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

	}

	@Test
	//@Ignore
	public void testeTextField() {

		driver.manage().window().maximize();
		driver.get(paginaComponente);
		dsl.escreveTexto("elementosForm:nome", "Teste de escrita");
		//driver.findElement(By.id("elementosForm:nome")).sendKeys("Teste de escrita");

		Assert.assertEquals("Teste de escrita", dsl.obterValorCampo("elementosForm:nome"));

	}

	@Test
	@Ignore
	public void interagirComTextArea() throws InterruptedException {

		driver.get(paginaComponente);
		//driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Escrita no textArea");
		dsl.escreveTexto("elementosForm:sugestoes", "Escrita no textArea");
		Thread.sleep(1000);

	}

	@Test
	@Ignore
	public void interagirComRadioButton() throws InterruptedException {

		driver.get(paginaComponente);
		//driver.findElement(By.id("elementosForm:sexo:0")).click();
		dsl.clicarRadioButton("elementosForm:sexo:0");
		Assert.assertTrue(dsl.isRadioMarcado("elementosForm:sexo:0"));
		Thread.sleep(1000);

	}
	
	@Test
	@Ignore
	public void interagirComChekBox() throws InterruptedException {

		driver.get(paginaComponente);
		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());
		Thread.sleep(1000);

	}
	
	@Test
	@Ignore
	public void interagirComboBox() throws InterruptedException {

		driver.get(paginaComponente);
		dsl.selecionarCombo("elementosForm:escolaridade", "2o grau incompleto");
		Assert.assertEquals("2o grau incompleto", dsl.obterValorCampo("2o grau incompleto"));
		Thread.sleep(1000);

	}
	
	@Test
	@Ignore
	public void validacoesCombo() {
		
		driver.get(paginaComponente);
		WebElement elemento = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(elemento);
		List<WebElement> opcoes = combo.getOptions();
		//combo.selectByIndex(3);
		//combo.selectByValue("superior");
		combo.selectByVisibleText("Superior");
		
		Assert.assertEquals(8, opcoes.size());
		Assert.assertEquals("Superior", combo.getFirstSelectedOption().getText());
	}
	
	@Test
	@Ignore
	public void validacoesComboMultiplaEscolha() {
		
		dsl.selecionarCombo("elementosForm:esportes", "Natacao");
		dsl.selecionarCombo("elementosForm:esportes", "Futebol");
		
		WebElement elemento = driver.findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(elemento);
		
		List<WebElement> opcoesSelecionadas = combo.getAllSelectedOptions();
		Assert.assertEquals(2, opcoesSelecionadas.size());
		//Assert.assertEquals("Superior", combo.getFirstSelectedOption().getText());
	}
	
	@Test
	@Ignore
	public void interagirComBotao() throws InterruptedException {

		driver.get(paginaComponente);
		WebElement elemento = driver.findElement(By.id("buttonSimple"));
		elemento.click();
		Assert.assertEquals("Obrigado!", elemento.getAttribute("value") );
		//Thread.sleep(1000);

	}
	
	@Test
	@Ignore
	public void interagirComLink() throws InterruptedException {

		driver.get(paginaComponente);
		WebElement elemento = driver.findElement(By.linkText("Voltar"));
		elemento.click();
		Assert.assertEquals("Voltou!", driver.findElement(By.id("resultado")).getText() );
		//Thread.sleep(1000);

	}
	
	@Test
	@Ignore
	public void buscarTextoNaPagina() throws InterruptedException {

		driver.get(paginaComponente);
		//WebElement elemento = driver.findElement(By.tagName("body"));
		//System.out.println(elemento.getText());
		//elemento.click();
		//Assert.assertTrue(elemento.getText().contains("Campo de Treinamento"));
		//Thread.sleep(1000);
		//WebElement elementoTexto = driver.findElement(By.tagName("h3"));
		//Assert.assertTrue(elementoTexto.getText().contains("Campo de Treinamento"));
		Assert.assertEquals("Campo de Treinamento", dsl.obterTexto(By.tagName("h3")));
		
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", dsl.obterTexto(By.className("facilAchar")));

	}

	@After
	public void posCondicao() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();

	}

}
