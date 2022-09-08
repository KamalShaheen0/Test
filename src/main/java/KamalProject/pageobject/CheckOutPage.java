package KamalProject.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import KamalProject.AbstractComponents.AbstractComponent;

public class CheckOutPage extends AbstractComponent {
	
	
WebDriver driver ;
	
	public  CheckOutPage(WebDriver driver){
		super(driver);
		//initialization
		this.driver =driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath = "(//button[contains(@class,'ta-item')])[2]")
	WebElement SelectCountry ;
	
	@FindBy(css = ".action__submit")
	WebElement Submit ;
	
	@FindBy(css = "[placeholder='Select Country']")
	WebElement Country ;
	
	
	By results = By.cssSelector(".ta-results");
	
	public void SelectCountry(String CountryName) {
	Actions a = new Actions(driver);
    a.sendKeys(Country, CountryName).build().perform();
    waitForElementToAppear(results);
    SelectCountry.click();
   
	}
	
	public ConfirmationPage submitOrder() {
		 Submit.click();
		return new ConfirmationPage(driver);
	}
	
	

	

}
