package week4.day2;

import java.time.Duration;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.sukgu.Shadow;

public class ArchitectCertifications {

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

		driver.findElement(By.xpath("//span[contains(text(),'Learn ')]")).click();

		//Handling Windows
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> window = new ArrayList<String>(windowHandles);
		System.out.println("Total Opened Windows: "+window.size());

		driver.switchTo().window(window.get(1));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();

		//Shadow DOM
		Shadow dom = new Shadow(driver);
		dom.findElementByXPath("//span[text()='Learning']").click();
		Thread.sleep(3000);

		WebElement moveto = dom.findElementByXPath("//span[text()='Learning on Trailhead']");

		//Performing mouse hover actions
		Actions act = new Actions(driver);
		act.moveToElement(moveto).perform();

		WebElement scroll = dom.findElementByXPath("//a[text()='Salesforce Certification']");
		act.scrollToElement(scroll).perform();
		Thread.sleep(3000);
		scroll.click();


		driver.findElement(By.xpath("(//div[@class='roleMenu-item_text'])[2]")).click();
		String Url = driver.getCurrentUrl();
		System.out.println("The Current URL is : "+Url);

		WebElement element = driver.findElement(By.xpath("//div[contains(@class,'cert-site_text')]"));
		String text = element.getText();
		System.out.println("The Text Summary is : "+text);

		List<String> cer = new ArrayList<String>();
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='credentials-card_title']/a"));
		System.out.println("Total Salesforce certifications available are :"+list.size() );
		for (int i = 0; i < list.size(); i++) {

			String name = list.get(i).getText();
			cer.add(name);

		}
		System.out.println("The names of salesforce certification :"+cer);
		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[text()='Application Architect']")).click();


		List<String> arc = new ArrayList<String>();
		List<WebElement> list1 = driver.findElements(By.xpath("//div[@class='credentials-card_title']/a"));
		System.out.println("Total Application Architect certifications available are :"+list1.size() );
		for (int i = 0; i < list1.size(); i++) {

			String name1 = list1.get(i).getText();
			arc.add(name1);

		}
		System.out.println("The names of Application Architect certification :"+arc);
		driver.quit();
	}

}
