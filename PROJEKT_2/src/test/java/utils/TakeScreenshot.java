package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class TakeScreenshot {
    public static void takeSnapshot(WebDriver webDriver, String filePath) throws IOException {
        TakesScreenshot screenshot = ((TakesScreenshot) webDriver);
        File screenShotFile = screenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(filePath);
        FileUtils.copyFile(screenShotFile, destinationFile);
    }
}
