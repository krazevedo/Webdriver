package com.ciandt.selenium.redenatura.pages;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.fail;

import com.ciandt.selenium.redenatura.helpers.CssSelectors;
import com.ciandt.selenium.redenatura.painelAdmin.TestBase;

public class HomePage extends TestBase{
	LoginPage loginPage = new LoginPage();
	public StringBuffer verificationErrors = new StringBuffer();
	CssSelectors css = new CssSelectors();
		
	public void verificarLogin() throws Exception{
		for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	try { if ("Bem-vinda".equals(driver.findElement(By.cssSelector("div.col-lg-4 > h3 > span:nth-child(2)")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	}
	
	public void verificarContrato() throws Exception{
		Thread.sleep(2000);
		for (int second = 0;; second++) {
	    	if (second >= 60) fail("timeout");
	    	driver.switchTo().defaultContent();
	    	try { if ("CONTRATO DE FRANQUIA".equals(driver.findElement(By.cssSelector("form#acceptAgreement > div > div.modal-header > h2.sub-title")).getText())) break; } catch (Exception e) {}
	    	Thread.sleep(1000);
	    }
	}
	
}
