package com.framework.base;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseUI {
	
	public WebDriver driver;
	public Set<String> handles;
	public void invokeBrowser(String browName) {
		
		if (browName.equalsIgnoreCase("Chrome")) {

			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+
					"\\src\\test\\resources\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			
		
		} else if (browName.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+
					"\\src\\test\\resources\\drivers\\gckodriver.exe");
			driver = new FirefoxDriver();

		}
		driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		
	}
	public void wait(int n) {
		driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
	}
	public void openURL(String webSiteURL) {
		driver.get(webSiteURL);
		
	}
	
	public void SwitchtoNextWin() {
		handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String parentId = (String) it.next();
		String childId = (String) it.next();
		driver.switchTo().window(childId);
	}
	public void checkIfTextPresent(String text) {
		if(driver.getPageSource().contains(text)) {
			System.out.println("Text is present");
		}else {
			System.out.println("Text not present");
		}
	}
	public void tearDown() {
		driver.close();
	}
	public void quitBrowser() {
		driver.quit();
	}
	public void enterTest(String xpath, String data) {
		driver.findElement(By.xpath(xpath)).sendKeys(data);
	}
	public void click(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}
	public void clickID(String Id) {
		driver.findElement(By.id(Id)).click();
	}
}
