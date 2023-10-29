package Autolearn.tests;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import Autolearn.pages.CartPage;
import Autolearn.pages.Catalougeproducts;
import Autolearn.pages.CheckoutPage;
import Autolearn.pages.ConfirmationPage;
import Autolearn.testcomponents.Retry;
import Autolearn.testcomponents.baseTest;


public class errorValidation extends baseTest {
	
	@Test(groups = {"ErrorHandling"},retryAnalyzer = Retry.class)
    public void Framework() throws IOException 
    {
	       String productName = "ZARA COAT 3";
	       
           landingPage.loginApplication("dewashishsahu8888@gmail.com","Dewa@0000");
           Assert.assertEquals("Incorrect email or password",landingPage.getErrorMessage());
           
           
}
} 