package com.ciandt.selenium.redenatura.pages;




import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ciandt.selenium.redenatura.helpers.CssSelectors;
import com.ciandt.selenium.redenatura.helpers.DataDriven;
import com.ciandt.selenium.redenatura.painelAdmin.TestBase;

public class DetalhesPedidoPage extends TestBase{
	public StringBuffer verificationErrors = new StringBuffer();
	CssSelectors css = new CssSelectors();
	PedidosPage pedidosPage = new PedidosPage();
	DataDriven properties = new DataDriven();
	

	public void verificaTotalPedido() throws Exception{
		properties.lerArquivo();
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("Sub Total:".equals(driver.findElement(By.cssSelector("table.table.invoice-total > tbody > tr > td > strong.ng-scope")).getText())) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		Thread.sleep(2000);
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

	public void verificaValoresFreteCupom(String tipo) throws Exception{
		properties.lerArquivo();
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("Sub Total:".equals(driver.findElement(By.cssSelector("table.table.invoice-total > tbody > tr > td > strong.ng-scope")).getText())) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		Thread.sleep(2000);
		WebElement baseTable = driver.findElement(By.cssSelector("div > div > rn-order-list > div > div > table.invoice-total"));
		List<WebElement> tableRows = baseTable.findElements(By.tagName("tr"));		
		if (tipo == "frete"){	
			List<WebElement> cellRows = tableRows.get(1).findElements(By.tagName("td"));
			try {
				assertEquals(properties.getProperties().getProperty("detalhe.pedido.valor.frete"), cellRows.get(1).getText());
			} catch (Error e) {
				verificationErrors.append(e.toString());
			}
		} else if(tipo == "cupom"){
			List<WebElement> cellRows = tableRows.get(2).findElements(By.tagName("td"));
			try {
				assertEquals(properties.getProperties().getProperty("detalhe.pedido.valor.cupom"), cellRows.get(1).getText());
			} catch (Error e) {
				verificationErrors.append(e.toString());
			}
		}		
	}

	public void verificaDescricaoProduto() throws Exception{
		properties.lerArquivo();
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("Sub Total:".equals(driver.findElement(By.cssSelector("table.table.invoice-total > tbody > tr > td > strong.ng-scope")).getText())) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		Thread.sleep(2000);
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
		Thread.sleep(2000);
		WebElement baseTable = driver.findElement(By.cssSelector("div > div > rn-order-list > div > div.col-md-12 > table.invoice-table"));
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

	public void comparaValoresDetalhes() throws Exception{
		properties.lerArquivo();
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("Sub Total:".equals(driver.findElement(By.cssSelector("table.table.invoice-total > tbody > tr > td > strong.ng-scope")).getText())) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		Thread.sleep(2000);
		WebElement baseTable = driver.findElement(By.cssSelector("div > div > rn-order-list > div > div > table.invoice-total"));
		List<WebElement> tableRows = baseTable.findElements(By.tagName("tr"));
		List<WebElement> cellRows = tableRows.get(3).findElements(By.tagName("td"));
		try {
			assertEquals(properties.getProperties().getProperty("cliente.valor.pedido"), driver.findElement(By.cssSelector("div > rn-order-detail-box > div:nth-child(3) > div > dl > dd:nth-child(4)")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}		
		try {
			assertEquals(properties.getProperties().getProperty("cliente.valor.pedido"), cellRows.get(1).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}		
	}

	public void verificaLabelCupom() throws Exception{
		properties.lerArquivo();
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("Sub Total:".equals(driver.findElement(By.cssSelector("table.table.invoice-total > tbody > tr > td > strong.ng-scope")).getText())) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		try {
			assertEquals(properties.getProperties().getProperty("detalhe.pedido.label.cupom"), driver.findElement(By.cssSelector("div > dl > dd:nth-child(6) > span.text-navy")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}	
	}

}
