package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	

	//WebElement deskTop=driver.findElement(By.xpath("//a[text()='Laptops & Notebooks']"));
	
	@FindBy(xpath="//a[text()='Laptops & Notebooks'")
	WebElement deskTop;
	@FindBy(linkText="Show AllLaptops & Notebooks")
	WebElement poductscatalogue;
	
	public void goToDekstopsSection() {
		Actions a = new Actions(driver);
		a.moveToElement(deskTop).build().perform();
		poductscatalogue.click();
		
	}
	
	public void addProductsToCart() {
		
		
	}

}
