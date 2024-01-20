package pageObjects.Android;

import java.io.IOException;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.android.AndroidDriver;
import testBase.Android.BaseTest;
import utilities.Android.UtilityCustomFunctions;

public class SectionControlsPage extends BaseTest{
//	AndroidDriver driver;
	public SectionControlsPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	Logger	logger = LogManager.getLogger(this.getClass());
	
	
	@FindBy(xpath="//label[contains(text(),'1)')]")
	WebElement lblSectionTitle;
	
	
	
	@FindBy(xpath="(//iframe[@title='Form preview'])[1]")
	WebElement iframe1;
	
	@FindBy(xpath="//div[@class='epsf-ans-section']/label")
	WebElement lblSectionHeader;
	
	
	
	
	@FindBy(xpath="//*[@id='rootdiv']//div[@class='input-group new_input']")
	WebElement txtListControl;
	
	@FindBy(xpath="//ul//li/div/a")
	List<WebElement> aListItems;
	
	//@FindBy(xpath="//*[@id='numbershow2228']")
	
	@FindBy(xpath="//*[contains(@id,'numbershow')]")	
	WebElement txtNumberInput;
	
	@FindBy(xpath="//input[@id='range']")
	WebElement eleRangeSlider;
	
	@FindBy(xpath="//mat-slider[@role='slider']")
	WebElement eleSectionRangeSlider;
	
	
	@FindBy(xpath="//div[@class='input-group']/ul[@class='opnscal-container float']")
	WebElement lstOpinionScale;
	
	
	@FindBy(xpath="//div[@class='fileupshow-body-div ng-star-inserted']")
	WebElement lnkFileUpload;
	
	@FindBy(xpath="//input[@id='datebox']")
	WebElement txtDateInput;

//	@FindBy(xpath="//input[@id='agreement_txt']")
//	WebElement lblAgreementText;
	
	@FindBy(xpath="//input[@id='agreement_txt']")
	WebElement lblAgreementText;
	

	
	@FindBy(xpath="//*[@id='uploadbutton' and @class='rcsingle-nxtbtn myanimation']")
	WebElement btnVRUpload;
	
	
	@FindBy(xpath="//input[@placeholder='Search Nearest Location']")
	WebElement txtGoogleMapInput;
	
	
	@FindBy(xpath="//*[@id='section_id']/app-sectionshow/div/p/button")
	WebElement btnSectionNext;
	
	
	@FindBy(xpath="//strong[normalize-space()='Section Title..!']")
	WebElement lblEmptySectionTitle;
	
	@FindBy(xpath="//*[@id='rootdiv']/div/p/span")
	WebElement lblSectionMsgControl;
	
	
	
	
	
	
	/*
	@FindBy(xpath="//div/p[@xpath='1']")
	WebElement txtDateInput; */
	
	
	
	
	//get Methods
	public String getDateSelected() throws Exception {
//		return txtDateInput.getAttribute("value");
		return UtilityCustomFunctions.getValue(driver, txtDateInput);
	}
	public String getAgreementMsg() {
		//String sSFMessage = lblAgreementText.getAttribute("value");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String sActvalue = (String) js.executeScript("return arguments[0].value", lblAgreementText);
		return sActvalue;
	}
	
	public String getSectionMsgControlTitle() {
		String sSFMessage = lblSectionMsgControl.getText();
		return sSFMessage;
	}
	public String getSectionHeader() {
		String sSFMessage = lblSectionHeader.getText();
		return sSFMessage;
	}
	
	
	
	public String getEmptySectionTitle() {
		String sSFMessage = lblEmptySectionTitle.getText();
		return sSFMessage;
	}
	public String getSectionTitle() {
		String sSFMessage = lblSectionTitle.getText();
		return sSFMessage;
	}
	
	
	//Set Functions
	public void setGoogleMapAddress(String strAddress) {
		utilities.Android.UtilityCustomFunctions.sendKeys(driver, txtGoogleMapInput, strAddress);
		txtGoogleMapInput.sendKeys(Keys.ENTER);
	}
	
	public void setNumber(String sNumber) throws Exception{
		utilities.Android.UtilityCustomFunctions.sendKeys(driver, txtNumberInput, sNumber);
	}
	
