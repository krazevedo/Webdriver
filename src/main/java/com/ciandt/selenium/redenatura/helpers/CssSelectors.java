package com.ciandt.selenium.redenatura.helpers;

import org.openqa.selenium.By;

public class CssSelectors {
	  //Menu
	  public By menuVisitas = By.cssSelector("ul#side-menu > li > a > span.fa.arrow");
	  public By menuPedidos = By.cssSelector("ul#side-menu > li:nth-child(4) > a > span.fa.arrow");
	  public By menuLealdade = By.cssSelector("ul#side-menu > li:nth-child(5) > a > span.fa.arrow");
	  public By menuAjuda = By.cssSelector("ul#side-menu > li:nth-child(11) > a > span");
	  public By primeiroSubmenu = By.cssSelector("ul#side-menu > li.active > ul > li:nth-child(1) > a");
	  public By segundoSubmenu = By.cssSelector("ul#side-menu > li.active > ul > li:nth-child(2) > a");
	  public By terceiroSubmenu = By.cssSelector("ul#side-menu > li.active > ul > li:nth-child(3) > a");
	  public By quartoSubmenu = By.cssSelector("ul#side-menu > li.active > ul > li:nth-child(4) > a");
	  
	  //Home
	  /// Box Pilares
	  public By visitas = By.cssSelector("div[class*='purple-dark2-bg-natura'] > div > div > h3");
	  public By valorVisitas = By.cssSelector("div[class*='purple-dark2-bg-natura'] > div > div > h2");
	  public By pedidos = By.cssSelector("div[class*='blue-dark-bg-natura'] > div > div > h3");
	  public By valorPedidos = By.cssSelector("div[class*='blue-dark-bg-natura'] > div > div > h2");
	  public By vendas = By.cssSelector("div[class*='green-dark2-bg-natura'] > div > div > h3");
	  public By valorVendas = By.cssSelector("div[class*='green-dark2-bg-natura'] > div > div > h2");
	  
	  /// Box Lucros
	  public By saldoDisponivel = By.cssSelector("div:nth-child(1) > div > div > p > span");
	  public By lucroPeriodo = By.cssSelector("div:nth-child(3) > div > div > p > span");
	  public By lancamentosFuturos = By.cssSelector("div:nth-child(3) > div > div:nth-child(2) > p > span");
	  
	  /// Box Oportunidades
	  public By refilHome = By.cssSelector("div > div:nth-child(2) > div > div:nth-child(1) > p > span");
	  public By oportunidadeHome = By.cssSelector("div > div:nth-child(2) > div > div:nth-child(2) > p > span");
	  public By sacolaHome = By.cssSelector("div > div:nth-child(2) > div > div:nth-child(3) > p > span");
	  
	  
	  //Box Clientes
	  public By iconePrint = By.cssSelector("div:nth-child(1) > div > div > button > i");	  										
	  public By novosClientes = By.cssSelector("div.white-bg > div > div > div> div:nth-child(2) > div > div > div > h2");
	  public By totalClientes = By.cssSelector("div.white-bg > div > div > div > div:nth-child(3) > div > div > div > h2");
	  public By clientesFrequentes = By.cssSelector("div.white-bg > div > div > div > div:nth-child(4) > div > div > div > h2");
	  
	  //Box Visitas
	  public By totalVisitas = By.cssSelector("div.widget.white-bg > div > div > div > div:nth-child(1) > div > div > div > h2");
	  public By totalVisitantes = By.cssSelector("div.widget.white-bg > div > div > div > div:nth-child(2) > div > div > div > h2");
	  public By totalPedidos = By.cssSelector("div.widget.white-bg > div > div > div > div:nth-child(3) > div > div > div > h2");
	  public By taxaConversao = By.cssSelector("div.widget.white-bg > div > div > div > div:nth-child(4) > div > div > div > h2");
	  
	  //Box Pedidos
	  public By lucroLiquido = By.cssSelector("div.white-bg.widget > div > div > p > span");
	  public By pedidosAprovados = By.cssSelector("div.white-bg.widget > div > div:nth-child(1) > p > span.btn-rounded");
	  public By taxaConversaoP = By.cssSelector("div.white-bg.widget > div > div:nth-child(2) > p > span.btn-rounded");
	  public By botaoResgatar = By.cssSelector("div.white-bg.widget > div > div > button");
	  
	  //Box Sacolas
	  public By valorTotal = By.cssSelector("div.white-bg > div > div > div > div:nth-child(3) > div > div > div > h2");
	  public By totalSacolas = By.cssSelector("div.white-bg > div > div > div > div:nth-child(2) > div > div > div > h2");
	  public By sacolasConvertidas = By.cssSelector("div.white-bg.page-heading > div > div > ul > li:nth-child(3)  > a > span.number");
	  
