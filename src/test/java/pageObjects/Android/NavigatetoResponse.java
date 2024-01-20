package pageObjects.Android;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class NavigatetoResponse {
	WebDriver driver;
	public NavigatetoResponse(WebDriver driver) {
		this.driver = driver;
		//PageFactory.initElements(new AppiumFieldDecorator(driver),this);
		PageFactory.initElements(driver,this);
	}
	
	//WebElements
	@FindBy(xpath="//input[@placeholder='E-Mail']")
	WebElement txtLoginEmail;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement txtLoginPwd;
	
	@FindBy(css="button[type='submit']")
	WebElement btnSubmitLogin;
	
	@FindBy(xpath="//span[@title='Clear all']")
	WebElement btnClearAll;
	
	@FindBy(xpath="//*[@id='formList']/div/div/div[2]/input")
	WebElement txtBuildName;
	
	@FindBy(css="i.material-icons.gap.rotate.comman.down")
	WebElement btnBuildSideBar;
	
	@FindBy(xpath = "//*[@id='sidebar_body']//i[@class='material-icons gap rotate comman2']")
	WebElement btnSideBarResult;
	
	
	@FindBy(xpath="//span[normalize-space()='Responses']")
	WebElement btnSideItemResponses;
	
	@FindBy(css="button.resp-filter-x")
	WebElement btnRefreshResponse;
	
	@FindBy(xpath="(//i[@class='material-icons sidebar-icon resp-page-icon ng-star-inserted'])[1]")
	WebElement lnkFirstResponse;
	
	//Set Text
	public void setEmailId(String strEmailId) {
		//utilities.UtilityCustomFunctions.sendKeys(driver, txtLoginEmail, strEmailId);
		txtLoginEmail.sendKeys(strEmailId);
	}
	
	public void setPassword(String strPassword) {
//		utilities.UtilityCustomFunctions.sendKeys(driver, txtLoginPwd, strPassword);
		txtLoginPwd.sendKeys(strPassword);
	
	}
	//Click Action
	
	public void clickSubmit() throws Exception {
//		utilities.UtilityCustomFunctions.doClick(driver, btnSubmitLogin);
		btnSubmitLogin.click();
	}
	
	public void clickClearAll() throws Exception {
		//utilities.UtilityCustomFunctions.doClick(driver, btnClearAll);
		btnClearAll.click();
	}
	
	public void clickSideBarBldBtn() throws Exception {
		//utilities.UtilityCustomFunctions.doClick(driver, btnBuildSideBar);
		btnBuildSideBar.click();
		
	}
	
	public void clickSideBarResult() throws Exception {
		//utilities.UtilityCustomFunctions.doClick(driver, btnSideBarResult);
		btnSideBarResult.click();
	}
	public void clickSideItemResp() throws Exception {
		//utilities.UtilityCustomFunctions.doClick(driver, btnSideItemResponses);
		btnSideItemResponses.click();
	}
	public void clickRefreshResponse() throws Exception {
		//utilities.UtilityCustomFunctions.doClick(driver, btnRefreshResponse);
		btnRefreshResponse.click();
	}
	public void clickFirstResponse() throws Exception {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", lnkFirstResponse);
	}
	
	//Set Methods
	public void setBuildName(String strBuildName) throws Exception {
//		utilities.UtilityCustomFunctions.sendKeys(driver, txtBuildName, strBuildName);
		utilities.Browser.UtilityCustomFunctions.sendKeys(driver, txtBuildName, strBuildName);
		txtBuildName.sendKeys(Keys.ENTER);
	}
	
	public void KeyEnterBuildName() throws Exception {
		txtBuildName.sendKeys(Keys.ENTER);
		//utilities.UtilityCustomFunctions.sendKeys(driver, txtBuildName, "Keys.ENTER");
	}
	
	public boolean bIsCloseAllVisible() {
		boolean bFlag = false;
		bFlag = IsElementVisible(driver, btnClearAll);
		return bFlag;
	}

	public boolean IsElementVisible(WebDriver driver, WebElement element) {
		boolean bIsElementVisible = false;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		wait.until(ExpectedConditions.visibilityOf(element));
		js.executeScript("arguments[0].scrollIntoView();", element);

		if (element.isDisplayed()) {
			bIsElementVisible = true;
		} else {
			bIsElementVisible = false;
		}
		return bIsElementVisible;
	}
	
	
	
	
	
	
	
	
		

}
