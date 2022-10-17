package edit.CeducacionIT05092022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import paginas.PaginaInicio;
import paginas.PaginaLogin;

public class laboratorio15 {
	
	String url="https://www.demo.guru99.com/test/table.html";
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
		
		String valor1 = driver.findElement(By.xpath("//tbody/tr[1]/td[1]")).getText();
		
		System.out.println("primera fila, primera columna: "+ valor1);
		
		String valor2 = driver.findElement(By.xpath("//tbody/tr[2]/td[3]")).getText();
		
		System.out.println("segunda fila, tercera columna: "+ valor2);
		
		String valor3 = driver.findElement(By.xpath("//tbody/tr[3]/td[1]")).getText();
		
		System.out.println("tercera fila, primera columna: "+ valor3);
		
		String valor4 = driver.findElement(By.xpath("//tbody/tr[4]/td[2]")).getText();
		
		System.out.println("cuarta fila, segunda columna: "+ valor4);
		
		
	}
	
	
	
	
	

}
