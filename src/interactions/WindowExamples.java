package interactions;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowExamples {

    private WebDriver driver;

    private static final String URL = "https://the-internet.herokuapp.com/windows";

    // Launch Browser
    public void launchApplication() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(URL);

        System.out.println("Application Launched Successfully");

    }

    // Handle Multiple Windows
    public void handleMultipleWindows() {

        String parentWindow = driver.getWindowHandle();

        System.out.println("Parent Window ID : " + parentWindow);

        driver.findElement(By.linkText("Click Here")).click();

        Set<String> windowHandles = driver.getWindowHandles();

        for (String window : windowHandles) {

            if (!window.equals(parentWindow)) {

                driver.switchTo().window(window);

                System.out.println("Child Window Title : " + driver.getTitle());

                System.out.println("Child Window URL : " + driver.getCurrentUrl());

                driver.close();

            }
        }

        driver.switchTo().window(parentWindow);

    }

    // Display Parent Window Information
    public void displayWindowInformation() {

        System.out.println("Parent Window Title : " + driver.getTitle());

        System.out.println("Parent Window URL : " + driver.getCurrentUrl());

    }

    // Close Browser
    public void closeBrowser() {

        driver.quit();

        System.out.println("Browser Closed Successfully");

    }

    public static void main(String[] args) {

        WindowExamples example = new WindowExamples();

        example.launchApplication();

        example.handleMultipleWindows();

        example.displayWindowInformation();

        example.closeBrowser();

    }

}