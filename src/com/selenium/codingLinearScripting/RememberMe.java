package com.selenium.codingLinearScripting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RememberMe {
	static WebDriver driver;
		public static void main(String[] args) {
			driver=new FirefoxDriver();
			driver.get("http://www.salesforce.com/");
			//driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			if (driver.findElement(By.xpath("//a[contains(text(),'Login')]")).isDisplayed())
			{
				driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
				
			}
			else
			{
				System.out.println("Login could not be found");
			}
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			if(driver.findElement(By.xpath("//input[@id='username']")).isDisplayed())
			{
				driver.findElement(By.xpath("//input[@id='username']")).sendKeys("arti161@gmail.com");
				driver.findElement(By.xpath("//input[@id='username']")).getAttribute("value");
				driver.findElement(By.xpath("//input[@id='username']")).getAttribute("id");
				
			}
			else
			{
				System.out.println("Username textbox could not be found");
			}
			if(driver.findElement(By.xpath("//input[@id='password']")).isDisplayed())
			{
				driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Anjalijose1");
			}
			else
			{
				System.out.println("Password textbox could not be found");
			}
			if(driver.findElement(By.xpath("//input[@id='rememberUn']")).isDisplayed())
			{
				driver.findElement(By.xpath("//input[@id='rememberUn']")).click();
			}
			else
			{
				System.out.println("Remember me username checkbox could not be found");
			}
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			if(driver.findElement(By.xpath("//button[@id='Login']")).isDisplayed())
			{
				driver.findElement(By.xpath("//button[@id='Login']")).click();
			}
			else
			{
				System.out.println("Login button could not be found");
			}
		driver.findElement(By.xpath("//span[@id='userNavLabel']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='username']")).getAttribute("value");
		driver.findElement(By.xpath("//input[@id='username']")).getAttribute("id");
	String message=driver.findElement(By.xpath("//a[contains(text(),'1 saved username')]")).getText();
	System.out.println("The message after checking 'remember username' is:"+message);
		driver.close();
		
		
	}

}
