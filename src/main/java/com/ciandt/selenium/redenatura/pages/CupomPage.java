package com.ciandt.selenium.redenatura.pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.ciandt.selenium.redenatura.helpers.CssSelectors;
import com.ciandt.selenium.redenatura.helpers.Geral;
import com.ciandt.selenium.redenatura.painelAdmin.TestBase;

public class CupomPage extends TestBase{
	public StringBuffer verificationErrors = new StringBuffer();
	CssSelectors css = new CssSelectors();
	Geral geral = new Geral();
	
	public void verificaUrl(){
		String previousURL = driver.getCurrentUrl();
		try {
			assertEquals(geral.baseURL + "/#/cupons-desconto", previousURL);
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
	}
	
	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

}
