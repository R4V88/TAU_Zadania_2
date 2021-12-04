package business.chrome;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static utils.TakeScreenshot.takeSnapshot;

public class ChromeTests {
    private static final Logger logger = LogManager.getLogger();
    private WebDriver driver;
    private String baseUrl;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        logger.info("Inicjalizacja Chrome driver'a");
        baseUrl = "http://automationpractice.com/index.php";
        driver.manage().timeouts().pageLoadTimeout(3600, TimeUnit.MILLISECONDS);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
        logger.info("Zamknięto driver'a");
    }

    @BeforeMethod
    public void beforeLoginToShopWhenUserDoesNotExist() throws InterruptedException {
        testPreparation();
    }

    @Test
    public void loginToShopWhenUserDoesNotExist() {
        String fakeLogin = "12344321";
        String fakePassword = "qwerty11110";

        WebElement signInButton = driver.findElement(By.linkText("Sign in"));
        signInButton.click();
        logger.info("Naciśnięto przycisk logowania do serwisu");

        WebElement emailAddressInput = driver.findElement(By.cssSelector("#email"));
        emailAddressInput.sendKeys(fakeLogin);
        logger.info("Wpisano niepoprawny login: " + fakeLogin);

        WebElement passwordInput = driver.findElement(By.cssSelector("#passwd"));
        passwordInput.sendKeys(fakePassword);
        logger.info("Wpisano niepoprawne hasło: " + fakePassword);

        WebElement greenSignInButton = driver.findElement(By.cssSelector("#SubmitLogin"));
        greenSignInButton.click();
        logger.info("Naciśnięto przycisk zalogowania");

        driver.manage().timeouts().implicitlyWait(3600, TimeUnit.MILLISECONDS);

        WebElement alertDiv = driver.findElement(By.cssSelector(".alert"));

        Assert.assertTrue(alertDiv.isDisplayed());
        logger.info("alert pojawił się na stronie i jest widoczny dla uzytkownika");
        logger.info("************************** Koniec testu **************************");
    }

    @BeforeMethod
    public void beforeCheckIfContactFormIsDisplayedAndTakeScreenshotOfIt() throws InterruptedException {
        testPreparation();
    }

    @Test
    public void checkIfContactFormIsDisplayedAndTakeScreenshotOfIt() throws IOException {
        String pathToFile = "d://test.png";

        WebElement contactUsButton = driver.findElement(By.cssSelector("#contact-link"));
        contactUsButton.click();
        logger.info("Naciśnięto przycisk 'Contact Us'");

        WebElement contactForm = driver.findElement(By.cssSelector(".contact-form-box"));

        Assert.assertTrue(contactForm.isDisplayed());
        logger.info("Formularz kontaktowy jest widoczny");

        takeSnapshot(driver, pathToFile);
        logger.info("Wykonano zrzut ekranu do pliku: " + pathToFile);
        logger.info("************************** Koniec testu **************************");
    }

    public void testPreparation() throws InterruptedException {
        driver.get(baseUrl);
        logger.info("Otwarto przeglądarkę i skierowano się na stronę: " + baseUrl);
        Thread.sleep(6000);
    }
}
