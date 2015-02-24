package com.ciandt.selenium.redenatura.painelAdmin;


import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Test;

import com.ciandt.selenium.redenatura.helpers.Geral;
import com.ciandt.selenium.redenatura.pages.LoginPage;
import com.ciandt.selenium.redenatura.pages.MoipPage;
import com.ciandt.selenium.redenatura.pages.PedidosPage;



public class Pedidos extends TestBase{
	PedidosPage pedidosPage = new PedidosPage();
	LoginPage loginPage = new LoginPage();
	Geral geral = new Geral();
	MoipPage moipPage = new MoipPage();
	

	@Test
	public void verificarSemanaAtual() throws Exception {
		geral.abrir(driver);
		loginPage.logar("thiago2@a.com", "123qwe123");
		pedidosPage.selecionarMenu();
		pedidosPage.verificaSemanaAtual();
	}

	@Test
	public void verificarValoresBoxes() throws Exception {
		geral.abrir(driver);
		loginPage.logar("thiago2@a.com", "123qwe123");
		pedidosPage.selecionarMenu();
		geral.selecionarSemana(driver, geral.datapicker, geral.semana);
		pedidosPage.validaValoresBoxes();
	}

	@Test
	public void verificarColunasGrid() throws Exception {
		geral.abrir(driver);
		loginPage.logar("thiago2@a.com", "123qwe123");
		pedidosPage.selecionarMenu();
		geral.selecionarSemana(driver, geral.datapicker, geral.semana);
		pedidosPage.validaColunasGrid();		
	}
	
	@Test
	public void verificarLinkMoip() throws Exception {
		geral.abrir(driver);
		loginPage.logar("thiago2@a.com", "123qwe123");
		pedidosPage.selecionarMenu();
		pedidosPage.resgatarSaldo();
		moipPage.verificarLinkMoip();
	}
	
	@Test
	public void verificarValoresTabelas() throws Exception {
		geral.abrir(driver);
		loginPage.logar("thiago2@a.com", "123qwe123");
		pedidosPage.selecionarMenu();
		geral.selecionarSemana(driver, geral.datapicker, geral.semana);
		pedidosPage.validaValoresTabelas();
	}
	
	@Test
	public void verificarQuantidadePedidosRealizados() throws Exception {
		geral.abrir(driver);
		loginPage.logar("thiago2@a.com", "123qwe123");
		pedidosPage.selecionarMenu();
		geral.selecionarSemana(driver, geral.datapicker, geral.semana);
		pedidosPage.validaQuantidadePedidos("realizado");
	}
	
	@Test
	public void verificarQuantidadePedidosAprovados() throws Exception {
		geral.abrir(driver);
		loginPage.logar("thiago2@a.com", "123qwe123");
		pedidosPage.selecionarMenu();
		geral.selecionarSemana(driver, geral.datapicker, geral.semana);
		pedidosPage.validaQuantidadePedidos("aprovado");
	}
	
	@Test
	public void verificarQuantidadePedidosCancelados() throws Exception {
		geral.abrir(driver);
		loginPage.logar("thiago2@a.com", "123qwe123");
		pedidosPage.selecionarMenu();
		geral.selecionarSemana(driver, geral.datapicker, geral.semana);
		pedidosPage.validaQuantidadePedidos("cancelado");
	}


	@After
	public void tearDown(){
		String verificationErrorString = pedidosPage.verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}	
		driver.close();
	}	
}
