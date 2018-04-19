import org.openqa.selenium.WebDriver;

public class CampoTreinamentoPage {
	
	private DSL dsl;
	
	public CampoTreinamentoPage(WebDriver driver) {
		dsl = new DSL(driver);
	}
	
	public void setNome(String nome) {
		dsl.escreveTexto("elementosForm:nome", nome);
	}
	
	public void setSobreNome(String sobreNome) {
		dsl.escreveTexto("elementosForm:sobrenome", sobreNome);
	}
	
	public void setSexoMasculino() {
		dsl.clicarRadioButton("elementosForm:sexo:0");
	}
	
	public void setSexoFeminino(){
		dsl.clicarRadioButton("elementosForm:sexo:1");
	}
	
	public void setComidaCarne(){
		dsl.clicarRadioButton("elementosForm:comidaFavorita:0");
	}
	
	public void setComidaPizza() {
		dsl.clicarRadioButton("elementosForm:comidaFavorita:2");
	}
	
	public void setComidaVegetariano(){
		dsl.clicarRadioButton("elementosForm:comidaFavorita:3");
	}
	
	public void setEscolaridade(String escolaridade) {
		dsl.selecionarCombo("elementosForm:escolaridade", escolaridade);
	}
	
	public void setEsporte(String... esportes) {
		for(String esporte:esportes)
			dsl.selecionarCombo("elementosForm:esportes", esporte);
	}
	
	public void cadastrar() {
		dsl.clicarBotao("elementosForm:cadastrar");
	}
	
	public String obterResultadoCadastro() {
		return dsl.obterTexto("resultado");
	}
	
	public String obterNomeCadastro() {
		return dsl.obterTexto("descNome");
	}
	
	public String obterSobrenomeCadastro() {
		return dsl.obterTexto("descSobrenome");
	}
	
	public String obterSexoCadastro() {
		return dsl.obterTexto("descSexo");
	}
	
	public String obterComidaCadastro() {
		return dsl.obterTexto("descComida");
	}
	
	public String obterEscolaridadeCadastro() {
		return dsl.obterTexto("descEscolaridade");
	}
	
	public String obterEsporteCadastro() {
		return dsl.obterTexto("descEsportes");
	}

}
