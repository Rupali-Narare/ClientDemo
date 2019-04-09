package com.NAQTS.tescoApp.pom.pages.session;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class LandingScreen {
	
	AndroidDriver<MobileElement> driver;
	public LandingScreen(AndroidDriver<MobileElement> driver){
		this.driver = driver;
	}
	
	public HomeScreen gotoHomeScreen(){
		
		return PageFactory.initElements(driver, HomeScreen.class);
		//return homeScreen;
	}

}
