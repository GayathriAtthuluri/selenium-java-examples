package elements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectionExamples {
	
	 private WebDriver driver;

	    private static final String URL = "https://demoqa.com/radio-button";

	    // Launch Browser
	    public void launchApplication() {

	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.get(URL);

	        System.out.println("Application Launched Successfully");

	    }
	    
	    // handle radiobuttons
	    
	    public void handleRadioButton() throws InterruptedException
	    {
	    	WebElement radiobutton =driver.findElement(By.xpath("//label[@for='yesRadio']"));
	    	radiobutton.click();
	    	Thread.sleep(2000);
	    	boolean selected =driver.findElement(By.id("yesRadio")).isSelected();
	    	System.out.println("yes Radio Button is Selected : "+selected);
	    	
	    	
	    }
	    
	    //handle checkboxes
	    public void handleCheckBox() throws InterruptedException
	    {
	    	driver.navigate().to("https://demoqa.com/checkbox");
	    	driver.findElement(By.xpath("//span[@class='rc-tree-switcher rc-tree-switcher_close']")).click();
	    	Thread.sleep(2000);
	    	driver.findElement(By.xpath("//span[@aria-label='Select Documents']")).click();
	    	Thread.sleep(2000);
	    	System.out.println("Check Box Selected Successfully");
	    	
	    }
	    
	    // Close Browser
	    public void closeBrowser() {

	        driver.quit();

	        System.out.println("Browser Closed Successfully");

	    }


	public static void main(String[] args) throws InterruptedException
	{
	
		SelectionExamples example = new SelectionExamples();
		example.launchApplication();
		example.handleRadioButton();
		example.handleCheckBox();
		Thread.sleep(1000);
		example.closeBrowser();
		

	}

}
