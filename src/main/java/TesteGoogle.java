import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TesteGoogle {
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
	public void teste() {
	//	System.setProperty("webdriver.gecko.driver", "C:\\Users\\Gordo\\Downloads\\gecko driver\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Gordo\\Downloads\\Chrome driver\\chromedriver.exe");

	//	WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
	//	WebDriver driver = new InternetExplorerDriver()	
		driver.get("http://google.com");	
		Assert.assertEquals("Google",driver.getTitle());
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.quit();		
		}
}
