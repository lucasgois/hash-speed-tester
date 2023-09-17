# Hash Speed Tester

## Description:
Hash Speed Tester is a tool designed to measure the performance of various hashing algorithms. It evaluates a range of algorithms like SHA-1, MD5, SHA3, among others, in terms of average time, minimum, maximum, median, and standard deviation of hashing time. This tool is especially useful for gauging the efficiency of different algorithms relative to file size and type.

## Usage:
1. **Execution:** Run the program. When executing, provide the paths to the files you wish to test as arguments.

    ```bash
    java -jar hash-speed-tester-1.0-SNAPSHOT.jar /path/to/file1 /path/to/file2 ...
    ```

2. **Analysis:** After execution, the program will display the results in a formatted table, showcasing the performance of each hashing algorithm for each file.

## Conclusions

**Efficiency of Algorithms for Small Files:**
For smaller file sizes, most of the hashing algorithms return extremely rapid processing times. This indicates their high efficiency when dealing with smaller files.

**SHA3 Shows Relative Slowness:**
The SHA3 algorithms, namely SHA3-256, SHA3-224, SHA3-384, and SHA3-512, tend to lag behind their counterparts like SHA-1, MD5, and SHA-512/256, especially as file sizes grow.

**MD2 Emerges as the Slowest:**
Across all the tests, the MD2 algorithm consistently recorded the longest processing times, rendering it the least efficient among the algorithms tested.

**Larger Files Still Processed Efficiently:**
Even when dealing with larger files, most algorithms still exhibit swift processing times, except MD2 and certain SHA3 variants.

**File Extension Doesn't Impact Performance:**
The performance metrics don't display significant variations based on file extensions, such as pdf, exe, png, jar, or jpg. The predominant determinant of processing time is the file size.

**No Additional Processing Time for Tinier Files:**
The algorithms can process smaller files almost instantaneously, showcasing their efficiency without incurring extra time or resource costs.

### Data Collection

The following data have been gathered from 50 executions for each case, with measurements recorded in milliseconds. The tests were conducted on a machine equipped with an AMD Ryzen 7 5800X3D 8-Core Processor and 16.0 GB of RAM running at 2667 MHz.

#### Results:

## PDF 594KB

| Algorithm    | Avg Time | Min Time | Max Time | Median | Std Dev |
|--------------|----------|----------|----------|--------|---------|
| SHA-1        | 0.00     | 0        | 0        | 0.00   | 0.00    |
| MD5          | 0.00     | 0        | 0        | 0.00   | 0.00    |
| SHA-512/256  | 0.00     | 0        | 0        | 0.00   | 0.00    |
| SHA-256      | 0.00     | 0        | 0        | 0.00   | 0.00    |
| SHA-384      | 0.00     | 0        | 0        | 0.00   | 0.00    |
| SHA-512/224  | 0.00     | 0        | 0        | 0.00   | 0.00    |
| SHA-512      | 0.00     | 0        | 0        | 0.00   | 0.00    |
| SHA-224      | 0.00     | 0        | 0        | 0.00   | 0.00    |
| SHA3-256     | 2.00     | 2        | 2        | 2.00   | 0.00    |
| SHA3-224     | 2.00     | 2        | 2        | 2.00   | 0.00    |
| SHA3-384     | 2.02     | 2        | 3        | 2.00   | 0.14    |
| SHA3-512     | 4.00     | 4        | 4        | 4.00   | 0.00    |
| MD2          | 44.24    | 44       | 45       | 44.00  | 0.43    |

## PDF 218KB

| Algorithm    | Avg Time | Min Time | Max Time | Median | Std Dev |
|--------------|----------|----------|----------|--------|---------|
| SHA-1        | 0.00     | 0        | 0        | 0.00   | 0.00    |
| MD5          | 0.00     | 0        | 0        | 0.00   | 0.00    |
| SHA-512/256  | 0.00     | 0        | 0        | 0.00   | 0.00    |
| SHA-256      | 0.00     | 0        | 0        | 0.00   | 0.00    |
| SHA-384      | 0.00     | 0        | 0        | 0.00   | 0.00    |
| SHA-512/224  | 0.00     | 0        | 0        | 0.00   | 0.00    |
| SHA-512      | 0.00     | 0        | 0        | 0.00   | 0.00    |
| SHA3-256     | 0.00     | 0        | 0        | 0.00   | 0.00    |
| SHA-224      | 0.00     | 0        | 0        | 0.00   | 0.00    |
| SHA3-224     | 0.00     | 0        | 0        | 0.00   | 0.00    |
| SHA3-512     | 1.00     | 1        | 1        | 1.00   | 0.00    |
| SHA3-384     | 1.00     | 1        | 1        | 1.00   | 0.00    |
| MD2          | 16.00    | 16       | 16       | 16.00  | 0.00    |

## EXE 9957KB

| Algorithm    | Avg Time | Min Time | Max Time | Median | Std Dev |
|--------------|----------|----------|----------|--------|---------|
| SHA-1        | 4.00     | 4        | 4        | 4.00   | 0.00    |
| SHA-256      | 5.00     | 5        | 5        | 5.00   | 0.00    |
| SHA-224      | 5.00     | 5        | 5        | 5.00   | 0.00    |
| MD5          | 10.98    | 10       | 11       | 11.00  | 0.14    |
| SHA-512/256  | 11.00    | 11       | 11       | 11.00  | 0.00    |
| SHA-512/224  | 11.00    | 11       | 11       | 11.00  | 0.00    |
| SHA-512      | 11.00    | 11       | 11       | 11.00  | 0.00    |
| SHA-384      | 11.02    | 11       | 12       | 11.00  | 0.14    |
| SHA3-224     | 35.44    | 35       | 37       | 35.00  | 0.54    |
| SHA3-256     | 37.26    | 37       | 38       | 37.00  | 0.44    |
| SHA3-384     | 48.44    | 48       | 50       | 48.00  | 0.54    |
| SHA3-512     | 69.10    | 68       | 72       | 69.00  | 0.61    |
| MD2          | 749.90   | 745      | 763      | 750.00 | 2.95    |

