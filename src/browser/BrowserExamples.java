package browser;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserExamples {

    private WebDriver driver;

    private static final String APPLICATION_URL = "https://www.saucedemo.com/";

    /**
     * Launch Chrome browser and maximize the window.
     */
    public void launchBrowser() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        System.out.println("Chrome browser launched successfully.");

    }

    /**
     * Open SauceDemo application.
     */
    public void openApplication() {

        driver.get(APPLICATION_URL);

        System.out.println("Application opened successfully.");

    }

    /**
     * Display browser information.
     */
    public void displayBrowserInformation() {

        System.out.println("\n========== Browser Information ==========");

        System.out.println("Page Title       : " + driver.getTitle());

        System.out.println("Current URL      : " + driver.getCurrentUrl());

        System.out.println("Window Handle    : " + driver.getWindowHandle());

        System.out.println("Page Source Size : " + driver.getPageSource().length());

    }

    /**
     * Demonstrate browser navigation.
     */
    public void performNavigation() {

        driver.navigate().to("https://www.selenium.dev/");

        System.out.println("\nNavigated to Selenium Website");

        driver.navigate().back();

        System.out.println("Navigated Back");

        driver.navigate().forward();

        System.out.println("Navigated Forward");

        driver.navigate().refresh();

        System.out.println("Page Refreshed");

    }

    /**
     * Close browser.
     */
    public void closeBrowser() {

        driver.quit();

        System.out.println("Browser closed successfully.");

    }

    public static void main(String[] args) throws InterruptedException {

        BrowserExamples browser = new BrowserExamples();

        browser.launchBrowser();

        browser.openApplication();

        browser.displayBrowserInformation();

        browser.performNavigation();

        Thread.sleep(3000);

        browser.closeBrowser();

    }

}