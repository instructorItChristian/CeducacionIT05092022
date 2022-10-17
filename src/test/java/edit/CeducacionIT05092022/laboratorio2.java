package edit.CeducacionIT05092022;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class laboratorio2 {
	
	//atributos
	
	String url ="http://automationpractice.com/index.php";
	String chromePath ="..\\CeducacionIT05092022\\Drivers\\chromedriver105.0.5195.52.exe";
	String firefoxDriver="..\\CeducacionIT05092022\\Drivers\\geckodriver-v0.31.0.exe";
	WebDriver driver;
	
	
	
	
	//acciones o metodos
	
	@Test
	public void buscarPalabraChrome(){
		
		//definir utilizacion del driver
		
		System.setProperty("webdriver.chrome.driver", chromePath);
		
		
		
		//abrir navegado
		driver = new ChromeDriver();
		
		//abrir el navegador
		driver.get(url);
				
		driver.manage().deleteAllCookies();
		
		driver.manage().window().maximize();
			
		//escribir palabra
		
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		
		txtBuscador.sendKeys("dress");
		
		
		
		//hacer la busqueda
		
		txtBuscador.sendKeys(Keys.ENTER);
		
		
		System.out.println("url:" + driver.getCurrentUrl());
		System.out.println("titulo de la pagina" + driver.getTitle());
			
		
		driver.close();
		
	}
	
	
	@Test
	public void buscarPalabraChromeNavegador(){
		
		//definir utilizacion del driver
		
		System.setProperty("webdriver.chrome.driver", chromePath);
		
		//lineas para elegir el navegador
		
		ChromeOptions options =new ChromeOptions();
		
		options.setBinary("C:/Program Files/Google/Chrome Beta/Application/chrome.exe");
		
		//le pasamos las opciones elegidas
		//abrir navegado
		driver = new ChromeDriver(options);
		
		//abrir el navegador
		driver.get(url);
			
		//escribir palabra
		
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		
		txtBuscador.sendKeys("dress");
		
		
		
		//hacer la busqueda
		
		txtBuscador.sendKeys(Keys.ENTER);
		
		//cerrar el navegador
		
			
		
	}
	
	
	
	
	@Test
	public void buscarPalabrafirefox(){
		
		//definir utilizacion del driver
		
		System.setProperty("webdriver.gecko.driver", firefoxDriver);
		
		//para seleccionar el binario a utilizar 
		//System.setProperty("webdriver.firefox.bin", "direcion del ejecutable");
		
		
		//abrir navegado
		driver = new FirefoxDriver();
		
		//abrir el navegador
		driver.get(url);
			
		//escribir palabra
		
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		
		txtBuscador.sendKeys("dress");
		
		
		
		//hacer la busqueda
		
		txtBuscador.sendKeys(Keys.ENTER);
		
		//cerrar el navegador
		
			
		
	}
	
	


}
