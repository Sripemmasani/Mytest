package Testingpack1;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class solotest2 {

	
	
	
	
	WebDriver driver;
	JavascriptExecutor js;
	
	
	@BeforeTest
	
		public void open(){
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Venkata\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		driver=new ChromeDriver();
	
		
		driver.get("http://the-internet.herokuapp.com/");
		
		driver.findElement(By.linkText("Infinite Scroll")).click();
		
		driver.manage().window().maximize();
		
		js = (JavascriptExecutor) driver;
	
}
	
	@Test(priority=0)
	public void scrolldown() throws InterruptedException{
		
		for(int i=1;i<3;i++){
			 
			 
			 js.executeScript("window.scrollTo(0,2000)");
			 
			 Thread.sleep(2000);
		 }	
	}	
		
	@Test(priority=1)	
	public void scrollup() throws InterruptedException{
		
		 for(int j=1;j<3;j++){
			 
             js.executeScript("window.scrollTo(0,-1500)");
				 
				 Thread.sleep(2000);
				 
			 }
		
	}
	
	
	@Test(priority=2)
	public void check(){
		
		 String actual=driver.findElement(By.xpath("//*[@id='content']/div/h3")).getText();
			
		  String expected="Infinite Scroll";
		  
		  Assert.assertEquals(actual, expected,"You are at top of the page");
	
	}
	
	
	
	@AfterTest
	public  void close() {
	 driver.close();	
}

	
	
	
	
	
	
	
	
}