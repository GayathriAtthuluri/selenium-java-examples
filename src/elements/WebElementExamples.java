package elements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementExamples {

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

    // Login to SauceDemo
    public void loginToApplication() {

        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        System.out.println("Login Successful");

    }

    // Demonstrate WebElement Methods
    public void verifyWebElementMethods() {

        // getText()
        WebElement pageTitle = driver.findElement(By.className("title"));
        System.out.println("Page Title : " + pageTitle.getText());

        // isDisplayed()
        WebElement cartIcon = driver.findElement(By.id("shopping_cart_container"));
        System.out.println("Cart Displayed : " + cartIcon.isDisplayed());

        // isEnabled()
        WebElement menuButton = driver.findElement(By.id("react-burger-menu-btn"));
        System.out.println("Menu Enabled : " + menuButton.isEnabled());

        // click()
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addToCartButton.click();
        System.out.println("Product Added to Cart");

        // getAttribute()
        WebElement cartBadge = driver.findElement(By.className("shopping_cart_badge"));
        System.out.println("Cart Count : " + cartBadge.getText());
        System.out.println("Cart Class Attribute : " + cartBadge.getAttribute("class"));

    }

    // Close Browser
    public void closeBrowser() {

        driver.quit();

        System.out.println("Browser Closed Successfully");

    }

    public static void main(String[] args) throws InterruptedException {

        WebElementExamples example = new WebElementExamples();

        example.launchApplication();

        example.loginToApplication();

        example.verifyWebElementMethods();

        Thread.sleep(3000);

        example.closeBrowser();

    }

}