package com.ciandt.selenium.redenatura.pages;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;

import com.ciandt.selenium.redenatura.helpers.CssSelectors;
import com.ciandt.selenium.redenatura.helpers.DataDriven;
import com.ciandt.selenium.redenatura.painelAdmin.TestBase;


public class VisitasPage extends TestBase{

	public StringBuffer verificationErrors = new StringBuffer();
	CssSelectors css = new CssSelectors();
	DataDriven properties = new DataDriven();
	public String valorGrid;

	public void selecionarMenu() throws Exception{
		driver.findElement(css.menuVisitas).click();
		Thread.sleep(2000);
		driver.findElement(css.primeiroSubmenu).click();		
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
			assertEquals(properties.getProperties().getProperty("visitas.total.visitas"), driver.findElement(By.cssSelector("div#mainDiv > rn-visit-info > div > div:nth-child(1) > div > div:nth-child(2) > div > h2")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals(properties.getProperties().getProperty("visitas.total.visitantes"), driver.findElement(By.cssSelector("div#mainDiv > rn-visit-info > div > div:nth-child(2) > div > div:nth-child(2) > div > h2")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals(properties.getProperties().getProperty("visitas.total.pedidos"), driver.findElement(By.cssSelector("div#mainDiv > rn-visit-info > div > div:nth-child(3) > div > div:nth-child(2) > div > h2")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals(properties.getProperties().getProperty("visitas.taxa.conversao"), driver.findElement(By.cssSelector("div#mainDiv > rn-visit-info > div > div:nth-child(4) > div > div:nth-child(2) > div > h2")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
	}
}
