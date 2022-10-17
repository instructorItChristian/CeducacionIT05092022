package edit.CeducacionIT05092022;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class laboratorio16 {
	
String url ="https://selenium.dev/";
WebDriver Driver;




@BeforeSuite
public void abrirPagina() {
	WebDriverManager.chromedriver().setup();
	
	Driver = new ChromeDriver();
	Driver.get(url);
	
	
	
}



@Test
public void test() {
	
	System.out.println("prueba sin el chomeDriver.exe!!!");
	
}



	
	
	

}
