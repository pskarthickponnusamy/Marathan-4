package testcase;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import page.LoginPage;

public class DeleteCallerTest  extends ProjectSpecificMethod{
	@BeforeTest
	public void setUp() {
		filename="DeleteCaller";
		testName="Delete Caller Test";
		testDescription="Delete Caller Test";
		testAuthor="Karthick";
		testType="Smoke";
	}
	@Test(dataProvider = "fetchData")
	public void delete(String uName,String pWord, String fName) throws IOException, InterruptedException {
		LoginPage loginPage = new LoginPage(driver, shadow, node);
		loginPage.enterPassWord(pWord).enterUserName(uName).clickLogin()
		.clickAll().enterValueInFilter().clickCallers().searchCaller(fName).clickPreViewButton().clickOpenRecordButton()
		.clickDeleteButton().acceptWarrning();
	}
}
