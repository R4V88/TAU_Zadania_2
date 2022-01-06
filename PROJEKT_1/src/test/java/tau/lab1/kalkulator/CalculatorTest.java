package tau.lab1.kalkulator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {
    private static final Logger logger = LogManager.getLogger();
    private static final Calculator calculator = new Calculator();
    private static Integer positiveA;
    private static Integer positiveB;
    private static Integer positiveC;
    private static Integer positiveD;
    private static Integer negativeA;
    private static Integer negativeB;
    private static Integer zeroNumber;

    @BeforeAll
    static void setUp() {
        positiveA = 5;
        positiveB = 7;
        positiveC = 8;
        positiveD = 2;
        negativeA = -10;
        negativeB = -1;
        zeroNumber = 0;

    }

    @BeforeEach
    void startTest() {
        logger.info("Start Testu");
    }

    @AfterEach
    void tearDown() {
        logger.info("Koniec Testu");
        System.out.println("******************** * ********************");
    }

    @Test
    void additionOfTwoPositiveNumbers() {
        int result = calculator.addition(positiveA, positiveB);
        logger.info("Sprawdzono dla liczb " + positiveA +" oraz " + positiveB);
        assertEquals(12, result);
    }

    @Test
    void additionOfTwoNegativeNumbers() {
        int result = calculator.addition(negativeA, negativeB);
        logger.info("Sprawdzono dla liczb " + negativeA +" oraz " + negativeB);
        assertEquals(-11, result);
    }

    @Test
    void addOfNegativeWithPositiveNumber() {
        int result = calculator.addition(negativeB, positiveB);
        logger.info("Sprawdzono dla liczb " + negativeB +" oraz " + positiveB);
        assertEquals(6, result);
    }

    @Test
    void subtractionOfTwoPositiveNumbers() {
        int result = calculator.subtraction(positiveA, positiveB);
        logger.info("Sprawdzono dla liczb " + positiveA +" oraz " + positiveB);
        assertEquals(-2, result);
    }

    @Test
    void subtractionOfTwoNegativeNumbers() {
        int result = calculator.subtraction(negativeA, negativeB);
        logger.info("Sprawdzono dla liczb " + positiveA +" oraz " + negativeB);
        assertEquals(-9, result);
    }

    @Test
    void subtractionOfPositiveAndNegativeNumber() {
        int result = calculator.subtraction(positiveA, negativeB);
        logger.info("Sprawdzono dla liczb " + positiveA +" oraz " + negativeB);
        assertEquals(6, result);
    }

    @Test
    void whenZeroExceptionThrown() {
        logger.info("Sprawdzono dla liczby " + zeroNumber);
        assertThrows(IllegalArgumentException.class, () -> calculator.numberValidator(zeroNumber));
    }

    @Test
    void whenValidatedNumberIsDifferentThanZero() {
        logger.info("Sprawdzono dla liczby " + positiveB);
        assertDoesNotThrow(() -> calculator.numberValidator(positiveB));
    }

    @Test
    void whenTwoNumbersAreDifferent() {
        logger.info("Sprawdzono dla liczb " + positiveA +" oraz " + positiveB);
        assertNotEquals(positiveA, positiveB);
    }

    @Test
    void exceptionThrownWhenDividingByZero() {
        logger.info("Sprawdzono dla liczb " + positiveA +" oraz " + zeroNumber);
        assertThrows(IllegalArgumentException.class, () -> calculator.division(positiveA, zeroNumber));
    }

    @Test
    void dividingTwoNegativeNumbers() {
        double result = calculator.division(negativeA, negativeB);
        logger.info("Sprawdzono dla liczb " + negativeA +" oraz " + negativeB);
        assertEquals(10, result);
    }

    @Test
    void dividingTwoPositiveBumbers() {
        double result = calculator.division(positiveC, positiveD);
        logger.info("Sprawdzono dla liczb " + positiveC +" oraz " + positiveD);
        assertEquals(4, result);
    }

    @Test
    void dividingPositiveNumberByNegativeNumber() {
        double result = calculator.division(positiveC, negativeB);
        logger.info("Sprawdzono dla liczb " + positiveC +" oraz " + negativeB);
        assertEquals(-8, result);
    }

    @Test
    void dividingNegativeNumberByPositiveNumber() {
        double result = calculator.division(negativeA, positiveD);
        logger.info("Sprawdzono dla liczb " + negativeA +" oraz " + positiveD);
        assertEquals(-5, result);
    }

    @Test
    void dividingZeroByNegativeNumber() {
        double result = calculator.division(zeroNumber, negativeA);
        logger.info("Sprawdzono dla liczb " + zeroNumber +" oraz " + negativeA);
        assertEquals(0, result);
    }

    @Test
    void joiningAdditionWithDivision() {
        double result = calculator.addition(positiveA, (int) calculator.division(positiveC, positiveD));
        logger.info("Sprawdzono dla liczb " + positiveC +" oraz " + positiveD);
        assertEquals(9, result);
    }
}