	  //Box Cupons
	  public By cuponsAtivos = By.cssSelector("ul > li:nth-child(1) > a > span.number");
	  public By cuponsExpirados = By.cssSelector("ul > li:nth-child(2) > a > span.number");
	  public By cuponsUtilizados = By.cssSelector("ul > li:nth-child(3) > a > span.number");
	  
	  //Form Criar Cupons
	  public By codigoCupom = By.cssSelector("input.form-control");
	  public By valorDesconto = By.cssSelector("div:nth-child(2) > div > select");
	  public By botaoCriar = By.cssSelector("div > button");
	  
	  //Box Lealdade
	  public By aniversariantes = By.cssSelector("div:nth-child(1) > div > div > div > h2");	  
	  public By recompras = By.cssSelector("div > div:nth-child(2) > div > div > div > h2");
	  public By sugestoes = By.cssSelector("div > div:nth-child(3) > div > div > div > h2");
	  public By detalhesAniversariantes = By.cssSelector("div > div:nth-child(3) > span > a");
	  public By detalhesRecompras = By.cssSelector("div > div:nth-child(1) > span > a");
	  public By detalhesSugestao = By.cssSelector("div > div:nth-child(2) > span > a");
	  
	  //Ajuda
	  public By tituloAjuda = By.cssSelector("div:nth-child(1) > div > div > div > div > div:nth-child(1) > div > h2");
	  public By aba1 = By.cssSelector("div > div:nth-child(1) > div > ul > li:nth-child(1) > a > span");
	  public By aba2 = By.cssSelector("div > div:nth-child(1) > div > ul > li:nth-child(2) > a > span");
	  public By aba3 = By.cssSelector("div > div:nth-child(1) > div > ul > li:nth-child(3) > a > span");
	  public By aba4 = By.cssSelector("div > div:nth-child(1) > div > ul > li:nth-child(4) > a > span");
	  public By aba5 = By.cssSelector("div > div:nth-child(1) > div > ul > li:nth-child(5) > a > span");
	  public By aba6 = By.cssSelector("div > div:nth-child(1) > div > ul > li:nth-child(6) > a > span");
	  public By pergunta1Aba1 = By.cssSelector("div#accordion1 > div:nth-child(1) > div > a > span");
	  public By pergunta2Aba1 = By.cssSelector("div#accordion1 > div:nth-child(2) > div > a > span");
	  public By pergunta3Aba1 = By.cssSelector("div#accordion1 > div:nth-child(3) > div > a > span");
	  public By pergunta4Aba1 = By.cssSelector("div#accordion1 > div:nth-child(4) > div > a > span");
	 
	  public By pergunta1Aba2 = By.cssSelector("div#accordion2 > div:nth-child(1) > div > a > span");
	  public By pergunta2Aba2 = By.cssSelector("div#accordion2 > div:nth-child(2) > div > a > span");
	  public By pergunta3Aba2 = By.cssSelector("div#accordion2 > div:nth-child(3) > div > a > span");
	  public By pergunta4Aba2 = By.cssSelector("div#accordion2 > div:nth-child(4) > div > a > span");
	  public By pergunta5Aba2 = By.cssSelector("div#accordion2 > div:nth-child(5) > div > a > span");
	  public By pergunta6Aba2 = By.cssSelector("div#accordion2 > div:nth-child(6) > div > a > span");
	  public By pergunta7Aba2 = By.cssSelector("div#accordion2 > div:nth-child(7) > div > a > span");
	  public By pergunta8Aba2 = By.cssSelector("div#accordion2 > div:nth-child(8) > div > a > span");
	  
	  public By pergunta1Aba3 = By.cssSelector("div#accordion3 > div:nth-child(1) > div > a > span");
	  public By pergunta2Aba3 = By.cssSelector("div#accordion3 > div:nth-child(2) > div > a > span");
	  public By pergunta3Aba3 = By.cssSelector("div#accordion3 > div:nth-child(3) > div > a > span");
	  public By pergunta4Aba3 = By.cssSelector("div#accordion3 > div:nth-child(4) > div > a > span");
	  
	  public By pergunta1Aba4 = By.cssSelector("div#accordion4 > div:nth-child(1) > div > a > span");
	  public By pergunta2Aba4 = By.cssSelector("div#accordion4 > div:nth-child(2) > div > a > span");
	  public By pergunta3Aba4 = By.cssSelector("div#accordion4 > div:nth-child(3) > div > a > span");
	  public By pergunta4Aba4 = By.cssSelector("div#accordion4 > div:nth-child(4) > div > a > span");
	  
