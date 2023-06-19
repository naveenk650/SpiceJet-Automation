package com.TestComponent;

import org.testng.annotations.Test;

import com.EngineComponent.BaseClass;
import com.PageComponent.Search_Flights;

public class Tc_002_SearchFlights extends BaseClass {
	@Test
	public void search_flights_Oneway(){
		try {
			Search_Flights sf = new Search_Flights();
			sf.oneWay_Trip();
		} catch (Exception e) {
			e.printStackTrace();
		}}
	@Test
	public void search_flights_Roundtrip(){
		try {
			Search_Flights sf = new Search_Flights();
			sf.round_Trip();
		} catch (Exception e) {
			e.printStackTrace();
		}}

}
