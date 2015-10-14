package com.selenium.testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class Gmail {
static WebDriver driver;
  @Test
  public void SendEmail() {
	  driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("artijose5@gmail.com");
	  driver.findElement(By.xpath("//input[@id='next']")).click();
	  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  driver.findElement(By.xpath("//input[@id='Passwd']")).sendKeys("Password12345!");
	  driver.findElement(By.xpath("//input[@id='signIn']")).click();
	  
	  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  
	 /* driver.switchTo().frame("js_frame");	
	  System.out.println("Entered js frame!");
	  driver.switchTo().frame("sound_frame");
	  System.out.println("Entered sound frame!");*/
	  driver.switchTo().frame("hist_frame");
	  System.out.println("Entered hist frame!");
	  driver.findElement(By.xpath(".//*[@id=':5w']/div/div")).click();
	  
	  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  
	  
	  driver.findElement(By.xpath("//textarea[@id=':az']")).sendKeys("arti161@gmail.com");
	  driver.findElement(By.xpath("//input[@id=':ak']")).sendKeys("test");
	  driver.findElement(By.xpath("//input[@id=':ak']")).sendKeys("hello");
	  driver.findElement(By.xpath("//div[@id=':aa']")).click();
	  
	  //.//*[@id=':5w']/div/div
	  //.//*[@id=':bo']
	  ////div[@id=':9m']
	  
  }
  @BeforeClass
  public void Setup() {
	  {
		  
			driver=new FirefoxDriver();
			driver.get("https://www.gmail.com/");
			driver.manage().window().maximize();
	  }
	  
  }

  @AfterClass
  public void Teardown() {
	  driver.close();
  }

}
