package KamalProject.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import KamalProject.AbstractComponents.AbstractComponent;

public class ProductCatalogue  extends AbstractComponent {
	
	
	WebDriver driver ;
	
	public  ProductCatalogue(WebDriver driver){
		super(driver);
		//initialization
		this.driver =driver;
		PageFactory.initElements(driver, this);
		
	}


	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement Spinner;
	
	By productBy =By.cssSelector(".mb-3");
	
	By AddToCart =By.cssSelector(".card-body button:last-of-type");
	
	By toastMessage =By.cssSelector("#toast-container");
	
	//prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
	
	
	public List<WebElement> getProductList() {
		waitForElementToAppear(productBy);
		return products ;
		
	}
	
	public WebElement getProductByName(String productName) {
		
	WebElement prod =	getProductList().stream().filter(product->
	product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
	
	 return prod ;
		
	}
	
	public void AddProductToCart(String product ) throws InterruptedException {
		WebElement prod =	getProductByName( product) ;
		prod.findElement(AddToCart).click();
		waitForElementToAppear(toastMessage);
		waitForElementToDisappear(Spinner);
		
	}
	
	

}
