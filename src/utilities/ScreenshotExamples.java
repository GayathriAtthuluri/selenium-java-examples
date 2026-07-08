package utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenshotExamples {

    private WebDriver driver;

    private static final String URL = "https://www.saucedemo.com/";

    // Launch Browser
    public void launchApplication() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(URL);

        System.out.println("Application Launched Successfully");

    }

    // Capture Screenshot
    public void captureScreenshot() throws IOException, InterruptedException {
         File screenshotFile = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);

        File destinationFile = new File("Screenshots/HomePage.png");

        destinationFile.getParentFile().mkdirs();

        FileUtils.copyFile(screenshotFile, destinationFile);
        Thread.sleep(5000);
        System.out.println(destinationFile.getAbsolutePath());
        System.out.println("Screenshot Captured Successfully");

    }

    // Close Browser
    public void closeBrowser() {

        driver.quit();

        System.out.println("Browser Closed Successfully");

    }

    public static void main(String[] args) throws IOException, InterruptedException {

        ScreenshotExamples example = new ScreenshotExamples();

        example.launchApplication();

        example.captureScreenshot();

        example.closeBrowser();

    }

}