package com.ciandt.selenium.redenatura.painelAdmin;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Test;

import com.ciandt.selenium.redenatura.helpers.Geral;
import com.ciandt.selenium.redenatura.pages.ClientesPage;
import com.ciandt.selenium.redenatura.pages.DetalhesClientePage;

import com.ciandt.selenium.redenatura.pages.LoginPage;


public class DetalhesDoCliente extends TestBase{	
	ClientesPage clientesPage = new ClientesPage();
	LoginPage loginPage = new LoginPage();
	Geral geral = new Geral();
	DetalhesClientePage detalhesPage = new DetalhesClientePage();
	
	
	@Test
	public void validarValores() throws Exception {
		geral.abrir(driver);
		loginPage.logar("thiago2@a.com", "123qwe123");
		clientesPage.selecionarMenu();
		geral.realizarBusca(driver, "kaio");
		clientesPage.clicarVerPerfil();
		detalhesPage.verificaTotalPedido();
	}
	
	@Test
	public void validarDescricaoProdutos() throws Exception {
		geral.abrir(driver);
		loginPage.logar("thiago2@a.com", "123qwe123");
		clientesPage.selecionarMenu();
		geral.realizarBusca(driver, "kaio");
		clientesPage.clicarVerPerfil();
		detalhesPage.verificaDescricaoProduto();
	}
	
	@Test
	public void validarTotalItem() throws Exception {
		geral.abrir(driver);
		loginPage.logar("thiago2@a.com", "123qwe123");
		clientesPage.selecionarMenu();
		geral.realizarBusca(driver, "kaio");
		clientesPage.clicarVerPerfil();
		detalhesPage.verificaTotalItem();
	}
	
	@Test
	public void validarValorTotalGridDetalhes() throws Exception {
		geral.abrir(driver);
		loginPage.logar("thiago2@a.com", "123qwe123");
		clientesPage.selecionarMenu();
		geral.realizarBusca(driver, "kaio");
		detalhesPage.pegaValorGrid();
		clientesPage.clicarVerPerfil();
		detalhesPage.comparaValoresDetalhes();
	}
	
	@After
	public void tearDown(){
		String verificationErrorString = detalhesPage.verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
		driver.quit();
	}	

}
