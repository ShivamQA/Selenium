package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FrameTest {
	
	WebDriver driver;
	
	public FrameTest(WebDriver driver) {
		
		this.driver = driver;

	}
	public void BoxCheck() {
		
		Boolean check = true;
		driver.switchTo().frame("main");
		Boolean box1 = driver.findElement(By.xpath("//div[contains(text(),'Box 1')]")).isEnabled();
		Assert.assertEquals(box1, check);
		driver.switchTo().frame("child");
		Boolean box2 = driver.findElement(By.xpath("//div[contains(text(),'Box 2')]")).isEnabled();
		Assert.assertEquals(box2, check);
		driver.switchTo().parentFrame();
	}
	
	public void FrameErrorTest() {
		
		
		String color3 = driver.findElement(By.xpath("//div[contains(text(),'Box 1')]")).getAttribute("class");
		driver.switchTo().frame("child");
		String color4 = driver.findElement(By.xpath("//div[contains(text(),'Box 2')]")).getAttribute("class");
		driver.switchTo().parentFrame();
		driver.findElement(By.xpath("//a[contains(text(),'Proceed')]")).click();
		if(color3.equals(color4))
			Assert.assertEquals(driver.getTitle(), "Drag - Basic Course - T.A.T.O.C");
		else 
			Assert.assertEquals(driver.getTitle(), "Error - T.A.T.O.C");
		
	}
	public void FrameColor() {
		
		driver.navigate().back();
		
		driver.switchTo().frame("main");
		String color = driver.findElement(By.xpath("//div[contains(text(),'Box 1')]")).getAttribute("class");
		
		String color2;
		do {
			driver.switchTo().frame("child");
			color2 = driver.findElement(By.xpath("//div[contains(text(),'Box 2')]")).getAttribute("class");
			driver.switchTo().parentFrame();
			if(color.equals(color2)) {
				
				driver.findElement(By.xpath("//a[contains(text(),'Proceed')]")).click();
				
			}
			else {
				
				driver.findElement(By.xpath("//a[contains(text(),'Repaint Box 2')]")).click();
				
			}
			
		}while(!(color.equals(color2)));
		
		String title = driver.getTitle();
		Assert.assertEquals(title, "Drag - Basic Course - T.A.T.O.C" );
		
	}
}