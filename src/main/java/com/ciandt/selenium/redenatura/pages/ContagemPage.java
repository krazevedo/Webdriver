package com.ciandt.selenium.redenatura.pages;

import org.openqa.selenium.By;




import static org.junit.Assert.*;

import com.ciandt.selenium.redenatura.painelAdmin.TestBase;


public class ContagemPage extends TestBase{
	public StringBuffer verificationErrors = new StringBuffer();

	public void verificaPaginaContagem() throws Exception{
		Thread.sleep(5000);		
		assertEquals("PARABÉNS!", driver.findElement(By.cssSelector("div#cadastro-concluido > div.modal-dialog.modal-lg > div.modal-content.sucesso > div.modal-header > h2")).getText());
		assertEquals("0", driver.findElement(By.cssSelector("div#cadastro-concluido div div div div div div p span span.ng-binding")).getText());		
	}

}
