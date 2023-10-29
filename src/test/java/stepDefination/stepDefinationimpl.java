package stepDefination;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Autolearn.pages.CartPage;
import Autolearn.pages.Catalougeproducts;
import Autolearn.pages.CheckoutPage;
import Autolearn.pages.ConfirmationPage;
import Autolearn.pages.LandingPage;
import Autolearn.testcomponents.baseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefinationimpl extends baseTest {
	
	public LandingPage landingPage;
	ConfirmationPage confirmationPage;
	Catalougeproducts catalougeprod;
	@Given("I landed on Ecommerce page")
	public void I_landed_on_Ecommerce_page() throws IOException
	{
		landingPage = launchApplication();
	}
	@Given("^Login with name(.+) and password(.+)$")
	public void login_with_name_and_password(String username, String password)
	{
		catalougeprod = landingPage.loginApplication(username,password);
	}
	@When("^I add product (.+) in cart$")
	public void I_add_product_in_cart(String productName)
	{
		List<WebElement>products = catalougeprod.getProductList();
        catalougeprod.addProductToCart(productName);
	}
	@When("^checkout (.+) and submit the order$")
	public void checkout_submit_order(String productName)
	{
		 CartPage cartPage = catalougeprod.goToCartPage();
         
         Boolean match = cartPage.VerifyProductDisplay(productName);
         Assert.assertTrue(match);
         CheckoutPage checkoutPage = cartPage.goToCheckout();
         checkoutPage.selectCountry("india");
         confirmationPage = checkoutPage.submitOrder();
	}
	
	@Then ("{String} message is displayed")
	public void message_displayed_confirmationPage(String string)
	{
		String confirmMessage = confirmationPage.getConfirmationMessage();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));	
	}
	
	@Then ("^\"({^\"]*)\" message is displayed$")
	public void something_message_is_displayed(String strArg1)
	{
		Assert.assertEquals("Incorrect email or password",landingPage.getErrorMessage());
		driver.close(); 
	}

}
