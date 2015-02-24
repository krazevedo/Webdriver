package com.ciandt.selenium.redenatura.pages;

import static org.junit.Assert.assertEquals;

import com.ciandt.selenium.redenatura.helpers.CssSelectors;
import com.ciandt.selenium.redenatura.painelAdmin.TestBase;

public class AjudaPage extends TestBase{
	
	public StringBuffer verificationErrors = new StringBuffer();
	CssSelectors css = new CssSelectors();
	
	public void selecionarMenu() throws Exception{
		driver.findElement(css.menuAjuda).click();
	}
	
	public void verificarAbas() throws Exception{
		Thread.sleep(1000);
		try {
			assertEquals("A Rede Natura", driver.findElement(css.aba1).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals("Condições comerciais Rede Natura", driver.findElement(css.aba2).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals("Lucro", driver.findElement(css.aba3).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals("Compras dos meus clientes", driver.findElement(css.aba4).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals("Natura+Moda+Casa", driver.findElement(css.aba5).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals("Ferramentas de vendas", driver.findElement(css.aba6).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
	}
	
	public void verificarPerguntasAba1() throws Exception{
		driver.findElement(css.aba1).click();
		Thread.sleep(1000);
		try {
			assertEquals("O que é a Rede Natura?", driver.findElement(css.pergunta1Aba1).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals("O que é ser um Consultor Natura Digital?", driver.findElement(css.pergunta2Aba1).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals("Ao me tornar um Consultor Natura Digital, também poderei vender pela Revista Natura?", driver.findElement(css.pergunta3Aba1).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals("O que é o Natura+moda+casa?", driver.findElement(css.pergunta4Aba1).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}		 
	}
	
	public void verificarPerguntasAba2() throws Exception{
		driver.findElement(css.aba2).click();
		Thread.sleep(1000);
		try {
			assertEquals("Quanto custa para ter um Espaço na Rede Natura?", driver.findElement(css.pergunta1Aba2).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals("Como faço para manter meu Espaço na Rede Natura funcionando?", driver.findElement(css.pergunta2Aba2).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals("Quais os pré-requisitos para me cadastrar para ser um Consultor Natura Digital?", driver.findElement(css.pergunta3Aba2).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals("Como faço para me tornar um Consultor Natura Digital?", driver.findElement(css.pergunta4Aba2).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals("Por que preciso cadastrar uma conta bancária? O que é o MOIP?", driver.findElement(css.pergunta5Aba2).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals("Por que preciso cadastrar um cartão de crédito no MOIP?", driver.findElement(css.pergunta6Aba2).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals("Como faço para manter meu Espaço sem pagar mensalidade?", driver.findElement(css.pergunta7Aba2).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}		
		try {
			assertEquals("Desejo cancelar minha assinatura da Rede Natura e encerrar meu Espaço", driver.findElement(css.pergunta8Aba2).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}		
	}
	
	public void verificarPerguntasAba3() throws Exception{
		driver.findElement(css.aba3).click();
		Thread.sleep(1000);
		try {
			assertEquals("Qual o valor do meu lucro nas vendas realizadas no meu Espaço na internet?", driver.findElement(css.pergunta1Aba3).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals("Qual o valor das taxas sobre minhas vendas online?", driver.findElement(css.pergunta2Aba3).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals("Como vou receber o lucro das minhas vendas na internet?", driver.findElement(css.pergunta3Aba3).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals("Além do lucro proveniente das vendas em meu Espaço, posso ganhar algo a mais?", driver.findElement(css.pergunta4Aba3).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
	}
	
	public void verificarPerguntasAba4() throws Exception{
		driver.findElement(css.aba4).click();
		Thread.sleep(1000);
		try {
			assertEquals("Existe um valor mínimo para meu cliente comprar no meu Espaço Natura na internet? Como ele pode pagar?", driver.findElement(css.pergunta1Aba4).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals("Quem paga o frete da compra no Espaço do(a) Consultor(a)?", driver.findElement(css.pergunta2Aba4).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals("Como será feita a entrega dos produtos comprados pelos meus clientes no meu Espaço do(a) Consultor(a)? Qual o prazo de entrega?", driver.findElement(css.pergunta3Aba4).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals("O preço anunciado no meu Espaço na Rede Natura é o mesmo anunciado na Revista Natura? As promoções também são as mesmas?", driver.findElement(css.pergunta4Aba4).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
	}
	
	public void verificarPerguntasAba5() throws Exception{
		driver.findElement(css.aba5).click();
		Thread.sleep(1000);
		try {
			assertEquals("Os produtos comercializados pelo Natura+ serão fabricados pela Natura?", driver.findElement(css.pergunta1Aba5).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals("Quem são os Parceiros do Natura+?", driver.findElement(css.pergunta2Aba5).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals("Os produtos Natura+moda+casa poderão sofrer mudanças no decorrer do projeto?", driver.findElement(css.pergunta3Aba5).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}		
	}
	
	public void verificarPerguntasAba6() throws Exception{
		driver.findElement(css.aba6).click();
		Thread.sleep(1000);
		try {
			assertEquals("Como saberei quantos pedidos foram feitos e o que meus clientes compraram no meu Espaço na Rede Natura?", driver.findElement(css.pergunta1Aba6).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals("Posso dar desconto para meus clientes comprarem no meu Espaço da Rede Natura?", driver.findElement(css.pergunta2Aba6).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals("O que é o Cupom Desconto?", driver.findElement(css.pergunta3Aba6).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals("Como funciona o Cupom Desconto?", driver.findElement(css.pergunta4Aba6).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals("Criei um Cupom Desconto. Como divulgo para meus clientes?", driver.findElement(css.pergunta5Aba6).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals("Nas compras realizadas com Cupom Desconto como fica meu lucro?", driver.findElement(css.pergunta6Aba6).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals("Quais percentuais de desconto posso conceder? Posso criar mais de um Cupom Desconto?", driver.findElement(css.pergunta7Aba6).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals("A Natura também pode criar um Cupom Desconto para o meu Espaço na Rede Natura?", driver.findElement(css.pergunta8Aba6).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals("Como posso divulgar meu Espaço na Rede Natura?", driver.findElement(css.pergunta9Aba6).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals("Posso customizar meu Espaço na Rede Natura?", driver.findElement(css.pergunta10Aba6).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals("Existe algum tipo de Capacitação para a atividade de Consultoria Natura Digital, na Rede Natura?", driver.findElement(css.pergunta11Aba6).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals("Como faço para me tornar um Consultor Natura Digital Recomendado e aparecer com prioridade na busca por Consultores Rede Natura?", driver.findElement(css.pergunta12Aba6).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals("Existe algum canal de contato para dúvidas?", driver.findElement(css.pergunta13Aba6).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
	}	
}
