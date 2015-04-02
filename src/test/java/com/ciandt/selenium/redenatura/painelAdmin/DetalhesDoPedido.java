package com.ciandt.selenium.redenatura.painelAdmin;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Test;

import com.ciandt.selenium.redenatura.helpers.DataDriven;
import com.ciandt.selenium.redenatura.helpers.Geral;
import com.ciandt.selenium.redenatura.pages.DetalhesPedidoPage;
import com.ciandt.selenium.redenatura.pages.LoginPage;
import com.ciandt.selenium.redenatura.pages.PedidosPage;

public class DetalhesDoPedido extends TestBase{	
	PedidosPage pedidosPage = new PedidosPage();
	LoginPage loginPage = new LoginPage();
	Geral geral = new Geral();
	DetalhesPedidoPage detalhesPage = new DetalhesPedidoPage();
	DataDriven properties = new DataDriven();
	
	@Test
	public void validarValores() throws Exception {
		properties.lerArquivo();
		geral.abrir(driver);
		loginPage.logar(properties.getProperties().getProperty("login.active"), properties.getProperties().getProperty("login.active.password"));
		pedidosPage.selecionarMenu();
		geral.selecionarSemana(driver, properties.getProperties().getProperty("pedido.datapicker"), properties.getProperties().getProperty("pedido.datapicker.semana"));
		geral.realizarBusca(driver, properties.getProperties().getProperty("pedido.busca"));
		pedidosPage.selecionaPedido();	
		detalhesPage.verificaTotalPedido();
	}
	
	@Test
	public void validarDescricaoProdutos() throws Exception {
		properties.lerArquivo();
		geral.abrir(driver);
		loginPage.logar(properties.getProperties().getProperty("login.active"), properties.getProperties().getProperty("login.active.password"));
		pedidosPage.selecionarMenu();
		geral.selecionarSemana(driver, properties.getProperties().getProperty("pedido.datapicker"), properties.getProperties().getProperty("pedido.datapicker.semana"));
		geral.realizarBusca(driver, properties.getProperties().getProperty("pedido.busca"));
		pedidosPage.selecionaPedido();	
		detalhesPage.verificaDescricaoProduto();
	}
	
	@Test
	public void validarTotalItem() throws Exception {
		properties.lerArquivo();
		geral.abrir(driver);
		loginPage.logar(properties.getProperties().getProperty("login.active"), properties.getProperties().getProperty("login.active.password"));
		pedidosPage.selecionarMenu();
		geral.selecionarSemana(driver, properties.getProperties().getProperty("pedido.datapicker"), properties.getProperties().getProperty("pedido.datapicker.semana"));
		geral.realizarBusca(driver, properties.getProperties().getProperty("pedido.busca"));
		pedidosPage.selecionaPedido();	
		detalhesPage.verificaTotalItem();
	}
	
	@Test
	public void validarValorTotalGridDetalhes() throws Exception {
		properties.lerArquivo();
		geral.abrir(driver);
		loginPage.logar(properties.getProperties().getProperty("login.active"), properties.getProperties().getProperty("login.active.password"));
		pedidosPage.selecionarMenu();
		geral.selecionarSemana(driver, properties.getProperties().getProperty("pedido.datapicker"), properties.getProperties().getProperty("pedido.datapicker.semana"));
		geral.realizarBusca(driver, properties.getProperties().getProperty("pedido.busca"));
		pedidosPage.selecionaPedido();	
		detalhesPage.comparaValoresDetalhes();
	}
	
	@Test
	public void validarPedidoComFrete() throws Exception {
		properties.lerArquivo();
		geral.abrir(driver);
		loginPage.logar(properties.getProperties().getProperty("login.active"), properties.getProperties().getProperty("login.active.password"));
		pedidosPage.selecionarMenu();
		geral.selecionarSemana(driver, properties.getProperties().getProperty("pedido.datapicker"), properties.getProperties().getProperty("pedido.datapicker.semana"));
		geral.realizarBusca(driver, properties.getProperties().getProperty("detalhe.pedido.busca.frete"));
		pedidosPage.selecionaPedido();	
		detalhesPage.verificaValoresFreteCupom("frete");
	}
	
	@Test
	public void validarPedidoComCupom() throws Exception {
		properties.lerArquivo();
		geral.abrir(driver);
		loginPage.logar(properties.getProperties().getProperty("login.active"), properties.getProperties().getProperty("login.active.password"));
		pedidosPage.selecionarMenu();
		geral.selecionarSemana(driver, properties.getProperties().getProperty("pedido.datapicker"), properties.getProperties().getProperty("pedido.datapicker.semana"));
		geral.realizarBusca(driver, properties.getProperties().getProperty("detalhe.pedido.busca.cupom"));
		pedidosPage.selecionaPedido();	
		detalhesPage.verificaLabelCupom();
		detalhesPage.verificaValoresFreteCupom("cupom");
	}
	
	@After
	public void tearDown(){
		String verificationErrorString = detalhesPage.verificationErrors.toString();
		String verificationErrorString2 = pedidosPage.verificationErrors.toString();
		String verificationErrorString3 = loginPage.verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
		if (!"".equals(verificationErrorString2)) {
			fail(verificationErrorString2);
		}
		if (!"".equals(verificationErrorString3)) {
			fail(verificationErrorString3);
		}
		driver.quit();
	}	

}
