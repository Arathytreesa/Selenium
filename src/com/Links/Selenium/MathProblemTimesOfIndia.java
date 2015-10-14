package com.Links.Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class MathProblemTimesOfIndia {
	static WebDriver driver;
 
  @BeforeTest
  public void beforeTest() {

	  
		driver=new FirefoxDriver();
		driver.get("http://timesofindia.indiatimes.com/poll.cms");
		driver.manage().window().maximize();
  }
  
  @Test
  public void getTimes() {
	  driver.findElement(By.xpath("//input[@name='PRadio']")).click();
	  //driver.findElement(By.xpath("//input[@id='mathuserans2']")).sendKeys("4");
	 String val= driver.findElement(By.xpath(".//*[@id='mathq2']")).getText();
	 System.out.println("The value is : "+val);
	 String[] input= val.split(" ");
	 String indexZero=input[0];
	 String indexTwo=input[2];
	 int first=Integer.parseInt(indexZero);
	 int Second= Integer.parseInt(indexTwo);
	 int Total=first+Second;
	 String var=Integer.toString(Total);
	 driver.findElement(By.xpath("//input[@id='mathuserans2']")).sendKeys(var);
	 driver.findElement(By.xpath("//form[@id='pollform']/table/tbody/tr[4]/td/div")).click();
	 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	 driver.getTitle();
  }
  
  

  @AfterTest
  public void afterTest() {
	  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  driver.close();
  }

}
