package edit.CeducacionIT05092022;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.DatosExcel;
import paginas.PaginaInicio;
import paginas.PaginaLogin;

public class laboratorio13 {
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
	
	
	
	@Test (dataProvider="datos login desde Excel")
	public void login(String email, String pass) {
		
		//en la pagina principal hacer click en el bnt sing in
		
		PaginaInicio inicio =new PaginaInicio(driver);
		
		inicio.hacerClickEnSingIn();
		
		//ingresar el correo y la contraseña
		
		PaginaLogin login = new PaginaLogin(driver);
		
		login.EscribirEmail(email);
		
		login.EscribirPass(pass);
		
		
		//hacer click en el boton sing in
		
		
		login.HacerClickEnSingIn();
		
		
	Assert.assertEquals("http://automationpractice.com/index.php?controller=my-account", driver.getCurrentUrl());
		
	
	login.HacerClickEnSignOut();
		
	}
	
	
@DataProvider(name="datos login desde Excel")	
public Object[][] obtenerDatosExcel() throws Exception{
	return DatosExcel.leerExcel("..\\CeducacionIT05092022\\Datos\\datos_Login.xlsx", "Hoja1");
	
	
}	
	
	
	

}
