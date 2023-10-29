

	package Autolearn.pages;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	import Autolearn.abstractcomponents.Abstractcomponents;

	public class LandingPage extends Abstractcomponents{
		public WebDriver driver;
		public LandingPage(WebDriver driver)
		{
			super(driver);
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(id = "userEmail")
		WebElement userEmail;
		
		@FindBy(id = "userPassword")
		WebElement passwordEle;
		
		@FindBy(id = "login")
		WebElement Submit;
		//div[@class='ng-tns-c4-5 ng-star-inserted ng-trigger ng-trigger-flyInOut ngx-toastr toast-error']
		@FindBy(css = "[class*='flyInOut']")
		WebElement errorMessage;
		
		public Catalougeproducts loginApplication(String email,String password)
		{
			userEmail.sendKeys(email);
			passwordEle.sendKeys(password);
			Submit.click();
			Catalougeproducts catalougeprod = new Catalougeproducts(driver);
			return catalougeprod;
		}
		
		public String getErrorMessage()
		{
			waitForWebElementToAppear(errorMessage);
			return errorMessage.getText();
		}
		
		public void goTo()
		{
			driver.get("https://rahulshettyacademy.com/client/");
			driver.manage().window().maximize();
		}
	}
	