package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VMChangePass {
	
	WebDriver driver;


	
	@FindBy(id = "Forgot-Password")
	private WebElement forgetpass;
	
	@FindBy(id = "login-email")
	private WebElement email;
	
	@FindBy(id = "Resetpassword")
	private WebElement password;
	
	@FindBy(id = "ResetresendOTP")
	private WebElement resendotp;
	
	@FindBy(id = "reset-login-otp-text")
	private WebElement changebtn;
	
	@FindBy(id = "firstResetOTP")
	private WebElement otp1;
	
	@FindBy(id = "secondResetOTP")
	private WebElement otp2;
	
	@FindBy(id = "thirdResetOTP")
	private WebElement otp3;
	
	@FindBy(id = "fourthResetOTP")
	private WebElement otp4;
	
	@FindBy(id = "fifthResetOTP")
	private WebElement otp5;
	
	@FindBy(id = "sixthResetOTP")
	private WebElement otp6;
	
	public WebElement getOtp1() {
		return otp1;
	}
	public WebElement getOtp2() {
		return otp2;
	}
	public WebElement getOtp3() {
		return otp3;
	}
	public WebElement getOtp4() {
		return otp4;
	}
	public WebElement getOtp5() {
		return otp5;
	}
	public WebElement getOtp6() {
		return otp6;
	}
	public WebElement getforgetpass() {
		return forgetpass;
	}
	public WebElement getEmailInput() {
		return email;
	}
	public WebElement getPasswordInput() {
		return password;
	}
	public WebElement getResendOTP() {
		return resendotp;
	}
	public WebElement getChangeBtn() {
		return changebtn;
	}
	
	
	public VMChangePass(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(this.driver, this);
		
	}
	
	
	
	
	
	
	
	
}
