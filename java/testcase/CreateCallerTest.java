package testcase;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import page.LoginPage;

public class CreateCallerTest extends ProjectSpecificMethod{
	@BeforeTest
	public void setUp() {
		filename="CreateCaller";
		testName="Create Caller Test";
		testDescription="Create Caller Test";
		testAuthor="Karthick";
		testType="Smoke";
	}
	@Test(dataProvider = "fetchData")
	public void CreateTest(String uName,String pword, String fname, String lname, String title, String email, String bPhone, String mPhone) throws InterruptedException, IOException {
		LoginPage loginPage = new LoginPage(driver, shadow,node);
		loginPage.enterUserName(uName).enterPassWord(pword).clickLogin()
		.clickAll().enterValueInFilter().clickCallers()
		.clickCreateNewCaller()
		.enterFirstName(fname).enterLastName(lname).enterTitle(title)
		.enterEmailID(email).enterBusinessPhone(bPhone).enterMobilePhone(mPhone).clickSubmitButton()
		.searchCaller(fname);

	}

}