	  public By pergunta1Aba5 = By.cssSelector("div#accordion5 > div:nth-child(1) > div > a > span");
	  public By pergunta2Aba5 = By.cssSelector("div#accordion5 > div:nth-child(2) > div > a > span");
	  public By pergunta3Aba5 = By.cssSelector("div#accordion5 > div:nth-child(3) > div > a > span");
	  
	  public By pergunta1Aba6 = By.cssSelector("div#accordion6 > div:nth-child(1) > div > a > span");
	  public By pergunta2Aba6 = By.cssSelector("div#accordion6 > div:nth-child(2) > div > a > span");
	  public By pergunta3Aba6 = By.cssSelector("div#accordion6 > div:nth-child(3) > div > a > span");
	  public By pergunta4Aba6 = By.cssSelector("div#accordion6 > div:nth-child(4) > div > a > span");
	  public By pergunta5Aba6 = By.cssSelector("div#accordion6 > div:nth-child(5) > div > a > span");
	  public By pergunta6Aba6 = By.cssSelector("div#accordion6 > div:nth-child(6) > div > a > span");
	  public By pergunta7Aba6 = By.cssSelector("div#accordion6 > div:nth-child(7) > div > a > span");
	  public By pergunta8Aba6 = By.cssSelector("div#accordion6 > div:nth-child(8) > div > a > span");
	  public By pergunta9Aba6 = By.cssSelector("div#accordion6 > div:nth-child(9) > div > a > span");
	  public By pergunta10Aba6 = By.cssSelector("div#accordion6 > div:nth-child(10) > div > a > span");
	  public By pergunta11Aba6 = By.cssSelector("div#accordion6 > div:nth-child(11) > div > a > span");
	  public By pergunta12Aba6 = By.cssSelector("div#accordion6 > div:nth-child(12) > div > a > span");
	  public By pergunta13Aba6 = By.cssSelector("div#accordion6 > div:nth-child(13) > div > a > span");
	  	  
	  //Titulo Tabelas
	  public By tituloTabela = By.cssSelector("div:not([style*=\'display\']) > div > div:nth-child(1) > div > ol > li:nth-child(1) > h2");
	  	  
	  //Busca
	  public By campoTexto = By.cssSelector("div:not([style*=\'display\']) > div > div > div > div > input[class*='search']");
	  	  
	  //Tabela
	  public By nomeColunasGrid = By.cssSelector("div[class*='colt'] > div:nth-child(2) > div > div[class*='colt']");
	  public By valoresLinhasGrid = By.cssSelector("div[class*='colt'] > div:nth-child(2) > div > div[class*='colt'] > span");
	  public By primeiraColunaIcone = By.cssSelector("div#DataTables_Table_0_wrapper > div > div > div:nth-child(1) > div > div:nth-child(2) > div > span > i");
	  public By legendaIcone = By.cssSelector("div#DataTables_Table_0_wrapper > div > div > div:nth-child(1) > div.col0.colt0 > div:nth-child(2) > div > span > span");
	  public By primeiraColunaLink = By.cssSelector("div#DataTables_Table_0_wrapper > div > div > div:nth-child(1) > div.col1.colt1 > div:nth-child(2) > div > span > a");
	  public By segundaColunaLink = By.cssSelector("div#DataTables_Table_0_wrapper > div > div > div:nth-child(1) > div.col2.colt2 > div:nth-child(2) > div > span > a");
	  public By segundaColuna = By.cssSelector("div#DataTables_Table_0_wrapper > div > div > div:nth-child(1) > div.col2.colt2 > div:nth-child(2) > div > span");
	  public By terceiraColunaLink = By.cssSelector("div#DataTables_Table_0_wrapper > div > div > div:nth-child(1) > div.col3.colt3 > div:nth-child(2) > div > span > a");
	  public By terceiraColunaSpam = By.cssSelector("div#DataTables_Table_0_wrapper > div > div > div:nth-child(1) > div.col3.colt3 > div:nth-child(2) > div > span");
	  public By terceiraColuna = By.cssSelector("div#DataTables_Table_0_wrapper > div > div > div:nth-child(1) > div.col3.colt3 > div:nth-child(2) > div");
	  public By quartaColuna = By.cssSelector("div#DataTables_Table_0_wrapper > div > div > div:nth-child(1) > div.col4.colt4 > div:nth-child(2) > div > span");
	  public By quartaColunaLink = By.cssSelector("div#DataTables_Table_0_wrapper > div > div > div:nth-child(1) > div.col4.colt4 > div:nth-child(2) > div > span > a");
	  public By quintaColuna = By.cssSelector("div#DataTables_Table_0_wrapper > div > div > div:nth-child(1) > div.col5.colt5 > div:nth-child(2) > div > span");
	  
	
}
