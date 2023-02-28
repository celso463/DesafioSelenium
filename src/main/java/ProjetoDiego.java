
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProjetoDiego {



public static void main(String[] args) {

	
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Gordo\\Downloads\\Chrome driver\\chromedriver2.exe");

	WebDriver driver = new ChromeDriver();
	driver.get("https://www.grocerycrud.com/v1.x/demo/bootstrap_theme");
	driver.manage().window().maximize();
	WebElement element = driver.findElement(By.id("switch-version-select"));
	Select combo = new Select(element);
	combo.selectByIndex(1);
	driver.findElement(By.partialLinkText("Add Customer")).click();
	
	driver.findElement(By.id("field-customerName")).sendKeys(" Teste Sinqia");
	driver.findElement(By.id("field-contactLastName")).sendKeys(" Teste");
	driver.findElement(By.id("field-contactFirstName")).sendKeys("Celso");
	driver.findElement(By.id("field-phone")).sendKeys("51 9999-9999");
	driver.findElement(By.id("field-addressLine1")).sendKeys("Av Sinqia, 1995");
	driver.findElement(By.id("field-addressLine2")).sendKeys("Torre D");
	driver.findElement(By.id("field-city")).sendKeys(" Porto Alegre");
	driver.findElement(By.id("field-state")).sendKeys("RS");
	driver.findElement(By.id("field-postalCode")).sendKeys("91000-000");
	driver.findElement(By.id("field-country")).sendKeys("Brasil from");

	driver.findElement(By.xpath("//*[@id=\"field_salesRepEmployeeNumber_chosen\"]/a/span")).click();
	driver.findElement(By.xpath("//*[@id=\"field_salesRepEmployeeNumber_chosen\"]/div/ul/li[8]")).click();
	driver.findElement(By.id("field-creditLimit")).sendKeys("200");

	driver.findElement(By.id("form-button-save")).click();
	new WebDriverWait(driver, 5)
	.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div/div/div/div[2]/form/div[15]/div[2]/p")));
	Assert.assertEquals("Your data has been successfully stored into the database. Edit Customer or Go back to list", driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/form/div[15]/div[2]/p")).getText());
	System.out.println(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/form/div[15]/div[2]/p")).getText());
	driver.quit();
	
}
}