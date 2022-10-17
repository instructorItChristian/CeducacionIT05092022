package edit.CeducacionIT05092022;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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

import Utilities.CapturaEvidencia;

public class laboratorio7 {
	
	String Url="http://automationpractice.com/index.php";;
	String Driverpath ="..\\CeducacionIT05092022\\Drivers\\chromedriver105.0.5195.52.exe";
	String imagePath="..\\CeducacionIT05092022\\Evidencias\\";
	String docPath="..\\CeducacionIT05092022\\Evidencias\\documentoEvidencias.docx";
	WebDriver driver;
	File screen;
	
	
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
	public void buscarPalabra() throws IOException {
		
		String palabraABuscar ="shirts";
		
		//captura evidencia
		
		screen =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File(imagePath, "01_pantalla_inicial.jpg"));
		
		
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		
		txtBuscador.sendKeys(palabraABuscar);
		
		//captura evidencia
		screen =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File(imagePath, "02_pantalla_busqueda.jpg"));
		
		//hacer la busqueda
		
		txtBuscador.sendKeys(Keys.ENTER);
		
		//validar donde esta el navegador o su URl
		
		///http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=dress&submit_search=
		
		
		
		//captura evidencia
		
		screen =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File(imagePath, "03_pantalla_resultado.jpg"));
		
		
		//Assert.assertEquals(driver.getCurrentUrl(), "http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=dress&submit_search=");
		
		Assert.assertEquals(driver.getCurrentUrl(), "http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query="+palabraABuscar+"&submit_search=");
		
		
	}
	
	
	
	@Test(description ="cp002 - ir a contac us", priority=20)
	public void irAContacUs() throws InvalidFormatException, IOException, InterruptedException {
		
		
		
		
		
		
		
		
		//definicion de titulo
		CapturaEvidencia.escribirTituloEnDocumento(docPath, "Documento de Evidencias de prueba", 18);
		
		//captura de evidencia
		
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver, imagePath + "img.jpg", docPath, "pantalla princial");
		
		driver.findElement(By.linkText("Contact us")).click();
		
		//captura de evidencia
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver, imagePath + "img.jpg", docPath, "pantalla form");
		
		
		
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
		
		//captura de evidencia
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver, imagePath + "img.jpg", docPath, "pantalla form completo");
		
		//click
		
		driver.findElement(By.name("submitMessage")).click();
		
		//captura de evidencia
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver, imagePath+"img.jpg", docPath, "pantalla respuesta form");
		
		
		
	}
	
	
	
	
	@Test(description ="cp003 - ir a contac us", priority=30)
	public void irAContacUsConArchivosDiferentes() throws InvalidFormatException, IOException, InterruptedException {
		
		
		Date fecha = new Date();
		
		Integer hora = fecha.getHours();
		
		Integer minutos = fecha.getMinutes();
		
		String docPathArchivo = imagePath+"docEvidencia"+LocalDate.now()+"H"+hora+"M"+minutos+".docx";
		
		
		
		//definicion de titulo
		CapturaEvidencia.escribirTituloEnDocumento(docPathArchivo, "Documento de Evidencias de prueba", 18);
		
		//captura de evidencia
		
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver, imagePath + "img.jpg", docPathArchivo, "pantalla princial");
		
		driver.findElement(By.linkText("Contact us")).click();
		
		//captura de evidencia
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver, imagePath + "img.jpg", docPathArchivo, "pantalla form");
		
		
		
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
		
		//captura de evidencia
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver, imagePath + "img.jpg", docPathArchivo, "pantalla form completo");
		
		//click
		
		driver.findElement(By.name("submitMessage")).click();
		
		//captura de evidencia
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver, imagePath+"img.jpg", docPathArchivo, "pantalla respuesta form");
		
		
		
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
