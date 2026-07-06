package browser;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverExamples {

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

    // Get Page Title
    public void getTitleExample() {

        System.out.println("Page Title : " + driver.getTitle());

    }

    // Get Current URL
    public void getCurrentUrlExample() {

        System.out.println("Current URL : " + driver.getCurrentUrl());

    }

    // Get Page Source Length
    public void getPageSourceExample() {

        System.out.println("Page Source Length : " + driver.getPageSource().length());

    }

    // Get Window Handle
    public void getWindowHandleExample() {

        System.out.println("Window Handle : " + driver.getWindowHandle());

    }

    // Get All Window Handles
    public void getWindowHandlesExample() {

        Set<String> windows = driver.getWindowHandles();

        System.out.println("Total Windows : " + windows.size());

    }

    // Delete Cookies
    public void deleteCookiesExample() {

        driver.manage().deleteAllCookies();

        System.out.println("Cookies Deleted Successfully");

    }

    // Browser Window Operations
    public void windowOperations() {

        driver.manage().window().minimize();

        System.out.println("Browser Minimized");

        driver.manage().window().maximize();

        System.out.println("Browser Maximized");

    }

    // Close Browser
    public void closeBrowser() {

        driver.quit();

        System.out.println("Browser Closed Successfully");

    }

    public static void main(String[] args) throws InterruptedException {

        WebDriverExamples example = new WebDriverExamples();

        example.launchApplication();

        example.getTitleExample();

        example.getCurrentUrlExample();

        example.getPageSourceExample();

        example.getWindowHandleExample();

        example.getWindowHandlesExample();

        example.deleteCookiesExample();

        example.windowOperations();

        Thread.sleep(3000);

        example.closeBrowser();

    }

}