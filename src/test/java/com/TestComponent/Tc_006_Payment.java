package com.TestComponent;

import org.testng.annotations.Test;

import com.EngineComponent.BaseClass;
import com.PageComponent.Booking_Page;
import com.PageComponent.PaymentPage;
import com.PageComponent.Search_Flights;

public class Tc_006_Payment extends BaseClass{
	@Test
	public void payment_validation() throws Throwable {
		try {
			Booking_Page bp = new Booking_Page();
			Search_Flights sf = new Search_Flights();
			PaymentPage pp = new PaymentPage();
			sf.oneWay_Trip();
			bp.booking_Code();
			pp.payment_code();
			

		} catch (Exception e) {
			e.printStackTrace();}	
	}	

}


