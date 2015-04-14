package com.ciandt.selenium.redenatura.painelAdmin;


import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Test;

import com.ciandt.selenium.redenatura.helpers.DataDriven;
import com.ciandt.selenium.redenatura.helpers.Geral;
import com.ciandt.selenium.redenatura.pages.PerformancePage;


public class PerformanceAlfeu extends TestBase{
	
	DataDriven properties = new DataDriven();
	PerformancePage performancePage = new PerformancePage();
	Geral geral = new Geral();
	


	@Test
	public void verificarPerformanceAlfeuHome() throws Exception {
		System.out.println("*************************************************************** \n" + "Inicio do teste de home \n");
		properties.lerArquivo();
		geral.abrir2(driver, "url.alfeu");
		performancePage.logar(properties.getProperties().getProperty("login.performance"), properties.getProperties().getProperty("login.performance.password"));
		performancePage.tempoLogin();
		performancePage.esperarCarregamentoHome();
		performancePage.tempoCarregamento("Alfeu");
		System.out.println("Término do teste de home \n");
	}
	
		
	@Test
	public void verificarPerformanceAlfeuClientes() throws Exception {
		System.out.println("*************************************************************** \n" + "Inicio do teste de clientes \n");
		properties.lerArquivo();
		geral.abrir2(driver, "url.alfeu");
		performancePage.logar(properties.getProperties().getProperty("login.performance"), properties.getProperties().getProperty("login.performance.password"));
		performancePage.selecionarMenuClientes();	
		performancePage.esperarCarregamentoClientes();
		performancePage.tempoCarregamento("Alfeu");
		System.out.println("Término do teste de clientes \n");
		performancePage.tempoHome();
		performancePage.esperarCarregamentoHome();
		performancePage.tempoCarregamento("Alfeu");
		System.out.println("Término do teste de home \n");
	}
	
	@Test
	public void verificarPerformanceAlfeuDetalhesCliente() throws Exception {
		System.out.println("*************************************************************** \n" + "Inicio do teste de detalhes do cliente \n");
		properties.lerArquivo();
		geral.abrir2(driver, "url.alfeu");
		performancePage.logar(properties.getProperties().getProperty("login.performance"), properties.getProperties().getProperty("login.performance.password"));
		performancePage.selecionarMenuClientes();
		geral.realizarBusca(driver, "R$4");
		performancePage.clicarVerPerfil();
		performancePage.esperarCarregamentoDetalheCliente();
		performancePage.tempoCarregamento("Alfeu");
		System.out.println("Término do teste de detalhes do cliente \n");
	}
	
	@Test
	public void verificarPerformanceAlfeuPedidos() throws Exception {
		System.out.println("*************************************************************** \n" + "Inicio do teste de pedidos \n");
		properties.lerArquivo();
		geral.abrir2(driver, "url.alfeu");
		performancePage.logar(properties.getProperties().getProperty("login.performance"), properties.getProperties().getProperty("login.performance.password"));
		performancePage.selecionarMenuPedidos();
		performancePage.esperarCarregamentoPedido();
		performancePage.tempoCarregamento("Alfeu");
		System.out.println("Término do teste de pedidos \n");
	}
	
	@Test
	public void verificarPerformanceAlfeuDetalhePedido() throws Exception {
		System.out.println("*************************************************************** \n" + "Inicio do teste de detalhes do pedido \n");
		properties.lerArquivo();
		geral.abrir2(driver, "url.alfeu");
		performancePage.logar(properties.getProperties().getProperty("login.performance"), properties.getProperties().getProperty("login.performance.password"));
		performancePage.selecionarMenuPedidos();
		performancePage.selecionaPedido();
		performancePage.esperarCarregamentoDetalhePedido();
		performancePage.tempoCarregamento("Alfeu");
		System.out.println("Término do teste de detalhes do pedido \n");
	}

	@Test
	public void verificarPerformanceAlfeuSacolas() throws Exception {
		System.out.println("*************************************************************** \n" + "Inicio do teste de sacolas \n");
		properties.lerArquivo();
		geral.abrir2(driver, "url.alfeu");
		performancePage.logar(properties.getProperties().getProperty("login.performance"), properties.getProperties().getProperty("login.performance.password"));
		performancePage.selecionarMenuSacolas();	
		performancePage.esperarCarregamentoSacolas();
		performancePage.tempoCarregamento("Alfeu");
		System.out.println("Término do teste de sacolas \n");
	}
	
	@Test
	public void verificarPerformanceAlfeuOferecaDeNovo() throws Exception {
		System.out.println("*************************************************************** \n" + "Inicio do teste de ofereça de novo \n");
		properties.lerArquivo();
		geral.abrir2(driver, "url.alfeu");
		performancePage.logar(properties.getProperties().getProperty("login.performance"), properties.getProperties().getProperty("login.performance.password"));
		performancePage.selecionarMenuOferecaDeNovo();	
		performancePage.esperarCarregamentoOferecaDeNovo();
		performancePage.tempoCarregamento("Alfeu");
		System.out.println("Término do teste de ofereça de novo \n");
	}
	
	@Test
	public void verificarPerformanceAlfeuOferecaTambem() throws Exception {
		System.out.println("*************************************************************** \n" + "Inicio do teste de ofereça tambem \n");
		properties.lerArquivo();
		geral.abrir2(driver, "url.alfeu");
		performancePage.logar(properties.getProperties().getProperty("login.performance"), properties.getProperties().getProperty("login.performance.password"));
		performancePage.selecionarMenuOferecaTambem();	
		performancePage.esperarCarregamentoOferecaTambem();
		performancePage.tempoCarregamento("Alfeu");
		System.out.println("Término do teste de ofereça tambem \n");
	}
	
	@Test
	public void verificarPerformanceAlfeuAniversariante() throws Exception {
		System.out.println("*************************************************************** \n" + "Inicio do teste de aniversariante \n");
		properties.lerArquivo();
		geral.abrir2(driver, "url.alfeu");
		performancePage.logar(properties.getProperties().getProperty("login.performance"), properties.getProperties().getProperty("login.performance.password"));
		performancePage.selecionarMenuAniversariante();	
		performancePage.esperarCarregamentoAniversariante();
		performancePage.tempoCarregamento("Alfeu");
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
