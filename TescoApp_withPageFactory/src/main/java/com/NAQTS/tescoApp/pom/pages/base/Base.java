package com.NAQTS.tescoApp.pom.pages.base;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.NAQTS.tescoApp.pom.Util.FBConstants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Base {
	
	protected AndroidDriver<MobileElement> driver;
	public ExtentTest test;
	public Base(){}
	
	public Base(AndroidDriver<MobileElement> driver, ExtentTest test){
		this.driver=driver;
		this.test=test;
		//PageFactory.initElements(new AppiumFieldDecorator(driver), this);
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
	
	public void reportFailure(String failureMessage){
		test.log(LogStatus.FAIL, failureMessage);
		takeScreenShot();
		//Assert.fail(failureMessage);
	}
	

}
