package week4.day4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class MainClass {
	
	public ChromeDriver driver;
	
	@BeforeMethod
	
	public void preCondition() {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
	    driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.xpath("//div[@id='username_container']/input")).sendKeys("hari.radhakrishnan@qeagle.com");        
		driver.findElement(By.xpath("//label[@class='label']/following-sibling::input")).sendKeys("Leaf@123");
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		
	}
	
	
	
	
	@AfterMethod
	public void PostCondition() {
		
		driver.close();
	}

}
