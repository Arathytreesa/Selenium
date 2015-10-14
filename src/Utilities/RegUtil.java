package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RegUtil{
	static WebDriver driver;

	public static void getRegisterUtil(){
		
		  driver.findElement(By.xpath("//a[contains(text(),'REGISTER')]")).click();
		  driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Arathy");
		  driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Jose");
		  driver.findElement(By.xpath("//input[@id='email']")).sendKeys("Arti");
		  driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Password");
		  driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys("Password");
		  driver.findElement(By.xpath("//input[@name='register']")).click(); 
		  String actual="Note: Your user name is Arti.";
		  String expected=driver.findElement(By.xpath("//a/font/b")).getText();
		  Assert.assertEquals(actual,expected);
		  System.out.println("Actual "+actual);
		  System.out.println("Expected "+expected);
		  }
}
