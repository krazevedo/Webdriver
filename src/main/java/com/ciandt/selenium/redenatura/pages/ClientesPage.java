package com.ciandt.selenium.redenatura.pages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ciandt.selenium.redenatura.helpers.CssSelectors;
import com.ciandt.selenium.redenatura.helpers.DataDriven;
import com.ciandt.selenium.redenatura.painelAdmin.TestBase;


public class ClientesPage extends TestBase{
	private long timeStart;
    private long timeEnd;
    public StringBuffer verificationErrors = new StringBuffer();
	CssSelectors css = new CssSelectors();
	DataDriven properties = new DataDriven();
	
	
	public void selecionarMenu() throws Exception{
		driver.findElement(css.menuVisitas).click();
		Thread.sleep(2000);
		driver.findElement(css.segundoSubmenu).click();
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (isElementPresent(css.iconePrint)) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		timeStart = System.currentTimeMillis();
	}

	
	public void validaColunasGrid() throws Exception{
		properties.lerArquivo();
		Thread.sleep(5000);
		List<WebElement> forms = driver.findElements(css.nomeColunasGrid);
		try {
			assertEquals(properties.getProperties().getProperty("cliente.coluna1"), forms.get(0).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals(properties.getProperties().getProperty("cliente.coluna2"), forms.get(1).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals(properties.getProperties().getProperty("cliente.coluna3"), forms.get(2).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals(properties.getProperties().getProperty("cliente.coluna4"), forms.get(3).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals(properties.getProperties().getProperty("cliente.coluna5"), forms.get(4).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals(properties.getProperties().getProperty("cliente.coluna6"), forms.get(5).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals(properties.getProperties().getProperty("cliente.coluna7"), forms.get(6).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
	}

	public void validaValoresTabelas() throws IOException{
		properties.lerArquivo();
		try {
			assertEquals(properties.getProperties().getProperty("cliente.nome"), driver.findElement(css.primeiraColunaLink).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals(properties.getProperties().getProperty("cliente.nascimento"), driver.findElement(css.segundaColuna).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals(properties.getProperties().getProperty("cliente.compras"), driver.findElement(css.terceiraColunaSpam).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals(properties.getProperties().getProperty("cliente.ultimo.pedido"), driver.findElement(css.quartaColunaLink).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals(properties.getProperties().getProperty("cliente.valor.pedido"), driver.findElement(css.quintaColuna).getText());
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
	
	public void esperarCarregamento(){
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(css.primeiraColunaLink));
		timeEnd = System.currentTimeMillis();
	}
	
	public void tempoCarregamento(String env){
		double seconds = (timeEnd-timeStart)/1000.0;
        System.out.println((env + " - " + "Time elapsed: "+new DecimalFormat("0.000").format(seconds)+" sec\n"));
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
