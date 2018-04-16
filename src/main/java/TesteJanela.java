import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteJanela {
	
	WebDriver driver;// = new FirefoxDriver();
	String baseUrl = "file:///c:/Users/Camila/Documents/campo-treinamento/componentes.html";
	
	@Before
	public void setUp() {
		
		System.setProperty("webdriver.gecko.driver", "C:\\WebDrivers\\firefox\\0.20.1\\geckodriver.exe");
		driver = new FirefoxDriver();
		System.out.println("Before");

	}
	
	@Test
	@Ignore
	public void interagirComOutraJanela() {
		
		driver.get(baseUrl);
		driver.findElement(By.id("buttonPopUpEasy")).click();
		driver.switchTo().window("Popup");//focar na janela com o identificador 'Popup'
		driver.findElement(By.tagName("textarea")).sendKeys("Deu certo?");
		driver.close();
		driver.switchTo().window("");//voltar para janela que possui identificador
		driver.findElement(By.tagName("textarea")).sendKeys("Deu certo?");
		
	}
	
	@Test
	public void interagirComOutraJanelaSemIdentificador() {
		
		driver.get(baseUrl);
		driver.findElement(By.id("buttonPopUpHard")).click();
		System.out.println(driver.getWindowHandle());
		System.out.println(driver.getWindowHandles());
		driver.switchTo().window((String)driver.getWindowHandles().toArray()[1]);
		driver.findElement(By.tagName("textarea")).sendKeys("Deu certo?");
		driver.switchTo().window((String)driver.getWindowHandles().toArray()[0]);
		driver.findElement(By.tagName("textarea")).sendKeys("Deu certo?");
		
	}
	
	@After
	public void posCondicao() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();

	}

}
