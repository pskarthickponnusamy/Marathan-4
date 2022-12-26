package testcase;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import page.LoginPage;

public class UpdateCallerTest extends ProjectSpecificMethod{
	@BeforeTest
	public void setUp() {
		filename="UpdateCaller";
		testName="Update Caller Test";
		testDescription="Update Caller Test";
		testAuthor="Karthick";
		testType="Smoke";
	}
	@Test(dataProvider = "fetchData")
	public void update(String uname,String pWord,String Fname,String Uphone) throws IOException, InterruptedException {
		LoginPage loginPage = new LoginPage(driver, shadow, node);
		loginPage.enterPassWord(pWord).enterUserName(uname).clickLogin()
		.clickAll().enterValueInFilter().clickCallers().searchCaller(Fname).clickPreViewButton()
		.clickOpenRecordButton().updateBusinessPhone(Uphone).clickUpdateButton();
		
	}
}
