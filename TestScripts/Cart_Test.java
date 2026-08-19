package TestScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_utilities.Base_Test;

public class Cart_Test extends Base_Test {
	
	
	@Test(priority = 1)
	public void AddToCart()  {
		
		driver.findElement(By.id("small-searchterms")).sendKeys("Book",Keys.ENTER);
		driver.findElement(By.xpath("//input[@value='Add to cart']")).click();
		
		
		
	}
	
	@Test(priority = 2)
	public void updateProductcountTest() throws Exception {
		
		driver.findElement(By.partialLinkText("Shopping cart")).click();
		WebElement product = driver.findElement(By.xpath("//input[contains(@name,'itemquantity')]"));
		product.clear();
		Thread.sleep(3000);
		product.sendKeys("4");
	    Assert.assertEquals(product.getAttribute("value"),"4","The Product Count is Not Update");
	    
	    driver.findElement(By.xpath("//input[@name='updatecart']")).click();
	    
		
		
		
	}
	
	@Test(priority = 3)
	public void RemoveToCart() throws Exception {
		
		driver.findElement(By.partialLinkText("Shopping cart")).click();
		driver.findElement(By.xpath("//input[@name='removefromcart']")).click();
		Thread.sleep(2000);
	    WebElement removeElement = 	driver.findElement(By.xpath("//input[@value='Update shopping cart']"));
	    removeElement.click();
	    
	    
	    String remove = driver.findElement(By.xpath("//span[@class='cart-qty']")).getText(); //    (0)
	    String rem = remove.replace("(", "").replace(")","");
	    Assert.assertEquals(Integer.parseInt(rem) == 0,true,"Product is Not Remove ");
	    
		
	}

}
