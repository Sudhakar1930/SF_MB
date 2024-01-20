package testCases;

import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.Android.IndvControls;
import pageObjects.Android.SectionControlsPage;
import testBase.Android.BaseTest;
import utilities.ExcelUtility;
import utilities.Android.SurveyFormReUsables;
import utilities.Android.UtilityCustomFunctions;

public class TC_004_SFS_All_MobilePopups extends BaseTest{
	Logger logger = LogManager.getLogger(this.getClass());
	@BeforeTest
	public void testName() {
		test = extent.createTest("TC_002_SFS_All_Mobile");
	}
	@Test(alwaysRun = true)
	public void testSectionContrls() throws Exception {
		node = test.createNode("Section_Controls_In_Mobile");
		SurveyFormReUsables oSFRSC = new SurveyFormReUsables(driver);
		
		logger.info("******starting TC_002_SFS_All_Mobile ****");
		String sBrowserName=utilities.Android.UtilityCustomFunctions.getBrowserName(driver);
		logger.info("Test Execution on Browser: "+ sBrowserName);
		System.out.println("Test Execution on Browser: "+ sBrowserName);
		try{
			
			
			IndvControls IndvObj = new IndvControls(driver);
			SectionControlsPage SecObj = new SectionControlsPage(driver);
			
//			String sPath=".\\testData\\" + "SFS_AllMobile_Tbl_Live" + ".xlsx" ;
			String sPath=".\\testData\\" + "SFS_AllMobile_Tbl_Rthree" + ".xlsx" ;
			


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
			String sExpSectionTitle = xlObj.getCellData("Sheet1", 1, 3);
			String sExpTxtMessageTitle = xlObj.getCellData("Sheet1", 1, 4);
			
			String sExpMC_Title = xlObj.getCellData("Sheet1", 1, 5);
			String sExpMC_Value = xlObj.getCellData("Sheet1", 1, 6);
			String sExpXQ_Title = xlObj.getCellData("Sheet1", 1, 7);
			String sExpXQ_Value = xlObj.getCellData("Sheet1", 1, 8);
			String sExpEM_Title = xlObj.getCellData("Sheet1", 1, 9);
			String sExpEM_Value = xlObj.getCellData("Sheet1", 1, 10);
			String sExpPN_Title = xlObj.getCellData("Sheet1", 1, 11);
			String sExpPN_Value = xlObj.getCellData("Sheet1", 1, 12);
			String sExpAP_Title = xlObj.getCellData("Sheet1", 1, 13);
			String sExpAP_Value = xlObj.getCellData("Sheet1", 1, 14);
			String sExpMS_Title = xlObj.getCellData("Sheet1", 1, 15);
			String sExpMS_Value = xlObj.getCellData("Sheet1", 1, 16);
			String sExpLS_Title = xlObj.getCellData("Sheet1", 1, 17);
			String sExpLS_Value = xlObj.getCellData("Sheet1", 1, 18);
			String sExpNM_Title = xlObj.getCellData("Sheet1", 1, 19);
			String sExpNM_Value = xlObj.getCellData("Sheet1", 1, 20);
			String sExpRG_Title = xlObj.getCellData("Sheet1", 1, 21);
			String sExpRG_Value = xlObj.getCellData("Sheet1", 1, 22);
			String sExpRT_Title = xlObj.getCellData("Sheet1", 1, 23);
			String sExpRT_Value = xlObj.getCellData("Sheet1", 1, 24);
			String sExpOS_Title = xlObj.getCellData("Sheet1", 1, 25);
			String sExpOS_Value = xlObj.getCellData("Sheet1", 1, 26);
			String sExpDT_Title = xlObj.getCellData("Sheet1", 1, 27);
			String sExpDT_Value = xlObj.getCellData("Sheet1", 1, 28);
			String sExpLK_Title = xlObj.getCellData("Sheet1", 1, 29);
			String sExpLK_Value = xlObj.getCellData("Sheet1", 1, 30);
			String sExpTQ_Title = xlObj.getCellData("Sheet1", 1, 31);
			String sExpTQ_Value = xlObj.getCellData("Sheet1", 1, 32);
			String sExpPM_Title = xlObj.getCellData("Sheet1", 1, 33);
			String sExpPM_Value = xlObj.getCellData("Sheet1", 1, 34);
			String sExpYN_Title = xlObj.getCellData("Sheet1", 1, 35);
			String sExpYN_Value = xlObj.getCellData("Sheet1", 1, 36);
			String sExpAG_Title = xlObj.getCellData("Sheet1", 1, 37);
			String sExpAG_Value = xlObj.getCellData("Sheet1", 1, 38);
			String sExpRM_Title = xlObj.getCellData("Sheet1", 1, 39);
			String sExpRM_Value = xlObj.getCellData("Sheet1", 1, 40);
			String sExpGM_Title = xlObj.getCellData("Sheet1", 1, 41);
			String sExpGM_Value = xlObj.getCellData("Sheet1", 1, 42);
			String sExpVR_Title = xlObj.getCellData("Sheet1", 1, 43);
			String sExpVR_Value = xlObj.getCellData("Sheet1", 1, 44);
			String sExpUF_Title = xlObj.getCellData("Sheet1", 1, 45);
			String sExpUF_Value = xlObj.getCellData("Sheet1", 1, 46);
			
			String sExpUF_Prefix = xlObj.getCellData("Sheet1", 1, 47);
			String sExpPN_Prefix = xlObj.getCellData("Sheet1", 1, 48);
			String sExpAG_Response = xlObj.getCellData("Sheet1", 1, 49);
			
			logger.info("Extracting DataSheet Values Completed...");
			
			oSFRSC.fLaunchUrl(driver, sExpBuildUrl);
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
			Thread.sleep(3000);
//			System.out.println("All Contexts " + driver.getContextHandles());
//			logger.info("All Contexts " + driver.getContextHandles());
//			Set contextNames = driver.getContextHandles();
//			System.out.println("cibtext suze "+contextNames.size());
//			if(contextNames.size()>1) {
//				System.out.println("Inside the context if");
//				Thread.sleep(3000);
//				driver.context("NATIVE_APP");
//				Thread.sleep(5000);
//				IndvObj.clickAndroidLinkAllow();
//				driver.context("CHROMIUM");
//				Thread.sleep(2000);	
//			}
//			System.out.println("outside the context if");
			//Validation of Section Title
			String sActSectionTitle = IndvObj.getGeneralTitle();
			oSFRSC.fSoftAssert(sActSectionTitle.trim(), sExpSectionTitle.trim(), "Section Title",node);
			logger.info("Section Title Validation done: " +sActSectionTitle );
			
			//Validation of Message Control Title
			SecObj.fValidateSectionLabels(driver, 1, sExpTxtMessageTitle, "Message Control Title",node);
			
			//Multi Choice Label Validation
			SecObj.fValidateSectionLabels(driver, 2, sExpMC_Title, "MultiChoice Control Title",node);
			//Select MultiChoice Value
			IndvObj.selectOneItem(sExpMC_Value);
			logger.info("MultiChoice Item Selected : " + sExpMC_Value);
			freport("MultiChoice Item Selected : " + sExpMC_Value, "pass",node);
			//TextQuestion Title
			SecObj.fValidateSectionLabels(driver, 3, sExpXQ_Title, "TextQuestion Control Title",node);
			//TextQuestion Answer
			IndvObj.setTextAnswer(sExpXQ_Value);
			freport("Text Entered in TextAnswer Control", "pass",node);
			logger.info("Text Entered in TextAnswer Control") ;
			
			//Email Address Title
			SecObj.fValidateSectionLabels(driver, 4, sExpEM_Title, "Email Control Title",node);
			//Set Email Id
			IndvObj.setEmail(sExpEM_Value);
			freport("Email Id Entered", "pass",node);
			logger.info("Email Id Entered") ;
			
			Thread.sleep(1000);
			System.out.println("Phone Number: " + sExpPN_Value);
			//Phone Number Label
			SecObj.fValidateSectionLabels(driver, 5, sExpPN_Title, "Phone Number Control Title",node);
			//Enter Phone Number
			IndvObj.setPhoneNumber(sExpPN_Value);
			freport("Phone Number Entered", "pass",node);
			logger.info("Phone Number Entered");
			

			//Appointment Label
			Thread.sleep(5000);
			SecObj.fValidateSectionLabels(driver, 6, sExpAP_Title, "Appointment Control Title",node);
			String sAppFullTime="";
			IndvObj.clickBookAppointment();
			Thread.sleep(1000);
			logger.info("Appointment button Clicked");
			IndvObj.clickApptChooseDate();
			Thread.sleep(3000);
			boolean bIsDateAvail = false;
			boolean bNewMonth = false;
			do {
				bIsDateAvail=IndvObj.setApptDateInSection(bNewMonth);
				System.out.println("Is Date Available in curr Month: "+bIsDateAvail);
				bNewMonth = true;
			}while(bIsDateAvail==false);
			System.out.println("Outside of appoitment");
			Thread.sleep(4000);
			IndvControls.clickGeneralToast();
			
			Thread.sleep(1000);
			sAppFullTime = IndvObj.getBtnApptMsg();
			sAppFullTime = sAppFullTime.replace("Date", "Appointment Date");
			xlObj.setCellData("Sheet1", 1, 14, sAppFullTime);
			logger.info("Appointment Updated to Datasheet");
			System.out.println(sAppFullTime);
		
			sExpAP_Value = sAppFullTime;
			freport("Appointment Time Captured", "pass",node);
			logger.info("Appointment Time Captured in Expected Value");
			Thread.sleep(5000);
		
			//MultiSelect Title
			SecObj.fValidateSectionLabels(driver, 7, sExpMS_Title, "MultiSelect Control Title",node);
			Thread.sleep(1000);
			//MultiSelect Value
			Thread.sleep(5000);
			IndvObj.setDropdownMS(sExpMS_Value);
			logger.info("MultiSelect Value Selected") ;
			freport("MultiSelect Value Selected", "pass",node);
			//List
			SecObj.fValidateSectionLabels(driver, 8, sExpLS_Title, "List Control Title",node);
			Thread.sleep(2000);
			//List Value
			SecObj.clickListInput();
			logger.info("List Input Box Clicked ");
			freport("List Input Box Clicked ", "pass",node);
			Thread.sleep(2000);
			SecObj.SelectListItem(sExpLS_Value);
			freport("List Value selected: "+sExpLS_Value, "pass",node);
			logger.info("List Item Selected " + sExpLS_Value);
			
			//Number
			Thread.sleep(2000);
			SecObj.fValidateSectionLabels(driver, 9, sExpNM_Title, "Number Control Title",node);
			SecObj.setNumber(sExpNM_Value);
			logger.info("Number Selected " + sExpNM_Value);
			freport("Number Selected " + sExpNM_Value, "pass",node);
			
			//Range
			Thread.sleep(1000);
			SecObj.fValidateSectionLabels(driver, 10, sExpRG_Title, "Range Control Title",node);
			Thread.sleep(2000);
			SecObj.setSectionRange(Integer.parseInt(sExpRG_Value));
			
			logger.info("Range Selected " + sExpRG_Value);
			freport("Range Selected " + sExpRG_Value, "pass",node);
			//Rating
			Thread.sleep(1000);
			SecObj.fValidateSectionLabels(driver, 11, sExpRT_Title, "Rating Control Title",node);
			Thread.sleep(2000);
			IndvObj.clickMatchingLabel(sExpRT_Value);
			logger.info("Rating Value: " + sExpRT_Value + "Clicked");
			freport("Rating Value: " + sExpRT_Value + "Clicked", "pass",node);
			//Opinion Scale
			Thread.sleep(1000);
			SecObj.fValidateSectionLabels(driver, 12, sExpOS_Title, "Opinion Scale Control Title",node);
			SecObj.selectOneItem(sExpOS_Value);
			logger.info("Opinion Scale : " + sExpOS_Value + "Clicked");
			freport("Opinion Scale : " + sExpOS_Value + "Clicked", "pass",node);
			//Date
			Thread.sleep(1000);
			SecObj.fValidateSectionLabels(driver, 13, sExpDT_Title, "Date Control Title",node);
			 Thread.sleep(1000);
			boolean bDateReturnValue = false;
			 bDateReturnValue = IndvObj.setDate("No");
			 if(bDateReturnValue=false) {
				 bDateReturnValue = IndvObj.setDate("Yes");
			 }
			 System.out.println("Date Value Entered:");
			 Thread.sleep(2000);
			 
			 String sDateSelected = SecObj.getDateSelected();
			 System.out.println("Date Contorl value: " + sDateSelected);
			 sExpDT_Value = sDateSelected;
			 xlObj.setCellData("Sheet1", 1, 28, sDateSelected);
			 logger.info("Date Value Updated to DataSheet");
			 freport("Date Selected" + sExpDT_Value + "Clicked", "pass",node);
		     System.out.println(sDateSelected);
		     
		   //Links Control
			 Thread.sleep(1000);
			 SecObj.fValidateSectionLabels(driver, 14, sExpLK_Title, "Links Control Title",node);
			//Thank You Control
			 Thread.sleep(1000);
			 SecObj.fValidateSectionLabels(driver, 16, sExpTQ_Title, "ThankYou Control Title",node);
			 Thread.sleep(1000);
			 
			 //Picture Message Control
			 Thread.sleep(1000);
			 SecObj.fValidateSectionLabels(driver, 17, sExpPM_Title, "PictureMessage Control Title",node);
			 IndvObj.clickPictMsgMatchLabel(sExpPM_Value);
			 logger.info("Picture Message Seleted:" + sExpPM_Value);
			 freport("Picture Message Seleted:" + sExpPM_Value, "pass",node);
			 Thread.sleep(1000);
			 
			 //Yes or No
			 Thread.sleep(1000);
			 SecObj.fValidateSectionLabels(driver, 18, sExpYN_Title, "YesorNo Control Title",node);
			 IndvObj.clickYesorNo(sExpYN_Value);
			 logger.info("Yes or No Clicked" + sExpYN_Value);
			 freport("Yes or No Clicked" + sExpYN_Value, "pass",node);
			//Agreement Control
			 SecObj.fValidateSectionLabels(driver, 19, sExpAG_Title, "Agreement Control Title",node);
			 Thread.sleep(2000);
			 String sActAG_Text = SecObj.getAgreementMsg();
			 System.out.println("Actual agreement text is: " + sActAG_Text);
			 oSFRSC.fSoftAssert(sActAG_Text, sExpAG_Value, "Agreement Text",node);
			 logger.info("Validation of Agreement Text Actual is: " + sActAG_Text + " Expected is: " + sExpAG_Value) ;
			 
			 //Ranking Matrix
			 SecObj.fValidateSectionLabels(driver, 20, sExpRM_Title, "RankingMatrix Control Title",node);
			 Thread.sleep(1000);
			 IndvObj.setRankingMatrix(sExpRM_Value);
			 logger.info("Ranking Matrix Values Selected");
			 freport("Ranking Matrix Values Selected", "pass",node);
			 
//			 System.out.println("All Contexts " + driver.getContextHandles());
//			 logger.info("All Contexts " + driver.getContextHandles());
//			 driver.context("NATIVE_APP");
//			 Thread.sleep(5000);
//			 IndvObj.clickAndroidLinkAllow();
//			 driver.context("CHROMIUM");
			 
//			//Google Map Control
//			 SecObj.fValidateSectionLabels(driver, 23, sExpGM_Title, "GoogleMap Control Title",node);
//			 Thread.sleep(3000);
//			 SecObj.setGoogleMapAddress(sExpGM_Value);
//			 logger.info("Address Entered in Google Map");
//			 freport("Address Entered in Google Map"+sExpGM_Value, "pass",node);
//			 
//			//Voice Record Control
//			 SecObj.fValidateSectionLabels(driver, 22, sExpVR_Title, "VoiceRecord Control Title",node);
//			 Thread.sleep(1000);
//			 IndvObj.clickMic();
//			 System.out.println("All Contexts 2nd time " + driver.getContextHandles());
//			 logger.info("All Contexts " + driver.getContextHandles());
//			 driver.context("NATIVE_APP");
//			 System.out.println("Switched to Native App");
//			 Thread.sleep(3000);
//			 IndvObj.clickAndroidLinkAllow();
//			 Thread.sleep(3000);
//			 IndvObj.clickAndroidAllowRecord();
//			 driver.context("CHROMIUM");
//			 Thread.sleep(5000);
//			 IndvObj.clickStop();
//			 String sCurrDate = UtilityCustomFunctions.getCurrentDate("ddMMyyyy");
//			 String sPrefixVR="voice_record_" + sCurrDate;
//			 logger.info("Voice Recorded");
//			 freport("Voice Recorded", "pass",node);
//			 //Update it to Excel sheet
//				
//				xlObj.setCellData("Sheet1", 1, 44, sPrefixVR);
//				sExpVR_Value = xlObj.getCellData("Sheet1", 1, 44);
//				logger.info("Voice Record Prefix updated to Datasheet");
//				Thread.sleep(3000);	
//			 SecObj.clickVRUpload();
//			 Thread.sleep(1000);
			 
//			//FileUpload Control
//		     Thread.sleep(1000);
//			 SecObj.fValidateSectionLabels(driver, 23, sExpUF_Title, "FileUpload Control Title",node);
//			 
////			 SecObj.SelectFiletoUpload(sExpUF_Value);
//			 IndvObj.SelectFiletoUpload(sExpUF_Value);
//			 Thread.sleep(3000);
//			 logger.info("File Uploaded");
//			 freport("File uploaded: " + sExpUF_Value, "pass",node);
//			 String sGetCurrDate =UtilityCustomFunctions.getCurrentDate("ddMMyyyy");
//			 String sUF_Prefix = "formshow_" + sGetCurrDate;
//			 System.out.println("File Uploaded");
//			 xlObj.setCellData("Sheet1", 1, 47, sUF_Prefix);
//			 logger.info("Upload file prefix added to Datasheet");
			 
			 
			// IndvObj.clickGeneralNext();
			 SecObj.clickNextInSection();
			 
			 Thread.sleep(3000);
			 logger.info("Section UI Form Submitted");
			 
			 
			 
			
		}
		catch(Exception e) {
			System.out.println(e.getCause());
			Assert.fail(e.getMessage());
		}//try catch
	}//test
}//class	
