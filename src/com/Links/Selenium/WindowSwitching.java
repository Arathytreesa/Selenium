package com.Links.Selenium;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class WindowSwitching {
	static WebDriver driver;
 
  @BeforeTest
  public void beforeTest() {
		driver=new FirefoxDriver();
		driver.get("http://www.toolsqa.com/automation-practice-switch-windows/");
		driver.manage().window().maximize();
  }

  @Test
  public void getWindow() {
	  
	  Set<String> handle1= driver.getWindowHandles();
	 	  //String  handle= driver.getWindowHandle();
	 System.out.println("Name: " + handle1);
	  //Name: {3f50d034-dc81-4270-bc6f-a8c19ce46db7}
	  driver.findElement(By.xpath("//button[@onclick='newMsgWin()']")).click();
	  Set<String> handle2= driver.getWindowHandles();
	 System.out.println("Name: " + handle2);
	  String[] WindowNames = handle2.toArray(new String[handle2.size()]);
	  String val=WindowNames[1];
	  String val1=WindowNames[0];
	  driver.switchTo().window(val);
	 String Actual="Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.";
	 String Expected=driver.findElement(By.xpath("//body")).getText();
	 Assert.assertEquals(Actual, Expected);
	 // driver.getTitle();
	 driver.close();
	 driver.switchTo().window(val1);
  }
  
  @AfterTest
  public void afterTest() {
	  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  driver.quit();
  }

}
