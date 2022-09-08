package KamalProject.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import KamalProject.pageobject.CartPage;
import KamalProject.pageobject.OrderPage;

public class AbstractComponent {
	
	
     WebDriver driver ;
	
	public  AbstractComponent(WebDriver driver){
		//initialization
		this.driver =driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css="[routerlink*='cart']")
	WebElement goToCartHeader ;
	
	@FindBy(css="button[routerlink$='/dashboard/myorders']")
	WebElement goToOrderHeader ;
	
	
	public void waitForElementToAppear(By findBy) {
    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
    wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));	//By.cssSelector(".mb-3")
	}
	
	public void waitForWebElementToAppear(WebElement webelment) {
	    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.visibilityOf(webelment));	//By.cssSelector(".mb-3")
		}
		
	
	

	public void waitForElementToDisappear(WebElement ele) throws InterruptedException {
		Thread.sleep(2000);
		
   // WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	//wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	public CartPage goToCartPage() {
		
	goToCartHeader.click();
	
	CartPage cartPage = new CartPage(driver);
	return cartPage ;
		
	}
	
	
	public OrderPage goToOrderPage() {
		
	goToOrderHeader.click();
	
	OrderPage orderPage = new OrderPage(driver);
	return orderPage ;
		
	}
	
	

}
