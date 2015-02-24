package com.ciandt.selenium.redenatura.pages;

import org.openqa.selenium.By;



import static org.junit.Assert.*;

import com.ciandt.selenium.redenatura.painelAdmin.TestBase;


public class ContagemPage extends TestBase{

	public void verificaPaginaContagem() throws Exception{
		Thread.sleep(5000);
		assertEquals("893771120", driver.findElement(By.cssSelector("div#cadastro-concluido > div > div > div > p > span.ng-binding")).getText());
		assertEquals("rede.natura.net/cc/asdjagsdisgaskd", driver.findElement(By.cssSelector("div#cadastro-concluido > div > div > div > div:nth-child(1) > div:nth-child(2) > p:nth-child(4) > a > span")).getText());
		assertEquals("0", driver.findElement(By.cssSelector("div#cadastro-concluido div div div div div div p span span.ng-binding")).getText());		
	}

}
