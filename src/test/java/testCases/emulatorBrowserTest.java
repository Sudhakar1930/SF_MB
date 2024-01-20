//package testCases;
//
//import java.net.MalformedURLException;
//import java.net.URL;
//
//import org.openqa.selenium.remote.DesiredCapabilities;
//
//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.remote.MobileCapabilityType;
//
//public class emulatorBrowserTest {
//
//	public static void main(String[] args) throws MalformedURLException {
//		// TODO Auto-generated method stub
//		AndroidDriver driver ;
//		URL url = new URL("http://127.0.0.1:4723");
//		DesiredCapabilities cap = new DesiredCapabilities();
//		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
//		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11.0");
//		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
//		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
//		driver = new AndroidDriver(url,cap);
//		driver.get("https://rthree.live/showform?formid=603433&nurams=bot1");
//		
////		https://www.youtube.com/watch?v=vQnk13m6lSw
//	}
//
//}
