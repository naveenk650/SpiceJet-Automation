package com.PageComponent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Utilities.WebUtils;

public class Search_Flights extends WebUtils{

	@FindBy (xpath = "(//div[@class='css-76zvg2 r-homxoj r-ubezar r-1ozqkpa'])[2]")
	WebElement roundtrip;

	@FindBy (xpath = "(//div[@class='css-76zvg2 r-homxoj r-ubezar r-16dba41'])[36]")
	WebElement returndate;

	@FindBy (xpath = "(//div[@class='css-76zvg2 css-bfa6kz r-homxoj r-ubezar'])[1]")
	WebElement date;

	@FindBy (xpath = "(//div[@class='css-1dbjc4n r-1awozwy r-1pi2tsx r-1777fci r-13qz1uu'])[29]")
	WebElement depdate;

	@FindBy (xpath = "(//input[@type='text'])[1]")
	WebElement from;

	@FindBy (xpath = "(//input[@type='text'])[2]")
	WebElement To;

	@FindBy (xpath = "//div[@data-testid='home-page-flight-cta']")
	WebElement SearchFlights;

	@FindBy (xpath = "//div[@class='css-76zvg2 r-homxoj r-1hfyk0a']")
	WebElement validation;


	public Search_Flights(){
		PageFactory.initElements(WebUtils.driver, this);}


	public void oneWay_Trip() {
		try {
			sendkey(from, "BOM");
			sendkey(To, "BKK");
			clickbtn(depdate);
			clickbtn(SearchFlights);
			implicitWait(5);
			String text = getText(validation);
			System.out.println(text);
		//	Assert.assertEquals("Select your Departure to Bangkok", text);
			
		} catch (Exception e) {
			e.printStackTrace();
		}}

	public void round_Trip() {
		try {
			clickbtn(roundtrip);
			sendkey(from, "BOM");
			sendkey(To, "BKK");
			clickbtn(depdate);
			clickbtn(returndate);
			clickbtn(SearchFlights);
			implicitWait(5);
			String text = getText(validation);
			Assert.assertEquals("Select your Departure to Bangkok", text);
		} catch (Exception e) {
			e.printStackTrace();
		}













	}

























}
