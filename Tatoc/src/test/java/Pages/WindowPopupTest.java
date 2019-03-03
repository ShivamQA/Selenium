package Pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class WindowPopupTest {
	
	WebDriver driver;
	HttpURLConnection huc = null;
	
	public WindowPopupTest(WebDriver driver) {
		
		this.driver = driver;

	}
	
	public void WindowLinks() throws IOException {
		
		String launchLink = driver.findElement(By.xpath("//a[contains(text(),'Launch Popup Window')]")).getAttribute("href");
		huc = (HttpURLConnection)(new URL(launchLink).openConnection());
	    huc.connect();
	    int respCode = huc.getResponseCode();
	    Assert.assertEquals(respCode, 200);
	    String proceedLink = driver.findElement(By.xpath("//a[contains(text(),'Proceed')]")).getAttribute("href");
		huc = (HttpURLConnection)(new URL(launchLink).openConnection());
	    huc.connect();
	    int respCode2 = huc.getResponseCode();
	    Assert.assertEquals(respCode2, 200);
	    
	}
	public void WindowButton() {
		
		Boolean expected = true;
		driver.findElement(By.xpath("//a[contains(text(),'Launch Popup Window')]")).click();
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		Boolean bar = driver.findElement(By.id("name")).isEnabled();
		Assert.assertEquals(bar, expected);
		Boolean bar2 = driver.findElement(By.id("submit")).isEnabled();
		Assert.assertEquals(bar2, expected);
		driver.switchTo().window(tabs2.get(0));
		
	}
	public void WindowErrorTest() {
		
		driver.findElement(By.xpath("//a[contains(text(),'Proceed')]")).click();
	    Assert.assertEquals(driver.getTitle(), "Error - T.A.T.O.C");
		
	}
	
	public void WindowNameTest() {
		
		driver.navigate().back();
		driver.findElement(By.xpath("//a[contains(text(),'Launch Popup Window')]")).click();
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		driver.findElement(By.id("submit")).click();
	    driver.switchTo().window(tabs2.get(0));
		driver.findElement(By.xpath("//a[contains(text(),'Proceed')]")).click();
	    Assert.assertEquals(driver.getTitle(), "Error - T.A.T.O.C");
		
	}
	public void WindowTest() {
		
		driver.navigate().back();
		driver.findElement(By.xpath("//a[contains(text(),'Launch Popup Window')]")).click();
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		driver.findElement(By.id("name")).sendKeys("Shivam");
		driver.findElement(By.id("submit")).click();
	    driver.switchTo().window(tabs2.get(0));
		driver.findElement(By.xpath("//a[contains(text(),'Proceed')]")).click();
	    Assert.assertEquals(driver.getTitle(), "Cookie Handling - Basic Course - T.A.T.O.C");
	
	}

}
