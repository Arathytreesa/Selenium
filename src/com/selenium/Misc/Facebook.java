package com.selenium.Misc;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Facebook {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver= new FirefoxDriver();
		Thread.sleep(8000);
		driver.get("https://www.facebook.com/");
List<WebElement> allTextBoxObjects=driver.findElements(By.tagName("input"));
for(int i=0;i<allTextBoxObjects.size();i++)
{
	try{
	if(allTextBoxObjects.get(i).getAttribute("aria-label").equalsIgnoreCase("First Name"))
	{
		allTextBoxObjects.get(i).sendKeys("Arathy");
	}
	if(allTextBoxObjects.get(i).getAttribute("aria-label").equalsIgnoreCase("Last Name"))
	{
		allTextBoxObjects.get(i).sendKeys("Jose");
	}
	if(allTextBoxObjects.get(i).getAttribute("aria-label").equalsIgnoreCase("Email or Mobile Number"))
	{
		allTextBoxObjects.get(i).sendKeys("abcd@gmail.com");
	}
	if(allTextBoxObjects.get(i).getAttribute("aria-label").equalsIgnoreCase("Re-enter Email or Mobile Number"))
	{
		allTextBoxObjects.get(i).sendKeys("abcd@gmail.com");
	}
	if(allTextBoxObjects.get(i).getAttribute("aria-label").equalsIgnoreCase("New Password"))
	{
		allTextBoxObjects.get(i).sendKeys("abcd@gmail.com");
	}
}catch (Exception e)
{
	System.out.println("Element not found!!");
}

}
	}
}


	
