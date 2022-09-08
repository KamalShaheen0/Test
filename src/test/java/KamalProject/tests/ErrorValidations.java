package KamalProject.tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import KamalProject.TestComponent.BaseTest;
import KamalProject.pageobject.CartPage;
import KamalProject.pageobject.CheckOutPage;
import KamalProject.pageobject.ConfirmationPage;
import KamalProject.pageobject.ProductCatalogue;

public class ErrorValidations extends BaseTest {
	
	
	@Test(groups= {"errorHandling"}) 
	public void LoginErrorVaildation() throws IOException, InterruptedException {
	

		landingPage.LogingApplication("anshika@gmail.com", "Iamking@00");
		assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
	}
	
	@Test(retryAnalyzer = KamalProject.TestComponent.Retry.class)
	public void productErrorVaildation() throws IOException, InterruptedException {
		
		String productName = "ZARA COAT 3";
		ProductCatalogue ProductCatalogue=	landingPage.LogingApplication("anshika@gmail.com", "Iamking@000");
	
		ProductCatalogue.AddProductToCart(productName);
		
		CartPage cartPage = ProductCatalogue.goToCartPage();	
		Boolean match =cartPage.VerifyProductDisplay(productName);
				Assert.assertTrue(match);

	}


}
