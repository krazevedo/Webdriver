package com.ciandt.selenium.redenatura.pages;

import org.openqa.selenium.By;

import static org.junit.Assert.fail;
import com.ciandt.selenium.redenatura.helpers.CssSelectors;
import com.ciandt.selenium.redenatura.painelAdmin.TestBase;

public class HomePage extends TestBase{
	public StringBuffer verificationErrors = new StringBuffer();
	CssSelectors css = new CssSelectors();
	
	public void verificarLogin() throws Exception{
		for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Bem-vindo,".equals(driver.findElement(By.cssSelector("div.col-lg-4 > h3 > span:nth-child(1)")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	}
	
	
}
