package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VMSignin {
	
	WebDriver driver;

	@FindBy(id="login-email")
	private WebElement email;
	
	@FindBy(id="login-password")
	private WebElement password;
	
	@FindBy(id = "login-submit-text")
	private WebElement loginBtn;
	
	@FindBy(className = "Sign-Up-Pop")
	private WebElement signinbtn;
	
	public WebElement getSigninbtn() {
		return signinbtn;
	}
	public WebElement getUsername() {
		return email;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	public VMSignin(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(this.driver, this);
		
	}
	
	
	
	
}
