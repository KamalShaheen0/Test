package KamalProject.stepDefinitions;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import KamalProject.TestComponent.BaseTest;
import KamalProject.pageobject.CartPage;
import KamalProject.pageobject.CheckOutPage;
import KamalProject.pageobject.ConfirmationPage;
import KamalProject.pageobject.LandingPage;
import KamalProject.pageobject.ProductCatalogue;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionImap  extends BaseTest{
	public LandingPage landingPage ;
	public ProductCatalogue productCatalogue ;
	public ConfirmationPage   confirmationPage ;
  @Given("I landed on Ecommerce Page")
  public void I_landed_On_Ecommerce_Page() throws IOException {
	         
	    landingPage  =  launchApplication();
	   
	  }
  @Given("^Logged in with username (.+) and password (.+)$")
  public void Logged_in_username_and_Paswword(String Email ,String passwordEle) {
	  productCatalogue =landingPage.LogingApplication(Email, passwordEle);
	  
  }
  @When("^I add product (.+) to Cart$")
  public void i_add_product_to_Car(String ProductName) throws InterruptedException {
	  List<WebElement>products =productCatalogue.getProductList();
	  productCatalogue.AddProductToCart(ProductName);
  }
   
  @When("^Checkout (.+) and submit the order$")
   public void checkout_submit_order(String productName) throws InterruptedException {
  
  CartPage cartPage = productCatalogue.goToCartPage();	
	Boolean match =cartPage.VerifyProductDisplay(productName);
			Assert.assertTrue(match);
	 CheckOutPage checkout =cartPage.goToCheckoutPage();
	
    checkout.SelectCountry("india");
    confirmationPage = checkout.submitOrder();
  }	
  @Then("{string} message is displayed on ConfirmationPage")
  public void message_displayed_confiramtion(String string) {
	String confirmMessage = confirmationPage.virfiedConfirmationPage();
	Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
	driver.quit();
	  
  }
  
  @Then("^\"([^\"]*)\" message is displayed$")
  public void something_message_is_displayed(String strArg1) throws Throwable {
 
  	Assert.assertEquals(strArg1, landingPage.getErrorMessage());
  	driver.quit();
  }
  

}
