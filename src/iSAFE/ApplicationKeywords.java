package iSAFE;

import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.SwitchToWindow;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.css.ElementCSSInlineStyle;
import org.xml.sax.SAXException;

import com.google.common.util.concurrent.UncheckedExecutionException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import AutomationFramework.APIKeywords;
import AutomationFramework.GenericKeywords;
import Utilities.Mailing;
import Utilities.ZipReportFile;
import baseClass.BaseClass;
import net.sourceforge.htmlunit.corejs.javascript.ast.SwitchCase;
import objectRepository.OR;
public class ApplicationKeywords extends APIKeywords
{
    public static String password;
	public ApplicationKeywords(BaseClass obj) {
		// TODO Auto-generated constructor stub
		super(obj);
	}
	public ApplicationKeywords()
	{

	}
	
	public static void sendMail()
	{
		if(GenericKeywords.getConfigProperty("SendMail(Yes/No)").equalsIgnoreCase("Yes"))
		{
			ZipReportFile.zipReport();
			Mailing.sendAttachmentMail(GenericKeywords.timeStamp+".zip");
		}
	}
	
	public boolean validateWebElements(String Xpath, String fields) {
		boolean elem_Status = false;
		try {
			List<WebElement> elements= driver.findElementsByXPath(Xpath);
			String[] values = fields.split("##");
			for (String uservalue:values) {
				boolean status = false;
				for (WebElement ele:elements) {
					String elementvalue = ele.getText();
					if (elementvalue.equalsIgnoreCase(uservalue)) {
						status = true;
						elem_Status = true;
					    testStepPassed("'"+uservalue+"' Field is present");
					    break;
					}
				}
				if(!status) {
					testStepFailed("'"+uservalue+"' Field is not present");
					elem_Status = false;
					break;
				}
			}
			
		}
		catch(Exception e) {
			elem_Status = false;
			e.printStackTrace();
			System.out.println(e);
		}
		
		return elem_Status;
	}
	
	
	
	public void validateElementSisDisplayed(String xpath) {
		
	}
	
	
	public void validateElementType (String xpath,String Type) {
		String attributetype = getAttributeValue(xpath, "type");
		if (attributetype.equals(Type)) {
			testStepPassed("Element Type is Same");
		}
		else {
			testStepFailed("Element Type is Not Same");
		}
	}
	
