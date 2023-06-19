package com.TestComponent;

import org.testng.annotations.Test;

import com.EngineComponent.BaseClass;
import com.PageComponent.SignUp_Page;

public class Tc_001_SignUp extends BaseClass {


@Test
	public void Valid_credentials() throws Throwable{

		SignUp_Page sp = new SignUp_Page();
		sp.signupCode();
	}


















}
