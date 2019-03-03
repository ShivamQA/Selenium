package Test;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.*;

public class TestTatoc extends TatocPages{
	
	
	//First Page Test Case
	@Test(priority = 0)
	public void Grid() {
		
		grid.GridErrorTest();  //When Red color box is clicked
		grid.GridPassTest();   //When Green color box is clicked	
		
	}
	
	@Test(priority = 1) 
	public void Frame() {
		
		
		frame.BoxCheck();          //verify box 1 and box 2 are displayed
		frame.FrameErrorTest();     
		frame.FrameColor();         
	
	}
	
	@Test(priority = 3)
	public void DragDrop() {
		
		
		drag.DragButton();
		drag.DragErrorTest();
		drag.DragTest();
		
	}
	
	@Test(priority = 4)
	public void WindowPopup() throws IOException {
		
		
		window.WindowLinks();
		window.WindowButton();
		window.WindowErrorTest();
		window.WindowNameTest();
		window.WindowTest();
		
	}
	
	@Test(priority = 5)
	public void CookieHandling() {
		
		
		cookie.CookieGenerateErrorTest();
		cookie.CookieErrorTest();
		cookie.CookieGenerateTest();
		
	}
	
	
	
	
	
}
