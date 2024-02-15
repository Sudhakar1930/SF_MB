package testBase.Android;

import pageObjects.Android.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Media;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import io.appium.java_client.service.local.AppiumDriverLocalService;

import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import pageObjects.Android.IndvControls;
import pageObjects.Android.NavigatetoResponse;
import testBase.Browser.BaseClass;
import utilities.ExtentReportManager;
public class BaseTest extends ExtentReportManager {

	public AndroidDriver driver;
	protected static File file;
	AppiumServiceBuilder builder = new AppiumServiceBuilder();
	static AppiumDriverLocalService service;

Logger logger = LogManager.getLogger(this.getClass());
@BeforeClass
public void configureAppium() throws MalformedURLException, InterruptedException {
	
			builder.withAppiumJS(new File("C:\\Users\\Rsoft\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
			.withIPAddress("127.0.0.1")
			.usingPort(4723)
			.withTimeout(Duration.ofSeconds(20)).build().start();
	 AppiumDriverLocalService service = AppiumDriverLocalService.buildService(builder);
		service.start();
		System.out.println("Appium Url:" + service.getUrl());
		System.out.println("Is Server Running:" + service.isRunning());
	
	UiAutomator2Options options = new UiAutomator2Options();

	options.setDeviceName("RZCWA1JJM5L");
	options.setPlatformVersion("14.0");
	options.setPlatformName("Android");
	options.noReset();
	options.withBrowserName("Chrome");
	options.setAutomationName("UiAutomator2");
	options.noSign();
	options.autoGrantPermissions();
	
	driver = new AndroidDriver(new URL("http://0.0.0.0:4723"),options);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		 
	logger = LogManager.getLogger(this.getClass());
		
	 
	 
 }
 public void testname(String testname, String name) {
		test = extent.createTest(testname);
		node = test.createNode(name);
		extent.attachReporter(sparkReporter);
	}
 

	
	public String randomeString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return (generatedString);
	}

	public String randomeNumber() {
		String generatedString2 = RandomStringUtils.randomNumeric(10);
		return (generatedString2);
	}
	
	public String randomAlphaNumeric() {
		String st = RandomStringUtils.randomAlphabetic(4);
		String num = RandomStringUtils.randomNumeric(3);
		
		return (st+"@"+num);
	}
	
	public void NavigatetoResponse(String strBuildName,AndroidDriver driver) throws Exception {
		IndvControls IndvObj = new IndvControls(driver);
		logger.info("Navigation started");
		//driver.close();
		//driver = new ChromeDriver();
		NavigatetoResponse obj = new NavigatetoResponse(driver);
		driver.get("https://rthree.live/");
//		driver.get("https://rbot.live/");
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		obj.setEmailId("rbot.live@gmail.com");
		obj.setPassword("12345678");
		logger.info("Login details Entered");
		obj.clickSubmit();
		logger.info("Chat bot Logged In");
		Thread.sleep(15000);
		obj.clickTopMenu();
		
		System.out.println("Set Context Native App");
		Set<String> gContextNames = driver.getContextHandles();
        for (String strContextName : gContextNames) {
            if (strContextName.contains("NATIVE_APP")) {
                driver.context("NATIVE_APP");
                break;
            }
        }
        Thread.sleep(3000);
		System.out.println("Native app set ");
//		Thread.sleep(5000);
//		obj.clickBrowserMenu();
//		Thread.sleep(5000);
//		obj.clickDesktopSite();
//		Thread.sleep(5000);

//		obj.action_clickOnPosition(92, 322);
		Thread.sleep(5000);
		 //set context to chromium
	    Set<String> gbcontextNames = driver.getContextHandles();
        for (String strContextName : gbcontextNames) {
            if (strContextName.contains("CHROMIUM")) {
                driver.context("CHROMIUM");
                break;
            }
        }
		System.out.println("Context back to chromium in NavigatetoResponse");
		Thread.sleep(5000);
		obj.clickClearAll();
		logger.info("clear all button clicked on listbox");
		obj.setBuildName(strBuildName);
		logger.info("Build Name entered in List Box");
		Thread.sleep(3000);
		logger.info("Waited for 3 secs");
//		obj.KeyEnterBuildName();
		logger.info("Enter Key applied on ListBox");
		Thread.sleep(1000);
		logger.info("Hard Wait for 1 sec");
		System.out.println("Set Context Native App");
		Set<String> lContextNames = driver.getContextHandles();
        for (String strContextName : lContextNames) {
            if (strContextName.contains("NATIVE_APP")) {
                driver.context("NATIVE_APP");
                break;
            }
        }
        Thread.sleep(3000);
        System.out.println("Native App Set");
        obj.action_clickOnPosition(87, 322);
        Thread.sleep(3000);
        
        
//		obj.clickSideBarBldBtn();
		logger.info("clicked side bar Build button once");
		Thread.sleep(1000);
		logger.info("Hard Wait for 1 sec");
		/*
		obj.clickSideBarBldBtn();
		logger.info("clicked side bar Build button twice");
		
		Thread.sleep(1000);
		
		logger.info("Hard Wait for 1 sec");
		*/
		obj.clickSideBarResult();
		logger.info("clicked side bar Result");
		obj.clickSideItemResp();
		logger.info("Side Item Response clicked");
		obj.clickRefreshResponse();
		logger.info("clicked refresh Response");
		obj.clickRefreshResponse();
		logger.info("clicked refresh Response Again");
		Thread.sleep(3000);
		obj.clickFirstResponse();
		logger.info("Clicked first Response");
	}
	
	
	public void freport(String dec, String status,ExtentTest node) throws IOException, InterruptedException {
		Media img = null;
		String filepath = "";
		
		long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L;
		System.err.println(number);
		try {
		String date = new SimpleDateFormat("dd-MMM-yy").format(new Date());
		String date1 = new SimpleDateFormat("HH.mm").format(new Date());
		filepath= "./reports/Screenshots/"+date+"/"+ date1 +"_"+ number + ".jpg";
		Thread.sleep(1000);		
		file = new File(filepath);
		
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		FileUtils.copyFile(takesScreenshot.getScreenshotAs(OutputType.FILE),
					file);
			
//		img = MediaEntityBuilder.createScreenCaptureFromPath(System.getProperty("user.dir")+"/reports/Screenshots/"+date+"/"+date1+"_"+number+".jpg").build();
		img = MediaEntityBuilder.createScreenCaptureFromPath("./../Screenshots/"+date+"/"+date1+"_"+number+".jpg").build();
		
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		if(status.equalsIgnoreCase("pass")) {
			System.err.println("Before node Pass");
			node.pass(dec, img);
			System.out.println(dec + " : " + "pass");

		}else if (status.equalsIgnoreCase("fail")) {
			System.err.println("Before node Fail");
			node.fail(dec, img);
			System.err.println(dec + " : After node Fail");
		}
		}

// public void tearDown() {
//	 driver.quit();
//     service.stop();
// }
}
