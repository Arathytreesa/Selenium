package com.Links.Selenium;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Links {
	static WebDriver driver;
 
  @BeforeTest
  public void beforeTest() {
		driver=new FirefoxDriver();
		//driver.get("http://www.google.com");
		//driver.get("http://toolsqa.com/");
		driver.get("https://www.madewithangular.com");
		driver.manage().window().maximize();
  }
  
  @Test
  public void getVisitLinks() throws InterruptedException {
	  
	  //Listing the total number of links in the page.
	  
	  List<WebElement> allLinks = driver.findElements(By.tagName("a"));
	  Thread.sleep(10000);
	  driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	    System.out.println(allLinks.size());
	   /* for(WebElement link:links){
	    	System.out.println(link.getText());
	    }*/
		for (int i = 0;i<=allLinks.size()-1;i=i+1)
		{

			System.out.println(allLinks.get(i).getText());

		}
		 
		//Identifying the visit links.Looping over the links and getting the link and opening each one in diff window.
		
			List<WebElement> links = driver.findElements(By.xpath("//a[@class='visit md-button md-default-theme']"));
			for (int i=1; i<=links.size()-1; i=i+1){
			List<WebElement> links1 = driver.findElements(By.xpath("//div[@class='md-actions']/a[2]/span"));
			Thread.sleep(6000);
			driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
			
			//System.out.println(links1.size());
			for (i=0; i<=links1.size()-1; i=i+1)

			{
				WebElement str=links1.get(i);
				//System.out.println(str);
				str.click();
				Set<String> handle1 = driver.getWindowHandles();
				System.out.println("Name:" +handle1);
				// driver.findElement(By.xpath("//div[@class='container row ng-scope']/md-card[1]/div/a[2]")).click();
				String[] WindowNames = handle1.toArray(new String[handle1.size()]);
				String val = WindowNames[1];
				String val1 = WindowNames[0];
		 	driver.switchTo().window(val);
		 	driver.getTitle();
		 	driver.close();
		 	driver.switchTo().window(val1);
			}
		
		}
  }
		

  @AfterTest
  public void afterTest() {
	 // driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  driver.quit();
  }

}
