package Testingpack1;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Solotestng {
	
	
	WebDriver driver;
	
	
	@BeforeTest
	
		public void open(){
		

		System.setProperty("webdriver.chrome.driver","C:\\Users\\Venkata\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		driver=new ChromeDriver();
		
			
		
          driver.get("http://the-internet.herokuapp.com/");
		
		
		driver.findElement(By.linkText("Form Authentication")).click();
	}	
	
	
	@Test(priority=0)
	
	public void correctusername(){
		
		driver.findElement((By.id("username"))).sendKeys("tomsmith");
			driver.findElement(By.id("password")).sendKeys("abcd");
			driver.findElement(By.xpath("//*[@id='login']/button/i")).click();
			

			String actual=driver.findElement(By.xpath("//*[@id='content']/div/h4")).getText();	  
			  

			 String expected="Welcome to the Secure Area. When you are done click logout below.";
			
			  Assert.assertEquals(actual, expected,"you Entered invalid Password");
			
			
	}
	
	
	
	
	@Test (priority=1)
	
	public void correctpassword(){
		
		
    driver.findElement((By.id("username"))).sendKeys("smark");
	driver.findElement(By.id("password")).sendKeys("SupperSecretPassword!");
    driver.findElement(By.xpath("//*[@id='login']/button/i")).click(); 
		
    String actual=driver.findElement(By.xpath("//*[@id='content']/div/h4")).getText();	  
	  

	 String expected="Welcome to the Secure Area. When you are done click logout below.";
      
	
	  Assert.assertEquals(actual, expected,"you Entered invalid UserName");
    
    
    
    
		
	}
	

	
	@Test (priority=2)
	
	public void bothcorrect() {
		
		driver.findElement((By.id("username"))).sendKeys("tomsmith");
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.xpath("//*[@id='login']/button/i")).click();
		
		
		String actual=driver.findElement(By.xpath("//*[@id='content']/div/h4")).getText();	  
		  

		 String expected="Welcome to the Secure Area. When you are done click logout below.";
		 
		 Assert.assertEquals(actual, expected,"Welcome to the secure area");
		
		
		
	}
	
	@Test (priority=3)
	
	public void logout(){
		
		driver.findElement(By.xpath("//*[@id='content']/div/a")).click();
	}
	
	@AfterTest
	public  void close() {
	 driver.close();	
}


}
