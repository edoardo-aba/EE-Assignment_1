import java.util.*;

// ! before running the analisys make a Warm up of the machine 5/10 iterations
public class Main {
    public static void main(String[] args) {
        // Define the possible parameters
        Sorter[] sorters = {
//                new BubbleSortUntilNoChange<>(),
//                new BubbleSortWhileNeeded<>(),
                new QuickSortGPT<>()
//                new SelectionSortGPT<>()
        };

        String[] dataDistributions = {"Random", "Pre-sorted", "Inverse-sorted"};
        String[] dataTypes = {"Integer", "Double", "String"};
        String[] inputSizes = {"Short", "Long"};
        int[] arraySizes = {100, 10000, 100000};

        // Map to store individual execution times for each sorter
        Map<Sorter, List<Long>> sorterTimes = new HashMap<>();

        // Loop through each combination of independent variables
        for (Sorter sorter : sorters) {
            sorterTimes.put(sorter, new ArrayList<>());  // Initialize time tracking for each sorter
            System.out.println();
            for (String distribution : dataDistributions) {
                for (String dataType : dataTypes) {
                    for (int arraySize : arraySizes) {
                        for (String inputSize : inputSizes) {
                            // Generate the test array based on parameters
                            Comparable[] array = generateTestArray(arraySize, dataType, distribution, inputSize);

                            // Clone the array for use with each sorter
                            Comparable[] arrayCopy = Arrays.copyOf(array, array.length);

                            // Track time
                            long startTime = System.nanoTime();

                            // Sort the array
                            sorter.sort(arrayCopy);

                            long endTime = System.nanoTime();
                            long executionTime = endTime - startTime;

                            // Store the execution time for each sorter
                            sorterTimes.get(sorter).add(executionTime);

                            // Print or log results
                            System.out.printf("Sorter: %s, Distribution: %s, DataType: %s, ArraySize: %d, InputSize: %s, Time: %.3f ms\n",
                                    sorter.getClass().getSimpleName(), distribution, dataType, arraySize, inputSize, executionTime / 1_000_000.0);
                        }
                    }
                }
            }
        }

        // List to store the average time and standard deviation for each sorter
        List<SorterStatistics> sorterStatisticsList = new ArrayList<>();

        // Calculate the average time and standard deviation for each sorter
        for (Sorter sorter : sorters) {
            List<Long> times = sorterTimes.get(sorter);
            double averageTime = calculateMean(times) / 1_000_000.0;  // Convert to milliseconds
            double stdDevTime = calculateStandardDeviation(times, averageTime) / 1_000_000.0;  // Convert to milliseconds

            sorterStatisticsList.add(new SorterStatistics(sorter.getClass().getSimpleName(), averageTime, stdDevTime));
        }

        // Sort the sorters based on their average time
        sorterStatisticsList.sort(Comparator.comparingDouble(SorterStatistics::getAverageTime));

        // Print the sorted results
        System.out.println("\nAverage execution times (sorted by mean):");
        for (SorterStatistics sorterStatistics : sorterStatisticsList) {
            System.out.printf("Sorter: %s, Average Time: %.3f ms, Std Dev: %.3f ms\n",
                    sorterStatistics.getSorterName(), sorterStatistics.getAverageTime(), sorterStatistics.getStandardDeviation());
        }
    }

    // Generate a test array based on the parameters
    private static Comparable[] generateTestArray(int size, String dataType, String distribution, String inputSize) {
        Random random = new Random();
        Comparable[] array = new Comparable[size];

        // Generate based on dataType and distribution
        if (dataType.equals("Integer")) {
            for (int i = 0; i < size; i++) {
                array[i] = random.nextInt(1000); // Generating random integers
            }
        } else if (dataType.equals("Double")) {
            for (int i = 0; i < size; i++) {
                array[i] = random.nextDouble();
            }
        } else if (dataType.equals("String")) {
            for (int i = 0; i < size; i++) {
                if (inputSize.equals("Short")) {
                    array[i] = generateRandomString(5); // Short string
                } else {
                    array[i] = generateRandomString(50); // Long string
                }
            }
        }

        // Adjust based on distribution
        if (distribution.equals("Pre-sorted")) {
            Arrays.sort(array);
        } else if (distribution.equals("Inverse-sorted")) {
            Arrays.sort(array, (a, b) -> ((Comparable) b).compareTo(a));
        }

        return array;
    }

    // Utility to generate a random string of given length
    private static String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }
        return sb.toString();
    }

    // Method to calculate mean of a list of times
    private static double calculateMean(List<Long> times) {
        long sum = 0;
        for (Long time : times) {
            sum += time;
        }
        return (double) sum / times.size();
    }

    // Method to calculate standard deviation
    private static double calculateStandardDeviation(List<Long> times, double mean) {
        double sumSquaredDifferences = 0.0;
        for (Long time : times) {
            sumSquaredDifferences += Math.pow(time - mean * 1_000_000.0, 2);  // Convert mean to nanoseconds for accurate calculation
        }
        return Math.sqrt(sumSquaredDifferences / times.size());
    }
}

// Helper class to store sorter names, average times, and standard deviation
class SorterStatistics {
    private final String sorterName;
    private final double averageTime;
    private final double standardDeviation;

    public SorterStatistics(String sorterName, double averageTime, double standardDeviation) {
        this.sorterName = sorterName;
        this.averageTime = averageTime;
        this.standardDeviation = standardDeviation;
    }

    public String getSorterName() {
        return sorterName;
    }

    public double getAverageTime() {
        return averageTime;
    }

    public double getStandardDeviation() {
        return standardDeviation;
    }
}
