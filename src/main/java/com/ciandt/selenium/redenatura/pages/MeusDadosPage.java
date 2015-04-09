package com.ciandt.selenium.redenatura.pages;

import static org.junit.Assert.*;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.ciandt.selenium.redenatura.helpers.CssSelectors;
import com.ciandt.selenium.redenatura.helpers.DataDriven;
import com.ciandt.selenium.redenatura.painelAdmin.TestBase;


public class MeusDadosPage extends TestBase{

	public StringBuffer verificationErrors = new StringBuffer();
	CssSelectors css = new CssSelectors();
	DataDriven properties = new DataDriven();

	public void selecionarMenu() throws Exception{
		Thread.sleep(5000);
		driver.findElement(css.menuConfiguracoes).click();
		Thread.sleep(2000);
		driver.findElement(css.primeiroSubmenuConf).click();		
	}


	public void validaDadosFormulario() throws Exception{
		properties.lerArquivo();
		Thread.sleep(2000);
		try {
			assertEquals(properties.getProperties().getProperty("login.active"), driver.findElement(By.xpath("//input[@type='email']")).getAttribute("value"));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals(properties.getProperties().getProperty("dados.telefone"), driver.findElement(By.name("phone")).getAttribute("value"));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals(properties.getProperties().getProperty("dados.cep"), driver.findElement(By.name("cep")).getAttribute("value"));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals(properties.getProperties().getProperty("dados.logradouro"), driver.findElement(By.name("street")).getAttribute("value"));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals(properties.getProperties().getProperty("dados.numero"), driver.findElement(By.name("streetNumber")).getAttribute("value"));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals(properties.getProperties().getProperty("dados.bairro"), driver.findElement(By.name("neighborhood")).getAttribute("value"));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals(properties.getProperties().getProperty("dados.consultora"), driver.findElement(By.name("name")).getAttribute("value"));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals(properties.getProperties().getProperty("dados.rg"), driver.findElement(By.name("rg")).getAttribute("value"));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals(properties.getProperties().getProperty("dados.nascimento"), driver.findElement(By.name("birthdate")).getAttribute("value"));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertTrue(driver.findElement(By.id("optionsRadios2")).isSelected());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals(properties.getProperties().getProperty("dados.cidade"), driver.findElement(By.name("city")).getAttribute("value"));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			Select archiveList = new Select(driver.findElement(By.name("state")));
			assertEquals(properties.getProperties().getProperty("dados.estado"), archiveList.getFirstSelectedOption().getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
	}

	public void validaMeta() throws Exception{
		properties.lerArquivo();
		try {
			assertEquals(properties.getProperties().getProperty("dados.meta"), driver.findElement(By.cssSelector("div:nth-child(2) > div > span.pull-right")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
	}	
	
	public void abrirFormulario() throws Exception{
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("div > div:nth-child(4) > div > span > a")).click();
	}
	
	public void informarValoresCartao() throws Exception{
		properties.lerArquivo();		
		driver.findElement(By.name("cardNumber")).click();
		driver.findElement(By.name("cardNumber")).sendKeys("");
		driver.findElement(By.name("cardNumber")).sendKeys("4716919155701731");
	    driver.findElement(By.name("cardName")).clear();
	    driver.findElement(By.name("cardName")).sendKeys("CIT TESTE");
	    WebElement select = driver.findElement(By.cssSelector("form#RNUpdateCreditcard > div > div.combo-my-personal > select"));
		List<WebElement> months = select.findElements(By.tagName("option"));
		for (WebElement option : months) {
			if("12".equals(option.getAttribute("value"))){
		        option.click();
		        break;
		    }
		}
		
		WebElement select2 = driver.findElement(By.cssSelector("form#RNUpdateCreditcard > div > div.combo-my-personal-var > select"));
		List<WebElement> years = select2.findElements(By.tagName("option"));
		for (WebElement option : years) {
			if("21".equals(option.getAttribute("value"))){
		        option.click();
		        break;
		    }
		}	    
	}	
	
	public void submeterFormulario(){
		driver.findElement(By.cssSelector("form#RNUpdateCreditcard > div:nth-child(3) > div > button")).submit();		
	}
	
	public void validarCamposObrigatorios(){
	    assertEquals("Campo obrigatório", driver.findElement(By.cssSelector("form#RNUpdateCreditcard > div:nth-child(2) > div.validation-hint-bottom > span:nth-child(1)")).getText());
	    assertEquals("Campo obrigatório", driver.findElement(By.cssSelector("form#RNUpdateCreditcard > div:nth-child(2) > div.validation-hint > span:nth-child(1)")).getText());

	}
	
	public void validarAlteracaoComSucesso(){
		
	}
	
}
