package utilities.Browser;

import java.io.IOException;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.android.AndroidDriver;
import pageObjects.Android.SectionControlsPage;
import testBase.Browser.BaseClass;
import utilities.Browser.*;

public class SurveyFormReUsables extends BaseClass{
	
	
	public SurveyFormReUsables(WebDriver driver) {
		this.driver = driver;
	}

	Logger logger = LogManager.getLogger(this.getClass());

	//SurveyFormReUsables a = new SurveyFormReUsables();
	public static void sendKeys(WebDriver webDriver, WebElement element, String keyValue) {
		try {
			//JavascriptExecutor js = (JavascriptExecutor) webDriver;
			//js.executeScript("arguments[0].scrollIntoView();", element);
			WebDriverWait webWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
			webWait.until(ExpectedConditions.elementToBeClickable(element));
			webWait.until(ExpectedConditions.visibilityOf(element));
			element.clear();
			Actions action = new Actions(webDriver);
			action.moveToElement(element).doubleClick().build().perform();
			element.sendKeys(keyValue);
		}
		catch(Exception e){
			System.out.println(e.getStackTrace());
		}
	}
	
	public static void fLaunchUrl(WebDriver driver,String sUrl) {
		try {
		driver.navigate().to(sUrl);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		}catch (Exception e) {
			//Assert.fail("Browser Launch failed");
			System.out.println(e.getCause());
		}
	}
	
	public static void fVerifyValue(String sActValue, String sExpValue,String sMessage) {
		try {
			Assert.assertEquals(sActValue.trim(), sExpValue.trim(),sMessage);
			
		}catch(Exception e) {
			Assert.fail(sMessage + " Failed");
		}
	}
	
	/*
	public void fSoftAssert(String sActValue, String sExpValue,String sMessage,ExtentTest Node,String log) throws IOException, InterruptedException {
		BaseTest a = new BaseTest();
		if(sActValue.trim().equalsIgnoreCase(sExpValue.trim())) {
			if(log.equalsIgnoreCase("BaseTest")) {
			a.logger.info(sMessage + " Passed : Actual Value is: " +sActValue + "Expected Value is: "+sExpValue);
			a.freport(sMessage, "Pass",Node);
			}
			else {
				logger.info(sMessage + " Passed : Actual Value is: " +sActValue + "Expected Value is: "+sExpValue);
				freport(sMessage, "Pass",Node);
			}
		}
		else {
			if(log.equalsIgnoreCase("BaseTest")) {
					a.logger.info(sMessage + " Failed : Actual Value is: " +sActValue + "Expected Value is: "+sExpValue);
					a.freport(sMessage, "fail",Node);
				}
				else {
					logger.info(sMessage + " Failed : Actual Value is: " +sActValue + "Expected Value is: "+sExpValue);
					freport(sMessage, "fail",Node);
				}
		}
		
	}*/
	
	public void fSoftAssert(String sActValue, String sExpValue,String sMessage,ExtentTest Node) throws IOException, InterruptedException {
		BaseClass b = new BaseClass();
		if(sActValue.trim().equalsIgnoreCase(sExpValue.trim())) {
			logger.info(sMessage + " Passed : Actual Value is: " +sActValue + "Expected Value is: "+sExpValue);
			b.freport(sMessage, "Pass",Node);
			
		}
		else {
			logger.info(sMessage + " Failed : Actual Value is: " +sActValue + "Expected Value is: "+sExpValue);
			b.freport(sMessage, "fail",Node);
			
			
		}
		
	}
	public static void SelectMultiValues (String sChoiceValues) {
		sChoiceValues.split(",");
	}
		public void ValidateAllIndResp(WebDriver driver,boolean bQuestion,String sExpValue,int iXpathIndex,String sValMessage,boolean isContains,ExtentTest Node) throws InterruptedException {
		try {
		System.out.println("Inside ValidateAllResp function");
		
		String sActRespVal="";
		String xPathWithVariable="";
		WebElement iframe1 = driver.findElement(By.xpath("(//iframe[@title='Form preview'])[1]"));
		driver.switchTo().frame(iframe1);
		if(bQuestion==true) {
			System.out.println("Inside If true");
			 xPathWithVariable = "(//label[@class='epsf-ans-myqlbl'])" + "[" + iXpathIndex + "]";
			
			Thread.sleep(1000);
			sActRespVal = driver.findElement(By.xpath(xPathWithVariable)).getText();
			
		}
		else
		{
			System.out.println("Inside If false");
			 xPathWithVariable = "(//label[@class='epsf-ans-ans'])" + "[" + iXpathIndex + "]";
			sActRespVal = driver.findElement(By.xpath(xPathWithVariable)).getText();
			
		}// get Actual response value
		System.out.println("Actual value is: " + sActRespVal);
		System.out.println("Expected value is: " + sExpValue);
		WebElement element = driver.findElement(By.xpath(xPathWithVariable));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		System.out.println(isContains);
		if(isContains==false) {

		logger.info(sValMessage + " Expected Value:" + sExpValue + " Actual Value: " + sActRespVal );
	
		
		
		fSoftAssert(sActRespVal.trim(),sExpValue,sValMessage,Node);
		
		}
		else {
			if(sExpValue!="") {
			boolean bResult = sActRespVal.contains(sExpValue);
			System.out.println("Actual Value is: " + sActRespVal + "Expected Value: " + sExpValue + " And is Contains is: " + bResult);
//			BaseTest.sAssertinFn.assertTrue(bResult,sValMessage);
			
			fSoftAssert(String.valueOf(bResult),"true",sValMessage,Node);
			
			}
			else {
				System.out.println(sValMessage + " Expected value is empty in Datasheet");
			}
		}//if isContains
	}catch (Exception e) {
		System.out.println(e.getCause());
		Assert.fail(sValMessage);
	}//try catch
		driver.switchTo().defaultContent();
}//method
	

	
}//class