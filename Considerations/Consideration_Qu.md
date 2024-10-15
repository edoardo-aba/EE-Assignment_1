## Dependent Variables
- Execution time
- RAM usage
- Number of comparisons and swaps

## Independent Variables
- Sorting algorithm
- Array type
  - Random array
  - Pre-sorted array
  - Inverse sorted array
  - Array with repeated values
- Array size
- How many times an experiment is repeated 

## Control Variables
- Hardware components:
  - CPU
  - RAM
  - OS
  - Storage
  - IDE and Java version

## Control Variables
- System workload: background processes or system loads not under direct control of the test
- Cache: algorithms that benefit better from the cache may show better performance than others

## Randomize
- Pivot selection in QuickSort
- Size and content of arrays

## Hypotheses
- BubbleSortUntilNoChange: simpler and works well on small arrays or fully sorted arrays, but it performs more comparisons
- BubbleSortWhileNeeded: reduces the number of comparisons in later passes when the array is already sorted or nearly sorted
- QuickSortGPT: depends on the pivot (chosen or randomized), in the given code the pivot is the last element, the worst case would be a pre-sorted array. But generally this algorithm is efficient for big arrays and random values
- SelectionSortGPT: independent of any kind of array but inefficient with large data 
