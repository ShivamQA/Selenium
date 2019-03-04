package Pages.Utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ELementSearch {
	
	WebDriver driver;
	static String fileName;
	static ArrayList<String> line = new ArrayList<String>();
	static String Selector;
	public ELementSearch(WebDriver driver, String file) {
		
		this.driver = driver;
		ELementSearch.fileName = file;

	}
	
	public ELementSearch() {
		
	}

	public void file() throws IOException {
		
		File file = new File(ELementSearch.fileName);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String readline;
		
		while ((readline = br.readLine()) != null)   {
			 
			ELementSearch.line.add(readline);
			
		}
		
		
	}
	
	public String findPath(String name) {
		
		for(int i = 0; i < ELementSearch.line.size(); i++) {
			
			if(ELementSearch.line.get(i).contains(name)) {
				
				String[] ar = ELementSearch.line.get(i).split("\\s+",3);
				ELementSearch.Selector = ar[1];
				String path = ar[2];
				return path;
			}
				
			
		}
		return null;
		
	}
	public WebElement findElement(String name) throws IOException {
		 
		 
	    	ELementSearch es = new ELementSearch();
	    	es.file();
		    String path = es.findPath(name);
	    	WebElement web = null;
	    	if(ELementSearch.Selector.contains("xpath")) {
	    		
	    		web = driver.findElement(By.xpath(path));
	    		return web;
	    		
	    	}
	    	if(ELementSearch.Selector.contains("id")) {
	    		
	    		web = driver.findElement(By.id(path));
	    		return web;
	    		
	    	}
	    	if(ELementSearch.Selector.contains("className")) {
	    		
	    		web = driver.findElement(By.className(path));
	    		return web;
	    		
	    	}
	    	
	    	return web;
	    	
	    }
	
}
