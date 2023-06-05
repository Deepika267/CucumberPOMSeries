package stepdefinitions;

import org.junit.Assert;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {
	private static String title;
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	@Given("user is on login page")
	public void user_is_on_login_page() {
	   DriverFactory.getDriver().get("https://courses.ultimateqa.com/users/sign_in");
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() throws InterruptedException {
		Thread.sleep(3000);
		title = loginPage.getLoginPageTitle();
		System.out.println("Page title is : "+title);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitleName) {
	    Assert.assertTrue(title.contains(expectedTitleName));
	}

	@Then("forgot your password link should be displayed")
	public void forgot_your_password_link_should_be_displayed() {
	    Assert.assertTrue(loginPage.isForgotPwdLinkExists());
	}

	@When("user enters emailid as {string}")
	public void user_enters_from_as(String username) {
	   loginPage.enterUserName(username);
	}

	@When("user enters password as {string}")

	public void user_enters_to_as(String password) {
	    loginPage.enterPassword(password);
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
	   loginPage.clickOnLogin();
	}

	

}
