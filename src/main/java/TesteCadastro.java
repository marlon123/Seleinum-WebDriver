import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCadastro {
	
	WebDriver driver;// = new FirefoxDriver();
	String paginaComponente = "file:///c:/Users/Camila/Documents/campo-treinamento/componentes.html";
	DSL dsl;
	
	public TesteCadastro() {
		System.setProperty("webdriver.gecko.driver", "C:\\WebDrivers\\firefox\\0.20.1\\geckodriver.exe");
		driver = new FirefoxDriver();
		dsl = new DSL(driver);
	}
	
	@Before
	public void setUp() {
		
		System.out.println("Before");

	}
	
	@Test
	public void cadastroComSucesso() throws InterruptedException {

		driver.get(paginaComponente);
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Marlon");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Pinto");
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		
		//WebElement elemento = driver.findElement(By.id("elementosForm:escolaridade"));
		//Select combo = new Select(elemento);
		//combo.selectByVisibleText("Especializacao");
		
		new Select(driver.findElement(By.id("elementosForm:escolaridade"))).selectByVisibleText("Especializacao");
		
		WebElement elementoMultiplaEscolha = driver.findElement(By.id("elementosForm:esportes"));
		Select comboEsportes = new Select(elementoMultiplaEscolha);
		comboEsportes.selectByVisibleText("Natacao");
		comboEsportes.selectByVisibleText("Futebol");
		
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		
		Assert.assertTrue(driver.findElement(By.id("resultado")).getText().startsWith("Cadastrado!"));
		Assert.assertTrue(driver.findElement(By.id("descNome")).getText().endsWith("Marlon"));
		Assert.assertEquals("Sobrenome: Pinto", driver.findElement(By.id("descSobrenome")).getText());

	}
	
	@After
	public void posCondicao() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();

	}

}
