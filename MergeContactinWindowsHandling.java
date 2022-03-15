package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContactinWindowsHandling {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		String title = driver.getTitle();
		System.out.println(title);

		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		String title1 = driver.getTitle();
		System.out.println(title1);
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		
		//click-from contact widget
		driver.findElement(By.xpath("(//div/form/table/tbody/tr/td/a)[1]")).click();  
		System.out.println("the title of the parentwindow "+driver.getTitle());
		
		//window handling
		Set<String> window=driver.getWindowHandles();			
		List<String> newwindow=new ArrayList<String>(window);
		driver.switchTo().window(newwindow.get(1));
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		System.out.println("thetitle of childwindow "+driver.getCurrentUrl());
		
		 //selecting 1st contact in window
		driver.findElement(By.xpath("((//div[@class='x-grid3-row   '][1])/table/tbody/tr/td[1])/div[1]/a")).click();
		driver.switchTo().window(newwindow.get(0));
		
		//click-to contact widget
		driver.findElement(By.xpath("(//div/form/table/tbody/tr/td/a)[2]")).click();   
		System.out.println("title of the parentwindow "+driver.getTitle());
		
		//window handling
		Set<String> window1=driver.getWindowHandles();			
		List<String> newwindow1=new ArrayList<String>(window1);
		driver.switchTo().window(newwindow1.get(1));
		String currentUrl2 = driver.getCurrentUrl();
		System.out.println(currentUrl2);
		System.out.println("thetitle of childwindow "+driver.getCurrentUrl());
		
		//selecting 2nd contact in window
		driver.findElement(By.xpath("(//div[contains(@class,'x-grid3-cell-inner x-grid3-col-partyId')])[2]/a")).click();
		driver.switchTo().window(newwindow.get(0));
		//click-Merge
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		System.out.println(driver.getTitle());
		}}
