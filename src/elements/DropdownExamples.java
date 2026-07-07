package elements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownExamples {

    private WebDriver driver;

    private static final String URL = "https://demoqa.com/select-menu";

    // Launch Browser
    public void launchApplication() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(URL);

        System.out.println("Application Launched Successfully");

    }

    // Demonstrate Select Class Methods
    public void handleDropdown() throws InterruptedException {

        WebElement colorDropdown = driver.findElement(By.id("oldSelectMenu"));

        Select select = new Select(colorDropdown);

        // Select by Visible Text
        select.selectByVisibleText("Purple");
        Thread.sleep(1000);

        // Select by Value
        select.selectByValue("5");
        Thread.sleep(1000);

        // Select by Index
        select.selectByIndex(2);
        Thread.sleep(1000);

        // Print Selected Option
        System.out.println("Selected Option : "
                + select.getFirstSelectedOption().getText());

    }

    // Close Browser
    public void closeBrowser() {

        driver.quit();

        System.out.println("Browser Closed Successfully");

    }

    public static void main(String[] args) throws InterruptedException {

        DropdownExamples example = new DropdownExamples();

        example.launchApplication();

        example.handleDropdown();

        Thread.sleep(3000);

        example.closeBrowser();

    }

}
