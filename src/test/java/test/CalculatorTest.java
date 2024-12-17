package test;

import com.example.calculatorApp.logic.Calculator;
import com.example.calculatorApp.logic.Result;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest(classes = Calculator.class)
public class CalculatorTest {

    @Test
    public void computeSampleStD_DoubleList() {
        // preq-UNIT-TEST-2

        // Arrange
        List<Double> doubleList = Arrays.asList(9.0, 6.0, 8.0, 5.0, 7.0);
        double expected = 1.5811388300841;

        // Act
        Result result = Calculator.computeSampleStD(doubleList);

        // Assert
        Assertions.assertEquals(expected, Double.parseDouble(result.getResult()), 0.00001);

    }

    @Test
    void computeSampleStD_ListOfZeros() {
        // preq-UNIT-TEST-2

        // Arrange
        List<Double> samples = Arrays.asList(0.0, 0.0, 0.0);
        double expected = 0.0;

        // Act
        Result result = Calculator.computeSampleStD(samples);

        // Assert
        Assertions.assertEquals(expected, Double.parseDouble(result.getResult()), 0.00001);
    }

    @Test
    void computeSampleStD_EmptyList() {
        // preq-UNIT-TEST-2

        // Arrange
        List<Double> samples = List.of();
        String error = "List of numbers cannot be empty.";

        // Act
        Result result = Calculator.computeSampleStD(samples);

        // Assert
        Assertions.assertEquals(error, result.getError());
    }

    @Test
    void computeSampleStD_NullList() {
        // preq-UNIT-TEST-2

        // Arrange
        String error = "List of numbers cannot be empty.";

        // Act
        Result result = Calculator.computeSampleStD(null);

        // Assert
        Assertions.assertEquals(error, result.getError());
    }

    @Test
    public void computePopulationStD_DoubleList() {
        //preq-UNIT-TEST-3

        // Arrange
        List<Double> doubleList = Arrays.asList(9.0, 6.0, 8.0, 5.0, 7.0);
        double expected = 1.4142135623731;

        // Act
        Result result = Calculator.computePopulationStD(doubleList);

        // Assert
        Assertions.assertEquals(expected, Double.parseDouble(result.getResult()), 0.00001);

    }

    @Test
    void computePopulationStD_ListOfZeros() {
        //preq-UNIT-TEST-3

        // Arrange
        List<Double> samples = Arrays.asList(0.0, 0.0, 0.0);
        double expected = 0.0;

        // Act
        Result result = Calculator.computePopulationStD(samples);

        // Assert
        Assertions.assertEquals(expected, Double.parseDouble(result.getResult()), 0.00001);
    }

    @Test
    void computePopulationStD_EmptyList() {
        //preq-UNIT-TEST-3

        // Arrange
        List<Double> samples = List.of();
        String error = "List of numbers cannot be empty.";

        // Act
        Result result = Calculator.computePopulationStD(samples);

        // Assert
        Assertions.assertEquals(error, result.getError());
    }

    @Test
    void computePopulationStD_NullList() {
        // preq-UNIT-TEST-3

        // Arrange
        String error = "List of numbers cannot be empty.";

        // Act
        Result result = Calculator.computePopulationStD(null);

        // Assert
        Assertions.assertEquals(error, result.getError());
    }

    @Test
    void computePopulationStD_ListWithOneSample() {
        //preq-UNIT-TEST-3

        // Arrange
        List<Double> samples = List.of(5.0);
        String error = "List of numbers must be at least 2.";

        // Act
        Result result = Calculator.computePopulationStD(samples);

        // Assert
        Assertions.assertEquals(error, result.getError());
    }

    @Test
    public void computeMean_DoubleList() {
        //preq-UNIT-TEST-4

        // Arrange
        List<Double> doubleList = Arrays.asList(9.0, 6.0, 8.0, 5.0, 7.0);
        double expected = 7;

        // Act
        Result result = Calculator.computeMean(doubleList);

        // Assert
        Assertions.assertEquals(expected, Double.parseDouble(result.getResult()), 0.00001);

    }

    @Test
    void computeMean_EmptyList() {
        //preq-UNIT-TEST-4

        // Arrange
        List<Double> samples = List.of();
        String error = "List of numbers cannot be empty.";

        // Act
        Result result = Calculator.computeMean(samples);

        // Assert
        Assertions.assertEquals(error, result.getError());
    }

    @Test
    void computeMean_NullList() {
        //preq-UNIT-TEST-4

        // Arrange
        String error = "List of numbers cannot be empty.";

        // Act
        Result result = Calculator.computeMean(null);

        // Assert
        Assertions.assertEquals(error, result.getError());
    }

    @Test
    public void computeZScore_DoubleList() {
        // preq-UNIT-TEST-5

        // Arrange
        double value = 11.5;
        double mean = 7;
        double stdDev = 1.5811388300841898;
        List<Double> samples = Arrays.asList(value, mean, stdDev);
        double expected = 2.846049894151541;

        // Act
        Result result = Calculator.computeZScore(samples);

        // Assert
        Assertions.assertEquals(expected, Double.parseDouble(result.getResult()), 0.00001);

    }

    @Test
    void computeZScore_MissingParameters() {
        // preq-UNIT-TEST-5

        // Arrange
        double value = 11.5;
        double mean = 7;
        List<Double> samples = Arrays.asList(value, mean);
        String error = "Input must contain exactly three numeric values separated by commas.";

        // Act
        Result result = Calculator.computeZScore(samples);

        // Assert
        Assertions.assertEquals(error, result.getError());
    }

