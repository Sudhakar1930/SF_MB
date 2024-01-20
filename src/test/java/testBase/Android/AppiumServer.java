package testBase.Android;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Media;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import utilities.ExtentReportManager;

public class AppiumServer extends ExtentReportManager{
	public static AndroidDriver driver;
	protected static File file;
	Logger logger = LogManager.getLogger(this.getClass());
//	static AppiumDriverLocalService server;
	
	@BeforeClass
	public void setInstance() throws MalformedURLException {
//		AppiumServiceBuilder builder = new AppiumServiceBuilder();
//		builder
//			.withAppiumJS(new File("C://Users//sudha//AppData//Roaming//npm//node_modules//appium//lib//main.js"))
//			.usingDriverExecutable(new File("C://Program Files//nodejs")).withArgument(GeneralServerFlag.SESSION_OVERRIDE).usingPort(4723).withArgument(GeneralServerFlag.LOCAL_TIMEZONE).withIPAddress("127.0.0.1");
//	server = AppiumDriverLocalService.buildService(builder);
//	server.start();
		AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
		service.start();
		System.out.println("Appium Url:" + service.getUrl());
		System.out.println("Is Server Running:" + service.isRunning());
	
	UiAutomator2Options options = new UiAutomator2Options();

	options.setDeviceName("RZCW30AKXKZ");
	options.setPlatformVersion("13.0");
	options.setPlatformName("Android");
	options.noReset();
	options.withBrowserName("Chrome");
	options.setAutomationName("UiAutomator2");
	options.noSign();
	options.autoGrantPermissions();
	
	driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
	
	logger = LogManager.getLogger(this.getClass());
	}	
	@Test()
	public void checkStartServer() throws MalformedURLException {
		setInstance();
	}
//	static AppiumDriverLocalService getInstance() throws MalformedURLException {
//		if(server==null) {
//			setInstance();
//		}
//		return server;
//		
//	}
//	
//	public static void startServer() throws AppiumServerHasNotBeenStartedLocallyException, MalformedURLException, InterruptedException {
//		getInstance().start();
//		Thread.sleep(3000);
//		System.out.println("Appium Url: " + server.getUrl());
//		System.out.println("Running: " + server.isRunning());
//	}
//	public static void stopServer() throws MalformedURLException {
//		if(server!=null) {
//			getInstance().stop();
//			System.out.println("Appium Server got stopped");
//		}
//		
//	}
	
	public void freport(String dec, String status,ExtentTest node) throws IOException, InterruptedException {
		Media img = null;
		String filepath = "";
		
		long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L;
		System.err.println(number);
		try {
		String date = new SimpleDateFormat("dd-MMM-yy").format(new Date());
		String date1 = new SimpleDateFormat("HH.mm").format(new Date());
		filepath= "./reports/Screenshots/"+date+"/"+ date1 +"_"+ number + ".jpg";
		Thread.sleep(1000);		
		file = new File(filepath);
		
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		FileUtils.copyFile(takesScreenshot.getScreenshotAs(OutputType.FILE),file);
			
//		img = MediaEntityBuilder.createScreenCaptureFromPath(System.getProperty("user.dir")+"/reports/Screenshots/"+date+"/"+date1+"_"+number+".jpg").build();
		img = MediaEntityBuilder.createScreenCaptureFromPath("./../Screenshots/"+date+"/"+date1+"_"+number+".jpg").build();
		
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		if(status.equalsIgnoreCase("pass")) {
			System.err.println("Before node Pass");
			node.pass(dec, img);
			System.out.println(dec + " : " + "pass");

		}else if (status.equalsIgnoreCase("fail")) {
			System.err.println("Before node Fail");
			node.fail(dec, img);
			System.err.println(dec + " : After node Fail");
		}
		}
	
}
