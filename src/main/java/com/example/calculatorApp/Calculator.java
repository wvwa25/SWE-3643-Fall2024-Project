package com.example.calculatorApp;

import java.util.List;

public class Calculator {
    // preq-LOGIC-3
    public static double computeSampleStD(List<Double> doubleList) throws IllegalArgumentException {

        // Check if the list is empty
        if (doubleList == null || doubleList.isEmpty()) {
            throw new IllegalArgumentException("List of numbers cannot be empty.");
        }

        double mean = computeMean(doubleList);
        double varianceSum = 0.0;

        for (double num : doubleList) {
            varianceSum += Math.pow(num - mean, 2);
        }

        return Math.sqrt(varianceSum / (doubleList.size() - 1));
    }

    // preq-LOGIC-4
    public static double computePopulationStD(List<Double> doubleList) throws IllegalArgumentException {

        // Check if the list is empty
        if (doubleList == null || doubleList.isEmpty()) {
            throw new IllegalArgumentException("List of numbers cannot be empty.");
        } else if (doubleList.size() < 2) {
            throw new IllegalArgumentException("List of numbers must be at least 2.");
        }

        double mean = computeMean(doubleList);
        double varianceSum = 0.0;

        for (double num : doubleList) {
            varianceSum += Math.pow(num - mean, 2);
        }

        return Math.sqrt(varianceSum / doubleList.size());
    }

    // preq-LOGIC-5
    public static double computeMean(List<Double> doubleList) throws IllegalArgumentException {
        // Check if the list is empty
        if (doubleList == null || doubleList.isEmpty()) {
            throw new IllegalArgumentException("List of numbers cannot be empty.");
        }

        double sum = 0.0;

        for (double num : doubleList) {
            sum += num;
        }

        return sum / doubleList.size();
    }

    // preq-LOGIC-6
    public static double computeZScore(List<Double> doubleList) throws IllegalArgumentException {
        if (doubleList.size() != 3) {
            throw new IllegalArgumentException("Input must contain exactly three numeric values separated by commas.");
        }

        double value = doubleList.get(0);
        double mean = doubleList.get(1);
        double stdDev = doubleList.get(2);

        if (stdDev == 0) {
            throw new IllegalArgumentException("Standard deviation cannot be zero.");
        }

        return (value - mean) / stdDev;
    }

    // preq-LOGIC-7
    public static String computeLinearReg(List<Double[]> pairs) throws IllegalArgumentException {

        // Check if the list is empty
        if (pairs == null || pairs.isEmpty()) {
            throw new IllegalArgumentException("List of numbers cannot be empty.");
        }

        // Check if all pairs are (0, 0)
        boolean allZero = pairs.stream().allMatch(pair -> pair[0] == 0.0 && pair[1] == 0.0);
        if (allZero) {
            throw new IllegalArgumentException("Input list cannot contain only (0, 0) pairs.");
        }

        // Check if all x values are the same
        boolean allXSame = pairs.stream().map(pair -> pair[0]).distinct().count() == 1;
        if (allXSame) {
            throw new IllegalArgumentException("All x values are the same. Cannot compute linear regression.");
        }

        double sumX = 0.0, sumY = 0.0, sumXY = 0.0, sumX2 = 0.0;
        int n = pairs.size();

        for (Double[] pair : pairs) {
            sumX += pair[0];
            sumY += pair[1];
            sumXY += pair[0] * pair[1];
            sumX2 += pair[0] * pair[0];
        }

        double slope = (n * sumXY - sumX * sumY) / (n * sumX2 - sumX * sumX);
        double intercept = (sumY - slope * sumX) / n;

        return String.format("y = %.3fx + %.3f", slope, intercept);
    }



    // preq-LOGIC-8
    public static double predictYValue(List<Double> doubleList) throws IllegalArgumentException {

        if (doubleList.size() != 3) {
            throw new IllegalArgumentException("Input must contain exactly three numeric values separated by commas.");
        }

        double x = doubleList.get(0);
        double m = doubleList.get(1);
        double b = doubleList.get(2);

        return m * x + b;
    }

}