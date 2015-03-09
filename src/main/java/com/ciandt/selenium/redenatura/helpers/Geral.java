package com.ciandt.selenium.redenatura.helpers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ciandt.selenium.redenatura.helpers.DataDriven;

public class Geral{
	DataDriven properties = new DataDriven();	
	CssSelectors css = new CssSelectors();

	public void abrir(WebDriver driver) throws IOException{
		properties.lerArquivo();
		driver.get(properties.getProperties().getProperty("url"));	
	}
		
	public void realizarBusca(WebDriver driver, String pesquisa) throws Exception{
		driver.findElement(css.campoTexto).clear();
		driver.findElement(css.campoTexto).sendKeys(pesquisa);		
		Thread.sleep(4000);
	}
	
	public String pegarData(){
		Date date = new Date() ;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String data = dateFormat.format(date);
		return data;
	}
	
	public String pegarHora(){
		Date date = new Date() ;
		SimpleDateFormat dateFormatHr = new SimpleDateFormat("HH-mm-ss");
		String dataHora = dateFormatHr.format(date);
		return dataHora;
	}
	
	public void selecionarSemana(WebDriver driver, String mes, Integer semana){
		driver.findElement(By.cssSelector("div:nth-child(1) > rn-weekly-calendar > div > div > input")).click();

		for (int i=0; i < 12; i++){
			String mesAno = driver.findElement(By.cssSelector("div.datepicker-days > table > thead > tr > th.datepicker-switch")).getText();
			if (mes.equals(mesAno)) {				
				List<WebElement> table = driver.findElements(By.cssSelector("div.datepicker-days > table > tbody > tr"));
				table.get(semana).click();
				driver.findElement(By.cssSelector("button#btn-ok-datepicker")).click();
				break;
			} else {
				driver.findElement(By.cssSelector("div.datepicker-days > table > thead > tr > th.prev")).click();
			}
		}
	}
}
