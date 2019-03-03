import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class NewTest {
	public String baseUrl = "https://qainfotech.com/";
    String driverPath = "/home/qainfotech/chromedriver";
    public WebDriver driver ;
    public HttpURLConnection huc = null;
  
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", driverPath);
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get(baseUrl);
	  
  }
  @Test
  public void VerifyImage() throws IOException {
	  //String expectedTitle = "QA InfoTech | Your Software Testing Partner";
      //String actualCode = driver.findElement(By.)
	  String actualImage = driver.findElement(By.cssSelector(".logo_lg img")).getAttribute("src");
      huc = (HttpURLConnection)(new URL(actualImage).openConnection());
      huc.connect();
      int respCode = huc.getResponseCode();
      Assert.assertEquals(respCode, 200);
  }
  @Test
  public void VerifyTabs() throws IOException {
	  
	  List<WebElement> tabList = driver.findElements(By.cssSelector(".nav-collapse a"));
	  for (int i=0; i<tabList.size();i++){
		  String a = tabList.get(i).getAttribute("href");
	  huc = (HttpURLConnection)(new URL(a).openConnection());
      huc.connect();
      int respCode = huc.getResponseCode();
	  Assert.assertEquals(respCode, 200);
	  }
	  }
  @Test
  public void VerifyBackground() throws IOException {
	
	  WebElement background = driver.findElement(By.cssSelector(".nav-collapse a"));
	  String color = background.getCssValue("color");
	  
	  Assert.assertEquals(color, "rgba(51, 51, 51, 1)");
	  }
  @Test
 public void VerifySearchBar() throws IOException {
	Boolean actual = true;
	  Boolean bar = driver.findElement(By.cssSelector(".top-search form")).isEnabled();
	  Assert.assertEquals(bar, actual);
	  }	  
  @Test
  public void VerifyLink() throws IOException {
 	Boolean actual = true;
 	  Boolean bar = driver.findElement(By.id("sidebar-page-1631_x_system-8113922")).isEnabled();
 	  Assert.assertEquals(bar, actual);
 	  }	  

	
	 @Test 
	 public void VerifyPlayPause() throws IOException 
	 { 
     List<WebElement> play = driver.findElements(By.cssSelector(".ls-bottom-nav-wrapper a"));
	 String p = play.get(0).getAttribute("class");
	 String p1 = play.get(10).getAttribute("class");
	
	 Assert.assertEquals(p, "ls-nav-start ls-nav-start-active");
	 Assert.assertEquals(p1, "ls-nav-stop");
	 }
	
  @Test
  public void VerifyDocumentImage() throws IOException
  {
	  String actualImage = driver.findElement(By.cssSelector(".rfq_inner img")).getAttribute("src");
      huc = (HttpURLConnection)(new URL(actualImage).openConnection());
      huc.connect();
      int respCode = huc.getResponseCode();
      Assert.assertEquals(respCode, 200);
  }
  @Test
  public void VerifyDocumentExpand() throws IOException
  {
	  String a = "display: block;";
	  driver.findElement(By.className("rfq_inner")).click();
	  String displayclose = driver.findElement(By.cssSelector(".rfq_close")).getAttribute("style");
	  
	  Assert.assertEquals(displayclose,a);
  }
  @AfterTest
  public void afterTest() {
	  driver.close();
  }
}
