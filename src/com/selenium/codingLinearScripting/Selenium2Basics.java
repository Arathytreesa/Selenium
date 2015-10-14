package com.selenium.codingLinearScripting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Selenium2Basics {
static WebDriver driver;
	public static void main(String[] args) {
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("https://www.salesforce.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("button-login")).click();
		
		if(driver.findElement(By.xpath("//input[@id='username']")).isDisplayed())
		{
			driver.findElement(By.xpath("//input[@id='username']")).sendKeys("username@gmail.com");
			System.out.println("PASS:The username field exits and the values are entered");
			String str1 = driver.findElement(By.id("username")).getAttribute("value");
			System.out.println(driver.findElement(By.id("username")).getAttribute("id"));
			System.out.println(str1);
			//driver.findElements(By.id("username")).clear();	
		}
		else
		{
			System.out.println("FAIL:The username field does not exit and the values could not be entered");
		}
		if(driver.findElement(By.id("password")).isDisplayed())
		{
			driver.findElement(By.id("password")).sendKeys("PAassword");
			String str2 = driver.findElement(By.id("password")).getAttribute("value");
			System.out.println(driver.findElement(By.id("password")).getAttribute("id"));
			System.out.println(str2);
		}
		else
		{
			System.out.println("Passowrd box i not displayed");
		}
		if(driver.findElement(By.id("Login")).isDisplayed())
		{
			driver.findElement(By.id("Login")).click();
			System.out.println("Login to Salesforce is displayed and content is shown below");
			String content=driver.findElement(By.id("Login")).getText();
		System.out.println(content);
		}
		else
		{
			System.out.println("Login to Salesforce could not be found");
		}
		//validateTextBoxMSG("id=username",)
		//System.out.println(val);
		String errMsg= driver.findElement(By.id("error")).getText();
		System.out.println("The erroe message is :"+errMsg);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.close();

	}  

}
