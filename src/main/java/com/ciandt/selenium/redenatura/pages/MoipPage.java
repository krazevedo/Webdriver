package com.ciandt.selenium.redenatura.pages;

import static org.junit.Assert.assertEquals;

import com.ciandt.selenium.redenatura.painelAdmin.TestBase;

public class MoipPage extends TestBase{
	public StringBuffer verificationErrors = new StringBuffer();
	public void verificarLinkMoip(){
		String winHandleBefore = driver.getWindowHandle();
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		String previousURL = driver.getCurrentUrl();
		try {
			assertEquals("https://moip.com.br/", previousURL);
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		driver.close();
		driver.switchTo().window(winHandleBefore);
	}
}
