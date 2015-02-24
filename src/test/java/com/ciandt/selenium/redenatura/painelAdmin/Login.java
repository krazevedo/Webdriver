package com.ciandt.selenium.redenatura.painelAdmin;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Test;

import com.ciandt.selenium.redenatura.helpers.Geral;
import com.ciandt.selenium.redenatura.pages.CadastroPage;
import com.ciandt.selenium.redenatura.pages.ContagemPage;
import com.ciandt.selenium.redenatura.pages.HomePage;
import com.ciandt.selenium.redenatura.pages.LoginPage;
import com.ciandt.selenium.redenatura.pages.MinhaContaPage;

public class Login extends TestBase{
	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	ContagemPage contagemPage = new ContagemPage();
	CadastroPage cadastroPage = new CadastroPage();
	MinhaContaPage contaPage = new MinhaContaPage();
	Geral geral = new Geral();

	@Test
	public void loginInvalido() throws Exception {
		geral.abrir(driver);
		loginPage.logar("xxxxx@a.com", "123qwe123");
		loginPage.validarMensagemLoginInvalido();
	}
	
	@Test
	public void validarFormatoEmailInvalido() throws Exception {
		geral.abrir(driver);
		loginPage.logar("xxxxx", "123qwe123");
		loginPage.validarMensagemFormatoInvalido();
	}

	@Test
	public void validarLoginNulo() throws Exception {
		geral.abrir(driver);
		loginPage.logar("", "");
		loginPage.validarMensagemLoginNulo("");
		loginPage.validarMensagemSenhaNulo("");
	}

	@Test
	public void validarSoLoginNulo() throws Exception {
		geral.abrir(driver);
		loginPage.logar("", "123qwe123");
	}

	@Test
	public void validarSenhaNulo() throws Exception {
		geral.abrir(driver);
		loginPage.logar("thiago2@a.com", "");
	}

	@Test
	public void validarEsqueciMinhaSenha() throws Exception {
		geral.abrir(driver);
		loginPage.clicarBotaoEsqueciMinhaSenha();
		contaPage.verificarLinkMinhaConta();
	}

	@Test
	public void validarLinkQueroMeCadastrar() throws Exception {
		geral.abrir(driver);
		loginPage.clicarBotaoQueroMeCadastrar();
		cadastroPage.verificarLinkCadastro();
	}

	@Test
	public void validarCndActive() throws Exception {
		geral.abrir(driver);
		loginPage.logar("thiago2@a.com", "123qwe123");
		homePage.verificarLogin();
	}

	@Test
	public void validarCndActiveAndNotAccepted() throws Exception {
		geral.abrir(driver);
		loginPage.logar("aa26@aa.aa", "A1A2A3");
		homePage.verificarLogin();
	}
	
	@Test
	public void validarCndCancelled() throws Exception {
		geral.abrir(driver);
		loginPage.logar("aa34@aa.aa", "A1A2A3");
		homePage.verificarLogin();
	}
	
	@Test
	public void validarCndInactive() throws Exception {
		geral.abrir(driver);
		loginPage.logar("aa39@aa.aa", "A1A2A3");
		homePage.verificarLogin();
	}
	
	@Test
	public void validarCndWaiting() throws Exception {
		geral.abrir(driver);
		loginPage.logar("aa190@mailinator.com", "A1A2A3");
		contagemPage.verificaPaginaContagem();
	}
/*	
	@Test
	public void validarDesistenciaAssinaturaBotaoX() throws Exception {
		geral.abrir(driver);
		loginPage.logar("thiago2@a.com", "inicial1");
		
	}
	
	@Test
	public void validarDesistenciaAssinaturaBotaoDesistir() throws Exception {
		geral.abrir(driver);
		loginPage.logar("thiago2@a.com", "inicial1");
		
	}
	
	@Test
	public void cookie() throws Exception {
		geral.abrir();
		loginPage.logar("thiago2@a.com", "123qwe123");
		loginPage.getCookieAntes();		
		loginPage.fecharBrowser();
		loginPage.getCookieDepois();
		loginPage.compararCookies();
	}*/
	
	

	@After
	public void tearDown(){
		String verificationErrorString = loginPage.verificationErrors.toString();
		String verificationErrorString2 = cadastroPage.verificationErrors.toString();
		String verificationErrorString3 = contaPage.verificationErrors.toString();
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
