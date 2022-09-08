package KamalProject.TestComponent;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import KamalProject.pageobject.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver ;
	public  LandingPage landingPage ; 
	
	public WebDriver initializeDriver() throws IOException {
		
		//properties class 
		
		Properties prop= new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\java\\KamalProject\\Resources\\GlobalData.properties");
		prop.load(fis);
		
		String browserName =System.getProperty("browser")!=null ? System.getProperty("browser") :prop.getProperty("browser");
		//String browserName = prop.getProperty("browser");
		//Command in mvn : mvn test -PRegression -Dbrowser=firefox
		
		if(browserName.contains("chrome")) {
			ChromeOptions options =new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			if(browserName.contains("headless")) {
			options.addArguments("headless");
			}
				
			 driver = new ChromeDriver(options);
			 driver.manage().window().setSize(new Dimension(1440, 900)); //to run in full screen

		}
		else if(browserName.equals("firefox")) {
		System.setProperty("webdriver.gecko.driver", "C:\\WebDriver\\geckodriver.exe");
			 driver = new FirefoxDriver();
		}
		else if(browserName.equals("edge")) {
		System.setProperty("webdriver.edge.driver", "C:\\WebDriver\\msedgedriver.exe");
		 driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		return driver ;
		

		
	}
	public  List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
		//read Json to string
		String JsonFormate =FileUtils.readFileToString(new File(filePath),
				StandardCharsets.UTF_8);
		
		//String to HashMap- Jackson Databind
		
		ObjectMapper mapper =new ObjectMapper();
		List<HashMap<String,String>> data =mapper.readValue(JsonFormate, new TypeReference<List<HashMap<String,String>>>() {
			
		});
		
		return data ;
	}
	
	public String getScreenShot(String testCase , WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver ;
		File source =ts.getScreenshotAs(OutputType.FILE) ;
		
		File file =new File(System.getProperty("user.dir")+"//reports//"+testCase+".png");
	    FileUtils.copyFile(source, file);
	    return System.getProperty("user.dir")+"//reports//"+testCase+".png";
		
}

	
	
	
	
	@BeforeMethod(alwaysRun = true) //this means if run group always run this methods
	public LandingPage launchApplication() throws IOException    {
		
		  driver =initializeDriver() ;
		
		  landingPage =new LandingPage(driver);
		
		  landingPage.goTo();
		  
		  return landingPage ;
		
	}
	
	@AfterMethod(alwaysRun = true)//this means if run group always run this methods
	public void CloseApp() {
		driver.quit();
	}

}
