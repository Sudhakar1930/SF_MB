package testCases;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import pageObjects.Android.IndvControls;
import pageObjects.Android.SectionControlsPage;
import testBase.Android.BaseTest;

public class HandleToastMessages extends BaseTest{
	
	@Test
	public void toastcheck() throws Exception {
	driver.get("https://rthree.live/showform?formid=289536&nurams=bot1");
	IndvControls IndvObj = new IndvControls(driver);
	SectionControlsPage SecObj = new SectionControlsPage(driver);
	
	String sAppFullTime="";
	IndvObj.clickBookAppointment();
	Thread.sleep(1000);
	IndvObj.clickApptChooseDate();
	Thread.sleep(3000);
	boolean bIsDateAvail = false;
	boolean bNewMonth = false;
	do {
		bIsDateAvail=IndvObj.setApptDateInSection(bNewMonth);
		System.out.println("Is Date Available in curr Month: "+bIsDateAvail);
		bNewMonth = true;
	}while(bIsDateAvail==false);
	
	
	Thread.sleep(1000);
	sAppFullTime = IndvObj.getBtnApptMsg();
	sAppFullTime = sAppFullTime.replace("Date", "Appointment Date");
	System.out.println(sAppFullTime);
	
	
	
	
	}
}//class
