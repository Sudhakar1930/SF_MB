package testCases;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;


import io.appium.java_client.android.AndroidDriver;


public class SFAllMB_Independent  {
	
	
	@Test
	public void init() throws MalformedURLException {
		
		WebDriver driver;
		ChromeOptions options=new ChromeOptions();
		
				
		URL url=new URL("http://localhost:4723/wd/hub");
		
		 options.setPlatformName("Android");

		 options.setAndroidDeviceSerialNumber("IGBEFIAEEJFGBFH");

		 //options.setBrowserVersion("117.0.5938.153");
		 options.setCapability("automationName", "UiAutomator2");
		 options.setCapability("browserName", "chrome");
		 options.setCapability("browserVersion", "117.0.5938.153");
		 
		 
		driver = new AndroidDriver(url, options);
		System.out.println("driver instance created");		
		driver.get("https://rthree.live/showform?formid=603433&nurams=bot1");
		
		
	}
	
	
}
