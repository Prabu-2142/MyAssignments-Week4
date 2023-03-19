package week4.day4;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CreateOpportunityWithout extends MainClass {

	@Test

	public  void withOut() throws InterruptedException {

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

		WebElement calender = driver.findElement(By.xpath("(//input[@class='slds-input'])[3]"));
		calender.click();
		calender.sendKeys("3/18/2023",Keys.ENTER);

		driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand']")).click();

		WebElement e1 = driver.findElement(By.xpath("//ul[@class='errorsList slds-list_dotted slds-m-left_medium']//a"));
		WebElement e2 = driver.findElement(By.xpath("(//ul[@class='errorsList slds-list_dotted slds-m-left_medium']//a)[2]"));
		String text = e1.getText();
		String text1 = e2.getText();

		if(e1.isDisplayed() && e2.isDisplayed()) {

			System.out.println("Verification Fields are Empty:");
			System.out.println("1."+text);
			System.out.println("2."+text1);
		}
		else {
			System.out.println("Verification fields are filled");
		}



	}

}
