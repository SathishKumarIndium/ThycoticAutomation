package pages;


import java.util.List;

import org.openqa.selenium.WebElement;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import objectRepository.OR;

public class HelpPage  extends ApplicationKeywords{
	
	public static final String help_title = "help page title#xpath=//div[text()='Help' and contains(@class,'column column')]";
	public static final String Licenses_title_page = "Licenses title page#xpath=//span[@id='FieldNameLabel' and text()='Install Licenses']";
	public static final String link_Getting_Started_tab = "Link for getting Started in help page#xpath=//ul[@class='linkList']//a[text()='Getting Started']";
	
	
	public HelpPage(BaseClass obj) {
		super(obj);
	}
	
	public void HelpPageFieldsValidation(String fields) {
		clickOn(OR.bth_help_icon);
		if(validateAllElementisDisplay("help pages fields #xpath=//ul[@class='linkList']/li/a/following-sibling::a", fields)) {
			vstsTestStepPassed("Help page have all elments", false);
		}
		else {
			vstsTestStepFailed("Some element are mission in Help Page ", true);
		}
	}
		
	
	public void addingLicensesSecretServerSetup(String LicenseName, String LicenseKey) {
	    try {
			clickOn(OR.bth_help_icon);

			if (isElementDisplayed(help_title)) {
				testStepPassed("Help Page is Displayed");
				vstsTestStepPassed("Help page is not Displayed", true);
			}
			else {
				testStepFailed("Help Page is not Displayed");
				vstsTestStepFailed("Help Page is not Displayed", true);
			}
			
			
			clickOn(link_Getting_Started_tab);
			if (elementPresent(OR.btn_Getting_Started_page_header)) {
				testStepPassed("Secret Server Setup' page should be displayed");
				vstsTestStepPassed("Secret Server Setup' page should be displayed", true);
				
				clickOn(OR.btn_Licenses_tab);
				if (elementPresent(Licenses_title_page)) {
					testStepPassed("Licenses page is displayed");
					vstsTestStepPassed("Licenses page is displayed", true);
					
					typeIn(OR.txtbox_License_Name, LicenseName);
					typeIn(OR.txtbox_License_Key, LicenseKey);
					
					if (ValidateEnterValusInTextField(OR.txtbox_License_Name, LicenseName, "license Name")) {
						testStepPassed("The user should be able to enter the value in License Name");
						vstsTestStepPassed("The user should be able to enter the value in License Name", true);
					}
					else {
						testStepFailed("The user should not able to enter the value in License Name");
						vstsTestStepFailed("The user should not able to enter the value in License Name", true);
					}
					
					if (ValidateEnterValusInTextField(OR.txtbox_License_Key, LicenseKey, "license Key")) {
						testStepPassed("The user should be able to enter the value in License Key");
						vstsTestStepPassed("The user should be able to enter the value in License Key", true);
					}
					else {
						testStepFailed("The user should not able to enter the value in License Key");
						vstsTestStepFailed("The user should not able to enter the value in License Key", true);
					}
					
					clickOn(OR.btn_add_license_icon);
					waitTime(3);
//					List<WebElement> componentlist = driver.findElementsByXPath("//tbody[@id='JsonListBody']/tr/td/following-sibling::td/p");
//					boolean status = false;
//					for (WebElement ele:componentlist ) {
//						String elementvalue = ele.getText();
//						if (elementvalue.equalsIgnoreCase(LicenseKey)) {
//							status = true;
//						    testStepPassed("Licenses Is Added Successfully");
//						    vstsTestStepPassed("Licenses Is Added Successfully", true);
//						    break;
//						}
//					}
//					if(!status) {
//						testStepFailed("Licenses Is Not Added");
//						vstsTestStepFailed("Licenses Is Not Added", true);
//					}
					
					if (validateLicensesispresent("//tbody[@id='JsonListBody']/tr/td/following-sibling::td/p", LicenseKey)) {
						testStepPassed("Licenses Is Added Successfully");
						vstsTestStepPassed("Licenses Is Added Successfully", true);
					}
					else {
						testStepFailed("Licenses Is Added Successfully");
						vstsTestStepFailed("Licenses Is Added Successfully", true);
					}
					
					
				}
				else {
					testStepFailed("Licenses page is not displayed");
					vstsTestStepFailed("Licenses page is not displayed", true);
				}
			}
			else {
				testStepFailed("Getting Started page is not Displayed");
				vstsTestStepFailed("Secret Server Setup' page should not be displayed", true);
			}
			
	    }
	    catch(Exception e) {
	    	e.printStackTrace();
	    }
		
	}
	
	
	public void verifyLicenesesinLicensesPage(String LicenseKey, boolean licenseispresent) {
		
		try {
			mouseOver(OR.btn_Admin_Tab);
			clickOn(OR.btn_Admin_Licenses_tab);
			if (elementPresent(OR.Licenses_page_header)) {
				testStepInfo("Licenses Page is displayed");
				vstsTestStepPassed("Licenses Page is displayed", true);
				boolean lstatus = false;

				if (licenseispresent) {
					if (validateLicensesispresent("//span[contains(@id,'LicenseKeyLabel')]", LicenseKey)) {
						testStepPassed("Licenses are Present in Licenses Page");
						vstsTestStepPassed("Licenses are  Present in Licenses Page", true);
					}
					else {
						testStepFailed("Licenses are Not Present in Licenses Page");
						vstsTestStepFailed("Licenses are Not Present in Licenses Page", true);
					}
				}
				else {
					if (!validateLicensesispresent("//span[contains(@id,'LicenseKeyLabel')]", LicenseKey)) {
						testStepPassed("Licenses are Present in Licenses Page");
						vstsTestStepPassed("Licenses are  Present in Licenses Page", true);
					}
					else {
						testStepFailed("Licenses are Not Present in Licenses Page");
						vstsTestStepFailed("Licenses are Not Present in Licenses Page", true);
					}
				}
			}
			else {
				testStepFailed("Licenses page is not displayed");
				vstsTestStepFailed("Licenses page is not displayed", true);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void deleteLicensesSecretServerSetup(String LicenseKey) {
		
		try {
			verifyLicenesesinLicensesPage(LicenseKey, true);
			clickOn(OR.bth_help_icon);

			if (isElementDisplayed(help_title)) {
				testStepPassed("Help Page is Displayed");
				vstsTestStepPassed("Help page is not Displayed", true);
			}
			else {
				testStepFailed("Help Page is not Displayed");
				vstsTestStepFailed("Help Page is not Displayed", true);
			}
			
			clickOn(link_Getting_Started_tab);
			if (elementPresent(OR.btn_Getting_Started_page_header)) {
				testStepPassed("Secret Server Setup' page should be displayed");
				vstsTestStepPassed("Secret Server Setup page should be displayed", true);
				
				clickOn(OR.btn_Licenses_tab);
				if (elementPresent(Licenses_title_page)) {
					testStepPassed("Licenses page is displayed");
					vstsTestStepPassed("Licenses page is displayed", true);
					clickOn("Delete button for Licenses#xpath=//p[text()='"+LicenseKey+"']/parent::td/following-sibling::td/a[@title='Remove']");
					waitTime(3);	
					
					if (!validateLicensesispresent("//tbody[@id='JsonListBody']/tr/td/following-sibling::td/p", LicenseKey)) {
						testStepPassed("Licenses are deleted Successfully from Secret Server Setup 'LicenseKey : "+ LicenseKey+"'");
						vstsTestStepPassed("Licenses are deleted Successfully from Licenses Page", true);
					}
					else {
						testStepFailed("Licenses are  not deleted Successfully from  Secret Server Setup 'LicenseKey : "+ LicenseKey+"'");
						vstsTestStepFailed("Licenses are  not deleted Successfully", true);
					}
					
					
					verifyLicenesesinLicensesPage(LicenseKey, false);
				}
				else {
					testStepFailed("Licenses page is not displayed");
					vstsTestStepFailed("Licenses page is not displayed", true);
				}
			}
			else {
				testStepFailed("Getting Started page is not Displayed");
				vstsTestStepFailed("Secret Server Setup' page should not be displayed", true);
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteLicenses(String LicenseKey) {
		try {
			mouseOver(OR.btn_Admin_Tab);
			clickOn(OR.btn_Admin_Licenses_tab);
			if (elementPresent("Licensekey in license page#xpath=//span[text()='"+LicenseKey+"']")) {
				clickOn("clicking on Liciense to delete#xpath=//span[text()='"+LicenseKey+"']/parent::td/preceding-sibling::td/a/span[text()='For Thycotic QA Only']");
			    clickOn("clicking on Delete button #xpath=//button[text()='Delete']");
			    alertOk();
	
			    
			    if (!validateLicensesispresent("//span[contains(@id,'LicenseKeyLabel')]", LicenseKey)) {
			    	testStepPassed("Licenses are  not deleted Successfully from Licenses Page 'LicenseKey : "+ LicenseKey+"'");
				}
				else {
					testStepPassed("Licenses are deleted Successfully from Licenses Page 'LicenseKey : "+ LicenseKey+"'");
				}
			}
			else {
				testStepFailed("License is not present");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void validateLicensesispresentprecondition(String LicenseName, String LicenseKey) {
		clickOn(OR.bth_help_icon);
		clickOn(link_Getting_Started_tab);
		if (elementPresent(OR.btn_Getting_Started_page_header)) {
			testStepPassed("Secret Server Setup' page should be displayed");
			clickOn(OR.btn_Licenses_tab);
			if (elementPresent(Licenses_title_page)) {	
				if (elementPresent("licenses key#xpath=//p[text()='"+LicenseKey+"']")) {
					testStepPassed("licenses are present");
					vstsTestStepPassed("licenses are present", true);
				}
				else {
					typeIn(OR.txtbox_License_Name, LicenseName);
					typeIn(OR.txtbox_License_Key, LicenseKey);
					
					clickOn(OR.btn_add_license_icon);
					waitTime(3);
					
					if (validateLicensesispresent("//tbody[@id='JsonListBody']/tr/td/following-sibling::td/p", LicenseKey)) {
						testStepPassed("Licenses Is Added Successfully");
						vstsTestStepPassed("Licenses Is Added Successfully", true);
					}
					else {
						testStepFailed("Licenses Is Not Added");
						vstsTestStepFailed("Licenses Is Not Added", true);
					}
				}
			}
			else {
				testStepFailed("Licenses page is not displayed");
				vstsTestStepFailed("Licenses Is Not Present", true);
			}
		}
		else {
			testStepFailed("Getting Started page is not Displayed");
			vstsTestStepFailed("Secret Server Setup' page should not be displayed", true);
		}
			
	}
	
	public boolean validateLicensesispresent(String xpath, String LicenseKey) {
		
		boolean status = false;
		try {
			List<WebElement> componentlist = driver.findElementsByXPath(xpath);
			for (WebElement ele:componentlist ) {
				String elementvalue = ele.getText();
				if (elementvalue.equalsIgnoreCase(LicenseKey)) {
					status = true;
					//testStepPassed("Licenses Is Added Successfully");
					break;
				}
			}
			if(!status) {
				status = false;
				//testStepFailed("Licenses Is Not Added");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
		
	}
  
}
