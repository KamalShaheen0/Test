package KamalProject.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import KamalProject.AbstractComponents.AbstractComponent;

public class LandingPage  extends AbstractComponent{
	WebDriver driver ;
	
	public  LandingPage(WebDriver driver){
		super(driver);
		//initialization
		this.driver =driver;
		PageFactory.initElements(driver, this);
		
	}
	

	
	// WebElement userEmail = driver.findElement(By.id("userEmail"));
	//PageFactory
	//--->
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")  
	WebElement password;
	
	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(css ="div[aria-label='Incorrect email or password.']")//div[aria-label='Incorrect email or password.']
	WebElement errorMessage;  //.ng-star-inserted
	
	
	public ProductCatalogue LogingApplication(String Email,String passwordEle) {
		
		userEmail.sendKeys(Email);
		password.sendKeys(passwordEle);
		submit.click();
		
		ProductCatalogue ProductCatalogue =new ProductCatalogue(driver);
		return  ProductCatalogue ;
		
	}
	
	public void goTo() {
		
		driver.get("https://rahulshettyacademy.com/client");
	}

	public String  getErrorMessage() {
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
		
	
	}

}
