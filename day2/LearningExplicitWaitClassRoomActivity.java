package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LearningExplicitWaitClassRoomActivity {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.leafground.com/window.xhtml");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//span[text()='Open Multiple']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		Boolean until1= wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		System.out.println(until1);

	}

}
