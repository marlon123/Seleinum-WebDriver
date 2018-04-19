import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
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
	
	/********* TextField e TextArea ************/
	
	public void escreveTexto(String id_campo, String texto) {
		
		escreveTexto(By.id(id_campo), texto);
	}
	
	public void escreveTexto(By by, String texto){
		
		driver.findElement(by).clear();
		driver.findElement(by).sendKeys(texto);
	}
	
	public String obterValorCampo(String id_campo) {
		
		return driver.findElement(By.id(id_campo)).getAttribute("value");
	}
	
	/********* Radio e Check ************/
	
	public void clicarRadioButton(String id_campo) {
		
		driver.findElement(By.id(id_campo)).click();
	}
	
	public boolean isRadioMarcado(String id_campo) {
		
		return driver.findElement(By.id(id_campo)).isSelected();
	}
	
	public void clicarCheck(String id) {
		driver.findElement(By.id(id)).click();
	}
	
	public boolean isCheckMarcado(String id){
		return driver.findElement(By.id(id)).isSelected();
	}
	
	/********* Combo ************/
	
	public void selecionarCombo(String id_campo, String texto) {
		
		WebElement elemento = driver.findElement(By.id(id_campo));//.click();
		Select combo = new Select(elemento);
		combo.selectByVisibleText(texto);
	}
	
	public String obterValorSelecionadoCombo(String id_campo) {
		
		WebElement elemento = driver.findElement(By.id(id_campo));//.click();
		Select combo = new Select(elemento);
		return combo.getFirstSelectedOption().getText();
	}
	
	public void deselecionarCombo(String id, String valor) {
		WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);
		combo.deselectByVisibleText(valor);
	}
	
	public List<String> obterValoresCombo(String id) {
		WebElement element = driver.findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(element);
		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		List<String> valores = new ArrayList<String>();
		
		for(WebElement opcao: allSelectedOptions) {
			valores.add(opcao.getText());
		}
		return valores;
	}
	
	public int obterQuantidadeOpcoesCombo(String id){
		WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		return options.size();
	}
	
	public boolean verificarOpcaoCombo(String id, String opcao){//verificar se opção está marcada no combo
		WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		for(WebElement option: options) {
			if(option.getText().equals(opcao)){
				return true;
			}
		}
		return false;
	}
	
	/********* Botao ************/
	
	public void clicarBotao(String id_campo) {
		
		driver.findElement(By.id(id_campo)).click();
	}
	
	public String obterValueElemento(String id) {
		return driver.findElement(By.id(id)).getAttribute("value");
	}
	
	/********* Link ************/
	
	public void clicarLink(String link) {
		
		driver.findElement(By.linkText(link)).click();
	}
	
	/********* Textos ************/
	
	public String obterTexto(String id_campo) {
		
		return obterTexto(id_campo);
	}
	
	public String obterTexto(By by) {
		
		return driver.findElement(by).getText();
	}
	
/********* Alerts ************/
	
	public String alertaObterTexto(){
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}
	
	public String alertaObterTextoEAceita(){
		Alert alert = driver.switchTo().alert();
		String valor = alert.getText();
		alert.accept();
		return valor;
		
	}
	
	public String alertaObterTextoENega(){
		Alert alert = driver.switchTo().alert();
		String valor = alert.getText();
		alert.dismiss();
		return valor;
		
	}
	
	public void alertaEscrever(String valor) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(valor);
		alert.accept();
	}
	
	/********* Frames e Janelas ************/
	
	public void entrarFrame(String id) {
		driver.switchTo().frame(id);
	}
	
	public void sairFrame(){
		driver.switchTo().defaultContent();
	}
	
	public void trocarJanela(String id) {
		driver.switchTo().window(id);
	}
	
	public void trocarJanela(int index) {
		driver.switchTo().window((String)driver.getWindowHandles().toArray()[index]);
	}
	
	public void voltarJanelaInicial() {
		driver.switchTo().defaultContent();
	}

}
