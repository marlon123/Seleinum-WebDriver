
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class TesteRegrasDeNegocio {
	
	private WebDriver driver;
	private String baseUrl = "file:///c:/Users/Camila/Documents/campo-treinamento/componentes.html";
	private DSL dsl;
	
	public TesteRegrasDeNegocio() {
		System.setProperty("webdriver.gecko.driver", "C:\\WebDrivers\\firefox\\0.20.1\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get(this.baseUrl);
		dsl = new DSL(driver);
	}
	
	@BeforeClass
	public static void setUp() {
		
		System.out.println("Início das validações");

	}
	
	@Test
	//@Ignore
	public void validarCampoNome() throws InterruptedException {
		
		dsl.escreveTexto("elementosForm:nome", "");
		//driver.findElement(By.id("elementosForm:nome")).sendKeys("");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		driver.switchTo().alert();
		Alert mensagemAlerta = driver.switchTo().alert();
		//Thread.sleep(3000);
		Assert.assertEquals("Nome eh obrigatorio", mensagemAlerta.getText());
		mensagemAlerta.accept();
		
	}
	
	@Test
	//@Ignore
	public void validarCampoSobrenome() throws InterruptedException {
		
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Marlon");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		driver.switchTo().alert();
		Alert mensagemAlerta = driver.switchTo().alert();
		Thread.sleep(3000);
		Assert.assertEquals("Sobrenome eh obrigatorio", mensagemAlerta.getText());
		mensagemAlerta.accept();
		
	}
	
	@Test
	//@Ignore
	public void validarCampoSexo() throws InterruptedException {
		
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Marlon");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Pinto");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		driver.switchTo().alert();
		Alert mensagemAlerta = driver.switchTo().alert();
		Thread.sleep(3000);
		Assert.assertEquals("Sexo eh obrigatorio", mensagemAlerta.getText());
		mensagemAlerta.accept();
		
	}
	
	@Test
	//@Ignore
	public void validarCampoComida() throws InterruptedException {
		
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Marlon");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Pinto");
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		driver.switchTo().alert();
		Alert mensagemAlerta = driver.switchTo().alert();
		//Thread.sleep(3000);
		Assert.assertEquals("Tem certeza que voce eh vegetariano?", mensagemAlerta.getText());
		mensagemAlerta.accept();
		
	}
	
	@Test
	public void validarCampoEsporte() throws InterruptedException {
		
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Marlon");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Pinto");
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		//driver.findElement(By.id("elementosForm:sexo:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		//driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
		
		Select esporte = new Select(driver.findElement(By.id("elementosForm:esportes")));
		//esporte.selectByIndex(1);
		//esporte.selectByIndex(4);
		esporte.selectByVisibleText("Futebol");
		esporte.selectByVisibleText("O que eh esporte?");
		
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		driver.switchTo().alert();
		Alert mensagemAlerta = driver.switchTo().alert();
		//Thread.sleep(3000);
		Assert.assertEquals("Voce faz esporte ou nao? com erro", mensagemAlerta.getText());
		mensagemAlerta.accept();
		
	}
	
	@AfterClass
	public static void posCondicao() throws InterruptedException {
		
		System.out.println("Fim das validações");

	}
	
	@After
	public void encerrarNavegador() {
		
		//Thread.sleep(3000);
		driver.quit();
	}

}
