public class Main {
    public static void main(String[] args) {
        // Example array to sort
        Integer[] array = {3, 5, 2, 1, 4};

        // Create an instance of QuickSortGPT
        QuickSortGPT<Integer> quickSorter = new QuickSortGPT<>();

        // Sort the array
        quickSorter.sort(array);

        // Print the sorted array
        System.out.println("Sorted array using QuickSort:");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println(); // Just to add a new line after the sorted output
    }
}
