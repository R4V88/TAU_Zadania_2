package tau.lab1.kalkulator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {
    private static final Calculator calculator = new Calculator();
    private static Integer positiveA;
    private static Integer positiveB;
    private static Integer positiveC;
    private static Integer positiveD;
    private static Integer negativeA;
    private static Integer negativeB;
    private static Integer zeroNumber;

    @BeforeEach
    void setUp() {
        positiveA = 5;
        positiveB = 7;
        positiveC = 8;
        positiveD = 2;
        negativeA = -10;
        negativeB = -1;
        zeroNumber = 0;

    }

    @AfterEach
    void tearDown() {
        System.out.println("After Tests");
    }

    @Test
    void additionOfTwoPositiveNumbers() {
        int result = calculator.addition(positiveA, positiveB);
        assertEquals(12, result);
    }

    @Test
    void additionOfTwoNegativeNumbers() {
        int result = calculator.addition(negativeA, negativeB);
        assertEquals(-11, result);
    }

    @Test
    void addOfNegativeWithPositiveNumber() {
        int result = calculator.addition(negativeB, positiveB);
        assertEquals(6, result);
    }

    @Test
    void subtractionOfTwoPositiveNumbers() {
        int result = calculator.subtraction(positiveA, positiveB);
        assertEquals(-2, result);
    }

    @Test
    void subtractionOfTwoNegativeNumbers() {
        int result = calculator.subtraction(negativeA, negativeB);
        assertEquals(-9, result);
    }

    @Test
    void subtractionOfPositiveAndNegativeNumber() {
        int result = calculator.subtraction(positiveA, negativeB);
        assertEquals(6, result);
    }

    @Test
    void whenZeroExceptionThrown() {
        assertThrows(IllegalArgumentException.class, () -> calculator.numberValidator(zeroNumber));
    }

    @Test
    void whenValidatedNumberIsDifferentThanZero() {
        assertDoesNotThrow(() -> calculator.numberValidator(positiveB));
    }

    @Test
    void whenTwoNumbersAreDifferent() {
        assertNotEquals(positiveA, positiveB);
    }

    @Test
    void exceptionThrownWhenDividingByZero() {
        assertThrows(IllegalArgumentException.class, () -> calculator.division(positiveA, zeroNumber));
    }

    @Test
    void dividingTwoNegativeNumbers() {
        double result = calculator.division(negativeA, negativeB);
        assertEquals(10, result);
    }

    @Test
    void dividingTwoPositiveBumbers() {
        double result = calculator.division(positiveC, positiveD);
        assertEquals(4, result);
    }

    @Test
    void dividingPositiveNumberByNegativeNumber() {
        double result = calculator.division(positiveC, negativeB);
        assertEquals(-8, result);
    }

    @Test
    void dividingNegativeNumberByPositiveNumber() {
        double result = calculator.division(negativeA, positiveD);
        assertEquals(-5, result);
    }

    @Test
    void dividingZeroByNegativeNumber() {
        double result = calculator.division(zeroNumber, negativeA);
        assertEquals(0, result);
    }

    @Test
    void joiningAdditionWithDivision() {
        double result = calculator.addition(positiveA, (int) calculator.division(positiveC, positiveD));
        assertEquals(9, result);
    }
}