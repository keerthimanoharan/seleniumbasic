package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IrctcinWindowHandling {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.irctc.co.in/");
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		ChromeOptions option=new ChromeOptions();  		//disable popup (allow/block)
		option.addArguments("disable-notification");
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		driver.findElement(By.xpath("//a[contains(text(),' FLIGHTS ')]")).click();
		
		Set<String> window=driver.getWindowHandles();     //windowHandling
		List<String> flightstab=new ArrayList<String>(window);
		driver.switchTo().window(flightstab.get(1));
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		driver.findElement(By.xpath("//button[text()='Allow']")).click();
		driver.findElement(By.xpath("//a[text()='Contact Us']")).click();
		WebElement findElement = driver.findElement(By.xpath("//a[text()=' flights@irctc.co.in']"));
		System.out.println("the mail id is: "+findElement.getText());
	}}
