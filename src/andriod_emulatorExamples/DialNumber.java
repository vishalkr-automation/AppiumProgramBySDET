package andriod_emulatorExamples;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DialNumber {
	
	@Test
	public void f(){
		DesiredCapabilities dc=new DesiredCapabilities();
		try{
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		dc.setCapability("udid", "emulator-5554");
		
//		dc.setCapability("appPackage", "com.google.android.dialer");
//		dc.setCapability("appActivity", "com.android.dialer.DialtactsActivity");
		
		dc.setCapability("appPackage", "com.android.dialer");
		dc.setCapability("appActivity", "com.android.dialer.app.DialtactsActivity");
		
		Thread.sleep(2000);
		
		URL url=new URL("http://127.0.0.1:4723/wd/hub");
		AndroidDriver<WebElement> driver=new AndroidDriver<WebElement>(url,dc);
		
		Thread.sleep(5000);
		
		//driver.findElement(By.id("com.google.android.dialer:id/fab")).click();
		driver.findElementById("com.android.dialer:id/fab").click();
		Thread.sleep(3000);
		
		driver.findElement(By.id("com.android.dialer:id/one")).click();
		
		driver.findElement(By.id("com.android.dialer:id/two")).click();
		
		driver.findElement(By.id("com.android.dialer:id/three")).click();	
		
		driver.findElement(By.id("com.android.dialer:id/dialpad_floating_action_button")).click();
		
		Thread.sleep(3000);
		driver.quit();
		
		}
		catch(Exception e){
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
		}
		
		
	}

}
