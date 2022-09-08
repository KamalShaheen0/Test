package KamalProject.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.xml.LaunchSuite;

import KamalProject.TestComponent.BaseTest;
import KamalProject.pageobject.CartPage;
import KamalProject.pageobject.CheckOutPage;
import KamalProject.pageobject.ConfirmationPage;
import KamalProject.pageobject.LandingPage;
import KamalProject.pageobject.OrderPage;
import KamalProject.pageobject.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AppTest extends BaseTest {
	
	@Test(dataProvider = "getData",groups = {"Purchase"})
	public void submitOrder(HashMap<String, String>input ) throws IOException, InterruptedException {
		
	
		ProductCatalogue ProductCatalogue=	landingPage.LogingApplication(input.get("email"), input.get("pasword"));
	
		ProductCatalogue.AddProductToCart(input.get("product"));
		
		CartPage cartPage = ProductCatalogue.goToCartPage();	
		Boolean match =cartPage.VerifyProductDisplay(input.get("product"));
				Assert.assertTrue(match);
		 CheckOutPage checkout =cartPage.goToCheckoutPage();
		
	      checkout.SelectCountry("india");
	      	
	      ConfirmationPage   confirmationPage = checkout.submitOrder();
	      
	      confirmationPage.virfiedConfirmationPage();	
	      
		String confirmMessage = confirmationPage.virfiedConfirmationPage();
		
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	
	}
	
	@Test(dependsOnMethods = {"submitOrder"})
	public void orderHistoryTest() throws InterruptedException {
	ProductCatalogue ProductCatalogue=	landingPage.LogingApplication("kamal@gmail.com", "kamalK!1");	
	OrderPage orderPage =ProductCatalogue.goToOrderPage();
	Assert.assertTrue(orderPage.VerifyOrderProductDisplay("ZARA COAT 3"));	
	}
	
	
	
	

	
	
	
	@DataProvider
	public Object[][] getData() throws IOException {

		List<HashMap<String, String>>  data =getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\KamalProject\\Data\\PurchaseOrder.json"); 
		
	return new Object[][] {{data.get(0)},{data.get(1)}};
	}
	
	
//	@DataProvider
	//public Object[][] getData(){
	//retrun new Object[][] {{"anshika@gmail.com","Iamking@000","ADIDAS ORIGINAL"},{""kamal@gmail.com","kamalK!1","ZARA COAT 3"}};
	//}
	
	
	/*
	HashMap<String, String> map =new HashMap<String,String>();
	map.put("email", "kamal@gmail.com");
	map.put("pasword", "kamalK!1");
	map.put("product", "ZARA COAT 3");
	
	HashMap<String, String> map1 =new HashMap<String,String>();
	map1.put("email", "anshika@gmail.com");
	map1.put("pasword", "Iamking@000");
	map1.put("product", "ADIDAS ORIGINAL");
	*/

}