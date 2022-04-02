package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseHRMClass;

public class PomLogin extends BaseHRMClass {
	
	//object repository
	@FindBy (id="txtUsername") //driver.findElement(By.
	WebElement Username;
	@FindBy (id="txtPassword")WebElement Password;
	@FindBy (id="btnLogin")WebElement Loginbtn;
	
	//initiate page element
	public PomLogin() {
		
		PageFactory.initElements(driver, this);
	}
	
	public void typeusername(String name) {
		
		Username.sendKeys(name);
		
	}
	public void typepassword(String pass) {
		Password.sendKeys(pass);
	}
	
	public void clickbtn() {
		Loginbtn.click();
	}
	public String verify () {
		return driver.getTitle();
	}
}
