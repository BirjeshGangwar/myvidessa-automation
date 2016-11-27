package com.myvidessa.genericMethods;

import java.util.Random;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public interface MyvidessaCommanHelperImpl {
	
	public void assertVerifyTextOnPage(By by, WebDriver driver, String expectedResult);
	
	// This method is used to find if element is present on the page or not.
	public boolean isElementPresent(By by, WebDriver driver);
	
	//This function is to handle drop down using index
	public void valueFromDropDownByIndex(By by,WebDriver driver, int index);
	
	//This function is to handle drop down using visible text
	public void valueFromDropDownByVisibleText(By by,WebDriver driver, String visibletext);
	
	//This method is to generate random numbers
	public int randomNumberGenerator(int max);
	
	//This is to generate random string
	public String generateString(String characters, int length);
	
	
	//This method is to initialize logs
	
	public void initializeLog4j(Logger logger2);

}
