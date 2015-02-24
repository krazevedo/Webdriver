package com.ciandt.selenium.redenatura.painelAdmin;


import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Test;

import com.ciandt.selenium.redenatura.helpers.Geral;
import com.ciandt.selenium.redenatura.pages.ClientesPage;
import com.ciandt.selenium.redenatura.pages.CupomPage;
import com.ciandt.selenium.redenatura.pages.DetalhesClientePage;
import com.ciandt.selenium.redenatura.pages.LoginPage;


public class Clientes extends TestBase{
	ClientesPage clientesPage = new ClientesPage();
	LoginPage loginPage = new LoginPage();
	DetalhesClientePage detalhesPage = new DetalhesClientePage();
	CupomPage cupomPage = new CupomPage();
	Geral geral = new Geral();
	
	
	@Test
	public void verificarColunasGrid() throws Exception {
		geral.abrir(driver);
		loginPage.logar("thiago2@a.com", "123qwe123");
		clientesPage.selecionarMenu();
		geral.realizarBusca(driver, "kaio");
		clientesPage.validaColunasGrid();		
	}
	
	@Test
	public void verificarValoresTabelas() throws Exception {
		geral.abrir(driver);
		loginPage.logar("thiago2@a.com", "123qwe123");
		clientesPage.selecionarMenu();
		geral.realizarBusca(driver, "kaio");
		clientesPage.validaValoresTabelas();
	}
	
	@Test
	public void verificarBotaoVerPerfil() throws Exception {
		geral.abrir(driver);
		loginPage.logar("thiago2@a.com", "123qwe123");
		clientesPage.selecionarMenu();
		geral.realizarBusca(driver, "kaio");
		clientesPage.clicarVerPerfil();
		detalhesPage.verificaUrl();
	}
	
	@Test
	public void verificarBotaoGerarCupom() throws Exception {
		geral.abrir(driver);
		loginPage.logar("thiago2@a.com", "123qwe123");
		clientesPage.selecionarMenu();
		geral.realizarBusca(driver, "kaio");
		clientesPage.clicarGerarCupom();
		cupomPage.verificaUrl();
	}
	
	@After
	public void tearDown(){
		String verificationErrorString = clientesPage.verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}	
		driver.close();
	}	
}
