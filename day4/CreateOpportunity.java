package week4.day4;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CreateOpportunity extends MainClass{

	@Test(priority=1)

	public  void create() throws InterruptedException {

		driver.findElement(By.xpath("(//div[contains(@class,'waffle')])[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='View All']")).click();

		WebElement moveto = driver.findElement(By.xpath("//p[text()='Sales']"));
		Actions act = new Actions(driver);
		act.scrollToElement(moveto).perform();
		Thread.sleep(3000);
		moveto.click();
		Thread.sleep(3000);

		WebElement j = driver.findElement(By.xpath("//span[text()='Opportunities']"));
		driver.executeScript("arguments[0].click()", j);
		Thread.sleep(3000);

		driver.findElement(By.xpath("//div[text()='New']")).click();

		WebElement ele = driver.findElement(By.xpath("(//input[@class='slds-input'])[4]"));
		ele.sendKeys("Salesforce Automation by Prabu");
		Thread.sleep(2000);

		WebElement calender = driver.findElement(By.xpath("(//input[@class='slds-input'])[3]"));
		calender.click();
		calender.sendKeys("3/17/2023",Keys.ENTER);

		driver.findElement(By.xpath("//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("(//lightning-base-combobox-item[@class='slds-media slds-listbox__option slds-media_center slds-media_small slds-listbox__option_plain'][3])")).click();

		driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand']")).click();

		WebElement name = driver.findElement(By.xpath("//div[contains(@class,'entityNameTitle ')]/following::lightning-formatted-text"));
		String text = name.getText();


		if(text.equalsIgnoreCase("Salesforce Automation by Prabu")) {

			System.out.println("Name Matched");
		}
		else {
			System.out.println("Name not Matched");

		}


	}

}
