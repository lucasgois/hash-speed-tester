package com.github.lucasgois.hashspeedtester;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents the result of a hash operation on a file using a specific algorithm.
 */
public class HashResult {

    private String algorithmName;
    private String fileExtension;
    private long fileSize;
    private List<Long> timings = new ArrayList<>();

    public String getAlgorithmName() {
        return algorithmName;
    }

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public List<Long> getTimings() {
        return timings;
    }

    public void setTimings(List<Long> timings) {
        this.timings = timings;
    }

    /**
     * Calculates the average time of the hash operations.
     *
     * @return The average time.
     */
    public double getAverageTime() {
        return timings.stream().mapToDouble(val -> val).average().orElse(0.0);
    }

    /**
     * Retrieves the minimum time of the hash operations.
     *
     * @return The minimum time.
     */
    public long getMinTime() {
        return timings.stream().mapToLong(val -> val).min().orElse(0L);
    }

    /**
     * Retrieves the maximum time of the hash operations.
     *
     * @return The maximum time.
     */
    public long getMaxTime() {
        return timings.stream().mapToLong(val -> val).max().orElse(0L);
    }

    /**
     * Calculates the median time of the hash operations.
     * If the number of timings is even, it calculates the average of the two middle values.
     * Otherwise, it returns the middle value.
     *
     * @return The median time.
     */
    public double getMedianTime() {
        List<Long> sortedTimings = new ArrayList<>(timings);
        Collections.sort(sortedTimings);
        int middle = sortedTimings.size() / 2;
        if (sortedTimings.size() % 2 == 0) {
            return (sortedTimings.get(middle - 1) + sortedTimings.get(middle)) / 2.0;
        } else {
            return sortedTimings.get(middle);
        }
    }

    /**
     * Calculates the standard deviation of the hash operations based on the variance.
     *
     * @return The standard deviation.
     */
    public double getStandardDeviation() {
        double average = getAverageTime();
        double variance = timings.stream().mapToDouble(val -> Math.pow(val - average, 2)).average().orElse(0.0);
        return Math.sqrt(variance);
    }
}
