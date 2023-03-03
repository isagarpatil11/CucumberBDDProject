package StepDefination;
//Parent class

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import Utilities.ReadConfig;
//Parent class

public class BaseClass {
	
	public static WebDriver driver;
	public LoginPage loginPg;
	public SearchCustomerPage SearchCustPg;
	public AddNewCustomerPage addNewCustPg;
	public static  Logger Log;
	public ReadConfig readConfig;
	
	//generate unique emailId
	public String generateEmailId()
	{
	   return RandomStringUtils.randomAlphabetic(5);		
	}
	}
