package edit.CeducacionIT05092022;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class laboratorio8 {
	
	
	
	//atributos
	
	String url ="http://automationpractice.com/index.php";
	String chromePath ="..\\CeducacionIT05092022\\Drivers\\chromedriver105.0.5195.52.exe";
	String firefoxDriver="..\\CeducacionIT05092022\\Drivers\\geckodriver-v0.31.0.exe";
	WebDriver driver;
	
	
	
	
	@Parameters("navegador")
	
	@BeforeTest
	public void setup(String navegador) {
		
		if(navegador.equalsIgnoreCase("chrome")) {	
		//definir utilizacion del driver
		
				System.setProperty("webdriver.chrome.driver", chromePath);
												
				//abrir navegado
				driver = new ChromeDriver();
				
				//abrir el navegador
				driver.get(url);
						
				driver.manage().deleteAllCookies();
				
				driver.manage().window().maximize();
		

		}else if(navegador.equalsIgnoreCase("firefox")){
				
				//definir utilizacion del driver
				
				System.setProperty("webdriver.gecko.driver", firefoxDriver);
				
				//para seleccionar el binario a utilizar 
				//System.setProperty("webdriver.firefox.bin", "direcion del ejecutable");
				
				
				//abrir navegado
				driver = new FirefoxDriver();
				
				//abrir el navegador
				driver.get(url);
				
							
		}
			
		
	}
	
	
	
	
	//acciones o metodos
	
	@Test
	public void buscarPalabra(){
		
			
		//escribir palabra
		
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		
		txtBuscador.sendKeys("dress");
			
		//hacer la busqueda
		
		txtBuscador.sendKeys(Keys.ENTER);
			
		
	}
	
	
	
	
	
	
	
	

}
