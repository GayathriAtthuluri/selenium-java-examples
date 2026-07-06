package browser;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorExamples {

    private WebDriver driver;

    private static final String URL = "https://www.saucedemo.com/";

    // Launch Browser and Open Application
    public void launchApplication() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(URL);

        System.out.println("SauceDemo Application Opened Successfully");

    }

    // Locate Username using ID
    
    public void idLocator() {

        WebElement username = driver.findElement(By.id("user-name"));

        username.sendKeys("standard_user");

        System.out.println("Username Entered Using ID Locator");

    }

    // Locate Password using Name
    
    public void nameLocator() {

        WebElement password = driver.findElement(By.name("password"));

        password.sendKeys("secret_sauce");

        System.out.println("Password Entered Using Name Locator");

    }

    // Locate Login Button using Class Name
    
    public void classNameLocator() {

        WebElement loginButton = driver.findElement(By.className("submit-button"));

        loginButton.click();

        System.out.println("Login Button Clicked Using Class Name");

    }

    // Locate all Input Elements using Tag Name
    public void tagNameLocator() {

        int inputCount = driver.findElements(By.tagName("div")).size();

        System.out.println("Total Input Elements : " + inputCount);

    }

    // Locate Menu Button using CSS Selector
    
    public void cssSelectorLocator() {

        WebElement menuButton = driver.findElement(By.cssSelector("#react-burger-menu-btn"));

        System.out.println("Menu Button Displayed : " + menuButton.isDisplayed());

    }

    // Locate Shopping Cart using XPath
    public void xpathLocator() {

        WebElement cart = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));

        System.out.println("Shopping Cart Displayed : " + cart.isDisplayed());

    }

    // Close Browser
    public void closeBrowser() {

        driver.quit();

        System.out.println("Browser Closed Successfully");

    }

    public static void main(String[] args) throws InterruptedException {

        LocatorExamples locator = new LocatorExamples();

        locator.launchApplication();

        locator.idLocator();

        locator.nameLocator();

        locator.classNameLocator();

        Thread.sleep(3000);

        locator.tagNameLocator();

        locator.cssSelectorLocator();

        locator.xpathLocator();

        Thread.sleep(3000);

        locator.closeBrowser();

    }

}