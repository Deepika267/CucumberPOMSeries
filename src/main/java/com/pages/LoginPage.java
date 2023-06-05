package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;
	//	1. By Locators:
	private By emailID = By.id("user[email]");
	private By pwd = By.id("user[password]");
	private By signInButton = By.xpath("//button[contains(text(),'Sign in')]");
	private By forgotPasswordLink = By.xpath("//a[contains(text(),'Forgot Password?')]");
//	private By emailID = By.xpath("//input[@role='searchbox' and @aria-controls='pr_id_1_list']");
//	private By toSearch = By.xpath("//input[@role='searchbox' and @aria-controls='pr_id_2_list']");
//	private By searchButton = By.xpath("//button[contains(text(),'Search')]");
	
	//	2. Constructor of the page class: 
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// 3. Page Actions : features(behaviour) of the page the form of methods:
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean isForgotPwdLinkExists() {
		return driver.findElement(forgotPasswordLink).isDisplayed();
	}
	
	public void enterUserName(String userName) {
		driver.findElement(emailID).sendKeys(userName);
	}
	
	public void enterPassword(String password) {
		driver.findElement(pwd).sendKeys(password);
	}
	
	public void clickOnLogin() {
		driver.findElement(signInButton).click();
	}
	
	public ProductsPage doLogin(String userName, String password) {
		System.out.println("Login in with :"+userName+" and "+password);
		driver.findElement(emailID).sendKeys(userName);
		driver.findElement(pwd).sendKeys(password);
		driver.findElement(signInButton).click();
		return new ProductsPage(driver);
		
	}
}