	public void validateDashboardPageDisplayed() {
		waitTime(3);
		if (elementPresent("Browser Button in DashBoard#xpath=//td[text()='Browse']")) {
			testStepPassed("Successfully Login to SecretServer");
			vstsTestStepPassed("Successfully Login to SecretServer", false);
		}
		else {
			testStepFailed("Failed to Login SecretServer");
			vstsTestStepFailed("Failed to Login SecretServer", true);
		}
	}
	
	
	public void dragAndDrop(String sourceLocator, String destinationLocator)
	{
		try {


			WebElement source = driver.findElement(By.xpath(sourceLocator));
			WebElement destination = driver.findElement(By.xpath(destinationLocator));
			Actions act=new Actions(driver);
			Action dragAndDrop = act.clickAndHold(source).moveToElement(destination).release(destination).build();
			dragAndDrop.perform();
			//act.dragAndDrop(source, destination).build().perform();

		}catch(Exception ex)
		{
			System.out.println("Exception in Drag and Drop Method "+ ex);
			ex.printStackTrace();
		}
	}
	
	
	public void dragAndDropDashboard(String sourceLocator, String destinationLocator)
	{
		try {
			if(elementDisplayed("//div[@class='ToolBoxContainer']", "ContentBox"))
			{
				
				waitTime(2);
				WebElement source = driver.findElement(By.xpath(sourceLocator));
				WebElement destination = driver.findElement(By.xpath(destinationLocator));
				Actions act=new Actions(driver);
				Action dragAndDrop = act.clickAndHold(source).moveToElement(destination).release(destination).build();
				dragAndDrop.perform();
			}
			else
			{
				clickOn(OR.btn_content);
				waitTime(2);
				WebElement source = driver.findElement(By.xpath(sourceLocator));
				WebElement destination = driver.findElement(By.xpath(destinationLocator));
				Actions act=new Actions(driver);
				Action dragAndDrop = act.clickAndHold(source).moveToElement(destination).release(destination).build();
				dragAndDrop.perform();
			}


		}catch(Exception ex)
		{
			System.out.println("Exception in Drag and Drop Method "+ ex);
			ex.printStackTrace();
		}
	}
	
	
	public boolean elementDisplayed(String locator, String Elementname)
	{

		boolean flag = false;

		try {


			if(driver.findElement(By.xpath(locator)).isDisplayed())
			{
				testStepInfo(Elementname+" is Displayed in the page");
				flag = true;
			}
			

		}
		catch(Exception ex)
		{
			System.out.println("Exception in elementDisplayed"+ex);
			ex.printStackTrace();
		}

		return flag;

	}
//	public void checkSecretWidgetIspresent(String ContentIcon) {
//		try {
//			if (elementPresent(ContentIcon+" is pesent in  dashboard#xpath=//h2[text()='"+ContentIcon+"']")) {
//				testStepPassed(ContentIcon+" is present in dashboared");
//				//vstsTestStepPassed(ContentIcon+" is present in dashboared", false);
//			}
//			else {
//				clickOn(OR.btn_content);
//				dragAndDrop("//li/nobr[text()='"+ContentIcon+"']", "//ul[@id='Ul3']");
//				if (elementPresent(ContentIcon+" is pesent in dashboard#xpath=//h2[text()='"+ContentIcon+"']")) {
//					testStepPassed(ContentIcon+" is present in DashBoared page");
//					//vstsTestStepPassed(ContentIcon+" is present in DashBoared page", false);
//				}
//				else {
//					testStepFailed(ContentIcon+" is not present in DashBoared page");
//					//vstsTestStepFailed(ContentIcon+" is not present in DashBoared page", false);
//				}
//			}
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	public void validateDashboard()
	{
		try {
			String confirmDashboard = getText(OR.lbl_Browse);
			if(confirmDashboard.equalsIgnoreCase("Browse")) {
				testStepPassed("Navigated to DashBoard Page");
			}
			else {
				testStepFailed("Unable to navigate to DashBoard Page");
			}
		}
		catch(Exception ex) {
			System.out.println("Exception in validateDashboard Method "+ ex);
			ex.printStackTrace();
		}
	}
	
	

	
	public void clickHereToLoginLink() {
		try {
			if(isElementDisplayed(GOR.txt_Logout_page)) {
				clickOn(GOR.link_Click_To_login);
				if (elementPresent(GOR.txt_ThycoticLoginPage)) {
					testStepPassed("Launch Url Successfully");
				}
				else {
					testStepFailed("Launch Url Not successfully");
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void CreateBankAccountSecretTemplate(String SecretItem, String SecretName, String AccountNumber, String RoutingNumber,
			String BankName, String AddressOne, String SecondAddress, String thirdAddress, String ContactPerson, String ContactPhone,
			String Notes, String folderPath, String folderName) {
	
		
		try {
			openSecreteTemplatePage(SecretItem);

			typeIn("Secret Name#id=SecretNameTextBox", SecretName);
			typeIn("Secret Account Number#id=SecretItemDisplay_SecretItemsRepeater_ctl00_ItemValueTextBox", AccountNumber);
			typeIn("Routing Number#id=SecretItemDisplay_SecretItemsRepeater_ctl01_ItemValueTextBox", RoutingNumber);
			typeIn("Bank Name#id=SecretItemDisplay_SecretItemsRepeater_ctl02_ItemValueTextBox", BankName);
			typeIn("Address 1#id=SecretItemDisplay_SecretItemsRepeater_ctl03_ItemValueTextBox", AddressOne);
			typeIn("Second address#id=SecretItemDisplay_SecretItemsRepeater_ctl04_ItemValueTextBox", SecondAddress);
			typeIn("third address#id=SecretItemDisplay_SecretItemsRepeater_ctl05_ItemValueTextBox", thirdAddress);
			typeIn("Contact Person#id=SecretItemDisplay_SecretItemsRepeater_ctl06_ItemValueTextBox", ContactPerson);
			typeIn("Contact Phone#id=SecretItemDisplay_SecretItemsRepeater_ctl07_ItemValueTextBox", ContactPhone);
			typeIn("Notes#id=SecretItemDisplay_SecretItemsRepeater_ctl08_ItemValueTextBox", Notes);
			
			
			if (elementPresent("clear folder#id=SecretFolderPicker_ClearFolderLink")) {
				clickOn("clear folder#id=SecretFolderPicker_ClearFolderLink");
			}
			if (elementPresent("No Selected Folder#id=SecretFolderPicker_FolderLink")) {  
				clickOn("No Selected Folder#id=SecretFolderPicker_FolderLink");
				switchToFrame("ifram#xpath=//iframe[@id='popupFrame']");
				typeIn("search box for folder path#xpath=//span[text()='Folder Search']/following-sibling::input", folderName);
				clickOn("click on folder#xpath=//div[text()='"+folderPath+"']");
			}
			
			clickOn("SecretTemplate Save button#id=SaveEditButton");
			if (elementPresent("secret Template name#xpath=//span[text()='Secret Name']/parent::td/following-sibling::td//span")) {
				String SecretnameGUI =  getText("secret Template name#xpath=//span[text()='Secret Name']/parent::td/following-sibling::td//span");
				if (SecretnameGUI.equals(SecretName)) {
					testStepPassed("Secret Name is same : "+SecretName);
				}
				else {
					testStepFailed("Secret Name is different : "+SecretName);
				}
			}
			
			else {
				testStepFailed("Creted Secrete Template is not present");
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void CreateCiscoAcountSecretTemplate(String SecretItem, String SecretName, String Host, String Username,
			String Password, String Notes, String folderPath, String folderName, String Inherit_Secret_Policy, String Secret_Policy, String AutoChange) {
	
		
		try {
			openSecreteTemplatePage(SecretItem);

			typeIn("Secret Name#id=SecretNameTextBox", SecretName);
			typeIn("Secret Host Number#id=SecretItemDisplay_SecretItemsRepeater_ctl00_ItemValueTextBox", Host);
			typeIn("Cisco Account Username#id=SecretItemDisplay_SecretItemsRepeater_ctl01_ItemValueTextBox", Username);
			typeIn("Cisco Account Password#id=SecretItemDisplay_SecretItemsRepeater_ctl02_ItemValueTextBox", Password);
			typeIn("Cisco Account Note#id=SecretItemDisplay_SecretItemsRepeater_ctl03_ItemValueTextBox", Notes);
			if (elementPresent("clear folder#id=SecretFolderPicker_ClearFolderLink")) {
				clickOn("clear folder#id=SecretFolderPicker_ClearFolderLink");
			}
			if (elementPresent("No Selected Folder#id=SecretFolderPicker_FolderLink")) {  
				clickOn("No Selected Folder#id=SecretFolderPicker_FolderLink");
				switchToFrame("ifram#xpath=//iframe[@id='popupFrame']");
				typeIn("search box for folder path#xpath=//span[text()='Folder Search']/following-sibling::input", folderName);
				clickOn("click on folder#xpath=//div[text()='"+folderPath+"']");
			}
			
			
			if (Inherit_Secret_Policy.equals("Yes")) {
				selectCheckBox(OR.chk_Cissco_SSh_Inherit_secret_policy);
			}
			else if(Inherit_Secret_Policy.equals("No")) {
				unSelectCheckBox(OR.chk_Cissco_SSh_Inherit_secret_policy);
				selectFromDropdown( "Secret policy in SSh Account#id=SecretPolicyDropDownList", Secret_Policy);
			}
			
			if (AutoChange.equals("Yes")) {
				selectCheckBox(OR.chk_Cissco_SSh_AutoChange);
			}
			
			
			
			clickOn("SecretTemplate Save button#id=SaveEditButton");
			if (elementPresent("secret Template name#xpath=//span[text()='Secret Name']/parent::td/following-sibling::td//span")) {
				String SecretnameGUI =  getText("secret Template name#xpath=//span[text()='Secret Name']/parent::td/following-sibling::td//span");
				if (SecretnameGUI.equals(SecretName)) {
					testStepPassed("Secret Name is same : "+SecretName);
				}
				else {
					testStepFailed("Secret Name is different : "+SecretName);
				    }
			}
			else {
				testStepFailed("Secrete Template is not created");
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void CreateSqlSecretTemplate(String SecretItem, String SecretName, String Server, String Username,
			String Password, String Notes, String folderPath, String folderName, String Inherit_Secret_Policy, String Secret_Policy, String AutoChange) {
	
		
		try {
			openSecreteTemplatePage(SecretItem);

			typeIn("Secret Name#id=SecretNameTextBox", SecretName);
			typeIn("Entering Server or Doman name#id=SecretItemDisplay_SecretItemsRepeater_ctl00_ItemValueTextBox", Server);
			typeIn("Entering Username textbox#id=SecretItemDisplay_SecretItemsRepeater_ctl01_ItemValueTextBox", Username);
			typeIn("Entering Password textbox#id=SecretItemDisplay_SecretItemsRepeater_ctl02_ItemValueTextBox", Password);
			typeIn("Entering Note textbox#id=SecretItemDisplay_SecretItemsRepeater_ctl03_ItemValueTextBox", Notes);
			if (elementPresent("clear folder#id=SecretFolderPicker_ClearFolderLink")) {
				clickOn("clear folder#id=SecretFolderPicker_ClearFolderLink");
			}
			if (elementPresent("No Selected Folder#id=SecretFolderPicker_FolderLink")) {  
				clickOn("No Selected Folder#id=SecretFolderPicker_FolderLink");
				switchToFrame("ifram#xpath=//iframe[@id='popupFrame']");
				typeIn("search box for folder path#xpath=//span[text()='Folder Search']/following-sibling::input", folderName);
				clickOn("click on folder#xpath=//div[text()='"+folderPath+"']");
			}
			
			
			if (Inherit_Secret_Policy.equals("Yes")) {
				selectCheckBox(OR.chk_Cissco_SSh_Inherit_secret_policy);
			}
			else if(Inherit_Secret_Policy.equals("No")) {
				unSelectCheckBox(OR.chk_Cissco_SSh_Inherit_secret_policy);
				selectFromDropdown( "Secret policy in SSh Account#id=SecretPolicyDropDownList", Secret_Policy);
			}
			
			if (AutoChange.equals("Yes")) {
				selectCheckBox(OR.chk_Cissco_SSh_AutoChange);
			}
			
			
			
			clickOn("SecretTemplate Save button#id=SaveEditButton");
			if (elementPresent("secret Template name#xpath=//span[text()='Secret Name']/parent::td/following-sibling::td//span")) {
				String SecretnameGUI =  getText("secret Template name#xpath=//span[text()='Secret Name']/parent::td/following-sibling::td//span");
				if (SecretnameGUI.equals(SecretName)) {
					testStepPassed("Secret Name is same : "+SecretName);
				}
				else {
					testStepFailed("Secret Name is different : "+SecretName);
				    }
			}
			else {
				testStepFailed("Secrete Template is not created");
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}
	
	
	public void CreateWindowAccountSecretTemplateWithListPermision(String SecretItem, String SecretName, String Server, String Username,
			String Password, String Notes, String folderPath, String folderName, String Inherit_Secret_Policy, String Secret_Policy, String AutoChange) {
	
		
		try {
			openSecreteTemplatePage(SecretItem);

			typeIn("Secret Name#id=SecretNameTextBox", SecretName);
			typeIn("Entering Server or Doman name#id=SecretItemDisplay_SecretItemsRepeater_ctl00_ItemValueTextBox", Server);
			typeIn("Entering Username textbox#id=SecretItemDisplay_SecretItemsRepeater_ctl01_ItemValueTextBox", Username);
			typeIn("Entering Password textbox#id=SecretItemDisplay_SecretItemsRepeater_ctl02_ItemValueTextBox", Password);
			typeIn("Entering Note textbox#id=SecretItemDisplay_SecretItemsRepeater_ctl03_ItemValueTextBox", Notes);
			if (elementPresent("clear folder#id=SecretFolderPicker_ClearFolderLink")) {
				clickOn("clear folder#id=SecretFolderPicker_ClearFolderLink");
			}
			if (elementPresent("No Selected Folder#id=SecretFolderPicker_FolderLink")) {  
				clickOn("No Selected Folder#id=SecretFolderPicker_FolderLink");
				switchToFrame("ifram#xpath=//iframe[@id='popupFrame']");
				typeIn("search box for folder path#xpath=//span[text()='Folder Search']/following-sibling::input", folderName);
				clickOn("click on folder#xpath=//div[text()='"+folderPath+"']");
			}
			
			
			if (Inherit_Secret_Policy.equals("Yes")) {
				selectCheckBox(OR.chk_Cissco_SSh_Inherit_secret_policy);
			}
			else if(Inherit_Secret_Policy.equals("No")) {
				unSelectCheckBox(OR.chk_Cissco_SSh_Inherit_secret_policy);
				selectFromDropdown( "Secret policy in SSh Account#id=SecretPolicyDropDownList", Secret_Policy);
			}
			
			if (AutoChange.equals("Yes")) {
				selectCheckBox(OR.chk_Cissco_SSh_AutoChange);
			}
			
			
			
			clickOn("SecretTemplate Save button#id=SaveEditButton");
			if (elementPresent("secret Template name#xpath=//td[@class='dialog_top' and contains(text(),'Access')]")) {
				String SecretnameGUI =  getText("No Access Error Message#id=NoAccessMessageLabel");
				if (SecretnameGUI.equals("You do not have permissions to view this Secret. If you think you should have access, then please contact the person who sent you this Secret and ask them to share it with you.")) {
					clickOn("ContinueButton in NO Access Page#id=ContinueButton");
				}
			}
			else {
				testStepFailed("Secrete Template is not created");
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}
	
	
	
	
	public void openSecreteTemplatePage(String SecretTemplateItem) {
		
		try {
			if(!elementPresent(OR.lbl_Browse))
			{
				clickOn(OR.btn_home_icon);
				clickOn(OR.btn_AdbancedTab);
			}
			if (elementPresent(OR.tab_Create_Secret)) {
				selectFromDropdown("select a create secret#xpath=//select[contains(@id,'CreateSecretWidget')]", SecretTemplateItem);
			}
			else {
				clickOn(OR.btn_content);
				dragAndDrop("//li/nobr[text()='Create Secret']", "//ul[@id='Ul3']");
				if (elementPresent("Create Secret is pesent in Secret widage#xpath=//h2[text()='Create Secret']")) {
					testStepPassed("Create Secret is present in DashBoared page");
				}
				else {
					testStepFailed("Create Secret is not present in DashBoared page");
				}
				clickOn(OR.btn_content);
				
				selectFromDropdown("select a create secret#xpath=//select[contains(@id,'CreateSecretWidget')]", SecretTemplateItem);
			}
			
			if (isElementDisplayed("Create Secret Page#id=SecretTypeLabel")) {
				testStepPassed("Secret Template page is displayed");
			}
			else {
				testStepFailed("Secret Template page is not displayed");
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	
	
	
	public void switchTofolders(String foldername) {
		try {
			
			if(!elementPresent(OR.lbl_Browse))
			{
				clickOn(OR.btn_home_icon);
				clickOn(OR.btn_AdbancedTab);
			}
			
			if (foldername.equals("Admin") || foldername.equals("Admin_ss")) {
				clickOn(OR.btn_Personal_Folders_DashBoard);
				//clickOn(OR.btn_Admin_Folder_DashBoard);
				clickOn( foldername+" Folders button#xpath=//label[text()='"+foldername+"']");
			}
			else {
				clickOn( foldername+" Folders button#xpath=//label[text()='"+foldername+"']");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public boolean ValidateBulkOperationOkPage(String BulkOpertion, boolean Inherit) {
		boolean messageStatus = false;
		boolean Status = false;
		
		try {
			int ButtonValue = validateElementisDisplay("Ok and cancel button in Bulkopertion#xpath=//div[@class='ui-dialog-buttonset']/button", "OK##Cancel");
   
			int Inheritfields = 0;
			if (Inherit) {
				Inheritfields = validateElementisDisplay("Inherit secret Policy#xpath=//span","Inherit Secret Policy");
				if(isElementDisplayed("Secret Server#xpath=//span[@id='ctl00_SecretPolicyDropDownListFieldLabel']")) {
					Inheritfields++;
				}
			}
			else {
				String msg_DeleteSecret = getText(OR.msg_delete_secret);
				if (msg_DeleteSecret.equals("Are you sure you want to perform this action on the selected Secrets?")) {
					testStepPassed("Message is Same for a Secret");
					messageStatus = true;
				}
				else {
					testStepFailed("Message is Different for Delete Secret Got: [' "+msg_DeleteSecret +" ']"
							+ " Expected[' Are you sure you want to perform this action on the selected Secrets? ']");
				}
			}
			
			if (Inherit && ButtonValue == 2 && Inheritfields == 2) {
				testStepPassed("Inherit fields  and ok,cancel button are present");
				Status = true;
			}
			else if(!Inherit && messageStatus && ButtonValue == 2) {
				testStepPassed("Message fields  and ok,cancel button are present");
				Status = true;
			}
			else {
				testStepFailed("Message or ok,cancel button are not present");
				Status = false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		return Status;
	}
	
	public boolean ValidateBulkOperationComplatePage(String SecretName, String BulkOperation, String BulkErrorMessageXpath, String BulkOperationErrorMsg) {
		 
		    boolean Status = false;
			waitForElementToDisplay("text for Bulk operation completed#xpath=//div[@id='CompleteMessage']", 10);
			
			int CompleteMsg = validateElementisDisplay("Complate Messgae#xpath=//div", "Bulk operation completed.");
			
			int ErrorMsg = validateElementisDisplay(BulkErrorMessageXpath, BulkOperationErrorMsg);
			int CloseButton = validateElementisDisplay("Error Message#xpath=//div[@class='ui-dialog-buttonset']/button", "Close");
			
			if (CompleteMsg+ErrorMsg+CloseButton == 3) {
				testStepPassed("Complete,Error message and Close Button is present");
				Status = true;
			}
			else {
				testStepFailed("Complete message or Error message or Close Button is not present");
				Status = false;
			}
			
		return Status;
	}
	
	public boolean SecretIsCheck(String SecretName ) {
		boolean status = false;
		try {
			
			clickOn(OR.btn_home_icon);
			waitTime(2);
			if (driver.findElementByXPath("//td[text()='"+SecretName+"']/preceding-sibling::td/input").isEnabled()) {
				status = true;
			}
			else {
				testStepFailed(SecretName+ " is not checked");
				status = false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}
	
	
	public void SetBulkOperationSecret(String SecretName, String BulkOperation) {
		try {
			if (elementPresent("Secret in Dashboard#xpath=//td[text()='"+SecretName+"']")) {
				selectCheckBox("enable secret in dashboard#xpath=//td[text()='"+SecretName+"']/preceding-sibling::td/input");
				selectFromDropdown(OR.drpdown_Selectbulkoperation, BulkOperation);
				
				if (elementPresent("Bulk Operation: Delete box#xpath=//span[text()='Bulk Operation: Delete']")) {
					testStepPassed("'Bulk Operation: Delete' page should be displayed");
				}
				else {
					testStepFailed("'Bulk Operation: Delete' page should not be displayed");
				}
				
			    clickOn("Ok button in Bulk Option#xpath=//div[@class='ui-dialog-buttonset']/button[text()='OK']");
			    clickOn("close button #xpath=//div[@class='ui-dialog-buttonset']/button[text()='Close']");
				
			}
			else {
				testStepFailed("' "+SecretName+"' Secret is not present in Dashboard");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void deleteSecretfromdashboard(String SecretNames) {
		try {
			
			if(!elementPresent(OR.lbl_Browse))
			{
				clickOn(OR.btn_home_icon);
				clickOn(OR.btn_AdbancedTab);
			}
			
			clickOn("All Folder in Home Page#xpath=//label[text()='< All Folders >']");
			String[] secretname = SecretNames.split("##");
			for (String Name:secretname) {
				if (elementPresent("Secret in Dashboard#xpath=//td[text()='"+Name+"']")) {
					selectCheckBox("enable secret in dashboard#xpath=//td[text()='"+Name+"']/preceding-sibling::td/input");
				}
				else {
					testStepFailed("' "+Name+"' Secret is not present in Dashboard");
				}
			}
			selectFromDropdown(OR.drpdown_Selectbulkoperation, "Delete");
			if (elementPresent("Bulk Operation: Delete box#xpath=//span[text()='Bulk Operation: Delete']")) {
				testStepPassed("'Bulk Operation: Delete' page should be displayed");
			}
			else {
				testStepFailed("'Bulk Operation: Delete' page should not be displayed");
			}
			
			clickOn("Ok button in Bulk Option#xpath=//div[@class='ui-dialog-buttonset']/button[text()='OK']");
			clickOn("close button #xpath=//div[@class='ui-dialog-buttonset']/button[text()='Close']");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void deleteSecretfromNewuser(String SecretNames, String CurrentPassword) {
		try {
			
			
			if (elementPresent("change password title#xpath=//table[@id='AdministrationDialog_DialogTable']//td[@class='dialog_top']")) {
				typeIn("change password field#id=ChangePasswordUserControl_CurrentPasswordTextBox", CurrentPassword);
				typeIn("new password#id=ChangePasswordUserControl_NewPasswordTextBox", "test@1234");
				typeIn("confirm password#id=ChangePasswordUserControl_ConfirmTextBox", "test@1234");
				clickOn("Save button#id=ChangePasswordUserControl_SaveButton");
				
				if(elementPresent("welcome page#xpath=//span[text()='Welcome to Secret Server']")) {
					clickOn("close#xpath=//button[@title='Close']");
				}
				
				waitTime(3);
				clickOn(OR.btn_Profile_Icon);
				clickOn("Change password link#xpath=//ul[@class='linkList']//a[text()='Change Password']");
				if (elementPresent("change password title#xpath=//table[@id='AdministrationDialog_DialogTable']//td[@class='dialog_top']")) {
					typeIn("change password field#id=ChangePasswordUserControl_CurrentPasswordTextBox", "test@1234");
					typeIn("new password#id=ChangePasswordUserControl_NewPasswordTextBox", CurrentPassword);
					typeIn("confirm password#id=ChangePasswordUserControl_ConfirmTextBox", CurrentPassword);
					clickOn("Save button#id=ChangePasswordUserControl_SaveButton");			
				}
			}
			deleteSecretfromdashboard(SecretNames);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public boolean EnableDisableRemotePasswordChangingParameters(String RemotePasswordParams, String RemotePasswordParamsStatus) {
		mouseOver(OR.btn_Admin_Tab);
		Boolean Status = false;
		try {
			clickOn(OR.btn_Remote_Password_Change);
			if (elementPresent(OR.Remote_Password_Change_Page_dialog_top)) {
				testStepPassed("Remote Password Change Page is displayed");			
				String BeforePasswordChangeStatus = getText("text for Remote Change Password Parameters#xpath=//span[text()='"+RemotePasswordParams+"']/parent::td/following-sibling::td/span[@class='Label']");
				
				if (BeforePasswordChangeStatus.equals(RemotePasswordParamsStatus)) {
					clickOn(OR.btn_home_icon);
					Status = true;
				}
				else {
					clickOn(OR.btn_Remote_Password_Change_Edit);
			        selectCheckBox("Disable a "+RemotePasswordParams+" in remote change password#xpath=//span[text()='"+RemotePasswordParams+"']/parent::td/following-sibling::td/span[@class='CheckBox']");
			        clickOn(OR.btn_Remote_Password_Change_Save);
					String PasswordChangeStatus = getText("text for Remote Change Password Parameters#xpath=//span[text()='"+RemotePasswordParams+"']/parent::td/following-sibling::td/span[@class='Label']");
					if (PasswordChangeStatus.equals(RemotePasswordParamsStatus)) {
						testStepPassed("RemotePasswordParams is PasswordChangeStatus");
						Status = true;
					}
					else {
						testStepFailed("Enable Remote Password Changing is unchecked"+PasswordChangeStatus);
						Status = false;
					}
				}           
			}
			else {
				testStepFailed("Remote Password Change Page is not displayed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Status;
	}
	
	
	public boolean enableDiasableRemotePasswordandHBInSecretTemplates(String SecretTemplate, String SecretTemplateParas, String SecretTemplateHearthbeatStatus) {
		boolean Status = false;
		try {
			mouseOver(OR.btn_Admin_Tab);
			clickOn(OR.btn_Secret_Template);
			
			if (elementPresent(OR.Secret_Template_Page)) {
				testStepPassed("Secret Template page is displayed");
				selectFromDropdown("select a secret template#id=SecretDropDownList", SecretTemplate);
				clickOn("clicking edit button in Secret Template#xpath=//button[text()='Edit']");
				
				if (elementPresent(OR.Secret_Template_Edit_Page)) {
					testStepPassed("Secret Template Edit page is displayed");
					clickOn("clicking 'Configure Password Changing' in Secret Template Designer page #xpath=//button[text()='Configure Password Changing']");
				    String HeartBeatStatus = getText("status for "+SecretTemplateParas+"#xpath=//span[text()='"+SecretTemplateParas+"']/parent::td/following-sibling::td/span[@class='Label']");
				    if (HeartBeatStatus.equals(SecretTemplateHearthbeatStatus)) {
						clickOn(OR.btn_home_icon);
						Status = true;
					}
					else {
						clickOn("clicking edit button in Secret Template#xpath=//button[text()='Edit']");
			            clickOn("Enable HearthBeaa Checkboxt#xpath=//span[text()='"+SecretTemplateParas+"']/parent::td/following-sibling::td//input[@type='checkbox']");
			            clickOn(OR.btn_Remote_Password_Change_Save);
			            String HeartBeatStatusafter = getText("status for "+SecretTemplateParas+"#xpath=//span[text()='"+SecretTemplateParas+"']/parent::td/following-sibling::td/span[@class='Label']");
						if (SecretTemplateHearthbeatStatus.equals(HeartBeatStatusafter)) {
							testStepPassed(SecretTemplateParas+" in secret template is "+SecretTemplateHearthbeatStatus);
							Status = true;
						}
						else {
//						System.out.println("PasswordChangeStatus"+PasswordChangeStatus);
							testStepFailed(SecretTemplateParas+" in secret template is unchecked"+SecretTemplateHearthbeatStatus);
							Status = false;
						}
					}    
				}
				else {
					testStepFailed("Secret Template Edit Page is Not displayed");
				}
			}
			else {
				testStepFailed("Secret Template page is not displayed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Status;
	}
	
	
	
	public void enableSecretInDashboard(String[] SecretName, String foldername) {
		try {
			switchTofolders(foldername);
			for (String Name:SecretName) {
				if (elementPresent("Secret in Dashboard#xpath=//td[text()='"+Name+"']")) {
					selectCheckBox("enable secret in dashboard#xpath=//td[text()='"+Name+"']/preceding-sibling::td/input");
				}
				else {
					testStepFailed("' "+Name+"' Secret is not present in Dashboard");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void CreateBankAccountSecretTemplateFromBasiclink(String SecretItem, String SecretName, String AccountNumber, String RoutingNumber,
			String BankName, String AddressOne, String SecondAddress, String thirdAddress, String ContactPerson, String ContactPhone,
			String Notes, String folderPath, String folderName) {
	
		
		try {
			//select[contains(@id,'SecretTypeDropDown')]
			selectFromDropdown("select a create secret#xpath=//select[contains(@id,'SecretTypeDropDown')]", SecretItem);
			typeIn("Secret Name#id=SecretNameTextBox", SecretName);
			typeIn("Secret Account Number#id=SecretItemDisplay_SecretItemsRepeater_ctl00_ItemValueTextBox", AccountNumber);
			typeIn("Routing Number#id=SecretItemDisplay_SecretItemsRepeater_ctl01_ItemValueTextBox", RoutingNumber);
			typeIn("Bank Name#id=SecretItemDisplay_SecretItemsRepeater_ctl02_ItemValueTextBox", BankName);
			typeIn("Address 1#id=SecretItemDisplay_SecretItemsRepeater_ctl03_ItemValueTextBox", AddressOne);
			typeIn("Second address#id=SecretItemDisplay_SecretItemsRepeater_ctl04_ItemValueTextBox", SecondAddress);
			typeIn("third address#id=SecretItemDisplay_SecretItemsRepeater_ctl05_ItemValueTextBox", thirdAddress);
			typeIn("Contact Person#id=SecretItemDisplay_SecretItemsRepeater_ctl06_ItemValueTextBox", ContactPerson);
			typeIn("Contact Phone#id=SecretItemDisplay_SecretItemsRepeater_ctl07_ItemValueTextBox", ContactPhone);
			typeIn("Notes#id=SecretItemDisplay_SecretItemsRepeater_ctl08_ItemValueTextBox", Notes);
			
			
			if (elementPresent("clear folder#id=SecretFolderPicker_ClearFolderLink")) {
				clickOn("clear folder#id=SecretFolderPicker_ClearFolderLink");
			}
			if (elementPresent("No Selected Folder#id=SecretFolderPicker_FolderLink")) {  
				clickOn("No Selected Folder#id=SecretFolderPicker_FolderLink");
				switchToFrame("ifram#xpath=//iframe[@id='popupFrame']");
				typeIn("search box for folder path#xpath=//span[text()='Folder Search']/following-sibling::input", folderName);
				clickOn("click on folder#xpath=//div[text()='"+folderPath+"']");
			}
			
			clickOn("SecretTemplate Save button#id=SaveEditButton");
			if (elementPresent("secret Template name#xpath=//span[text()='Secret Name']/parent::td/following-sibling::td//span")) {
				String SecretnameGUI =  getText("secret Template name#xpath=//span[text()='Secret Name']/parent::td/following-sibling::td//span");
				if (SecretnameGUI.equals(SecretName)) {
					testStepPassed("Secret Name is same : "+SecretName);
				}
				else {
					testStepFailed("Secret Name is different : "+SecretName);
				    }
			}
			else {
				testStepFailed("Secrete Template is not created");
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	public String getAlertText() {
		String Alerttext = null;
		try {
		    Alerttext = driver.switchTo().alert().getText();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return Alerttext;
	}
	
	public void SwitchtoWindow(int windowindex) {
		try {
			List<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window((String) tabs.get(windowindex));
			testStepPassed("Switch to NewWindow");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// method use to close the second window and switch to first window
	public void CloseSecondWindow() {
	    try {
			List<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			if (tabs.size() == 2) {
				((JavascriptExecutor)driver).executeScript("window.close()");
			    driver.switchTo().window(tabs.get(0));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void closerApplication(String AppExeName) {
		try {
	    String st;
		String dir = System.getProperty("user.dir");
	    System.out.println("current dir = " + dir+"\\test.txt");
		File file = new File(dir+"\\data\\tasksProcesser.txt");
		if (file.exists()) {
			file.delete();
		}
		String csvPath = "cmd /c tasklist /Fo csv > \""+dir+"\\data\\tasksProcesser.txt\"";
		Runtime.getRuntime().exec(csvPath);
		waitTime(5);
		BufferedReader br = new BufferedReader(new FileReader(dir+"\\data\\tasksProcesser.txt"));
		  while ((st = br.readLine()) != null) {				  
		    if (st.contains("\""+AppExeName+"\"")) {
		    	Runtime.getRuntime().exec("taskkill /F /im "+AppExeName);
		    	break;
		    }
		  }
		  br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void waitForApplicationLunch(String AppExeName, int WaitTime) {
		try {
		    String st;
		    boolean status = false;
			String dir = System.getProperty("user.dir");
		    System.out.println("current dir = " + dir+"\\test.txt");
		    for (int i=0; i<=WaitTime; i++) {
		    	File file = new File(dir+"\\data\\tasksProcesser.txt");
				if (file.exists()) {
					file.delete();
				}
				String csvPath = "cmd /c tasklist /Fo csv > \""+dir+"\\data\\tasksProcesser.txt\"";
				Runtime.getRuntime().exec(csvPath);
				waitTime(2);
				BufferedReader br = new BufferedReader(new FileReader(dir+"\\data\\tasksProcesser.txt"));
				while ((st = br.readLine()) != null) {				  
				    if (st.contains("\""+AppExeName+"\"")) {
				    	status = true;
				    	System.out.println("Application is launched"+st);
				    	break;
				    }
				}
				if (!status) {
					  waitTime(1);
				}
				else {
					break;
				}
				br.close();
		    }
		    if (status) {
		    	testStepInfo("Application is lanuched");
		    }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public boolean VerifyApplicationIsLaunch(String AppExeName) {
		boolean VerifyStatus = false;
		try {
		    String st;
		   // boolean VerifyStatus = false;
			String dir = System.getProperty("user.dir");
			waitForApplicationLunch(AppExeName, 10);
			waitTime(5);
			BufferedReader AppBR = new BufferedReader(new FileReader(dir+"\\data\\tasksProcesser.txt"));
			while ((st = AppBR.readLine()) != null) {				  
			    if (st.contains("\""+AppExeName+"\"")) {
			    	VerifyStatus = true;
			    	testStepPassed("Application is launched");
			    	break;
			    }
			}
			if (!VerifyStatus) {
				testStepFailed("Application is not launched");
			}
			AppBR.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return VerifyStatus;
	}
	
	
	// new scripts
	
	
	public boolean validateAllElementisDisplay(String xpath, String fields) {
		Boolean Status = false;
		String[] elefields = fields.split("##"); 
		int fieldsize = elefields.length;
		int i = validateElementisDisplay(xpath, fields);
		if (i == fieldsize) {
			testStepPassed("All Fields are present");
			Status = true;
		}
		else {
			testStepFailed("Some fields are not present");
			Status = false;;
		}
		return Status;
	}
	
	public int validateElementisDisplay(String xpath, String fields) {
		String[] elefields = fields.split("##");
		int i=0;
		for (String ele:elefields) {
			if(elementPresent(xpath+"[contains(text(),'"+ele+"')]")) {
				testStepInfo(ele+" field is present");
				i++;
			}
			else {
				testStepFailed(ele+" Fields is not present");
				break;
			}
		}
		return i;
	}
	
//	public void ValidateCheckboxischecked(String xpath, String element) {
//		
//		try {
//			if (driver.findElementByXPath(xpath).isEnabled()) {
//				testStepPassed(element+" is checked");
//				vstsTestStepPassed(element+" is checked", false);
//			}
//			else {
//				testStepFailed(element+ " is not checked");
//				vstsTestStepFailed(element+ " is not checked", true);
//			}
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	public boolean ValidateEnterValusInTextField(String Xpath, String TextValue, String Field) {
		boolean Status = false;
		String Username_value = getAttributeValue(Xpath, "value");
		if (Username_value.equals(TextValue)) {
			testStepPassed(Field+" is able to enter in textfield");
			Status = true;
		}
		else {
			testStepFailed(Field+" is not able to enter in textfield");
		}
		return Status;
	}
	
	
	public boolean ValidatetextfieldwithEnteringtext(String Xpath, String TextValue, String Field) {
		
		boolean Status = false;
		typeIn(Xpath, TextValue);
		waitTime(2);
		String Username_value = getAttributeValue(Xpath, "value");
		if (Username_value.equals(TextValue)) {
			testStepPassed(Field+" is able to enter in textfield");
			Status = true;
		}
		else {
			testStepFailed(Field+" is not able to enter in textfield");
		}
		return Status;
	}
	
	public boolean PerformSecretChecked(String SecretName) {
		boolean MultipleStatus = false;
		try {
			waitTime(2);
			String[] secretname = SecretName.split("##");
			for (String Name:secretname) {
				if (elementPresent("Secret in Dashboard#xpath=//td[text()='"+Name+"']")) {
					selectCheckBox("enable secret in dashboard#xpath=//td[text()='"+Name+"']/preceding-sibling::td/input");
					if (driver.findElementByXPath("//td[text()='"+Name+"']/preceding-sibling::td/input").isEnabled()) {
						testStepPassed(Name+" is checked");
						MultipleStatus = true;
					}
					else {
						testStepFailed(Name+ " is not checked");
						MultipleStatus = false;
						break;
					}
				}
				else {
					MultipleStatus = false;
					testStepFailed("' "+Name+"' Secret is not present in Dashboard");
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return MultipleStatus;
	}
	
	//sathish
	
	public void DeleteContentInDashBoard()
	{
		try {

			List<WebElement> Del_contents = driver.findElements(By.xpath("//li[contains(@class,'ui-icon ui-icon-trash CloseWidget')]"));
			for(int i=1;i<=Del_contents.size();i++)
			{
				clickOn("Deleting the already present items#xpath=//li[contains(@class,'ui-icon ui-icon-trash CloseWidget')]");
				waitTime(2);
				alertOk();
				waitTime(2);
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public boolean validateDashboardwithVSTS()
	{
		boolean status= false;
		try {

			String confirmDashboard = getText(OR.lbl_Browse);

			if(confirmDashboard.equalsIgnoreCase("Browse"))
			{
				testStepPassed("Navigated to DashBoard Page");
				status = true;
			}

			else
			{
				testStepFailed("Unable to navigate to DashBoard Page");
				status = false;
			}


		}catch(Exception ex)
		{
			System.out.println("Exception in validateDashboard Method "+ ex);
			ex.printStackTrace();
		}
		return status;
	}
	
	public boolean validateAlertText(String AlertMsg, boolean vsts)
	{
		boolean flag = false;
		
		
		try
		{
			Alert alr = driver.switchTo().alert();
			String AlertText =alr.getText();
			
			if(AlertText.contains(AlertMsg))
			{
				testStepPassed("The Alert message is Validated");
				if(vsts==true)
				vstsTestStepPassed("The Alert message is Validated", false);
				flag = true;
			}
			else
			{
				testStepFailed("Unable to validate alert message");
				if(vsts==false)
				vstsTestStepFailed("Unable to validate alert message", true);
			}
			
		}
		catch(Exception ex)
		{
			System.out.println("Exception in validateAlertText"+ex);
			ex.printStackTrace();
		}
		return flag;
	}
	
	public void ClipBoardtoTextFile(String path) throws IOException
	{
		try
		{

			//Timestamp timestamp = new Timestamp(System.currentTimeMillis());

			PrintWriter out = new PrintWriter("D:\\Sample.txt");

			try {
				String data = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
				out.println(data);

				out.close();
			} catch (HeadlessException e) {

				e.printStackTrace();
			} catch (UnsupportedFlavorException e) {

				e.printStackTrace();
			}
		}catch(Exception ex)
		{
			System.out.println("Exception in ClipBoardtoTextFile "+ex);
			ex.printStackTrace();

		}
	}

	public void CreatePinSecretTemplate(String SecretItem, String SecretName,String PIN, String Notes, String folderName,String folderPath)
	{
		try {
			openSecreteTemplatePage(SecretItem);

			typeIn("Secret Name#id=SecretNameTextBox", SecretName);
			typeIn("PIN code#xpath=//input[contains(@id,'SecretItemDisplay') and @class='SecretViewTextbox']", PIN);
			typeIn("Notes#xpath=//textarea[@class='SecretViewTextbox']", Notes);


			if (elementPresent("clear folder#id=SecretFolderPicker_ClearFolderLink")) {
				clickOn("clear folder#id=SecretFolderPicker_ClearFolderLink");
			}
			if (elementPresent("No Selected Folder#id=SecretFolderPicker_FolderLink")) { 
				clickOn("No Selected Folder#id=SecretFolderPicker_FolderLink");
				switchToFrame("ifram#xpath=//iframe[@id='popupFrame']");
				typeIn("search box for folder path#xpath=//span[text()='Folder Search']/following-sibling::input", folderName);
				clickOn("click on folder#xpath=//div[text()='"+folderPath+"']");


				clickOn("SecretTemplate Save button#id=SaveEditButton");
				if (elementPresent("secret Template name#xpath=//span[text()='Secret Name']/parent::td/following-sibling::td//span")) {
					String SecretnameGUI = getText("secret Template name#xpath=//span[text()='Secret Name']/parent::td/following-sibling::td//span");
					if (SecretnameGUI.equals(SecretName)) {
						testStepPassed("Secret Name is same : "+SecretName);
					}
					else {
						testStepFailed("Secret Name is different : "+SecretName);
					}
				}
				else {
					testStepFailed("Secrete Template is not created");
				}
			}


		}catch(Exception ex)
		{
			System.out.println("Exception in CreatePinSecretTemplate "+ex);
			ex.printStackTrace();

		}

	}
	
	public boolean validatetitleWithAutoit(String filepathwithparameters, String messages) {
		String line = null;
    	boolean Status = false;
    	try {
			Process Remort = Runtime.getRuntime().exec(filepathwithparameters);
			BufferedReader reader = new BufferedReader(new InputStreamReader(Remort.getInputStream()));
			while ((line = reader.readLine()) != null) {
				if (line.contains(messages)) {
					Status = true;
				    break;
				}
				
				System.out.println("line ======  "+line);
			}
			if(!Status) {
				testStepFailed(messages+"is not present");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Status;
	}
	
	
}