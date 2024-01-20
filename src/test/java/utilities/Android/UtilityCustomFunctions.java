package utilities.Android;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;

public class UtilityCustomFunctions {
	AndroidDriver driver;
	static Logger logger = LogManager.getLogger(UtilityCustomFunctions.class);
	public UtilityCustomFunctions(AndroidDriver driver) {
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}
	
	public static String getBrowserName(AndroidDriver driver) {
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
	    String browserName = cap.getBrowserName().toLowerCase();
		return browserName;
	}

	public static void sendKeys(WebDriver driver2, WebElement element, String keyValue) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver2;
			
			
			WebDriverWait wait = new WebDriverWait(driver2, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			wait.until(ExpectedConditions.visibilityOf(element));
			js.executeScript("arguments[0].scrollIntoView();", element);
			element.clear();
//			Actions action = new Actions(driver);
//			action.moveToElement(element).doubleClick().build().perform();
			element.sendKeys(keyValue);
			element.sendKeys(Keys.ENTER);
		}
		catch(Exception e){
			System.out.println(e.getCause());
			
		}
	
	}//function end
	public static boolean selectMultiItemfromListBox(AndroidDriver AndroidDriver, WebElement element, String textValue) {
		//waitForJQueryToLoad(AndroidDriver);
		boolean flag = false;
		
		try {
			((JavascriptExecutor) AndroidDriver).executeScript("arguments[0].scrollIntoView(true);", element);
			
			System.out.println("Element:" + element.getTagName());
			if (element.isDisplayed() || element.isEnabled()) {
				String arrValues[]=textValue.split(",");
				element.click();
				Thread.sleep(1000);
				List<WebElement> options = element.findElements(By.tagName("li"));
//				System.out.println(arrValues.length);
//				System.out.println("List Item Size:"+options.size());
				for(int i=0;i<arrValues.length;i++) {
					for (WebElement option : options) {
						System.out.println("Option in List Box is : "+option.getText());
						System.out.println("Expected Value to be clicked is: " + arrValues[i]);
						if (arrValues[i].equalsIgnoreCase(option.getText().trim())) {
							
							System.out.println("Inside loop clicked Item is: " + option.getText());
							System.out.println("Inside click loop expected value to clicked is: " + arrValues[i]);
							
							logger.info("Expected Value:" + arrValues[i]);
							logger.info("DropDown Value:" + option.getText());
							option.click();
							continue;
							
						}
					}
				}
			}
		} catch (Exception e) {
			//Reporter.log("Exception occured while fnSelectFromComboBox event " + e.getMessage());
			System.out.println(e.getMessage());
		}
		return flag;
	}//function end
	
	public boolean selectFromComboBox(AndroidDriver AndroidDriver, WebElement element, String textValue) {
		//waitForJQueryToLoad(AndroidDriver);
		boolean flag = false;
		try {
			((JavascriptExecutor) AndroidDriver).executeScript("arguments[0].scrollIntoView(true);", element);
			if (element.isDisplayed() || element.isEnabled()) {
				List<WebElement> options = element.findElements(By.tagName("option"));
				for (WebElement option : options) {
					if (textValue.equalsIgnoreCase(option.getText().trim())) {
						option.click();
						System.out.println("[" + textValue + "] is selected");
						logger.info("[" + textValue + "] is selected in Dropdown");
						flag = true; break;
					}
				}
			}
		} catch (Exception e) {
			//Reporter.log("Exception occured while fnSelectFromComboBox event " + e.getMessage());
			System.out.println(e.getMessage());
		}
		return flag;
	}//function end
	public static boolean selectOneItemfromListBox(WebDriver driver2, WebElement element, String textValue) {
		//waitForJQueryToLoad(AndroidDriver);
		boolean flag = false;
		
		try {
			((JavascriptExecutor) driver2).executeScript("arguments[0].scrollIntoView(true);", element);
			
			System.out.println("Element:" + element.getTagName());
			if (element.isDisplayed() || element.isEnabled()) {
				Thread.sleep(3000);
				List<WebElement> options = element.findElements(By.tagName("li"));
				System.out.println("List Item Size:"+options.size());
				for (WebElement option : options) {
					if (textValue.equalsIgnoreCase(option.getText().trim())) {
						option.click();
						System.out.println("[" + textValue + "] is selected");
						logger.info("[" + textValue + "] is selected in List");
						flag = true; break;
					}
				}
			}
		} catch (Exception e) {
			//Reporter.log("Exception occured while fnSelectFromComboBox event " + e.getMessage());
			System.out.println(e.getMessage());
		}
		return flag;
	}//function end
	
	
	
	/**
	 * This method is will performs click action on the element
	 * @param element Holds the Web element
	 * @return return the boolean value
	 * @throws Exception 
	 */
	public static boolean doClick(WebDriver driver2, WebElement element) throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver2;
		boolean isClicked = false;
		try {
			js.executeScript("arguments[0].scrollIntoView(true);", element);
			WebDriverWait webWait = new WebDriverWait(driver2, Duration.ofSeconds(20));
			webWait.until(ExpectedConditions.elementToBeClickable(element));
			webWait.until(ExpectedConditions.visibilityOf(element));
			js.executeScript("arguments[0].click();", element);
			//BaseTest.logger.info("Clicked...." + element.getAttribute("value"));
			//System.out.println("click element name : " + element.getAttribute("innerText"));
		
//			Actions action = new Actions(AndroidDriver);
//			action.moveToElement(element).click().build().perform();
		
			isClicked = true;
		}  catch (Exception ex) {
			//Reporter.log("Exception occured while doClick event " + ex.getMessage());
			System.out.println("Exception occured while doClick event " + ex.getMessage());
			throw ex;
		}
		return isClicked;
	}

	/**
	 * This method helps to get text from web element
	 * @param driver The AndroidDriver
	 * @param element  Holds the web element
	 * 
	 * @return Returns the String
	 * @throws Exception 
	 */
	public static String getValue(AndroidDriver AndroidDriver, WebElement element) throws Exception{
		String actualValue = null;
		JavascriptExecutor js = (JavascriptExecutor) AndroidDriver;
		try {
			WebDriverWait webWait = new WebDriverWait(AndroidDriver, Duration.ofSeconds(10));
//			webWait.until(ExpectedConditions.elementToBeClickable(element));
			webWait.until(ExpectedConditions.visibilityOf(element));
			js.executeScript("arguments[0].scrollIntoView(true);", element);
			actualValue= (String) js.executeScript("return arguments[0].value", element);
//			actualValue = element.getText();
		}  catch (Exception ex) {
			actualValue = element.getText();
			//Reporter.log("Exception occured while getValue event " + ex.getMessage());
			System.out.println("Exception occured while getValue event " + ex.getMessage());
			
			//throw ex;
		}
		return actualValue;
	}
	public static String getText(AndroidDriver AndroidDriver, WebElement element) throws Exception{
		String actualValue = null;
		JavascriptExecutor js = (JavascriptExecutor) AndroidDriver;
		try {
			WebDriverWait webWait = new WebDriverWait(AndroidDriver, Duration.ofSeconds(10));
			webWait.until(ExpectedConditions.elementToBeClickable(element));
			webWait.until(ExpectedConditions.visibilityOf(element));
			js.executeScript("arguments[0].scrollIntoView(true);", element);
//			actualValue= (String) js.executeScript("return arguments[0].value", element);
			actualValue = element.getText();
		}  catch (Exception ex) {
			//Reporter.log("Exception occured while getValue event " + ex.getMessage());
			System.out.println("Exception occured while getValue event " + ex.getMessage());
			//throw ex;
		}
		return actualValue;
	}
	
	public static String selectFirstListItem(AndroidDriver driver, WebElement element) {
		//waitForJQueryToLoad(AndroidDriver);
		String strFirstItem="";

		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			
			
			System.out.println("Element:" + element.getTagName());
			if (element.isDisplayed() || element.isEnabled()) {
				Thread.sleep(3000);
				List<WebElement> options = element.findElements(By.tagName("li"));
				System.out.println("List Item Size:"+options.size());
				if(options.size()!=0) {
				for (WebElement option : options) {
						strFirstItem = option.getText();
						option.click();
						System.out.println("[" + option.getText() + "] is selected");
						logger.info("[" + option.getText() + "] is selected in List");
						
						break;
					}//for loop
				}
				else {
					//Select Next Enabled Date
					
					strFirstItem="";
					
				}// if options!=0
				
				}// if isDisp/isEnab
			
				
			
	
		} catch (Exception e) {
			//Reporter.log("Exception occured while fnSelectFromComboBox event " + e.getMessage());
			System.out.println(e.getMessage());
			Assert.fail("Date Not Selected");
		}
		return strFirstItem;
		
	}//function end
	
	public static String SelectNextAvailDate(AndroidDriver driver, WebElement WbTblAppointMent,WebElement btnCurrentDate) {
	//	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", WbTblAppointMent);
		String sDateAttribute="";
		String sDay = "";
		List<WebElement> trows = WbTblAppointMent.findElements(By.tagName("tr"));
		
		System.out.println("trows:" + trows.size());
		
		for(WebElement trow: trows) {
			
			List<WebElement> tcols = trow.findElements(By.tagName("td"));
			for(WebElement tcol: tcols) {
				if(tcol.getText().length()<3) {
					System.out.println("Only Dates in Date Selection");
					if(Integer.parseInt(btnCurrentDate.getText())< Integer.parseInt(tcol.getText())) {
						sDateAttribute=tcol.getAttribute("class");
						if(sDateAttribute.contains("disabled")) {
							
						}
						else
						{
							sDay =tcol.getText();
							tcol.click();
							
							break;
						}//td disabled
					}
				}//get Only Dates
				
			}
			}//tcols
		return sDay;
		
	}//trows
	/*
    public static boolean clickDateAndGetslots(AndroidDriver driver,WebElement eleWbtbl,WebElement eleCurrDate,WebElement element,WebElement eleChooseDate) throws InterruptedException {
		int iSlotcount=0;
		boolean bFoundDate=false;
		tcols = driver.findElements(By.xpath("//table[@role='presentation']/tbody/tr/td"));
		System.out.println("Tcols  " + tcols.size());

			
			for (int j = 0; j < tcols.size(); j++) {
				tcols = driver.findElements(By.xpath("//table[@role='presentation']/tbody/tr/td"));
				String sDateAttribute = tcols.get(j).getAttribute("class");
				
				if(tcols.get(j).getText().length()<3) {
					
					eleCurrDate = driver.findElement(By.xpath("//div[contains(@class,'today')]"));
					System.out.println("today found"+eleCurrDate.getText());
					
				
					if(Integer.parseInt(eleCurrDate.getText())< Integer.parseInt(tcols.get(j).getText())) {
						System.out.println("Inside second IF");
						
						if(sDateAttribute.contains("disabled")) {
//							driver.navigate().refresh();
						}
						else {
							bFoundDate = true;
							tcols.get(j).click();
							Thread.sleep(1000);
							iSlotcount=getTimeSlots(element);
							
							if(iSlotcount==0) {
								System.out.println("Slot Count: " + iSlotcount);
								eleChooseDate.click();
								Thread.sleep(1000);
								continue;
							}else {
								//getFirstItem
								bFoundDate = true;
								clickFirstItem(element);
								break;
							}//If slotcount 0 or not

						}// If date disabled

					}//Parsed comparison
                    
					
				}//If values only 2 digits Only through Dates
			}
			return bFoundDate;
	}*/
	
	
   
	
    public static boolean clickLinkItems(AndroidDriver AndroidDriver, WebElement element, String textValue) {
		//waitForJQueryToLoad(AndroidDriver);
    	System.out.println("Expected Link texts: " + textValue);
		boolean flag = false;
		
		try {
			((JavascriptExecutor) AndroidDriver).executeScript("arguments[0].scrollIntoView(true);", element);
			
			System.out.println("Element:" + element.getTagName());
			if (element.isDisplayed() || element.isEnabled()) {
				String arrValues[]=textValue.split(",");
				
				Thread.sleep(1000);
				List<WebElement> options = element.findElements(By.tagName("li"));
				System.out.println("Linnks count:" + options.size());
				System.out.println("Expected 1Value: " + arrValues[0]);
				for(int i=0;i<arrValues.length;i++) {
					for (WebElement option : options) {
						System.out.println("Option in List Box is : "+option.getText());
						System.out.println("Expected Value to be clicked is: " + arrValues[i]);
						if (arrValues[i].equalsIgnoreCase(option.getText().trim())) {
							
							System.out.println("Inside loop clicked Item is: " + option.getText());
							System.out.println("Inside click loop expected value to clicked is: " + arrValues[i]);
							logger.info("Expected Value:" + arrValues[i]);
							logger.info("DropDown Value:" + option.getText());
							option.click();
							continue;
							
						}
					}
				}
			}
		} catch (Exception e) {
			//Reporter.log("Exception occured while fnSelectFromComboBox event " + e.getMessage());
			System.out.println(e.getMessage());
		}
		return flag;
	}//function end
    public static void setRankMatrix(WebElement eleRMTbl,String sRMValues) {
		List<WebElement> lstRadButtons = eleRMTbl.findElements(By.tagName("button"));
		System.out.println("String:" + lstRadButtons.size());
		String aRMArray[] = sRMValues.split(",");
		for(int i=0;i<aRMArray.length;i++) {
			
		
		for(int j=0;j<lstRadButtons.size();j++) {
			if(aRMArray[i].contentEquals(String.valueOf(j+1))){

				lstRadButtons.get(j).click();

			}

		}//inner for
		}//outer for
    }//method end
    
    
    public static void findAndClick(String strItem, List<WebElement> sLstPicMsgItems) {
    	System.out.println("Match item Inside parameter" + sLstPicMsgItems.size());
 
		List<WebElement> sMatchItems = sLstPicMsgItems;
		System.out.println("Match item:" + sMatchItems.size());
		
		for(WebElement item: sMatchItems) {
			if(strItem.equalsIgnoreCase(item.getText().trim())) {
				System.out.println("Matched item:"+ item.getText());
				item.click();
				break;
			}

		}//for loop
		
		
	}//method
    //get RankMatrix Selected Values from Response Page
    public String getRespankMatrixValues(List<WebElement> lstRespRMValues)
	{
    WebElement iframe1 = driver.findElement(By.xpath("(//iframe[@title='Form preview'])[1]"));
	driver.switchTo().frame(iframe1);	
	int i = 0;
	String sRMRespValues="";
	for(WebElement eleRankValue: lstRespRMValues) {
		i = i+ 1;
		if(eleRankValue.getAttribute("class").contains("epsf-ans-ranksel")){
		System.out.println(eleRankValue.getText());
		sRMRespValues = sRMRespValues + String.valueOf(i);
		}//if
	}//for
	driver.switchTo().defaultContent();
	return sRMRespValues;
	}//function
    
    //get Current Date in given format
    public static String getCurrentDate(String dtFormat) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(dtFormat);
		Date date = new Date();
		String sDate = dateFormat.format(date);
		return sDate;
	}
    
}