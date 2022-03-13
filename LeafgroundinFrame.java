package week4.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafgroundinFrame {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/frame.html");
		
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
driver.findElement(By.id("wrapframe"));
driver.switchTo().frame(0);
WebElement click1 = driver.findElement(By.id("Click"));
click1.click();
System.out.println(click1.getText());
driver.switchTo().defaultContent();		
Thread.sleep(1000);

driver.findElement(By.xpath("(//div[@id='wrapframe']/iframe)[2]"));
driver.switchTo().frame(1);
driver.switchTo().frame("frame2");
WebElement click2 = driver.findElement(By.id("Click1"));
click2.click();
System.out.println(click2.getText());
driver.switchTo().parentFrame();
driver.switchTo().defaultContent();

List<WebElement> find=driver.findElements(By.tagName("iframe"));
int size = find.size();
System.out.println("total numberof frames are "+size);
	}}
