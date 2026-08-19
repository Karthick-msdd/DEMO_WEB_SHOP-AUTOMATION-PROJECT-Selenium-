package TestScripts;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import Generic_utilities.Base_Test;

public class Purchase_Test extends Base_Test {
	
	
	@Test(priority = 1)
	public void purchaseProductViaCOD() throws Exception {
		
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		driver.findElement(By.linkText("Shopping cart")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("termsofservice")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("checkout")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@onclick='Billing.save()']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("PickUpInStore")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@onclick='Shipping.save()']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@onclick='ShippingMethod.save()']")).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@class='button-1 payment-method-next-step-button']")))).click();
		// driver.findElement(By.xpath("")).click();  // select the payment method 
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='button-1 payment-info-next-step-button']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@onclick='ConfirmOrder.save()']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='button-1 confirm-order-next-step-button']")).click();
		
		
	}
	
	
	@Test(priority = 2)
	public void purchaseProductViaCC() throws Exception {
		
	    driver.findElement(By.linkText("Shopping cart")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.id("termsofservice")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.id("checkout")).click();
	    Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@onclick='Billing.save()']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@onclick='Shipping.save()']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@onclick='ShippingMethod.save()']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='paymentmethod_2']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='button-1 payment-method-next-step-button']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("CardholderName")).sendKeys();
		
		
		
		
	}
	
	

}
