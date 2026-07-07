package elements;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableExamples {

    private WebDriver driver;

    private static final String URL = "https://www.w3schools.com/html/html_tables.asp";

    // Launch Browser
    public void launchApplication() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(URL);

        System.out.println("Application Launched Successfully");

    }

    // Read Complete Web Table
    public void readTableData() {

        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr"));

        int totalRows = rows.size();

        int totalColumns = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[2]/td")).size();

        System.out.println("\n========== WEB TABLE ==========");
        System.out.println("Total Rows    : " + (totalRows - 1));
        System.out.println("Total Columns : " + totalColumns);
        System.out.println("================================\n");

        for (int i = 2; i <= totalRows; i++) {

            for (int j = 1; j <= totalColumns; j++) {

                String cellData = driver.findElement(
                        By.xpath("//table[@id='customers']/tbody/tr[" + i + "]/td[" + j + "]"))
                        .getText();

                System.out.print(cellData + "\t");

            }

            System.out.println();

        }

    }

    // Display Company Names
    public void displayCompanyNames() {

        List<WebElement> companies = driver.findElements(
                By.xpath("//table[@id='customers']/tbody/tr/td[1]"));

        System.out.println("\nCompanies\n");

        for (int i = 0; i < companies.size(); i++) {

            System.out.println(companies.get(i).getText());

        }

    }

    // Close Browser
    public void closeBrowser() {

        driver.quit();

        System.out.println("\nBrowser Closed Successfully");

    }

    public static void main(String[] args) {

        WebTableExamples table = new WebTableExamples();

        table.launchApplication();

        table.readTableData();

        table.displayCompanyNames();

        table.closeBrowser();

    }

}