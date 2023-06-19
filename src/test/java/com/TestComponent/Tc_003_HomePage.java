package com.TestComponent;

import org.testng.annotations.Test;

import com.EngineComponent.BaseClass;
import com.PageComponent.Homepage_fields;


public class Tc_003_HomePage extends BaseClass{
	
@Test
	public void field_Validation() {

		try {
			Homepage_fields hm = new Homepage_fields();
			hm.field_code();
		} catch (Exception e) {
			e.printStackTrace();
		}}
}
