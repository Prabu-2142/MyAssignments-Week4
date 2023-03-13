package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AlertsAssignments {

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.leafground.com/alert.xhtml");
		Thread.sleep(3000);

		//Simple Alert
		driver.findElement(By.xpath("//span[text()='Show']")).click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(3000);
		alert.accept();
		String text = driver.findElement(By.xpath("//span[@id='simple_result']")).getText();
		System.out.println("1. Simple Alert : "+text);
		Thread.sleep(3000);

		//Confirm Alert
		driver.findElement(By.xpath("(//span[text()='Show'])[2]")).click();
		Alert alert1 = driver.switchTo().alert();
		Thread.sleep(3000);
		alert1.accept();
		String text1 = driver.findElement(By.xpath("//span[@id='result']")).getText();
		System.out.println("2. Confirm Alert : "+text1);
		Thread.sleep(3000);

		//Sweet Alert 
		driver.findElement(By.xpath("(//span[text()='Show'])[3]")).click();
		Thread.sleep(3000);
		String text2 = driver.findElement(By.xpath("//div[@class='ui-dialog-content ui-widget-content']")).getText();
		System.out.println("3. Sweet Alert : "+text2);
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-closethick']")).click();
		Thread.sleep(3000);

		//Prompt Alert
		driver.findElement(By.xpath("(//span[text()='Show'])[5]")).click();
		Alert alert2 = driver.switchTo().alert();
		alert2.sendKeys("Prabu");
		alert2.accept();
		String text3 = driver.findElement(By.xpath("//span[@id='confirm_result']")).getText();
		System.out.println("4. Prompt Alert : "+text3);
		Thread.sleep(3000);


		driver.findElement(By.xpath("//div[@class='card']/button[@id='j_idt88:j_idt111']")).click();
		Thread.sleep(3000);
		String text4 = driver.findElement(By.xpath("(//div[@class='ui-dialog-content ui-widget-content']/p)[3]")).getText();
		System.out.println("5. Maximize Alert : "+text4);
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-minus']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-plus']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[@class='ui-dialog-titlebar-icon ui-dialog-titlebar-close ui-corner-all']/span)[3]")).click();
		Thread.sleep(3000);

	}

}
