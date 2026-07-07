package interactions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsExamples {

    private WebDriver driver;

    // Launch Browser
    public void launchApplication(String url) {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(url);

    }

    // Double Click and Right Click
    public void performMouseActions() {

        Actions actions = new Actions(driver);

        WebElement doubleClickButton = driver.findElement(By.id("doubleClickBtn"));
        actions.doubleClick(doubleClickButton).perform();

        System.out.println(driver.findElement(By.id("doubleClickMessage")).getText());

        WebElement rightClickButton = driver.findElement(By.id("rightClickBtn"));
        actions.contextClick(rightClickButton).perform();

        System.out.println(driver.findElement(By.id("rightClickMessage")).getText());

    }

    // Drag and Drop
    public void performDragAndDrop() {

        driver.get("https://jqueryui.com/droppable/");

        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));

        Actions actions = new Actions(driver);

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        actions.dragAndDrop(source, target).perform();

        System.out.println(target.getText());

        driver.switchTo().defaultContent();

    }

    // Close Browser
    public void closeBrowser() {

        driver.quit();

    }

    public static void main(String[] args) {

        ActionsExamples example = new ActionsExamples();

        example.launchApplication("https://demoqa.com/buttons");

        example.performMouseActions();

        example.performDragAndDrop();

        example.closeBrowser();

    }

}