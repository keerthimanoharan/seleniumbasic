package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnAlert {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Alert.html");
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.findElement(By.xpath("//button[text()='Alert Box']")).click();
		//simple alert
		Alert alert =driver.switchTo().alert();
		 String alertmsg = alert.getText();
System.out.println(alertmsg);
alert.accept();

//confirmation alert/
driver.findElement(By.xpath("//button[text()='Confirm Box']")).click();
alert.dismiss();
String text=driver.findElement(By.id("result")).getText();
System.out.println(text);

//prompt alert
driver.findElement(By.xpath("//button[text()='Prompt Box']")).click();
alert.sendKeys("keerthi");
alert.accept();

driver.findElement(By.xpath("//button[text()='Sweet Alert']")).click();
driver.findElement(By.xpath("//button[text()='OK']")).click();
System.out.println();
	}

}
