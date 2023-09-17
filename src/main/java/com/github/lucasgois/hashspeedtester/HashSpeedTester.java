package com.github.lucasgois.hashspeedtester;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * A class responsible for evaluating the performance of different hash algorithms on files.
 */
public class HashSpeedTester {

    private static final int TEST_REPEATS = 50;
    private static final List<String> AVAILABLE_HASH_ALGORITHMS = getAvailableHashAlgorithms();

    /**
     * Main method to start the hash speed tester.
     *
     * @param args Command-line arguments containing file paths for evaluation.
     */
    public static void main(String[] args) throws Exception {

        if (args.length < 1) {
            System.err.println("Error: File path argument is missing.");
            return;
        }

        // Warm-up phase to preload all necessary classes into memory
        System.out.println("Warm-up phase");
        executeTests(1, args);

        // Main testing phase
        System.out.println("Testing phase");
        executeTests(TEST_REPEATS, args);
    }

    /**
     * Executes the hash tests for the provided files and algorithms.
     *
     * @param testRepeats The number of times each test should be repeated.
     * @param filePaths   Paths of the files for testing.
     */
    private static void executeTests(int testRepeats, String[] filePaths) throws IOException, NoSuchAlgorithmException {

        for (String filePath : filePaths) {
            List<HashResult> results = new ArrayList<>();
            Path path = Path.of(filePath);
            byte[] fileContent = Files.readAllBytes(path);

            for (String algorithmName : AVAILABLE_HASH_ALGORITHMS) {
                HashResult hashResult = new HashResult();

                hashResult.setAlgorithmName(algorithmName);
                hashResult.setFileExtension(getFileExtension(filePath));
                hashResult.setFileSize(getFileSize(path));

                for (int i = 0; i < testRepeats; i++) {
                    hashResult.getTimings().add(
                            computeSingleHashDuration(fileContent, algorithmName)
                    );
                }

                results.add(hashResult);
            }

            displayHashResults(results);
        }
    }

    /**
     * Displays the hash results in a structured tabular format.
     *
     * @param results List of hash results to display.
     */
    private static void displayHashResults(List<HashResult> results) {
        System.out.println("\n=========================================================");
        System.out.printf(
                "%-15s %-8s %10s %12s %10s %10s %10s %10s %10s %n",
                "Algorithm",
                "Ext.",
                "Size (KB)",
                "Count",
                "Avg Time",
                "Min Time",
                "Max Time",
                "Median",
                "Std Dev"
        );

        results.sort(Comparator.comparing(HashResult::getAverageTime));

        for (HashResult result : results) {
            System.out.printf(
                    "%-15s %-8s %10d %12d %10.2f %10d %10d %10.2f %10.2f %n",
                    result.getAlgorithmName(),
                    result.getFileExtension(),
                    result.getFileSize() / 1024,  // Convert fileSize from bytes to KB
                    result.getTimings().size(),
                    result.getAverageTime(),
                    result.getMinTime(),
                    result.getMaxTime(),
                    result.getMedianTime(),
                    result.getStandardDeviation()
            );
        }

        System.out.println("=========================================================\n");
    }

    /**
     * Computes the duration for a single hash operation.
     *
     * @param content   Content to be hashed.
     * @param algorithm Hash algorithm to be used.
     * @return Duration of the hash operation in milliseconds.
     */
    private static long computeSingleHashDuration(byte[] content, String algorithm) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(algorithm);

        long startTime = System.nanoTime();
        md.update(content);
        md.digest();
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1_000_000;  // Convert nanoseconds to milliseconds
    }

    /**
     * Retrieves the file extension from the provided file path.
     *
     * @param filePath Path of the file.
     * @return File extension as a string.
     */
    private static String getFileExtension(String filePath) {
        int lastIndex = filePath.lastIndexOf(".");
        return lastIndex != -1 ? filePath.substring(lastIndex + 1) : "";
    }

    /**
     * Retrieves the file size in bytes.
     *
     * @param path Path of the file.
     * @return Size of the file in bytes.
     */
    private static long getFileSize(Path path) throws IOException {
        return Files.size(path);
    }

    /**
     * Retrieves the list of available hash algorithms.
     *
     * @return List of hash algorithm names.
     */
    private static List<String> getAvailableHashAlgorithms() {
        List<String> algorithms = new ArrayList<>();
        Provider[] providers = Security.getProviders();
        for (Provider provider : providers) {
            provider.getServices().stream()
                    .filter(service -> "MessageDigest".equals(service.getType()))
                    .forEach(service -> algorithms.add(service.getAlgorithm()));
        }
        return algorithms;
    }
}