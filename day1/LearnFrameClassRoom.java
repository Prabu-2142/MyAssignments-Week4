package week4.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class LearnFrameClassRoom {

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();

		options.addArguments("--remote-allow-origins=*");

		ChromeDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get("https://jqueryui.com/droppable/");

		driver.switchTo().frame(0);
		Thread.sleep(3000);

		Actions a = new Actions(driver);
		WebElement dg = driver.findElement(By.id("draggable"));
		WebElement dp = driver.findElement(By.id("droppable"));
		a.dragAndDrop(dg, dp).perform();

	}

}
