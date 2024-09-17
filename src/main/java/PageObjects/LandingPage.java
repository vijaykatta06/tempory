package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstarctComponents.Abstractcomponent;

public class LandingPage extends Abstractcomponent{

	// TODO Auto-generated method stub
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@type='email']")
	WebElement userEmail;

	@FindBy(xpath = "//input[@type='password']")
	WebElement passwordele;

	@FindBy(id = "login")
	WebElement submit;

	public void LoginApplication(String email, String password) {
		userEmail.sendKeys(email);
		passwordele.sendKeys(password);
		submit.click();
	}
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
		
	}
	

}
