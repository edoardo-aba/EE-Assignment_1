import matplotlib.pyplot as plt
import pandas as pd

data_full = {
    "BubbleSortUntilNoChange_250": [0.137, 0.123, 2.029, 1.835, 1.376, 0.442, 0.009, 0.002, 0.001, 0.001, 0.003, 0.001,
                                    0.256, 0.245, 0.232, 0.208, 0.306, 0.261],
    "BubbleSortWhileNeeded_250": [0.094, 0.089, 0.984, 0.926, 0.657, 0.299, 0.004, 0.001, 0.001, 0.001, 0.002, 0.001,
                                  0.126, 0.130, 0.117, 0.112, 0.150, 0.147],
    "QuickSortGPT_250": [0.012, 0.011, 0.096, 0.062, 0.094, 0.063, 0.119, 0.115, 0.115, 0.112, 0.158, 0.149, 0.092,
                         0.094, 0.102, 0.115, 0.128, 0.128],
    "SelectionSortGPT_250": [0.037, 0.035, 0.579, 0.540, 0.443, 0.187, 0.098, 0.085, 0.085, 0.084, 0.117, 0.118, 0.101,
                             0.096, 0.092, 0.087, 0.130, 0.120],

    "BubbleSortUntilNoChange_2500": [14.544, 15.141, 9.802, 10.867, 39.833, 24.616, 0.014, 0.016, 0.008, 0.008, 0.022,
                                     0.012, 26.734, 26.087, 20.060, 20.019, 32.202, 32.403],
    "BubbleSortWhileNeeded_2500": [11.595, 11.972, 8.389, 7.665, 27.155, 17.111, 0.014, 0.014, 0.008, 0.008, 0.021,
                                   0.011, 11.872, 12.394, 11.773, 11.985, 14.917, 16.032],
    "QuickSortGPT_2500": [0.165, 0.153, 0.841, 0.899, 0.912, 0.849, 12.433, 13.197, 11.401, 11.315, 15.200, 17.854,
                          5.093, 5.341, 9.693, 9.464, 14.855, 15.439],
    "SelectionSortGPT_2500": [2.444, 2.388, 6.226, 3.473, 13.064, 11.465, 7.991, 8.136, 7.933, 8.121, 11.100, 13.721,
                              10.750, 11.192, 8.109, 8.120, 14.507, 11.393],

    "BubbleSortUntilNoChange_25000": [1226.174, 1229.580, 1183.740, 1185.061, 4702.638, 3446.164, 0.104, 0.089, 0.079,
                                      0.078, 0.205, 0.137, 2149.778, 2207.359, 2047.792, 2053.578, 3821.879, 3605.760],
    "BubbleSortWhileNeeded_25000": [778.282, 801.426, 768.623, 766.699, 2750.705, 2187.486, 0.089, 0.088, 0.080, 0.073,
                                    0.206, 0.118, 1188.801, 1169.284, 1198.249, 1195.286, 2080.177, 2203.812],
    "QuickSortGPT_25000": [2.035, 1.930, 10.148, 7.307, 6.372, 3.627, 1214.511, 1208.838, 1210.187, 1201.119, 2263.132,
                           2137.484, 325.326, 312.570, 1046.756, 1030.485, 1887.375, 1765.173],
    "SelectionSortGPT_25000": [247.821, 246.751, 339.485, 346.365, 980.833, 1060.257, 825.047, 800.461, 808.602,
                               808.200, 1189.697, 1383.534, 903.548, 902.224, 867.398, 872.882, 1865.256, 1542.580]
}

data_250 = {key.split('_')[0]: values for key, values in data_full.items() if key.endswith("250")}
data_2500 = {key.split('_')[0]: values for key, values in data_full.items() if key.endswith("2500")}
data_25000 = {key.split('_')[0]: values for key, values in data_full.items() if key.endswith("25000")}


data_250 = {
    "BubbleUNT": data_250["BubbleSortUntilNoChange"],
    "BubbleWHL": data_250["BubbleSortWhileNeeded"],
    "QuickSort": data_250["QuickSortGPT"],
    "SelectSort": data_250["SelectionSortGPT"]
}

data_2500 = {
    "BubbleUNT": data_2500["BubbleSortUntilNoChange"],
    "BubbleWHL": data_2500["BubbleSortWhileNeeded"],
    "QuickSort": data_2500["QuickSortGPT"],
    "SelectSort": data_2500["SelectionSortGPT"]
}

data_25000 = {
    "BubbleUNT": data_25000["BubbleSortUntilNoChange"],
    "BubbleWHL": data_25000["BubbleSortWhileNeeded"],
    "QuickSort": data_25000["QuickSortGPT"],
    "SelectSort": data_25000["SelectionSortGPT"]
}


plt.figure(figsize=(6, 6))
pd.DataFrame(data_250).boxplot(color="blue")
plt.title("Execution Times for Array Size 250")
plt.ylabel("Execution Time (ms)")
plt.xlabel("Algorithm")
plt.show()


plt.figure(figsize=(6, 6))
pd.DataFrame(data_2500).boxplot(color="blue")
plt.title("Execution Times for Array Size 2500")
plt.ylabel("Execution Time (ms)")
plt.xlabel("Algorithm")
plt.show()


plt.figure(figsize=(6, 6))
pd.DataFrame(data_25000).boxplot(color="blue")
plt.title("Execution Times for Array Size 25000")
plt.ylabel("Execution Time (ms)")
plt.xlabel("Algorithm")
plt.show()
