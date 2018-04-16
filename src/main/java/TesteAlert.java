import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteAlert {
	
	WebDriver driver;// = new FirefoxDriver();
	String paginaComponente = "file:///c:/Users/Camila/Documents/campo-treinamento/componentes.html";
	
	public TesteAlert() {
		System.setProperty("webdriver.gecko.driver", "C:\\WebDrivers\\firefox\\0.20.1\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	
	@Before
	public void setUp() {

		System.out.println("Before");

	}
	
	@Test
	@Ignore
	public void interagirComAlert() throws InterruptedException {

		driver.get(paginaComponente);
		WebElement elementoBotaoAlert = driver.findElement(By.id("alert"));
		elementoBotaoAlert.click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(1000);
		Assert.assertEquals("Alert Simples", alert.getText());
		String texto = alert.getText();
		alert.accept();
		driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);
		Thread.sleep(1000);

	}
	
	@Test
	@Ignore
	public void interagirComAlertConfirmar() throws InterruptedException {

		driver.get(paginaComponente);
		WebElement elementoBotaoAlertConfirmar = driver.findElement(By.id("confirm"));
		elementoBotaoAlertConfirmar.click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(1000);
		Assert.assertEquals("Confirm Simples", alert.getText());
		//String texto = alert.getText();
		alert.accept();
		//alert.dismiss();
		Assert.assertEquals("Confirmado", alert.getText());
		alert.accept();
		//driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);
		Thread.sleep(1000);

	}
	
	@Test
	@Ignore
	public void interagirComAlertPrompt() throws InterruptedException {

		driver.get(paginaComponente);
		WebElement elementoBotaoAlertPrompt = driver.findElement(By.id("prompt"));
		elementoBotaoAlertPrompt.click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(1000);
		Assert.assertEquals("Digite um numero", alert.getText());
		alert.sendKeys("123");
		alert.accept();
		Assert.assertEquals("Era 123?", alert.getText());
		alert.accept();
		Assert.assertEquals(":D", alert.getText());
		Thread.sleep(1000);

	}
	
	
	
	@After
	public void posCondicao() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();

	}

}
