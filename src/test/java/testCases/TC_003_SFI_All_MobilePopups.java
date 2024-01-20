package testCases;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import pageObjects.Android.IndvControls;
import pageObjects.Android.SectionControlsPage;
import testBase.Android.BaseTest;
import utilities.ExcelUtility;
import utilities.Android.SurveyFormReUsables;
import utilities.Android.UtilityCustomFunctions;


public class TC_003_SFI_All_MobilePopups extends BaseTest{
	Logger	logger = LogManager.getLogger(this.getClass());
	@BeforeTest
	public void testName() {
		test = extent.createTest("TC_001_SFI_All_Mobile");
	}
	
	@Test(alwaysRun = true)
	public void TestMobileIndividualControls() throws Exception {
	try{
		node = test.createNode("SFI Mobile Form");
		SurveyFormReUsables oSFR = new SurveyFormReUsables(driver);
		IndvControls IndvObj = new IndvControls(driver);
		SectionControlsPage SecObj = new SectionControlsPage(driver);
		logger.info("******starting TC_001_SFI_All_Mobile ****");
		String sBrowserName=utilities.Android.UtilityCustomFunctions.getBrowserName(driver);
		logger.info("Test Execution on Browser: "+ sBrowserName);
		System.out.println("Test Execution on Browser: "+ sBrowserName);
	//	try{
			
//			String sPath=".\\testData\\" + "SFI_AllMobile_Tbl_Live" + ".xlsx" ;
			String sPath=".\\testData\\" + "SFI_AllMobile_Tbl_RThree" + ".xlsx" ;
			
			
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
			String sExpMC_Title = xlObj.getCellData("Sheet1", 1, 4);
			String sExpMC_Value = xlObj.getCellData("Sheet1", 1, 5);
			String sExpXQ_Title = xlObj.getCellData("Sheet1", 1, 6);
			String sExpXQ_Value = xlObj.getCellData("Sheet1", 1, 7);
			String sExpEM_Title = xlObj.getCellData("Sheet1", 1, 8);
			String sExpEM_Value = xlObj.getCellData("Sheet1", 1, 9);
			String sExpPN_Title = xlObj.getCellData("Sheet1", 1, 10);
			String sExpPN_Value = xlObj.getCellData("Sheet1", 1, 11);
			String sExpAP_Title = xlObj.getCellData("Sheet1", 1, 12);
			
			String sExpAP_Value = xlObj.getCellData("Sheet1", 1, 13);
			
			String sExpMS_Title = xlObj.getCellData("Sheet1", 1, 14);
			String sExpMS_Value = xlObj.getCellData("Sheet1", 1, 15);
			String sExpLS_Title = xlObj.getCellData("Sheet1", 1, 16);
			String sExpLS_Value = xlObj.getCellData("Sheet1", 1, 17);
			String sExpNM_Title = xlObj.getCellData("Sheet1", 1, 18);
			String sExpNM_Value = xlObj.getCellData("Sheet1", 1, 19);
			String sExpRG_Title = xlObj.getCellData("Sheet1", 1, 20);
			String sExpRG_Value = xlObj.getCellData("Sheet1", 1, 21);
			String sExpRT_Title = xlObj.getCellData("Sheet1", 1, 22);
			String sExpRT_Value = xlObj.getCellData("Sheet1", 1, 23);
			String sExpOS_Title = xlObj.getCellData("Sheet1", 1, 24);
			String sExpOS_Value = xlObj.getCellData("Sheet1", 1, 25);
			String sExpDT_Title = xlObj.getCellData("Sheet1", 1, 26);
			String sExpDT_Value = xlObj.getCellData("Sheet1", 1, 27);
			
			String sExpLK_Title = xlObj.getCellData("Sheet1", 1, 28);
			String sExpLK_Value = xlObj.getCellData("Sheet1", 1, 29);
			String sExpTQ_Title = xlObj.getCellData("Sheet1", 1, 30);
			String sExpTQ_Value = xlObj.getCellData("Sheet1", 1, 31);
			String sExpPM_Title = xlObj.getCellData("Sheet1", 1, 32);
			String sExpPM_Value = xlObj.getCellData("Sheet1", 1, 33);
			String sExpYN_Title = xlObj.getCellData("Sheet1", 1, 34);
			String sExpYN_Value = xlObj.getCellData("Sheet1", 1, 35);
			String sExpAG_Title = xlObj.getCellData("Sheet1", 1, 36);
			String sExpAG_Value = xlObj.getCellData("Sheet1", 1, 37);
			String sExpRM_Title = xlObj.getCellData("Sheet1", 1, 38);
			String sExpRM_Value = xlObj.getCellData("Sheet1", 1, 39);
			
			String sExpGM_Title = xlObj.getCellData("Sheet1", 1, 40);
			String sExpGM_Value = xlObj.getCellData("Sheet1", 1, 41);
			String sExpVR_Title = xlObj.getCellData("Sheet1", 1, 42);
			String sExpVR_Value = xlObj.getCellData("Sheet1", 1, 43);
			String sExpUF_Title = xlObj.getCellData("Sheet1", 1, 44);
			String sExpUF_Value = xlObj.getCellData("Sheet1", 1, 45);
			
			String sExpUF_Prefix = xlObj.getCellData("Sheet1", 1, 46);
			String sExpPN_Prefix = xlObj.getCellData("Sheet1", 1, 47);
			String sExpAG_Response = xlObj.getCellData("Sheet1", 1, 48);
			
			logger.info("Extracting DataSheet Values Completed...");
//			Launch Url
			oSFR.fLaunchUrl(driver, sExpBuildUrl);
			//URL Validation 
			logger.info("Survey Form Url Launched..");
			String sActBuildUrl = driver.getCurrentUrl();
			if(sActBuildUrl.trim().equalsIgnoreCase(sExpBuildUrl)) {
				freport(sExpBuildUrl, "pass", node);
				logger.info("Build Url Pass");
			}
			else {
				logger.info("Build Url failing");
				freport("Browser URL Not Correct" , "fail",node);
				Assert.fail("Url Failed");
			}
			
			//Message Control Validation
			if(IndvObj.bIsMessageTitleDisplayed()) {
				String sActTxtMessageTitle = IndvObj.getSFMessage();
				oSFR.fSoftAssert(sActTxtMessageTitle.trim(), sExpTxtMessageTitle, "Message Title", node);
				logger.info("Message Control Title Passed");
//			 	Click Message Next
				IndvObj.clickMessageNext();
				Thread.sleep(1000);
				}
				else {
					logger.info("Message control Missing");
					freport("Message Control Missing" , "fail",node);
					Assert.fail("Message Control Not Displayed");
				}

			
//			MultiChoice Control Validation
			if(IndvObj.bIsMultiChoiceDisplayed()) {

				String sActMC_Title = IndvObj.getMultiChoiceTitle();
				logger.info(sActMC_Title +"Actual Title ");
				System.out.println(sActMC_Title);
				oSFR.fSoftAssert(sActMC_Title.trim(), sExpMC_Title, "MultiChoice Control Title",node);
				IndvObj.selectOneItem(sExpMC_Value);
				logger.info("MultiChoice Item Selected");
				freport("MultiChoice Item Selected:" +sExpMC_Value , "pass",node);
				}
			else
				{
				logger.info("MultiChoice control Missing");
				freport("MultiChoice Control Missing" , "fail",node);
				Assert.fail("MultiChoice Not Displayed");
			}
			
			Thread.sleep(1000);
			IndvObj.clickGeneralNext();
			logger.info("MultiChoice Next Clicked");
			Thread.sleep(1000);
//			TextQuestion Control Validation
			if (IndvObj.bIsTextQuestionDisplayed()) {
				freport("Text Question Conrol Present", "pass", node);
				logger.info("Text Question Conrol Present");
				String sActTX_Title = IndvObj.getGeneralTitle();
				oSFR.fSoftAssert(sActTX_Title.trim(), sExpXQ_Title, "TextQuestion Control Title", node);
				logger.info("Validation of TextQuestion Control Title");
				IndvObj.setTextAnswer(sExpXQ_Value);
				logger.info("Text Entered in TextAnswer Control");
				freport("Text Entered in TextAnswer Control:" + sExpXQ_Value, "pass", node);
				
			} else {
				freport("Text Question Conrol Missing", "fail", node);
				logger.info("Text Question Conrol Missing");
				Assert.fail("Text Question Conrol Missing");
			}
			IndvObj.clickGeneralNext();
			logger.info("Text Question Next Clicked");
			
	//		Email Control
			if(IndvObj.bEmailPresent()) {
				freport("Email Control Present" , "pass",node);
				logger.info("Email Control Present");
				String sActEM_Title = IndvObj.getGeneralTitle();
				oSFR.fSoftAssert(sActEM_Title.trim(),sExpEM_Title,"Email Control Title",node);
				logger.info("Validation of Email Control Title") ;
				IndvObj.setEmail(sExpEM_Value);
				logger.info("Email Id Entered") ;
				freport("Email Id Entered:" +sExpEM_Value , "pass",node);
				
			}else {
				freport("Email Control Missing" , "fail",node);
				logger.info("Email Control Missing");
				Assert.fail("Email Control Missing");
			}
			IndvObj.clickGeneralNext();
			logger.info("Email Next Clicked") ;
			Thread.sleep(1000);
//			PhoneNumber Control Validation
			if(IndvObj.bIsPhoneNoDisplayed()) {
				String sActPN_Title = IndvObj.getGeneralTitle();
				oSFR.fSoftAssert(sActPN_Title.trim(),sExpPN_Title,"Phone Number Control Title",node);
				logger.info("Validation of PhoneNumber Control Title") ;
				Thread.sleep(1000);
				 freport("Phone Number Conrol Present" , "pass",node);
				 logger.info("Phone Number Conrol Present");
				 IndvObj.setPhoneNumber(sExpPN_Value);
				 freport("Phone Number Entered: " +sExpPN_Value , "pass",node);
				 logger.info("Phone Number Entered");
					
			}
			else {
				 freport("Phone Number Conrol Missing" , "fail",node);
				 logger.info("Phone Number Conrol Missing");
				 Assert.fail("PhoneNumber Missing");
			}
			Thread.sleep(1000);
			IndvObj.clickPhoneNumberNext();
			logger.info("PhoneNumber Next Clicked") ;
			Thread.sleep(1000);
			
			//Appointment
			 if(IndvObj.bIsAppointmentDisplayed()) {
				 Thread.sleep(1000);
					String sAppFullTime = "";
					IndvObj.clickBookAppointment();
					logger.info("Appointment Clicked");
					IndvObj.clickApptChooseDate();
					boolean bIsDataAvail = false;
					boolean bNewMonth = false;

					do {
						bIsDataAvail = IndvObj.setAppointmentDate(bNewMonth);
						System.out.println("No Date Available In this Month: " + bIsDataAvail);
						bNewMonth = true;
					} while (bIsDataAvail == false);

					Thread.sleep(1000);
					sAppFullTime = IndvObj.getBtnApptMsg();
					sAppFullTime = sAppFullTime.replace("Date", "Appointment Date");
					xlObj.setCellData("Sheet1", 1, 13, sAppFullTime);
					logger.info("Appointment Updated to Datasheet");
					System.out.println(sAppFullTime);

					sExpAP_Value = sAppFullTime;
					logger.info("Appointment Time Captured in Expected Value");
					freport("Appointment Time Captured: " + sAppFullTime, "pass", node);
					Thread.sleep(1000);
			 }
			 else {
				 freport("Appointment Control Missing", "fail", node);
				 logger.info("Appointment Conrol Missing");
				 Assert.fail("Appointment Control Missing");
			 }
			 IndvObj.clickGeneralNext();
			 logger.info("Appointment Next Button clicked");
			 Thread.sleep(1000);
//			MultiSelect Control Validation
			if(IndvObj.bIsMultiSelectDisplayed()) {
				String sActMS_Title = IndvObj.getSecGenTitle();
				oSFR.fSoftAssert(sActMS_Title.trim(),sExpMS_Title,"MultiSelect Control Title",node);
				logger.info("Validation of MultiSelect Control Title") ;
				//Set MultiSelectValue
				IndvObj.setDropdownMS(sExpMS_Value);
				logger.info("MultiSelect Value Selected") ;
				freport("MultiSelect Value Selected: " +sExpMS_Value , "pass",node);
				
			}
			else {
				 freport("MultiSelect Control Missing", "fail", node);
				 logger.info("MultiSelect Conrol Missing");
				 Assert.fail("MultiSelect Control Missing");
			}
			//MultiSelect Next Clicked
			IndvObj.clickGeneralNext();
			logger.info("MultiSelect Next Clicked");
			Thread.sleep(1000);
			// List
			if (IndvObj.bIsListDisplayed()) {
				freport("List Control Present", "pass", node);
				logger.info("List Conrol Present");
				String sActLS_Title = IndvObj.getSecGenTitle();
				oSFR.fSoftAssert(sActLS_Title.trim(), sExpLS_Title, "List Control Title", node);
				logger.info("Validation of List Control Control Title");
				IndvObj.clickListInput();
				Thread.sleep(1000);
				IndvObj.selectListItem(sExpLS_Value);
				logger.info("List Item Selected " + sExpLS_Value);
				freport("List Item Selected : " + sExpLS_Value, "pass", node);
			} else {
				freport("List Conrol missing", "fail", node);
				logger.info("List Conrol missing");
				Assert.fail("List Conrol missing");
			}
			IndvObj.clickGeneralNext();
			logger.info("List Next Clicked");
			Thread.sleep(1000);
			//Number
			if(IndvObj.bIsNumberDisplayed()) {
				 freport("Number Control Present" , "pass",node);
				 logger.info("Number Control Present");
				 IndvObj.setNumber(sExpNM_Value);
				 logger.info("Number Selected " + sExpNM_Value);
				 freport("Number Selected " + sExpNM_Value , "pass",node);
			}
			else {
				freport("Number Control Missing" , "fail",node);
				logger.info("Number Control Missing");
				Assert.fail("Number Control Missing");
			}
			IndvObj.clickGeneralNext();
			logger.info("Number Next Clicked");
			Thread.sleep(1000);
			//Range
			if(IndvObj.bIsRangeDisplayed()) {
				freport("Range Conrol Present" , "pass",node);
				 logger.info("Range Conrol Present");
				String sActRG_Title = IndvObj.getSecGenTitle();
				oSFR.fSoftAssert(sActRG_Title.trim(),sExpRG_Title,"Range Control Title",node);
				logger.info("Validation of Range Control Control Title") ;
				 
				 IndvObj.setRange(Integer.parseInt(sExpRG_Value));
				 logger.info("Range Selected " + sExpRG_Value);
				 freport("Range Selected " + sExpRG_Value , "pass",node);
			}
			else {
				logger.info("Range control Missing");
				freport("Range Conrol missing" , "fail",node);
				Assert.fail("Range Conrol missing");
			}
			IndvObj.clickGeneralNext();
			logger.info("Range Next Clicked");
			Thread.sleep(1000);
			//Rating
			if(IndvObj.bIsRatingDisplayed()) {
			logger.info("Rating control Present");
			freport("Rating Conrol present" , "pass",node);
			String sActRT_Title = IndvObj.getSecGenTitle();
			oSFR.fSoftAssert(sActRT_Title.trim(),sExpRT_Title,"Rating Control Title",node);
			logger.info("Validation of Rating Control Control Title") ;
			boolean bRatingPresent = false;
			bRatingPresent = IndvObj.clickMatchingLabel(sExpRT_Value);
			if(bRatingPresent==true) {
				logger.info("Rating Value: " + sExpRT_Value + "Clicked");
				freport("Rating Value: " + sExpRT_Value , "pass",node);	
			}
			else {
				logger.info("Rating Value: " + sExpRT_Value + " missing");
				freport("Rating Value: " + sExpRT_Value , "fail",node);
			}
			}else {
				logger.info("Rating control Missing");
				freport("Rating Conrol missing" , "fail",node);
				Assert.fail("Rating Conrol missing");
				
			}
			IndvObj.clickGeneralNext();
			logger.info("Rating Next Clicked");
			Thread.sleep(1000);
			// Opinion scale 
			if(IndvObj.bIsOpinionScaleDisplayed()) {
				freport("Opinion Scale Present", "pass", node);
				logger.info("Opinion Scale Conrol Present");
				String sActOS_Title = IndvObj.getSecGenTitle();
				oSFR.fSoftAssert(sActOS_Title.trim(), sExpOS_Title, "Opinion Scale Control Title", node);
				logger.info("Validation of Opinion Scale Control Title");
				// Verify Opinion Scale control present else fail.
				boolean bIsOSSelected;
				bIsOSSelected = IndvObj.selectOneItem(sExpOS_Value);
				if (bIsOSSelected == true) {
					logger.info("Opinion Scale Control: " + sExpOS_Value + "Clicked");
					freport("Opinion Scale: " + sExpOS_Value, "pass", node);
				} else {
					logger.info("Opinion Scale control: " + sExpOS_Value + " missing");
					freport("Opinion Scale: " + sExpOS_Value, "fail", node);
				}
			}
			else {
				freport("Opinion Scale Present", "fail", node);
				logger.info("Opinion Scale Conrol missing");
				Assert.fail("Opinion Scale Conrol Missing");
			}
			IndvObj.clickGeneralNext();
			logger.info("Opinion Scale Next Clicked");
			Thread.sleep(1000);
			//Date
			if(IndvObj.bIsDateDisplayed()) {
			freport("Date Control Present", "pass", node);
			logger.info("Date Conrol Present");	
			 boolean bDateReturnValue = false;
			 bDateReturnValue = IndvObj.setDate("No");
			 if(bDateReturnValue==false) {
				 bDateReturnValue = IndvObj.setDate("Yes");
			 }
			 Thread.sleep(1000);
			 String sDateSelected = IndvObj.getDateSelected();
			 sExpDT_Value = sDateSelected;
			 xlObj.setCellData("Sheet1", 1, 27, sDateSelected);
			 logger.info("Date Value Updated to DataSheet");
			 freport("Date Selected : " + sDateSelected  , "pass",node);
		     System.out.println(sDateSelected);
			}
			else {
				freport("Date Control Missing", "fail", node);
				logger.info("Date Conrol Missing");
				Assert.fail("Date Control Missing");
			}
			 IndvObj.clickGeneralNext();
			 logger.info("Date Next Clicked");
			 Thread.sleep(1000);
			
			 //Links Validation
			 if(IndvObj.bIsLinksControlDisplayed()) {
			  freport("Links Control Present", "pass", node);
			  logger.info("Links Conrol Present");
					
			 String sActLK_Title = IndvObj.getSecGenTitle();
			 oSFR.fSoftAssert(sActLK_Title.trim(),sExpLK_Title,"Link Control Title",node);
			 logger.info("Validation of Link Control Title" + sActLK_Title) ;
			 
			 System.out.println("Link Value:" +sExpLK_Value);
			 //IndvObj.clickLinks(sExpLK_Value);
			 logger.info("Multiple Links Clicked") ;
			 }else {
				 freport("Links Control Present", "fail", node);
				  logger.info("Links Conrol Missing");
				  Assert.fail("Links Conrol Missing");
				 
			 }	
			 IndvObj.clickGeneralNext();
			 logger.info("Links Next Clicked");
			 Thread.sleep(1000);
			//ThankYou Control
			 if(IndvObj.bIsThankYouDisplayed()) {
				 Thread.sleep(1000);
				 logger.info("ThankYou control Present");
				 freport("ThankYou Control Present" , "pass",node);
				 String sActTQ_Title = IndvObj.getGeneralTitle();
				 oSFR.fSoftAssert(sActTQ_Title.trim(),sExpTQ_Title,"ThankYou Control Title",node);
				 logger.info("Validation of ThankYou Control Title" + sActTQ_Title) ;
			 }
			 else {
				 logger.info("ThankYou control Missing");
				 freport("ThankYou Control Missing" , "fail",node);
				 Assert.fail("ThankYou Control Not Displayed");
			 }
			 IndvObj.clickThankYouGo();
			 logger.info("ThankYou Next Clicked");	
			// Picture Message Control
				if (IndvObj.bIsPictureMessageDisplayed()) {
					freport("Picture Message Control Present", "pass", node);
					logger.info("Picture Message Control Present");
					Thread.sleep(1000);
					 String sActPM_Title = IndvObj.getPicMsgTitle();
					 oSFR.fSoftAssert(sActPM_Title.trim(),sExpPM_Title,"Picture Message Control Title",node);
					 logger.info("Validation of Picture Message Control Title" + sActPM_Title) ;
					 
					 Thread.sleep(1000);
					 IndvObj.clickPictMsgMatchLabel(sExpPM_Value);
					 logger.info("Picture Message Seleted:" + sExpPM_Value);
					 freport("Picture Message Selected:" + sExpPM_Value , "pass",node);
					
				} else {
					freport("Picture Message Control Missing", "fail", node);
					logger.info("Picture Message Conrol Missing");
					Assert.fail("Picture Message Control Missing");
				}
					Thread.sleep(1000);
					IndvObj.clickGeneralNext();
					logger.info("Picture Message Next Clicked");
					Thread.sleep(1000);
			 
			// Yes or No
				if (IndvObj.bIsYesorNoDisplayed()) {
					freport("YesorNO Control Present", "pass", node);
					logger.info("YesorNo Control Present");
					String sActYN_Title = IndvObj.getGeneralTitle();
					oSFR.fSoftAssert(sActYN_Title.trim(), sExpYN_Title, "Yes or No Control Title", node);
					logger.info("Validation of YesorNo Control Title" + sActYN_Title);
					//set Yes or No
					IndvObj.clickYesorNo(sExpYN_Value);
					freport("Yes or No Seleted:" + sExpYN_Value, "pass", node);
					logger.info(sExpYN_Value + " Clicked");

				} else {
					freport("Yes or No Control Missing", "fail", node);
					logger.info("Yes or No Control missing");
					Assert.fail("Yes or No Control missing");
				}
				//Yes or No Next Clicked
				IndvObj.clickGeneralNext();
				logger.info("YesorNo Next Clicked");
				Thread.sleep(1000);
			 
				//Agreement Control	
				if (IndvObj.bIsAgreementDisplayed()) {
					freport("Agreement Conrol Present", "pass", node);
					logger.info("Agreement Question Conrol Present");
					String sActAG_Title = IndvObj.getSecGenTitle();
					oSFR.fSoftAssert(sActAG_Title.trim(), sExpAG_Title, "Agreement Control Title", node);
					logger.info("Validation of Agreement Control Title" + sActAG_Title);
					String sActAG_Text = IndvObj.getAgreementMsg();
					oSFR.fSoftAssert(sActAG_Text.trim(), sExpAG_Value, "Agreement Text", node);
					logger.info("Validation of Agreement Text" + sActAG_Text);
					Thread.sleep(1000);
					
				} else {
					freport("Agreement Conrol Missing", "fail", node);
					logger.info("Agreement Conrol Missing");
					Assert.fail("Agreement Conrol Missing");
				}
				IndvObj.clickGeneralNext();
				logger.info("Agreement Next Clicked");
				Thread.sleep(1000);
				//Rank Matrix Control
				if(IndvObj.bIsRankMatrixDisplayed()) {
					logger.info("RankMatrix control present");
					freport("RankMatrix Control present" , "pass",node);
					String sActRM_Title = IndvObj.getSecGenTitle();
					oSFR.fSoftAssert(sActRM_Title.trim(),sExpRM_Title,"Ranking Matrix Title",node);
					logger.info("Validation of Rank Matrix Control Title" + sActRM_Title);
					freport("RankMatrix Control Present" , "pass",node);
					IndvObj.setRankingMatrix(sExpRM_Value);
					logger.info("Ranking Matrix Values Selected");
					freport("Ranking Matrix Values Selected:" + sExpRM_Value , "pass",node);
				}
				else {
					logger.info("RankMatrix control Missing");
					freport("RankMatrix Control Missing" , "fail",node);
					Assert.fail("RankMatrix Not Displayed");
				}//Rank Matrix Displayed
				IndvObj.clickGeneralNext();
				logger.info("Ranking Matrix Next Clicked");
				Thread.sleep(1000);
				
				
//				System.out.println("All Contexts " + driver.getContextHandles());
//				logger.info("All Contexts " + driver.getContextHandles());
//				Thread.sleep(1000);
//				
//				Thread.sleep(1000);
//				//GoogleMap Control
//				if(IndvObj.bIsGoogleMapDisplayed()) {
//					freport("Google Map Control Present" , "pass",node);
//					logger.info("Google Map Control Present");
//						driver.context("NATIVE_APP");
//						Thread.sleep(1000);
//						IndvObj.clickAndroidLinkAllow();
//						Thread.sleep(3000);
//						IndvObj.clickAndroidAllowRecord();
//						driver.context("CHROMIUM");
//					   String sActGM_Title = IndvObj.getSecGenTitle();
//					   oSFR.fSoftAssert(sActGM_Title.trim(),sExpGM_Title,"Google Map Title",node);
//					   logger.info("Validation of Google Map Control Title" + sActGM_Title) ;
//					   Thread.sleep(1000);
//					   //Enter GoogleMap Values
//						IndvObj.setGoogleMapAddress(sExpGM_Value);
//						freport("Google Map Address Entered:" + sExpGM_Value , "pass",node);
//						logger.info("Address Entered in Google Map");
//						
//						}else {
//							logger.info("Google Map Control Missing");
//							freport("Google Map Control Missing" , "fail",node);
//							Assert.fail("Google Map Control Missing");
//					}
//				Thread.sleep(1000);
//				IndvObj.clickGeneralNext();
//				logger.info("Google Map Next Clicked");
//			
////VR
//			
//				//VR Control
//				if(IndvObj.bIsVRDisplayed()) {
//					 logger.info("VR control present");
//					 freport("Voice Record Control present" , "pass",node);
//					 Thread.sleep(1000);
//					 String sActVR_Title = IndvObj.getSecGenTitle();
//					 oSFR.fSoftAssert(sActVR_Title.trim(),sExpVR_Title,"Voice Record Title",node);
//					 logger.info("Validation of Voice Record Control Title" + sActVR_Title) ;
//					 
//					IndvObj.clickMic();
//					Thread.sleep(2000);
//					System.out.println("All Contexts 2nd time " + driver.getContextHandles());
//					logger.info("All Contexts " + driver.getContextHandles());
//					driver.context("NATIVE_APP");
//					System.out.println("Switched to Native App");
//					Thread.sleep(3000);
//					IndvObj.clickAndroidLinkAllow();
//					Thread.sleep(4000);
//					IndvObj.clickAndroidAllowRecord();
//					driver.context("CHROMIUM");
//					Thread.sleep(5000);
//					IndvObj.clickStop();
//					String sCurrDate = utilities.Android.UtilityCustomFunctions.getCurrentDate("ddMMyyyy");
//					String sPrefixVR="voice_record_" + sCurrDate;
//					logger.info("Voice Recorded");
//					freport("Voice Recorded:" + sPrefixVR , "pass",node);
//					//Update it to Excel sheet
//					xlObj.setCellData("Sheet1", 1, 43, sPrefixVR);
//					sExpVR_Value = xlObj.getCellData("Sheet1", 1, 43);
//					logger.info("Voice Record Prefix updated to Datasheet");
//				}
//				else {
//					logger.info("VR control Missing");
//					freport("Voice Record Control Missing" , "fail",node);
//					Assert.fail("Voice Record Not Displayed");
//				}
//				Thread.sleep(2000);
//				IndvObj.clickGeneralNext();
//				logger.info("Voice Record Next Clicked");
//			
//			// File Upload
//			if (IndvObj.bIsFileUploadDisplayed()) {
//				IndvObj.clickAndroidAllowRecord();
//				freport("FileUpload Control Present", "pass", node);
//				logger.info("FileUpload Conrol Present");
//				String sActUF_Title = IndvObj.getSecGenTitle();
//				oSFR.fSoftAssert(sActUF_Title.trim(), sExpUF_Title, "File Upload Control Title", node);
//				logger.info("Validation of File Upload Control Title");
//				//set file
//				IndvObj.SelectFiletoUpload(sExpUF_Value);
//				Thread.sleep(3000);
//				freport("File Selected : " + sExpUF_Value, "pass", node);
//				//update value to DataTable
//				String sGetCurrDate = UtilityCustomFunctions.getCurrentDate("ddMMyyyy");
//				String sUF_Prefix = "formshow_" + sGetCurrDate;
//				System.out.println("File Uploaded");
//				xlObj.setCellData("Sheet1", 1, 46, sUF_Prefix);
//				logger.info("Upload file prefix added to Datasheet");
//				
//			} else {
//				freport("FileUpload Control Missing", "fail", node);
//				logger.info("FileUpload Conrol Missing");
//				Assert.fail("FileUpload control Missing");
//			}
//			IndvObj.clickGeneralNext();
//			logger.info("FileUpload Next Clicked");
//			Thread.sleep(1000);
			 
	}	catch(Exception e) {
		System.out.println(e.getCause());
		Assert.fail(e.getMessage());
	}//try catch
			
	}
}
