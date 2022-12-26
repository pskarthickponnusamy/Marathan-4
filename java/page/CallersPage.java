package page;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

import base.ProjectSpecificMethod;
import io.github.sukgu.Shadow;

public class CallersPage extends ProjectSpecificMethod{
	public CallersPage(ChromeDriver driver, Shadow shadow, ExtentTest node) {
		this.driver=driver;
		this.shadow=shadow;
		this.node=node;
	}
	public CreateCallerPage clickCreateNewCaller() throws IOException {
		driver.findElement(By.xpath("//button[@id='sysverb_new']")).click();
		reportStep("clickCreateNewCallersucessfully","pass");
		return new CreateCallerPage(driver,shadow,node);
	}
	public CallersPage searchCaller(String fNme) throws InterruptedException, IOException {
		WebElement search = driver.findElement(By.xpath("//input[@class='form-control']"));
		Thread.sleep(8000);
		search.clear();
		search.sendKeys(fNme,Keys.RETURN);
		reportStep("searchCaller sucessfully","pass");
		return this;
	}
	public CallersPage clickPreViewButton() throws IOException {
		driver.findElement(By.xpath("(//a[contains(@class,'btn btn-icon')])[2]")).click();
		reportStep("Preview is opened sucessfully","pass");
		return this;
	}
	public User clickOpenRecordButton() throws IOException {
		driver.findElement(By.linkText("Open Record")).click();
		reportStep("Record is opened sucessfully","pass");
		return new User(driver,shadow,node);
	}
}
