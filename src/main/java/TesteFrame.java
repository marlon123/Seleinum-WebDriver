import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TesteFrame {
	
	WebDriver driver;// = new FirefoxDriver();
	String baseUrl = "file:///c:/Users/Camila/Documents/campo-treinamento/componentes.html";
	
	@Before
	public void setUp() {
		
		System.setProperty("webdriver.gecko.driver", "C:\\WebDrivers\\firefox\\0.20.1\\geckodriver.exe");
		driver = new FirefoxDriver();
		System.out.println("Before");

	}
	
	@Test
	public void interagirComFrame() {
		
		driver.get(baseUrl);
		driver.switchTo().frame("frame1");
		driver.findElement(By.id("frameButton")).click();
		Alert alerta = driver.switchTo().alert();
		String mensagemAlerta = alerta.getText();
		Assert.assertEquals("Frame OK!", mensagemAlerta);
		alerta.accept();
		
		driver.switchTo().defaultContent();
		driver.findElement(By.id("elementosForm:nome")).sendKeys(mensagemAlerta);
		
	}
	
	@After
	public void posCondicao() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();

	}

}
