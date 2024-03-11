package com.VmTest;

import org.openqa.selenium.WebDriver;

import com.VmRunner.Runner;
import com.base.BaseClass;
import com.pageObjectManager.PageObjectManager;

public class VMTest extends BaseClass{

	WebDriver driver = Runner.driver;
	
	PageObjectManager pom = new PageObjectManager(driver);
	
	public void VMWrongRegister() {
		//Attempt to register without mobile number

		launchUrl("https://accounts.vmmaps.com/");
		pom.getVMRegister().getRegisterHere().click();
		pom.getVMRegister().getFullName().sendKeys("Jagadeesh Krishnan");
		pom.getVMRegister().getEmail().sendKeys("jagadeeshkrishnan2209@gmail.com");
		pom.getVMRegister().getPassword().sendKeys("Virtualmaze");
		pom.getVMRegister().getConfirmPass().sendKeys("Virtualmaze");
		pom.getVMRegister().getAgree().click();
		pom.getVMRegister().getNewsLetter().click();
		pom.getVMRegister().getRegisterHere().click();
		
	}
	
	public void VMRegisteration() {
		launchUrl("https://accounts.vmmaps.com/");
		pom.getVMRegister().getRegisterHere().click();
		pom.getVMRegister().getFullName().sendKeys("Jagadeesh Krishnan");
		pom.getVMRegister().getEmail().sendKeys("jagadeeshkrishnan2209@gmail.com");
		pom.getVMRegister().getMobile().sendKeys("8838730691");
		pom.getVMRegister().getPassword().sendKeys("Virtualmaze");
		pom.getVMRegister().getConfirmPass().sendKeys("Virtualmaze");
		pom.getVMRegister().getAgree().click();
		pom.getVMRegister().getNewsLetter().click();
		pom.getVMRegister().getRegisterHere().click();
	}
	
	public void VMReRegisteration() {
		//register with already registered account
		launchUrl("https://accounts.vmmaps.com/");
		pom.getVMRegister().getRegisterHere().click();
		pom.getVMRegister().getFullName().sendKeys("Jagadeesh Krishnan");
		pom.getVMRegister().getEmail().sendKeys("jagadeeshkrishnan2209@gmail.com");
		pom.getVMRegister().getMobile().sendKeys("8838730691");
		pom.getVMRegister().getPassword().sendKeys("Virtualmaze");
		pom.getVMRegister().getConfirmPass().sendKeys("Virtualmaze");
		pom.getVMRegister().getAgree().click();
		pom.getVMRegister().getNewsLetter().click();
		pom.getVMRegister().getRegisterHere().click();
	}
	
	public void login() {

		launchUrl("https://accounts.vmmaps.com/");
		pom.getVMSignin().getSigninbtn().click();
		pom.getVMSignin().getUsername().sendKeys("jagadeeshkrishnan2209@gmail.com");
		pom.getVMSignin().getPassword().sendKeys("Virtualmaze");
		pom.getVMSignin().getLoginBtn().click();
		
	}
	
	public void logout() {

		launchUrl("https://accounts.vmmaps.com/");
		pom.getVMSignin().getSigninbtn().click();
		pom.getVMSignin().getUsername().sendKeys("jagadeeshkrishnan2209@gmail.com");
		pom.getVMSignin().getPassword().sendKeys("Virtualmaze");
		pom.getVMSignin().getLoginBtn().click();
		pom.getVMLogout().getSettingDrop().click();
		pom.getVMLogout().getSignOutBtn().click();
		
	}
	
	public void wrongLogin1() {
		//login without password

		launchUrl("https://accounts.vmmaps.com/");
		pom.getVMSignin().getSigninbtn().click();
		pom.getVMSignin().getUsername().sendKeys("jagadeeshkrishnan2209@gmail.com");
		pom.getVMSignin().getPassword().sendKeys("");
		pom.getVMSignin().getLoginBtn().click();
		
	}
	
	public void wrongLogin2() {
		//login without email

		launchUrl("https://accounts.vmmaps.com/");
		pom.getVMSignin().getSigninbtn().click();
		pom.getVMSignin().getUsername().sendKeys("");
		pom.getVMSignin().getPassword().sendKeys("Virtualmaze");
		pom.getVMSignin().getLoginBtn().click();
		
	}
	
	public void forgetPass() {

		launchUrl("https://accounts.vmmaps.com/");
		pom.getVMSignin().getSigninbtn().click();
		pom.getVMSignin().getUsername().sendKeys("jagadeeshkrishnan2209@gmail.com");
		pom.getVMChangePass().getforgetpass().click();
		//enter otp
		pom.getVMChangePass().getPasswordInput().sendKeys("Virtualmaze");
		pom.getVMChangePass().getChangeBtn().click();
		
	}
	
	public void forgetpassotp() {

		launchUrl("https://accounts.vmmaps.com/");
		pom.getVMSignin().getSigninbtn().click();
		pom.getVMSignin().getUsername().sendKeys("jagadeeshkrishnan2209@gmail.com");
		pom.getVMChangePass().getforgetpass().click();
		pom.getVMChangePass().getResendOTP().click();
		//enter otp
		pom.getVMChangePass().getPasswordInput().sendKeys("Virtualmaze");
		pom.getVMChangePass().getChangeBtn().click();
		
	}
	
}
