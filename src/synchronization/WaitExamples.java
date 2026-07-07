package synchronization;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitExamples {

    private WebDriver driver;

    private static final String URL =
            "https://the-internet.herokuapp.com/dynamic_loading/2";

    // Launch Browser
    public void launchApplication() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(URL);

        System.out.println("Application Launched Successfully");

    }

    // Demonstrate Explicit Wait
    public void demonstrateExplicitWait() {

        driver.findElement(By.xpath("//button[text()='Start']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement message = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("finish")));

        System.out.println("Message : " + message.getText());

    }

    // Close Browser
    public void closeBrowser() {

        driver.quit();

        System.out.println("Browser Closed Successfully");

    }

    public static void main(String[] args) {

        WaitExamples example = new WaitExamples();

        example.launchApplication();

        example.demonstrateExplicitWait();

        example.closeBrowser();

    }

}
