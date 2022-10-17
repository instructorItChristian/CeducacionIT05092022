package edit.CeducacionIT05092022;

import org.testng.annotations.Test;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class laboratorio3 {
	
	String url="http://automationpractice.com/index.php?controller=authentication&back=my-account";
	String driverPath="..\\CeducacionIT05092022\\Drivers\\chromedriver105.0.5195.52.exe";
	WebDriver driver;
	
	
	@Test
	public void registrarUsuario() {
		
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("incognito");
		options.addArguments("start-maximized");
		
	//	options.addArguments("disable-infobars");
		
		/**
		 * incognito
		 * start-maximizied
		 * disable-externsions
		 * disable-popup-blocking 
		 * 
		 **/
		
		
		driver = new ChromeDriver(options);
		
		driver.navigate().to(url);
		
		
		//incluir un correo electronico
		
		WebElement txtEmail = driver.findElement(By.cssSelector("#email_create"));
	//	txtEmail.sendKeys("micorreo1721@test.com");
		
		txtEmail.sendKeys("micorreo"+ Math.random() +"@test.com");
		//driver.findElement(By.cssSelector("#email_create")).sendKeys("micorreo1613@test.com");
		
		//apretar el boton de ingreso
		
		driver.findElement(By.id("SubmitCreate")).click();
		
		//pasar a la segunda pagina y completar todos los datos
		
		//espera para que cargue el contenido
		
		WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#id_gender1")));
		
		
		//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		
		//radio button
		
		driver.findElement(By.cssSelector("#id_gender1")).click();
		
		
		//first name
		
		WebElement txtname = driver.findElement(By.xpath("//input[@id='customer_firstname']"));
		
		txtname.sendKeys("pepe");
		
		
		//last name
		
		driver.findElement(By.name("customer_lastname")).sendKeys("argento");
		
		//password
		
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/form[1]/div[1]/div[5]/input[1]")).sendKeys("1234test");
		
		//day
		
		Select day = new Select (driver.findElement(By.id("days")));
		day.selectByValue("20");
		
		
		//month
		
		Select month = new Select (driver.findElement(By.name("months")));
		month.selectByVisibleText("March ");
		
		//year
		
		Select year = new Select (driver.findElement(By.cssSelector("#years")));
		
		year.selectByIndex(50);
		
		//newsletter
		
		driver.findElement(By.xpath("//input[@id='newsletter']")).click();
		
		
		//ofertas
		
		driver.findElement(By.name("optin")).click();
		
		
		//address
		
		driver.findElement(By.id("address1")).sendKeys("calle 1236 45");
				
		//city
		driver.findElement(By.name("city")).sendKeys("tucuman");
		
		
		//state
		
		Select state = new Select(driver.findElement(By.id("id_state")));
		state.selectByVisibleText("Arizona");
		
		//zip
		
		driver.findElement(By.cssSelector("#postcode")).sendKeys("98074");
		
		//country
		
		Select country =new Select(driver.findElement(By.id("id_country")));
		country.selectByValue("21");
		
		//mobilephone
		
		driver.findElement(By.id("phone_mobile")).sendKeys("45698742110");
		
		//referencia
		
		WebElement txtAlias = driver.findElement(By.xpath("//input[@id='alias']"));
		
		txtAlias.clear();
		
		txtAlias.sendKeys("Mi Casa");
		
		//boton de registrar
		
	
		
		driver.findElement(By.id("submitAccount")).click();
		
		
		
		
		
		
		
		
	}
	
	
	

}
