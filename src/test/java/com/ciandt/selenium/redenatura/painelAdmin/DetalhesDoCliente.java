package com.ciandt.selenium.redenatura.painelAdmin;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Test;

import com.ciandt.selenium.redenatura.helpers.DataDriven;
import com.ciandt.selenium.redenatura.helpers.Geral;
import com.ciandt.selenium.redenatura.pages.ClientesPage;
import com.ciandt.selenium.redenatura.pages.DetalhesClientePage;
import com.ciandt.selenium.redenatura.pages.LoginPage;


public class DetalhesDoCliente extends TestBase{	
	ClientesPage clientesPage = new ClientesPage();
	LoginPage loginPage = new LoginPage();
	Geral geral = new Geral();
	DataDriven properties = new DataDriven();
	DetalhesClientePage detalhesPage = new DetalhesClientePage();
	
	
	@Test
	public void validarValores() throws Exception {
		properties.lerArquivo();
		geral.abrir(driver);
		loginPage.logar(properties.getProperties().getProperty("login.active"), properties.getProperties().getProperty("login.active.password"));
		clientesPage.selecionarMenu();
		geral.realizarBusca(driver, properties.getProperties().getProperty("cliente.busca"));
		clientesPage.clicarVerPerfil();
		detalhesPage.verificaTotalPedido();
	}
	
	@Test
	public void validarDescricaoProdutos() throws Exception {
		properties.lerArquivo();
		geral.abrir(driver);
		loginPage.logar(properties.getProperties().getProperty("login.active"), properties.getProperties().getProperty("login.active.password"));
		clientesPage.selecionarMenu();
		geral.realizarBusca(driver, properties.getProperties().getProperty("cliente.busca"));
		clientesPage.clicarVerPerfil();
		detalhesPage.verificaDescricaoProduto();
	}
	
	@Test
	public void validarTotalItem() throws Exception {
		properties.lerArquivo();
		geral.abrir(driver);
		loginPage.logar(properties.getProperties().getProperty("login.active"), properties.getProperties().getProperty("login.active.password"));
		clientesPage.selecionarMenu();
		geral.realizarBusca(driver, properties.getProperties().getProperty("cliente.busca"));
		clientesPage.clicarVerPerfil();
		detalhesPage.verificaTotalItem();
	}
	
	@Test
	public void validarValorTotalGridDetalhes() throws Exception {
		properties.lerArquivo();
		geral.abrir(driver);
		loginPage.logar(properties.getProperties().getProperty("login.active"), properties.getProperties().getProperty("login.active.password"));
		clientesPage.selecionarMenu();
		geral.realizarBusca(driver, properties.getProperties().getProperty("cliente.busca"));
		detalhesPage.pegaValorGrid();
		clientesPage.clicarVerPerfil();
		detalhesPage.comparaValoresDetalhes();
	}
	
	@After
	public void tearDown(){
		String verificationErrorString = loginPage.verificationErrors.toString();
		String verificationErrorString2 = clientesPage.verificationErrors.toString();
		String verificationErrorString3 = detalhesPage.verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
		if (!"".equals(verificationErrorString2)) {
			fail(verificationErrorString);
		}
		if (!"".equals(verificationErrorString3)) {
			fail(verificationErrorString);
		}
		driver.quit();
	}	

}
