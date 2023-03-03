package StepDefination;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import Utilities.ReadConfig;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

//Child class of BaseClass
public class StepDef extends BaseClass {
	
	@Before
	public void setup1()
	{
		readConfig = new ReadConfig();
		
		
		//initialize logger
		Log = LogManager.getLogger("StepDef");
		
		System.out.println("Setup-Sanity Method Executed..");
		String browser = readConfig.getBrowser();
		
		//launch browser
		switch(browser.toLowerCase())
		{
		case"chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
			
		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
			
		case "firefox":
		    WebDriverManager.firefoxdriver().setup();
		    driver = new FirefoxDriver();
		    break;
		    
		default:
			driver = null;
			break;
			
			
		}
		
//		 WebDriverManager.chromedriver().setup();
//		 driver=new ChromeDriver();
		 Log.info("Setup1 executed..");
	}
	
//	@Before("@regression")
//	public void setup2()
//	{
//		System.out.println("Setup2-regression Method Executed..");
//		 WebDriverManager.chromedriver().setup();
//		 driver=new ChromeDriver();
//		 Log.info("Setup2 executed..");
//		 
//	}
	
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
	 
	 loginPg=new LoginPage(driver);
	 addNewCustPg= new AddNewCustomerPage(driver);
	 SearchCustPg= new SearchCustomerPage(driver);
	 Log.info("chrome browser launch..");
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
	   driver.get(url);
	   Log.info("Url opened..");
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String emailadd, String password) {
	   loginPg.enterEmail(emailadd);
	   loginPg.enterPassword(password);
	   Log.info("email address and password entered");
	}

	@When("Click on Login")
	public void click_on_login() {
	   loginPg.clickOnLoginButton();
	   Log.info("Login button clicked.");
	}
/////////Login features ////////////
	@Then("Page Title should be {string}")
	public void page_title_should_be(String expectedTitle) {
	    String actualTitle=driver.getTitle();
	    
	    if(actualTitle.equals(expectedTitle))
	    {
	    	Log.warn("Login feature: Page title matched.");
	    	Assert.assertTrue(true);
	    }
	    else
	    {
	    	Assert.assertTrue(false);
	    	Log.warn("Test Failed: Login feature-page title not matched.");

	    }
	}

	@When("User Click on Log out link")
	public void user_click_on_log_out_link() {
	   loginPg.clickOnLogOutButton();
	   Log.info("user clicked on logout link.");

	}

