package week4.day2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
public class CherCherFrames {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().window().maximize();
		 
		driver.findElement(By.xpath("(//div[@class='card mb-3']/iframe)[1]"));
		driver.switchTo().frame(0);
		
		driver.findElement(By.tagName("input")).sendKeys("I love testing");

driver.switchTo().frame("frame3");
WebElement box=driver.findElement(By.id("a"));
box.click();
driver.switchTo().parentFrame();
driver.switchTo().defaultContent();

driver.switchTo().frame(1);
WebElement animal=driver.findElement(By.id("animals"));
Select cattypes=new Select(animal);
cattypes.selectByIndex(3);
}}
