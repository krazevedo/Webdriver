package com.ciandt.selenium.redenatura.painelAdmin;


import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Test;

import com.ciandt.selenium.redenatura.helpers.DataDriven;
import com.ciandt.selenium.redenatura.helpers.Geral;
import com.ciandt.selenium.redenatura.pages.PerformancePage;


public class PerformancePRD extends TestBase{
	
	DataDriven properties = new DataDriven();
	PerformancePage performancePage = new PerformancePage();
	Geral geral = new Geral();
	


	@Test
	public void verificarPerformancePRDHome() throws Exception {
		System.out.println("*************************************************************** \n" + "Inicio do teste de home \n");
		properties.lerArquivo();
		geral.abrir2(driver, "url.prod");
		performancePage.logar(properties.getProperties().getProperty("login.performance.prod"), properties.getProperties().getProperty("login.performance.prod.password"));
		performancePage.tempoLogin();
		performancePage.esperarCarregamentoHome();
		performancePage.tempoCarregamento("PRD");
		System.out.println("Término do teste de home \n");
	}
	
		
	@Test
	public void verificarPerformancePRDClientes() throws Exception {
		System.out.println("*************************************************************** \n" + "Inicio do teste de clientes \n");
		properties.lerArquivo();
		geral.abrir2(driver, "url.prod");
		performancePage.logar(properties.getProperties().getProperty("login.performance.prod"), properties.getProperties().getProperty("login.performance.prod.password"));
		performancePage.selecionarMenuClientes();	
		performancePage.esperarCarregamentoClientes();
		performancePage.tempoCarregamento("PRD");
		System.out.println("Término do teste de clientes \n");
	}
	
	@Test
	public void verificarPerformancePRDDetalhesCliente() throws Exception {
		System.out.println("*************************************************************** \n" + "Inicio do teste de detalhes do cliente \n");
		properties.lerArquivo();
		geral.abrir2(driver, "url.prod");
		performancePage.logar(properties.getProperties().getProperty("login.performance.prod"), properties.getProperties().getProperty("login.performance.prod.password"));
		performancePage.selecionarMenuClientes();
		geral.realizarBusca(driver, "R$4");
		performancePage.clicarVerPerfil();
		performancePage.esperarCarregamentoDetalheCliente();
		performancePage.tempoCarregamento("PRD");
		System.out.println("Término do teste de detalhes do cliente \n");
	}
	
	@Test
	public void verificarPerformancePRDPedidos() throws Exception {
		System.out.println("*************************************************************** \n" + "Inicio do teste de pedidos \n");
		properties.lerArquivo();
		geral.abrir2(driver, "url.prod");
		performancePage.logar(properties.getProperties().getProperty("login.performance.prod"), properties.getProperties().getProperty("login.performance.prod.password"));
		performancePage.selecionarMenuPedidos();
		//performancePage.selecionarSemana(driver, "Fevereiro 2015", "1");
		performancePage.esperarCarregamentoPedido();
		performancePage.tempoCarregamento("PRD");
		System.out.println("Término do teste de pedidos \n");
	}
	
	@Test
	public void verificarPerformancePRDDetalhePedido() throws Exception {
		System.out.println("*************************************************************** \n" + "Inicio do teste de detalhes do pedido \n");
		properties.lerArquivo();
		geral.abrir2(driver, "url.prod");
		performancePage.logar(properties.getProperties().getProperty("login.performance.prod"), properties.getProperties().getProperty("login.performance.prod.password"));
		performancePage.selecionarMenuPedidos();
		performancePage.selecionarSemana(driver, "Fevereiro 2015", "1");
		performancePage.selecionaPedido();
		performancePage.esperarCarregamentoDetalhePedido();
		performancePage.tempoCarregamento("PRD");
		System.out.println("Término do teste de detalhes do pedido \n");
	}

	@Test
	public void verificarPerformancePRDSacolas() throws Exception {
		System.out.println("*************************************************************** \n" + "Inicio do teste de sacolas \n");
		properties.lerArquivo();
		geral.abrir2(driver, "url.prod");
		performancePage.logar(properties.getProperties().getProperty("login.performance.prod"), properties.getProperties().getProperty("login.performance.prod.password"));
		performancePage.selecionarMenuSacolas();	
		performancePage.esperarCarregamentoSacolas();
		performancePage.tempoCarregamento("PRD");
		System.out.println("Término do teste de sacolas \n");
	}
	
	@Test
	public void verificarPerformancePRDOferecaDeNovo() throws Exception {
		System.out.println("*************************************************************** \n" + "Inicio do teste de ofereça de novo \n");
		properties.lerArquivo();
		geral.abrir2(driver, "url.prod");
		performancePage.logar(properties.getProperties().getProperty("login.performance.prod"), properties.getProperties().getProperty("login.performance.prod.password"));
		performancePage.selecionarMenuOferecaDeNovo();	
		performancePage.esperarCarregamentoOferecaDeNovo();
		performancePage.tempoCarregamento("PRD");
		System.out.println("Término do teste de ofereça de novo \n");
	}
	
	@Test
	public void verificarPerformancePRDOferecaTambem() throws Exception {
		System.out.println("*************************************************************** \n" + "Inicio do teste de ofereça tambem \n");
		properties.lerArquivo();
		geral.abrir2(driver, "url.prod");
		performancePage.logar(properties.getProperties().getProperty("login.performance.prod"), properties.getProperties().getProperty("login.performance.prod.password"));
		performancePage.selecionarMenuOferecaTambem();	
		performancePage.esperarCarregamentoOferecaTambem();
		performancePage.tempoCarregamento("PRD");
		System.out.println("Término do teste de ofereça tambem \n");
	}
	
	@Test
	public void verificarPerformancePRDAniversariante() throws Exception {
		System.out.println("*************************************************************** \n" + "Inicio do teste de aniversariante \n");
		properties.lerArquivo();
		geral.abrir2(driver, "url.prod");
		performancePage.logar(properties.getProperties().getProperty("login.performance.prod"), properties.getProperties().getProperty("login.performance.prod.password"));
		performancePage.selecionarMenuAniversariante();	
		performancePage.esperarCarregamentoAniversariante();
		performancePage.tempoCarregamento("PRD");
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
