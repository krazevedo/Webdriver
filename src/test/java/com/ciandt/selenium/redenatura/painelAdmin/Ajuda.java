package com.ciandt.selenium.redenatura.painelAdmin;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Test;

import com.ciandt.selenium.redenatura.helpers.Geral;
import com.ciandt.selenium.redenatura.pages.AjudaPage;
import com.ciandt.selenium.redenatura.pages.LoginPage;


public class Ajuda extends TestBase{
	AjudaPage ajudaPage = new AjudaPage();
	LoginPage loginPage = new LoginPage();
	Geral geral = new Geral();
	
	@Test
	public void validarAbas() throws Exception {
		geral.abrir(driver);
		loginPage.logar("thiago2@a.com", "123qwe123");
		ajudaPage.selecionarMenu();
		ajudaPage.verificarAbas();		
	}

	@Test
	public void validarPerguntas() throws Exception {
		geral.abrir(driver);
		loginPage.logar("thiago2@a.com", "123qwe123");
		ajudaPage.selecionarMenu();
		ajudaPage.verificarPerguntasAba1();
		ajudaPage.verificarPerguntasAba2();
		ajudaPage.verificarPerguntasAba3();
		ajudaPage.verificarPerguntasAba4();
		ajudaPage.verificarPerguntasAba5();
		ajudaPage.verificarPerguntasAba6();	
	}
	
	@After
	public void tearDown(){
		String verificationErrorString = ajudaPage.verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
		driver.quit();
	}	
	
}
