package testCases;

import java.io.File;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import pageObjects.Android.IndvControls;
import testBase.Android.BaseTest;
import testBase.Android.NewBase;
import testBase.Android.AppiumServer;
import utilities.ExcelUtility;
import utilities.Android.SurveyFormReUsables;

public class TC002_SFI_MBPopups extends BaseTest {
	Logger	logger = LogManager.getLogger(this.getClass());

	@BeforeTest()
	public void testName() throws MalformedURLException, AppiumServerHasNotBeenStartedLocallyException, InterruptedException {
		test = extent.createTest("TC002_SFI_MBPopups");
	}
	@Test
	public void TestMobilePopupControls() throws Exception {
		System.out.println("Test Execution started...");
		node = test.createNode("MobilePopups");
		IndvControls IndvObj = new IndvControls(driver);
		SurveyFormReUsables oSFR = new SurveyFormReUsables(driver);
		System.out.println("Page Objects started...");
		logger.info("******starting TC002_SFI_MBPopups ****");
		String sBrowserName=utilities.Android.UtilityCustomFunctions.getBrowserName(driver);
		System.out.println("Found Browser Name...");
		logger.info("Test Execution on Browser: "+ sBrowserName);
		System.out.println("Test Execution on Browser: "+ sBrowserName);
	//	try{
			String sPath=".\\testData\\" + "SFI_AllMobilePopups_Tbl_Rthree" + ".xlsx" ;
			
			ExcelUtility xlObj = new ExcelUtility(sPath);
			logger.info("Excel file Utility instance created");
		
			int iRowCount = xlObj.getRowCount("Sheet1");
			System.out.println("Total rows: " + iRowCount);
			logger.info("Row Count is: " + iRowCount);
			
		
			int iColCount = xlObj.getCellCount("Sheet1", iRowCount);
			System.out.println("Cols: " + iColCount);
			logger.info("Col Count is: " + iColCount);
						
			logger.info("Extracting DataSheet Values started...");
			String sExpBuildUrl = xlObj.getCellData("Sheet1", 1, 0);
			String sExpBuildName = xlObj.getCellData("Sheet1", 1, 1);
			String sExpExcelFileName = xlObj.getCellData("Sheet1", 1, 2);
			String sExpTxtMessageTitle = xlObj.getCellData("Sheet1", 1, 3);
			String sExpGM_Title = xlObj.getCellData("Sheet1", 1, 4);
			String sExpGM_Value = xlObj.getCellData("Sheet1", 1, 5);
			String sExpVR_Title = xlObj.getCellData("Sheet1", 1, 6);
			String sExpVR_Value = xlObj.getCellData("Sheet1", 1, 7);
			String sExpUF_Title = xlObj.getCellData("Sheet1", 1, 8);
			String sExpUF_Value = xlObj.getCellData("Sheet1", 1, 9);
			String sExpUF_Prefix = xlObj.getCellData("Sheet1", 1, 10);
			oSFR.fLaunchUrl(driver, sExpBuildUrl);
//			freport(sExpBuildUrl, "pass",node);
			logger.info("Survey Form Section Controls Url Launched..");
			
			Thread.sleep(5000);
			//Upload file
			 String sActUF_Title = IndvObj.getSecGenTitle();
			 oSFR.fSoftAssert(sActUF_Title.trim(),sExpUF_Title,"File Upload Control Title",node);
			 logger.info("Validation of File Upload Control Title") ;

			 IndvObj.SelectFiletoUpload(sExpUF_Value);
			 Thread.sleep(3000);
			 System.out.println("After media clicked");
			 Set<String> fcontextNames = driver.getContextHandles();
		        for (String strContextName : fcontextNames) {
		            if (strContextName.contains("NATIVE_APP")) {
		                driver.context("NATIVE_APP");
		                break;
		            }
		        }
			 Thread.sleep(3000);
			 boolean btest = IndvObj.IsMediaFirstItemDisplayed();
			 System.out.println(btest);
			 if(IndvObj.IsMediaFirstItemDisplayed()) {
				 IndvObj.clickMediaFirstItm();
			 }
			 else {
				 System.out.println("Media item not displayed");
			 }
			   Set<String> contextNames1 = driver.getContextHandles();
		        for (String strContextName : contextNames1) {
		            if (strContextName.contains("CHROMIUM")) {
		                driver.context("CHROMIUM");
		                break;
		            }
		        }
		        
			 Thread.sleep(3000);
			 freport("File Selected : " + sExpUF_Value  , "pass",node);
			 String sGetCurrDate =utilities.Android.UtilityCustomFunctions.getCurrentDate("ddMMyyyy");
			 String sUF_Prefix = "formshow_" + sGetCurrDate;
			 System.out.println("File Uploaded");
			 xlObj.setCellData("Sheet1", 1, 10, sUF_Prefix);
			 logger.info("Upload file prefix added to Datasheet");
			 Thread.sleep(3000);
			 IndvObj.clickGeneralNext();
			 logger.info("FileUpload Next Clicked");
			 Thread.sleep(3000);
//			--------------------------------------------------------			 
			System.out.println("Before Google Map context");
			Set<String> gmcontextNames = driver.getContextHandles();
	        for (String strContextName : gmcontextNames) {
	            if (strContextName.contains("CHROMIUM")) {
	                driver.context("CHROMIUM");
	                break;
	            }
	        }
	        Thread.sleep(1000);
	        System.out.println("After Google Map context");
			if(IndvObj.bIsGoogleMapDisplayed()) {
				System.out.println("Within Google Map context");
//				freport("Google Map Control Present" , "pass",node);
				logger.info("Google Map Control Present");
				Thread.sleep(3000);
				System.out.println("Set Context NativeApp for GM");
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
				Thread.sleep(3000);
				if(IndvObj.bIsAllowLocPopup())
				{
					IndvObj.clickAndroidLinkAllowLocation();
				}
				Thread.sleep(3000);
				
			    Thread.sleep(1000);
			    if(IndvObj.bIsAllowPermission()) {
			    	IndvObj.clickAndroidAllowPermission();
			    }else {
			    	System.out.println("Allow permission popup not displayed");
			    }
			    //set context to chromium
			    Set<String> gbcontextNames = driver.getContextHandles();
		        for (String strContextName : gbcontextNames) {
		            if (strContextName.contains("CHROMIUM")) {
		                driver.context("CHROMIUM");
		                break;
		            }
		        }
				System.out.println("Context back to chromium in GM");
				String sActGM_Title = IndvObj.getSecGenTitle();
				oSFR.fSoftAssert(sActGM_Title.trim(),sExpGM_Title,"Google Map Title",node);
				logger.info("Validation of Google Map Control Title" + sActGM_Title) ;
				System.out.println("Google Map title validated");
				Thread.sleep(3000);
//				//Enter GoogleMap Values
				System.out.println("Expected GM Value to be entered is: " + sExpGM_Value);
				IndvObj.setGoogleMapAddress(sExpGM_Value);
//				freport("Google Map Address Entered:" + sExpGM_Value , "pass",node);
				logger.info("Address Entered in Google Map");
				System.out.println("Address Entered in Google Map");
				}else {
						logger.info("Google Map Control Missing");
//						freport("Google Map Control Missing" , "fail",node);
						Assert.fail("Google Map Control Missing");
				}
			Thread.sleep(3000);
			IndvObj.clickGeneralNext();
			logger.info("Google Map Next Clicked");
			Thread.sleep(3000);
			
//			//VR Control
			if(IndvObj.bIsVRDisplayed()) {
				 logger.info("VR control present");
//				 freport("Voice Record Control present" , "pass",node);
				 Thread.sleep(1000);
				 String sActVR_Title = IndvObj.getSecGenTitle();
				 oSFR.fSoftAssert(sActVR_Title.trim(),sExpVR_Title,"Voice Record Title",node);
				 logger.info("Validation of Voice Record Control Title" + sActVR_Title) ;
				 System.out.println("VR Title Validated");
				IndvObj.clickMic();
				System.out.println("VR Mic Clicked");
				 Set<String> vrcontextNames = driver.getContextHandles();
			     for (String strContextName : vrcontextNames) {
			         if (strContextName.contains("NATIVE_APP")) {
			           driver.context("NATIVE_APP");
			           System.out.println("Switched to Native App");
			           break;
			         }
			     }
			     Thread.sleep(3000);
					if(IndvObj.bIsAllowLocPopup())
					{
						IndvObj.clickAndroidLinkAllowLocation();
					}
					Thread.sleep(3000);
					try {
					if(IndvObj.bIsAllowPermission()) {
				    	IndvObj.clickAndroidAllowPermission();
				    }else {
				    	System.out.println("Allow permission popup not displayed");
				    }
					}catch(Exception e) {
						System.out.println(e.getCause());
					}
					Set<String> vr1contextNames = driver.getContextHandles();
			        for (String strContextName : vr1contextNames) {
			            if (strContextName.contains("CHROMIUM")) {
			                driver.context("CHROMIUM");
			                System.out.println("Switched back to Chromium in VR");
			                break;
			            }
			        }
				Thread.sleep(5000);
				IndvObj.clickStop();
				System.out.println("VR Stop Clicked");
				String sCurrDate = utilities.Android.UtilityCustomFunctions.getCurrentDate("ddMMyyyy");
				String sPrefixVR="voice_record_" + sCurrDate;
				logger.info("Voice Recorded");
//				freport("Voice Recorded:" + sPrefixVR , "pass",node);
				//Update it to Excel sheet
				xlObj.setCellData("Sheet1", 1, 43, sPrefixVR);
				sExpVR_Value = xlObj.getCellData("Sheet1", 1, 43);
				logger.info("Voice Record Prefix updated to Datasheet");
				System.out.println("VR Prefix added to datasheet");
			}
			else {
				logger.info("VR control Missing");
//				freport("Voice Record Control Missing" , "fail",node);
				Assert.fail("Voice Record Not Displayed");
			}
			Thread.sleep(2000);
			IndvObj.clickGeneralNext();
			logger.info("Voice Record Next Clicked");
//-----------------------------------------------------------------------------			
//			
//			Thread.sleep(1000);
//			String sActVR_Title = IndvObj.getSecGenTitle();
//			oSFR.fSoftAssert(sActVR_Title.trim(),sExpVR_Title,"Voice Record Title",node);
//			
//			logger.info("Validation of Voice Record Control Title" + sActVR_Title) ;
//			
//			IndvObj.clickMic();
//			Thread.sleep(1000);
//			System.out.println("All Contexts 2nd time " + driver.getContextHandles());
//			logger.info("All Contexts " + driver.getContextHandles());
//			driver.context("NATIVE_APP");
//			System.out.println("Switched to Native App");
//			Thread.sleep(1000);
//			IndvObj.clickAndroidLinkAllowLocation();
//		
//			Thread.sleep(3000);
//			IndvObj.clickAndroidAllowPermission();
//			driver.context("CHROMIUM");
//			Thread.sleep(5000);
//			IndvObj.clickStop();
//			String sCurrDate = utilities.Android.UtilityCustomFunctions.getCurrentDate("ddMMyyyy");
//			String sPrefixVR="voice_record_" + sCurrDate;
//			logger.info("Voice Recorded");
//			freport("Voice Recorded:" + sPrefixVR , "pass",node);
//			//Update it to Excel sheet
//			xlObj.setCellData("Sheet1", 1, 43, sPrefixVR);
//			sExpVR_Value = xlObj.getCellData("Sheet1", 1, 43);
//			logger.info("Voice Record Prefix updated to Datasheet");
//			Thread.sleep(2000);
//			IndvObj.clickGeneralNext();
//			logger.info("Voice Record Next Clicked");
			
			
				 
			 
			
			 
		
	}//Test
	

}
