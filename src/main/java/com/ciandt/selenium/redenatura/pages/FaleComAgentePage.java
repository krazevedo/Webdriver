package com.ciandt.selenium.redenatura.pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.ciandt.selenium.redenatura.helpers.CssSelectors;
import com.ciandt.selenium.redenatura.helpers.DataDriven;
import com.ciandt.selenium.redenatura.painelAdmin.TestBase;

public class FaleComAgentePage extends TestBase{
	public StringBuffer verificationErrors = new StringBuffer();
	CssSelectors css = new CssSelectors();
	DataDriven properties = new DataDriven();

	public void selecionarMenu() throws Exception{
		driver.findElement(css.menuFale).click();
		Thread.sleep(2000);
	}	

	public void preencherMensagem() throws Exception{
		properties.lerArquivo();
		driver.findElement(By.name("type")).click();
		new Select(driver.findElement(By.name("type"))).selectByVisibleText("Sugestao");
	    driver.findElement(By.cssSelector("option[value=\"1\"]")).click();
		driver.findElement(By.name("message")).click();
		driver.findElement(By.name("message")).clear();
		driver.findElement(By.name("message")).sendKeys("teste");
	}

	public void enviarMensagem() throws Exception{
		driver.findElement(By.cssSelector("rn-contact-us > form > div > div:nth-child(7) > button")).click();				
	}

	public void validarMensagem() throws Exception{
		Thread.sleep(2000);
		assertEquals("Mensagem enviada com sucesso", driver.findElement(By.cssSelector("h2.ng-binding")).getText());
	    driver.findElement(By.xpath("//button[@type='button']")).click();
	}
	
	public void validarMensagemCampoObrigatorio() throws Exception{
		Thread.sleep(2000);
		assertEquals("Informe o assunto.", driver.findElement(By.cssSelector("div:nth-child(5) > div.col-sm-12 > div.form-group > div.validation-hint-my-personal-form.arrow_box > span.ng-scope")).getText());
	    assertEquals("Escreva a mensagem.", driver.findElement(By.cssSelector("div:nth-child(6) > div.col-sm-12 > div.form-group > div.validation-hint-my-personal-form.arrow_box > span:nth-child(1).ng-scope")).getText());
	}
	
}