## EXE 23124KB

| Algorithm   | Avg Time | Min Time | Max Time | Median  | Std Dev |
|-------------|----------|----------|----------|---------|---------|
| SHA-1       | 10.72    | 10       | 11       | 11.00   | 0.45    |
| SHA-256     | 11.18    | 11       | 12       | 11.00   | 0.38    |
| SHA-224     | 11.26    | 11       | 12       | 11.00   | 0.44    |
| MD5         | 25.04    | 25       | 26       | 25.00   | 0.20    |
| SHA-512/256 | 26.00    | 26       | 26       | 26.00   | 0.00    |
| SHA-384     | 26.00    | 26       | 26       | 26.00   | 0.00    |
| SHA-512/224 | 26.00    | 26       | 26       | 26.00   | 0.00    |
| SHA-512     | 26.00    | 26       | 26       | 26.00   | 0.00    |
| SHA3-224    | 83.14    | 83       | 84       | 83.00   | 0.35    |
| SHA3-256    | 87.98    | 87       | 89       | 88.00   | 0.37    |
| SHA3-384    | 113.34   | 112      | 115      | 113.00  | 0.62    |
| SHA3-512    | 161.44   | 161      | 163      | 161.00  | 0.54    |
| MD2         | 1746.86  | 1742     | 1769     | 1746.00 | 5.12    |

## PNG 3KB

| Algorithm    | Avg Time | Min Time | Max Time | Median | Std Dev |
|--------------|----------|----------|----------|--------|---------|
| SHA-1        | 0.00     | 0        | 0        | 0.00   | 0.00    |
| MD2          | 0.00     | 0        | 0        | 0.00   | 0.00    |
| MD5          | 0.00     | 0        | 0        | 0.00   | 0.00    |
| SHA-512/256  | 0.00     | 0        | 0        | 0.00   | 0.00    |
| SHA3-512     | 0.00     | 0        | 0        | 0.00   | 0.00    |
| SHA-256      | 0.00     | 0        | 0        | 0.00   | 0.00    |
| SHA-384      | 0.00     | 0        | 0        | 0.00   | 0.00    |
| SHA-512/224  | 0.00     | 0        | 0        | 0.00   | 0.00    |
| SHA-512      | 0.00     | 0        | 0        | 0.00   | 0.00    |
| SHA3-256     | 0.00     | 0        | 0        | 0.00   | 0.00    |
| SHA-224      | 0.00     | 0        | 0        | 0.00   | 0.00    |
| SHA3-384     | 0.00     | 0        | 0        | 0.00   | 0.00    |
| SHA3-224     | 0.00     | 0        | 0        | 0.00   | 0.00    |


## JAR 13KB

| Algorithm    | Avg Time | Min Time | Max Time | Median | Std Dev |
|--------------|----------|----------|----------|--------|---------|
| SHA-1        | 0.00     | 0        | 0        | 0.00   | 0.00    |
| MD5          | 0.00     | 0        | 0        | 0.00   | 0.00    |
| SHA-512/256  | 0.00     | 0        | 0        | 0.00   | 0.00    |
| SHA3-512     | 0.00     | 0        | 0        | 0.00   | 0.00    |
| SHA-256      | 0.00     | 0        | 0        | 0.00   | 0.00    |
| SHA-384      | 0.00     | 0        | 0        | 0.00   | 0.00    |
| SHA-512/224  | 0.00     | 0        | 0        | 0.00   | 0.00    |
| SHA-512      | 0.00     | 0        | 0        | 0.00   | 0.00    |
| SHA3-256     | 0.00     | 0        | 0        | 0.00   | 0.00    |
| SHA-224      | 0.00     | 0        | 0        | 0.00   | 0.00    |
| SHA3-384     | 0.00     | 0        | 0        | 0.00   | 0.00    |
| SHA3-224     | 0.00     | 0        | 0        | 0.00   | 0.00    |
| MD2          | 0.06     | 0        | 1        | 0.00   | 0.24    |

## JPG 496KB

| Algorithm    | Avg Time | Min Time | Max Time | Median | Std Dev |
|--------------|----------|----------|----------|--------|---------|
| SHA-1        | 0.00     | 0        | 0        | 0.00   | 0.00    |
| MD5          | 0.00     | 0        | 0        | 0.00   | 0.00    |
| SHA-512/256  | 0.00     | 0        | 0        | 0.00   | 0.00    |
| SHA-256      | 0.00     | 0        | 0        | 0.00   | 0.00    |
| SHA-384      | 0.00     | 0        | 0        | 0.00   | 0.00    |
| SHA-512/224  | 0.00     | 0        | 0        | 0.00   | 0.00    |
| SHA-512      | 0.00     | 0        | 0        | 0.00   | 0.00    |
| SHA-224      | 0.00     | 0        | 0        | 0.00   | 0.00    |
| SHA3-256     | 1.00     | 1        | 1        | 1.00   | 0.00    |
| SHA3-224     | 1.00     | 1        | 1        | 1.00   | 0.00    |
| SHA3-384     | 2.00     | 2        | 2        | 2.00   | 0.00    |
| SHA3-512     | 3.00     | 3        | 3        | 3.00   | 0.00    |
| MD2          | 37.04    | 37       | 38       | 37.00  | 0.20    |