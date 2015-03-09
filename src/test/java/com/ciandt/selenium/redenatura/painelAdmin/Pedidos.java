package com.ciandt.selenium.redenatura.painelAdmin;


import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Test;

import com.ciandt.selenium.redenatura.helpers.DataDriven;
import com.ciandt.selenium.redenatura.helpers.Geral;
import com.ciandt.selenium.redenatura.pages.LoginPage;
import com.ciandt.selenium.redenatura.pages.MoipPage;
import com.ciandt.selenium.redenatura.pages.PedidosPage;



public class Pedidos extends TestBase{
	PedidosPage pedidosPage = new PedidosPage();
	LoginPage loginPage = new LoginPage();
	Geral geral = new Geral();
	MoipPage moipPage = new MoipPage();
	DataDriven properties = new DataDriven();
	

	@Test
	public void verificarSemanaAtual() throws Exception {
		properties.lerArquivo();
		geral.abrir(driver);
		loginPage.logar(properties.getProperties().getProperty("login.active"), properties.getProperties().getProperty("login.active.password"));
		pedidosPage.selecionarMenu();
		pedidosPage.verificaSemanaAtual();
	}

	@Test
	public void verificarValoresBoxes() throws Exception {
		properties.lerArquivo();
		geral.abrir(driver);
		loginPage.logar(properties.getProperties().getProperty("login.active"), properties.getProperties().getProperty("login.active.password"));
		pedidosPage.selecionarMenu();
		geral.selecionarSemana(driver, properties.getProperties().getProperty("pedido.datapicker"), properties.getProperties().getProperty("pedido.datapicker.semana"));
		pedidosPage.validaValoresBoxes();
	}

	@Test
	public void verificarColunasGrid() throws Exception {
		properties.lerArquivo();
		geral.abrir(driver);
		loginPage.logar(properties.getProperties().getProperty("login.active"), properties.getProperties().getProperty("login.active.password"));
		pedidosPage.selecionarMenu();
		geral.selecionarSemana(driver, properties.getProperties().getProperty("pedido.datapicker"), properties.getProperties().getProperty("pedido.datapicker.semana"));
		pedidosPage.validaColunasGrid();		
	}
	
	@Test
	public void verificarLinkMoip() throws Exception {
		properties.lerArquivo();
		geral.abrir(driver);
		loginPage.logar(properties.getProperties().getProperty("login.active"), properties.getProperties().getProperty("login.active.password"));
		pedidosPage.selecionarMenu();
		pedidosPage.resgatarSaldo();
		moipPage.verificarLinkMoip();
	}
	
	@Test
	public void verificarValoresTabelas() throws Exception {
		properties.lerArquivo();
		geral.abrir(driver);
		loginPage.logar(properties.getProperties().getProperty("login.active"), properties.getProperties().getProperty("login.active.password"));
		pedidosPage.selecionarMenu();
		geral.selecionarSemana(driver, properties.getProperties().getProperty("pedido.datapicker"), properties.getProperties().getProperty("pedido.datapicker.semana"));
		geral.realizarBusca(driver, properties.getProperties().getProperty("pedido.busca"));
		pedidosPage.validaValoresTabelas();
	}
	
	@Test
	public void verificarQuantidadePedidosRealizados() throws Exception {
		properties.lerArquivo();
		geral.abrir(driver);
		loginPage.logar(properties.getProperties().getProperty("login.active"), properties.getProperties().getProperty("login.active.password"));
		pedidosPage.selecionarMenu();
		geral.selecionarSemana(driver, properties.getProperties().getProperty("pedido.datapicker"), properties.getProperties().getProperty("pedido.datapicker.semana"));
		pedidosPage.validaQuantidadePedidos("realizado");
	}
	
	@Test
	public void verificarQuantidadePedidosAprovados() throws Exception {
		properties.lerArquivo();
		geral.abrir(driver);
		loginPage.logar(properties.getProperties().getProperty("login.active"), properties.getProperties().getProperty("login.active.password"));
		pedidosPage.selecionarMenu();
		geral.selecionarSemana(driver, properties.getProperties().getProperty("pedido.datapicker"), properties.getProperties().getProperty("pedido.datapicker.semana"));
		pedidosPage.validaQuantidadePedidos("aprovado");
	}
	
	@Test
	public void verificarQuantidadePedidosCancelados() throws Exception {
		properties.lerArquivo();
		geral.abrir(driver);
		loginPage.logar(properties.getProperties().getProperty("login.active"), properties.getProperties().getProperty("login.active.password"));
		pedidosPage.selecionarMenu();
		geral.selecionarSemana(driver, properties.getProperties().getProperty("pedido.datapicker"), properties.getProperties().getProperty("pedido.datapicker.semana"));
		pedidosPage.validaQuantidadePedidos("cancelado");
	}


	@After
	public void tearDown(){
		String verificationErrorString = pedidosPage.verificationErrors.toString();
		String verificationErrorString2 = loginPage.verificationErrors.toString();
		String verificationErrorString3 = moipPage.verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
		if (!"".equals(verificationErrorString2)) {
			fail(verificationErrorString2);
		}	
		if (!"".equals(verificationErrorString3)) {
			fail(verificationErrorString3);
		}	
		driver.close();
	}	
}
