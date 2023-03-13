package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LearningAlertClassRoom {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();

		options.addArguments("--remote-allow-origins=*");

		ChromeDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get("https://www.leafground.com/alert.xhtml");

		driver.findElement(By.xpath("(//span[text()='Show'])[5]")).click();

		Alert alert = driver.switchTo().alert();

		alert.sendKeys("Prabu");
		alert.accept();
		String text = driver.findElement(By.xpath("//span[@id='confirm_result']")).getText();
		System.out.println(text);
	}

}
