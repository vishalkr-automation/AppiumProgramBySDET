package andriod_emulatorExamples;



import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;




public class LaunchChromeBrowser {
	//AppiumDriver<MobileElement> driver;

	@Test
	public void setup(){
		try{
         DesiredCapabilities dc=new DesiredCapabilities();
		
        /*dc.setCapability("platformName", "Android");
		dc.setCapability(CapabilityType.PLATFORM_NAME, "Android");*/
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		dc.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
		//dc.setCapability("W3C",true);
		//dc.setCapability(MobileCapabilityType.APP, "");
		dc.setCapability("chromedriverExecutable", "D:\\Projects\\AppiumProgramBySDET\\drivers\\chromedriver.exe");
		dc.setCapability(MobileCapabilityType.BROWSER_NAME, "CHROME");
		//dc.setCapability("browserName", "chrome");
		
		
		
		URL url=new URL("http://127.0.0.1:4723/wd/hub");
		//driver=new AppiumDriver<MobileElement>(url, dc);
				
		//WebDriver driver=new AppiumDriver<>(url,dc);
		WebDriver driver=new RemoteWebDriver(url, dc);
		driver.get("https://www.facebook.com/");
				
		//driver=new AndroidDriver<MobileElement>(url, dc);
		//driver=new IOSDriver<MobileElement>(url, dc);
		
	
		System.out.println("Application Started");
		}
		catch(Exception e){
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	@AfterTest
	public void tearDown(){
		
		//driver.quit();
	}

}
