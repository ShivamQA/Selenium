package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Test.TestTatoc;

public class GridGateTest {
	
	WebDriver driver;
	
	public GridGateTest(WebDriver driver) {

		this.driver = driver;

	}
	
	public void GridErrorTest() {
		
		driver.findElement(By.className("redbox")).click();
		String errorPage = driver.getTitle();
        Assert.assertEquals(errorPage, "Error - T.A.T.O.C");

	}
	public void GridPassTest() {
	
		driver.navigate().back();
		driver.findElement(By.className("greenbox")).click();
        String nextPage = driver.getTitle();
        Assert.assertEquals(nextPage, "Frame Dungeon - Basic Course - T.A.T.O.C");
        //System.out.println(driver.getTitle());
	}
	
}