    @Test
    void computeZScore_MeanZero() {
        // preq-UNIT-TEST-5

        // Arrange
        double value = 10.0;
        double mean = 0.0;
        double stdDev = 2.0;
        List<Double> samples = Arrays.asList(value, mean, stdDev);
        double expected = 5.0;

        // Act
        Result result = Calculator.computeZScore(samples);

        // Assert
        Assertions.assertEquals(expected, Double.parseDouble(result.getResult()), 0.00001);
    }

    @Test
    void computeZScore_StdZero() {
        // preq-UNIT-TEST-5

        // Arrange
        double value = 10.0;
        double mean = 2.0;
        double stdDev = 0.0;
        List<Double> samples = Arrays.asList(value, mean, stdDev);
        String error = "Standard deviation cannot be zero.";

        // Act
        Result result = Calculator.computeZScore(samples);

        // Assert
        Assertions.assertEquals(error, result.getError());
    }

    @Test
    public void computeLinearReg_DoubleArrList() {
        // preq-UNIT-TEST-6

        // Arrange
        Double[] pair1 = {1.47, 52.21};
        Double[] pair2 = {1.5, 53.12};
        Double[] pair3 = {1.52,54.48};
        Double[] pair4 = {1.55,55.84};
        Double[] pair5 = {1.57,57.2};
        Double[] pair6 = {1.6,58.57};
        Double[] pair7 = {1.63,59.93};
        Double[] pair8 = {1.65,61.29};
        Double[] pair9 = {1.68,63.11};
        Double[] pair10 = {1.7,64.47};
        Double[] pair11 = {1.73,66.28};
        Double[] pair12 = {1.75,68.1};
        Double[] pair13 = {1.78,69.92};
        Double[] pair14 = {1.8,72.19};
        Double[] pair15 = {1.83,74.46};
        List<Double[]> pairs = Arrays.asList(pair1, pair2, pair3, pair4, pair5, pair6, pair7, pair8, pair9, pair10, pair11, pair12, pair13, pair14, pair15);
        String expected = "y = 61.27219x + -39.06196";

        // Act
        Result result = Calculator.computeLinearReg(pairs);

        // Assert
        Assertions.assertEquals(expected, result.getResult());

    }

    @Test
    void computeLinearReg_EmptyList() {
        // preq-UNIT-TEST-6

        // Arrange
        List<Double[]> pairs = List.of();
        String error = "List of numbers cannot be empty.";

        // Act
        Result result = Calculator.computeLinearReg(pairs);

        // Assert
        Assertions.assertEquals(error, result.getError());
    }

    @Test
    void computeLinearReg_NullList() {
        // preq-UNIT-TEST-6

        // Arrange
        String error = "List of numbers cannot be empty.";

        // Act
        Result result = Calculator.computeLinearReg(null);

        // Assert
        Assertions.assertEquals(error, result.getError());
    }

    @Test
    void computeLinearReg_MissingParameters() {
        // preq-UNIT-TEST-6

        // Arrange
        List<Double[]> pairs = Arrays.asList(
                new Double[]{1.0, 2.0},
                new Double[]{1.0}
        );
        String error = "Each line must contain two values separated by commas.";

        // Act
        Result result = Calculator.computeLinearReg(pairs);

        // Assert
        Assertions.assertEquals(error, result.getError());
    }

    @Test
    void computeLinearReg_AllXValuesSame() {
        // preq-UNIT-TEST-6

        // Arrange
        List<Double[]> pairs = Arrays.asList(
                new Double[]{1.0, 2.0},
                new Double[]{1.0, 4.0},
                new Double[]{1.0, 6.0}
        );
        String error = "All x values are the same. Cannot compute linear regression.";

        // Act
        Result result = Calculator.computeLinearReg(pairs);

        // Assert
        Assertions.assertEquals(error, result.getError());
    }

    @Test
    void computeLinearReg_AllYValuesSame() {
        // preq-UNIT-TEST-6

        // Arrange
        List<Double[]> pairs = Arrays.asList(
                new Double[]{1.0, 2.0},
                new Double[]{2.0, 2.0},
                new Double[]{3.0, 2.0}
        );
        String expected = "y = 0.00000x + 2.00000";

        // Act
        Result result = Calculator.computeLinearReg(pairs);

        // Assert
        Assertions.assertEquals(expected, result.getResult());
    }

    @Test
    void computeLinearReg_AllPairsZero() {
        // preq-UNIT-TEST-6

        // Arrange
        List<Double[]> pairs = Arrays.asList(
                new Double[]{0.0, 0.0},
                new Double[]{0.0, 0.0},
                new Double[]{0.0, 0.0}
        );
        String error = "Input list cannot contain only (0, 0) pairs.";

        // Act
        Result result = Calculator.computeLinearReg(pairs);

        // Assert
        Assertions.assertEquals(error, result.getError());
    }

    @Test
    public void predictYValue_DoubleList() {
        // preq-UNIT-TEST-7

        // Arrange
        double x = 1.535;
        double m = 61.272186542107434;
        double b = -39.061955918838656;
        List<Double> samples = Arrays.asList(x, m, b);
        String expected = String.format("y = %.5f", 54.990850423296244);

        // Act
        Result result = Calculator.predictYValue(samples);

        // Assert
        Assertions.assertEquals(expected, result.getResult());

    }

    @Test
    void predictYValue_MissingParameters() {
        // preq-UNIT-TEST-7

        // Arrange
        double x = 2.0;
        double m = 3.0;
        List<Double> samples = Arrays.asList(x, m);
        String error = "Input must contain exactly three numeric values separated by commas.";

        // Act
        Result result = Calculator.predictYValue(samples);

        // Act & Assert
        Assertions.assertEquals(error, result.getError());
    }

}
