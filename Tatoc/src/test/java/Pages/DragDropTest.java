package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class DragDropTest {
	
	WebDriver driver;
	
	public DragDropTest(WebDriver driver) {
		
		this.driver = driver;

	}
	
	public void DragButton() {
		
		Boolean check = true;
		Boolean button = driver.findElement(By.xpath("//div[contains(text(),'DRAG ME')]")).isEnabled();
		Assert.assertEquals(button, check);
	}
	public void DragErrorTest() {
		
		driver.findElement(By.xpath("//a[contains(text(),'Proceed')]")).click();
        Assert.assertEquals(driver.getTitle(), "Error - T.A.T.O.C");
       
        
	}
	public void DragTest() {
        
		driver.navigate().back(); 
		WebElement From=driver.findElement(By.xpath("//div[contains(text(),'DRAG ME')]"));	
        WebElement To=driver.findElement(By.xpath("//div[contains(text(),'DROPBOX')]"));									
        Actions act=new Actions(driver);							
        act.dragAndDrop(From, To).build().perform();
        driver.findElement(By.xpath("//a[contains(text(),'Proceed')]")).click();
        Assert.assertEquals(driver.getTitle(), "Windows - Basic Course - T.A.T.O.C");
        
        
		
	}

}
