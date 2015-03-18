package com.ciandt.selenium.redenatura.painelAdmin;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Test;

import com.ciandt.selenium.redenatura.helpers.DataDriven;
import com.ciandt.selenium.redenatura.helpers.Geral;
import com.ciandt.selenium.redenatura.pages.FaleComAgentePage;
import com.ciandt.selenium.redenatura.pages.LoginPage;

public class FaleComAgente extends TestBase{
	LoginPage loginPage = new LoginPage();
	FaleComAgentePage falePage = new FaleComAgentePage();
	Geral geral = new Geral();
	DataDriven properties = new DataDriven();

	@Test
	public void camposObrigatorios() throws Exception {
		properties.lerArquivo();
		geral.abrir(driver);
		loginPage.logar(properties.getProperties().getProperty("login.active"), properties.getProperties().getProperty("login.active.password"));
		falePage.selecionarMenu();
		falePage.enviarMensagem();
		falePage.validarMensagemCampoObrigatorio();
	}
	
	@Test
	public void validarMensagemEnviadaComSucesso() throws Exception {
		properties.lerArquivo();
		geral.abrir(driver);
		loginPage.logar(properties.getProperties().getProperty("login.active"), properties.getProperties().getProperty("login.active.password"));
		falePage.selecionarMenu();
		falePage.preencherMensagem();
		falePage.enviarMensagem();
		falePage.validarMensagem();
	}

	@Test
	public void validarQTDCaracteres() throws Exception {
		geral.abrir(driver);
		loginPage.logar("", "");
		loginPage.validarMensagemLoginNulo("");
		loginPage.validarMensagemSenhaNulo("");
	}

	@After
	public void tearDown(){
		String verificationErrorString  = loginPage.verificationErrors.toString();
		String verificationErrorString2 = falePage.verificationErrors.toString();
		
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
		if (!"".equals(verificationErrorString2)) {
			fail(verificationErrorString2);
		}		
		driver.close();
	}	

}
