package KamalProject.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;

import KamalProject.AbstractComponents.AbstractComponent;

public class OrderPage extends AbstractComponent{
	
WebDriver driver ;
	
	public  OrderPage(WebDriver driver){
		super(driver);
		//initialization
		this.driver =driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> OrderList ;  
	
	 @FindBy(css=".py-5")
	 WebElement TabelOrderList ;
	
	
	public List<WebElement> getOrderList() throws InterruptedException {
		return OrderList ;
		
	}
	
     public boolean VerifyOrderProductDisplay(String productName) throws InterruptedException {
    	 waitForWebElementToAppear(TabelOrderList);
      Boolean match = getOrderList().stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));
		return match ;
		
	}
     
   
	
	

}
