package base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;
import util.ExcelData;

public class ProjectSpecificMethod {
	public ChromeDriver driver;
	public String filename;
	public static ExtentReports extentReports;
	public ExtentTest test,node;
	public String testName,testDescription,testAuthor,testType;
	public Shadow shadow;
	
	@BeforeSuite
	public void startReport() {
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./reports/result.html");
		reporter.setAppendExisting(true);
		extentReports = new ExtentReports();
		extentReports.attachReporter(reporter);
	}
	@BeforeClass
	public void testCaseDetail() {
		test = extentReports.createTest(testName,testDescription);
		test.assignAuthor(testAuthor);
		test.assignCategory(testType);
	}

	public int takeSnapshot() throws IOException {
		int ranNum =(int)(Math.random()*999999)+1000000;
		File source = driver.getScreenshotAs(OutputType.FILE);
		File destination = new File("./snap/img"+ranNum+".png");
		FileUtils.copyFile(source, destination);
		return ranNum;
	}
	public void reportStep(String stepDescription, String status) throws IOException {
		if(status.equalsIgnoreCase("pass")) {
			node.pass(stepDescription,MediaEntityBuilder.createScreenCaptureFromPath(".././snap/img"+takeSnapshot()+".png").build());
		}else if(status.equalsIgnoreCase("fail")){
			node.fail(stepDescription,MediaEntityBuilder.createScreenCaptureFromPath(".././snap/img"+takeSnapshot()+".png").build());
			throw new RuntimeException("Please look the report for failure");
		}
	}
	@AfterSuite
	public void stopReport() {
		extentReports.flush();
	}
	@BeforeMethod
	public void startBrowser() throws InterruptedException {
		node = test.createNode(testName);
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://dev119706.service-now.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		shadow = new Shadow(driver);
		shadow.setImplicitWait(30);
			
	}
	@AfterMethod
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
		
	}
	@DataProvider(name = "fetchData")
	public String[][] getData() throws IOException{
		String[][]data=ExcelData.readlData(filename);
		return data;
	}
}
