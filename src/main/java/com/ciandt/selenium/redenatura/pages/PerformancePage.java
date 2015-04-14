package com.ciandt.selenium.redenatura.pages;

import static org.junit.Assert.assertEquals;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ciandt.selenium.redenatura.helpers.CssSelectors;
import com.ciandt.selenium.redenatura.helpers.DataDriven;
import com.ciandt.selenium.redenatura.helpers.Geral;
import com.ciandt.selenium.redenatura.painelAdmin.TestBase;


public class PerformancePage extends TestBase{

	public StringBuffer verificationErrors = new StringBuffer();
	CssSelectors css = new CssSelectors();
	DataDriven properties = new DataDriven();
	public String valorGrid;
	public long timeStart;
	private long timeEnd;
	Geral geral = new Geral();


	public void logar(String user, String pass){
		driver.findElement(By.cssSelector("form > div:nth-child(1) > div:nth-child(1) > div > input")).clear();
		driver.findElement(By.cssSelector("form > div:nth-child(1) > div:nth-child(1) > div > input")).sendKeys(user);
		driver.findElement(By.cssSelector("form > div:nth-child(1) > div:nth-child(2) > div > input")).clear();
		driver.findElement(By.cssSelector("form > div:nth-child(1) > div:nth-child(2) > div > input")).sendKeys(pass);
		driver.findElement(By.cssSelector("button#okButton")).click();		
	}

	public void tempoLogin(){
		timeStart = System.currentTimeMillis();
		String timeStampStart = new SimpleDateFormat("dd/MM/yyyy_HH:mm:ss").format(Calendar.getInstance().getTime());
		System.out.println("Clique no login: " + timeStampStart);
	}

	public void tempoHome(){
		driver.findElement(By.cssSelector("#side-menu > li:nth-child(2) > a > span")).click();
		timeStart = System.currentTimeMillis();
		String timeStampStart = new SimpleDateFormat("dd/MM/yyyy_HH:mm:ss").format(Calendar.getInstance().getTime());
		System.out.println("Acessando a home: " + timeStampStart);

	}

	public void realizarBusca(WebDriver driver, String pesquisa) throws Exception{
		driver.findElement(css.campoTexto).clear();
		driver.findElement(css.campoTexto).sendKeys(pesquisa);		
		Thread.sleep(4000);
	}

	public void selecionarMenuClientes() throws Exception{
		driver.findElement(css.menuVisitas).click();
		Thread.sleep(2000);
		driver.findElement(css.segundoSubmenu).click();		
		timeStart = System.currentTimeMillis();
		String timeStampStart = new SimpleDateFormat("dd/MM/yyyy_HH:mm:ss").format(Calendar.getInstance().getTime());
		System.out.println("Clique no menu: " + timeStampStart);
	}

	public void selecionarMenuOferecaDeNovo() throws Exception{
		driver.findElement(css.menuLealdade).click();
		Thread.sleep(2000);
		driver.findElement(css.primeiroSubmenu).click();		
		timeStart = System.currentTimeMillis();
		String timeStampStart = new SimpleDateFormat("dd/MM/yyyy_HH:mm:ss").format(Calendar.getInstance().getTime());
		System.out.println("Clique no menu: " + timeStampStart);
	}

	public void selecionarMenuOferecaTambem() throws Exception{
		driver.findElement(css.menuLealdade).click();
		Thread.sleep(2000);
		driver.findElement(css.segundoSubmenu).click();		
		timeStart = System.currentTimeMillis();
		String timeStampStart = new SimpleDateFormat("dd/MM/yyyy_HH:mm:ss").format(Calendar.getInstance().getTime());
		System.out.println("Clique no menu: " + timeStampStart);
	}

	public void selecionarMenuAniversariante() throws Exception{
		driver.findElement(css.menuLealdade).click();
		Thread.sleep(2000);
		driver.findElement(css.terceiroSubmenu).click();		
		timeStart = System.currentTimeMillis();
		String timeStampStart = new SimpleDateFormat("dd/MM/yyyy_HH:mm:ss").format(Calendar.getInstance().getTime());
		System.out.println("Clique no menu: " + timeStampStart);
	}

	public void clicarVerPerfil(){
		driver.findElement(By.linkText("ver perfil")).click();
		timeStart = System.currentTimeMillis();
		String timeStampStart = new SimpleDateFormat("dd/MM/yyyy_HH:mm:ss").format(Calendar.getInstance().getTime());
		System.out.println("Clique no link: " + timeStampStart);
	}

	public void selecionarMenuPedidos() throws Exception{
		driver.findElement(css.menuPedidos).click();
		Thread.sleep(2000);
		driver.findElement(css.primeiroSubmenu).click();		
		timeStart = System.currentTimeMillis();
		String timeStampStart = new SimpleDateFormat("dd/MM/yyyy_HH:mm:ss").format(Calendar.getInstance().getTime());
		System.out.println("Clique no menu: " + timeStampStart);
	}

	public void selecionarMenuSacolas() throws Exception{
		driver.findElement(css.menuPedidos).click();
		Thread.sleep(2000);
		driver.findElement(css.terceiroSubmenu).click();		
		timeStart = System.currentTimeMillis();
		String timeStampStart = new SimpleDateFormat("dd/MM/yyyy_HH:mm:ss").format(Calendar.getInstance().getTime());
		System.out.println("Clique no menu: " + timeStampStart);
	}

