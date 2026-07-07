package interactions;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertExamples {

    private WebDriver driver;

    private static final String URL =
            "https://the-internet.herokuapp.com/javascript_alerts";

    // Launch Browser
    public void launchApplication() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(URL);

        System.out.println("Application Launched Successfully");

    }

    // Handle JavaScript Alerts
    public void handleAlerts() {

        Alert alert;

        // Simple Alert
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

        alert = driver.switchTo().alert();

        System.out.println("Simple Alert : " + alert.getText());

        alert.accept();

        // Confirmation Alert
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();

        alert = driver.switchTo().alert();

        System.out.println("Confirmation Alert : " + alert.getText());

        alert.dismiss();

        // Prompt Alert
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();

        alert = driver.switchTo().alert();

        System.out.println("Prompt Alert : " + alert.getText());

        alert.sendKeys("Test User");

        alert.accept();

    }

    // Display Result
    public void displayResult() {

        String result = driver.findElement(By.id("result")).getText();

        System.out.println("Result : " + result);

    }

    // Close Browser
    public void closeBrowser() {

        driver.quit();

        System.out.println("Browser Closed Successfully");

    }

    public static void main(String[] args) {

        AlertExamples example = new AlertExamples();

        example.launchApplication();

        example.handleAlerts();

        example.displayResult();

        example.closeBrowser();

    }

}