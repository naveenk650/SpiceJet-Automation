package com.PageComponent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Utilities.WebUtils;
import com.aventstack.extentreports.Status;


public class Search_Flights extends WebUtils{


	@FindBy (xpath = "(//div[@class='css-76zvg2 r-homxoj r-ubezar r-1ozqkpa'])[2]")
	WebElement roundtrip;

	@FindBy (xpath = "(//div[text()='27'])[9]")
	WebElement returndate;

	@FindBy (xpath = "(//div[@class='css-76zvg2 css-bfa6kz r-homxoj r-ubezar'])[1]")
	WebElement date;

	@FindBy (xpath = "(//div[text()='20'])[9]")
	WebElement depdate;

	@FindBy (xpath = "//div[@class='css-1dbjc4n r-1loqt21 r-u8s1d r-11xbo3g r-1v2oles r-1otgn73 r-16zfatd r-eafdt9 r-1i6wzkk r-lrvibr r-184en5c']")
	WebElement arrow;

	@FindBy (xpath = "(//input[@type='text'])[1]")
	WebElement from;

	@FindBy (xpath = "(//input[@type='text'])[2]")
	WebElement To;

	@FindBy (xpath = "//div[@data-testid='home-page-flight-cta']")
	WebElement SearchFlights;

	@FindBy (xpath = "//div[@class='css-76zvg2 r-homxoj r-adyw6z r-1kfrs79']")
	WebElement validation;


	public Search_Flights(){
		PageFactory.initElements(WebUtils.driver, this);}

	public void oneWay_Trip() {
		try {
			sendkey(from, "BOM");
			sendkey(To, "BKK");
			for(int i=1;i<=4;i++) {
				jsclick(arrow);}
			implicitWait(10);
			clickbtn(depdate);
			clickbtn(SearchFlights);
			String text = getText(validation);
			Assert.assertEquals("Select your Departure to Bangkok", text);
			test.log(Status.PASS, "Oneway Trip Validation Sucessfull");
			implicitWait(10);
			getScreenShot("OnewayTrip");
		} catch (Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, "Oneway Trip Validation Failed");
		}}

	public void round_Trip() {
		try {
			clickbtn(roundtrip);
			sendkey(from, "BOM");
			sendkey(To, "BKK");
			for(int i=1;i<=4;i++) {
				jsclick(arrow);}
			implicitWait(10);
			clickbtn(depdate);
			clickbtn(returndate);
			clickbtn(SearchFlights);
			String text = getText(validation);
			Assert.assertEquals("Select your Departure to Bangkok", text);
			test.log(Status.PASS, "RounTrip Trip Validation Sucessfull");
			implicitWait(10);
			getScreenShot("Roundtrip");
		} catch (Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, "RoundTrip Trip Validation Failed");
		}













	}

























}
