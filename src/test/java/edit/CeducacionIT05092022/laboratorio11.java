package edit.CeducacionIT05092022;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class laboratorio11 {
	
	
	
	
	String url="https://demoqa.com/alerts";
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
	public void alert1() {
		
		driver.findElement(By.id("alertButton")).click();
		Alert alerta = driver.switchTo().alert();
		alerta.accept();
					
	}
	
	
	@Test
	
	public void alert2() {
		
		driver.findElement(By.id("timerAlertButton")).click();
		
WebDriverWait wait = new WebDriverWait (driver,Duration.ofSeconds(15));
wait.until(ExpectedConditions.alertIsPresent());
			
		Alert alerta = driver.switchTo().alert();
		alerta.accept();	
		
		
	}
	
	
	
	@Test
	public void alert3() {
		
		driver.findElement(By.id("confirmButton")).click();
		
		Alert alerta = driver.switchTo().alert();
		alerta.dismiss();
				
			
	}
	
	@Test
	public void alert4() {
		driver.findElement(By.id("promtButton")).click();
		
		Alert alerta = driver.switchTo().alert();
		alerta.sendKeys("clase de automatizacion");
		alerta.accept();
		
		
	}

}
