package com.PageComponent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Utilities.WebUtils;
import com.aventstack.extentreports.Status;

public class PaymentPage extends WebUtils{

	@FindBy (xpath = "//div[@data-testid='review-details-prepayment']")
	WebElement ReviewBooking;

	@FindBy (xpath = "(//div[text()='Continue'])[3]")
	WebElement addoncontinue;

	@FindBy (xpath = "(//div[text()='Add'])[3]")
	WebElement add;

	@FindBy (xpath = "(//div[text()='30E'])[1]")
	WebElement seat;

	@FindBy (xpath = "//div[text()='Done']")
	WebElement done;

	@FindBy (xpath = "(//div[@class='css-1dbjc4n r-1loqt21 r-1otgn73'])[2]")
	WebElement closereview;

	@FindBy (xpath = "//input[@name='card_number']")
	WebElement cardnumbertextbox;

	@FindBy (xpath = "//input[@placeholder='Cardholder Name']")
	WebElement cardholdername;

	@FindBy (xpath = "//input[@id='card_exp_month']")
	WebElement expmonth;

	@FindBy (xpath = "//input[@id='card_exp_year']")
	WebElement expyear;

	@FindBy (xpath = "//input[@id='security_code']")
	WebElement cvv;

	@FindBy (xpath = "//div[@data-testid='common-proceed-to-pay']")
	WebElement proceed;

	@FindBy (xpath = "//iframe[@class='card_number_iframe']")
	WebElement cardframe;

	@FindBy (xpath = "//iframe[@class='name_on_card_iframe']")
	WebElement nameframe;

	@FindBy (xpath = "//iframe[@class='card_exp_month_iframe']")
	WebElement expmmframe;

	@FindBy (xpath = "//iframe[@class='card_exp_year_iframe']")
	WebElement expyyframe;

	@FindBy (xpath = "//iframe[@class='security_code_iframe']")
	WebElement cvvframe;

	@FindBy (xpath = "//div[@id='payment_form_card_number_error']")
	WebElement paymenterror;

	public PaymentPage(){
		PageFactory.initElements(WebUtils.driver, this);}


	public void payment_code() {
		try {
			clickbtn(add);
			clickbtn(seat);
			clickbtn(done);
			jsclick(addoncontinue);
			implicitWait(10);
			clickbtn(ReviewBooking);
			getScreenShot("Booking Page");
			String text = getText(ReviewBooking);
			Assert.assertEquals("Review Booking", text);
			test.log(Status.PASS, "Booking Page Validation Sucessfull");}
		catch (Exception e) {
			e.printStackTrace();
			test.log(Status.INFO, "Continued To Payment Page");
		}

		try {
			clickbtn(closereview);
			implicitWait(10);
			frameIn(cardframe);
			sendkey(cardnumbertextbox, readProperty("cardno"));
			frameOut();
			frameIn(nameframe);
			sendkey(cardholdername, readProperty("cardname"));
			frameOut();
			frameIn(expmmframe);
			sendkey(expmonth,readProperty("mm"));
			frameOut();
			frameIn(expyyframe);
			sendkey(expyear, readProperty("yy"));
			frameOut();
			frameIn(cvvframe);
			sendkey(cvv, readProperty("cvv"));
			frameOut();
			clickbtn(proceed);
			test.log(Status.INFO, "Entered payment Details");
			implicitWait(10);
			getScreenShot("Payment");
			String text2 = getText(paymenterror);
			Assert.assertEquals("Please enter a valid card", text2);
			test.log(Status.PASS, "Payment Page Validation Sucessfull");
		} catch (Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, "Payment Page Validation Failed");
		}

	} 

}









