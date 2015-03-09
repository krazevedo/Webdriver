package com.ciandt.selenium.redenatura.pages;

import static org.junit.Assert.assertEquals;



import com.ciandt.selenium.redenatura.painelAdmin.TestBase;

public class MinhaContaPage extends TestBase{
	public StringBuffer verificationErrors = new StringBuffer();
	public void verificarLinkMinhaConta(){
		String winHandleBefore = driver.getWindowHandle();
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		String previousURL = driver.getCurrentUrl();
		try {
			assertEquals("https://s.rede.natura.net/recuperar-acesso", previousURL);
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		driver.close();
		driver.switchTo().window(winHandleBefore);
	}
}
