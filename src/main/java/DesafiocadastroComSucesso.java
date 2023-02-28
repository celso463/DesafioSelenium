
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DesafiocadastroComSucesso {
private WebDriver driver;
private DSL dsl;
	
	
	@Before
	public void inicializa() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Gordo\\Downloads\\gecko driver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("file:///C:/Users/Gordo/Downloads/campo_treinamento/componentes.html");
		driver.manage().window().setSize(new Dimension(1200, 765));
		dsl = new DSL(driver);
	}
	@After
	public void finaliza() {
	driver.quit();	
	}
	@Test
	public void  deveRealizarCadastroComSucesso() {
	
	
	dsl.escrever("elementosForm:nome", "Celso");
	dsl.escrever("elementosForm:sobrenome", "Farias");
	dsl.clicarRadio("elementosForm:sexo:0");
	dsl.clicarRadio("elementosForm:comidaFavorita:2");
	dsl.selecionarCombo("elementosForm:escolaridade", "2o grau completo");
	dsl.selecionarCombo("elementosForm:esportes", "Natacao");
	dsl.clicarBotao("elementosForm:cadastrar");	
	
	Assert.assertTrue(dsl.obterTexto("resultado").startsWith("Cadastrado!"));
	Assert.assertTrue(dsl.obterTexto("descNome").endsWith("Celso"));
	Assert.assertEquals("Sobrenome: Farias", dsl.obterTexto("descSobrenome"));
	Assert.assertEquals("Sexo: Masculino", dsl.obterTexto("descSexo"));
	Assert.assertEquals("Comida: Pizza", dsl.obterTexto("descComida"));
	Assert.assertEquals("Escolaridade: 2graucomp", dsl.obterTexto("descEscolaridade"));
	Assert.assertEquals("Esportes: Natacao Corrida", dsl.obterTexto("descEsportes"));

	}

	@Test
	public void  deveValidarNomeObrigatorio() {

	
			
		driver.findElement(By.id("elementosForm:cadastrar")).click();	
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Nome eh obrigatorio", alert.getText());
	


}
	@Test
	public void  deveValidarSobrenomeObrigatorio() {


		driver.findElement(By.id("elementosForm:nome")).sendKeys("Nome qualquer");	
		driver.findElement(By.id("elementosForm:cadastrar")).click();	
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Sobrenome eh obrigatorio", alert.getText());
		
	}
	@Test
	public void  deveValidarSexoObrigatorio() {


		driver.findElement(By.id("elementosForm:nome")).sendKeys("Nome qualquer");	
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Sobrenome qualquer");
		driver.findElement(By.id("elementosForm:cadastrar")).click();	
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Sexo eh obrigatorio", alert.getText());
	
}
	@Test
	public void  deveValidarComidaObrigatorio() {

	
		dsl.escrever("elementosForm:nome", "Nome qualquer");
		dsl.escrever("elementosForm:sobrenome", "Sobrenome qualquer");
		dsl.clicarRadio("elementosForm:sexo:1");
		dsl.clicarRadio("elementosForm:comidaFavorita:0");
		dsl.clicarRadio("elementosForm:comidaFavorita:3");
		dsl.clicarBotao("elementosForm:cadastrar");	
		Assert.assertEquals("Tem certeza que voce eh vegetariano?", dsl.alertaObterTextoEAceita());
	}
	@Test
	public void  deveValidarEsportistaIndeciso() {

	
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Nome qualquer");	
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Sobrenome qualquer");
		driver.findElement(By.id("elementosForm:sexo:1")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		Select combo = new Select(driver.findElement(By.id("elementosForm:esportes")));
		combo.selectByVisibleText("Karate");
		combo.selectByVisibleText("O que eh esportes?");
		driver.findElement(By.id("elementosForm:cadastrar")).click();	
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Voce faz esportes ou nao?", alert.getText());

}
}
