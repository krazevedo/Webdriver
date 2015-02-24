package com.ciandt.selenium.redenatura.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.ciandt.selenium.redenatura.helpers.CssSelectors;
import com.ciandt.selenium.redenatura.painelAdmin.TestBase;

public class SacolasPage extends TestBase{
	public StringBuffer verificationErrors = new StringBuffer();
	CssSelectors css = new CssSelectors();
	
	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

}
