package andriod_emulatorExamples;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class HorizontalSwipe2 {	
		// Method - 5
		public void voidSwipeHorizontal5(AndroidDriver<WebElement> driver, double startPercentage, double endPercentage) {
			Dimension size = driver.manage().window().getSize();
			int height = (int) (size.getHeight()*0.20);
			int startX = (int) (size.getWidth() * startPercentage);

			int endX = (int) (size.getWidth() * endPercentage);
			new TouchAction(driver).press(PointOption.point(startX, height)).waitAction().moveTo(PointOption.point(endX, height)).release().perform();

		}
		
	// Method - 6
	public void SwipeHorizontal6(AndroidDriver<WebElement> driver, double startPercentage, double endPercentage)
			throws Exception {
		Dimension size = driver.manage().window().getSize();
		int height = (int) (size.getHeight() * 0.20);
		
		int startX = (int) (size.getWidth() * startPercentage);
		int endX = (int) (size.getWidth() * endPercentage);
		
		TouchAction action = new TouchAction(driver);
		action.longPress(PointOption.point(startX, height)).moveTo(PointOption.point(endX, height)).release().perform();
	}
	
	@Test
	public void f(){
		DesiredCapabilities dc=new DesiredCapabilities();
		try{
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1.0");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		dc.setCapability("udid", "emulator-5554");
		
		dc.setCapability("appPackage", "io.appium.android.apis");
		dc.setCapability("appActivity", "io.appium.android.apis.view.Tabs5");
		
		Thread.sleep(2000);
		
		URL url=new URL("http://127.0.0.1:4723/wd/hub");
		AndroidDriver<WebElement> driver=new AndroidDriver<WebElement>(url,dc);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		Thread.sleep(5000);
		
		for(int i=0; i<=4; i++){
			//voidSwipeHorizontal5(driver, 0.75, 0.35);
			SwipeHorizontal6(driver, 0.75, 0.35);
		System.out.println(i);
		}
    
	   Thread.sleep(8000);
		
		driver.quit();
		
		}
		catch(Exception e){
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
		}
		
		
	}
	
	

}
