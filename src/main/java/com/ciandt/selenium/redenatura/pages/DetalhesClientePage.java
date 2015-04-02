package com.ciandt.selenium.redenatura.pages;




import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ciandt.selenium.redenatura.helpers.CssSelectors;
import com.ciandt.selenium.redenatura.helpers.DataDriven;
import com.ciandt.selenium.redenatura.helpers.Geral;
import com.ciandt.selenium.redenatura.painelAdmin.TestBase;

public class DetalhesClientePage extends TestBase{
	public StringBuffer verificationErrors = new StringBuffer();
	CssSelectors css = new CssSelectors();
	public String valorGrid;
	Geral geral = new Geral();
	DataDriven properties = new DataDriven();

	public void verificaUrl() throws Exception{
		Thread.sleep(5000);
		properties.lerArquivo();
		String previousURL = driver.getCurrentUrl();
		try {
			assertEquals(properties.getProperties().getProperty("url") + "#/perfil-do-cliente/" + properties.getProperties().getProperty("cliente.id"), previousURL);
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
	}

	public void verificaTotalPedido() throws Exception{
		properties.lerArquivo();
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("Sub Total:".equals(driver.findElement(By.cssSelector("table.table.invoice-total > tbody > tr > td > strong.ng-scope")).getText())) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		WebElement baseTable = driver.findElement(By.cssSelector("div > div > rn-order-list > div > div > table.invoice-total"));
		List<WebElement> tableRows = baseTable.findElements(By.tagName("tr"));
		double total = 0.0;
		for (int i=0; i < tableRows.size()-1; i++){
			List<WebElement> cellRows = tableRows.get(i).findElements(By.tagName("td"));
			for (int x=0; x < cellRows.size(); x++){
				x = x + 1;
				if (cellRows.get(x).getText() != null && cellRows.get(x).getText().length() > 0){
					if (i == 3){
						total = total - Double.parseDouble(cellRows.get(x).getText().replaceAll("R|\\$| ", "").replaceAll(",", ".").replaceAll("(", "").replaceAll(")", ""));
					}
					total = total + Double.parseDouble(cellRows.get(x).getText().replaceAll("R|\\$| ", "").replaceAll(",", "."));
				}
			}
		}
		try {
			assertEquals(properties.getProperties().getProperty("detalhe.cliente.valor.pedido"), String.valueOf(total));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
	}

	public void verificaDescricaoProduto() throws Exception{
		properties.lerArquivo();
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("Sub Total:".equals(driver.findElement(By.cssSelector("table.table.invoice-total > tbody > tr > td > strong.ng-scope")).getText())) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		Thread.sleep(5000);
		WebElement baseTable = driver.findElement(By.cssSelector("div > div > rn-order-list > div > div > table.invoice-table"));
		List<WebElement> tableRows = baseTable.findElements(By.tagName("tr"));
		try {
			assertEquals(properties.getProperties().getProperty("detalhe.cliente.item1"), tableRows.get(1).findElements(By.tagName("td")).get(1).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals(properties.getProperties().getProperty("detalhe.cliente.item2"), tableRows.get(2).findElements(By.tagName("td")).get(1).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals(properties.getProperties().getProperty("detalhe.cliente.item3"), tableRows.get(3).findElements(By.tagName("td")).get(1).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals(properties.getProperties().getProperty("detalhe.cliente.item4"), tableRows.get(4).findElements(By.tagName("td")).get(1).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
	}

	public void verificaTotalItem() throws Exception{		
		properties.lerArquivo();
		Thread.sleep(5000);
		WebElement baseTable = driver.findElement(By.cssSelector("div:nth-child(2) > div > div > rn-order-list > div > div.col-md-12 > table.invoice-table"));
		List<WebElement> tableRows = baseTable.findElements(By.tagName("tr"));
		double soma = 0.0;		
		List<WebElement> cellRows = tableRows.get(1).findElements(By.tagName("td"));
		soma = (Integer.parseInt(cellRows.get(2).getText()) * Double.parseDouble(cellRows.get(3).getText().replaceAll("R|\\$| ", "").replaceAll(",", "."))) - Double.parseDouble(cellRows.get(4).getText().replaceAll("R|\\$| ", "").replaceAll("\\(", "").replaceAll("\\)", "").replaceAll(",", "."));				
		BigDecimal total = new BigDecimal(soma).setScale(2, RoundingMode.HALF_UP);
		try {
			assertEquals(properties.getProperties().getProperty("detalhe.cliente.valor.item1"), String.valueOf(total));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
	}

	public  String pegaValorGrid(){
		valorGrid = driver.findElement(css.quintaColuna).getText();	
		return valorGrid;
	}

	public void comparaValoresDetalhes() throws Exception{
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("Sub Total:".equals(driver.findElement(By.cssSelector("table.table.invoice-total > tbody > tr > td > strong.ng-scope")).getText())) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		WebElement baseTable = driver.findElement(By.cssSelector("div > div > rn-order-list > div > div > table.invoice-total"));
		List<WebElement> tableRows = baseTable.findElements(By.tagName("tr"));
		List<WebElement> cellRows = tableRows.get(3).findElements(By.tagName("td"));
		try {
			assertEquals(valorGrid, driver.findElement(By.cssSelector("div > rn-order-detail-box > div:nth-child(3) > div > dl > dd:nth-child(4)")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}		
		try {
			assertEquals(valorGrid, cellRows.get(1).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}		
	}


}
