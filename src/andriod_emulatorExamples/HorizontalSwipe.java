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

public class HorizontalSwipe {
	
	//Method - 1 
		public void voidSwipeHorizontal(AndroidDriver<WebElement> driver, double startPercentage, double endPercentage){
			Dimension size=driver.manage().window().getSize();
			int width=(int)(size.getWidth()*0.50);
			int startX=(int)(size.getHeight()*startPercentage);
			
			int endX=(int)(size.getHeight()*endPercentage);
			new TouchAction(driver).press(PointOption.point(startX, width)).waitAction().moveTo(PointOption.point(endX, width)).release().perform();
			
		}
		
		//Method - 2 
		public void voidSwipeHorizontal2(AndroidDriver<WebElement> driver, double startPercentage, double endPercentage){
			Dimension size=driver.manage().window().getSize();
			int width=(int)(size.getWidth()*0.50);
			int startX=(int)(size.getHeight()*startPercentage);
			
			int endX=(int)(size.getHeight()*endPercentage);
			new TouchAction(driver).press(PointOption.point(startX, width)).moveTo(PointOption.point(endX, width)).release().perform();
		}
		
		//Method - 3
		public void voidSwipeHorizontal3(AndroidDriver<WebElement> driver, double startPercentage, double endPercentage) throws Exception{
			Dimension size=driver.manage().window().getSize();
			int width=(int)(size.getWidth()*0.50);
			int startX=(int)(size.getHeight()*startPercentage);
			
			int endX=(int)(size.getHeight()*endPercentage);
			
			TouchAction action = new TouchAction(driver); 
			action.longPress(PointOption.point(startX, width)).moveTo(PointOption.point(endX, width)).release().perform();
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
		
		dc.setCapability("appPackage", "jettoast.easyscroll");
		dc.setCapability("appActivity", "jettoast.easyscroll.screen.MainActivity");
		
		Thread.sleep(2000);
		
		URL url=new URL("http://127.0.0.1:4723/wd/hub");
		AndroidDriver<WebElement> driver=new AndroidDriver<WebElement>(url,dc);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		Thread.sleep(5000);
		
		for(int i=0; i<=4; i++){
		//voidSwipeHorizontal3(driver, 0.50, 0.10);
	     voidSwipeHorizontal(driver, 0.50, 0.05);
			
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
