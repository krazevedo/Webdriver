package com.ciandt.selenium.redenatura.pages;

import static org.junit.Assert.assertEquals;

import com.ciandt.selenium.redenatura.painelAdmin.TestBase;

public class CadastroPage extends TestBase{
	public StringBuffer verificationErrors = new StringBuffer();
	public void verificarLinkCadastro(){		
		String previousURL = driver.getCurrentUrl();
		try {
			assertEquals("http://cadastro.rede.natura.net/cadastro/passo-1", previousURL);
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
	}
}
