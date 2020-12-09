package com.stepdata;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class dataa {
	public WebDriver driver;

	@When("^user open \"(.*)\" browser$")
	public void browser(String browsername){
		System.setProperty("webdriver.chrome.driver","F:\\Software\\Testing\\12-10\\chromedriver.exe");
		driver=new ChromeDriver();
	}

	@And("^user enter url \"(.*)\"$")
	public void url(String url){
		driver.get(url);
	}

	@And("^user wait \"(.*)\" second to load login page$")
	public void timeout(int sec){
	driver.manage().timeouts().pageLoadTimeout(sec, TimeUnit.SECONDS);
	}

	@Then("^user is on login screen of restapiio documentation application$")
	public void title(){	
	String title= driver.getTitle();
	System.out.println(title);
	}
    
	@Given("^Rates API for Latest Foreign  Exchange rates$")
	public void latest(){
    driver.findElement(By.xpath("/html/body/div/div/div/div[3]/ul/li[1]/a")).click();
    }
	
	@When("^The API is available$")
	public void apiavailble(){
		WebElement tit=driver.findElement(By.xpath("//*[@id='latest']/p"));
	    String title1= tit.getText();
	    System.out.println(title1);	
	}
	
	@And("^An automated test suite should run which will assert the success status of the response$")
 public void responsee(){
		Response rs=RestAssured.get("https://api.ratesapi.io/api/latest HTTP/2");
		int stcode=rs.statusCode();
		String red= rs.getContentType();
		System.out.println("contwt"+rs.getContentType());
		System.out.println("tim"+rs.getTime());
		System.out.println("co"+stcode);
		}

	@Then("^An automated test suite should run which will assert the response$")
public void response1(){
	Response rs=RestAssured.get("https://api.ratesapi.io/api/latest HTTP/2");
	int stcode=rs.statusCode();
	Assert.assertEquals(stcode,404);
	System.out.println("assert successful");
}

@When("^An incorrect or incomplete url is provided$")
public void incorrecturl(){
	Response rs=RestAssured.get("https://api.ratesapi.io/api");
	int stcode=rs.statusCode();
	String red= rs.getContentType();
	System.out.println("contwt"+rs.getContentType());
	System.out.println("tim"+rs.getTime());
	System.out.println("co"+stcode);
}

@Then("^Test case should assert the correct response supplied by the call$")
public void incoreecturl1(){
	Response rs=RestAssured.get("https://api.ratesapi.io/api");
	int stcode=rs.statusCode();
	int i=400;
	Assert.assertEquals(stcode,i);
	System.out.println("assert successful");
}

@Given("^Rates API for Specific date Foreign Exchange rates$")
public void date(){
driver.findElement(By.xpath("/html/body/div/div/div/div[5]/ul/li[1]/a")).click();
}

@When("^The API is available$")
public void availble(){
	WebElement tit=driver.findElement(By.xpath("//*[@id='specific-date']/h5"));
    String title1= tit.getText();
    System.out.println(title1);	
}

@And("^An automated test suite should run which will assert the success status of the response$")
public void esponse(){
	Response rs=RestAssured.get("https://api.ratesapi.io/api/2010-01-12");
	int stcode=rs.statusCode();
	String red= rs.getContentType();
	System.out.println("contwt"+rs.getContentType());
	System.out.println("tim"+rs.getTime());
	System.out.println("co"+stcode);
	}

@Then("^An automated test suite should run which will assert the response$")
public void datreponse1(){
Response rs=RestAssured.get("https://api.ratesapi.io/api/2010-01-12");
int stcode=rs.statusCode();
Assert.assertEquals(stcode,404);
System.out.println("assert successful");
}
@When("^A future date is provided in the url$")
public void futuredatee(){
	Response rs=RestAssured.get("https://api.ratesapi.io/api/2010-01-13");
	int stcode=rs.statusCode();
}
@Then("^An automated test suite should run which will validate that the response matches for the current date$")
public void dattresponse(){
	Response rs=RestAssured.get("https://api.ratesapi.io/api/2010-01-13");
	int stcode=rs.statusCode();
	Assert.assertEquals(stcode,404);
	System.out.println("assert successful");
}	

}
