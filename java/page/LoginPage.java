package page;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

import base.ProjectSpecificMethod;
import io.github.sukgu.Shadow;

public class LoginPage extends ProjectSpecificMethod{
	public LoginPage(ChromeDriver driver, Shadow shadow, ExtentTest node) {
		this.driver=driver;
		this.shadow=shadow;
		this.node=node;
	}
	public LoginPage enterUserName(String uName) {
		driver.findElement(By.id("user_name")).sendKeys(uName);
		return this;
	}
	public LoginPage enterPassWord(String pWord) {
		driver.findElement(By.id("user_password")).sendKeys(pWord);
		return this;
	}
	public HomePage clickLogin() throws InterruptedException, IOException {
		driver.findElement(By.id("sysverb_login")).click();
		Thread.sleep(5000);
		reportStep("Loged in   sucessfully","pass");
		return new HomePage(driver,shadow,node);
		
	}
}


