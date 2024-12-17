package com.example.calculatorApp.logic;

import java.util.List;


public class Calculator {
    // preq-LOGIC-3
    public static Result computeSampleStD(List<Double> doubleList) {

        // Instantiate calculation result object and set operation description
        Result result = new Result();
        result.setOperation("Sample Standard Deviation");

        try {
            // Check if the list is null or empty
            if (doubleList == null || doubleList.isEmpty()) {
                throw new IllegalArgumentException("List of numbers cannot be empty.");
            }

            Result mean = computeMean(doubleList);
            double varianceSum = 0.0;

            for (double num : doubleList) {
                varianceSum += Math.pow(num - Double.parseDouble(mean.getResult()), 2);
            }

            result.setResult(String.format("%.5f", (Math.sqrt(varianceSum / (doubleList.size() - 1)))));
            result.setIsSuccess(true);

        } catch (Exception e) {
            result.setIsSuccess(false);
            result.setError(e.getMessage());
        }

        return result;
    }

    // preq-LOGIC-4
    public static Result computePopulationStD(List<Double> doubleList) {

        // Instantiate calculation result object and set operation description
        Result result = new Result();
        result.setOperation("Population Standard Deviation");

        try {
            // Check if the list is empty
            if (doubleList == null || doubleList.isEmpty()) {
                throw new IllegalArgumentException("List of numbers cannot be empty.");
            } else if (doubleList.size() < 2) {
                throw new IllegalArgumentException("List of numbers must be at least 2.");
            }

            Result mean = computeMean(doubleList);
            double varianceSum = 0.0;

            for (double num : doubleList) {
                varianceSum += Math.pow(num - Double.parseDouble(mean.getResult()), 2);
            }

            result.setResult(String.format("%.5f", (Math.sqrt(varianceSum / doubleList.size()))));
            result.setIsSuccess(true);

        } catch (Exception e) {
            result.setIsSuccess(false);
            result.setError(e.getMessage());
        }

        return result;
    }

    // preq-LOGIC-5
    public static Result computeMean(List<Double> doubleList) {

        // Instantiate calculation result object and set operation description
        Result result = new Result();
        result.setOperation("Mean");

        try {
            // Check if the list is empty
            if (doubleList == null || doubleList.isEmpty()) {
                throw new IllegalArgumentException("List of numbers cannot be empty.");
            }

            double sum = 0.0;

            for (double num : doubleList) {
                sum += num;
            }

            result.setResult(String.format("%.7f", (sum / doubleList.size())));
            result.setIsSuccess(true);

        } catch (Exception e) {
            result.setIsSuccess(false);
            result.setError(e.getMessage());
        }

        return result;
    }

    // preq-LOGIC-6
    public static Result computeZScore(List<Double> doubleList) {

        // Instantiate calculation result object and set operation description
        Result result = new Result();
        result.setOperation("Z-Score");

        try {

            if (doubleList.size() != 3) {
                throw new IllegalArgumentException("Input must contain exactly three numeric values separated by commas.");
            }

            double value = doubleList.get(0);
            double mean = doubleList.get(1);
            double stdDev = doubleList.get(2);

            if (stdDev == 0) {
                throw new IllegalArgumentException("Standard deviation cannot be zero.");
            }

            result.setResult(String.format("%.5f", ((value - mean) / stdDev)));
            result.setIsSuccess(true);

        } catch (Exception e) {
            result.setIsSuccess(false);
            result.setError(e.getMessage());
        }

        return result;
    }

    // preq-LOGIC-7
    public static Result computeLinearReg(List<Double[]> pairs) {

        // Instantiate calculation result object and set operation description
        Result result = new Result();
        result.setOperation("Single Linear Regression Formula");

        try {
            // Check if the list is empty
            if (pairs == null || pairs.isEmpty()) {
                throw new IllegalArgumentException("List of numbers cannot be empty.");
            }

            // Check if each line has a pair of values in it
            for (Double[] pair : pairs) {
                if (pair == null || pair.length != 2) {
                    throw new IllegalArgumentException("Each line must contain two values separated by commas.");
                }
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

            result.setResult(String.format("y = %.5fx + %.5f", slope, intercept));
            result.setIsSuccess(true);

        } catch (Exception e) {
            result.setIsSuccess(false);
            result.setError(e.getMessage());
        }

        return result;
    }

    // preq-LOGIC-8
    public static Result predictYValue(List<Double> doubleList) {

        // Instantiate calculation result object and set operation description
        Result result = new Result();
        result.setOperation("Single Linear Regression Prediction");

        try {
            if (doubleList.size() != 3) {
                throw new IllegalArgumentException("Input must contain exactly three numeric values separated by commas.");
            }

            double x = doubleList.get(0);
            double m = doubleList.get(1);
            double b = doubleList.get(2);

            result.setResult(String.format("y = %.5f", (m * x + b)));
            result.setIsSuccess(true);

        } catch (Exception e) {
            result.setIsSuccess(false);
            result.setError(e.getMessage());
        }

        return result;
    }

}