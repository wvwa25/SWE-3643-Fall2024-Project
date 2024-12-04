import main.Calculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;

public class CalculatorTest {

    @Test
    public void sampleStD_doubleList_returnsStD() {
        // preq-UNIT-TEST-2

        // Arrange
        List<Double> doubleList = Arrays.asList(9.0, 6.0, 8.0, 5.0, 7.0);
        double expected = 1.5811388300841;

        // Act
        double result = Calculator.computeSampleStD(doubleList);

        // Assert
        Assertions.assertEquals(result, expected, 8);

    }

    @Test
    public void populationStD_doubleList_returnsStD() {
        //preq-UNIT-TEST-3

        // Arrange
        List<Double> doubleList = Arrays.asList(9.0, 6.0, 8.0, 5.0, 7.0);
        double expected = 1.4142135623731;

        // Act
        double result = Calculator.computePopulationStD(doubleList);

        // Assert
        Assertions.assertEquals(result, expected, 8);

    }

    @Test
    public void mean_doubleList_returnsMean() {
        //preq-UNIT-TEST-4

        // Arrange
        List<Double> doubleList = Arrays.asList(9.0, 6.0, 8.0, 5.0, 7.0);
        double expected = 7;

        // Act
        double result = Calculator.computeMean(doubleList);

        // Assert
        Assertions.assertEquals(result, expected, 8);

    }

    @Test
    public void zScore_doubleList_returnsZScore() {
        // preq-UNIT-TEST-5

        // Arrange
        double value = 11.5;
        double mean = 7;
        double stdDev = 1.5811388300841898;
        List<Double> doubleList = Arrays.asList(value, mean, stdDev);
        double expected = 2.846049894151541;

        // Act
        double result = Calculator.computeZScore(doubleList);

        // Assert
        Assertions.assertEquals(result, expected, 8);

    }

    @Test
    public void linReg_doubleArrList_returnsLinReg() {
        // preq-UNIT-TEST-6

        // Arrange
        Double[] pair1 = {1.47, 52.21};
        Double[] pair2 = {1.5, 53.12};
        List<Double[]> doubleArrList = Arrays.asList(pair1, pair2);

        // Act
        // double result = main.Calculator.computeLinearReg(doubleArrList);

        // Assert
        // Assertions.assertEquals(result, expected, 8);

    }

}
