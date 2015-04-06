package com.ciandt.selenium.redenatura.pages;

import static org.junit.Assert.*;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.ciandt.selenium.redenatura.helpers.GeradorDeNome;
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
	GeradorDeNome nome = new GeradorDeNome();


	public void selecionarMenu() throws Exception{
		driver.findElement(css.menuPedidos).click();
		Thread.sleep(2000);
		driver.findElement(css.segundoSubmenu).click();		
	}

	public void verificaUrl() throws Exception{
		Thread.sleep(5000);
		properties.lerArquivo();
		String previousURL = driver.getCurrentUrl();
		try {
			assertEquals(properties.getProperties().getProperty("url") + "#/cupons-desconto", previousURL);
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
	}

	public void clicarVejaSugestao() throws Exception{
		Thread.sleep(2000);
		driver.findElement(By.linkText("Veja sugestão")).click();
		Thread.sleep(10000);
		try {
			assertFalse((driver.findElement(By.id("secret-word")).getAttribute("value")).isEmpty());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}		
	}

	public String criarCupom() throws Exception{
		properties.lerArquivo();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Veja sugestão")).click();
		Thread.sleep(5000);
		palavraSecreta = driver.findElement(By.id("secret-word")).getAttribute("value") + nome.gerarNome();
		driver.findElement(By.id("secret-word")).clear();
		driver.findElement(By.id("secret-word")).sendKeys(palavraSecreta);
		driver.findElement(By.name("account")).click();
		new Select(driver.findElement(By.name("account"))).selectByVisibleText(properties.getProperties().getProperty("cupom.promocao"));
		WebElement scroll = driver.findElement(By.cssSelector("rn-coupon-maker > div > div > div > div > h2"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scroll);
		Thread.sleep(500); 
		driver.findElement(By.name("useLimit")).clear();
		driver.findElement(By.name("useLimit")).sendKeys(properties.getProperties().getProperty("cupom.limite"));
		driver.findElement(By.id("btn-gerar-cupom")).click();
		Thread.sleep(10000);
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
		for (int x=0; x < tableRows.size(); x = x + 6){
			List<WebElement> cellRows = tableRows.get(x).findElements(By.className("ngCellText"));
			if  (palavraSecreta.equals(cellRows.get(0).getText())) {
				break;				 
			}		
		}
	}

	public void encerrarCupom() throws Exception{
		Thread.sleep(2000);
		WebElement scroll2 = driver.findElement(By.cssSelector("div.cupons-utilizados > div > div > div > div.cupons-ativos > h2"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scroll2);
		Thread.sleep(500);
		for (int x=0; x < 3; x++){
			WebElement baseTable = driver.findElement(By.cssSelector("div#DataTables_Table_0_wrapper"));
			List<WebElement> tableRows = baseTable.findElements(By.className("ngCell"));
			if (tableRows.size() == 0){
				x = x + 3;
				break;
			}
			List<WebElement> cellRows = tableRows.get(5).findElements(By.className("ngCellText"));
			cellRows.get(0).findElement(By.tagName("a")).click();
			Thread.sleep(10000);
			assertEquals("Cupom cancelado com sucesso.", driver.findElement(By.cssSelector("div.modal-body > h2.ng-binding")).getText());
			driver.findElement(By.xpath("//button[@type='button']")).click();			
		}
	}	
	public void criarVariosCupons() throws Exception{
		properties.lerArquivo();
		for (int x=0; x <= 3; x++){
			Thread.sleep(2000);
			driver.findElement(By.linkText("Veja sugestão")).click();
			Thread.sleep(5000);
			driver.findElement(By.id("secret-word")).sendKeys(nome.gerarNome());
			palavraSecreta = driver.findElement(By.id("secret-word")).getAttribute("value");			
			driver.findElement(By.name("account")).click();
			new Select(driver.findElement(By.name("account"))).selectByVisibleText(properties.getProperties().getProperty("cupom.promocao"));
			WebElement scroll = driver.findElement(By.cssSelector("rn-coupon-maker > div > div > div > div > h2"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scroll);
			Thread.sleep(500); 
			driver.findElement(By.name("useLimit")).clear();
			driver.findElement(By.name("useLimit")).sendKeys(properties.getProperties().getProperty("cupom.limite"));
			driver.findElement(By.id("btn-gerar-cupom")).click();
			Thread.sleep(10000);
			if (x == 3){
				assertEquals("Você já criou o limite máximo de palavras secretas disponíveis. Você só poderá criar novas palavras quando as existentes já tiverem expirado.", driver.findElement(By.cssSelector("div.modal-body > h2.ng-binding")).getText());
				driver.findElement(By.xpath("//button[@type='button']")).click();
				break;
			}
			assertEquals("Cupom criado com sucesso.", driver.findElement(By.cssSelector("div.modal-body > h2.ng-binding")).getText());
			driver.findElement(By.xpath("//button[@type='button']")).click();
		}
	}	

	public void criarCupomBlackList(String palavraSecreta) throws Exception{
		properties.lerArquivo();
		Thread.sleep(2000);		
		driver.findElement(By.id("secret-word")).clear();
		driver.findElement(By.id("secret-word")).sendKeys(palavraSecreta);
		driver.findElement(By.name("account")).click();
		new Select(driver.findElement(By.name("account"))).selectByVisibleText(properties.getProperties().getProperty("cupom.promocao"));
		WebElement scroll = driver.findElement(By.cssSelector("rn-coupon-maker > div > div > div > div > h2"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scroll);
		Thread.sleep(500); 
		driver.findElement(By.name("useLimit")).clear();
		driver.findElement(By.name("useLimit")).sendKeys(properties.getProperties().getProperty("cupom.limite"));
		driver.findElement(By.id("btn-gerar-cupom")).click();
		Thread.sleep(10000);
		assertEquals("A palavra secreta não esta disponível.", driver.findElement(By.cssSelector("div.modal-body > h2.ng-binding")).getText());
		driver.findElement(By.xpath("//button[@type='button']")).click();			
	}
}
