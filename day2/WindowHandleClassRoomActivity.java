package week4.day2;



import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WindowHandleClassRoomActivity {

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
		
		driver.findElement(By.xpath("//span[contains(text(),'Learn ')]")).click();
		Thread.sleep(3000);
		
		//String windowHandle = driver.getWindowHandle();
		//System.out.println(windowHandle);
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> window = new ArrayList<String>(windowHandles);
		System.out.println("Total Opened Windows: "+window.size());
		
		
		driver.switchTo().window(window.get(1));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		String title = driver.getTitle();
		System.out.println(title);
		driver.close();
		
		driver.switchTo().window(window.get(0));
		Thread.sleep(3000);
		String title1 = driver.getTitle();
		System.out.println(title1);
		driver.quit();
		
		
		
		
		
		
		
	}

}
