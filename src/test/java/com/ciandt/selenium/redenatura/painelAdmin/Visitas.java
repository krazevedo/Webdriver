package com.ciandt.selenium.redenatura.painelAdmin;


import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Test;

import com.ciandt.selenium.redenatura.helpers.DataDriven;
import com.ciandt.selenium.redenatura.helpers.Geral;
import com.ciandt.selenium.redenatura.pages.LoginPage;
import com.ciandt.selenium.redenatura.pages.VisitasPage;



public class Visitas extends TestBase{
	VisitasPage visitasPage = new VisitasPage();
	LoginPage loginPage = new LoginPage();
	Geral geral = new Geral();
	DataDriven properties = new DataDriven();
	

	@Test
	public void verificarSemanaAtual() throws Exception {
		properties.lerArquivo();
		geral.abrir(driver);
		loginPage.logar(properties.getProperties().getProperty("login.active"), properties.getProperties().getProperty("login.active.password"));
		visitasPage.selecionarMenu();
		visitasPage.verificaSemanaAtual();
	}

	@Test
	public void verificarValoresBoxes() throws Exception {
		properties.lerArquivo();
		geral.abrir(driver);
		loginPage.logar(properties.getProperties().getProperty("login.active"), properties.getProperties().getProperty("login.active.password"));
		visitasPage.selecionarMenu();
		geral.selecionarSemana(driver, properties.getProperties().getProperty("visitas.datapicker"), properties.getProperties().getProperty("visitas.datapicker.semana"));
		visitasPage.validaValoresBoxes();
	}	

	@After
	public void tearDown(){
		String verificationErrorString = visitasPage.verificationErrors.toString();
		String verificationErrorString2 = loginPage.verificationErrors.toString();		
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
		if (!"".equals(verificationErrorString2)) {
			fail(verificationErrorString2);
		}				
		driver.close();
	}	
}
