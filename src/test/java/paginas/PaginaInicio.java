package paginas;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaInicio {
	//elementos que vamos a utilizar
	
	@FindBy(xpath="//a[contains(text(),'Sign in')]")
	WebElement lnkSingIn; 
	
	
	@FindBy(id="search_query_top")
	WebElement txtBuscador;
	
	//constructor
	
	public PaginaInicio(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
		
	//definicion de los metodos a realizar
	
	public void hacerClickEnSingIn() {
		
		lnkSingIn.click();
		
		
	}
	
	
	public void escribirPalabraBuscdor(String palabra) {
		txtBuscador.sendKeys(palabra);
		
		
	}
	
	
	public void hacerClickBuscadorPalabra() {
		
		
		txtBuscador.sendKeys(Keys.ENTER);
		
	}
	

}
