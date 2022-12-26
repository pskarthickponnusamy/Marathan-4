package caller;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class CreateNewCaller {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
		driver.manage().window().maximize();
		
		driver.get("https://dev57553.service-now.com/");
		
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("5$dJ*EFdhhW0");
		driver.findElement(By.id("sysverb_login")).click();
		Thread.sleep(5000);
		
		Shadow shadow = new Shadow(driver);
		shadow.setImplicitWait(30);
		shadow.findElementByXPath("//div[text()='All']").click();
		
		WebElement filter = shadow.findElementByXPath("//input[@id='filter']");
		shadow.setImplicitWait(10);
		filter.click();
		filter.sendKeys("Callers");
		shadow.findElementByXPath("//span[text()='Callers']").click();
		
		
		Thread.sleep(3000);
		WebElement eleFrame = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(eleFrame);
		
		driver.findElement(By.xpath("//button[@id='sysverb_new']")).click();
		
		
		driver.findElement(By.xpath("//input[@id='sys_user.first_name']")).sendKeys("Priyadharshini");
		driver.findElement(By.id("sys_user.last_name")).sendKeys("S");
		
		driver.findElement(By.id("sys_user.email")).sendKeys("xyz@gmail.com");
		driver.findElement(By.id("sys_user.title")).sendKeys("Tester");
		driver.findElement(By.id("sys_user.phone")).sendKeys("123456789");
		driver.findElement(By.id("sys_user.mobile_phone")).sendKeys("123456789");
		driver.findElement(By.id("sysverb_insert_bottom")).click();
		

		Thread.sleep(3000);
	
		WebElement search = driver.findElement(By.xpath("//input[@class='form-control']"));
		Thread.sleep(8000);
		search.clear();
		search.sendKeys("Priyadharshini",Keys.RETURN);
	}

}
