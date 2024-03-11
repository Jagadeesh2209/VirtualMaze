package com.pageObjectManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.pom.VMChangePass;
import com.pom.VMLogout;
import com.pom.VMRegister;
import com.pom.VMSignin;

public class PageObjectManager {

	WebDriver driver;
	
	private VMSignin Signin;
	private VMChangePass ChangePass;
	private VMLogout Logout;
	private VMRegister Register;
	
	
	
	public VMSignin getVMSignin() {
		Signin = new VMSignin(driver);
		return Signin;
	}
	public VMChangePass getVMChangePass() {
		ChangePass = new VMChangePass(driver);
		return ChangePass;
	}
	public VMLogout getVMLogout() {
		Logout = new VMLogout(driver);
		return Logout;
	}
	public VMRegister getVMRegister() {
		Register = new VMRegister(driver);
		return Register;
	}
	
	
	public PageObjectManager(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	
	}
	
}
