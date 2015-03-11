package com.ciandt.selenium.redenatura.pages;

import static org.junit.Assert.*;

import java.io.IOException;






import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.ciandt.selenium.redenatura.helpers.CssSelectors;
import com.ciandt.selenium.redenatura.helpers.DataDriven;
import com.ciandt.selenium.redenatura.helpers.Geral;
import com.ciandt.selenium.redenatura.painelAdmin.TestBase;

public class CupomPage extends TestBase{
	public StringBuffer verificationErrors = new StringBuffer();
	public String palavraSecreta;
	CssSelectors css = new CssSelectors();
	Geral geral = new Geral();
	DataDriven properties = new DataDriven();


	public void selecionarMenu() throws Exception{
		driver.findElement(css.menuPedidos).click();
		Thread.sleep(2000);
		driver.findElement(css.segundoSubmenu).click();		
	}

	public void verificaUrl() throws IOException{
		properties.lerArquivo();
		String previousURL = driver.getCurrentUrl();
		try {
			assertEquals(properties.getProperties().getProperty("url") + "/#/cupons-desconto", previousURL);
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
	}

	public void clicarVejaSugestao() throws Exception{
		Thread.sleep(2000);
		driver.findElement(By.linkText("Veja sugestão")).click();
		Thread.sleep(5000);
		try {
			assertFalse((driver.findElement(By.id("secret-word")).getAttribute("value")).isEmpty());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}		
	}

	public String criarCupom() throws Exception{
		Thread.sleep(2000);
		driver.findElement(By.linkText("Veja sugestão")).click();
		Thread.sleep(5000);
		palavraSecreta = driver.findElement(By.id("secret-word")).getAttribute("value");
		driver.findElement(By.name("account")).click();
		new Select(driver.findElement(By.name("account"))).selectByVisibleText("12%");
		WebElement scroll = driver.findElement(By.cssSelector("rn-coupon-maker > div > div > div > div > h2"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scroll);
		Thread.sleep(500); 
		driver.findElement(By.name("useLimit")).clear();
		driver.findElement(By.name("useLimit")).sendKeys("2");
		driver.findElement(By.id("btn-gerar-cupom")).click();
		Thread.sleep(2000);
		assertEquals("Cupom criado com sucesso.", driver.findElement(By.cssSelector("div.modal-body > h2.ng-binding")).getText());
		driver.findElement(By.xpath("//button[@type='button']")).click();	
		return palavraSecreta;
	}

	public void verificarCupomCriado() throws Exception{
		WebElement scroll2 = driver.findElement(By.cssSelector("div.cupons-utilizados > div > div > div > div.cupons-ativos > h2"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scroll2);
		Thread.sleep(500);

		WebElement baseTable = driver.findElement(By.cssSelector("div#DataTables_Table_0_wrapper"));
		List<WebElement> tableRows = baseTable.findElements(By.className("ngCell"));
		List<WebElement> cellRows = tableRows.get(0).findElements(By.className("ngCellText"));
		for (int x=0; x < cellRows.size(); x++){
			if  (palavraSecreta.equals(cellRows.get(x).getText())) {
				break;				 
			}
		}
	}

	public void encerrarCupom() throws Exception{
		WebElement scroll2 = driver.findElement(By.cssSelector("div.cupons-utilizados > div > div > div > div.cupons-ativos > h2"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scroll2);
		Thread.sleep(500);
		
		WebElement baseTable = driver.findElement(By.cssSelector("div#DataTables_Table_0_wrapper"));
		List<WebElement> tableRows = baseTable.findElements(By.className("ngCell"));
		List<WebElement> cellRows = tableRows.get(5).findElements(By.className("ngCellText"));
		for (int x=0; x < cellRows.size(); x++){
			cellRows.get(x).findElement(By.tagName("a")).click();
			assertEquals("Cupom cancelado com sucesso.", driver.findElement(By.cssSelector("div.modal-body > h2.ng-binding")).getText());
			driver.findElement(By.xpath("//button[@type='button']")).click();
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scroll2);
			Thread.sleep(500);
		}
	}

}
