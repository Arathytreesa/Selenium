package com.selenium.testNG;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DataProviderStructure {

	static WebDriver driver;
  @BeforeClass
  public void setup() {
	  
		driver=new FirefoxDriver();
		driver.get("http://newtours.demoaut.com/");
		driver.manage().window().maximize();
  }
  
  @DataProvider(name="DynamicUsername")
	  public Object[][] userdata(){
	  return new Object[][]{
			  {"Ab","12","12"},
			  {"Abc","123","123"},
			  {"Abcd","1234","1234"},
			  {"Abcde","12345","12345"},
			  {"Abcdef","123456","123456"}
	  };
  }
   
 /* @Test
  public void getRegister() {
	  driver.findElement(By.xpath("//a[contains(text(),'REGISTER')]")).click();
	  driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Arathy");
	  driver.findElement(By.xpath("/input[@name='lastName']")).sendKeys("Jose");
	  
	   }*/
  @Test(dataProvider="DynamicUsername")
  public void getDynamicUser(String UserName, String Password , String ConfirmPassword) {
	  driver.findElement(By.xpath("//a[contains(text(),'REGISTER')]")).click();
	  driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Arathy");
	  driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Jose");
	  driver.findElement(By.xpath("//input[@id='email']")).sendKeys(UserName);
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Password);
	  driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys(ConfirmPassword);
	  driver.findElement(By.xpath("//input[@name='register']")).click(); 
	  String actual="Note: Your user name is "+UserName+".";
	  String expected=driver.findElement(By.xpath("//a/font/b")).getText();
	  Assert.assertEquals(actual,expected);
	  System.out.println("Actual "+actual);
	  System.out.println("Expected "+expected);
	  
  }

  @AfterClass
  public void teardown() {
	  driver.close();
	  
  }

}
