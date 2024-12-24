package com.example.test;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CalculatorAppIT {

    // Shared between all tests in this class.
    static Playwright playwright;
    static Browser browser;

    // New instance for each test method.
    BrowserContext context;
    Page page;

    @BeforeAll
    static void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(200));
    }

    @AfterAll
    static void closeBrowser() {
        playwright.close();
    }

    @BeforeEach
    void createContextAndPage() {
        context = browser.newContext();
        page = context.newPage();
        page.navigate("http://localhost:8080/");
    }

    @AfterEach
    void closeContext() {
        context.close();
    }

    @Test
    void pageTitle_isCalculator() {
        // preq-E2E-TEST-5
        assertThat(page).hasTitle("Calculator");
    }

    @Test
    void sampleStD_computesResult() {
        // preq-E2E-TEST-6

        // Arrange
        double expected = 3.060787652326;
        String textInput = "9\n2\n5\n4\n12\n7\n8\n11\n9\n3\n7\n4\n12\n5\n4\n10\n9\n6\n9\n4";
        String result;

        // Act
        page.getByLabel("Values", new Page.GetByLabelOptions().setExact(true)).fill(textInput);
        page.getByLabel("sampleStD").click();
        result = page.getByLabel("result").innerText();

        // Assert
        Assertions.assertEquals(expected, Double.parseDouble(result), 0.00001);
    }

    @Test
    void populationStD_emptyList() {
        // preq-E2E-TEST-7

        // Arrange
        String error = "List of numbers cannot be empty.";
        String result;

        // Act
        page.getByLabel("populationStD").click();
        result = page.getByLabel("description").innerText();

        // Assert
        Assertions.assertEquals(error, result);
    }

    @Test
    void sampleStD_ListWithOneSample() {
        // preq-E2E-TEST-8

        // Arrange
        String error = "List of numbers must be at least 2.";
        String textInput = "5";
        String result;

        // Act
        page.getByLabel("Values", new Page.GetByLabelOptions().setExact(true)).fill(textInput);
        page.getByLabel("sampleStD").click();
        result = page.getByLabel("description").innerText();

        // Assert
        Assertions.assertEquals(error, result);
    }

    @Test
    void mean_computesResult() {
        // preq-E2E-TEST-9

        // Arrange
        double expected = 7.0;
        String textInput = "9\n2\n5\n4\n12\n7\n8\n11\n9\n3\n7\n4\n12\n5\n4\n10\n9\n6\n9\n4";
        String result;

        // Act
        page.getByLabel("Values", new Page.GetByLabelOptions().setExact(true)).fill(textInput);
        page.getByLabel("mean").click();
        result = page.getByLabel("result").innerText();

        // Assert
        Assertions.assertEquals(expected, Double.parseDouble(result), 0.00001);
    }

    @Test
    void zScore_computesResult() {
        // preq-E2E-TEST-10

        // Arrange
        double expected = -0.49007;
        String textInput = "5.5, 7, 3.060787652326";
        String result;

        // Act
        page.getByLabel("Values", new Page.GetByLabelOptions().setExact(true)).fill(textInput);
        page.getByLabel("zScore").click();
        result = page.getByLabel("result").innerText();

        // Assert
        Assertions.assertEquals(expected, Double.parseDouble(result), 0.00001);
    }

    @Test
    void linearReg_computesResult() {
        // preq-E2E-TEST-11

        // Arrange
        String expected = "y = -0.04596x + 6.93359";
        String textInput = "5,3\n3,2\n2,15\n1,12.3\n7.5,-3\n4,5\n3,17\n4,3\n6.42,4\n34,5\n12,17\n3,-1";
        String result;

        // Act
        page.getByLabel("Values", new Page.GetByLabelOptions().setExact(true)).fill(textInput);
        page.getByLabel("linearReg").click();
        result = page.getByLabel("result").innerText();

        // Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    void predictY_computesResult() {
        // preq-E2E-TEST-11

        // Arrange
        String expected = "y = 6.65784";
        String textInput = "6, -0.04596, 6.9336";
        String result;

        // Act
        page.getByLabel("Values", new Page.GetByLabelOptions().setExact(true)).fill(textInput);
        page.getByLabel("predictY").click();
        result = page.getByLabel("result").innerText();

        // Assert
        Assertions.assertEquals(expected, result);
    }
}