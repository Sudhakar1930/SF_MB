package testBase.Android;

import java.io.File;
import java.net.*;
import java.time.Duration;

import io.appium.java_client.service.local.AppiumServiceBuilder;
import utilities.ExtentReportManager;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
public class NewBase extends ExtentReportManager{
	public AndroidDriver driver;
	public void startAppium() throws MalformedURLException {
		AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS(new File("C://Users//sudha//AppData//Roaming//npm//node_modules//appium//lib//main.js")).withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		
		UiAutomator2Options options = new UiAutomator2Options();

		options.setDeviceName("RZCW30AKXKZ");
		options.setPlatformVersion("13.0");
		options.setPlatformName("Android");
		options.noReset();
		options.withBrowserName("Chrome");
		options.autoGrantPermissions();
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
}
