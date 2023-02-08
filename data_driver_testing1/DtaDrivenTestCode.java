package data_driver_testing1;

import java.io.IOException;

import org.bouncycastle.oer.its.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DtaDrivenTestCode {

	public static void main(String[] args) throws InterruptedException, IOException {
	
	WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
		
		driver.manage().window().maximize();
		
		String path="D:\\selenum ROGRAM\\SelenimWithJava\\SBIDA\\SBIData.xlsx";
		Thread.sleep(3000);
		int rows=XLUtils_method.getRowcount(path,"Sheet1");
		// call his method from xlutils class -->inside static class
		for(int r=1;r<=rows;r++) { // fixed no. of columns so no need to write another for loop.(1 for loop[ manage) 
			//read data from excel
			
			
			String pric=XLUtils_method.getCellData(path,"Sheet1",r,0);
			String rateofinterest=XLUtils_method.getCellData(path,"Sheet1",r,1);
			String per1=XLUtils_method.getCellData(path,"Sheet1",r,2);
			String per2=XLUtils_method.getCellData(path,"Sheet1",r,3);
			String fre=XLUtils_method.getCellData(path,"Sheet1",r,4);
			String exp_mvalue=XLUtils_method.getCellData(path,"Sheet1",r,5);
			
			//pass data to  the application using respected column x path. 
			
			driver.findElement(By.id("principal")).sendKeys(pric);
			driver.findElement(By.id("interest")).sendKeys(rateofinterest);
			driver.findElement(By.id("tenure")).sendKeys(per1);// sendkeys only passes string data and not int.
           
			//(period) dropdown handle using select class object
			Select perdrp=new Select(driver.findElement(By.id("tenurePeriod")));
			perdrp.selectByVisibleText(per2);
			
			//(frequency)  dropdown handle using select class object
			Select fredrp=new Select(driver.findElement(By.id("frequency")));
			perdrp.selectByVisibleText(fre);
			
			
			
			
			
			
			JavascriptExecutor jse=(JavascriptExecutor)driver;
			WebElement ele=driver.findElement(By.xpath("//img[@src='https://images.moneycontrol.com/images/mf_revamp/btn_calcutate.gif']"));
			
			jse.executeScript("arguments[0].click()", ele);
			
			//validation and update result in excel.
			//to get actual maturity value 
			String act_mvalue=driver.findElement(By.xpath("//*[@id=\"resp_matval\"]/strong")).getText();
			
			if(Double.parseDouble(exp_mvalue)==Double.parseDouble(act_mvalue))
			{
				
				System.out.println("Test passed");
				XLUtils_method.setCellData(path,"Sheet1",r,7,"Passed");
				XLUtils_method.fillGreenColor(path,"Sheet1",r,7);
			}
			else
			{
				System.out.println("Test Failed");
	     			XLUtils_method.setCellData(path,"Sheet1",r,7,"Failed"); //to write the data use setcelldata
				XLUtils_method.fillRedColor(path, "Sheet1", r, 7);
			}
			Thread.sleep(3000);
			// after completing one row,we have to first clear data by clicking clear button
			
			JavascriptExecutor jse1=(JavascriptExecutor)driver;
			WebElement ele1=driver.findElement(By.xpath("//*[@id=\"fdMatVal\"]/div[2]/a[2]/img"));
			
			jse1.executeScript("arguments[0].click();", ele1);
	
		}
		
		
			driver.close();
			
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}


