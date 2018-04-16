import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DSL {
	
	private WebDriver driver;
	
	public DSL(WebDriver driver) {
		super();
		this.driver = driver;
		
	}
	
	public void escreveTexto(String id_campo, String texto) {
		
		driver.findElement(By.id(id_campo)).sendKeys(texto);
	}
	
	public String obterValorCampo(String id_campo) {
		
		return driver.findElement(By.id(id_campo)).getAttribute("value");
	}
	
	public void clicarRadioButton(String id_campo) {
		
		driver.findElement(By.id(id_campo)).click();
	}
	
	public boolean isRadioMarcado(String id_campo) {
		
		return driver.findElement(By.id(id_campo)).isSelected();
	}
	
	public void selecionarCombo(String id_campo, String texto) {
		
		WebElement elemento = driver.findElement(By.id(id_campo));//.click();
		Select combo = new Select(elemento);
		//combo.selectByIndex(3);
		//combo.selectByValue("");
		combo.selectByVisibleText(texto);
	}
	
	public String obterValorSelcionadoCombo(String id_campo) {
		
		WebElement elemento = driver.findElement(By.id(id_campo));//.click();
		Select combo = new Select(elemento);
		return combo.getFirstSelectedOption().getText();
	}
	
	public void clicarBotao(String id_campo) {
		
		driver.findElement(By.id(id_campo)).click();
	}
	
	public void clicarLink(String link) {
		
		driver.findElement(By.linkText(link)).click();
	}
	
	public String obterTexto(String id_campo) {
		
		return obterTexto(id_campo);
	}
	
	public String obterTexto(By by) {
		
		return driver.findElement(by).getText();
	}

}
