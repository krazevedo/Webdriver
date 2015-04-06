package com.ciandt.selenium.redenatura.painelAdmin;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Test;

import com.ciandt.selenium.redenatura.helpers.DataDriven;
import com.ciandt.selenium.redenatura.helpers.Geral;
import com.ciandt.selenium.redenatura.pages.CupomPage;
import com.ciandt.selenium.redenatura.pages.LoginPage;


public class Cupom extends TestBase{
	Geral geral = new Geral();
	LoginPage loginPage = new LoginPage();
	CupomPage cupomPage = new CupomPage();
	DataDriven properties = new DataDriven();
	
	@Test
	public void gerarPalavraSecreta() throws Exception {
		properties.lerArquivo();
		geral.abrir(driver);
		loginPage.logar(properties.getProperties().getProperty("login.active"), properties.getProperties().getProperty("login.active.password"));
		cupomPage.selecionarMenu();
		cupomPage.clicarVejaSugestao();		
	}

	@Test
	public void gerarCupom() throws Exception {
		properties.lerArquivo();
		geral.abrir(driver);
		loginPage.logar(properties.getProperties().getProperty("login.active"), properties.getProperties().getProperty("login.active.password"));
		cupomPage.selecionarMenu();
		cupomPage.encerrarCupom();
		cupomPage.criarCupom();	
		cupomPage.verificarCupomCriado();		
	}
	
	@Test
	public void encerrarCupom() throws Exception {
		properties.lerArquivo();
		geral.abrir(driver);
		loginPage.logar(properties.getProperties().getProperty("login.active"), properties.getProperties().getProperty("login.active.password"));
		cupomPage.selecionarMenu();
		cupomPage.encerrarCupom();
	}
	
	@Test
	public void validarLimiteCupons() throws Exception {
		properties.lerArquivo();
		geral.abrir(driver);
		loginPage.logar(properties.getProperties().getProperty("login.active"), properties.getProperties().getProperty("login.active.password"));
		cupomPage.selecionarMenu();
		cupomPage.encerrarCupom();
		cupomPage.criarVariosCupons();		
	}
	
	@Test
	public void validarBlackList() throws Exception {
		properties.lerArquivo();
		geral.abrir(driver);
		loginPage.logar(properties.getProperties().getProperty("login.active"), properties.getProperties().getProperty("login.active.password"));
		cupomPage.selecionarMenu();
		cupomPage.encerrarCupom();
		cupomPage.criarCupomBlackList("AVON");		
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
