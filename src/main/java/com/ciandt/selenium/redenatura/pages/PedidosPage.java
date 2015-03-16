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
import com.ciandt.selenium.redenatura.helpers.DataDriven;
import com.ciandt.selenium.redenatura.painelAdmin.TestBase;


public class PedidosPage extends TestBase{

	public StringBuffer verificationErrors = new StringBuffer();
	CssSelectors css = new CssSelectors();
	DataDriven properties = new DataDriven();
	public String valorGrid;

	public void selecionarMenu() throws Exception{
		driver.findElement(css.menuPedidos).click();
		Thread.sleep(2000);
		driver.findElement(css.primeiroSubmenu).click();
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (isElementPresent(css.iconePrint)) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
	}

	public void selecionarSemanaAtual(){
		Date toDay = new Date();
		DateFormat formatador = new SimpleDateFormat("dd");
		String day = formatador.format(toDay);

		driver.findElement(By.cssSelector("div:nth-child(1) > rn-weekly-calendar > div > div > input")).click();
		List<WebElement> table = driver.findElements(By.cssSelector("div.datepicker-days > table > tbody > tr"));

		for (int i=0; i < table.size(); i++){
			String date = table.get(i).findElement(By.className("day")).getText();
			if (((Integer.parseInt(day) < Integer.parseInt(date)) && (i > 0))) {
				table.get(i-1).click();
				break;
			} 
		}
		table.get(table.size()).click();
	}

	public boolean verificaSemanaAtual() throws ParseException{
		DateFormat firstDay = new SimpleDateFormat("dd/MM/yyyy");
		DateFormat lastDay = new SimpleDateFormat("dd/MM/yyyy");
		Date toDay = new Date();

		String startDate = driver.findElement(By.cssSelector("input#start-date")).getAttribute("value");
		String endDate = driver.findElement(By.cssSelector("input#end-date")).getAttribute("value");
		return firstDay.parse(startDate).before(toDay) && lastDay.parse(endDate).after(toDay);

	}


	public void validaValoresBoxes()throws Exception{
		properties.lerArquivo();
		Thread.sleep(5000);
		try {
			assertEquals(properties.getProperties().getProperty("pedido.aprovado"), driver.findElement(css.pedidosAprovados).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals(properties.getProperties().getProperty("pedido.conversao"), driver.findElement(css.taxaConversaoP).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}		
	}

	public void selecionaPedido(){
		driver.findElement(css.primeiraColunaLink).click();		
	}

	public void resgatarSaldo(){
		driver.findElement(css.botaoResgatar).click();
	}
	
	public  String pegaValorGrid(){
		valorGrid = driver.findElement(css.quartaColuna).getText();	
		return valorGrid;
	}

	public void validaColunasGrid() throws Exception{
		Thread.sleep(5000);
		List<WebElement> forms = driver.findElements(css.nomeColunasGrid);
		try {
			assertEquals("Status do pedido", forms.get(0).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals("Pedido", forms.get(1).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals("Cliente", forms.get(2).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals("Data da compra", forms.get(3).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals("Valor (com frete)", forms.get(4).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals("Ações", forms.get(5).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
	}

	public void validaValoresTabelas() throws Exception{
		Thread.sleep(2000);
		properties.lerArquivo();
		try {
			assertEquals(properties.getProperties().getProperty("pedido.status.label"), driver.findElement(css.primeiraColunaIcone).getAttribute("class"));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals(properties.getProperties().getProperty("pedido.status.pagamento"), driver.findElement(css.legendaIcone).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals(properties.getProperties().getProperty("pedido.id"), driver.findElement(css.primeiraColunaLink).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals(properties.getProperties().getProperty("pedido.cliente"), driver.findElement(css.segundaColunaLink).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals(properties.getProperties().getProperty("pedido.data.compra"), driver.findElement(css.terceiraColunaSpam).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals(properties.getProperties().getProperty("pedido.valor"), driver.findElement(css.quartaColuna).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
	}	

	public void validaQuantidadePedidos(String status) throws Exception{
		properties.lerArquivo();
		Thread.sleep(5000);
		switch (status){
		case "realizado" : 		
			try {
				assertEquals(properties.getProperties().getProperty("pedido.realizado"), driver.findElement(By.cssSelector("span.label.yellow-bg")).getText()); break;
			} catch (Error e) {
				verificationErrors.append(e.toString());
			}
		case "aprovado" :
			try {
				assertEquals(properties.getProperties().getProperty("pedido.aprovado"), driver.findElement(By.cssSelector("span.label.label-primary")).getText()); break;
			} catch (Error e) {
				verificationErrors.append(e.toString());
			}
		case "cancelado" :
			try {
				assertEquals(properties.getProperties().getProperty("pedido.cancelado"), driver.findElement(By.cssSelector("div > span.label.label-danger.ng-binding")).getText()); break;
			} catch (Error e) {
				verificationErrors.append(e.toString());
			}
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
