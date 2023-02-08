package extentreport;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Extent_reprort_manually {
	WebDriver driver;
	@Test(priority=1)
   public void launchBrowser() {
	System.setProperty("Webdriver.chrome.driver", "C:\\selenium Webdriver\\chromedriver.exe");
	
	 driver=new ChromeDriver();
	
		
	
	
}
	@Test(priority=2)
	public void launchApp() {
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		
		
		
	}
	
	@Test(priority=3)
	public void loginToApp() {
	
		driver.findElement(By.xpath("//input[@id='Email']")).clear();
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("admin@yourstore.com");
		
		driver.findElement(By.xpath("//input[@id='Password']")).clear();
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("admin");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String act_Title=driver.getTitle();
		if(act_Title.equals("act_Title"))  
		{
			
			System.out.println("Test case passed");
		
		}
		else
		{
			System.out.println("Test case failed");
		}
		
	}
	@Test(priority=4)
	public void closetheBrowser() {
	  driver.close();
	}
}