//	@Then("close browser")
//	public void close_browser() {
//	   driver.close();
//	   Log.info("Browser closed");
//
//	   
//	//   driver.quit();
//	}

	
	////////////////////////////////////////////
	
	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
	   String actualTitle = addNewCustPg.getPageTitle();
	   String expectedTitle = "Dashboard / nopCommerce administration";
	   
	   if(actualTitle.equals(expectedTitle))
	   {
		   Log.info("User can view Dashboard test passed.");
		   Assert.assertTrue(true);
	   }
	   else {
		   Assert.assertTrue(false);
		   Log.warn("User can view Dashboard test failed.");
	   }
	}

	@When("User Click on customers Menu")
	public void user_click_on_customers_menu() {
	    addNewCustPg.clickOnCustomersMenu();
	    Log.info("Customer menu clicked");
	    
	    try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("click on customers Menu Item")
	public void click_on_customers_menu_item() {
	    addNewCustPg.clickOnCustomersMenuItom();
		   Log.info("Customer menu itom clicked.");

	    
	    try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("click on Add new button")
	public void click_on_add_new_button() {
	    addNewCustPg.clickOnAddnew();
		   Log.info("clicked on add new button.");

	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
	    String actualTitle =  addNewCustPg.getPageTitle();
	    String expectedTitle = "Add a new customer / nopCommerce administration";
	    
	    if(actualTitle.equals(expectedTitle))
	    {
	    	Log.info("User can view Add new customer page- passed");
	    	Assert.assertTrue(true);  //Pass
	    }
	    else {
	    	Assert.assertTrue(false);  //fail
	    	Log.info("User can view Add new customer page- failed");
	    }
	}

	@When("User enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
		
		Thread.sleep(3000);
	   // addNewCustPg.enterEmail("cs9@gmail.com");
	    addNewCustPg.enterEmail(generateEmailId()+"@gmail.com");
		addNewCustPg.enterPassword("test1");
	    addNewCustPg.enterFirstName("Prachi");
	    addNewCustPg.enterLastName("Gupta");
	    addNewCustPg.enterGender("Female");
	    addNewCustPg.enterDob("6/13/1998");
	    addNewCustPg.enterCompanyName("Coders");
	    addNewCustPg.enterAdminContent("Admin Content");
	    addNewCustPg.enterManagerOfVendor("Vendor 1");
	    
		Log.info("Customer information entered");


	}

	@When("click on Save button")
	public void click_on_save_button() {
		addNewCustPg.clickOnSave();
		Log.info("Clicked on save button");
	}

	@Then("User can View confirmation message {string}")
	public void user_can_view_confirmation_message(String expectedConfirmationMsg) {
	    String bodyTagText = driver.findElement(By.tagName("Body")).getText();
	    if(bodyTagText.contains(expectedConfirmationMsg))
	    {
	    	Assert.assertTrue(true);   //pass
	    	Log.info("User can view confirmation message- passed");
	    }
	    else {
	    	Assert.assertTrue(false);  //false
	    	Log.warn("User can view confirmation message- failed");
	    }
	    
	    
	}
	//////////////////////////////////SearchCustomer by email/////////////////////////
	@When("Enter Customer Email")
	public void enter_customer_email() {
	  SearchCustPg.enterEmailAdd("james_pan@nopCommerce.com");
	  Log.info("Email address entered");
	}

	@When("Click on Search button")
	public void click_on_search_button() {
		SearchCustPg.clickOnSearchButton();
		  Log.info("Clicked on search button");

		 try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	@Then("User Should found email in the search table")
	public void user_should_found_email_in_the_search_table() {
	  String expectedEmail = "james_pan@nopCommerce.com";
	  
	 // Assert.assertTrue(SearchCustPg.searchCustomerByEmail(expectedEmail)==true);
	  
	if(SearchCustPg.searchCustomerByEmail(expectedEmail)==true)
	{
		 Log.info("User Should found email in the search table- passed");
		Assert.assertTrue(true);
	}
	else
	{
		Assert.assertTrue(false);
		 Log.warn("User Should found email in the search table- failed");
	}
	}
 

	////////////////////////Search Custommer by NAme//////////////////////
	
	@When("Enter Customer FirstName")
	public void enter_customer_first_name() {
	 SearchCustPg.enterFirstName("John");
	}

	@When("Enter Customer LastName")
	public void enter_customer_last_name() {
		SearchCustPg.enterLastName("Smith");
	}

	@Then("User Should found Name in the Search table")
	public void user_should_found_name_in_the_search_table() {
	   
		String expectedName = "John Smith";
		  
		if(SearchCustPg.searchCustomerByName(expectedName) ==true)
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		}

	@After(order=1)
	public void teardown1(Scenario sc) 
	{
		System.out.println("Tear Down1 Method Executed..");
		if(sc.isFailed()==true)
		{
			//Convert web driver object to TakeScreenshot
			
			String filewithPath= "C:\\Users\\dell\\eclipse-workspace\\CucumberFramework\\Screenshot\\failedScreenshot.png";
			TakesScreenshot scrShot = ((TakesScreenshot)driver);
			
			//call getScreenshotAs method to create image file
			File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
			
			//Move image file to new destination 
			File DestFile = new File(filewithPath);
			
			//Copy File at Destination
			try {
				FileUtils.copyFile(SrcFile, DestFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		}
		
		driver.quit();
	}
	
	@AfterStep
	public void addScreenshot(Scenario scenario) {
		if(scenario.isFailed())
		{
		final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		//attach image file report(data, media, name of the attachment)
		scenario.attach(screenshot, "image/png", scenario.getName());	
		}
	}
	
	
//	@After(order=2)
//	public void teardown2()
//	{
//		System.out.println("Tear Down2 Method Executed..");
//		driver.quit();
//	}
	
//	@BeforeStep
//	public void beforeStepMethodDemo()
//	{
//		System.out.println("This is before Step..");
//	}
//	
//	@AfterStep
//	public void afterStepMethodDemo()
//	{
//		System.out.println("This is After Step..");
//	}
	
	
	
	
	
	
	
	
	
}
