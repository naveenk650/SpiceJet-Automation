package com.TestComponent;
import org.testng.annotations.Test;
import com.EngineComponent.BaseClass;
import com.PageComponent.Login_Page;


public class Tc_004_LoginPage extends BaseClass{

	@Test
	public void valid_username_Password() {//Positive Test Case
		//Verify if a user will be able to login with a valid username and valid password.
		try {
			Login_Page lp = new Login_Page();
			lp.valid_Login_code(readProperty("Username"), readProperty("Password"));
		} catch (Throwable e) {
			e.printStackTrace();
		}

	}
	@Test
	public void inValidUsername_InvalidPassword() {//Negative Test Case
		//Verify if a user cannot login with a invalid username and an invalid password.
		try {
			Login_Page lp = new Login_Page();
			lp.invalid_Login_code(readProperty("Password"),readProperty("Username"));
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	@Test
	public void blank_Username_Password() {//Negative Test Case
		//Verify the login page for both, when the field is blank and Submit button is clicked.
		try {
			Login_Page lp = new Login_Page();
			lp.blank_Login_code(readProperty(""),readProperty(""));
		} catch (Throwable e) {
			e.printStackTrace();
		}


	}


}
