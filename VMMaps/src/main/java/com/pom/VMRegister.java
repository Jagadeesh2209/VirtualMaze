package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VMRegister {

	WebDriver driver;
	
	@FindBy(id = "registerHere")
	private WebElement registerhere;
	
	@FindBy(id = "signup-username")
	private WebElement fullname;
	
	@FindBy(id = "signup-email")
	private WebElement email;
	
	@FindBy(id = "signup-mobile")
	private WebElement mobile;
	
	@FindBy(id = "signup-password")
	private WebElement password;
	
	@FindBy(id = "signup-confirmPassword")
	private WebElement confirmpass;
	
	@FindBy(id = "terms-vms-policy")
	private WebElement agree;
	
	@FindBy(id = "newsLetter")
	private WebElement newsletter;
	
	@FindBy(id = "signup-submit-text")
	private WebElement registerbtn;
	
	@FindBy(className = "Sign-Up-Pop")
	private WebElement register;
	
	@FindBy(id = "registerHere")
	private WebElement signup;
	
	
	public WebElement getSignup() {
		return signup;
	}
	public WebElement getSignin() {
		return register;
	}
	public WebElement getRegisterHere() {
		return registerhere;
	}
	public WebElement getFullName() {
		return fullname;
	}
	public WebElement getEmail() {
		return email;
	}
	public WebElement getMobile() {
		return mobile;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getConfirmPass() {
		return confirmpass;
	}
	public WebElement getAgree() {
		return agree;
	}
	public WebElement getNewsLetter() {
		return newsletter;
	}
	public WebElement getRegisterBTN() {
		return registerbtn;
	}
	
	public VMRegister(WebDriver driver) {

	
		this.driver = driver;
		
		PageFactory.initElements(this.driver, this);
		
		
	}
	
}
