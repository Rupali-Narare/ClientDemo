package com.NAQTS.tescoApp.pom.pages;

import com.NAQTS.tescoApp.pom.pages.base.Base;
import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginScreen extends Base{
	
	//AndroidDriver<MobileElement> driver;

	//public ExtentTest test;
	public LoginScreen(AndroidDriver<MobileElement> driver, ExtentTest test){
		//this.driver = driver;
		//this.test=test;
		super(driver, test);
		//PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	// Gets handle to all UIAButton class/type elements in the screen
		@AndroidFindBy(xpath = "//*[@text='Sign in']")
		public MobileElement goToSignIn;
		
		@AndroidFindBy(id = "username_et")
		public MobileElement usernameField;
		
		@AndroidFindBy(id = "password_et")
		public MobileElement passwordField;
		
		@AndroidFindBy(xpath = "//*[@text='Sign in']")
		public MobileElement signInBtn;
		
		
		//WebDriverWait wait = new WebDriverWait(driver, 60);

		//Login to the app using given credentials
		public void doLogin(String username, String password) throws InterruptedException {
		
			//wait.until(ExpectedConditions.visibilityOf(usernameField));
			//if(isElementPresent(usernameField)){
			//goToSignIn.click();
				usernameField.click();
				usernameField.sendKeys(username);
				passwordField.click();
				passwordField.sendKeys(password);
				driver.hideKeyboard();
				signInBtn.click();
				//return PageFactory.initElements(driver, LandingScreen.class);
				//return landingScreen;
			//}
		}
		

}
