package com.ciandt.selenium.redenatura.helpers;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.ciandt.selenium.redenatura.painelAdmin.TestBase;



public class ScreenshotRule extends TestWatcher{
	Geral geral = new Geral();
		
	protected void failed(Throwable e, Description description)
	{
		String nomeClasse = description.getTestClass().getSimpleName();
		String nomeTeste = description.getMethodName();

		try {
			tiraScreenshot(nomeClasse, nomeTeste);
		} catch (Throwable e1) {
			e1.printStackTrace();
		}		
		TestBase.getFirefoxDriver().quit();
	}

	public void tiraScreenshot(String nomeClasse, String nomeTeste) throws Throwable {
		TakesScreenshot takesScreenshot = (TakesScreenshot) TestBase.getFirefoxDriver();
		//Cria um diret�rio "screenshots" na raiz do projeto
		new File("screenshots/" + nomeClasse + "/" + nomeTeste + "/" + geral.pegarData() + "/").mkdirs();
		//Obt�m um screenshot
		File screenshot = takesScreenshot.getScreenshotAs(OutputType.FILE);
		//Cria um arquivo dentro do diret�rio "screenshots", contendo
		//o nome da classe/m�todo de teste
		//Exemplo: "IncluirUsuarioTest-incluirComSucesso-screenshot.png"
		FileUtils.copyFile(screenshot, new File("screenshots/" + nomeClasse + "/" + nomeTeste + "/" + geral.pegarData() + "/" + geral.pegarHora() +"-screenshot.png"));			
	}		
}


