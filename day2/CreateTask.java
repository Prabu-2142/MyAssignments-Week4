package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class CreateTask {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://login.salesforce.com/");
        driver.findElement(By.xpath("//div[@id='username_container']/input")).sendKeys("hari.radhakrishnan@qeagle.com");        
		driver.findElement(By.xpath("//label[@class='label']/following-sibling::input")).sendKeys("Leaf@123");
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		driver.findElement(By.xpath("(//div[contains(@class,'waffle')])[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("task");
		
		WebElement moveto = driver.findElement(By.xpath("//mark[text()='Task']"));
		
		Actions act = new Actions(driver);
		act.moveToElement(moveto).perform();
		moveto.click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='slds-context-bar__label-action slds-p-left--none'])[4]")).click();
		WebElement ele = driver.findElement(By.xpath("//span[text()='New Task']"));
		driver.executeScript("arguments[0].click()", ele);
		
		driver.findElement(By.xpath("//input[@class='slds-combobox__input slds-input']")).sendKeys("Bootcamp");
		driver.findElement(By.xpath("//a[text()='Not Started']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Waiting on someone else']")).click();
		driver.findElement(By.xpath("//span[text()='Save']")).click();
		WebElement msg = driver.findElement(By.xpath("//div[contains(@class,'slds-page-header__title slds-m-right--small slds-align-middle clip-text slds-line-clamp')]"));
		
		if(msg.isDisplayed()) {
			System.out.println("Task Successfully Created");
		}
		
		else {
			System.out.println("Task not created Successfully");
		}
			
		driver.close();
		
	}

}
