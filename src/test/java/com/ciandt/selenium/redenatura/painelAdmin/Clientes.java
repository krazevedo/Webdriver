package com.ciandt.selenium.redenatura.painelAdmin;


import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Test;

import com.ciandt.selenium.redenatura.helpers.DataDriven;
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
	DataDriven properties = new DataDriven();
	Geral geral = new Geral();
	
	
	@Test
	public void verificarColunasGrid() throws Exception {
		properties.lerArquivo();
		geral.abrir(driver);
		loginPage.logar(properties.getProperties().getProperty("login.active"), properties.getProperties().getProperty("login.active.password"));
		clientesPage.selecionarMenu();
		clientesPage.validaColunasGrid();		
	}
	
	@Test
	public void verificarValoresTabelas() throws Exception {
		properties.lerArquivo();
		geral.abrir(driver);
		loginPage.logar(properties.getProperties().getProperty("login.active"), properties.getProperties().getProperty("login.active.password"));
		clientesPage.selecionarMenu();
		geral.realizarBusca(driver, properties.getProperties().getProperty("cliente.busca"));
		clientesPage.validaValoresTabelas();
	}
	
	@Test
	public void verificarBotaoVerPerfil() throws Exception {
		properties.lerArquivo();
		geral.abrir(driver);
		loginPage.logar(properties.getProperties().getProperty("login.active"), properties.getProperties().getProperty("login.active.password"));
		clientesPage.selecionarMenu();
		geral.realizarBusca(driver, properties.getProperties().getProperty("cliente.busca"));
		clientesPage.clicarVerPerfil();
		detalhesPage.verificaUrl();
	}
	
	@Test
	public void verificarBotaoGerarCupom() throws Exception {
		properties.lerArquivo();
		geral.abrir(driver);
		loginPage.logar(properties.getProperties().getProperty("login.active"), properties.getProperties().getProperty("login.active.password"));
		clientesPage.selecionarMenu();
		geral.realizarBusca(driver, properties.getProperties().getProperty("cliente.busca"));
		clientesPage.clicarGerarCupom();
		cupomPage.verificaUrl();
	}
	
	@After
	public void tearDown(){
		String verificationErrorString = clientesPage.verificationErrors.toString();
		String verificationErrorString2 = loginPage.verificationErrors.toString();
		String verificationErrorString3 = detalhesPage.verificationErrors.toString();
		String verificationErrorString4 = cupomPage.verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
		if (!"".equals(verificationErrorString2)) {
			fail(verificationErrorString);
		}	
		if (!"".equals(verificationErrorString3)) {
			fail(verificationErrorString);
		}	
		if (!"".equals(verificationErrorString4)) {
			fail(verificationErrorString);
		}	
		driver.close();
	}	
}
