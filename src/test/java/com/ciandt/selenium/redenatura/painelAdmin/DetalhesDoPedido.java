package com.ciandt.selenium.redenatura.painelAdmin;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Test;

import com.ciandt.selenium.redenatura.helpers.Geral;
import com.ciandt.selenium.redenatura.pages.DetalhesPedidoPage;
import com.ciandt.selenium.redenatura.pages.LoginPage;
import com.ciandt.selenium.redenatura.pages.PedidosPage;

public class DetalhesDoPedido extends TestBase{	
	PedidosPage pedidosPage = new PedidosPage();
	LoginPage loginPage = new LoginPage();
	Geral geral = new Geral();
	DetalhesPedidoPage detalhesPage = new DetalhesPedidoPage();
	
	@Test
	public void validarValores() throws Exception {
		geral.abrir(driver);
		loginPage.logar("thiago2@a.com", "123qwe123");
		pedidosPage.selecionarMenu();
		geral.selecionarSemana(driver, geral.datapicker, geral.semana);
		pedidosPage.selecionaPedido();	
		detalhesPage.verificaTotalPedido();
	}
	
	@Test
	public void validarDescricaoProdutos() throws Exception {
		geral.abrir(driver);
		loginPage.logar("thiago2@a.com", "123qwe123");
		pedidosPage.selecionarMenu();
		geral.selecionarSemana(driver, geral.datapicker, geral.semana);
		pedidosPage.selecionaPedido();	
		detalhesPage.verificaDescricaoProduto();
	}
	
	@Test
	public void validarTotalItem() throws Exception {
		geral.abrir(driver);
		loginPage.logar("thiago2@a.com", "123qwe123");
		pedidosPage.selecionarMenu();
		geral.selecionarSemana(driver, geral.datapicker, geral.semana);
		pedidosPage.selecionaPedido();	
		detalhesPage.verificaTotalItem();
	}
	
	@Test
	public void validarValorTotalGridDetalhes() throws Exception {
		geral.abrir(driver);
		loginPage.logar("thiago2@a.com", "123qwe123");
		pedidosPage.selecionarMenu();
		geral.selecionarSemana(driver, geral.datapicker, geral.semana);
		pedidosPage.pegaValorGrid();
		pedidosPage.selecionaPedido();	
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
