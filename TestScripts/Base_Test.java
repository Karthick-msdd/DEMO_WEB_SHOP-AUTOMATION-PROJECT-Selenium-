package Generic_utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class Base_Test {
	
	public WebDriver driver;
	public WebDriverWait wait;
	
	
	@Parameters("browser")    // Chrome , Edge , Firefox
	
	@BeforeClass(alwaysRun = true)
	public void openBrowser(@Optional("chrome") String browser) {
		
		if(browser.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		}
		else  {
			driver = new FirefoxDriver();
		}
		

		driver.manage().window().maximize();
		driver.get(File_Utility.getProperty("url"));
		Reporter.log("\t\t Browser Launched Successfully",true);
	}
	
	
     @BeforeMethod(alwaysRun = true)
     public void loginToDWS() {
    	 
    	 
    	 driver.findElement(By.linkText("Log in")).click();
    	 Reporter.log("\t\t\t Log in Successfully",true);
    	 driver.findElement(By.id("Email")).sendKeys(File_Utility.getProperty("Email"));
    	 driver.findElement(By.id("Password")).sendKeys(File_Utility.getProperty("Password"));
    	 driver.findElement(By.xpath("//input[@value='Log in']")).click();
    	 
     }
     
     @AfterMethod(alwaysRun = true)
     public void logoutToDWS() {
    	 driver.findElement(By.linkText("Log out")).click();
    	 Reporter.log("\t\t User Logged Out Succesfully",true);
     }
     
     
     @AfterClass(alwaysRun = true)
     public void closeBrowser() {
    	
    	 driver.quit();
    	 Reporter.log("\t\t Browser Closed  Successfully",true);
     }
     
     

}
