package com.ciandt.selenium.redenatura.painelAdmin;


import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Test;

import com.ciandt.selenium.redenatura.helpers.DataDriven;
import com.ciandt.selenium.redenatura.helpers.Geral;
import com.ciandt.selenium.redenatura.pages.PerformancePage;


public class Performance extends TestBase{
	
	DataDriven properties = new DataDriven();
	PerformancePage performancePage = new PerformancePage();
	Geral geral = new Geral();
	


	@Test
	public void verificarPerformanceHMLHome() throws Exception {
		System.out.println("*************************************************************** \n" + "Inicio do teste de home \n");
		properties.lerArquivo();
		geral.abrir(driver);
		performancePage.logar(properties.getProperties().getProperty("login.performance"), properties.getProperties().getProperty("login.performance.password"));
		performancePage.tempoLogin();
		performancePage.esperarCarregamentoHome();
		performancePage.tempoCarregamento("HML");
		System.out.println("Término do teste de home \n");
	}
	
		
	@Test
	public void verificarPerformanceHMLClientes() throws Exception {
		System.out.println("*************************************************************** \n" + "Inicio do teste de clientes \n");
		properties.lerArquivo();
		geral.abrir(driver);
		performancePage.logar(properties.getProperties().getProperty("login.performance"), properties.getProperties().getProperty("login.performance.password"));
		performancePage.selecionarMenuClientes();	
		performancePage.esperarCarregamentoClientes();
		performancePage.tempoCarregamento("HML");
		System.out.println("Término do teste de clientes \n");
	}
	
	@Test
	public void verificarPerformanceHMLDetalhesCliente() throws Exception {
		System.out.println("*************************************************************** \n" + "Inicio do teste de detalhes do cliente \n");
		properties.lerArquivo();
		geral.abrir(driver);
		performancePage.logar(properties.getProperties().getProperty("login.performance"), properties.getProperties().getProperty("login.performance.password"));
		performancePage.selecionarMenuClientes();
		//geral.realizarBusca(driver, "beatriz s");
		performancePage.clicarVerPerfil();
		performancePage.esperarCarregamentoDetalheCliente();
		performancePage.tempoCarregamento("HML");
		System.out.println("Término do teste de detalhes do cliente \n");
	}
	
	@Test
	public void verificarPerformanceHMLPedidos() throws Exception {
		System.out.println("*************************************************************** \n" + "Inicio do teste de pedidos \n");
		properties.lerArquivo();
		geral.abrir(driver);
		performancePage.logar(properties.getProperties().getProperty("login.performance"), properties.getProperties().getProperty("login.performance.password"));
		performancePage.selecionarMenuPedidos();
		performancePage.selecionarSemana(driver, "Fevereiro 2015", "1");
		performancePage.esperarCarregamentoPedido();
		performancePage.tempoCarregamento("HML");
		System.out.println("Término do teste de pedidos \n");
	}
	
	@Test
	public void verificarPerformanceHMLDetalhePedido() throws Exception {
		System.out.println("*************************************************************** \n" + "Inicio do teste de detalhes do pedido \n");
		properties.lerArquivo();
		geral.abrir(driver);
		performancePage.logar(properties.getProperties().getProperty("login.performance"), properties.getProperties().getProperty("login.performance.password"));
		performancePage.selecionarMenuPedidos();
		performancePage.selecionarSemana(driver, "Fevereiro 2015", "1");
		performancePage.selecionaPedido();
		performancePage.esperarCarregamentoDetalhePedido();
		performancePage.tempoCarregamento("HML");
		System.out.println("Término do teste de detalhes do pedido \n");
	}

	@Test
	public void verificarPerformanceHMLSacolas() throws Exception {
		System.out.println("*************************************************************** \n" + "Inicio do teste de sacolas \n");
		properties.lerArquivo();
		geral.abrir(driver);
		performancePage.logar(properties.getProperties().getProperty("login.performance"), properties.getProperties().getProperty("login.performance.password"));
		performancePage.selecionarMenuSacolas();	
		performancePage.esperarCarregamentoSacolas();
		performancePage.tempoCarregamento("HML");
		System.out.println("Término do teste de sacolas \n");
	}
	
	@Test
	public void verificarPerformanceHMLOferecaDeNovo() throws Exception {
		System.out.println("*************************************************************** \n" + "Inicio do teste de ofereça de novo \n");
		properties.lerArquivo();
		geral.abrir(driver);
		performancePage.logar(properties.getProperties().getProperty("login.performance"), properties.getProperties().getProperty("login.performance.password"));
		performancePage.selecionarMenuOferecaDeNovo();	
		performancePage.esperarCarregamentoOferecaDeNovo();
		performancePage.tempoCarregamento("HML");
		System.out.println("Término do teste de ofereça de novo \n");
	}
	
	@Test
	public void verificarPerformanceHMLOferecaTambem() throws Exception {
		System.out.println("*************************************************************** \n" + "Inicio do teste de ofereça tambem \n");
		properties.lerArquivo();
		geral.abrir(driver);
		performancePage.logar(properties.getProperties().getProperty("login.performance"), properties.getProperties().getProperty("login.performance.password"));
		performancePage.selecionarMenuOferecaTambem();	
		performancePage.esperarCarregamentoOferecaTambem();
		performancePage.tempoCarregamento("HML");
		System.out.println("Término do teste de ofereça tambem \n");
	}
	
	@Test
	public void verificarPerformanceHMLAniversariante() throws Exception {
		System.out.println("*************************************************************** \n" + "Inicio do teste de aniversariante \n");
		properties.lerArquivo();
		geral.abrir(driver);
		performancePage.logar(properties.getProperties().getProperty("login.performance"), properties.getProperties().getProperty("login.performance.password"));
		performancePage.selecionarMenuAniversariante();	
		performancePage.esperarCarregamentoAniversariante();
		performancePage.tempoCarregamento("HML");
		System.out.println("Término do teste de aniversariante \n");
	}


	@After
	public void tearDown(){
		String verificationErrorString = performancePage.verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
		driver.close();
	}	
}
