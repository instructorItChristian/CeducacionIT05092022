package edit.CeducacionIT05092022;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class laboratorio4 {
	
	String Url="http://automationpractice.com/index.php";;
	String Driverpath ="..\\CeducacionIT05092022\\Drivers\\chromedriver105.0.5195.52.exe";
	WebDriver driver;
	
	
	@BeforeSuite
	//acciones que se van a ejecutar antes de toda la suite de pruebas
	
	public void beforesuite(){
		System.out.println("beforesuite - inicio de la suite de pruebas");
		
	}
	
	
	@BeforeClass
	//acciones que se van a ejecutar antes de arrancar toda la clase
	
	
	public void beforeClass(){
		System.out.println("beforeclass - inicio de la clase pruebas");
		
		System.setProperty("webdriver.chrome.driver", Driverpath);
		driver = new ChromeDriver();
		driver.get(Url);
		
		
		
	}
	
	@BeforeTest
	public void beforetest(){
		System.out.println("beforetest - inicio del test de prueba");
		
	}
	//acciones que se ejecutan antes de un test especifico
			
	@Test
	public void buscarPalabra() {
		
		
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		
		txtBuscador.sendKeys("shirts");
		
		
		
		//hacer la busqueda
		
		txtBuscador.sendKeys(Keys.ENTER);
		
		//validar donde esta el navegador o su URl
		
		///http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=dress&submit_search=
		
		Assert.assertEquals(driver.getCurrentUrl(), "http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=dress&submit_search=");
		
		
	}
	
	
	@AfterTest
	
	public void aftertest() {
		System.out.println("aftertest - fin del test");
		
	}
	
	@AfterClass
	
	public void afterclass() {
		System.out.println("afterclass - termino de la clase");
		
	}
	
	@AfterSuite
	
	public void aftersuite() {
		
		System.out.println("aftersuite - fin de la suite");
	}

	
	
	
	
}
