package com.NAQTS.tescoApp.pom.BaseTest;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.NAQTS.tescoApp.pom.Util.ExtentManager;
import com.NAQTS.tescoApp.pom.Util.FBConstants;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class BaseTest {
	
	public ExtentReports extent = ExtentManager.getInstance();
	public ExtentTest test;
	public AndroidDriver<MobileElement> driver;
	
	public void init(String dType){
		test.log(LogStatus.INFO, "Opening "+ dType + " device");
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "CIC Lansing - Galaxy S7");
		caps.setCapability("udid", "ce0516051cd7ef1103"); //Give Device ID of your mobile phone
		caps.setCapability("platformName", dType);
		caps.setCapability("platformVersion", "8.0");
		caps.setCapability("appPackage", "com.tesco.grocery.view");
		caps.setCapability("appActivity", "tescoui.activities.TabSplashScreenActivity");
		caps.setCapability("automationName", "uiautomator2");
		caps.setCapability("app", "/Users/rupalinarare/Downloads/TescoApp.apk");
		/*caps.setCapability("automationName", "uiautomator2");
		caps.setCapability("browserName", "Chrome");*/
		//caps.setCapability("noReset", true);

		/*
		 * We initialize the Appium driver that will connect us to the Android
		 * device with the capabilities that we have just set. The URL we are
		 * providing is telling Appium we are going to run the test locally.
		 */
		
		    try {
				driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.manage().timeouts().implicitlyWait(40000, TimeUnit.MILLISECONDS);
	}

	public void reportFailure(String failureMessage){
		test.log(LogStatus.FAIL, failureMessage);
		takeScreenShot();
		//Assert.fail(failureMessage);
	}
	
	public void takeScreenShot(){
		Date d=new Date();
		String screenshotFile=d.toString().replace(":", "_").replace(" ", "_")+".png";
		String filePath=FBConstants.REPORTS_PATH+"screenshots//"+screenshotFile;
		// store screenshot in that file
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(scrFile, new File(filePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(LogStatus.INFO,test.addScreenCapture(filePath));
	}
}
