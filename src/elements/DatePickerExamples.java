package elements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DatePickerExamples {

    private WebDriver driver;

    private static final String URL = "https://demoqa.com/date-picker";

    // Launch Browser
    public void launchApplication() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(URL);

        System.out.println("Application Launched Successfully");

    }

    // Select Date using Calendar
    public void selectDate() {

        // Open Calendar
        driver.findElement(By.id("datePickerMonthYearInput")).click();

        // Select Month
        WebElement month = driver.findElement(By.className("react-datepicker__month-select"));

        Select monthDropdown = new Select(month);

        monthDropdown.selectByVisibleText("July");

        // Select Year
        WebElement year = driver.findElement(By.className("react-datepicker__year-select"));

        Select yearDropdown = new Select(year);

        yearDropdown.selectByVisibleText("2026");

        // Select Day
        driver.findElement(By.xpath("//div[contains(@class,'react-datepicker__day') and text()='20']")).click();

        System.out.println("Date Selected Successfully");

    }

    // Display Selected Date
    public void displaySelectedDate() {

        String selectedDate = driver.findElement(By.id("datePickerMonthYearInput"))
                .getAttribute("value");

        System.out.println("Selected Date : " + selectedDate);

    }

    // Close Browser
    public void closeBrowser() {

        driver.quit();

        System.out.println("Browser Closed Successfully");

    }

    public static void main(String[] args) throws InterruptedException {

        DatePickerExamples example = new DatePickerExamples();

        example.launchApplication();

        example.selectDate();

        example.displaySelectedDate();

        Thread.sleep(3000);

        example.closeBrowser();

    }

}