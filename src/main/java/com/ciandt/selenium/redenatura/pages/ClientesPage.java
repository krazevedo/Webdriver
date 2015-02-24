package com.ciandt.selenium.redenatura.pages;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.ciandt.selenium.redenatura.helpers.CssSelectors;
import com.ciandt.selenium.redenatura.painelAdmin.TestBase;


public class ClientesPage extends TestBase{

	public StringBuffer verificationErrors = new StringBuffer();
	CssSelectors css = new CssSelectors();

	public void selecionarMenu() throws Exception{
		driver.findElement(css.menuVisitas).click();
		driver.findElement(css.segundoSubmenu).click();
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (isElementPresent(css.iconePrint)) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
	}

	public void validaValoresBoxes()throws Exception{
		Thread.sleep(5000);
		try {
			assertEquals("1", driver.findElement(css.pedidosAprovados).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals("0%", driver.findElement(css.taxaConversaoP).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}		
	}

	public void validaColunasGrid() throws Exception{
		Thread.sleep(5000);
		List<WebElement> forms = driver.findElements(css.nomeColunasGrid);
		try {
			assertEquals("Alertas", forms.get(0).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals("Cliente", forms.get(1).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals("Aniversário", forms.get(2).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals("Compras realizadas", forms.get(3).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals("Último pedido", forms.get(4).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals("Valor c/ frete", forms.get(5).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals("Ações", forms.get(6).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
	}

	public void validaValoresTabelas(){
		try {
			assertEquals("Kaio Azevedo", driver.findElement(css.primeiraColunaLink).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals("16/08/1950", driver.findElement(css.segundaColuna).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals("3", driver.findElement(css.terceiraColunaSpam).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals("75851202", driver.findElement(css.quartaColunaLink).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals("R$163,20", driver.findElement(css.quintaColuna).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
	}	
	
	public void clicarVerPerfil(){
		driver.findElement(By.linkText("ver perfil")).click();
	}
	
	public void clicarGerarCupom(){
		driver.findElement(By.linkText("gerar cupom")).click();
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
