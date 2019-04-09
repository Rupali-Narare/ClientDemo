package com.NAQTS.tescoApp.pom.pages;

import org.openqa.selenium.support.PageFactory;

import com.NAQTS.tescoApp.pom.pages.base.Base;
import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LaunchApp extends Base{
	
	//AndroidDriver<MobileElement> driver;
	//public ExtentTest test;
	public LaunchApp(AndroidDriver<MobileElement> driver, ExtentTest test){
		//this.driver=driver;
		//this.test=test;
		super(driver, test);
		//PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	// Gets handle to all UIAButton class/type elements in the screen
		@AndroidFindBy(xpath = "//*[@text='Sign in']")
		public MobileElement goToSignIn;
	
	public LoginScreen goToLoginScreen(){
		goToSignIn.click();
		LoginScreen loginscreen=new LoginScreen(driver,test);
		PageFactory.initElements(new AppiumFieldDecorator(driver), loginscreen);
		return loginscreen;
		
		
	}

}
