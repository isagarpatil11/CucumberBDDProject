package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddNewCustomerPage {
	
 public WebDriver ldriver;
 
 //cunstructor
 public AddNewCustomerPage(WebDriver rdriver)
 {
	 ldriver=rdriver;
	 PageFactory.initElements(ldriver, this);
 }
 
 //Find webelement on on the webpage
 
 @FindBy(xpath="//a[@href='#']//p[contains(text(),'Customers')]")
 WebElement lnkCustomers_menu;

// @FindBy(xpath="//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")
// WebElement lnkCustomers_menuitem;

 @FindBy(xpath="(//i[@class='nav-icon far fa-dot-circle'])[13]")
 WebElement lnkCustomers_menuitem;
 
 @FindBy(xpath="//a[@class='btn btn-primary']")
 WebElement btnAddNew;
 
 @FindBy(xpath="//input[@id='Email']")
 WebElement txtEmail;
 
 @FindBy(xpath="//input[@id='Password']")
 WebElement txtPassword;
 
 @FindBy(xpath="//div[@class='k-multiselect-wrap k-floatwrap']")
 WebElement txtCustomersRoles;
 
 @FindBy(xpath="//li[contains(text(),'Administrators')]")
 WebElement listItemAdministrators;
 
 @FindBy(xpath="//li[contains(text(),'Registered')]")
 WebElement listAdminRegistered;
 
 @FindBy(xpath="//li[contains(text(),'Guests')]")
 WebElement listAdminGuest;
 
 @FindBy(xpath="//li[contains(text(),'Guests')]")
 WebElement listItomVendors;
 
 @FindBy(xpath="//*[@id='VendorId']")
 WebElement dropdownVendormgr;
 
 @FindBy(id="Gender_Male")
 WebElement maleGender;
 
 @FindBy(id="Gender_Female")
 WebElement femaleGender;
 
 @FindBy(xpath="//input[@id='FirstName']")
 WebElement txtFirstName;
 
 @FindBy(xpath="//input[@id='LastName']")
 WebElement txtLastName;
 
 @FindBy(xpath="//input[@id='DateOfBirth']")
 WebElement txtDob;
 
 @FindBy(xpath="//input[@id='Company']")
 WebElement txtCompanyName;
 
 @FindBy(xpath="//textarea[@id='AdminComment']")
 WebElement txtAdminContent;
 
 @FindBy(xpath="//button[@name='save']")
 WebElement btnSave;
 
 //Action methods for Webelements
 
 public String getPageTitle()
 {
	 return ldriver.getTitle();
 }
 
 public void clickOnCustomersMenu()
 {
	 lnkCustomers_menu.click();
 }
 
 public void clickOnCustomersMenuItom()
 {
	 lnkCustomers_menuitem.click();
 }
 
 public void clickOnAddnew()
 {
	 btnAddNew.click();
 }
 
 public void enterEmail(String email)
 {
	 txtEmail.sendKeys(email);
 }
 
 public void enterPassword(String password)
 {
	 txtPassword.sendKeys(password);
 }
 
 public void enterFirstName(String firstName)
 {
	 txtFirstName.sendKeys(firstName);
 }
 
 public void enterLastName(String lastName)
 {
	 txtLastName.sendKeys(lastName);
 }
 
 public void enterDob(String dob) {
     this.txtDob.sendKeys(new CharSequence[]{dob});
 }

 public void enterCompanyName(String coName) {
     this.txtCompanyName.sendKeys(new CharSequence[]{coName});
 }

 public void enterAdminContent(String content) {
     this.txtAdminContent.sendKeys(new CharSequence[]{content});
 }

 public void enterManagerOfVendor(String value) {
     Select drp = new Select(this.dropdownVendormgr);
     drp.selectByVisibleText(value);
 }

 public void enterGender(String gender) {
     if (gender.equals("Male")) {
         this.maleGender.click();
     } else if (gender.equals("Female")) {
         this.femaleGender.click();
     } else {
         this.maleGender.click();
     }

 }

 public void clickOnSave() {
     this.btnSave.click();
 }
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
}


