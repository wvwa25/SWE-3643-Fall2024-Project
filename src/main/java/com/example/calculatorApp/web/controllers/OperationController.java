package com.example.calculatorApp.web.controllers;

import com.example.calculatorApp.logic.Calculator;
import com.example.calculatorApp.logic.Result;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/performOperation")
public class OperationController {

    @PostMapping
    public ResponseEntity<Map<String, Object>> performOperation(@RequestBody OperationRequest request) {
        String input = request.getValues();
        String operationType = request.getOperationType();
        Result calculation = new Result();
        Map<String, Object> response = new HashMap<>();

        switch (operationType) {
            case "sampleStdDev" -> calculation = computeSampleStd(input);
            case "populationStdDev" -> calculation = computePopulationStd(input);
            case "mean" -> calculation = computeMean(input);
            case "zScore" -> calculation = computeZScore(input);
            case "linearRegression" -> calculation = computeLinearReg(input);
            case "predictY" -> calculation = predictYValue(input);
        }

        // Send back both the result and a success flag
        if (calculation.getIsSuccess()) {
            response.put("success", true);
            response.put("result", calculation.getResult());
            response.put("operation", calculation.getOperation()); // Send operation type to update description
        } else {
            response.put("success", false);
            response.put("error", calculation.getError());
        }

        return ResponseEntity.ok(response);
    }

    private List<Double> parseDoubleList(String[] inputLines) {
        // Parse String array as list of Doubles
        List<Double> result = new ArrayList<>();
        for (int i = 0; i < inputLines.length; i++) {
            inputLines[i] = inputLines[i].trim();

            try {
                result.add(Double.parseDouble(inputLines[i]));
            } catch (NumberFormatException ignored) {}
        }
        return result;
    }

    private List<Double[]> parseDoubleArrayList(String[] inputLines) {
        // Parse String array as a list of Double arrays
        List<Double[]> result = new ArrayList<Double[]>();
        for (int i = 0; i < inputLines.length; i++) {

            String[] splitLine = inputLines[i].split(",");
            for (int j = 0; i < splitLine.length; i++) {
                splitLine[j] = splitLine[j].trim();
            }

            Double[] doubles = new Double[splitLine.length];
            try {
                for (int j = 0; j < splitLine.length; j++) {
                    doubles[j] = Double.parseDouble(splitLine[j]);
                }
                result.add(doubles);
            } catch (NumberFormatException ignored) {}
        }
        return result;
    }

    private Result computeSampleStd(String input) {
        String[] inputLines = input.split("\\n");
        // Parse String array as list of Doubles
        List<Double> data = parseDoubleList(inputLines);
        // Calculate and return result
        return Calculator.computeSampleStD(data);
    }

    private Result computePopulationStd(String input) {
        String[] inputLines = input.split("\\n");
        // Parse String array as list of Doubles
        List<Double> data = parseDoubleList(inputLines);
        // Calculate and return result
        return Calculator.computePopulationStD(data);
    }

    private Result computeMean(String input) {
        String[] inputLines = input.split("\\n");
        // Parse String array as list of Doubles
        List<Double> data = parseDoubleList(inputLines);
        // Calculate and return result
        return Calculator.computeMean(data);
    }

    private Result computeZScore(String input) {
        String[] inputLines = input.split(",");
        // Parse String array as list of Doubles
        List<Double> data = parseDoubleList(inputLines);
        // Calculate and return result
        return Calculator.computeZScore(data);
    }

    private Result computeLinearReg(String input) {
        String[] inputLines = input.split("\\n");
        // Parse String array as list of Double arrays
        List<Double[]> data = parseDoubleArrayList(inputLines);
        // Calculate and return result
        return Calculator.computeLinearReg(data);
    }

    private Result predictYValue(String input) {
        String[] inputLines = input.split(",");
        // Parse String array as list of Doubles
        List<Double> data = parseDoubleList(inputLines);
        // Calculate and return result
        return Calculator.predictYValue(data);
    }
}
