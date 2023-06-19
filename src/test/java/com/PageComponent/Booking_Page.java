package com.PageComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Utilities.WebUtils;
import com.aventstack.extentreports.Status;

public class Booking_Page extends WebUtils {

	@FindBy (xpath = "//div[@data-testid='continue-search-page-cta']")
	WebElement Continue;

	@FindBy (xpath = "//input[@placeholder='DD/MM/YYYY' and @data-testid='traveller-0-date-of-birth-field']")
	WebElement dobclick;

	@FindBy (xpath = "(//div[@class='css-76zvg2 r-homxoj r-poiln3 r-edyy15 r-q4m81j'])[16]")
	WebElement year;

	@FindBy (xpath = "(//div[@class='css-76zvg2 r-homxoj r-poiln3 r-edyy15 r-q4m81j'])[5]")
	WebElement month;

	@FindBy (xpath = "(//div[@class='css-1dbjc4n r-1loqt21 r-1otgn73'])[12]")
	WebElement day;

	@FindBy (xpath = "//input[@maxlength='32' and @data-testid='first-inputbox-contact-details']")
	WebElement firstname;

	@FindBy (xpath = "//input[@maxlength='32' and @data-testid='last-inputbox-contact-details']")
	WebElement lastname;

	@FindBy (xpath = "//input[@maxlength='266' and @data-testid='emailAddress-inputbox-contact-details']")
	WebElement emailtext ;

	@FindBy (xpath = "//input[@maxlength='10' and @data-testid='contact-number-input-box']")
	WebElement mobile;

	@FindBy (xpath = "(//div[@class='css-76zvg2 r-qsz3a2 r-poiln3 r-1b43r93 r-16dba41'])[4]")
	WebElement checkbox;

	@FindBy (xpath = "//input[@maxlength='15'and @class='css-1cwyjr8 r-homxoj r-poiln3 r-ubezar r-1eimq0t r-1e081e0 r-xfkzu9 r-lnhwgy']")
	WebElement passportno;

	@FindBy (xpath = "(//input[@placeholder='DD/MM/YYYY'])[2]")
	WebElement passportvalidity;

	@FindBy (xpath = "//div[text()='2025']")
	WebElement passportyear;

	@FindBy (xpath = "//div[text()='Apr']")
	WebElement passportmonth;

	@FindBy (xpath = "//div[text()='5']")
	WebElement passportday;

	@FindBy (xpath = "//div[@data-testid='traveller-info-continue-cta']")
	WebElement continuepayment;
	
	public Booking_Page(){
		PageFactory.initElements(WebUtils.driver, this);}

	public void booking_Code(){

		try {
			test.log(Status.INFO, "Continued To Booking Page");
			clickbtn(Continue);
			clickbtn(passportvalidity);
			clickbtn(passportyear);
			clickbtn(passportmonth);
			clickbtn(passportday);
			sendkey(firstname, readProperty("fname"));
			sendkey(lastname, readProperty("lname"));
			sendkey(emailtext,readProperty("email"));
			sendkey(mobile, readProperty("mob"));
			clickbtn(checkbox);
			implicitWait(3);
			clickbtn(dobclick);
			clickbtn(year);
			clickbtn(month);
			clickbtn(day);
			sendkey(passportno, readProperty("passnumber"));
			clickbtn(continuepayment);
			test.log(Status.INFO, "Entered Customer Information");
			} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
}













