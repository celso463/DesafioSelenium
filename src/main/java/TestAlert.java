import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class TestAlert<Confirm> {
private WebDriver driver;
	
	
	@Before
	public void inicializa() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Gordo\\Downloads\\gecko driver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("file:///C:/Users/Gordo/Downloads/campo_treinamento/componentes.html");
		driver.manage().window().setSize(new Dimension(1200, 765));
	}
	@After
	public void finaliza() {
	driver.quit();	
	}
	@Test
	
	public void  InteragirComAlertSimples(){
	
	
	driver.findElement(By.id("alert")).click();
	Alert alert = driver.switchTo().alert();
	String texto = alert.getText();
	Assert.assertEquals("Alert Simples",texto);
	alert.accept();
	
	driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);
	
	}
	
	@Test
	
	public void  InteragirComConfirmSimples(){
	

	driver.findElement(By.id("confirm")).click();
	Alert alert = driver.switchTo().alert();
	Assert.assertEquals("Confirm Simples", alert.getText());
	alert.accept();
	Assert.assertEquals("Confirmado", alert.getText());
	alert.accept();
	
	
	driver.findElement(By.id("confirm")).click();
	alert = driver.switchTo().alert();
	Assert.assertEquals("Confirm Simples", alert.getText());
	alert.dismiss();
	Assert.assertEquals("Negado", alert.getText());
	alert.accept();

	
}
//@Test

public void  InteragirComPrompt(){


driver.findElement(By.id("prompt")).click();
Alert alerta = driver.switchTo().alert();
Assert.assertEquals("Digite um numero", alerta.getText());
alerta.sendKeys("12");
alerta.accept();
Assert.assertEquals("Era 12?", alerta.getText());
alerta.accept();
Assert.assertEquals(":D", alerta.getText());
alerta.accept();


}

}
//file:///C:/Users/Gordo/Downloads/campo_treinamento/componentes.html
