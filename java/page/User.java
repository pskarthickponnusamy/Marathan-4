package page;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

import base.ProjectSpecificMethod;
import io.github.sukgu.Shadow;

public class User extends ProjectSpecificMethod {

	public User(ChromeDriver driver, Shadow shadow, ExtentTest node) {
		this.driver=driver;
		this.shadow=shadow;
		this.node=node;
	}
	public User updateBusinessPhone(String ubNumber) {
		WebElement updatePhoneNumber = driver.findElement(By.id("sys_user.phone"));
		updatePhoneNumber.clear();
		updatePhoneNumber.sendKeys(ubNumber);
		return this;
	}
	public CallersPage clickUpdateButton() throws IOException {
		driver.findElement(By.xpath("//button[@id='sysverb_update_bottom']")).click();
		reportStep("Caller is updated sucessfully","pass");
		return new CallersPage(driver, shadow, node);
	}
	public User clickDeleteButton() throws IOException {
		driver.findElement(By.xpath("//button[@id='sysverb_delete_bottom']")).click();
		reportStep("Delete Button is clicked sucessfully","pass");
		return this;
	}
	public CallersPage acceptWarrning() throws IOException {
		driver.findElement(By.id("ok_button")).click();
		reportStep("Caller is Deleted sucessfully","pass");
		return new CallersPage(driver, shadow,node);
	}

}
