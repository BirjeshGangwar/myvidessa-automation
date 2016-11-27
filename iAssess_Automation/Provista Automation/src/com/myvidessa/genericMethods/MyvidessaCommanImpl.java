package com.myvidessa.genericMethods;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.myvidessa.impl.MyvidessaLoadPropertiesFileImpl;
import com.sun.jmx.snmp.Timestamp;

public class MyvidessaCommanImpl implements MyvidessaCommanHelperImpl {
	MyvidessaLoadPropertiesFileImpl loadproperties = new MyvidessaLoadPropertiesFileImpl();
	Properties prop = loadproperties.loadParamPropertiesFile();

	// This method is use to verify text content on the page.
	@Override
	public void assertVerifyTextOnPage(By by, WebDriver driver, String expectedResult) {
		String actualResult = driver.findElement(by).getText();
		Assert.assertEquals(actualResult, expectedResult);
	}

	@Override
	// This method is used to find if element is present on the page or not.
		public boolean isElementPresent(By by, WebDriver driver) {
			try {
				//wait.until(ExpectedConditions.presenceOfElementLocated(by));
				if((driver.findElements(by).size())>0){
				return true;
				} else {
					return false;
				}
			} catch (org.openqa.selenium.NoSuchElementException e) {
				return false;
			}
		}

	@Override
	public void valueFromDropDownByIndex(By by, WebDriver driver,int index) {
		Select dropdown=new Select(driver.findElement(by));
		dropdown.selectByIndex(index);
		
	}

	@Override
	public void valueFromDropDownByVisibleText(By by, WebDriver driver,String visibletext){		
		Select dropdown=new Select(driver.findElement(by));
		dropdown.selectByVisibleText(visibletext);
	}

	@Override
	public int randomNumberGenerator(int max) 
		{
			Random rand = new Random();
			int  n = rand.nextInt(max) + 1;
			return n;
		}

	@Override
	public String generateString(String characters, int length) {
		Random random=new Random();
	    char[] text = new char[length];
	    for (int i = 0; i < length; i++)
	    {
	        text[i] = characters.charAt(random.nextInt(characters.length()));
	    }
	    return new String(text);
	}
	@Override
	public void initializeLog4j(Logger logger2) {
		try {
			// This block configure the logger with handler and formatter
			Date d = new Date();
			Timestamp t = new Timestamp(d.getTime());
			String timeStamp = t.toString();
			timeStamp = timeStamp.replace(' ', '_');
			timeStamp = timeStamp.replace(':', '_');

			FileHandler fileHandler = new FileHandler(prop.getProperty("LOGFILEPATH")+ ".log");
			logger2.addHandler(fileHandler);
			SimpleFormatter formatter = new SimpleFormatter();
			fileHandler.setFormatter(formatter);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	
	
}
