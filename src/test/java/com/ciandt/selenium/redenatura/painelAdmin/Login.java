package com.ciandt.selenium.redenatura.painelAdmin;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Test;

import com.ciandt.selenium.redenatura.helpers.DataDriven;
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
	DataDriven properties = new DataDriven();

	@Test
	public void loginInvalido() throws Exception {
		properties.lerArquivo();
		geral.abrir(driver);
		loginPage.logar("xxxxx@a.com", properties.getProperties().getProperty("login.active.password"));
		loginPage.validarMensagemLoginInvalido();
	}
	
	@Test
	public void validarFormatoEmailInvalido() throws Exception {
		properties.lerArquivo();
		geral.abrir(driver);
		loginPage.logar("xxxxx", properties.getProperties().getProperty("login.active.password"));
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
		properties.lerArquivo();
		geral.abrir(driver);
		loginPage.logar("", properties.getProperties().getProperty("login.active.password"));
	}

	@Test
	public void validarSenhaNulo() throws Exception {
		properties.lerArquivo();
		geral.abrir(driver);
		loginPage.logar(properties.getProperties().getProperty("login.active"), "");
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
		properties.lerArquivo();
		geral.abrir(driver);
		loginPage.logar(properties.getProperties().getProperty("login.active"), properties.getProperties().getProperty("login.active.password"));
		homePage.verificarLogin();
	}

	@Test
	public void validarCndActiveAndNotAccepted() throws Exception {
		properties.lerArquivo();
		geral.abrir(driver);
		loginPage.logar(properties.getProperties().getProperty("login.activenotaccepted"), properties.getProperties().getProperty("login.activenotaccepted.password"));
		homePage.verificarContrato();
	}
	
	@Test
	public void validarCndCancelled() throws Exception {
		properties.lerArquivo();
		geral.abrir(driver);
		loginPage.logar(properties.getProperties().getProperty("login.cancelled"), properties.getProperties().getProperty("login.cancelled.password"));
		homePage.verificarLogin();
	}
	
	@Test
	public void validarCndInactive() throws Exception {
		properties.lerArquivo();
		geral.abrir(driver);
		loginPage.logar(properties.getProperties().getProperty("login.inactive"), properties.getProperties().getProperty("login.inactive.password"));
		homePage.verificarLogin();
	}
	
	@Test
	public void validarCndWaiting() throws Exception {
		properties.lerArquivo();
		geral.abrir(driver);
		loginPage.logar(properties.getProperties().getProperty("login.waiting"), properties.getProperties().getProperty("login.waiting.password"));
		contagemPage.verificaPaginaContagem();
	}

	@After
	public void tearDown(){
		String verificationErrorString  = loginPage.verificationErrors.toString();
		String verificationErrorString2 = cadastroPage.verificationErrors.toString();
		String verificationErrorString3 = contaPage.verificationErrors.toString();
		String verificationErrorString4 = homePage.verificationErrors.toString();
		String verificationErrorString5 = contagemPage.verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
		if (!"".equals(verificationErrorString2)) {
			fail(verificationErrorString2);
		}
		if (!"".equals(verificationErrorString3)) {
			fail(verificationErrorString3);
		}
		if (!"".equals(verificationErrorString4)) {
			fail(verificationErrorString3);
		}
		if (!"".equals(verificationErrorString5)) {
			fail(verificationErrorString3);
		}
		driver.close();
	}	

}
