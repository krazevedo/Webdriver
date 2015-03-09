package com.ciandt.selenium.redenatura.pages;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.ciandt.selenium.redenatura.helpers.CssSelectors;
import com.ciandt.selenium.redenatura.helpers.DataDriven;
import com.ciandt.selenium.redenatura.helpers.Geral;
import com.ciandt.selenium.redenatura.painelAdmin.TestBase;

public class CupomPage extends TestBase{
	public StringBuffer verificationErrors = new StringBuffer();
	CssSelectors css = new CssSelectors();
	Geral geral = new Geral();
	DataDriven properties = new DataDriven();
	
	public void verificaUrl() throws IOException{
		properties.lerArquivo();
		String previousURL = driver.getCurrentUrl();
		try {
			assertEquals(properties.getProperties().getProperty("url") + "/#/cupons-desconto", previousURL);
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
