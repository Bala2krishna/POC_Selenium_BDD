package Testcomponents;
import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import pageObjects.HomePage;

public class StandaloneTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://tutorialsninja.com/demo/");
		String productName = "MacBook";
		HomePage landingpage= new HomePage(driver);
		
		Actions a = new Actions(driver);
		WebElement deskTop=driver.findElement(By.xpath("//a[text()='Laptops & Notebooks']"));
		a.moveToElement(deskTop).build().perform();
		driver.findElement(By.linkText("Show AllLaptops & Notebooks")).click();
		List<WebElement>productNames=driver.findElements(By.cssSelector("h4 a"));
		
		
		for(int i=0; i<productNames.size();i++) {
			String name=productNames.get(i).getText();
			
			if(name.equalsIgnoreCase(productName)) {
				driver.findElements(By.xpath("(//span[contains(text(),'Add to Cart')])")).get(i).click();
			}
		}
		Thread.sleep(2000);
driver.findElement(By.id("cart-total")).click();
driver.findElement(By.xpath("//strong[contains(text(),'View Cart')]")).click();
List<WebElement> cartproducts=driver.findElements(By.cssSelector("td a"));
boolean flag =cartproducts.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(productName));
Assert.assertTrue(flag);


	}
	

}
