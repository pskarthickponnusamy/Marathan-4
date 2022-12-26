package page;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

import base.ProjectSpecificMethod;
import io.github.sukgu.Shadow;

public class HomePage extends ProjectSpecificMethod{
	public HomePage(ChromeDriver driver, Shadow shadow, ExtentTest node) {
		this.driver=driver;
		this.shadow=shadow;
		this.node=node;
	}
	public HomePage clickAll() {
		shadow.findElementByXPath("//div[text()='All']").click();
		return this;
	}
	public HomePage enterValueInFilter() throws IOException {
		WebElement filter = shadow.findElementByXPath("//input[@id='filter']");
		shadow.setImplicitWait(10);
		filter.click();
		filter.sendKeys("Callers");
		reportStep("filter is entered sucessfully","pass");
		return this;
	}
	public CallersPage clickCallers() throws InterruptedException, IOException {
		shadow.findElementByXPath("//span[text()='Callers']").click();
		Thread.sleep(3000);
		WebElement eleFrame = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(eleFrame);
		reportStep("Caller page is loaded sucessfully","pass");
		return new CallersPage(driver,shadow,node);
	}
}



