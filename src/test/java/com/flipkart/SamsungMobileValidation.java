package com.flipkart;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class SamsungMobileValidation {
	static WebDriver driver;
	static long startTime;
	static String name1;
	@BeforeClass
	public static void beforeCalss() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@AfterClass
	public static void afterClass() {
		driver.quit();
	}
	@Before
	public void beforeScript() {
		startTime = System.currentTimeMillis();
	}
	@After
	public void afterScript() {
		long endTime = System.currentTimeMillis();
		System.out.println("Time taken is" + (endTime - startTime));
	}
	@Test
	public void mentod1() {
		WebElement closebtn = driver.findElement(By.xpath("//button[text() ='✕']"));
		closebtn.click();
	}
	@Test
	public void method2() {
		WebElement search = driver.findElement(By.name("q"));
		search.sendKeys("Samsung Mobile",Keys.ENTER);
	}
	@Test
	public void method3() {
		WebElement mobileName1 = driver.findElement(By.xpath("(//div[@class ='_4rR01T'])[1]"));
		name1 = mobileName1.getText();
		System.out.println(name1);
		mobileName1.click();
	}
	@Test
	public void method4() {
		String pWin = driver.getWindowHandle();
		Set <String> cWin = driver.getWindowHandles();
		for(String x:cWin) {
			if(!pWin.equals(x)) {
				driver.switchTo().window(x);
			}
		}
	}
	@Test
	public void method5() {
		WebElement mobileName2 = driver.findElement(By.xpath("//span[@class ='B_NuCI']"));
		String name2 = mobileName2.getText();
				System.out.println(name2);
				Assert.assertEquals(name1, name2);
	}

}