	public void selecionarSemana(WebDriver driver, String mes, String s) throws Exception{
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("div:nth-child(1) > rn-weekly-calendar > div > div > input")).click();
		int semana = Integer.parseInt(s);
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
		timeStart = System.currentTimeMillis();
		String timeStampStart = new SimpleDateFormat("dd/MM/yyyy_HH:mm:ss").format(Calendar.getInstance().getTime());
		System.out.println("Clique no OK: " + timeStampStart);
	}

	public void selecionaPedido(){
		driver.findElement(css.primeiraColunaLink).click();	
		timeStart = System.currentTimeMillis();
		String timeStampStart = new SimpleDateFormat("dd/MM/yyyy_HH:mm:ss").format(Calendar.getInstance().getTime());
		System.out.println("Clique no link: " + timeStampStart);
	}

	public void esperarCarregamentoLogin(){
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul#side-menu > li.nav-header > div.dropdown.profile-element > a > span > span.block.m-t-xs > strong")));
		timeEnd = System.currentTimeMillis();
		String timeStampEnd = new SimpleDateFormat("dd/MM/yyyy_HH:mm:ss").format(Calendar.getInstance().getTime());
		System.out.println("Resposta na tela: " + timeStampEnd);
	}

	public void esperarCarregamento(){
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(css.visitas));
		}

	public void esperarCarregamentoHome(){
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(css.visitas));
		timeEnd = System.currentTimeMillis();
		String timeStampEnd = new SimpleDateFormat("dd/MM/yyyy_HH:mm:ss").format(Calendar.getInstance().getTime());
		System.out.println("Resposta na tela: " + timeStampEnd);
	}
	
	public void esperarCarregamentoClientes(){
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(css.primeiraColunaLink));
		timeEnd = System.currentTimeMillis();
		String timeStampEnd = new SimpleDateFormat("dd/MM/yyyy_HH:mm:ss").format(Calendar.getInstance().getTime());
		System.out.println("Resposta na tela: " + timeStampEnd);
	}

	public void esperarCarregamentoDetalheCliente(){
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div > div > rn-order-detail-box > div:nth-child(2) > div > dl > dd:nth-child(6) > a")));
		timeEnd = System.currentTimeMillis();
		String timeStampEnd = new SimpleDateFormat("dd/MM/yyyy_HH:mm:ss").format(Calendar.getInstance().getTime());
		System.out.println("Resposta na tela: " + timeStampEnd);
	}

	public void esperarCarregamentoPedido(){
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(css.primeiraColunaLink));
		timeEnd = System.currentTimeMillis();
		String timeStampEnd = new SimpleDateFormat("dd/MM/yyyy_HH:mm:ss").format(Calendar.getInstance().getTime());
		System.out.println("Resposta na tela: " + timeStampEnd);
	}

	public void esperarCarregamentoDetalhePedido(){
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div > rn-order-detail-box > div:nth-child(2) > div > dl > dt:nth-child(5)")));
		timeEnd = System.currentTimeMillis();
		String timeStampEnd = new SimpleDateFormat("dd/MM/yyyy_HH:mm:ss").format(Calendar.getInstance().getTime());
		System.out.println("Resposta na tela: " + timeStampEnd);
	}

	public void esperarCarregamentoSacolas(){
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div > div.col-md-6 > div > div.row > div.col-xs-10 > span")));
		timeEnd = System.currentTimeMillis();
		String timeStampEnd = new SimpleDateFormat("dd/MM/yyyy_HH:mm:ss").format(Calendar.getInstance().getTime());
		System.out.println("Resposta na tela: " + timeStampEnd);
	}

	public void esperarCarregamentoOferecaDeNovo(){
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#recompra > div > div:nth-child(1) > div > ol > li:nth-child(1) > h2 > span")));
		timeEnd = System.currentTimeMillis();
		String timeStampEnd = new SimpleDateFormat("dd/MM/yyyy_HH:mm:ss").format(Calendar.getInstance().getTime());
		System.out.println("Resposta na tela: " + timeStampEnd);
	}

	public void esperarCarregamentoOferecaTambem(){
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#sugestao > div > div:nth-child(1) > div > ol > li:nth-child(1) > h2 > span")));
		timeEnd = System.currentTimeMillis();
		String timeStampEnd = new SimpleDateFormat("dd/MM/yyyy_HH:mm:ss").format(Calendar.getInstance().getTime());
		System.out.println("Resposta na tela: " + timeStampEnd);
	}

	public void esperarCarregamentoAniversariante(){
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div:nth-child(3) > a > div.green-dark2-bg-natura > div > div.col-xs-9 > h3")));
		timeEnd = System.currentTimeMillis();
		String timeStampEnd = new SimpleDateFormat("dd/MM/yyyy_HH:mm:ss").format(Calendar.getInstance().getTime());
		System.out.println("Resposta na tela: " + timeStampEnd);
	}

	public void tempoCarregamento(String env){
		double seconds = (timeEnd-timeStart)/1000.0;
		System.out.println((env + " - " + "Time elapsed: "+new DecimalFormat("0.000").format(seconds)+" sec\n"));
	}

}
