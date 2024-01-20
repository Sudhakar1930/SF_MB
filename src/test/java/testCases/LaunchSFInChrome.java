//package testCases;
//
//import org.openqa.selenium.remote.CapabilityType;
//import org.openqa.selenium.remote.DesiredCapabilities;
//
//import com.google.common.collect.ImmutableMap;
//
//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.remote.MobileCapabilityType;
//import io.appium.java_client.remote.MobilePlatform;
//
//import java.net.MalformedURLException;
//import java.net.URL;
//
//public class LaunchSFInChrome {
//	public static void main(String[] args) throws MalformedURLException {
//		DesiredCapabilities cap = new DesiredCapabilities();
//		//cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
//		//cap.setCapability("platformName", "Android");
//		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.ANDROID);
//		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION,"9.0");
//		//cap.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5554");
//		cap.setCapability(MobileCapabilityType.DEVICE_NAME,"db48f8d9");
//		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
//		//cap.setCapability("VERSION", "9.0");
//		//cap.setCapability("deviceName", "emulator-5554");
////		cap.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
//		
////		cap.setCapability("browserVersion", "69.0.3497.100");
////		cap.setCapability("chromedriverExecutable", "D:\\Softwares\\chromedriver_win32\\chromedriver.exe");
//		
////		cap.setCapability("automationName", "UiAutomator2");
////		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
////		cap.setCapability("chromeOptions",ImmutableMap.of("w3c",false));
//
//		AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub/"),cap);
//		driver.get("http://www.google.com");
//	}
//}
