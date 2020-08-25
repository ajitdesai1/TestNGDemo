package com.test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGBasics {
	WebDriver driver;
	
	@BeforeSuite
	public void setUp() {
		System.out.println("setUp the initial config");
		System.setProperty("webdriver.chrome.driver", "D:\\EclipseInstallFolder\\Softwares\\chromedriver.exe");
		
				
	}
	@BeforeTest
	public void launchBrowser() {
		System.out.println("launch Browser");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	@BeforeClass
	public void enterURL() {
		System.out.println("enter URL");
		driver.get("https://www.google.com/");
	}
	@BeforeMethod
	public void login() throws InterruptedException {
		System.out.println("enter login details");
		driver.findElement(By.name("q")).sendKeys("Selenium");
		Thread.sleep(2000);
	}	
	@Test
	public void validateTitle() {
		String title = driver.getTitle();
		System.out.println("Check Title of the page: "+title);
		Assert.assertEquals(title, "Google");
	}
	@Test
	public void clickOnabout() {
		driver.findElement(By.xpath("//a[text()='About']")).click();
		String title1 = driver.getTitle();
		Assert.assertEquals(title1, "Google - About Google, Our Culture &amp; Company News");
	}	
	@AfterMethod
	public void logout() {
		System.out.println("I'm logout");
	}	
	@AfterClass
	public void ClearCoockies() {
		System.out.println("Clear Coockies");
		driver.manage().deleteAllCookies();
	}
	@AfterTest
	public void closeBrowser() {
		System.out.println("Close the browser");
		driver.quit();
	}
	

}
