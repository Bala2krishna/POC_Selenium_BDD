package pageobjects;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class StandaloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://tutorialsninja.com/demo/");
		
		Actions a = new Actions(driver);
		WebElement deskTop=driver.findElement(By.xpath("//a[text()='Laptops & Notebooks']"));
		a.moveToElement(deskTop).build().perform();
		driver.findElement(By.linkText("Show AllLaptops & Notebooks")).click();
		List<WebElement>productNames=driver.findElements(By.cssSelector("h4 a"));
		
		for(int i=0; i<=productNames.size();i++) {
			String name=productNames.get(i).getText();
			if(name.equalsIgnoreCase("Macbook")) {
				driver.findElements(By.xpath("(//span[contains(text(),'Add to Cart')])")).get(i).click();
			}
		}

	}

}
