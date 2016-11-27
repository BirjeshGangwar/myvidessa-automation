package com.myvidessa.impl;

import org.openqa.selenium.WebDriver;

public interface MyvidessaAddProviderHelperImpl {

	// This method is to add the provider
	public void addProvider(WebDriver driver,int title, String fname, String mname, String lname, String email, String phone,
			String NPINumber, String NPIName, String facname, String facphone, String facfax, String addline1,
			String addline2, String city, int state, String zip) throws InterruptedException;

	// This method is to check the error when no data filled and try to submit
	// the provider form
	public void addProviderWithNoData(WebDriver driver) throws InterruptedException;
	
	

}
