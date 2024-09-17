package Tests;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import PageObjects.LandingPage;

//kattavijay612@gmail.com
//Vijay@mini6
public class StandAloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

		String productName1 = "ZARA COAT 3";
		WebDriver driver = new ChromeDriver();

		//driver.get("https://rahulshettyacademy.com/client");
		
		
		LandingPage landingPage=new LandingPage(driver);
		landingPage.goTo();
		// Log in to the application
		/*driver.findElement(By.xpath("//input[@type='email']")).sendKeys("kattavijay612@gmail.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Vijay@mini6");
		driver.findElement(By.id("login")).click();
		driver.manage().window().maximize();*/
		landingPage.LoginApplication("kattavijay612@gmail.com","Vijay@mini6");
		
		

		// Wait for products to be visible
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));

		// Find the product and add it to the cart
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		WebElement prod = products.stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst()
				.orElse(null);

		// Click the 'Add to Cart' button
		prod.findElement(By.cssSelector(".card-body button:last-child")).click();

		// Wait for the toast message and ensure it's gone
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));

		// Go to the cart
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();

		// Wait for the cart products to be visible
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cartSection")));

		// Verify the product is in the cart
		List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean match = cartProducts.stream()
				.anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase("ZARA COAT 3"));

		Assert.assertTrue(match, "Product 'ZARA COAT 3' was not found in the cart.");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");
		WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));

		// Then wait for the button to be clickable
		WebElement checkoutButton = driver.findElement(By.xpath("//button[text()='Checkout']"));
		wait4.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();
		
		Actions a= new 	Actions(driver);
		a.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")), "india").build().perform(); 
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
		driver.findElement(By.xpath("//a[@class='btnn action__submit ng-star-inserted']")).click();
		
		String confirmationmessage= driver.findElement(By.xpath("//h1[@class='hero-primary']")).getText();
		
		
		Assert.assertEquals(confirmationmessage, "Thankyou for the order.");
		
		
	
	}
	
}
