package com.ciandt.selenium.redenatura.painelAdmin;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Test;

import com.ciandt.selenium.redenatura.helpers.DataDriven;
import com.ciandt.selenium.redenatura.helpers.Geral;
import com.ciandt.selenium.redenatura.pages.AjudaPage;
import com.ciandt.selenium.redenatura.pages.LoginPage;


public class Ajuda extends TestBase{
	AjudaPage ajudaPage = new AjudaPage();
	LoginPage loginPage = new LoginPage();
	DataDriven properties = new DataDriven();
	Geral geral = new Geral();
	
	@Test
	public void validarAbas() throws Exception {
		properties.lerArquivo();
		geral.abrir(driver);
		loginPage.logar(properties.getProperties().getProperty("login.active"), properties.getProperties().getProperty("login.active.password"));
		ajudaPage.selecionarMenu();
		ajudaPage.verificarAbas();		
	}

	@Test
	public void validarPerguntas() throws Exception {
		properties.lerArquivo();
		geral.abrir(driver);
		loginPage.logar(properties.getProperties().getProperty("login.active"), properties.getProperties().getProperty("login.active.password"));
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
