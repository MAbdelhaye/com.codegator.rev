package Utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	public static WebDriver driver; 
	
	
	public void OpenChromeBrower() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ghait\\Downloads\\Jar_files\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));	
	}
	
	
	public void VisitUrl(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	
	
}
