package com.PageComponent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.Utilities.WebUtils;
import com.aventstack.extentreports.Status;

public class Homepage_fields extends WebUtils {

	@FindBy(xpath = "(//div[@class='css-76zvg2 r-cqee49 r-ubezar r-1ozqkpa'])[1]")
	WebElement CheckIn;

	@FindBy(xpath = "(//div[@class='css-76zvg2 r-cqee49 r-ubezar r-1ozqkpa'])[2]")
	WebElement FlightStatus;

	@FindBy(xpath = "(//div[@class='css-76zvg2 r-cqee49 r-ubezar r-1ozqkpa'])[3]")
	WebElement ManageBooking;

	public Homepage_fields() {
		PageFactory.initElements(WebUtils.driver, this);}


	public void field_code() {
		try {
			String text1 = getText(CheckIn);
			Assert.assertEquals("Check-In", text1);
			test.log(Status.PASS, text1+" : Validated Sucessfully");
			String text2 = getText(FlightStatus);
			Assert.assertEquals("Flight Status", text2);
			test.log(Status.PASS, text2+" : Validated Sucessfully");
			String text3 = getText(ManageBooking);
			Assert.assertEquals("Manage Booking", text3);
			test.log(Status.PASS, text3+" : Validated Sucessfully");
			getScreenShot("HomepageFields");

		} catch (Exception e) {
			e.printStackTrace();
		}







	}





















}