package interactions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameExamples {

    private WebDriver driver;

    private static final String URL = "https://demoqa.com/frames";

    // Launch Browser
    public void launchApplication() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(URL);

        System.out.println("Application Launched Successfully");

    }

    // Handle Frames
    public void handleFrames() {

        // Switch to Frame 1 using ID
        driver.switchTo().frame("frame1");

        WebElement heading = driver.findElement(By.id("sampleHeading"));

        System.out.println("Frame 1 Text : " + heading.getText());

        // Return to Main Page
        driver.switchTo().defaultContent();

        // Switch to Frame 2 using WebElement
        WebElement frame2 = driver.findElement(By.id("frame2"));

        driver.switchTo().frame(frame2);

        heading = driver.findElement(By.id("sampleHeading"));

        System.out.println("Frame 2 Text : " + heading.getText());

        // Return to Main Page
        driver.switchTo().defaultContent();

    }

    // Display Page Information
    public void displayPageInformation() {

        System.out.println("Page Title : " + driver.getTitle());

        System.out.println("Current URL : " + driver.getCurrentUrl());

    }

    // Close Browser
    public void closeBrowser() {

        driver.quit();

        System.out.println("Browser Closed Successfully");

    }

    public static void main(String[] args) {

        FrameExamples example = new FrameExamples();

        example.launchApplication();

        example.handleFrames();

        example.displayPageInformation();

        example.closeBrowser();

    }

}