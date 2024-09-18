package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstarctComponents.Abstractcomponent;

public class Productcataloge extends Abstractcomponent {
	// TODO Auto-generated method stub
		WebDriver driver;

		public Productcataloge(WebDriver driver) {
			super(driver);
			this.driver = driver;

			PageFactory.initElements(driver, this);
		}
		
		@FindBy(css=".mb-3")
		List<WebElement> products;
		
		By productsBy =  By.cssSelector(".mb03");
		public List<WebElement> Getproductlist() {
			waitForElementToApper(productsBy);
			return products;
		}
		

}
