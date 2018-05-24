package pages;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import org.openqa.selenium.WebElement;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import objectRepository.OR;

public class BasicPage extends ApplicationKeywords{

	
	public static final String Basic_link = "Basic link in Dashboard#id=BasicLabel";
	public static final String Advance_page_link = "advance page link#id=AdvancedLabel";
	public static final String txt_box_SearchBox = "Search Box in basic Link#xpath=//legend[text()='Secrets']/following-sibling::div/input[@placeholder='Search Secrets']";
	public static final String btn_create_secret_button = "Create a secret button in Basic#id=secretCreateContainer";
	public static final String btn_Back_Button = "Back Button for Secret Template#id=BackToSearchResultsButton";
	public static final String txt_recent_secret = "text in basic link#xpath=//legend[text()='Recent Secrets']";
	public static final String btn_launch_icon = "launch Icon for Secret Server#id=launcherTypeId";
	
	public BasicPage(BaseClass obj) {
		super(obj);
	}
	
	
	public void checkBasicSearch(String SearchValue) {
		
		clickOn(OR.btn_home_icon);
		waitTime(2);
		clickOn(Basic_link);
		if (elementPresent("Basic link page#xpath=//div[@id='homeContainer']/fieldset[@class='searchContainer']")) {
			testStepPassed("Simple page is displayed");
			vstsTestStepPassed("Simple page is not displayed", true);
		}
		else {
			testStepFailed("Simple page is not displayed");
			vstsTestStepFailed("Simple page is not displayed", true);
		}
		
		
		typeIn(txt_box_SearchBox, SearchValue);
		waitTime(3);
		List<WebElement> Searchelements = driver.findElementsByXPath("//div[@id='secretCreateContainer']/following-sibling::div//div[@class='SecretTitle']");	
		boolean status = false;
		for (WebElement ele:Searchelements ) {
			String elementvalue = ele.getText();
			if (elementvalue.equalsIgnoreCase(SearchValue)) {
				status = true;
			    testStepPassed("Search secrets should displayed in the Secrets section");
			    vstsTestStepPassed("Search secrets should displayed in the Secrets section", true);
			    break;
			}
		}
		if(!status) {
			testStepFailed("Search secrets is not displayed in the Secrets section");
			vstsTestStepFailed("Search secrets is not displayed in the Secrets section", true);
		}
		
		clickOn(Advance_page_link);
		
	}

	
	public void CheckCreateSecreteInBasicLink(String SecretItem, String SecretName, String AccountNumber, String RoutingNumber,
			String BankName, String AddressOne, String SecondAddress, String thirdAddress, String ContactPerson, String ContactPhone, String Notes, 
			String folderPath, String folderName) {
		
		try {
			clickOn(Basic_link);
			
			if (elementPresent("Basic link page#xpath=//div[@id='homeContainer']/fieldset[@class='searchContainer']")) {
				testStepPassed("Simple page is displayed");
				vstsTestStepPassed("Simple page is not displayed", true);
			}
			else {
				testStepFailed("Simple page is not displayed");
				vstsTestStepFailed("Simple page is not displayed", true);
			}
			
			
			if (elementPresent(txt_recent_secret)) {
			clickOn(btn_create_secret_button);
			waitTime(2);
			
			if (elementPresent("Create New Secret Page#xpath=//table[@id='SecretViewDialog_DialogTable']//td[@class='dialog_top']")) {
				testStepPassed("Create New Secret page is displayed");
				vstsTestStepPassed("Create New Secret page is displayed", true);
			}
			else {
				testStepFailed("Create New Secret page is not displayed");
				vstsTestStepFailed("Create New Secret page is displayed", true);
			}
			
			CreateBankAccountSecretTemplateFromBasiclink(SecretItem, SecretName, AccountNumber, RoutingNumber, BankName, AddressOne, SecondAddress, 
					thirdAddress, ContactPerson, ContactPhone, Notes, folderPath, folderName);
			
			
			String SecretnameGUI =  getText("secret Template name#xpath=//span[text()='Secret Name']/parent::td/following-sibling::td//span");
			if (SecretnameGUI.equals(SecretName)) {
				vstsTestStepPassed("Secret is created ", true);
			}
			else {
				vstsTestStepFailed("Secret is not created", false);
			}
			
		
			clickOn(btn_Back_Button);
			
			if (elementPresent("Basic link page#xpath=//div[@id='homeContainer']/fieldset[@class='searchContainer']")) {
				testStepPassed("Simple dashboard page is displayed");
				vstsTestStepPassed("Simple dashboard page is  displayed", true);
			}
			else {
				testStepFailed("Simple dashboard page is not displayed");
				vstsTestStepFailed("Simple dashboard page is not displayed", true);
			}
			
			
			
			List<WebElement> SecretTitles = driver.findElementsByXPath("//legend[text()='Recent Secrets']/following-sibling::div//label[@class='tileName']");
			boolean status = false;
			for (WebElement titles: SecretTitles) {
				String Gui_SecretTitle = titles.getText();
				if (SecretName.equals(Gui_SecretTitle)) {
					testStepPassed(SecretName +" Secret is displayed in Recent Secrets");
					vstsTestStepPassed(SecretName +" Secret is displayed in Recent Secrets", true);
					status = true;
					break;
				}
			}
			if (!status) {
				testStepFailed(SecretName+" Secret is not displayed in Recent Secrets");
				vstsTestStepFailed(SecretName+" Secret is not displayed in Recent Secrets", true);
			}
			
			clickOn(Advance_page_link);
			deleteSecretfromdashboard(SecretName);
			}
			else {
				testStepFailed("Basic link page is not displayed");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void VerifySqlServerLaunch(String SecretName) {
		String dir = System.getProperty("user.dir");
		String line;
		boolean status = false;
		clickOn(OR.btn_home_icon);
		clickOn(Basic_link);
		
		if (elementPresent("Basic link page#xpath=//div[@id='homeContainer']/fieldset[@class='searchContainer']")) {
			testStepPassed("Simple page is displayed");
			vstsTestStepPassed("Simple page is not displayed", true);
		}
		else {
			testStepFailed("Simple page is not displayed");
			vstsTestStepFailed("Simple page is not displayed", true);
		}
		
		if (elementPresent(txt_recent_secret)) {
			try {
				closerApplication("RDPWin.WatchDog.exe");
				clickOn("Expending secret in Recent Secret#xpath=//legend[text()='Recent Secrets']/following-sibling::div//label[text()='"+SecretName+"']");
			    
				if (elementPresent(btn_launch_icon)) {
					testStepPassed("Secret is open in simple home page");
					vstsTestStepPassed("Secret is seleted in Simple home page", true);
					clickOn(btn_launch_icon);
				}
				else {
					testStepFailed("Secret is not opened in simple home page");
					vstsTestStepPassed("Secret is not opened in simple home page", true);
				}

			    Process process = Runtime.getRuntime().exec(dir+"\\AutoIt\\SqlServerLuncher.exe");
			    waitTime(2);
			    
			    if(VerifyApplicationIsLaunch("RDPWin.WatchDog.exe")) {
			    	testStepPassed("Sql application is launch");
			    	vstsTestStepPassed("Sql application is launch", true);
			    }
			    else {
			    	testStepFailed("Sql application is not launched");
			    	vstsTestStepFailed("Sql application is not launched", true);
			    }
			    
//			    BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
//				while ((line = reader.readLine()) != null) {
//					if (line.contains("Microsoft SQL Server Management Studio")) {
//						testStepPassed("Microsoft SQL Server Management Studio is Lunched");
//						System.out.println("Microsoft SQL Server Management Studio is Lunched");
//						status = true;
//						break;
//					}
//				}
//				
//				if (!status) {
//					testStepFailed("Microsoft SQL Server Management Studio is not Lunched");
//				}
////				
//		    	VerifyApplicationIsLaunch("RDPWin.WatchDog.exe");
		    	clickOn(OR.btn_AdbancedTab);
	//	    	closerApplication("RDPWin.WatchDog.exe");
		    }
		    catch (Exception e) {
		    	e.printStackTrace();
		    }
		}
		else {
			testStepFailed("Basic link page is not displayed");
		} 
		
	}
	
	public void VerifyRemortMachineLaunch(String SecretName) {
		String dir = System.getProperty("user.dir");
		clickOn(OR.btn_home_icon);
		clickOn(Basic_link);
		
		if (elementPresent("Basic link page#xpath=//div[@id='homeContainer']/fieldset[@class='searchContainer']")) {
			testStepPassed("Simple page is displayed");
			vstsTestStepPassed("Simple page is not displayed", true);
		}
		else {
			testStepFailed("Simple page is not displayed");
			vstsTestStepFailed("Simple page is not displayed", true);
		}
		
		if (elementPresent(txt_recent_secret)) {
			try {
				closerApplication("RDPWin.WatchDog.exe");
				clickOn("Expending secret in Recent Secret#xpath=//legend[text()='Recent Secrets']/following-sibling::div//label[text()='"+SecretName+"']");
			    clickOn(btn_launch_icon);
			  
			    waitTime(2);	    	
		    	Runtime.getRuntime().exec(dir+"\\AutoIt\\OpenUrlLink.exe");
		    	waitTime(2);
		    	
		    	if(VerifyApplicationIsLaunch("RDPWin.WatchDog.exe")) {
		    		testStepPassed("Remort Machine is launched");
		    		 vstsTestStepPassed("pop up is displayed", true);
		    	}
		    	else {
		    		testStepFailed("Remort Machine is not launched");
		    		vstsTestStepFailed("pop up is not displayed", true);
		    	}

		    	
		    	String Remortfirstpopup = "This remote connection could harm your local or remote computer. Do not connect unless you know where this connection came from or have used it before.";
		    	if (validatetitleWithAutoit(dir+"\\AutoIt\\ReturnTitle.exe "+"Remote Desktop Connection", Remortfirstpopup)) {
		    		testStepPassed("Remote Desktop connection popup should be displayed");
		    		vstsTestStepPassed("Remote Desktop connection popup should be displayed", true);
		    	}
		    	else {
		    		testStepFailed("Remote Desktop connection popup should not be displayed");
		    		vstsTestStepFailed("Remote Desktop connection popup should not be displayed", true);
		    	}
		    	
				
		    	 
		    	Runtime.getRuntime().exec(dir+"\\AutoIt\\RemortMachinePopOKYesButton.exe Button11");
		    	
		    	waitTime(10);
		    	

		    	
		    	String RemortSecondpopup = "The remote computer could not be authenticated due to problems with its security certificate. It may be unsafe to proceed.";
		    	
		    	if (validatetitleWithAutoit(dir+"\\AutoIt\\ReturnTitle.exe "+"Remote Desktop Connection", RemortSecondpopup)) {
		    		testStepPassed("Remote Desktop connection popup should be displayed");
		    		vstsTestStepPassed("Remote Desktop connection popup should be displayed", true);
		    	}
		    	else {
		    		testStepFailed("Remote Desktop connection popup should not be displayed");
		    		vstsTestStepFailed("Remote Desktop connection popup should not be displayed", true);
		    	}
		    	
			
				Runtime.getRuntime().exec(dir+"\\AutoIt\\RemortMachinePopOKYesButton.exe Button5");
				
				waitTime(10);
				if (validatetitleWithAutoit(dir+"\\AutoIt\\ReturnTitle.exe "+"192 - 192.168.1.138 - Remote Desktop Connection", "192 - 192.168.1.138 - Remote Desktop")) {
		    		testStepPassed("Remote Desktop connection popup should be displayed");
		    		vstsTestStepPassed("Remote Desktop connection popup should be displayed", true);
		    	}
		    	else {
		    		testStepFailed("Remote Desktop connection popup should not be displayed");
		    		vstsTestStepFailed("Remote Desktop connection popup should not be displayed", true);
		    	}
				
				waitTime(3);
				
		    	clickOn(OR.btn_AdbancedTab);
		    	waitTime(3);
		    	closerApplication("RDPWin.WatchDog.exe");
		    	
		    	
		    }
		    catch (Exception e) {
		    	e.printStackTrace();
		    }
		}
		else {
			testStepFailed("Basic link page is not displayed");
		} 
		
	}
	
}
