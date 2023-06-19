package com.PageComponent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utilities.WebUtils;

public class SignUp_Page extends WebUtils {

	@FindBy(xpath = "//div[text()='Signup']")
	WebElement signup;

	@FindBy(xpath = "//select[@class='form-control form-select ']")
	WebElement titleselect;

	@FindBy(xpath = "//input[@id='first_name']")
	WebElement firstnametext;

	@FindBy(xpath = "//input[@id='last_name']")
	WebElement lastnametext;

	@FindBy(xpath = "//select[@class='form-control form-select']")
	WebElement countryselect;

	@FindBy(xpath = "//input[@id='dobDate']")
	WebElement dobtext;

	@FindBy(xpath = "//input[@id='email_id']")
	WebElement emailtext;

	@FindBy(xpath = "//div[@class='selected-flag']")
	WebElement flag;

	@FindBy(xpath="//input[@type='tel']")
	WebElement phonetext;

	@FindBy(xpath = "//input[@id='new-password']")
	WebElement password;

	@FindBy(xpath = "//input[@id='c-password']")
	WebElement confirmpassword;

	@FindBy(xpath = "//input[@id='defaultCheck1']")
	WebElement tcagree;

	@FindBy(xpath = "//button[@class='btn btn-red']")
	WebElement submitbtn;

	@FindBy(xpath = "//li[@data-flag-key='flag_no_84']")
	WebElement indiaflag;



	public SignUp_Page() {
		PageFactory.initElements(WebUtils.driver, this);
	}

	public void signupCode() throws Throwable {
		try {
			clickbtn(signup);
			implicitWait(3);
			windowHandles();
			selectDownVisible(titleselect, "Mr");
			sendkey(firstnametext, readProperty("fname"));
			sendkey(lastnametext,readProperty("lname"));
			sendkey(dobtext, readProperty("dob"));
			selectDownVisible(countryselect, "India");
			sendkey(phonetext, readProperty("mob"));
			sendkey(emailtext, readProperty("email"));
			sendkey(password, readProperty("Password"));
			sendkey(confirmpassword, readProperty("Password"));
			clickbtn(tcagree);
			clickbtn(submitbtn);
			getScreenShot("SignUp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
