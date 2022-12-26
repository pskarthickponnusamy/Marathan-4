package page;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

import base.ProjectSpecificMethod;
import io.github.sukgu.Shadow;

public class CreateCallerPage extends ProjectSpecificMethod{
	public CreateCallerPage(ChromeDriver driver, Shadow shadow, ExtentTest node) {
		this.driver=driver;
		this.shadow=shadow;
		this.node=node;
	}
	public CreateCallerPage enterFirstName(String fNme) {
		driver.findElement(By.xpath("//input[@id='sys_user.first_name']")).sendKeys(fNme);
		return this;
	}
	public CreateCallerPage enterLastName(String lName) {
		driver.findElement(By.id("sys_user.last_name")).sendKeys(lName);
		return this;
	}
	public CreateCallerPage enterEmailID(String email) {
		driver.findElement(By.id("sys_user.email")).sendKeys(email);
		return this;
	}
	public CreateCallerPage enterTitle(String title) {
		driver.findElement(By.id("sys_user.title")).sendKeys(title);
		return this;
	}
	public CreateCallerPage enterBusinessPhone(String bPhone) {
		driver.findElement(By.id("sys_user.phone")).sendKeys(bPhone);
		return this;
	}
	public CreateCallerPage enterMobilePhone(String mPhone) {
		driver.findElement(By.id("sys_user.mobile_phone")).sendKeys(mPhone);
		return this;
	}
	public CallersPage clickSubmitButton() throws InterruptedException, IOException {
		reportStep("content is entered sucessfully","pass");
		driver.findElement(By.id("sysverb_insert_bottom")).click();
		Thread.sleep(3000);
		reportStep("Caller is created sucessfully","pass");
		return new CallersPage(driver,shadow,node );
	}
}