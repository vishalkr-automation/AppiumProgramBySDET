package andriod_emulatorExamples;

import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class VerticalSwipeExample {
	
	//Method - 1 
	public void voidSwipevertical(AndroidDriver<MobileElement> driver, double startPercentage, double endPercentage){
		Dimension size=driver.manage().window().getSize();
		int width=(int)(size.getWidth()/2);
		int startPoint_Y=(int)(size.getHeight()*startPercentage);
		
		int endPoint_Y=(int)(size.getHeight()*endPercentage);
		new TouchAction(driver).press(PointOption.point(width, startPoint_Y)).waitAction().moveTo(PointOption.point(width, endPoint_Y)).release().perform();
		
	}
	
	//Method - 2 
	public void voidSwipevertical2(AndroidDriver<WebElement> driver, double startPercentage, double endPercentage){
		Dimension size=driver.manage().window().getSize();
		int width=(int)(size.getWidth()/2);
		int startPoint_Y=(int)(size.getHeight()*startPercentage);
		
		int endPoint_Y=(int)(size.getHeight()*endPercentage);
		new TouchAction(driver).press(PointOption.point(width, startPoint_Y)).moveTo(PointOption.point(width, endPoint_Y)).release().perform();
	}
	
	//Method - 3
	public void Swipevertical3(AndroidDriver<WebElement> driver, double startPercentage, double endPercentage) throws Exception{
		Dimension size=driver.manage().window().getSize();
		int width=(int)(size.getWidth()/2);
		int startPoint_Y=(int)(size.getHeight()*startPercentage);
		
		int endPoint_Y=(int)(size.getHeight()*endPercentage);
		
		TouchAction action = new TouchAction(driver); 
		action.longPress(PointOption.point(width, startPoint_Y)).moveTo(PointOption.point(width, endPoint_Y)).release().perform();
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
		
		dc.setCapability("appPackage", "com.mobeta.android.demodslv");
		dc.setCapability("appActivity", "com.mobeta.android.demodslv.Launcher");
		
		Thread.sleep(2000);
		
		URL url=new URL("http://127.0.0.1:4723/wd/hub");
		AndroidDriver<WebElement> driver=new AndroidDriver<WebElement>(url,dc);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		Thread.sleep(2000);
		
		WebElement e1=driver.findElement
		(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.TextView[2]"));
		 e1.click();
		 
		 Thread.sleep(5000);
		 
		Swipevertical3(driver, 0.80, 0.20);
			
		 Thread.sleep(3000);
		
		driver.quit();
		
		}
		catch(Exception e){
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
		}	
		
	}

}
