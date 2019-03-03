package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import Pages.CookieHandlingTest;
import Pages.DragDropTest;
import Pages.FrameTest;
import Pages.GridGateTest;
import Pages.WindowPopupTest;

public class TatocPages {
	
	WebDriver driver;
	GridGateTest grid;
	FrameTest frame;
	DragDropTest drag;
	WindowPopupTest window;
	CookieHandlingTest cookie;

	public TatocPages() {
		
		System.setProperty("webdriver.chrome.driver", "resource/chromedriver.exe");
		driver = new ChromeDriver();
		
	}
	
	public void init() {
		
		grid = new GridGateTest(driver);
		frame = new FrameTest(driver);
		drag = new DragDropTest(driver);
		window = new WindowPopupTest(driver);
		cookie = new CookieHandlingTest(driver);
		
	}
	
	@BeforeClass
	public void setup() {
		
		driver.get("http://10.0.1.86/tatoc/basic/grid/gate");
		driver.manage().window().maximize();
		init();
	}
	
	@AfterClass
	public void closeSetup() {
		
		driver.close();
		
	}
	

}
