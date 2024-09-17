package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstarctComponents.Abstractcomponent;

public class Productcataloge extends Abstractcomponent {
	// TODO Auto-generated method stub
		WebDriver driver;

		public Productcataloge(WebDriver driver) {
			this.driver = driver;

			PageFactory.initElements(driver, this);
		}
		
		@FindBy(css=".mb-3")
		List<WebElement> products;
		
			
		public List<WebElement> Getproductlist() {
			waitForElementToApper(null);
			return products;
		}
		

}
