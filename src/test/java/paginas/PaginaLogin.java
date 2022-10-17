package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaLogin {
	
	
@FindBy(css="#email")	
WebElement txtemail;

@FindBy(name="passwd")
WebElement txtpass;

@FindBy(id="SubmitLogin")
WebElement btnSingIn;

@FindBy(linkText="Sign out")
WebElement btonsingOut;
	
	

public PaginaLogin(WebDriver driver) {
	
	PageFactory.initElements(driver, this);
		
}


public void EscribirEmail(String email) {
	
	txtemail.sendKeys(email);
}


public void EscribirPass(String Pass) {
	txtpass.sendKeys(Pass);
	
}

public void HacerClickEnSingIn() {
	
	btnSingIn.click();
	
	
}

public void HacerClickEnSignOut() {
	
	btonsingOut.click();
	
}
	

}
