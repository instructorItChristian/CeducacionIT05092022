package edit.CeducacionIT05092022;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import paginas.PaginaInicio;
import paginas.PaginaLogin;

public class laboratorio9 {
	
	String url="http://automationpractice.com/index.php";
	String driverPath="..\\CeducacionIT05092022\\Drivers\\chromedriver105.0.5195.52.exe";
	WebDriver driver;
	
	@BeforeSuite
	public void setup() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		ChromeOptions options =new ChromeOptions();
		options.addArguments("incognito");
		
		driver =new ChromeDriver(options);
		
		driver.get(url);
		driver.manage().window().maximize();
		
				
	}
	
	
	
	@Test
	public void login() {
		
		//en la pagina principal hacer click en el bnt sing in
		
		PaginaInicio inicio =new PaginaInicio(driver);
		
		inicio.hacerClickEnSingIn();
		
		//ingresar el correo y la contraseña
		
		PaginaLogin login = new PaginaLogin(driver);
		
		login.EscribirEmail("micorreo0.8892123983747402@test.com");
		
		login.EscribirPass("1234test");
		
		
		//hacer click en el boton sing in
		
		
		login.HacerClickEnSingIn();
		
		
	}
	
	
	
	
	
	

}
