package tau.lab1.kalkulator.stepDefinitions;

import io.cucumber.java.en.Given;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tau.lab1.kalkulator.Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CucumberCalculatorTest {
    private static final Logger logger = LogManager.getLogger();
    private static final Calculator calculator = new Calculator();
    private static final Integer POSITIVE_NUMBER = 2;
    private static final Integer NEGATIVE_NUMBER = -2;
    private static final Integer ZERO_NUMBER = 0;
    private static Integer result;

    @Given("Uzytkownik wybiera dwie liczby dodatnie")
    public void uzytkownikWybieraDwieLiczbyDodatnie() {
        result = calculator.multiplication(POSITIVE_NUMBER, POSITIVE_NUMBER);
        assertEquals(4, result);
        logger.info("Test Uruchomiony z parametrami: pierwsza liczba - " + POSITIVE_NUMBER + " druga liczba - " + POSITIVE_NUMBER + ", Wynik = " + result);
    }

    @Given("Uzytkownik wybiera pierwsza liczbe dodatnia i druga liczbe ujemna")
    public void uzytkownikWybieraPierwszaLiczbeDodatniaIDrugaLiczbeUjemna() {
        result = calculator.multiplication(POSITIVE_NUMBER, NEGATIVE_NUMBER);
        assertEquals(-4, result);
        logger.info("Test Uruchomiony z parametrami: pierwsza liczba - " + POSITIVE_NUMBER + " druga liczba - " + NEGATIVE_NUMBER + ", Wynik = " + result);
    }

    @Given("Uzytkownik wybiera pierwsza liczbe ujemna a druga dodatnia")
    public void uzytkownikWybieraPierwszaLiczbeUjemnaADrugaDodatnia() {
        result = calculator.multiplication(NEGATIVE_NUMBER, POSITIVE_NUMBER);
        assertEquals(-4, result);
        logger.info("Test Uruchomiony z parametrami: pierwsza liczba - " + NEGATIVE_NUMBER + " druga liczba - " + POSITIVE_NUMBER + ", Wynik = " + result);
    }

    @Given("Uzytkownik wybiera dwie liczby ujemne")
    public void uzytkownikWybieraDwieLiczbyUjemne() {
        result = calculator.multiplication(NEGATIVE_NUMBER, NEGATIVE_NUMBER);
        assertEquals(4, result);
        logger.info("Test Uruchomiony z parametrami: pierwsza liczba - " + NEGATIVE_NUMBER + " druga liczba - " + NEGATIVE_NUMBER + ", Wynik = " + result);
    }

    @Given("Uzytkownik wybiera pierwsza liczbe rozna od zera a druga liczba jest rowna zero")
    public void uzytkownikWybieraPierwszaLiczbeRoznaOdZeraADrugaLiczbaJestRownaZero() {
        result = calculator.multiplication(NEGATIVE_NUMBER, ZERO_NUMBER);
        assertEquals(0, result);
        logger.info("Test Uruchomiony z parametrami: pierwsza liczba - " + NEGATIVE_NUMBER + " druga liczba - " + ZERO_NUMBER + ", Wynik = " + result);
    }

    @Given("Uzytkownik wybiera pierwsza liczbe rowna zero i druga liczba jest rozna od zera")
    public void uzytkownikWybieraPierwszaLiczbeRownaZeroIDrugaLiczbaJestRoznaOdZera() {
        result = calculator.multiplication(ZERO_NUMBER, POSITIVE_NUMBER);
        assertEquals(0, result);
        logger.info("Test Uruchomiony z parametrami: pierwsza liczba - " + ZERO_NUMBER + " druga liczba - " + POSITIVE_NUMBER + ", Wynik = " + result);
    }

    @Given("Uzytkwnik wybiera dwie liczby i obie to zero")
    public void uzytkwnikWybieraDwieLiczbyIObieToZero() {
        result = calculator.multiplication(ZERO_NUMBER, ZERO_NUMBER);
        assertEquals(0, result);
        logger.info("Test Uruchomiony z parametrami: pierwsza liczba - " + ZERO_NUMBER + " druga liczba - " + ZERO_NUMBER + ", Wynik = " + result);
    }
}
