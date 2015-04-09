package com.ciandt.selenium.redenatura.painelAdmin;


import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Test;

import com.ciandt.selenium.redenatura.helpers.DataDriven;
import com.ciandt.selenium.redenatura.helpers.Geral;
import com.ciandt.selenium.redenatura.pages.LoginPage;
import com.ciandt.selenium.redenatura.pages.MeusDadosPage;


public class MeusDados extends TestBase{
	MeusDadosPage dadosPage = new MeusDadosPage();
	LoginPage loginPage = new LoginPage();
	DataDriven properties = new DataDriven();
	Geral geral = new Geral();
	
	
	@Test
	public void verificarDadosFormulario() throws Exception {
		properties.lerArquivo();
		geral.abrir(driver);
		loginPage.logar(properties.getProperties().getProperty("login.active"), properties.getProperties().getProperty("login.active.password"));
		dadosPage.selecionarMenu();
		dadosPage.validaDadosFormulario();	
	}
	
	@Test
	public void verificarValorMeta() throws Exception {
		properties.lerArquivo();
		geral.abrir(driver);
		loginPage.logar(properties.getProperties().getProperty("login.active"), properties.getProperties().getProperty("login.active.password"));
		dadosPage.selecionarMenu();
		dadosPage.validaMeta();
	}
	
	@Test
	public void verificarAlteracaoCartao() throws Exception {
		properties.lerArquivo();
		geral.abrir(driver);
		loginPage.logar(properties.getProperties().getProperty("login.active"), properties.getProperties().getProperty("login.active.password"));
		dadosPage.selecionarMenu();
		dadosPage.abrirFormulario();
		dadosPage.informarValoresCartao();
		dadosPage.submeterFormulario();
		dadosPage.validarAlteracaoComSucesso();
	}
	
	@Test
	public void verificarCartaoInvalido() throws Exception {
		properties.lerArquivo();
		geral.abrir(driver);
		loginPage.logar(properties.getProperties().getProperty("login.active"), properties.getProperties().getProperty("login.active.password"));
		dadosPage.selecionarMenu();
		dadosPage.validaMeta();
	}
	
	@Test
	public void verificarCamposObrigatorios() throws Exception {
		properties.lerArquivo();
		geral.abrir(driver);
		loginPage.logar(properties.getProperties().getProperty("login.active"), properties.getProperties().getProperty("login.active.password"));
		dadosPage.selecionarMenu();
		dadosPage.abrirFormulario();
		dadosPage.submeterFormulario();
		dadosPage.validarCamposObrigatorios();
	}
		
		
	@After
	public void tearDown(){
		String verificationErrorString = dadosPage.verificationErrors.toString();
		String verificationErrorString2 = loginPage.verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
		if (!"".equals(verificationErrorString2)) {
			fail(verificationErrorString);
		}	
		driver.close();
	}	
}
