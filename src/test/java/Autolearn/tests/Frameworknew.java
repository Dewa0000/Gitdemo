package Autolearn.tests;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

import Autolearn.pages.CartPage;
import Autolearn.pages.Catalougeproducts;
import Autolearn.pages.CheckoutPage;
import Autolearn.pages.ConfirmationPage;
import Autolearn.pages.OrderPage;
import Autolearn.testcomponents.baseTest;


public class Frameworknew extends baseTest {
	String productName = "ZARA COAT 3";	
	@Test(dataProvider = "getData",groups = {"purchse"})
    public void Framework(HashMap<String,String> input) throws IOException 
    {
	       
	       
           Catalougeproducts catalougeprod = landingPage.loginApplication(input.get("email"),input.get("password"));
           List<WebElement>products = catalougeprod.getProductList();
           catalougeprod.addProductToCart(input.get("product"));
           CartPage cartPage = catalougeprod.goToCartPage();
           
           Boolean match = cartPage.VerifyProductDisplay(input.get("product"));
           Assert.assertTrue(match);
           CheckoutPage checkoutPage = cartPage.goToCheckout();
           checkoutPage.selectCountry("india");
           ConfirmationPage confirmationPage = checkoutPage.submitOrder();
           String confirmMessage = confirmationPage.getConfirmationMessage();
           Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
           
           
}
	
	@Test(dependsOnMethods = {"Framework"})
	public void OrderHistoryTest()
	{
		Catalougeproducts catalougeprod = landingPage.loginApplication("dewashishsahu8888@gmail.com","Dewa@0000");
		OrderPage orderPage=catalougeprod.goToOrdersCartPage();
		Assert.assertTrue(orderPage.VerifyOrderDisplay(productName));
	}
	
	
	
	@DataProvider
	public Object[][] getData() throws IOException, IOException
	{
		
		List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")+ "/src/test/java/Autolearn/data/PurchaseOrder.json");
		return new Object[][]{{data.get(0)},{data.get(1)}};
	}
} 

/*HashMap<String,String> map = new HashMap<String,String>();
map.put("email", "dewashishsahu8888@gmail.com");
map.put("password", "Dewa@0000");
map.put("product","ZARA COAT 3");

HashMap<String,String> map1 = new HashMap<String,String>();
map.put("email", "dewashishsahu@gmail.com");
map.put("password", "Dewa@0000");
map.put("product","ADIDAS ORIGINAL");*/