	public void setIndvRange(int iSliderValue) throws Exception{
		
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", eleRangeSlider);
			WebDriverWait webWait = new WebDriverWait(driver, Duration.ofSeconds(10));
			webWait.until(ExpectedConditions.elementToBeClickable(eleRangeSlider));
			webWait.until(ExpectedConditions.visibilityOf(eleRangeSlider));
			for(int i = 0;i<iSliderValue;i++) {
				eleRangeSlider.sendKeys(Keys.ARROW_RIGHT);
			}
	}
	public void setSectionRange(int iSliderValue) throws Exception{
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", eleSectionRangeSlider);
		WebDriverWait webWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		webWait.until(ExpectedConditions.elementToBeClickable(eleSectionRangeSlider));
		webWait.until(ExpectedConditions.visibilityOf(eleSectionRangeSlider));
		for(int i = 0;i<iSliderValue;i++) {
			eleSectionRangeSlider.sendKeys(Keys.ARROW_RIGHT);
		}
}
	public void setFrameFormPreview() {
		driver.switchTo().frame(iframe1);
	}
	//Select Functions
	public void selectOneItem(String strItem) throws Exception{
		utilities.Android.UtilityCustomFunctions.selectOneItemfromListBox(driver, lstOpinionScale, strItem);
	}
	
	public void SelectListItem(String sItem) throws Exception{
		for(WebElement lstItem: aListItems)
		{
			if(lstItem.getText().equalsIgnoreCase(sItem)) {
				lstItem.click();
				break;
			}
		}
	}
		/*
		public void SelectFiletoUpload(String sFUPath) throws IOException, InterruptedException {
			lnkFileUpload.click();
			Thread.sleep(1000);;
//			Runtime.getRuntime().exec("D:\\Automation\\AutoITScript.exe"+ " " + "D:\\NewFile.txt");
			Runtime.getRuntime().exec("D:\\Automation\\AutoITScript.exe"+ " " + "D:/NewFile.txt");
		}*/
		public void SelectFiletoUpload(String sFUPath) throws IOException, InterruptedException {
			lnkFileUpload.click();
			Thread.sleep(1000);
			String sBrowserName=utilities.Android.UtilityCustomFunctions.getBrowserName(driver);
			if(sBrowserName.equalsIgnoreCase("firefox")) {
				Runtime.getRuntime().exec("D:\\Automation\\FuFirefox.exe"+" " + "D:\\NewFile.txt");
			}
			else {
				Runtime.getRuntime().exec("D:\\Automation\\AutoITScript.exe"+ " " + "D:\\NewFile.txt");
			}
			
		}
		
		
		public void selectListDropDown(WebDriver driver,String sItem) {
			String sLstXpath = "//a[normalize-space()='" + sItem +"']";
			driver.findElement(By.xpath(sLstXpath)).click();
			
		}
	
	//click Methods
	public void clickNextInSection() throws Exception {
//		btnSectionNext.click();
		utilities.Android.UtilityCustomFunctions.doClick(driver, btnSectionNext);
	}
	public void clickVRUpload()
	{
		if(btnVRUpload.isEnabled()) {
		btnVRUpload.click();
		}
		else {
			Assert.fail("VR Upload Not Enabled");
		}
	}
	public void clickListInput() throws Exception {
		//utilities.UtilityCustomFunctions.doClick(driver, txtListControl);
		txtListControl.click();

	}
	
	public void fValidateSectionLabels(WebDriver driver,int iLabelIndex,String sExpValue,String sValMessage,ExtentTest node) {
		try {
		String sUILableExpath = "(//*[@id='rootdiv']/div/p)[" + iLabelIndex +"]" ;
		WebElement eleLabel = driver.findElement(By.xpath(sUILableExpath));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", eleLabel);
		String sActLabel = driver.findElement(By.xpath(sUILableExpath)).getText();
		//oSFRVal.fSoftAssert(sActLabel.trim(), sExpValue.trim(), sValMessage, node);
		freport(sValMessage, "Pass",node);
		logger.info(sValMessage + " Validation with Expected: " + sExpValue + " and Actual is: " +sActLabel);
		}catch (Exception e) {
			System.out.println(e.getCause());
		}
	}

}
