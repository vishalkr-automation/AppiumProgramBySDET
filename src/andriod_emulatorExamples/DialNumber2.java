package andriod_emulatorExamples;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DialNumber2 {
	
	@Test
	public void f(){
		DesiredCapabilities dc=new DesiredCapabilities();
		try{
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0.1");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Bijaya");
		dc.setCapability("udid", "101a6c167d03");
		
		dc.setCapability("appPackage", "com.religare.staging");
		dc.setCapability("appActivity", "com.religare.healthinsurance.view.ui_activity.ui.fragment.onboarding.SplashActivity");
		
		Thread.sleep(2000);
		
		URL url=new URL("http://127.0.0.1:4723/wd/hub");
		AndroidDriver<WebElement> driver=new AndroidDriver<WebElement>(url,dc);
		
		Thread.sleep(5000);
		
		driver.findElement(By.id("com.religare.staging:id/ivNext")).click();
		
		/*Thread.sleep(5000);
		
		//driver.findElement(By.id("com.google.android.dialer:id/fab")).click();
		driver.findElementById("com.google.android.dialer:id/floating_action_button").click();
		Thread.sleep(3000);
		
		driver.findElement(By.id("com.google.android.dialer:id/one")).click();
		
		driver.findElement(By.id("com.google.android.dialer:id/two")).click();
		
		driver.findElement(By.id("com.google.android.dialer:id/three")).click();	
		
		driver.findElement(By.id("com.google.android.dialer:id/dialpad_floating_action_button")).click();
		
		Thread.sleep(3000);
		driver.quit();*/
		
		}
		catch(Exception e){
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
		}
		
		
	}

}
