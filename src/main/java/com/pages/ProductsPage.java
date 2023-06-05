package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage {
	private WebDriver driver;
	private By productHeaders = By.cssSelector("ul.products__list li h3");

	public ProductsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getProductsPageTitle() {
		return driver.getTitle();
	}

	public int getProductsSectionCount() {
		return driver.findElements(productHeaders).size();
	}
	
	public List<String> getProductsSectionList() {
		List<String> productList = new ArrayList<>();
		List<WebElement> productsHeaderList = driver.findElements(productHeaders);
		for(WebElement e : productsHeaderList) {
			String text = e.getText();
			System.out.println(text);
			productList.add(text);
		}
		
		return productList;
	}
}
