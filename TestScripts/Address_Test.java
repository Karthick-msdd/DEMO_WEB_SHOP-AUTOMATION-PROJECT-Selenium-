package TestScripts;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import Generic_utilities.Base_Test;
import Generic_utilities.File_Utility;

public class Address_Test extends Base_Test{
	
	@Test(priority = 1)
	public void AdrressTest() throws Exception {
		
		
		driver.findElement(By.linkText("Addresses")).click();
		driver.findElement(By.xpath("//input[@value='Add new']")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("Address_FirstName")).sendKeys(File_Utility.getProperty("firstname"));
		driver.findElement(By.id("Address_LastName")).sendKeys(File_Utility.getProperty("lastname"));
		driver.findElement(By.id("Address_Email")).sendKeys(File_Utility.getProperty("email"));
		driver.findElement(By.id("Address_Company")).sendKeys(File_Utility.getProperty("company"));
		WebElement country = driver.findElement(By.id("Address_CountryId"));
		Select sel = new Select(country);
		sel.selectByValue("41");
		
		driver.findElement(By.id("Address_City")).sendKeys(File_Utility.getProperty("City"));
		driver.findElement(By.id("Address_Address1")).sendKeys(File_Utility.getProperty("address1"));
		driver.findElement(By.id("Address_Address2")).sendKeys(File_Utility.getProperty("address2"));
		driver.findElement(By.id("Address_ZipPostalCode")).sendKeys(File_Utility.getProperty("zip"));
		driver.findElement(By.id("Address_PhoneNumber")).sendKeys(File_Utility.getProperty("phonenumber"));
		driver.findElement(By.id("Address_FaxNumber")).sendKeys(File_Utility.getProperty("faxnumber"));
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@value='Save']")).click();
		
  }
	
	
	@Test(priority = 2)
	public void UpdateAddress() throws Exception {
		
		driver.findElement(By.linkText("Addresses")).click();
		driver.findElement(By.xpath("//input[@class='button-2 edit-address-button']")).click();
		Thread.sleep(2000);
		
	    WebElement ln = driver.findElement(By.id("Address_LastName"));
		ln.clear();
		ln.sendKeys("STAR");
		
        driver.findElement(By.id("Address_City")).click();
	    WebElement add = driver.findElement(By.id("Address_City"));
	    add.clear();
	    add.sendKeys("MADURAI");
	    
	    Thread.sleep(2000);
	     driver.findElement(By.xpath("//input[@class='button-1 save-address-button']")).click();
	    
	}
	
	@Test(priority = 3)
	public void RemoveAddress() throws Exception {
		
		driver.findElement(By.linkText("Addresses")).click();
		driver.findElement(By.xpath("(//input[@value='Delete'])[1]")).click();
		
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
		
		Thread.sleep(2000);
		
	}

}
