package andriod_emulatorExamples;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class TextBox_CheckBox_Example {
	@Test
	public void f(){
		DesiredCapabilities dc=new DesiredCapabilities();
		try{
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1.0");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		dc.setCapability("udid", "emulator-5554");
		
		dc.setCapability("appPackage", "io.selendroid.testapp");
		dc.setCapability("appActivity", "io.selendroid.testapp.HomeScreenActivity");
		
		Thread.sleep(2000);
		
		URL url=new URL("http://127.0.0.1:4723/wd/hub");
		AndroidDriver<WebElement> driver=new AndroidDriver<WebElement>(url,dc);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("io.selendroid.testapp:id/waitingButtonTest")).click();
		
		Thread.sleep(10000);
		
		//Enter Text Box
		driver.findElement(By.id("io.selendroid.testapp:id/inputUsername")).sendKeys("Tester");
		
		driver.navigate().back();
		
		//Clicked On Check Box
		driver.findElement(By.id("io.selendroid.testapp:id/input_adds")).click();
		
		
		//Drop Down
		Thread.sleep(2000);
		driver.findElement(By.id("io.selendroid.testapp:id/input_preferedProgrammingLanguage")).click();
		
		Thread.sleep(1000);
		 
		driver.findElementByAndroidUIAutomator("UiSelector().text(\"PHP\")").click();
		
		Thread.sleep(3000);
		driver.quit();
		
		}
		catch(Exception e){
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
		}
		
		
	}

}
