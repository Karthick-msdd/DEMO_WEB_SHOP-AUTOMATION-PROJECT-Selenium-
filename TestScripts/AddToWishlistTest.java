package TestScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_utilities.Base_Test;

public class AddToWishlistTest extends Base_Test{
	
	@Test
	public void addToWishlistTest()  throws Exception {
		
		driver.findElement(By.id("small-searchterms")).sendKeys("book",Keys.ENTER);
		driver.findElement(By.linkText("Health Book")).click();
		driver.findElement(By.id("add-to-wishlist-button-22")).click();
		
	}
	
	@Test
	public void updateProductCountTest() throws Exception {
		
	   driver.findElement(By.linkText("Wishlist")).click();
	   WebElement rb =  driver.findElement(By.xpath("//input [@class='qty-input']"));
	   
	   rb.clear();
	   rb.sendKeys("10");
	   
	   driver.findElement(By.xpath("//input[@value='Update wishlist']")).click();
	   String remove= driver.findElement(By.xpath("//span[@class='wishlist-qty']")).getText();
	   String rem = remove.replace("(", "").replace(")","");
	   Assert.assertEquals(Integer.parseInt(rem) == 10,true,"Whistlist is Not Update ");
		
	}
	
	@Test
	
	public void removeFromWishlistTest() throws Exception {
		
		driver.findElement(By.linkText("Wishlist")).click();
		driver.findElement(By.xpath("//input[@name='removefromcart']")).click();
		driver.findElement(By.xpath("//input[@value='Update wishlist']")).click();
		String remove= driver.findElement(By.xpath("//span[@class='wishlist-qty']")).getText();
		String rem = remove.replace("(", "").replace(")","");
		Assert.assertEquals(Integer.parseInt(rem) == 0,true,"Whistlist is Not Update ");
		
		
		
	}
	
	
	@Test
	
   public void addTocartFromWishlistTest()  throws Exception {
		
		
		driver.findElement(By.linkText("Wishlist")).click();
		driver.findElement(By.xpath("//input[@name='addtocart']")).click();
		driver.findElement(By.xpath("//input[@name='addtocartbutton']")).click();
		
		
	}
	
	
	

}
