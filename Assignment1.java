package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1 {

	public static void main(String[]args)
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
driver.findElement(By.id("username")).sendKeys("demosalesmanager");
driver.findElement(By.id("password")).sendKeys("crmsfa");
driver.findElement(By.className("decorativeSubmit")).click();
String title = driver.getTitle();
System.out.println(title);
driver.findElement(By.linkText("CRM/SFA")).click();
driver.findElement(By.linkText("Leads")).click();
String title2 = driver.getTitle();
System.out.println(title2);

driver.findElement(By.linkText("Create Lead")).click();
driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Testleaf");
driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Keerthi");
driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Mano");
driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("keerthana");
driver.findElement(By.className("inputBox")).sendKeys("EEE");
driver.findElement(By.name("description")).sendKeys("interested in testing");
driver.findElement(By.className("inputBox")).sendKeys("keetu@gmail.com");

WebElement stateProvince=driver.findElement(By.name("generalStateProvinceGeoId"));
Select state=new Select(stateProvince);
state.selectByVisibleText("New York");

driver.findElement(By.className("smallSubmit")).click();
String title3 = driver.getTitle();
System.out.println(title3);


	}
}
