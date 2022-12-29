package Stepdefinition;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import Utilities.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login extends Base  {
	
	

@Given("I open chrome browser")
public void i_open_chrome_browser() {
	OpenChromeBrower();
	//System.setProperty("webdriver.chrome.driver", "C:\\Users\\ghait\\Downloads\\Jar_files\\chromedriver_win32\\chromedriver.exe");
	//driver= new ChromeDriver();
	//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));	
   
}
@Given("I visit the url")
public void i_visit_the_url() {
	VisitUrl("https://login.salesforce.com");
	//driver.get("https://login.salesforce.com");
	driver.manage().window().maximize();

}
@Given("I enter a {string} valid username")
public void i_enter_a_valid_username(String username) {
	driver.findElement(By.id("username")).sendKeys(username);
    
}
@Given("I enter a {string} valid password")
public void i_enter_a_valid_password(String password) {
	driver.findElement(By.id("password")).sendKeys(password);
}
@When("I click on login")
public void i_click_on_login() {
	driver.findElement(By.name("Login")).click();
}
@Then("I should see the dashboard")
public void i_should_see_the_dashboard() {
	boolean homelogo =driver.findElement(By.id("phHeaderLogoImage")).isDisplayed();
	Assert.assertTrue(homelogo);
	   
}

@Then("I click on {string} tab")
public void i_click_on_tab(String tab) {
   driver.findElement(By.linkText(tab)).click();
}
@Then("I click on {string} button")
public void i_click_on_button(String buttonval) {
   driver.findElement(By.xpath("//input[@value=' "+buttonval+" ']")).click();
}
@Then("I should see the bellow values in the {string} field")
public void i_should_see_the_bellow_values_in_the_field(String sla, io.cucumber.datatable.DataTable dataTable) {
    List<String> selData = dataTable.asList(String.class);
    WebElement selDropdown = driver.findElement(By.id(sla));
    Select sel = new Select(selDropdown );
    List<WebElement> options=sel.getOptions();
    for(int i=0; i<options.size();i++) {
    	Assert.assertEquals( options.get(i).getText(), selData.get(i));
    }
}


}
