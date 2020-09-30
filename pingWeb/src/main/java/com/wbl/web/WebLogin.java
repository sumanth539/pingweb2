package com.wbl.web;

import java.util.logging.Logger;

import javax.naming.NamingException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebLogin  {
	public static WebDriver driver;
	//public static WebDriver driver;

    @FindBy(xpath="//input[@type='number']") public WebElement number;
    @FindBy(xpath="//button[@class='btn btn-primary mb-5 float-right mr-5 mt-2']")
	public WebElement login;
	@Before
	public void loginPage() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kanpuri\\Desktop\\driver\\chromedriver.exe");

		 driver = new ChromeDriver();

		driver.get("https://ping.telebu.com/login");
      
	}
	//WebElement number;
	//WebElement login ;
	    
	@Test
	public void validCredientials() {
	try {	number.sendKeys("8523088073");
		login.click();

		 String actualUrl="https://ping.telebu.com/chat";
	        String expectedUrl= driver.getCurrentUrl();
	        
	        Assert.assertEquals(expectedUrl,actualUrl);
	}catch(Exception e) {}
	}
	@Test
	public void InvalidCredientials1() {
		try {

		number.sendKeys("1478523693");
		login.click();

		 String actualUrl="https://ping.telebu.com/chat";
	        String expectedUrl= driver.getCurrentUrl();
	        
	        Assert.assertNotEquals(expectedUrl,actualUrl);
		}catch(Exception e) {}
}
	@Test
	public void NullCredientials() {
		
		try {
			number.sendKeys(null);
			login.click();

			 String actualUrl="https://ping.telebu.com/chat";
		        String expectedUrl= driver.getCurrentUrl();
		        
		        Assert.assertNotEquals(expectedUrl,actualUrl);

		} catch(NullPointerException e) {
			e.printStackTrace();
		}
		
	}
	@Test
	public void  IntCharCreiantials() {
try {
		number.sendKeys("789abc2312");
		login.click();

		 String actualUrl="https://ping.telebu.com/chat";
	        String expectedUrl= driver.getCurrentUrl();
	        
	        Assert.assertNotEquals(expectedUrl,actualUrl);
}catch(Exception e) {}
	}
	@Test
	public void  Fractions() {
		try {
		number.sendKeys("99898784.99");
		login.click();

		 String actualUrl="https://ping.telebu.com/chat";
	        String expectedUrl= driver.getCurrentUrl();
	        
	        Assert.assertNotEquals(expectedUrl,actualUrl);
		}catch(Exception e) {}
	}
	@Test
	public void NumberSPecialCaracters() {
		try {
		number.sendKeys("-8523496325");
		login.click();

		 String actualUrl="https://ping.telebu.com/chat";
	        String expectedUrl= driver.getCurrentUrl();
	        
	        Assert.assertNotEquals(expectedUrl,actualUrl);
		}catch(Exception e) {}
	}
	@Test
	public void EmptyCredientials() {
		try {
		number.sendKeys("   ");
		login.click();

		 String actualUrl="https://ping.telebu.com/chat";
	        String expectedUrl= driver.getCurrentUrl();
	        
	        Assert.assertNotEquals(expectedUrl,actualUrl);
		}catch(Exception e) {}
	}
	@Test
	public void SpacedCredientials() {
		try {
		number.sendKeys("85230 88073");
		login.click();

		 String actualUrl="https://ping.telebu.com/chat";
	        String expectedUrl= driver.getCurrentUrl();
	        
	        Assert.assertNotEquals(expectedUrl,actualUrl);
		}catch(Exception e) {}
	}
 

}
