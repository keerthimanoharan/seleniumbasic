package week4.day2;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class Amazon {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro",Keys.ENTER);
		driver.findElement(By.xpath("//span[text()='OnePlus 9 Pro 5G (Morning Mist, 12GB RAM, 256GB Storage)']")).click();
		WebElement price = driver.findElement(By.xpath("(//span[contains(@class,'a-price-whole')])[1]"));
		System.out.println("the price is: "+price.getText());
		
		List<WebElement> rating= driver.findElements(By.xpath("(//span[text()='4.3 out of 5 stars'])[1]"));
	int size = rating.size();
	System.out.println("the star rating is: "+size);
	driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
	String rate = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']")).getText();
	System.out.println("the total rate matches with the price:"+rate);
	
	}}
