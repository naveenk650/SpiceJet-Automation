package com.TestComponent;

import org.testng.annotations.Test;

import com.EngineComponent.BaseClass;
import com.PageComponent.Booking_Page;
import com.PageComponent.Login_Page;
import com.PageComponent.Search_Flights;

public class Tc_005_BookingPage extends BaseClass{
	@Test
	public void booking_validation() throws Throwable {
		try {
			Booking_Page bp = new Booking_Page();
			Search_Flights sf = new Search_Flights();
			sf.oneWay_Trip();
			bp.booking_Code();

		} catch (Exception e) {
			e.printStackTrace();}	
	}	

}
