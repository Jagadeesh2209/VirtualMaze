package com.VmRunner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.VmTest.VMTest;
import com.base.BaseClass;

public class Runner extends BaseClass {

	public static WebDriver driver;

	@BeforeTest
	public static void setUp() {
		
		driver=launchBrowser("chrome");
		implicitWait(30);
	}

	@Test
	public void executeTest() {

		VMTest test = new VMTest();
		test.VMWrongRegister();
		test.VMRegisteration();
		test.VMReRegisteration();
		test.login();
		test.logout();
		test.wrongLogin1();
		test.wrongLogin2();
		test.forgetPass();
		test.forgetpassotp();
	
	}
	
	
	
	@AfterTest
	public static void teardown() throws Throwable {
		quitBrowser();
	}
	
}
