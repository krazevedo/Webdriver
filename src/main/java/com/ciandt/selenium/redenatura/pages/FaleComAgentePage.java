package com.ciandt.selenium.redenatura.pages;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
		WebElement select = driver.findElement(By.tagName("select"));
		List<WebElement> allOptions = select.findElements(By.tagName("option"));
		for (WebElement option : allOptions) {
			if("1".equals(option.getAttribute("value"))){
		        option.click();
		    }
		}
		driver.findElement(By.name("message")).click();
		driver.findElement(By.name("message")).clear();
		driver.findElement(By.name("message")).sendKeys("teste");
	}

	public void enviarMensagem() throws Exception{
		driver.findElement(By.cssSelector("rn-contact-us > form > div > div:nth-child(7) > button")).click();				
	}

	public void validarMensagem() throws Exception{
		Thread.sleep(3000);
	    assertEquals("Obrigado por sua mensagem!", driver.findElement(By.cssSelector("div#modal-mensagens > div:nth-child(2) > div > div.modal-body > span")).getText());
	    driver.findElement(By.xpath("//button[@type='button']")).click();
	}
	
	public void validarMensagemCampoObrigatorio() throws Exception{
		Thread.sleep(2000);
		assertEquals("Informe o assunto.", driver.findElement(By.cssSelector("div:nth-child(5) > div.col-sm-12 > div.form-group > div.validation-hint-my-personal-form.arrow_box > span.ng-scope")).getText());
	    assertEquals("Escreva a mensagem.", driver.findElement(By.cssSelector("div:nth-child(6) > div.col-sm-12 > div.form-group > div.validation-hint-my-personal-form.arrow_box > span:nth-child(1).ng-scope")).getText());
	}
	
}
