package KamalProject.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import KamalProject.AbstractComponents.AbstractComponent;

public class ConfirmationPage extends AbstractComponent {
	
	
WebDriver driver ;
	
	public  ConfirmationPage(WebDriver driver){
		super(driver);
		//initialization
		this.driver =driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(css=(".hero-primary"))
	WebElement ConfrimationMessage ;
	
	public String  virfiedConfirmationPage() {
		
	return  ConfrimationMessage.getText();
		
	}

}
