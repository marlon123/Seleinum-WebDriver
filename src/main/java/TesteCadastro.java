import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteCadastro {
	
	WebDriver driver;// = new FirefoxDriver();
	String paginaComponente = "file:///c:/Users/Camila/Documents/campo-treinamento/componentes.html";
	DSL dsl;
	CampoTreinamentoPage page;
	
	public TesteCadastro() {
		System.setProperty("webdriver.gecko.driver", "C:\\WebDrivers\\firefox\\0.20.1\\geckodriver.exe");
		driver = new FirefoxDriver();
		dsl = new DSL(driver);
		driver.get(paginaComponente);
		page = new CampoTreinamentoPage(driver);
	}
	
	@Before
	public void setUp() {
		
		System.out.println("Before");
		
	}
	
	@Test
	public void cadastroComSucesso() throws InterruptedException {
		
		page.setNome("Marlon");
		page.setSobreNome("Pinto");
		page.setSexoMasculino();
		page.setComidaPizza();
		page.setEscolaridade("Especializacao");
		page.setEsporte("Natacao");
		page.cadastrar();
		
		Assert.assertTrue(page.obterResultadoCadastro().startsWith("Cadastrado!"));
		Assert.assertTrue(page.obterNomeCadastro().endsWith("Marlon"));
		Assert.assertEquals("Sobrenome: Pinto", page.obterSobrenomeCadastro());
		Assert.assertEquals("Sexo: Masculino", page.obterSexoCadastro());
		Assert.assertEquals("Comida: Pizza", page.obterComidaCadastro());
		Assert.assertEquals("Escolaridade: Especializacao", page.obterEscolaridadeCadastro());
		Assert.assertEquals("Esportes: Natacao", page.obterEsporteCadastro());

	}
	
	@After
	public void posCondicao() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
		
	}

}
