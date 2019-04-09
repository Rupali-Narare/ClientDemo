package com.NAQTS.tescoApp.pom.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.NAQTS.tescoApp.pom.BaseTest.BaseTest;
import com.NAQTS.tescoApp.pom.pages.LaunchApp;
import com.NAQTS.tescoApp.pom.pages.LoginScreen;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class LoginTest extends BaseTest{
	
	//AndroidDriver<MobileElement> driver;
	//public ExtentReports extent = ExtentManager.getInstance();
	//public ExtentTest test;
	
	
	@Test
	public void LoginTest() {
		Reporter.log("Test Android");
		test = extent.startTest("Login Test");
		test.log(LogStatus.INFO, "Starting login test");
		test.log(LogStatus.INFO, "Opening device");
		init("Android");
		
			test.log(LogStatus.INFO, "Login Test");
		LaunchApp launchApp = new LaunchApp(driver, test);
		PageFactory.initElements(new AppiumFieldDecorator(driver), launchApp);
		LoginScreen loginscreen=launchApp.goToLoginScreen();
		launchApp.takeScreenShot();
	
		test.log(LogStatus.PASS, "Navigate to Login Screen");
		loginscreen.takeScreenShot();
	
		//PageFactory.initElements(driver, launchApp);
		
		//LoginScreen loginscreen = launchApp.goToLoginScreen();
		
		//LoginScreen loginscreen = new LoginScreen(driver, test);
		
		try {
			loginscreen.doLogin("sayom4u@gmail.com", "Zzxx5566");
			loginscreen.takeScreenShot();
			test.log(LogStatus.PASS, "Login Success");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			test.log(LogStatus.FAIL, "Login Fail");
		}
		
		
		
	}
	@AfterMethod
	public void quit(){
		if(extent!=null){
			extent.endTest(test);
			extent.flush();
		}
		if(driver!=null)
			driver.quit();
	}

}
