package interactions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExamples {

    private WebDriver driver;

    private JavascriptExecutor js;

    private static final String URL = "https://demoqa.com/text-box";

    // Launch Browser
    public void launchApplication() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(URL);

        js = (JavascriptExecutor) driver;

        System.out.println("Application Launched Successfully");

    }

    // JavaScript Operations
    public void performJavaScriptOperations() {

        WebElement fullName = driver.findElement(By.id("userName"));

        // Scroll Element into View
        js.executeScript("arguments[0].scrollIntoView({behavior:'smooth',block:'center'});", fullName);

        // Highlight Element
        js.executeScript("arguments[0].style.border='3px solid blue';", fullName);

        // Enter Text
        js.executeScript("arguments[0].value='Test User';", fullName);

        // Get Entered Value
        String value = (String) js.executeScript("return arguments[0].value;", fullName);

        System.out.println("Entered Name : " + value);

        // Scroll to Bottom
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        // Scroll to Top
        js.executeScript("window.scrollTo(0,0);");

        // Get Page Title
        String title = (String) js.executeScript("return document.title;");
        System.out.println("Page Title : " + title);

        // Get Current URL
        String url = (String) js.executeScript("return document.URL;");
        System.out.println("Current URL : " + url);

    }

    // Close Browser
    public void closeBrowser() {

        driver.quit();

        System.out.println("Browser Closed Successfully");

    }

    public static void main(String[] args) {

        JavaScriptExamples example = new JavaScriptExamples();

        example.launchApplication();

        example.performJavaScriptOperations();

        example.closeBrowser();

    }

}