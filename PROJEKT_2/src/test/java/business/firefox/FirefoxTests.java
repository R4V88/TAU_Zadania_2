package business.firefox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FirefoxTests {
    private static final Logger logger = LogManager.getLogger();
    private WebDriver driver;
    private String baseUrl;

    @BeforeTest
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        logger.info("Inicjalizacja Firefox driver'a");
        baseUrl = "https://www.zalando.pl/";
        driver.manage().timeouts().pageLoadTimeout(3600, TimeUnit.MILLISECONDS);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
        logger.info("Zamknięto driver'a");
    }

    @BeforeMethod
    public void beforeCheckIfPageOfOverpricedItemsIsFilled() {
        testPreparation();
    }

    @Test
    public void checkIfPageOfOverpricedItemsIsFilled() throws InterruptedException {
        WebElement overpricedItemsLink = driver.findElement(By.xpath("//a[@href='/okazje/?sale=true']"));
        overpricedItemsLink.click();
        logger.info("Przekierowano na podstronę z promocjami");

        Thread.sleep(2000);
        logger.info("Odczekano na załadowanie strony");

        List<WebElement> overpricedItemsList = driver.findElements(By.cssSelector(".iOzucJ"));
        logger.info("Zebrano wszystkie przecenione elementy");

        Assert.assertEquals(overpricedItemsList.size(), 87);
        logger.info("Sprawdzono czy strona jest w pełni wypełniona przecenionymi rzeczami");
        logger.info("************************** Koniec testu **************************");
    }

    @BeforeMethod
    public void beforeCheckIfSearchNotCorrectInputResultInCorrectOutputMessage() {
        testPreparation();
    }

    @Test
    public void checkIfSearchNotCorrectInputResultInCorrectOutputMessage() throws InterruptedException {
        int waitMiliseconds = 1200;
        String fakeInputText = "asudgfbwef";
        String resultText = "Spróbuj wpisać coś innego lub sprawdź pisownię.";

        WebElement searchInput = driver.findElement(By.xpath("//input[@type='search']"));
        logger.info("Wyszukano input wyszukiwarki");
        searchInput.click();

        searchInput.sendKeys(fakeInputText);
        logger.info("Wpisano text do wyszukiwarki :" + fakeInputText);
        searchInput.sendKeys(Keys.ENTER);

        logger.info("Odczekiwanie w milisekundach :" + waitMiliseconds);
        Thread.sleep(waitMiliseconds);

        String message = driver.findElement(By.xpath(("//div[@class='Bqz_1C']/span"))).getText();
        logger.info("Wyszukano zwrocony text: " + message);

        Assert.assertEquals(message, resultText);
        logger.info("************************** Koniec testu **************************");
    }

    public void testPreparation() {
        driver.get(baseUrl);
        logger.info("Otwarto przeglądarkę i skierowano się na stronę: " + baseUrl);
    }
}
