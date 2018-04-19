import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCampoTreinamento {

	WebDriver driver;// = new FirefoxDriver();
	String paginaComponente = "file:///c:/Users/Camila/Documents/campo-treinamento/componentes.html";
	DSL dsl;

	public TesteCampoTreinamento() {
		System.setProperty("webdriver.gecko.driver", "C:\\WebDrivers\\firefox\\0.20.1\\geckodriver.exe");
		driver = new FirefoxDriver();
		dsl = new DSL(driver);
	}

	@Before
	public void setUp() {

		System.out.println("Before");
		driver.manage().window().maximize();
		driver.get(paginaComponente);

	}

	@Test
	//@Ignore
	public void testeTextField() {
		
		dsl.escreveTexto("elementosForm:nome", "Teste de escrita");
		Assert.assertEquals("Teste de escrita", dsl.obterValorCampo("elementosForm:nome"));

	}
	
	@Test
	public void testTextFieldDuplo(){
		dsl.escreveTexto("elementosForm:nome", "Wagner");
		Assert.assertEquals("Wagner", dsl.obterValorCampo("elementosForm:nome"));
		dsl.escreveTexto("elementosForm:nome", "Aquino");
		Assert.assertEquals("Aquino", dsl.obterValorCampo("elementosForm:nome"));
	}

	@Test
	@Ignore
	public void interagirComTextArea() throws InterruptedException {
		
		dsl.escreveTexto("elementosForm:sugestoes", "teste\n\naasldjdlks\nUltima linha");
		Assert.assertEquals("teste\n\naasldjdlks\nUltima linha", dsl.obterValorCampo("elementosForm:sugestoes"));

	}

	@Test
	@Ignore
	public void interagirComRadioButton() throws InterruptedException {

		dsl.clicarRadioButton("elementosForm:sexo:0");
		Assert.assertTrue(dsl.isRadioMarcado("elementosForm:sexo:0"));

	}
	
	@Test
	@Ignore
	public void interagirComChekBox() throws InterruptedException {

		dsl.clicarCheck("elementosForm:comidaFavorita:2");
		Assert.assertTrue(dsl.isCheckMarcado("elementosForm:comidaFavorita:2"));
		Thread.sleep(1000);

	}
	
	@Test
	@Ignore
	public void interagirComboBox() throws InterruptedException {

		dsl.selecionarCombo("elementosForm:escolaridade", "2o grau completo");
		Assert.assertEquals("2o grau completo", dsl.obterValorSelecionadoCombo("elementosForm:escolaridade"));

	}
	
	@Test
	@Ignore
	public void validacoesCombo() {
		
		Assert.assertEquals(8, dsl.obterQuantidadeOpcoesCombo("elementosForm:escolaridade"));
		Assert.assertTrue(dsl.verificarOpcaoCombo("elementosForm:escolaridade", "Mestrado"));
	}
	
	@Test
	@Ignore
	public void validacoesComboMultiplaEscolha() {
		
		dsl.selecionarCombo("elementosForm:esportes", "Natacao");
		dsl.selecionarCombo("elementosForm:esportes", "Corrida");
		dsl.selecionarCombo("elementosForm:esportes", "O que eh esporte?");

		List<String> opcoesMarcadas = dsl.obterValoresCombo("elementosForm:esportes");
		Assert.assertEquals(3, opcoesMarcadas.size());
		
		dsl.deselecionarCombo("elementosForm:esportes", "Corrida");
		opcoesMarcadas = dsl.obterValoresCombo("elementosForm:esportes");
		Assert.assertEquals(2, opcoesMarcadas.size());
		Assert.assertTrue(opcoesMarcadas.containsAll(Arrays.asList("Natacao", "O que eh esporte?")));
	}
	
	@Test
	@Ignore
	public void interagirComBotao() throws InterruptedException {

		dsl.clicarBotao("buttonSimple");
		Assert.assertEquals("Obrigado!", dsl.obterValueElemento("buttonSimple"));

	}
	
	@Test
	@Ignore
	public void interagirComLink() throws InterruptedException {
		
		dsl.clicarLink("Voltar");
		Assert.assertEquals("Voltou!", dsl.obterTexto("resultado"));
		
	}
	
	@Test
	@Ignore
	public void buscarTextoNaPagina() throws InterruptedException {

		Assert.assertEquals("Campo de Treinamento", dsl.obterTexto(By.tagName("h3")));
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", dsl.obterTexto(By.className("facilAchar")));

	}

	@After
	public void posCondicao() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();

	}

}
