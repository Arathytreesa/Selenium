package com.selenium.Misc;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AllLinks {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver= new FirefoxDriver();
		Thread.sleep(8000);
		driver.get("http://timesofindia.indiatimes.com/international-home");
List<WebElement> allLinksObjects=driver.findElements(By.tagName("a"));
System.out.println("All links are"+allLinksObjects.size());
for(int i=0;i<allLinksObjects.size();i++)
{
	try{
		System.out.println("--"+allLinksObjects.get(i).getText());
	
	
}catch (Throwable t){
System.out.println("Throwable"+t);
	}
}
	}
}


	
