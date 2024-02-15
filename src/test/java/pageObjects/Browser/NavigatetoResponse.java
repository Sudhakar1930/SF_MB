package pageObjects.Browser;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.MouseButton;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;
import utilities.Browser.UtilityCustomFunctions;


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
	
	@FindBy(xpath="//android.widget.ImageButton[@content-desc='Customise and control Google Chrome']")
	WebElement lnkMenuButton;
	
	@FindBy(id="com.android.chrome:id/checkbox")
	WebElement lnkDesktopMnuItem;
	
//	@FindBy(xpath="//android.view.View[@content-desc=' ']")
	@FindBy(xpath="//android.widget.TextView[@text='']")
	WebElement mnuResponseItem;
	
	@FindBy(xpath="//android.view.View[@resource-id='navbar-collapse']")
	WebElement topmnuItems;
	
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
	public void clickDesktopSite() throws Exception {
		lnkDesktopMnuItem.click();
	}
	public void clickBrowserMenu() throws Exception {
		lnkMenuButton.click();
	}
	public void clickTopMenu() {
		mnuResponseItem.click();
//		TouchAction touchAction = new TouchAction(null);
//		touchAction.tap(PointOption.point(1280, 1013)).perform()
//		
	}
	public void action_clickOnPosition(int pointA_X, int pointA_Y) { 
		PointerInput finger = new PointerInput(org.openqa.selenium.interactions.PointerInput.Kind.TOUCH, "finger"); 
		org.openqa.selenium.interactions.Sequence clickPosition = new org.openqa.selenium.interactions.Sequence(finger, 1); 
		clickPosition .addAction(finger.createPointerMove(Duration.ZERO, Origin.viewport(), pointA_X,pointA_Y)) .addAction(finger.createPointerDown(MouseButton.LEFT.asArg())) .addAction(finger.createPointerUp(MouseButton.LEFT.asArg())); 
		try {
			((RemoteWebDriver) driver).perform(Arrays.asList(clickPosition));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
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
