package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CookieHandlingTest {
	
	WebDriver driver; 
	
	public CookieHandlingTest(WebDriver driver) {
		
		this.driver = driver;

	}
	
	public void CookieGenerateErrorTest() {
		
		driver.findElement(By.xpath("//a[contains(text(),'Generate Token')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Proceed')]")).click();
		Assert.assertEquals(driver.getTitle(), "Error - T.A.T.O.C");
		
	}
	
	public void CookieErrorTest() {
		
		driver.navigate().back();
		driver.findElement(By.xpath("//a[contains(text(),'Proceed')]")).click();
		Assert.assertEquals(driver.getTitle(), "Error - T.A.T.O.C");
		
	}
	
	public void CookieGenerateTest() {
		
		driver.navigate().back();
		driver.findElement(By.xpath("//a[contains(text(),'Generate Token')]")).click();
		String cookie = driver.findElement(By.id("token")).getText();
		
		String[] cookiesplit = cookie.split(": ");
		
		Cookie ck = new Cookie("Token", cookiesplit[1]);
		driver.manage().addCookie(ck);
		driver.findElement(By.xpath("//a[contains(text(),'Proceed')]")).click();
		Assert.assertEquals(driver.getTitle(), "End - T.A.T.O.C");
		
	}
}