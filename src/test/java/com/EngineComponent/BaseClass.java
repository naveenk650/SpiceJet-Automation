package com.EngineComponent;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.Utilities.WebUtils;

public class BaseClass extends WebUtils{


	@BeforeSuite(alwaysRun=true)
	public void beforesuite() {
		startReport();

	}

	@BeforeMethod(alwaysRun=true)
	public void beforemethod() {
		test = reports.createTest("Automation Test Report");
		browserlaunch(readProperty("browser"));
		implicitWait(3);
		geturl(readProperty("url"));


	}

	@AfterMethod(alwaysRun=true)
	public void aftermethod() {
		browserClose();
		stopReport();


	}

	@AfterSuite(alwaysRun=true)
	public void aftersuite() {
	stopReport();
	}


	

}
