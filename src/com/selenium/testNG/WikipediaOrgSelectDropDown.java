package com.selenium.testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class WikipediaOrgSelectDropDown {
	static WebDriver driver;
	  
  @BeforeClass
  public void setUp(){
		
			  
				driver=new FirefoxDriver();
				driver.get("https://www.wikipedia.org/");
				driver.manage().window().maximize();
		  }
  
 

  @Test
  public void getLanguage() {
	 Select sel=new Select(driver.findElement(By.xpath("//select[@id='searchLanguage']")));
	 sel.selectByIndex(1);
	 driver.findElement(By.xpath("//input[@name='go']"));
  }
  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
