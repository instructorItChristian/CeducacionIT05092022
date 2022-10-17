package edit.CeducacionIT05092022;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class laboratorio5 {
	
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
			
	@Test(description ="cp001 - buscar palabra", priority =10)
	public void buscarPalabra() {
		
		String palabraABuscar ="shirts";
		
		
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		
		txtBuscador.sendKeys(palabraABuscar);
		
		
		
		//hacer la busqueda
		
		txtBuscador.sendKeys(Keys.ENTER);
		
		//validar donde esta el navegador o su URl
		
		///http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=dress&submit_search=
		
		//Assert.assertEquals(driver.getCurrentUrl(), "http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query="+palabraABuscar+"&submit_search=");
		
		Assert.assertEquals(driver.getCurrentUrl(), "http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=dress&submit_search=");
		
		
	}
	
	
	
	@Test(description ="cp002 - ir a contac us", priority=20)
	public void irAContacUs() {
		
		driver.findElement(By.linkText("Contact us")).click();
		
		Select subject =new Select(driver.findElement(By.id("id_contact")));
		subject.selectByVisibleText("Customer service");
		
		//mail
		
		driver.findElement(By.id("email")).sendKeys("micorreo@test.com");
		
		//order
		
		driver.findElement(By.name("id_order")).sendKeys("123545");
		
		//archivo
		
		driver.findElement(By.cssSelector("#fileUpload")).sendKeys("c:\\testenvio.txt");
		
		//texto
		
		driver.findElement(By.tagName("textarea")).sendKeys("mi mensaje de test");
		
		//click
		
		driver.findElement(By.name("submitMessage")).click();
		
		
		
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
