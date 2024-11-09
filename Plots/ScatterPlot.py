import matplotlib.pyplot as plt

array_sizes = [250, 2500, 25000]
bubble_unt = [0.137, 14.544, 1226.174]
bubble_while = [0.094, 11.595, 778.282]
quick_sort = [0.012, 0.165, 2.035]
selection = [0.037, 2.444, 247.821]

plt.figure(figsize=(10, 6))
plt.scatter(array_sizes, bubble_unt, label="BubbleSortUNT", color="blue")
plt.scatter(array_sizes, bubble_while, label="BubbleSortWHL", color="fuchsia")
plt.scatter(array_sizes, quick_sort, label="QuickSort", color="red")
plt.scatter(array_sizes, selection, label="SelectSort", color="green")

plt.title("Array Size vs Execution Time for Different Sorting Algorithms")
plt.xlabel("Array Size")
plt.ylabel("Execution Time (ms)")
plt.legend()

plt.show()

