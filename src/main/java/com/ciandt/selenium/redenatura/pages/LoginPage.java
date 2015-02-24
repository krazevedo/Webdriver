package com.ciandt.selenium.redenatura.pages;

import static org.junit.Assert.*;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.NoSuchElementException;

import com.ciandt.selenium.redenatura.helpers.CssSelectors;
import com.ciandt.selenium.redenatura.painelAdmin.TestBase;

public class LoginPage extends TestBase{
	public static Set<Cookie> cookieAntes;
	public static Set<Cookie> cookieDepois;
	public StringBuffer verificationErrors = new StringBuffer();
	CssSelectors css = new CssSelectors();

	public void logar(String user, String pass) throws Exception{
		driver.findElement(By.cssSelector("form > div:nth-child(1) > div:nth-child(1) > div > input")).clear();
		driver.findElement(By.cssSelector("form > div:nth-child(1) > div:nth-child(1) > div > input")).sendKeys(user);
		driver.findElement(By.cssSelector("form > div:nth-child(1) > div:nth-child(2) > div > input")).clear();
		driver.findElement(By.cssSelector("form > div:nth-child(1) > div:nth-child(2) > div > input")).sendKeys(pass);
		driver.findElement(By.cssSelector("button#okButton")).click();
	}

	public void fecharBrowser(){
		driver.close();	
		driver.get("");
	}

	public Set<Cookie> getCookieAntes(){
		cookieAntes = driver.manage().getCookies();
		return cookieAntes;
	}

	public Set<Cookie> getCookieDepois(){
		cookieDepois = driver.manage().getCookies();
		return cookieDepois;
	}

	public void compararCookies(){
		try {
			cookieAntes.equals(cookieDepois);
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
	}

	public void clicarBotaoQueroMeCadastrar(){
		driver.findElement(By.cssSelector("div > div > div > a.btn")).click();
	}

	public void clicarBotaoEsqueciMinhaSenha(){
		driver.findElement(By.cssSelector("form > div > div > div > a > small.ng-scope")).click();
	}

	public void validarMensagemLoginNulo(String user){
		if (user == ""){
			try {
				assertEquals("Digite o seu usuário.", driver.findElement(By.cssSelector("form > div:nth-child(1) > div:nth-child(1) > div > div > span")).getText());
			} catch (Error e) {
				verificationErrors.append(e.toString());
			}
		} else {
			try {
				assertTrue(isElementPresent(By.cssSelector("form > div:nth-child(1) > div:nth-child(1) > div > div > span:nth-child(1).ng-hide")));
			} catch (Error e) {
				verificationErrors.append(e.toString());
			}
		}
	}

	public void validarMensagemSenhaNulo(String pass){
		if (pass == ""){
			try {
				assertEquals("Digite a sua senha", driver.findElement(By.cssSelector("form > div:nth-child(1) > div:nth-child(2) > div > div > span")).getText());
			} catch (Error e) {
				verificationErrors.append(e.toString());
			}
		} else {
			try {
				assertTrue(isElementPresent(By.cssSelector("form > div:nth-child(1) > div:nth-child(2) > div > div > span.ng-hide")));
			} catch (Error e) {
				verificationErrors.append(e.toString());
			}
		}
	}

	public void validarMensagemLoginInvalido() throws Exception{
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("Login ou senha inválidos".equals(driver.findElement(By.cssSelector("form > div > span")).getText())) break; } catch (Exception e) {verificationErrors.append(e.toString());}
			Thread.sleep(1000);
		}				
	}

	public void validarMensagemFormatoInvalido() throws Exception{
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("Digite um usuário válido.".equals(driver.findElement(By.cssSelector("form > div:nth-child(1) > div:nth-child(1) > div > div > span:nth-child(2)")).getText())) break; } catch (Exception e) {verificationErrors.append(e.toString());}
			Thread.sleep(1000);
		}	
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
