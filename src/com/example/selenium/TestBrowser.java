package com.example.selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBrowser {

		@Test
		public void Test1() throws InterruptedException
		{
//		System.setProperty("webdriver.chrome.driver", "C:/bin/chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("sekar@iperceiveit.co");
		driver.findElement(By.id("userPassword")).sendKeys("Password1234!");
		driver.findElement(By.id("login")).click();
		List<WebElement> productList = driver.findElements(By.cssSelector(".mb-3"));
		WebElement actualProduct = productList.stream().filter(product-> 
		product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
		actualProduct.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		Thread.sleep(3000);
		driver.quit();
		}
	

}
