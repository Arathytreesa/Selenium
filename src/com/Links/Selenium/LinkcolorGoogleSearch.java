package com.Links.Selenium;

import java.util.ArrayList;
import java.util.Iterator;
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

public class LinkcolorGoogleSearch {
	static WebDriver driver;
	//private static String[] allLinks = null;
	List <String> newWindowLinks = new ArrayList <String>();
 
  @BeforeTest
  public void beforeTest() {
	  driver=new FirefoxDriver();
		driver.get("http://www.google.com");
		driver.manage().window().maximize();
  }
  
  @Test
  public void getSearch() throws InterruptedException {
	  
	  driver.findElement(By.xpath("//input[@id='lst-ib']")).sendKeys("Selenium Webdriver");
	  driver.findElement(By.xpath("//button[@name='btnG']")).click();
	  Thread.sleep(3000);
	 // driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  List<WebElement> links = driver.findElements(By.tagName("a"));
	  Thread.sleep(10000);
	  driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	    System.out.println(links.size());
	   // allLinks= new String[links.size()];
	    for(WebElement link:links){
	    	System.out.println(link.getText());
	    }
	   /* for (int i = 0;i<=links.size()-1;i=i+1){
	    	driver.navigate().to(allLinks[i]);
	    	Thread.sleep(3000);
	    	*/
	    	for (WebElement link : links){
	    		newWindowLinks.add(link.getText());
	    		
	    	}
	    	//click links that open in new window
	    	/*for (String anchorText : newWindowLinks){
	    	driver.findElement(By.linkText(anchorText)).click();
	    	Set <String> handles =driver.getWindowHandles();
	    	Iterator<String> it = handles.iterator();
	    	while (it.hasNext()){
	    	String parent = it.next();
	    	String newwin = it.next();
	    	driver.switchTo().window(newwin);
	    	//close the newly opened window
	    	driver.close();
	    	//go back to parent window
	    	driver.switchTo().window(parent);
	    	}
	    	
	    	*/
	    	for (String anchorText:newWindowLinks){
	    		driver.findElement(By.linkText(anchorText)).click();
	    		//back to parent window
	    		driver.navigate().back();
	    		}
	    }
  

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
