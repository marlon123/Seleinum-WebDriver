import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(Parameterized.class)
public class TesteRegrasCadastro {
	
	WebDriver driver;
	private String baseUrl = "file:///c:/Users/Camila/Documents/campo-treinamento/componentes.html";
	private DSL dsl;
	private  CampoTreinamentoPage page;
	
	@Parameter
	public String nome;
	@Parameter(value=1)
	public String sobrenome;
	@Parameter(value=2)
	public String sexo;
	@Parameter(value=3)
	public List<String> comidas;
	@Parameter(value=4)
	public String[] esportes;
	@Parameter(value=5)
	public String msg;
	
	public TesteRegrasCadastro() {
		System.setProperty("webdriver.gecko.driver", "C:\\WebDrivers\\firefox\\0.20.1\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	
	@Before
	public void setUp() {
		
		System.out.println("Início das validações");
		driver.get(this.baseUrl);
		dsl = new DSL(driver);
		page = new CampoTreinamentoPage(driver);

	}
	
	@Parameters(name = "{0} | {1} | {2} | {3} | {4} | {5}")
	public static Collection<Object[]> getCollection(){
		return Arrays.asList(new Object[][] {
			{"", "", "", Arrays.asList(), new String[]{}, "Nome eh obrigatorio"},
			{"Marlon", "", "", Arrays.asList(), new String[]{}, "Sobrenome eh obrigatorio"},
			{"Marlon", "Pinto", " ", Arrays.asList(), new String[]{}, "Sexo eh obrigatorio"},
			{"Marlon", "Pinto", "Masculino", Arrays.asList("Carne", "Vegetariano"), new String[]{}, "Tem certeza que voce eh vegetariano?"},
			{"Marlon", "Pinto", "Masculino", Arrays.asList("Carne"), new String[]{"Karate", "O que eh esporte?"}, "Voce faz esporte ou nao?"}
		});
	}
	
	@Test
	public void deveValidarRegras(){
		
		page.setNome(nome);
		page.setSobreNome(sobrenome);
		if(sexo.equals("Masculino")) {
			page.setSexoMasculino();
		} 
		if(sexo.equals("Feminino")) {
			page.setSexoFeminino();
		}
		if(comidas.contains("Carne")) page.setComidaCarne(); 
		if(comidas.contains("Pizza")) page.setComidaPizza(); 
		if(comidas.contains("Vegetariano")) page.setComidaVegetariano(); 
		page.setEsporte(esportes);
		page.cadastrar();
		System.out.println(msg);
		Assert.assertEquals(msg, dsl.alertaObterTextoEAceita());
	}
	
	@After
	public void posCondicao() {
		driver.quit();
	}

}
