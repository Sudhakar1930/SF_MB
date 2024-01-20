package testBase.Android;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Base1 {
	 
	@Test
	public void configureAppium() throws MalformedURLException {
	
	UiAutomator2Options options = new UiAutomator2Options();
	options.setPlatformName("Android");
	options.setDeviceName("db48f8d9");
	options.setApp(System.getProperty("user.dir") + "\\resources\\ApiDemos-debug.apk");
	
	AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}//method
	//Create object for Android Driver
	
	
	
}
