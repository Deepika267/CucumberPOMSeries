package stepdefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pages.LoginPage;
import com.pages.ProductsPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ProductsPageSteps {
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private ProductsPage productsPage;
	

	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable credTable) {
		List<Map<String, String>> credList = credTable.asMaps();
		String userName = credList.get(0).get("username");
		String password = credList.get(0).get("password");
		
		DriverFactory.getDriver().get("https://courses.ultimateqa.com/users/sign_in");
		productsPage = loginPage.doLogin(userName, password);
	}

	@Given("user is on Products page")
	public void user_is_on_products_page() {
		String title = productsPage.getProductsPageTitle();
		System.out.println("Products page title : "+title);
	}

	@Then("user gets accounts section")
	public void user_gets_accounts_section(DataTable sectionsTable) throws InterruptedException {
		List<String> expSectionsList = sectionsTable.asList();
		System.out.println("Expected products list:"+expSectionsList);
		Thread.sleep(3000);
		List<String> actualSectionsList = productsPage.getProductsSectionList();
		System.out.println("Actual products list:"+actualSectionsList);
		Assert.assertTrue(expSectionsList.containsAll(actualSectionsList));
	}

	@Then("products section count should be {int}")
	public void products_section_count_should_be(Integer expectedSectionCount) {
	    Assert.assertTrue(productsPage.getProductsSectionCount()==expectedSectionCount);
	}
}
