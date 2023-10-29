package Autolearn.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Autolearn.abstractcomponents.Abstractcomponents;

public class CheckoutPage extends Abstractcomponents{
	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	@FindBy(css = ".action_submit")
	WebElement submit;
	
	@FindBy(css = "[placeholder = 'Select Country']")
	WebElement country;
	
	@FindBy(xpath = "//button[contains(@class,'ta-item')][2]")
	WebElement selectCountry;
	
	By results = By.cssSelector(".ta-results");

	public void selectCountry(String CountryName)
	{
		   Actions a = new Actions(driver);
           a.sendKeys(country, CountryName).build().perform();
           waitForElementToAppear(By.cssSelector(".ta-results"));
           selectCountry.click();
	}
	public ConfirmationPage submitOrder()
	{
		submit.click();
		return new ConfirmationPage(driver);
	}
}