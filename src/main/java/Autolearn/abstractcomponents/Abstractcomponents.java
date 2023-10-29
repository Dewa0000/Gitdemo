
package Autolearn.abstractcomponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Autolearn.pages.CartPage;
import Autolearn.pages.OrderPage;



public class Abstractcomponents {
    WebDriver driver;
	public Abstractcomponents(WebDriver driver) 
	{
		
		this.driver = driver;
	}
	
	@FindBy(id = "[routerlink*='cart']")
	WebElement cartHeader;
	
	@FindBy(id = "[routerlink*='myorders']")
	WebElement orderHeader;

	public  void waitForElementToAppear(By findBy) {
		// TODO Auto-generated method stub
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public  void waitForWebElementToAppear(WebElement findBy) {
		// TODO Auto-generated method stub
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(findBy));
	}
	
	public CartPage goToCartPage()             //the error comes here which says CartPage cannot be resolved
	{
		cartHeader.click();
		CartPage cartPage = new CartPage(driver);        //It also comes here
		return cartPage;
	}
	
	public OrderPage goToOrdersCartPage()             //the error comes here which says CartPage cannot be resolved
	{
		orderHeader.click();
		OrderPage orderPage = new OrderPage(driver);        //It also comes here
		return orderPage;
	}
	
	public void waitForElementToDisappear(WebElement ele)
	{
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	

}