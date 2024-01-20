package testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//import pageObjects.Browser.IndvControls;
import pageObjects.Browser.SectionControlsPage;
import pageObjects.Browser.IndvControls;
import testBase.Browser.BaseClass;

import utilities.ExcelUtility;
import utilities.Browser.*;

public class TC_004_SFS_All_MobilePopupResponse extends BaseClass{
	
	Logger	logger = LogManager.getLogger(this.getClass());
	@BeforeTest
	public void testName() {
		test = extent.createTest("TC_002_SFS_All_MobileResponse");
	}
	@Test(alwaysRun = true)
	public void testMobileSectionContrls() throws Exception {
		try {
		node = test.createNode("SectionControlsInSection");
		
		SurveyFormReUsables oSFRSC = new SurveyFormReUsables(driver);
		SectionControlsPage SecObj = new SectionControlsPage(driver);
		IndvControls IndvObj = new IndvControls(driver);
		
		logger.info("******starting TC_002_SFS_All_MobileResponse ****");
		String sBrowserName=utilities.Browser.UtilityCustomFunctions.getBrowserName(driver);
		
		logger.info("Test Execution on Browser: "+ sBrowserName);
		System.out.println("Test Execution on Browser: "+ sBrowserName);
//		try{
			
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
			
			Thread.sleep(5000);
			NavigatetoResponse(sExpBuildName, driver);
			logger.info("Navigated to Build: " + sExpBuildName);
			
			SecObj.setFrameFormPreview();
			 String sActRespSectionTitle = SecObj.getSectionTitle();
			 //BaseClass.sAssertinFn.assertEquals(sActRespSectionTitle.trim(), sExpSectionTitle.trim(),"Section Title in Response");
			 boolean bResponseSecTitle = sActRespSectionTitle.contains(sExpSectionTitle.trim());
			 sAssertinFn.assertTrue(bResponseSecTitle,"Section Title in Response Validation");
			 logger.info("Section Title in Response : " +sActRespSectionTitle);
			 driver.switchTo().defaultContent();
			 oSFRSC.ValidateAllIndResp(driver,true,sExpTxtMessageTitle,1,"Message Title in Response",false,node);
			 oSFRSC.ValidateAllIndResp(driver,true,sExpMC_Title,2,"Multi Choice Question in Response",false,node);
			 oSFRSC.ValidateAllIndResp(driver,false,sExpMC_Value,1,"Multi Choice Answer in Response",false,node);
			
			//TextQuestion
			 oSFRSC.ValidateAllIndResp(driver,true,sExpXQ_Title,3,"Text Question Control Question",false,node);
			 oSFRSC.ValidateAllIndResp(driver,false,sExpXQ_Value,2,"Text Question Control Answer",false,node);
			//Email Control
			 oSFRSC.ValidateAllIndResp(driver,true,sExpEM_Title,4,"Email Control Question",false,node);
			 oSFRSC.ValidateAllIndResp(driver,false,sExpEM_Value,3,"Email Control Answer",false,node);
			
			//Phone Number
			 sExpPN_Value = sExpPN_Prefix + " " + sExpPN_Value;
				
			 oSFRSC.ValidateAllIndResp(driver,true,sExpPN_Title,5,"Phone Number Control Question",false,node);
			 oSFRSC.ValidateAllIndResp(driver,false,sExpPN_Value,4,"Phone Number Control Answer",false,node);	
			 
			//Appointment Control
			 sExpAP_Value = xlObj.getCellData("Sheet1", 1, 14);
			 oSFRSC.ValidateAllIndResp(driver,true,sExpAP_Title,6,"Appointment Control Question",false,node);
			 oSFRSC.ValidateAllIndResp(driver,false,sExpAP_Value,5,"Appointment Control Answer",false,node);
			 
			//Multi Select
			oSFRSC.ValidateAllIndResp(driver, true, sExpMS_Title,7,"MultiChoice Control Question", false,node);
			oSFRSC.ValidateAllIndResp(driver, false, sExpMS_Value,6,"MultiChoice Control Answer", false,node);
			// List Control
			oSFRSC.ValidateAllIndResp(driver, true, sExpLS_Title,8,"List Control Question",false,node);
			oSFRSC.ValidateAllIndResp(driver, false, sExpLS_Value,7, "List Control Values",false,node);
			// Number Control
			oSFRSC.ValidateAllIndResp(driver, true, sExpNM_Title,9,"Number Control Question",false,node);
			oSFRSC.ValidateAllIndResp(driver, false, sExpNM_Value,8,"Number Control Answer",false,node);
			// Range Control
			oSFRSC.ValidateAllIndResp(driver, true, sExpRG_Title,10, "Range Control Question",false,node);
			oSFRSC.ValidateAllIndResp(driver, false, sExpRG_Value, 9, "Range Control Answer",false,node);
			// Rating Control
			oSFRSC.ValidateAllIndResp(driver, true, sExpRT_Title, 11, "Rating Control Question",false,node);
			oSFRSC.ValidateAllIndResp(driver, false, sExpRT_Value, 10, "Rating Control Answer",false,node);
			// Opinion Scale
			oSFRSC.ValidateAllIndResp(driver, true, sExpOS_Title, 12,"Opinion Scale Control Question", false,node);
			oSFRSC.ValidateAllIndResp(driver, false, sExpOS_Value, 11,"Opinion Scale Control Answer", false,node);
			// Date Control
			oSFRSC.ValidateAllIndResp(driver, true, sExpDT_Title, 13, "Date Control Question",false,node);
			oSFRSC.ValidateAllIndResp(driver, false, sExpDT_Value, 12, "Date Control Answer",false,node);
			//Link Control
			oSFRSC.ValidateAllIndResp(driver,true,sExpLK_Title,14,"Link Control Question",false,node);
//			oSFRSC.ValidateAllIndResp(driver,false,sExpLK_Value,15,"Link Control Answer",false);
			//Thank You Control
			oSFRSC.ValidateAllIndResp(driver,true,sExpTQ_Title,15,"Thank You Control Question",false,node);
			//oSFRSC.ValidateAllIndResp(driver,false,sExpTQ_Value,16,"Thank You Control Answer");
			//Picture Message Control
			oSFRSC.ValidateAllIndResp(driver,true,sExpPM_Title,16,"Picture Message Control Question",false,node);
			oSFRSC.ValidateAllIndResp(driver,false,sExpPM_Value,14,"Picture Message Control Answer",false,node);
			//Yes or No Control		
			oSFRSC.ValidateAllIndResp(driver,true,sExpYN_Title,17,"Yes or No Control Question",false,node);
			oSFRSC.ValidateAllIndResp(driver,false,sExpYN_Value,15,"Yes or No Control Answer",false,node);
			//Agreement Control
			oSFRSC.ValidateAllIndResp(driver,true,sExpAG_Title,18,"Agreement Control Question",false,node);
			oSFRSC.ValidateAllIndResp(driver,false,sExpAG_Response,16,"Agreement Control Answer",false,node);
			//Rank Matrix Control
			oSFRSC.ValidateAllIndResp(driver,true,sExpRM_Title,19,"Rank Matrix Control Question",false,node);
			//oSFRSC.ValidateAllIndResp(driver,false,sExpAG_Value,19,"Rank Matrix Control Answer");
			sExpRM_Value=sExpRM_Value.replace(",", "");
			String sActRM_Value= IndvObj.getRespRMValues();
			System.out.println("Actual Response Values: "+sActRM_Value);
			oSFRSC.fSoftAssert(String.valueOf(sActRM_Value),String.valueOf(sExpRM_Value),"Rank Matrix Response Values",node);
//			//Google Map
//			oSFRSC.ValidateAllIndResp(driver,true,sExpGM_Title,20,"Google Map Control Question",false,node);
//			oSFRSC.ValidateAllIndResp(driver,false,sExpGM_Value,18,"Google Map Control Answer",false,node);
//			//Voice Record Control
//			oSFRSC.ValidateAllIndResp(driver,true,sExpVR_Title,21,"Voice Record Control Question",false,node);
//			sExpVR_Value = xlObj.getCellData("Sheet1", 1, 44);
//			oSFRSC.ValidateAllIndResp(driver,false,sExpVR_Value,19,"Voice Record Control Answer",true,node);
//			//FileUpload Control
//			oSFRSC.ValidateAllIndResp(driver,true,sExpUF_Title,22,"FileUpload Control Question",false,node);
//			sExpUF_Prefix = xlObj.getCellData("Sheet1", 1, 47);
//			oSFRSC.ValidateAllIndResp(driver,false,sExpUF_Prefix,20,"FileUpload Control Answer",true,node);
			
			
			
			IndvObj.clickResponseClose(driver);
		}
		catch(Exception e) {
			System.out.println(e.getCause());
			Assert.fail(e.getMessage());
		}//try catch
	}//test
}//class	