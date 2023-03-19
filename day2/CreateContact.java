package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;


public class CreateContact {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://login.salesforce.com/");
		Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@id='username_container']/input")).sendKeys("hari.radhakrishnan@qeagle.com");        
		driver.findElement(By.xpath("//label[@class='label']/following-sibling::input")).sendKeys("Leaf@123");
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		driver.findElement(By.xpath("(//div[contains(@class,'waffle')])[2]")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		Thread.sleep(3000);
		WebElement moveto = driver.findElement(By.xpath("//p[text()='Sales']"));
		Actions act = new Actions(driver);
		act.scrollToElement(moveto).perform();
		Thread.sleep(3000);
		moveto.click();
		Thread.sleep(3000);
		
		WebElement j = driver.findElement(By.xpath("//span[text()='Accounts']"));
		driver.executeScript("arguments[0].click()", j);
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[text()='New']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("(//input[@class='slds-input'])[2]")).sendKeys("P2");
		Thread.sleep(2000);
		
	    WebElement j1 = driver.findElement(By.xpath("(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[3]"));
		driver.executeScript("arguments[0].click()", j1);
		Thread.sleep(2000);
		
		WebElement j2 = driver.findElement(By.xpath("//lightning-base-combobox-item[@class='slds-media slds-listbox__option slds-media_center slds-media_small slds-listbox__option_plain']/span"));
		driver.executeScript("arguments[0].click()", j2);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		
		WebElement name = driver.findElement(By.xpath("//lightning-formatted-text[@class='custom-truncate']"));
		String text = name.getText();
		System.out.println(text);
		
		if(name.isDisplayed()) {
			
			System.out.println("Message Verified");
		}
		
		else {
			System.out.println("Message not Verified");
		}
		
		String title = driver.getTitle();
		System.out.println(title);
		
		if(title.equalsIgnoreCase("P2 | Salesforce")) {
			
			System.out.println("Title Matches");
		}
		else {
			System.out.println("Title Not Matches");
		}
				
		
	}

}
