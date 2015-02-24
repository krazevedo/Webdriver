package com.ciandt.selenium.redenatura.painelAdmin;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Test;

import com.ciandt.selenium.redenatura.helpers.Geral;
import com.ciandt.selenium.redenatura.pages.CupomPage;
import com.ciandt.selenium.redenatura.pages.LoginPage;

public class Cupom extends TestBase{
	Geral geral = new Geral();
	LoginPage loginPage = new LoginPage();
	CupomPage cupomPage = new CupomPage();
	
	@Test
	public void verificarSemanaAtual() throws Exception {
		geral.abrir(driver);
		loginPage.logar("thiago2@a.com", "123qwe123");		
	}
	
	@After
	public void tearDown(){
		String verificationErrorString = cupomPage.verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}	
		driver.close();
	}	


}
