package com.PageComponent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Utilities.WebUtils;



public class Login_Page extends WebUtils{
	@FindBy(xpath= "(//div[@class='css-76zvg2 r-jwli3a r-ubezar'])[1]")
	WebElement LoginBtn;

	@FindBy(xpath= "//input[@data-testid='user-mobileno-input-box']")
	WebElement usermobilenum;

	@FindBy(xpath= "//input[@data-testid='password-input-box-cta']")
	WebElement passwordtext;

	@FindBy(xpath= "//div[@data-testid='login-cta']")
	WebElement submitbtn;

	@FindBy(xpath= "(//div[@class='css-76zvg2 r-homxoj r-ubezar r-1ozqkpa'])[4]")
	WebElement emailradiobtn;
	
	@FindBy(xpath= "//div[@class='css-76zvg2 r-jwli3a']")
	WebElement signinValidation;
	
	@FindBy(xpath= "//div[@class='css-76zvg2 r-1ttbpl1 r-18tvxmy r-1enofrn r-1bymd8e']")
	WebElement signinInvalidValidation;
	
	
	
	public Login_Page(){
		PageFactory.initElements(WebUtils.driver, this);
	}
	
	public void valid_Login_code(String Username, String Password) {
		clickbtn(LoginBtn);
		sendkey(usermobilenum, Username);
		sendkey(passwordtext,Password);
		clickbtn(submitbtn);
		implicitWait(3);
		getScreenShot("ValidLogin");
		String text = getText(signinValidation);
		Assert.assertEquals("N", text);}
	
	public void invalid_Login_code(String Username, String Password) {
		clickbtn(LoginBtn);
		sendkey(usermobilenum, Username);
		sendkey(passwordtext,Password);
		clickbtn(submitbtn);
		implicitWait(3);
		getScreenShot("InvalidLogin");
		String text = getText(signinInvalidValidation);
		Assert.assertEquals("Please enter a valid mobile number", text);}
	
	public void blank_Login_code(String Username, String Password) {
		clickbtn(LoginBtn);
		sendkey(usermobilenum, Username);
		sendkey(passwordtext,Password);
		clickbtn(submitbtn);
		implicitWait(3);
		getScreenShot("BlankLogin");
		String text = getText(signinInvalidValidation);
		Assert.assertEquals("Please enter a valid mobile number", text);}
	
	


}
