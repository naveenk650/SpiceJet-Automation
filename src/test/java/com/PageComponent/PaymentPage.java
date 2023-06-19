package com.PageComponent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utilities.WebUtils;

public class PaymentPage extends WebUtils{

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
	
	@FindBy (xpath = "(//div[text()='Continue'])[3]")
	WebElement addoncontinue;

	@FindBy (xpath = "(//div[text()='Add'])[3]")
	WebElement add;

	@FindBy (xpath = "(//div[text()='23C'])[1]")
	WebElement seat;

	@FindBy (xpath = "//div[text()='Done']")
	WebElement done;

	@FindBy (xpath = "//div[@data-testid='review-details-prepayment']")
	WebElement ReviewBooking;

	@FindBy (xpath = "//span[@id='skipfrompopup']")
	WebElement skip;
	
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
	
	public PaymentPage(){
		PageFactory.initElements(WebUtils.driver, this);}
	
	
public void payment_code() {
	clickbtn(add);
	clickbtn(seat);
	clickbtn(done);
	jsclick(addoncontinue);
	frameIn(cardframe);
	sendkey(cardnumbertextbox, "5546123578953215");
	frameOut();
	frameIn(nameframe);
	sendkey(cardholdername, "naveen");
	frameOut();
	frameIn(expmmframe);
	sendkey(expmonth, "05");
	frameOut();
	frameIn(expyyframe);
	sendkey(expyear, "30");
	frameOut();
	frameIn(cvvframe);
	sendkey(cvv, "254");
	frameOut();
	clickbtn(proceed);

	}


	
	
	
	
	
	
}
