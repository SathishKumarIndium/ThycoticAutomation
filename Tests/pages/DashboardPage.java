package pages;



import java.io.IOException;

import javax.swing.plaf.basic.BasicScrollPaneUI.VSBChangeListener;

import org.openqa.selenium.By;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import iSAFE.GOR;
import objectRepository.OR;

public class DashboardPage extends ApplicationKeywords {
	
	public static int DashboardElements = 0;
	
	public static final String Advance_Fields = "Advance#xpath=//div[@id='AdvancedSearchDiv']//td/span";
	
	
	
	//sathish
	
	public static final String drag_src_CreateSecret = "//li/nobr[text()='Create Secret']";


	public static final String lbl_DashboardElements = "validating dashboard Elements#xpath=//div[@class='WidgetLiDiv']/h2";
	public static final String lbl_dashboard_createSecret = "create secret#xpath=//div[@class='WidgetLiDiv']/h2[text()='Create Secret']";
	public static final String drag_src_RecentSecrets = "//li/nobr[text()='Recent Secrets']";

	public static final String drag_src_ExpiredSecrets = "//li/nobr[text()='Expired Secrets']";
	public static final String drag_src_OutofSyncSecrets = "//li/nobr[text()='Out of Sync Secrets']";
	public static final String drag_src_RequestManagement = "//li/nobr[text()='Request Management']";
	public static final String drag_src_Report = "//li/nobr[text()='Report']";
	public static final String drag_src_WelcomeButton = "To click or drag welcome#xpath=//li/nobr[text()='Welcome']";
	public static final String btn_iconfavourite = "fav icon#xpath=//span[@title='Set Favorite']";
	public static final String btn_basicTab = "Click on Basic button#xpath=//span[@id='BasicLabel' and text()='Basic']";
	public static final String lbl_SecretsLabel = "Validate the basic home page#xpath=//legend[text()='Secrets']";
	public static final String btn_view = "click on view button#xpath=//span[text()='View']";
	public static final String drp_Content = "click on content button#xpath=//li[contains(@class,'draggable')]/nobr";
	public static final String drag_src_Welcome = "//li/nobr[text()='Welcome']";
	public static final String drop_Destination = "//ul[@id='Ul3']";
	public static final String drag_src_FavoriteSecrets = "//li/nobr[text()='Favorite Secrets']";
	public static final String lbl_validationSummary = "To reteive validation summary#xpath=//div[@id='ValidationUpdatePanel']/div[@id='ValidationSummary']";
	public static final String lst_SecretElements = "Elements in Secrets#xpath=//table[@class='InlineSecretViewTable']/following-sibling::table/tbody/tr/td/a";
	public static final String lbl_noErrMsg = "No error msg#xpath=//div[@id='NoErrorMessage']";
	public static final String lbl_NOERRORMsg = "No error msg#xpath=//div";
	public static final String btn_OK = "OK button#xpath=//button[contains(@class,'okButton')]";
	public static final String btn_close= "cancel button#xpath=//button[text()='Close' and contains(@class,'cancelButtonIcon')]";
	
	public static final String btn_security = "Security butoon in secrest#xpath=//a[@title='Security']";
	public static final String lbl_HideLauncherPassword = "Verify hide launcher password status#xpath=//tr[@id='HideLauncherPasswordRow']//span[contains(text(),'Hide Launcher Password')]/..//following-sibling::td/span[contains(text(),'Yes')]";

	
	
	public DashboardPage(BaseClass obj) {
		super(obj);
	}
	
	public void CheckHelpPageLayout(String fields) {
		
		
	}
	
	// Verify Column Selection items are present in SecretGrid when enable in Column Selection
	public void AddVerifyColumnInSecretGrid(String columnselectionitem, String Advancefields) {

		waitForElementToDisplay(OR.link_Advancelink, 10);	
		
		if(!isElementDisplayed("TemplateLabel#id=TemplateLabel")) {
			clickOn(OR.link_Advancelink);
		}

		int fields = validateElementisDisplay(Advance_Fields, Advancefields);
		int column_field = validateElementisDisplay("column Selection#xpath=//div[@id='AdvancedSearchDiv']//td/a", "Column Selection");
		if (fields+column_field == 4) {
			testStepPassed("All Advance fields  are present");
			vstsTestStepPassed("All Advance fields  are present", false);
		}
		else {
			testStepFailed("Some Advance fields are not present");
			vstsTestStepFailed("Some Advance fields are not present", true);
		}
		
        clickOn("click on columnselect#id=ColumnSelectionLink");
       // validateAllElementisDisplay("Displayed columns#xpath=//span", "Displayed Columns");
        
        if (isElementDisplayed("Displayed columns#xpath=//span[contains(text(),'Displayed Columns')]")) {
        	vstsTestStepPassed("Displayed Columns is present", false);
        }
        else {
        	vstsTestStepFailed("Displayed Columns is not present", true);
        }
        
        selectCheckBox("Enabling "+columnselectionitem+" in columnselect#xpath=//label[text()='"+columnselectionitem+"']/preceding-sibling::input");
        ValidateCheckboxischecked("//label[text()='"+columnselectionitem+"']/preceding-sibling::input", columnselectionitem);
        
        clickOn(OR.btn_Column_Selection_ok);
        
        waitForElementToDisplay("secret grid#xpath=//div[text()='"+columnselectionitem+"']", 10);
        
        if (isElementDisplayed("secret grid#xpath=//div[text()='"+columnselectionitem+"']")) {
        	testStepPassed("'"+columnselectionitem+"' is present in Secret Grid");
        	vstsTestStepPassed("'"+columnselectionitem+"' is present in Secret Grid", false);
        	
        }else {
        	testStepFailed("'"+columnselectionitem+"' is not present in Sceret Grid");
        	vstsTestStepFailed("'"+columnselectionitem+"' is not present in Sceret Grid", true);
        }
        
        clickOn(OR.link_Column_select);
        clickOn("Enabling "+columnselectionitem+" in columnselect#xpath=//label[text()='"+columnselectionitem+"']/preceding-sibling::input");
        clickOn(OR.btn_Column_Selection_ok);
       
        if (!isElementDisplayed("secret grid#xpath=//div[text()='"+columnselectionitem+"']")) {
        	testStepInfo("'"+columnselectionitem+"' is removied in Secret Grid");
        }else {
        	testStepFailed("'"+columnselectionitem+"' is removied in Sceret Grid");
        }

	}
	
	//verifying 
	public void verifySecretWidgetDelete(String ContentIcon, String ExpectedMessage) {
		if (elementPresent(ContentIcon+" is pesent in Secret widage#xpath=//h2[text()='"+ContentIcon+"']")) {
			testStepPassed("Secret is present");
			vstsTestStepPassed("Secret is present", false);
			
			clickOn("delete content item from DashBoard#xpath=//h2[text()='"+ContentIcon+"']/following-sibling::ul/li[@class='ui-icon ui-icon-trash CloseWidget']");
			waitTime(2);
			String alrmessage = getAlertText();

			System.out.println("aaaaaa"+alrmessage);
			System.out.println("uuuuu"+ExpectedMessage);
			
			
			if (alrmessage.contains(ExpectedMessage)) {
				testStepPassed("Alert Box message is displayed");
				vstsTestStepPassed("Alert Box message is displayed", false);
			}
			else {
				testStepFailed("Alert Box Message is not displayed");
				vstsTestStepFailed("Alert Box Message is not displayed", false);
			}
			alertOk();
			
			waitTime(2);
			if (!elementPresent(ContentIcon+" is pesent in Secret widage#xpath=//h2[text()='"+ContentIcon+"']")) {
				testStepPassed(ContentIcon+" is Not present in tab page");
				vstsTestStepPassed(ContentIcon+" is Not present in tab page", false);
			}
			else {
				testStepFailed(ContentIcon+" is present in tab page");
				vstsTestStepFailed(ContentIcon+" is present in tab page", true);
			}
			
		}
		else {
			testStepFailed(ContentIcon+" is not present in DashBoard");
			vstsTestStepFailed(ContentIcon+" is not present in DashBoard", true);
		}
	}
	
	public void addNewTabInDashboard(String newTabName) {

		String folder_source = "//label[@id='f_-1' and text()='< All Folders >']";
		String Newtab_div_dest = "//ul[@id='TabContainer']";
		validateElementsInDashboard("No");
		clickOn(OR.btn_NewTab_Icon);
		typeIn(OR.txt_NewTab, newTabName);
	    clickOn(OR.Search_Field);
		waitTime(3);
		dragAndDrop(folder_source, Newtab_div_dest);
		
		if (isElementDisplayed("all folder in new tab#xpath=//td[contains(@id,'pinTabTD') and contains(text(),'< All Folders >')]")) {
			testStepPassed("All folder is present in new tab");
			vstsTestStepPassed("All folder is present in new tab", false);
		}
		else {
			testStepFailed("All folder is not present in New tab");
			vstsTestStepFailed("All folder is not present in New tab", true);
		}
		
//		System.out.println("ssss"+getText("element#xpath=//li[@id='ftvli']"));
		validateElementsInDashboard("Yes");
		
		clickOn(OR.Delete_Icon);
		alertOk();
		waitTime(3);
		clickOn("Delet Icon for New Tab#xpath=//td[text()='"+newTabName+"']//following-sibling::td/span[contains(@class,'ui-icon-close')]");
		alertOk();
		//dragAndDrop(, destinationLocator);
	}
	
//	public void PerformBulkOperation(String SecretName, String BulkOperation, String BulkOperationErrorMsg, 
//			String BulkErrorMessageXpath, String foldername, boolean inhertir, boolean MultipeSecret, String vstsUpdateforOkPage) {
	
		public void PerformBulkOperation(String SecretName, String BulkOperation, String BulkOperationErrorMsg, 
				String BulkErrorMessageXpath, String foldername, boolean inherit,  String vstsUpdateforOkPagetitle, String vstsUpdateforComplatepagetitle) {
		try {
			clickOn(OR.btn_home_icon);
			waitTime(2);
			switchTofolders(foldername);

			if (PerformSecretChecked(SecretName)) {
				vstsTestStepPassed("All secret are checked", true);
			}
			else {
				vstsTestStepFailed("Some secrets sre not checked", true);
			}


			selectFromDropdown(OR.drpdown_Selectbulkoperation, BulkOperation);
			if (vstsUpdateforOkPagetitle.equalsIgnoreCase("Yes")) {
				if (elementPresent("Bulk Operation: "+BulkOperation+" box#xpath=//span[text()='Bulk Operation: "+BulkOperation+"']")) {
					testStepPassed("'Bulk Operation: "+BulkOperation+"' page should be displayed");
					vstsTestStepPassed("'Bulk Operation: "+BulkOperation+"' page should be displayed", false);
				}
				else {
					testStepFailed("'Bulk Operation: "+BulkOperation+"' page should not be displayed");
					vstsTestStepFailed("'Bulk Operation: "+BulkOperation+"' page should not be displayed", true);
				}
			}
			
			if(ValidateBulkOperationOkPage(BulkOperation, inherit)) {
				vstsTestStepPassed("Bulk Operation Message and OK,Cancel is Present", false);
			}
			else {
				vstsTestStepFailed("Bulk Operation Message and OK,Cancel is not Present", true);
			}
			
			if (inherit) {
				selectCheckBox(OR.chk_Inherit_Secret_Policy);
				waitTime(3);
				if (isElementDisplayed(OR.drd_Secret_Policy)) {
					testStepFailed("Secret Policy Field Is Present After Enabling a Inherit Secret Policy");
					vstsTestStepFailed("Secret Policy Field Is Not Present After Enabling a Inherit Secret Policy", true);
				}
				else {
					testStepPassed("Secret Policy Field Is Not Present After Enabling a Inherit Secret Policy");
					vstsTestStepPassed("Secret Policy Field Is Not Present After Enabling a Inherit Secret Policy", true);
				}
			}
			clickOn("Ok button in Bulk Option#xpath=//div[@class='ui-dialog-buttonset']/button[text()='OK']");
			
			
			if (vstsUpdateforComplatepagetitle.equalsIgnoreCase("Yes")) {
				if (elementPresent("Bulk operation " + BulkOperation
						+ " completed page#xpath=//span[text()='Bulk Operation: " + BulkOperation + "']")) {
					testStepPassed("Bulk operation " + BulkOperation + " completed page is displayed");
					vstsTestStepPassed("Bulk operation " + BulkOperation + " completed page is displayed", false);
				} else {
					testStepFailed("Bulk operation  completed page is not displayed");
					vstsTestStepFailed("Bulk operation  completed page is not displayed", true);
				} 
			}
			
			waitTime(4);
			if (ValidateBulkOperationComplatePage(SecretName, BulkOperation, BulkErrorMessageXpath,
					BulkOperationErrorMsg)) {
				vstsTestStepPassed("Complete,Error message and Close Button is present", false);
				
			} else {
				vstsTestStepFailed("Complete message or Error message or Close Button is not present", true);
			} 
			
			
			clickOn("close button #xpath=//div[@class='ui-dialog-buttonset']/button[text()='Close']");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void deleteSecretusingBulkOperation(String SecretName, String Foldername) {
		
		//PerformBulkOperation(SecretName, "Delete","There were no errors.", "ErrorMessage in bulk opertion#xpath=//div", Foldername, false, false, "yes");
		
		PerformBulkOperation(SecretName, "Delete","There were no errors.", "ErrorMessage in bulk opertion#xpath=//div", Foldername, false, "yes", "yes");
		
		if (!elementPresent("verify secret in dashboard#xpath=//td[text()='"+SecretName+"']/preceding-sibling::td/input")) {
			testStepPassed("Secret is delete from dashboard");
			vstsTestStepPassed("Secret is delete from dashboard", false);
		}
		else {
			testStepFailed("Secret is not delete from dashboard");
			vstsTestStepFailed("Secret is not delete from dashboard", true);
		}
	}

	public void EnableDisableCommentViewInBulkNoErrorMessage(String SecretName, String BulkOperation, String BulkErrorMsg, String Foldername) {
		String xpath = "Error Message for Bulkopertion#xpath=//div";
		//PerformBulkOperation(SecretName, BulkOperation, BulkErrorMsg, xpath, Foldername, false, false, "yes");
		PerformBulkOperation(SecretName, BulkOperation, BulkErrorMsg, xpath, Foldername, false, "yes", "yes");
	}
		
	public void ValidateErrorMsgAssignSecretPolicy(String SecretErrorMessage) {
		selectFromDropdown(OR.drpdown_Selectbulkoperation, "Assign Secret Policy");
		String ErrorMsg = getText(OR.txt_BulKoption_Error_Msg);
		if ( isElementDisplayed(OR.txt_BulKoption_Error_Msg) || ErrorMsg.equals(SecretErrorMessage)) {
			testStepPassed("Error Message is Displayed");
			vstsTestStepPassed("Error Message is Displayed", false);
		}
		else {
			testStepFailed("Error Messgae is Not Displayed");
			vstsTestStepFailed("Error Messgae is Not Displayed", true);
		}
	}
	
	public void AssignSecretPolicyInBulkOperation(String SecretName, String BulkOperation, String foldername) {
		clickOn(OR.btn_home_icon);
	
		
		String ErrorMessage =  "There were no errors.";
		String xpath = "ErrorMessage in bulk opertion#xpath=//div";
		//PerformBulkOperation(SecretName, BulkOperation, "There were no errors.", "ErrorMessage in bulk opertion#xpath=//div", foldername, true, false, "Yes");
	
		PerformBulkOperation(SecretName, BulkOperation, ErrorMessage, xpath, foldername, true, "yes", "yes");
		
		if (elementPresent("Browser Button in DashBoard#xpath=//td[text()='Browse']")) {
			testStepPassed("Dashboard page is Displayed");
			vstsTestStepPassed("Dashboard page is Displayed", false);
		}
		else {
			testStepFailed("Dashboard page is not Displayed");
			vstsTestStepFailed("Dashboard page is not Displayed", true);
		}
		
		clickOn("Clicking "+SecretName+" Secret in DashBoard#xpath=//td[text()='"+SecretName+"']");
		
		if (isElementDisplayed(OR.btn_Secret_view_button)) {
			vstsTestStepPassed("Secret Is Expended", false);
		}
		else {
			vstsTestStepFailed("Secret is not Expended", true);
		}
		clickOn(OR.btn_Secret_view_button);
		
		if (isElementDisplayed("Secret Server Page#xpath=//td[@class='dialog_top' and contains(text(),'"+SecretName+"')]")) {
			testStepPassed("Secret Server page is Displayes");
			vstsTestStepPassed("Secret Server page is Displayes", false);
		}
		else {
			testStepFailed("Secret Server Page is Not Displayed");
			vstsTestStepFailed("Secret Server Page is Not Displayed", true);
		}
		String FirstInheritSecretPolicy = getText(OR.txt_inciden_secret);
		
		if (FirstInheritSecretPolicy.equals("Yes")) {
			testStepPassed("'Inherit Secret Policy' field have  'Yes' value");
			vstsTestStepPassed("Inherit Secret Policy field have  Yes value", false);
		}
		else {
			testStepFailed("'Inherit Secret Policy' field have not 'Yes' value Got:[' " +FirstInheritSecretPolicy+" '] Expeted:[' Yes ']");
			vstsTestStepFailed("Inherit Secret Policy field have different value", true);
		}
		
		deleteSecretfromdashboard(SecretName);
	}

	
	public void VerifyDisableCheckout(String SecretName, String BulkOperation, String BulkErrorMsg, String prereqBulkOperation, String Foldername) {
		String xpath = "Error message in Bulk operation#xpath=//div";
		
		//PerformBulkOperation(SecretName, BulkOperation, BulkErrorMsg, xpath, Foldername, false, false, "No");
		PerformBulkOperation(SecretName, BulkOperation, BulkErrorMsg, xpath, Foldername, false, "No", "No");
		
		if (elementPresent("Browser Button in DashBoard#xpath=//td[text()='Browse']")) {
			testStepPassed("Dashboard page is Displayed");
			vstsTestStepPassed("Dashboard page is Displayed", false);
		}
		else {
			testStepFailed("Dashboard page is not Displayed");
			vstsTestStepFailed("Dashboard page is not Displayed", true);
		}
		
		
		clickOn("Clicking "+SecretName+" Secret in DashBoard#xpath=//td[text()='"+SecretName+"']");
		
		clickOn(OR.btn_Secret_view_button);
		
		if (elementPresent("secret view page title#xpath=//td[@class='dialog_top' and contains(text(),'"+SecretName+"')]")) {
			testStepPassed("Secreat View Page Is Open");
			vstsTestStepPassed("Secreat View Page Is Open", false);
			clickOn(OR.btn_Secret_Security_tab);
			String check_out_interval = getText(OR.txt_Check_Out_Interval);
		    if (check_out_interval.equals("No")) {
		    	testStepPassed("Check Out option  displayed as 'No'");
		    	vstsTestStepPassed("Check Out option  displayed as No", false);
		    }
		    else {
		    	testStepFailed("Check Out option is different  Got: ['"+check_out_interval+" '] Expected: ['No']");
		    	vstsTestStepFailed("Check Out option is different  ", true);
		    }
		}
		else {
			testStepFailed("Secret View Page Is Not Open");
			vstsTestStepFailed("Secret View Page Is Not Open", true);
		}
		
		//clickOn(OR.btn_home_icon);
		deleteSecretfromdashboard(SecretName);
	}
	
	
	public void verifyEnableCheckoutInBulkOperation(String firstSecretName, String secondSecretName, 
			String BulkOperation, String BulkOpertioErrorMessage, String foldername) {
		
		String SecretName = firstSecretName+"##"+secondSecretName;
		String BulkErrorMessageXpath = "Error Messsage for Bulk Operation#xpath=//div";
		
		//PerformBulkOperation(SecretName, BulkOperation, BulkOpertioErrorMessage, BulkErrorMessageXpath, foldername, false, true, "Yes");
		
		PerformBulkOperation(SecretName, BulkOperation, BulkOpertioErrorMessage, BulkErrorMessageXpath, foldername, false, "Yes", "Yes");
		if (elementPresent("Browser Button in DashBoard#xpath=//td[text()='Browse']")) {
			testStepPassed("Dashboard page is Displayed");
			vstsTestStepPassed("Dashboard page is Displayed", false);
		}
		else {
			testStepFailed("Dashboard page is not Displayed");
			vstsTestStepFailed("Dashboard page is not Displayed", true);
		}
		
	    deleteSecretfromdashboard(firstSecretName+"##"+secondSecretName);
	}
	
	public void verifyEnableDisableAutochangeInBulkOperation(String SecretName, String BulkOperation, 
			String BulkErrorMsg, String AutoChangeStatus, String Foldername) {
		
		String xpath = "Error Message For Bulk Operation#xpath=//div";
		
		//PerformBulkOperation(SecretName, BulkOperation, BulkErrorMsg,"//div[@id='NoErrorMessage']", Foldername, false, false, "No");
		
		PerformBulkOperation(SecretName, BulkOperation, BulkErrorMsg,xpath, Foldername, false, "No", "No");
		
		if (elementPresent("Browser Button in DashBoard#xpath=//td[text()='Browse']")) {
			testStepPassed("Dashboard page is Displayed");
			vstsTestStepPassed("Dashboard page is Displayed", false);
		}
		else {
			testStepFailed("Dashboard page is not Displayed");
			vstsTestStepFailed("Dashboard page is not Displayed", true);
		}
		
		clickOn("Clicking "+SecretName+" Secret in DashBoard#xpath=//td[text()='"+SecretName+"']");
		clickOn(OR.btn_Secret_view_button);
		if (elementPresent("secret view page title#xpath=//td[@class='dialog_top' and contains(text(),'"+SecretName+"')]")) {
			testStepPassed("Secreat View Page Is Open");
			vstsTestStepPassed("Secreat View Page Is Open", false);
			clickOn(OR.btn_Remort_Change_Password_tab);
			String AutoChange = getText(OR.txt_AutoChange);
		    if (AutoChangeStatus.equals(AutoChange)) {
		    	testStepPassed(" AutoChange option  displayed as '"+AutoChangeStatus+"'");
		    	vstsTestStepPassed(" AutoChange option  displayed as same", false);
		    }
		    else {
		    	testStepFailed("AutoChange option is different Got: ['"+AutoChange+" '] Expected: ['"+AutoChangeStatus+"']");
		    	vstsTestStepFailed("AutoChange option is different", true);
		    }
		}
		else {
			testStepFailed("Secret View Page Is Not Open");
			vstsTestStepFailed("Secret View Page Is Not Open", false);
		}
	}
	
	
	public void VerifyHeartbeatoptionPresent() {
		clickOn(OR.btn_home_icon);
		clickOn(OR.drpdown_Selectbulkoperation);
				
		if (isElementDisplayed(OR.Enable_Heartbeat) && isElementDisplayed(OR.Disable_Heartbeat) && isElementDisplayed(OR.Run_Heartbeat)) {
			testStepPassed("Enable,Disable and Run Heartbeat is present");
			vstsTestStepPassed("Enable Disable and Run Heartbeat is present", false);
		}
		else {
			testStepFailed("Enable or Disable or Run Heartbeat is not present");
			vstsTestStepFailed("Enable or Disable or Run Heartbeat is not present", true);
		}
	    
	}
	
	
    public void verifyEnableDisableHearthbeat( String SecretName, String BulkOperation, String BulkOperationErrorMsg, String Foldername) {
    	
    	String BulkErrorMessageXpath = "Error Message for Bulk Operation#xpath=//div";
    	
    	PerformBulkOperation(SecretName, BulkOperation, "There were no errors.",BulkErrorMessageXpath, Foldername, false, "No", "No");
    	
    	if (!elementPresent("Bulk operation " + BulkOperation
				+ " completed page#xpath=//div[@class='ui-dialog-buttonset']/button[text()='Close']")) {
			testStepPassed("Bulk operation " + BulkOperation + " completed page is Not displayed");
			vstsTestStepPassed("Bulk operation " + BulkOperation + " completed page is Not displayed", false);
		} else {
			testStepFailed("Bulk operation  completed page is  displayed");
			vstsTestStepFailed("Bulk operation  completed page is  displayed", true);
		}

	}    
    
    public void RunHearthbeat( String SecretName, String BulkOperation, String BulkOperationErrorMsg, String Foldername) {
		
		//PerformBulkOperation(SecretName, BulkOperation, BulkOperationErrorMsg, "//div[@id='NoErrorMessage']", Foldername, false, false, "No");
		
    	PerformBulkOperation(SecretName, BulkOperation, BulkOperationErrorMsg, "ErrorMessage bulkopertion#xpath=//div", Foldername, false, "No", "No");
    	
    	if (!elementPresent("Bulk operation " + BulkOperation
				+ " completed page#xpath=//div[@class='ui-dialog-buttonset']/button[text()='Close']")) {
			testStepPassed("Bulk operation " + BulkOperation + " completed page is Not displayed");
			vstsTestStepPassed("Bulk operation " + BulkOperation + " completed page is Not displayed", false);
		} else {
			testStepFailed("Bulk operation  completed page is  displayed");
			vstsTestStepFailed("Bulk operation  completed page is  displayed", true);
		}
    	
		clickOn("Clicking "+SecretName+" Secret in DashBoard#xpath=//td[text()='"+SecretName+"']");
		clickOn(OR.btn_Secret_view_button);
		if (elementPresent("secret view page title#xpath=//td[@class='dialog_top' and contains(text(),'"+SecretName+"')]")) {
			testStepPassed("Secreat  Page Is Open");
			vstsTestStepPassed("Secreat  Page Is Open", false);
			String Heartbeatstatus = getText(OR.txt_Heartbeat_status);
		    if (Heartbeatstatus.contains("Success") || Heartbeatstatus.contains("Pending")) {
		    	testStepPassed(" Last Heartbeat option is  displayed as '"+Heartbeatstatus+"'");
		    	vstsTestStepPassed("Last Heartbeat option is  displayed as same", true);
		    }
		    else {
		    	testStepFailed("Last Heartbeat option is different Got: ['"+Heartbeatstatus+" '] Expected: ['Success OR Pending']");
		        vstsTestStepFailed("Last Heartbeat option is different as different", false);
		    }
		}
		else {
			testStepFailed("Secret View Page Is Not Open");
			vstsTestStepFailed("Secret  Page Is Not Open", true);
		}
		clickOn(OR.btn_home_icon);
		deleteSecretfromdashboard(SecretName);
	}
    
	
	public void BulkopetionCompletePage(String BulkOperation, String BulkOpertioErrorMessagexpath, String BulkOpertioErrorMessage) {
		waitTime(4);
		if (elementPresent("Bulk operation "+BulkOperation+" completed page#xpath=//span[text()='Bulk Operation: "+BulkOperation+"']")) {
			testStepPassed("Bulk operation "+BulkOperation+" completed page is displayed");
			waitForElementToDisplay("text for Bulk operation completed#xpath=//div[@id='CompleteMessage']", 10);
			waitForElement("text for Bulk operation completed#xpath=//div[@id='CompleteMessage']");
			validateWebElements("//div[@id='CompleteMessage']", "Bulk operation completed.");
			//System.out.println("BulkOpertioErrorMessage");
			validateWebElements(BulkOpertioErrorMessagexpath, BulkOpertioErrorMessage);
			validateWebElements("//div[@class='ui-dialog-buttonset']/button[text()='Close']", "Close");
			clickOn("close button #xpath=//div[@class='ui-dialog-buttonset']/button[text()='Close']");
			validateDashboard();
		}
		else {
			testStepFailed("Bulk operation  completed page is not displayed");
		}
	}
	
	
	 public void verifyHBInBulkoperationWhenHBIsDisableInTemplate(String SecretTemplate, String FirstSecretName, 
			 String SecondSecretName, String firstBulkOperation, String SecondBulkOperationString, String HeatbeatTemplatestatus, 
			  String FirstBulkOpertioErrorMessage, String SecondBulkOpertioErrorMessage, String foldername) {
		clickOn(OR.btn_home_icon);
		
		String SecretNames= FirstSecretName+"##"+SecondSecretName;
		
		if(PerformSecretChecked(SecretNames)) {
			testStepPassed("Secret are checked");
			vstsTestStepPassed("Secret are checked", true);
		}
		else {
			testStepFailed("Secret server is not checked");
			vstsTestStepFailed("Secret server is not checked", true);
		}
		
		
		selectFromDropdown(OR.drpdown_Selectbulkoperation, firstBulkOperation);
			
		if (elementPresent("Bulk Operation: "+firstBulkOperation+" box#xpath=//span[text()='Bulk Operation: "+firstBulkOperation+"']")) {
			testStepPassed("'Bulk Operation: "+firstBulkOperation+"' page should be displayed");
			vstsTestStepPassed("'Bulk Operation: "+firstBulkOperation+"' page should be displayed", true);
			
			clickOn(OR.btn_bulk_operation_ok_button);
			
			waitTime(5);
			//'Secret "Secret Name" already has heartbeat enabled.'  should be displayed
			
			if (elementPresent("No error Message for first#xpath=//td[text()='"+FirstSecretName+"']/following-sibling::td[text()='Secret \""+FirstSecretName+"\" already has heartbeat enabled.']")
					&& elementPresent("No error Message for first#xpath=//td[text()='"+SecondSecretName+"']/following-sibling::td[text()='Secret \""+SecondSecretName+"\" already has heartbeat enabled.']")) {
					testStepPassed("No error message is displayed");
					vstsTestStepPassed(FirstBulkOpertioErrorMessage +" is successfully", true);
				}
				else {
					testStepFailed("No Error message is not displayed");
					vstsTestStepFailed(FirstBulkOpertioErrorMessage+"is not Successfully", true);
				}
			clickOn(OR.btn_bulk_operation_close_button);
		}
		else {
			testStepFailed("'Bulk Operation: "+firstBulkOperation+"' page should not be displayed");
			vstsTestStepFailed("'Bulk Operation: "+firstBulkOperation+"' page should not be displayed", true);
		}
		
		if(enableDiasableRemotePasswordandHBInSecretTemplates(SecretTemplate, "Enable Heartbeat",HeatbeatTemplatestatus)) {
			testStepPassed("Enable Heartbeat is disabled");
			vstsTestStepPassed("Enable Heartbeat is disabled", true);
		}
		else {
			testStepFailed("Enable Heartbeat is not disabled");
			vstsTestStepFailed("Enable Heartbeat is not disabled", true);
		}
		
		clickOn(OR.btn_home_icon);
		if(PerformSecretChecked(SecretNames)) {
			testStepPassed("Secret are checked");
			vstsTestStepPassed("Secret are checked", true);
		}
		else {
			testStepFailed("Secret server is not checked");
			vstsTestStepFailed("Secret server is not checked", true);
		}
		selectFromDropdown(OR.drpdown_Selectbulkoperation, SecondBulkOperationString);
			
		if (elementPresent("Bulk Operation: "+SecondBulkOperationString+" box#xpath=//span[text()='Bulk Operation: "+SecondBulkOperationString+"']")) {
			testStepPassed("'Bulk Operation: "+SecondBulkOperationString+"' page should be displayed");
			vstsTestStepPassed("'Bulk Operation: "+SecondBulkOperationString+"' page should be displayed", true);
			
			clickOn(OR.btn_bulk_operation_ok_button);
			if (elementPresent("No error Message for first#xpath=//td[text()='"+FirstSecretName+"']/following-sibling::td[text()='"+FirstBulkOpertioErrorMessage+"']")
					&& elementPresent("No error Message for first#xpath=//td[text()='"+SecondSecretName+"']/following-sibling::td[text()='"+SecondBulkOpertioErrorMessage+"']")) {
					vstsTestStepPassed(FirstBulkOpertioErrorMessage +" is successfully", true);
				}
				else {
					vstsTestStepFailed(FirstBulkOpertioErrorMessage+"is not Successfully", true);
				}
			clickOn(OR.btn_bulk_operation_close_button);
		}
		else {
			testStepFailed("'Bulk Operation: "+firstBulkOperation+"' page should not be displayed");
			vstsTestStepFailed("'Bulk Operation: "+firstBulkOperation+"' page should not be displayed", true);
		}
		
		if (elementPresent("Browser Button in DashBoard#xpath=//td[text()='Browse']")) {
			testStepPassed("Dashboard page is Displayed");
			vstsTestStepPassed("Dashboard page is Displayed", true);
		}
		else {
			testStepFailed("Dashboard page is not Displayed");
			vstsTestStepFailed("Dashboard page is not Displayed", true);
		}
			
	}	
	 
	 
	public void performAddShareInBulkOperation (String SecretName, String BulkOperation, String BulkOperationErrorMessage, 
			String UserGropParams, String Foldername) {
		
		String BulkOperationErrorMessagexpath = null;
		
		if (BulkOperationErrorMessage.equals("There were no errors.")) {
			BulkOperationErrorMessagexpath = "error message for shared folder#xpath=//div";
		}
		else {
			BulkOperationErrorMessagexpath = "error message for shared folder#xpath=//div[@id='gview_BulkOperationErrorMessageGrid']//div//td[text()='"+SecretName+"']/following-sibling::td";
		}
		
		
		clickOn(OR.btn_home_icon);
		switchTofolders(Foldername);
		
		waitTime(3);
		if (PerformSecretChecked(SecretName)) {
			vstsTestStepPassed("All secret are checked", true);
		}
		else {
			vstsTestStepFailed("Some secrets sre not checked", true);
		}
		
		selectFromDropdown(OR.drd_Bulk_Operation, BulkOperation);
		if (elementPresent("Bulk Operation: "+BulkOperation+" box#xpath=//span[text()='Bulk Operation: "+BulkOperation+"']")) {
			testStepPassed("'Bulk Operation: "+BulkOperation+"' page should be displayed");
			vstsTestStepPassed("Bulk Operation: "+BulkOperation+" page should be displayed", true);
			selectFromDropdown(OR.drd_Shared_User_Group, UserGropParams);
			//ValidateCheckboxischecked(OR.drd_Shared_User_Group, UserGropParams);
			
			if (isElementDisplayed("selected shared folder#xpath=//a[@class='UserIconImage' and text()='"+UserGropParams+"']")) {
				testStepPassed("The users should be selected");
				vstsTestStepPassed("The users should be selected", true);
			}
			else {
				testStepFailed("The users should not be selected");
				vstsTestStepPassed("The users should not be selected", true);
			}
			
			clickOn(OR.btn_bulk_operation_ok_button);
			
			waitTime(3);
			if(validateAllElementisDisplay(BulkOperationErrorMessagexpath, BulkOperationErrorMessage)) {
				testStepPassed("Error message is displayed");
				vstsTestStepPassed("Error Message is Displayed", true);
			}
			else {
				testStepFailed("Error Message is not Displayed");
				vstsTestStepFailed("Error Message is not Displayed", true);
			}
			clickOn(OR.btn_bulk_close_button);
		}
		else {
			testStepFailed("'Bulk Operation: "+BulkOperation+"' page should not be displayed");
			vstsTestStepFailed("Bulk Operation: "+BulkOperation+" page should not be displayed", true);
		}

	}
	
	
	public void performAddShareInBulkOperationNoError (String SecretName, String BulkOperation, String BulkOperationErrorMessage, 
			String UserGropParams, String Foldername) {
		
		String BulkOperationErrorMessagexpath = "//div[@id='NoErrorMessage']";
		
		clickOn(OR.btn_home_icon);
		switchTofolders(Foldername);
		
		if (elementPresent("Secret in Dashboard#xpath=//td[text()='"+SecretName+"']")) {
			selectCheckBox("enable secret in dashboard#xpath=//td[text()='"+SecretName+"']/preceding-sibling::td/input");
		}
		else {
			testStepFailed("' "+SecretName+"' Secret is not present in Dashboard");
		}
		
		selectFromDropdown(OR.drd_Bulk_Operation, BulkOperation);
		if (elementPresent("Bulk Operation: "+BulkOperation+" box#xpath=//span[text()='Bulk Operation: "+BulkOperation+"']")) {
			testStepPassed("'Bulk Operation: "+BulkOperation+"' page should be displayed");
			selectFromDropdown(OR.drd_Shared_User_Group, UserGropParams);
			clickOn(OR.btn_bulk_operation_ok_button);
			BulkopetionCompletePage(BulkOperation, BulkOperationErrorMessagexpath, BulkOperationErrorMessage);
		}
		else {
			testStepFailed("'Bulk Operation: "+BulkOperation+"' page should not be displayed");
		}

	}
	
	public void CheckBulkOpertionWithErrorMsg(String SecretName, String BulkOperation, String BulkOperationErrorMessage, String Foldername) {
		String xpath = "Error Message for Bulk Operation#xpath=//div[@id='gview_BulkOperationErrorMessageGrid']//div//td";	
		
		PerformBulkOperation(SecretName, BulkOperation, BulkOperationErrorMessage, xpath, Foldername, false, "Yes", "Yes");
		
	}
	
	
	
	public void CheckBulkOpertionWithfolderErrorMsg(String SecretName, String BulkOperation, String BulkOperationErrorMessage, String Foldername) {
		String xpath = null;
		
		waitTime(2);
		
		switchTofolders(Foldername);
		
		if (BulkOperationErrorMessage.equals("There were no errors.")) {
			xpath = "Error Message for Bulk Operation#xpath=//div";
		}
		else {
			xpath = "Error Message for Bulk Operation#xpath=//div[@id='gview_BulkOperationErrorMessageGrid']//div//td";
		}
		
		waitTime(2);
		if (PerformSecretChecked(SecretName)) {
			vstsTestStepPassed("All secret are checked", true);
		}
		else {
			vstsTestStepFailed("Some secrets sre not checked", true);
		}
		
		selectFromDropdown(OR.drd_Bulk_Operation, BulkOperation);
		if (elementPresent("Bulk Operation: "+BulkOperation+" box#xpath=//span[text()='Bulk Operation: "+BulkOperation+"']")) {
			testStepPassed("'Bulk Operation: "+BulkOperation+"' page should be displayed");
			vstsTestStepPassed("'Bulk Operation: "+BulkOperation+"' page should be displayed", false);
		}
		else {
			testStepFailed("'Bulk Operation: "+BulkOperation+"' page should not be displayed");
			vstsTestStepFailed("'Bulk Operation: "+BulkOperation+"' page should not be displayed", true);
		}
		
		clickOn(OR.btn_bulk_operation_ok_button);
		
		waitTime(2);
		if(validateAllElementisDisplay(xpath, BulkOperationErrorMessage)) {
			//testStepPassed("Error message is displayed");
			vstsTestStepPassed("Error Message is Displayed", true);
		}
		else {
			//testStepFailed("Error Message is not Displayed");
			vstsTestStepFailed("Error Message is not Displayed", true);
		}
		
		clickOn(OR.btn_bulk_close_button);
		
	}
	
	
	public void CheckBulkOpertionWithEnableHeartbeatErrorMsg(String SecretTemplateItem, String SecretName, String Domain, String Username, String Password,
			String folderName, String folderPath, String BulkOperation, String BulkOperationErrorMsg) {
		String xpath = "Error Message for Bulk Operation#xpath=//div[@id='gview_BulkOperationErrorMessageGrid']//div//td[text()='"+SecretName+"']/following-sibling::td";	
		
		if (elementPresent(OR.tab_Create_Secret)) {
			selectFromDropdown("select a create secret#xpath=//select[contains(@id,'CreateSecretWidget')]", SecretTemplateItem);
		}
		
		if (isElementDisplayed("Create Secret Page#id=SecretTypeLabel")) {
			testStepPassed("Secret Template page is displayed");
			vstsTestStepPassed("Secret Template page is displayed", true);
			
			typeIn("Secret Name#id=SecretNameTextBox", SecretName);
			boolean Secret_Status = ValidateEnterValusInTextField("Secret Name#id=SecretNameTextBox", SecretName, "Secret Name");
			typeIn("Entering Server or Doman name#id=SecretItemDisplay_SecretItemsRepeater_ctl00_ItemValueTextBox", Domain);
			boolean Domain_Status  = ValidateEnterValusInTextField("Entering Server or Doman name#id=SecretItemDisplay_SecretItemsRepeater_ctl00_ItemValueTextBox", Domain, "Domain");
			typeIn("Entering Username textbox#id=SecretItemDisplay_SecretItemsRepeater_ctl01_ItemValueTextBox", Username);
			boolean UserName_Status  = ValidateEnterValusInTextField("Entering Username textbox#id=SecretItemDisplay_SecretItemsRepeater_ctl01_ItemValueTextBox", Username, "UserName");
			typeIn("Entering Password textbox#id=SecretItemDisplay_SecretItemsRepeater_ctl02_ItemValueTextBox", Password);
			boolean Password_Status  = ValidateEnterValusInTextField("Entering Password textbox#id=SecretItemDisplay_SecretItemsRepeater_ctl02_ItemValueTextBox", Password, "Password");
			
			if (Secret_Status && Domain_Status && UserName_Status && Password_Status) {
				testStepPassed("Secretname, Domain, UserName,Password are able to enter");
				vstsTestStepPassed("Secretname, Domain, UserName,Password are able to enter", true);
			}
			else {
				testStepFailed("Secretname, Domain, UserName,Password are not able to enter");
				vstsTestStepFailed("Secretname, Domain, UserName,Password are not able to enter", true);
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
					vstsTestStepPassed("Secret should be successfully created", true);
				}
				else {
					testStepFailed("Secret Name is different : "+SecretName);
					vstsTestStepFailed("Secret should be successfully not created", true);
				}
			}
			clickOn("SecretTemplate BackButton button#id=BackToSearchResultsButton");
			
			if (elementPresent("Browser Button in DashBoard#xpath=//td[text()='Browse']")) {
				testStepPassed("Dashboard page is Displayed");
				vstsTestStepPassed("Dashboard page is Displayed", true);
			}
			else {
				testStepFailed("Dashboard page is not Displayed");
				vstsTestStepFailed("Dashboard page is not Displayed", true);
			}
			
		}
		else {
			testStepFailed("Secret Template page is not displayed");
			vstsTestStepFailed("Secret Template page is not displayed", true);
		}
		
		
		PerformBulkOperation(SecretName, BulkOperation, BulkOperationErrorMsg, xpath, folderName, false, "No", "No");
		
		if (!elementPresent("Bulk operation " + BulkOperation
				+ " completed page#xpath=//div[@class='ui-dialog-buttonset']/button[text()='Close']")) {
			testStepPassed("Bulk operation " + BulkOperation + " completed page is Not displayed");
			vstsTestStepPassed("Bulk operation " + BulkOperation + " completed page is Not displayed", false);
		} else {
			testStepFailed("Bulk operation  completed page is  displayed");
			vstsTestStepFailed("Bulk operation  completed page is  displayed", true);
		}

	}
	
	public void ValidateEnableCommendonviewWithError(String SecretName, String BulkOperation, String BulkOperationErrorMsg, String folderName) {
		String xpath = "Error Message for Bulk Operation#xpath=//div[@id='gview_BulkOperationErrorMessageGrid']//div//td[text()='"+SecretName+"']/following-sibling::td[text()='"+BulkOperationErrorMsg+"']";	
		
		if(PerformSecretChecked(SecretName)) {
			testStepPassed("Secret are checked");
			vstsTestStepPassed("Secret are checked", true);
		}
		else {
			testStepFailed("Secret server is not checked");
			vstsTestStepFailed("Secret server is not checked", true);
		}
		
		selectFromDropdown(OR.drpdown_Selectbulkoperation, BulkOperation);
			
		if (elementPresent("Bulk Operation: "+BulkOperation+" box#xpath=//span[text()='Bulk Operation: "+BulkOperation+"']")) {
			testStepPassed("'Bulk Operation: "+BulkOperation+"' page should be displayed");
			vstsTestStepPassed("'Bulk Operation: "+BulkOperation+"' page should be displayed", true);
		
			clickOn(OR.btn_bulk_operation_ok_button);
		
			waitTime(5);
		
			if (elementPresent(xpath)) {
				testStepPassed("No error message is displayed");
				vstsTestStepPassed( BulkOperation+" is successfully", true);
			}
			else {
				testStepFailed("No Error message is not displayed");
				vstsTestStepFailed(BulkOperation+" is not Successfully", true);
			}
			clickOn(OR.btn_bulk_operation_close_button);
		}
		else {
			testStepFailed("'Bulk Operation: "+BulkOperation+"' page should not be displayed");
			vstsTestStepFailed("'Bulk Operation: "+BulkOperation+"' page should not be displayed", true);
		}
		
		if (elementPresent("Browser Button in DashBoard#xpath=//td[text()='Browse']")) {
			testStepPassed("Dashboard page is Displayed");
			vstsTestStepPassed("Dashboard page is Displayed", false);
		}
		else {
			testStepFailed("Dashboard page is not Displayed");
			vstsTestStepFailed("Dashboard page is not Displayed", true);
		}
	}

	public void validateElementsInDashboard(String DeleteIcon) {
		
		DashboardElements = 0;
		int DashboardExpectedelemets = 0;
		validateElementPresent(OR.txt_Browser, "Browser Tab");
		validateElementPresent(OR.btn_NewTab_Icon, "New tab Icon");
		validateElementPresent(OR.btn_Expend_button, "Expend button");
		validateElementPresent(OR.Search_Field, "Search Text Box");
		validateElementPresent(OR.link_Advancelink, "Advanced Link");
		validateElementPresent(OR.tab_Secret, "Secrets Section");
		validateElementPresent(OR.drd_Bulk_Operation, "Bulk Operation");
		
		if (DeleteIcon.equals("yes")) {
			DashboardExpectedelemets = 8;
			validateElementPresent(OR.Delete_Icon, "Delete Icon for newTab");
		}
		else {
			DashboardExpectedelemets = 7;
		}
		if (DashboardElements == DashboardExpectedelemets) {
			testStepPassed("All element in DashBoard is  present");
			vstsTestStepPassed("All element in DashBoard is  present", false);
		}
		else {
			testStepFailed("Some element in Dashboard is not present");
			vstsTestStepFailed("Some element in Dashboard is not present", true);
		}
	}
	
	public void validateElementPresent(String xpath, String Elements) {
		if (isElementDisplayed(xpath)) {
			DashboardElements++;
		}
		else {
			testStepFailed("'" +Elements +"' is not present in dashboard");
		}
	}
	
//	public void ValidateCheckboxischecked(String xpath, String element) {
//			
//		try {
//			
//			System.out.println("SSS"+xpath);
//			
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
//			vstsTestStepFailed(element+ " is not checked", true);
//			e.printStackTrace();
//		}
//	}
	
	public void checkSecretWidgetIspresent(String ContentIcon) {
		try {
			if (elementPresent(ContentIcon+" is pesent in  dashboard#xpath=//h2[text()='"+ContentIcon+"']")) {
				testStepPassed(ContentIcon+" is present in dashboared");
				vstsTestStepPassed(ContentIcon+" is present in dashboared", false);
			}
			else {
				clickOn(OR.btn_content);
				dragAndDrop("//li/nobr[text()='"+ContentIcon+"']", "//ul[@id='Ul3']");
				if (elementPresent(ContentIcon+" is pesent in dashboard#xpath=//h2[text()='"+ContentIcon+"']")) {
					testStepPassed(ContentIcon+" is present in DashBoared page");
					vstsTestStepPassed(ContentIcon+" is present in DashBoared page", false);
				}
				else {
					testStepFailed(ContentIcon+" is not present in DashBoared page");
					vstsTestStepFailed(ContentIcon+" is not present in DashBoared page", false);
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
//	public boolean validateSecretispresent(String SecretName, boolean WithvstsUpdate) {
//		
//		boolean Status = false;
//		clickOn(OR.btn_home_icon);
//		
//		if (isElementDisplayed("Secret in Dashboard Page#xpath=//td[text()='"+SecretName+"']")) {
//			testStepPassed("Secret is present in Dashboard page");
//			Status = true;
//			if (WithvstsUpdate)
//			vstsTestStepPassed("Secret is present in Dashboard page", false);
//		}
//		else {
//			testStepFailed("Secret is not present in Dashboard page");
//			Status = false;
//			if (WithvstsUpdate)
//			vstsTestStepFailed("Secret is not present in Dashboard page", true);
//		}
//		return Status;
//	}
	
//	public boolean performbulkoperationforPreCondition(String SecretName, String BulkOperation, String foldername, boolean WithVstsUpdate) {
//		
//		boolean status = true;
//		clickOn(OR.btn_home_icon);
//		switchTofolders(foldername);
//				
//		if (elementPresent("Secret in Dashboard#xpath=//td[text()='"+SecretName+"']")) {
//			selectCheckBox("enable secret in dashboard#xpath=//td[text()='"+SecretName+"']/preceding-sibling::td/input");
//			selectFromDropdown(OR.drpdown_Selectbulkoperation, BulkOperation);
//			
//			if (elementPresent("Bulk Operation: "+BulkOperation+" box#xpath=//span[text()='Bulk Operation: "+BulkOperation+"']")) {
//				testStepPassed("'Bulk Operation: "+BulkOperation+"' page should be displayed");
//			}
//			else {
//				testStepFailed("'Bulk Operation: "+BulkOperation+"' page should not be displayed");
//			}
//			
//			clickOn("Ok button in Bulk Option#xpath=//div[@class='ui-dialog-buttonset']/button[text()='OK']");
//			
//			if (elementPresent("Bulk operation "+BulkOperation+" completed page#xpath=//span[text()='Bulk Operation: "+BulkOperation+"']")) {
//				testStepPassed("Bulk operation "+BulkOperation+" completed page is displayed");
//			}
//			else {
//				testStepFailed("Bulk operation  completed page is not displayed");
//			}
//			
//			if (isElementDisplayed("No error Message#xpath=//div[@id='NoErrorMessage' and text()='There were no errors.']")) {
//			   status = true;
//				if(WithVstsUpdate)
//				vstsTestStepPassed(BulkOperation +" is successfully", false);
//			}
//			else {
//				 status = false;
//				if(WithVstsUpdate)
//				vstsTestStepFailed(BulkOperation+"is not Successfully", true);
//			}
//			
//			waitTime(4);
//			clickOn("close button #xpath=//div[@class='ui-dialog-buttonset']/button[text()='Close']");
//		}
//		else {
//			testStepFailed("' "+SecretName+"' Secret is not present in Dashboard");
//		}
//		return status;
//	}
	
	public void validatePrereDisableAutoChange(String SecretName, String BulkOperation, boolean RemotePasswordstatus, String foldername) {
		
	   // boolean RemotePasswordparams = EnableDisableRemotePasswordChangingParameters(RemotePasswordParams, RemotePasswordStatus);
	    boolean Secretispresent = validateSecretispresent(SecretName, foldername, false);
	    boolean bulkoperation = performbulkoperationforPreCondition(SecretName, BulkOperation, foldername, false);
	   
	    
		if (RemotePasswordstatus && Secretispresent && bulkoperation) {
			testStepPassed("Remorte Password, secret is present");
			vstsTestStepPassed("Remorte Password enable, secret is present", false);
		}
		else {
			testStepFailed("Remorte Password enable, secret is not present");
			vstsTestStepFailed("Remorte Password, secret is not present", true);
		}
	}
	
	public void validatePrereDisableHeartbeat(String SecretName, String foldername, boolean RemotePasswordparams,boolean EnableHeartBeatSecret) {
		
	    boolean Secretispresent = validateSecretispresent(SecretName, foldername, false);
	    
		if (RemotePasswordparams && Secretispresent && EnableHeartBeatSecret) {
			testStepPassed("Remorte Password, Enable HearthBeat in secret and Secret are present");
			vstsTestStepPassed("Remorte Password enable,Enable HearthBeat in secret and Secret is present", false);
		}
		else {
			testStepFailed("Remorte Password enable, secret is not present");
			vstsTestStepFailed("Remorte Password, Enable HearthBeat in secret and Secret is not present", true);
		}
	}
	
	public void validateFolderDefaultSecretPreCondition(String SecretName, String foldername, boolean DefaultSecretStatus,boolean FolderStatus) {
			
		boolean Secretispresent = validateSecretispresent(SecretName, foldername, false);
		
		if (DefaultSecretStatus && Secretispresent && FolderStatus) {
			testStepPassed("Default Secret is set and folder is created and secret and Secret are present");
			vstsTestStepPassed("Default Secret is set and folder is created and secret and Secret are present", true);
		}
		else {
			testStepFailed("Default Secret is set and folder is created and secret and Secret are present");
			vstsTestStepFailed("Default Secret is not set or folder is not created or Secret are not present", true);
		}
	}
	
	public void validatePrereDisableHeartbeatandRemortstatus(boolean RemotePasswordparams,boolean EnableHeartBeatSecret) {
		if (RemotePasswordparams && EnableHeartBeatSecret) {
			testStepPassed("Remorte Password, Enable HearthBeat in secret and Secret are present");
			vstsTestStepPassed("Remorte Password enable,Enable HearthBeat in secret and Secret is present", false);
		}
		else {
			testStepFailed("Remorte Password enable, secret is not present");
			vstsTestStepFailed("Remorte Password, Enable HearthBeat in secret and Secret is not present", true);
		}
	}
	
	
	// sathish
	
	
	
	public void dragNDropPrecondition()
	{
		if(elementPresent("New Tab#xpath=//ul[@id='Ul3']"))
		{
			testStepPassed("New Tab is present");
			vstsTestStepPassed("New Tab is present", false);
		}
		else
		{
			testStepFailed("Failed to verify the presence of New Tab");
			vstsTestStepFailed("Failed to verify the presence of New Tab", true);
		}
	}
	
	public void performDashboardActions(String Content_items)

	{
		try {

			clickOn(OR.btn_content);

			if(isElementDisplayed("Toolbox container in content dropdown#xpath=//div[@class='ToolBoxContainer']//ul//li/nobr[text()='Report']"))
			{
				testStepPassed("The contents are displayed");
				vstsTestStepPassed("The contents are displayed", false);
			}
			else
			{
				testStepFailed("Unable to finds the presesnce of elements");
				vstsTestStepFailed("Unable to finds the presesnce of elements", true);
			}

			waitTime(2);


			dragandDropwithVSTS(drag_src_CreateSecret, drop_Destination, "Create Secret");
			dragandDropwithVSTS(drag_src_Welcome, drop_Destination, "Welcome");
			dragandDropwithVSTS(drag_src_RecentSecrets, drop_Destination, "Recent Secrets");
			dragandDropwithVSTS(drag_src_FavoriteSecrets, drop_Destination, "Favorite Secrets");
			dragandDropwithVSTS(drag_src_ExpiredSecrets, drop_Destination, "Expired Secrets");
			dragandDropwithVSTS(drag_src_OutofSyncSecrets, drop_Destination, "Out of Sync Secrets");
			dragandDropwithVSTS(drag_src_RequestManagement, drop_Destination, "Request Management");
			dragandDropwithVSTS(drag_src_Report, drop_Destination, "Report");




			clickOn(OR.btn_content);
			
			if(!elementPresent("Create secret#xpath=div[@id='ToolBoxSeparator']"))
			{
				testStepPassed("The content button is clicked and the elements are not displayed");
				vstsTestStepPassed("The content button is clicked and the elements are not displayed", false);
			}
			else
			{
				testStepFailed("The element is displayed");
				vstsTestStepFailed("The element is displayed", true);
			}
			
			

		}
		catch(Exception ex)
		{
			System.out.println("Exception in performDashboardActions "+ex);
			ex.printStackTrace();
		}
	}
	
		
	public void commentOnView_Validation(String msg_validation)
	{
		try {


			validateDashboard();
			selectFromDropdown(OR.drpdown_Selectbulkoperation, "Disable Comment on View");
			String Err_msg = getText(lbl_validationSummary);
			System.out.println("This"+Err_msg);
			waitTime(2);
			if(Err_msg.equals(msg_validation))
			{
				testStepPassed("The occurance of Error message "+Err_msg+" is verified");
				vstsTestStepPassed("The occurance of Error message "+Err_msg+" is verified", false);
			}
			else
			{
				testStepFailed("Failed to verify the occurance of nessage "+Err_msg+"");
				vstsTestStepFailed("Failed to verify the occurance of nessage "+Err_msg+"", true);
			}
		}catch(Exception ex)
		{
			System.out.println("Exception in commentOnView_Validation "+ex);
			ex.printStackTrace();
		}
	}

	public void newSecret_Validation(String Secretname, String foldername,String createSec_elements)
	{
		try {

			PerformBulkOperation(Secretname, "Disable Comment on View", "There were no errors", lbl_noErrMsg, foldername, false, "yes", "yes");
			clickOn("secret name #xpath=//td[@title='"+Secretname+"']");
			String confirmDashboard = getText(OR.lbl_Browse);


			if(confirmDashboard.equalsIgnoreCase("Browse"))
			{
				testStepPassed("Navigated to DashBoard Page");
				vstsTestStepPassed("Navigated to DashBoard Page", false);

			}

			else
			{
				testStepFailed("Unable to navigate to DashBoard Page");
				vstsTestStepFailed("Unable to navigate to DashBoard Page", true);

			}
			if(validateAllElementisDisplay(lst_SecretElements, createSec_elements)==true)
			{
				testStepPassed("The Secret Elements are found");
				vstsTestStepPassed("The Secret Elements are found", false);
			}
			else
			{
				testStepFailed("The Secret element is not found");
				vstsTestStepFailed("The Secret element is not found", true);
			}

		}catch(Exception ex)
		{
			System.out.println("Exception in newSecret_Validation "+ex);
			ex.printStackTrace();
		}
	}
	
	
	public void CommentonView_Multiple_Secrets(String SecretName, String SecretName1, String BulkOpertion)
	{
		try {
			clickOn(OR.btn_home_icon);
			selectCheckBox("enable secret in dashboard#xpath=//td[text()='"+SecretName+"']/preceding-sibling::td/input");
			selectCheckBox("enable secret in dashboard#xpath=//td[text()='"+SecretName1+"']/preceding-sibling::td/input");
			ValidateCheckboxischeckedMultiple("//td[text()='"+SecretName+"']/preceding-sibling::td/input", "//td[text()='"+SecretName1+"']/preceding-sibling::td/input", "Secrets");

			selectFromDropdown(OR.drpdown_Selectbulkoperation, BulkOpertion);

			if (elementPresent("Bulk Operation: "+BulkOpertion+" box#xpath=//span[text()='Bulk Operation: "+BulkOpertion+"']")) {
				testStepPassed("Bulk Operation: "+BulkOpertion+"' page should be displayed");
				vstsTestStepPassed("Bulk Operation: "+BulkOpertion+"' page should be displayed", false);
			}
			else {
				testStepFailed("Bulk Operation: "+BulkOpertion+"' page should not be displayed");
				vstsTestStepFailed("Bulk Operation: "+BulkOpertion+"' page should not be displayed", true);
			}


			if(ValidateBulkOperationOkPage(BulkOpertion, false)==true)
			{
				testStepPassed("Elements validated in Ok page");
				vstsTestStepPassed("Elements validated in Ok page", false);
			}
			else
			{
				testStepFailed("Unable to validate Elements in Ok page");
				vstsTestStepFailed("Unable to validate Elements in Ok page", true);
			}

			clickOn(btn_OK);

			if (elementPresent("Bulk Operation: "+BulkOpertion+" box#xpath=//span[text()='Bulk Operation: "+BulkOpertion+"']")) {
				testStepPassed("Bulk Operation: "+BulkOpertion+"' page should be displayed");
				vstsTestStepPassed("Bulk Operation: "+BulkOpertion+"' page should be displayed", false);
			}
			else {
				testStepFailed("Bulk Operation: "+BulkOpertion+"' page should not be displayed");
				vstsTestStepFailed("Bulk Operation: "+BulkOpertion+"' page should not be displayed", true);
			}
			boolean secret =ValidateBulkOperationComplatePage(SecretName, BulkOpertion, "error message xpath#xpath=//div[@id='gview_BulkOperationErrorMessageGrid']//div//td[text()='"+SecretName+"']/following-sibling::td", "Secret \""+SecretName+"\" is already set to not require comment on view.");
			boolean secret1 =ValidateBulkOperationComplatePage(SecretName, BulkOpertion, "error message xpath#xpath=//div[@id='gview_BulkOperationErrorMessageGrid']//div//td[text()='"+SecretName1+"']/following-sibling::td", "Secret \""+SecretName1+"\" is already set to not require comment on view.");
			waitTime(4);
			if(secret==true && secret1==true)
			{
				testStepPassed("Verified presence of elements");
				vstsTestStepPassed("Verified presence of elements", false);
			}
			else
			{
				testStepFailed("unable to verify the presence of elements");
				vstsTestStepFailed("unable to verify the presence of elements", true);
			}

			clickOn(btn_close);

			String confirmDashboard = getText(OR.lbl_Browse);

			if(confirmDashboard.equalsIgnoreCase("Browse"))
			{
				testStepPassed("Navigated to DashBoard Page");
				vstsTestStepPassed("Navigated to DashBoard Page", false);
			}

			else
			{
				testStepFailed("Unable to navigate to DashBoard Page");
				vstsTestStepFailed("Unable to navigate to DashBoard Page", true);
			}


		}catch(Exception ex)
		{
			System.out.println("Exception in CommentonView_Multiple_Secrets "+ex);
			ex.printStackTrace();
		}
	}


	public void single_Enable_Check_Out(String Secretname, String BulkOperation, String foldername)
	{
		try {

			PerformBulkOperation(Secretname, "Enable Check Out", "There were no errors", lbl_noErrMsg, foldername, false, "yes", "yes");
			
			String confirmDashboard = getText(OR.lbl_Browse);

			if(confirmDashboard.equalsIgnoreCase("Browse"))
			{
				testStepPassed("Navigated to DashBoard Page");
				vstsTestStepPassed("Navigated to DashBoard Page", false);
			}

			else
			{
				testStepFailed("Unable to navigate to DashBoard Page");
				vstsTestStepFailed("Unable to navigate to DashBoard Page", true);

			}
			clickOn("Secret#xpath=//td[@title='"+Secretname+"' and contains(@aria-describedby,'"+Secretname+"')]");

			if(validateElementisDisplay("Inline Test#xpath=//span[@class='InlineSecretView']/div", "Please click view to Checkout the Secret.")==1)
			{
				testStepPassed("The Message is present after clicking the secret");
				vstsTestStepPassed("The Message is present after clicking the secret", false);
			}
			else
			{
				testStepFailed("The Message is not present after clicking the secret");
				vstsTestStepFailed("The Message is not present after clicking the secret", true);
			}

		}catch(Exception ex)
		{
			System.out.println("Exception in single_Enable_Check_Out "+ex);
			ex.printStackTrace();
		}
	}

	public void multiple_Enable_Check_Out(String SecretName, String SecretName1, String BulkOpertion)
	{
		try {

			clickOn(OR.btn_home_icon);
			selectCheckBox("enable secret in dashboard#xpath=//td[text()='"+SecretName+"']/preceding-sibling::td/input");
			selectCheckBox("enable secret in dashboard#xpath=//td[text()='"+SecretName1+"']/preceding-sibling::td/input");
			ValidateCheckboxischeckedMultiple("//td[text()='"+SecretName+"']/preceding-sibling::td/input", "//td[text()='"+SecretName1+"']/preceding-sibling::td/input", "Secrets");

			selectFromDropdown(OR.drpdown_Selectbulkoperation, BulkOpertion);

			if (elementPresent("Bulk Operation: "+BulkOpertion+" box#xpath=//span[text()='Bulk Operation: "+BulkOpertion+"']")) {
				testStepPassed("Bulk Operation: "+BulkOpertion+" page should be displayed");
				vstsTestStepPassed("Bulk Operation: "+BulkOpertion+" page should be displayed", false);
			}
			else {
				testStepFailed("Bulk Operation: "+BulkOpertion+" page should not be displayed");
				vstsTestStepFailed("Bulk Operation: "+BulkOpertion+" page should not be displayed", true);
			}

			if(ValidateBulkOperationOkPage(BulkOpertion, false)==true)
			{
				testStepPassed("Elements validated in Ok page");
				vstsTestStepPassed("Elements validated in Ok page", false);
			}
			else
			{
				testStepFailed("Unable to validate Elements in Ok page");
				vstsTestStepFailed("Unable to validate Elements in Ok page", true);
			}

			clickOn(btn_OK);
			if (elementPresent("Bulk Operation: "+BulkOpertion+" box#xpath=//span[text()='Bulk Operation: "+BulkOpertion+"']")) {
				testStepPassed("Bulk Operation: "+BulkOpertion+" page should be displayed");
				vstsTestStepPassed("Bulk Operation: "+BulkOpertion+" page should be displayed", false);
			}
			else {
				testStepFailed("Bulk Operation: "+BulkOpertion+" page should not be displayed");
				vstsTestStepFailed("Bulk Operation: "+BulkOpertion+" page should not be displayed", true);
			}

			boolean secret = ValidateBulkOperationComplatePage(SecretName, BulkOpertion, "Error Msg#xpath=//div[@id='gview_BulkOperationErrorMessageGrid']//div//td[text()='"+SecretName+"']/following-sibling::td", "Secret \""+SecretName+"\" is already set to require Check Out.");
			boolean secret1 = ValidateBulkOperationComplatePage(SecretName1, BulkOpertion, "Error Msg#xpath=//div[@id='gview_BulkOperationErrorMessageGrid']//div//td[text()='"+SecretName1+"']/following-sibling::td", "Secret \""+SecretName1+"\" is already set to require Check Out.");

			if(secret==true && secret1==true)
			{
				testStepPassed("Fields found in Complete page");
				vstsTestStepPassed("Fields found in Complete page", false);
			}
			else
			{
				//				testStepFailed("Fields not found in Complete page");
				vstsTestStepFailed("Fields not found in Complete page", true);
			}

			clickOn(btn_close);

			String confirmDashboard = getText(OR.lbl_Browse);

			if(confirmDashboard.equalsIgnoreCase("Browse"))
			{
				testStepPassed("Navigated to DashBoard Page");
				vstsTestStepPassed("Navigated to DashBoard Page", false);
			}

			else
			{
				testStepFailed("Unable to navigate to DashBoard Page");
				vstsTestStepFailed("Unable to navigate to DashBoard Page", true);
			}



		}catch(Exception ex)
		{
			System.out.println("Exception in single_Enable_Check_Out "+ex);
			ex.printStackTrace();
		}
	}

	public void Validate_Welcome_contentElement(String contentItem, String alertMsg)
	{
		try {


			clickOn(OR.btn_content);
			if(!elementPresent(drag_src_WelcomeButton))
			{
				testStepPassed("Verifies: The WELCOME element is not present");
				vstsTestStepPassed("Verifies: The WELCOME element is not present", false);
			}
			else
			{
				testStepFailed("Unable to Verify: The WELCOME element is present");
				vstsTestStepFailed("Unable to Verify: The WELCOME element is present", true);

			}
			clickOn(OR.btn_content);

			clickOn("delete content item from DashBoard#xpath=//h2[text()='"+contentItem+"']/following-sibling::ul/li[@class='ui-icon ui-icon-trash CloseWidget']");
			validateAlertText(alertMsg, true);
			alertOk();

			if (elementPresent("Welcome tab#xpath=//h2[text()='Welcome']"))
			{
				testStepPassed("Element not present in dashboard");
				vstsTestStepPassed("Element not present in dashboard", false);
			}
			else
			{
				testStepFailed("Unable to verify the presence of Element");
				vstsTestStepFailed("Unable to verify the presence of Element", true);
			}

			clickOn(OR.btn_content);

			if(elementPresent(drag_src_WelcomeButton))
			{
				testStepPassed("Verifies: The WELCOME element is present");
				vstsTestStepPassed("Verifies: The WELCOME element is present", false);
			}
			else
			{
				testStepFailed("Unable to Verify: The WELCOME element is present");
				vstsTestStepFailed("Unable to Verify: The WELCOME element is present", true);

			}




		}catch(Exception ex)
		{
			System.out.println("Exception in Validate_Welcome_contentElement "+ex);
			ex.printStackTrace();
		}
	}



	public void hide_Launcher_Password(String Secretname,String BulkOperation, String foldername, boolean inherit,String vstsUpdateforOkPagetitle,String vstsUpdateforComplatepagetitle,String SecretItem)
	{
		try {

			PerformBulkOperation(Secretname, BulkOperation, "There were no errors",  lbl_noErrMsg, foldername, inherit, vstsUpdateforOkPagetitle, vstsUpdateforComplatepagetitle);

			clickOn("secret name #xpath=//td[@title='"+Secretname+"']");
			clickOn("View button in secret#xpath=//table[@class='InlineSecretViewTable']/following-sibling::table/tbody/tr/td/a[text()='View']");

			if(isElementDisplayed("Navigated to secret page#xpath=//td[@class='dialog_top' and contains(text(),'"+Secretname+"')]"))
			{
				testStepPassed("Navigated to Secret page");
				vstsTestStepPassed("Navigated to Secret page", false);
			}
			else
			{
				testStepFailed("Unable to navigate to Secret page");
				vstsTestStepFailed("Unable to navigate to Secret page", true);
			}

			clickOn(btn_security);


			if(elementPresent(lbl_HideLauncherPassword))
			{
				testStepPassed("Verified the activation of Hide launcher password");
				vstsTestStepPassed("Verified the activation of Hide launcher password", false);
			}
			else
			{
				testStepFailed("Unable to Verify activation of Hide launcher password");
				vstsTestStepFailed("Unable to Verify activation of Hide launcher password", true);
			}

		}catch(Exception ex)
		{
			System.out.println("Exception in hide_Launcher_Password "+ex);
			ex.printStackTrace();
		}
	}

	public void RemotePasswordOption(String RemotePasswordParams, String RemotePasswordParamsStatus, String OperationName)
	{
		try {

			EnableDisableRemotePasswordChangingParameters(RemotePasswordParams, RemotePasswordParamsStatus);
			clickOn(OR.btn_home_icon);
			waitTime(3);
			if(elementPresent("Checking remote access password#xpath=//select[@id='OperationDropDownList']/optgroup[contains(@label,'"+OperationName+"')]"))
			{
				testStepPassed("The value "+ OperationName+" is present in dropdown ");	
				vstsTestStepPassed("The value "+ OperationName+" is present in dropdown " , false);
			}
			else
			{
				testStepFailed("Unable to verify "+ OperationName+" presence in dropdown ");
				vstsTestStepFailed("Unable to verify "+ OperationName+" presence in dropdown ", true);
			}

		}catch(Exception ex)
		{
			System.out.println("Exception in RemotePasswordOption "+ex);
			ex.printStackTrace();
		}
	}

	public void SetFavourite(String SecretDetails, String WidgetName, String SecretName)
	{
		try
		{
			clickOn(OR.btn_home_icon);
			//			checkSecretWidgetIspresent(WidgetName);
			clickOn("Click row to view details#xpath=//table[contains(@class,'expandableGridTable')]//tr//td[text()='"+SecretName+"']");


			if(validateAllElementisDisplay("validate secretgrid#xpath=//table[@class='InlineSecretViewTable']/tbody//tr//label", SecretDetails))
			{
				testStepPassed("Verified presence of elements in secret grid");
				vstsTestStepPassed("Verified presence of elements in secret grid", false);
			}
			else
			{
				testStepFailed("unable to verify presence of elements in secret grid");
				vstsTestStepFailed("unable to verify presence of elements in secret grid", true);
			}

			if(elementPresent(btn_iconfavourite))
			{
				testStepPassed("Verified presence of favorite icon");
				vstsTestStepPassed("Verified presence of favorite icon", false);
			}
			else
			{
				testStepFailed("unable to verify the presence of favorite icon");
				vstsTestStepFailed("unable to verify the presence of favorite icon", true);
			}

			clickOn(btn_iconfavourite);

			if(elementPresent("Favourite enabled secret#xpath=//td[@title='"+SecretName+"']/../following-sibling::tr//table//td/span[@style='cursor:pointer;']"))
			{
				testStepPassed("The favourite is enabled for "+SecretName+"");
				vstsTestStepPassed("The favourite is enabled for "+SecretName+"", false);
			}
			else
			{
				testStepFailed("The secret "+SecretName+" is not enabled for favourite");
				vstsTestStepFailed("The secret "+SecretName+" is not enabled for favourite", true);
			}


			if(validateElementisDisplay("favourite secret#xpath=//p[@class='listRowItem']/a", SecretName)==1)
			{
				testStepPassed("The secret "+SecretName+" is present in favourite secret widget");
				vstsTestStepPassed("The secret "+SecretName+" is present in favourite secret widget", false);
			}
			else
			{
				testStepFailed("The secret "+SecretName+" is not present in favourite secret widget");
				vstsTestStepFailed("The secret "+SecretName+" is not present in favourite secret widget", true);
			}
		}catch(Exception ex)
		{
			System.out.println("Exception in SetFavourite "+ex);
			ex.printStackTrace();
		}

	}



	public void Multiple_Pin_Secret(String SecretName,String SecretName1, String BulkOpertion, String Error_msg)
	{
		try {
			clickOn(OR.btn_home_icon);
			selectCheckBox("enable secret in dashboard#xpath=//td[text()='"+SecretName+"']/preceding-sibling::td/input");
			selectCheckBox("enable secret in dashboard#xpath=//td[text()='"+SecretName1+"']/preceding-sibling::td/input");
			ValidateCheckboxischeckedMultiple("//td[text()='"+SecretName+"']/preceding-sibling::td/input", "//td[text()='"+SecretName1+"']/preceding-sibling::td/input", "Secrets");

			waitTime(3);
			selectFromDropdown(OR.drpdown_Selectbulkoperation, BulkOpertion);

			if (elementPresent("Bulk Operation: "+BulkOpertion+" box#xpath=//span[text()='Bulk Operation: "+BulkOpertion+"']")) {
				testStepPassed("Bulk Operation: "+BulkOpertion+"' page should be displayed");
				vstsTestStepPassed("Bulk Operation: "+BulkOpertion+"' page should be displayed", false);
			}
			else {
				testStepFailed("Bulk Operation: "+BulkOpertion+"' page should not be displayed");
				vstsTestStepFailed("Bulk Operation: "+BulkOpertion+"' page should not be displayed", true);
			}
			elementPresent("Confirmation message#xpath=//div[@id='BulkModal' and text()='Are you sure you want to perform this action on the selected Secrets?']");
			validateWebElements("//div[@class='ui-dialog-buttonset']/button", "OK##Cancel");
			clickOn(btn_OK);

			//validateWebElements("//td[text()='Secret does not have a launcher.']", Error_msg);

			int secret = validateElementisDisplay("error message#xpath=//table[@id='BulkOperationErrorMessageGrid']//td[@title='"+SecretName+"']/following-sibling::td", Error_msg);
			System.out.println("secret "+secret);
			
			
			
			int secret1 = validateElementisDisplay("error message#xpath=//table[@id='BulkOperationErrorMessageGrid']//td[@title='"+SecretName1+"']/following-sibling::td", Error_msg);

			System.out.println("secret 11"+secret);
			
			if(secret==1 && secret1==1)
			{
				testStepPassed("Error message validated");
				vstsTestStepPassed("Error message validated", false);
			}
			else
			{
				testStepFailed("Unable to verify error message");
				vstsTestStepFailed("Unable to verify error message", true);
			}
			clickOn(btn_close);

		}catch(Exception ex)
		{
			System.out.println("Exception in Multiple_Pin_Secret "+ex);
			ex.printStackTrace();
		}
	}

	public void Enable_Autochange_RemotePassword(String SecretTemplate, String SecretTemplateParas, String SecretTemplateHearthbeatStatus,String SecretName, String SecretName1, String BulkOpertion)
	{
		try
		{
			clickOn(OR.btn_home_icon);
			enableDiasableRemotePasswordandHBInSecretTemplates(SecretTemplate, SecretTemplateParas, SecretTemplateHearthbeatStatus);
			selectCheckBox("enable secret in dashboard#xpath=//td[text()='"+SecretName+"']/preceding-sibling::td/input");
			selectCheckBox("enable secret in dashboard#xpath=//td[text()='"+SecretName1+"']/preceding-sibling::td/input");
			ValidateCheckboxischeckedMultiple("//td[text()='"+SecretName+"']/preceding-sibling::td/input", "//td[text()='"+SecretName1+"']/preceding-sibling::td/input", "Secrets");

			selectFromDropdown(OR.drpdown_Selectbulkoperation, BulkOpertion);
			if (elementPresent("Bulk Operation: "+BulkOpertion+" box#xpath=//span[text()='Bulk Operation: "+BulkOpertion+"']")) {
				testStepPassed("'Bulk Operation: "+BulkOpertion+"' page should be displayed");
			}
			else {
				testStepFailed("'Bulk Operation: "+BulkOpertion+"' page should not be displayed");
			}
			elementPresent("Confirmation message#xpath=//div[@id='BulkModal' and text()='Are you sure you want to perform this action on the selected Secrets?']");
			validateWebElements("//div[@class='ui-dialog-buttonset']/button", "OK##Cancel");
			clickOn(btn_OK);

			
			

			int secret =validateElementisDisplay("error msg#xpath=//div[@id='gview_BulkOperationErrorMessageGrid']//div//td[text()='"+SecretName+"']/following-sibling::td", "The Secret Template for \""+SecretName+"\" is not configured for Password Changing");
			int secret1 = validateElementisDisplay("error msg#xpath=//div[@id='gview_BulkOperationErrorMessageGrid']//div//td[text()='"+SecretName1+"']/following-sibling::td", "The Secret Template for \""+SecretName1+"\" is not configured for Password Changing");
			if((secret==1) && (secret1==1))
			{
				testStepPassed("validated error msg");
				vstsTestStepPassed("validated error msg", false);
			}
			else
			{
				testStepFailed("unable to validate error msg");
				vstsTestStepFailed("unable to validate error msg", true);
			}
			clickOn(btn_close);
		}catch(Exception ex)
		{
			System.out.println("Exception in Enable_Autochange_RemotePassword "+ex);
			ex.printStackTrace();	
		}
	}


	public void RunHeartbeat_HeartbeatDisabled(String SecretTemplate, String SecretTemplateParas, String SecretTemplateHearthbeatStatus,String SecretName, String SecretName1, String BulkOpertion)
	{

		clickOn(OR.btn_home_icon);
		selectCheckBox("enable secret in dashboard#xpath=//td[text()='"+SecretName+"']/preceding-sibling::td/input");
		selectCheckBox("enable secret in dashboard#xpath=//td[text()='"+SecretName1+"']/preceding-sibling::td/input");
		
		ValidateCheckboxischeckedMultiple("//td[text()='"+SecretName+"']/preceding-sibling::td/input", "//td[text()='"+SecretName1+"']/preceding-sibling::td/input", "Secrets");
		
		
		selectFromDropdown(OR.drpdown_Selectbulkoperation, BulkOpertion);
		if (elementPresent("Bulk Operation: "+BulkOpertion+" box#xpath=//span[text()='Bulk Operation: "+BulkOpertion+"']")) {
			testStepPassed("Bulk Operation: "+BulkOpertion+"' page should be displayed");
			vstsTestStepPassed("Bulk Operation: "+BulkOpertion+"' page should be displayed", false);
		}
		else {
			testStepFailed("Bulk Operation: "+BulkOpertion+"' page should not be displayed");
			vstsTestStepFailed("Bulk Operation: "+BulkOpertion+"' page should not be displayed", true);
		}
		elementPresent("Confirmation message#xpath=//div[@id='BulkModal' and text()='Are you sure you want to perform this action on the selected Secrets?']");
		validateWebElements("//div[@class='ui-dialog-buttonset']/button", "OK##Cancel");
		clickOn(btn_OK);

	

		int secret=validateElementisDisplay("error msg#xpath=//div[@id='gview_BulkOperationErrorMessageGrid']//div//td[text()='"+SecretName+"']/following-sibling::td", "The Secret Template for \""+SecretName+"\" is not configured for Heartbeat");
		int secret1 = validateElementisDisplay("error msg#xpath=//div[@id='gview_BulkOperationErrorMessageGrid']//div//td[text()='"+SecretName1+"']/following-sibling::td", "The Secret Template for \""+SecretName1+"\" is not configured for Heartbeat");
		
		if(secret==1 && secret1==1)
		{
			testStepPassed("Elements are validated");
			vstsTestStepPassed("Elements are validated", false);
		}
		else
		{
			testStepFailed("Unable to validate Elements");
			vstsTestStepFailed("Unable to validate Elements", true);
		}
		
		String confirmDashboard = getText(OR.lbl_Browse);

		if(confirmDashboard.equalsIgnoreCase("Browse"))
		{
			testStepPassed("Navigated to DashBoard Page");
			vstsTestStepPassed("Navigated to DashBoard Page", false);
		}

		else
		{
			testStepFailed("Unable to navigate to DashBoard Page");
			vstsTestStepFailed("Unable to navigate to DashBoard Page", true);
			
		}
		
		
		clickOn(btn_close);
	}


	public void Disableheartbeat_HeartbeatDisabled(String SecretName,String BulkOpertion, 
			String BulkOperationErrorMessage, String foldername, boolean BrowserButton)
	{
		clickOn(OR.btn_home_icon);
		String xpath = null;
		
		CheckBulkOpertionWithfolderErrorMsg(SecretName, BulkOpertion, BulkOperationErrorMessage, foldername);
	
		String confirmDashboard = getText(OR.lbl_Browse);

		if (BrowserButton) {
			if(confirmDashboard.equalsIgnoreCase("Browse"))
			{
				testStepPassed("Navigated to DashBoard Page");
				vstsTestStepPassed("Navigated to DashBoard Page", false);
			}
	
			else
			{
				testStepFailed("Unable to navigate to DashBoard Page");
				vstsTestStepFailed("Unable to navigate to DashBoard Page", true);
			}
		}
	}


	public void AddShareBulkOperation(String SecretName, String BulkOpertion,String foldername) 
	{
		clickOn(OR.btn_home_icon);
		PerformBulkOperation(SecretName, BulkOpertion, "You do not have Owner permissions on Secret \""+SecretName+"\".", "Error msg#xpath=//div[@id='gview_BulkOperationErrorMessageGrid']//div//td[text()='"+SecretName+"']/following-sibling::td", foldername, false, "No", "Yes");
	}

	public void PerformEnableCheckOutforNewSecretscopypermissionsfromfolder(String SecretName, String BulkOpertion,String foldername) 
	{
		clickOn(OR.btn_home_icon);
		PerformBulkOperation(SecretName, BulkOpertion, "You do not have Edit permission on Secret \""+SecretName+"\".", "Error msg#xpath=//div[@id='gview_BulkOperationErrorMessageGrid']//div//td[text()='"+SecretName+"']/following-sibling::td", foldername, false, "No", "Yes");
	}


	public void PerformEnableCheckOutforNewSecretswithEditPermisson(String SecretName, String BulkOpertion,String foldername) 
	{
		clickOn(OR.btn_home_icon);
		
		PerformBulkOperation(SecretName, BulkOpertion, "There were no errors", lbl_noErrMsg, foldername, false, "No", "Yes");
	}


	public void PerformHeartbeatwithListPermission(String SecretName, String BulkOpertion,String foldername) 
	{
		clickOn(OR.btn_home_icon);
		
		PerformBulkOperation(SecretName, BulkOpertion, "You do not have Owner permissions on Secret \""+SecretName+"\".", "Error msg#xpath=//div[@id='gview_BulkOperationErrorMessageGrid']//div//td[text()='"+SecretName+"']/following-sibling::td", foldername, false, "No", "Yes");
	}

	public void PerformRunHeartbeatWithViewPermission(String SecretName, String BulkOpertion,String foldername) 
	{
		clickOn(OR.btn_home_icon);
		
		PerformBulkOperation(SecretName, BulkOpertion, "You do not have Edit permission on Secret \""+SecretName+"\".", "Error msg#xpath=//div[@id='gview_BulkOperationErrorMessageGrid']//div//td[text()='"+SecretName+"']/following-sibling::td", foldername, false, "No", "Yes");
	}


	public void PerformRunHeartbeatWithListPermission(String SecretName, String BulkOpertion, String foldername) 
	{
		clickOn(OR.btn_home_icon);
		PerformBulkOperation(SecretName, BulkOpertion, "You do not have Edit permission on Secret \""+SecretName+"\".", "Error msg#xpath=//div[@id='gview_BulkOperationErrorMessageGrid']//div//td[text()='"+SecretName+"']/following-sibling::td", foldername, false, "No", "Yes");	
	}


	public void PerformEnableHeartbeatWithViewPermission(String SecretName, String BulkOpertion,String foldername) 
	{
		clickOn(OR.btn_home_icon);
		PerformBulkOperation(SecretName, BulkOpertion, "Secret \""+SecretName+"\" already has heartbeat enabled.", "Error msg#xpath=//div[@id='gview_BulkOperationErrorMessageGrid']//div//td[text()='"+SecretName+"']/following-sibling::td", foldername, false, "No", "Yes");
	}
	

	public void PerformDisableHeartbeatWithViewPermission(String SecretName, String BulkOpertion,String foldername) 
	{
		clickOn(OR.btn_home_icon);
		PerformBulkOperation(SecretName, BulkOpertion, "There were no errors.", lbl_noErrMsg, foldername, false, "No", "Yes");
	}

	public void PerformRunHeartbeatWithViewPermission_onlyCreatorHasPermission(String SecretName, String BulkOpertion,String foldername) 
	{
		clickOn(OR.btn_home_icon);
		PerformBulkOperation(SecretName, BulkOpertion, "There were no errors", lbl_noErrMsg, foldername, false, "No", "Yes");
	}

	public void BasicTab(String SecretElements, String SecretName)
	{
		clickOn(OR.btn_home_icon);
		clickOn(btn_basicTab);
		waitTime(3);
		
		//validateWebElements("//legend[text()='Secrets']", "Secrets");
		
		if(validateElementisDisplay("Secrets#xpath=//legend", "Secrets")==1)
		{
			testStepPassed("Secrets is displayed");
			vstsTestStepPassed("Secrets is displayed", false);
		}
		else
		{
			testStepFailed("Secrets is not displayed");
			vstsTestStepFailed("Secrets is not displayed", true);
		}
		
		driver.findElement(By.xpath("//span[@title='Bank Account']/following-sibling::label[@title='"+SecretName+"']")).click();
		if(validateAllElementisDisplay("Fields in Inline#xpath=//span", SecretElements)==true)
		{
			testStepPassed("Secret Elements are displayed");
			vstsTestStepPassed("Secret Elements are displayed", false);
		}
		else
		{
			testStepFailed("Secret Elements are not displayed");
			vstsTestStepFailed("Secret Elements are not displayed", true);
		}
		clickOn(btn_view);
		
		if(validateElementisDisplay("Secret is Present#xpath=//table[@id='SecretViewDialog_DialogTable']//td", SecretName)==1)
		{
			testStepPassed(SecretName+" (Bank Account) is present");
			vstsTestStepPassed(SecretName+" (Bank Account) is present", false);
		}
		else
		{
			testStepFailed(SecretName+" (Bank Account) is not present");
			vstsTestStepFailed(SecretName+" (Bank Account) is not present", true);
		}
		clickOn(OR.btn_home_icon);
		clickOn(OR.btn_AdbancedTab);
		waitTime(2);
	}

	public void copyTextTOClipBoard(String SecretName, String SecretData, String path) throws IOException
	{
		clickOn(OR.btn_home_icon);
		clickOn(btn_basicTab);
		waitTime(3);
		validateWebElements("//legend[text()='Secrets']", "Secrets");
		clickOn("Click on Secret in basic tab#xpath=//span[@title='Windows Account']/following-sibling::label[@title='"+SecretName+"']");

		clickOn("Unlock Password#xpath=//span[contains(@class,'unmaskhyperlink')]");
		waitTime(3);
		validateWebElements("//ul[@class='SecretFields']/li/span/following-sibling::span[contains(@class,'inlineValueDisplay')]", SecretData);

		waitTime(2);
		clickOn("copy to clipboard#xpath=//span[contains(@class,'unmaskhyperlink')]/preceding-sibling::span[@title='Copy To Clipboard.']");

		ClipBoardtoTextFile(path);


	}

	public void dragandDropwithVSTS(String sourceLocator, String destinationLocator, String ElementName)
	{

		clickOn(OR.btn_home_icon);

		dragAndDropDashboard(sourceLocator, destinationLocator);

		if(elementPresent("validating elements#xpath=//div[@class='WidgetLiDiv']/h2[text()='"+ElementName+"']"))
		{
			testStepPassed("Verifed the presence of element"+ElementName+"");
			vstsTestStepPassed("Verifed the presence of element", false);
		}
		else
		{
			testStepFailed("Unable to verify the presence of element"+ElementName+"");
			vstsTestStepFailed("Unable to verify the presence of element", true);
		}
	}



	public void ValidateCheckboxischecked(String xpath, String element) {

		try {

			System.out.println("SSS"+xpath);

			if (driver.findElementByXPath(xpath).isEnabled()) {
				testStepPassed(element+" is checked");
				vstsTestStepPassed(element+" is checked", false);
			}
			else {
				testStepFailed(element+ " is not checked");
				vstsTestStepFailed(element+ " is not checked", true);
			}
		}
		catch(Exception e) {
			vstsTestStepFailed(element+ " is not checked", true);
			e.printStackTrace();
		}
	}
	public void ValidateCheckboxischeckedMultiple(String xpath,String xpath1, String element) {

		try {

			System.out.println("SSS"+xpath+" "+xpath1);

			if (driver.findElementByXPath(xpath).isEnabled() && driver.findElementByXPath(xpath1).isEnabled()) {
				testStepPassed(element+" is checked");
				vstsTestStepPassed(element+" is checked", false);
			}
			else {
				testStepFailed(element+ " is not checked");
				vstsTestStepFailed(element+ " is not checked", true);
			}
		}
		catch(Exception e) {
			vstsTestStepFailed(element+ " is not checked", true);
			e.printStackTrace();
		}
	}

	public boolean ValidateBulkOperationOkPage(String BulkOpertion, boolean Inherit) {
		boolean messageStatus = false;
		boolean Status = false;

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

	public boolean performbulkoperationforPreCondition(String SecretName, String BulkOperation, String foldername, boolean WithVstsUpdate) {

		boolean status = true;
		clickOn(OR.btn_home_icon);
		switchTofolders(foldername);

		if (elementPresent("Secret in Dashboard#xpath=//td[text()='"+SecretName+"']")) {
			selectCheckBox("enable secret in dashboard#xpath=//td[text()='"+SecretName+"']/preceding-sibling::td/input");
			selectFromDropdown(OR.drpdown_Selectbulkoperation, BulkOperation);

			if (elementPresent("Bulk Operation: "+BulkOperation+" box#xpath=//span[text()='Bulk Operation: "+BulkOperation+"']")) {
				testStepPassed("'Bulk Operation: "+BulkOperation+"' page should be displayed");
			}
			else {
				testStepFailed("'Bulk Operation: "+BulkOperation+"' page should not be displayed");
			}

			clickOn("Ok button in Bulk Option#xpath=//div[@class='ui-dialog-buttonset']/button[text()='OK']");

			if (elementPresent("Bulk operation "+BulkOperation+" completed page#xpath=//span[text()='Bulk Operation: "+BulkOperation+"']")) {
				testStepPassed("Bulk operation "+BulkOperation+" completed page is displayed");
			}
			else {
				testStepFailed("Bulk operation  completed page is not displayed");
			}

			if (isElementDisplayed("No error Message#xpath=//div[@id='NoErrorMessage']")) {
				status = true;
				if(WithVstsUpdate)
					vstsTestStepPassed(BulkOperation +" is successfully", false);
			}
			else {
				status = false;
				if(WithVstsUpdate)
					vstsTestStepFailed(BulkOperation+"is not Successfully", true);
			}

			waitTime(4);
			clickOn("close button #xpath=//div[@class='ui-dialog-buttonset']/button[text()='Close']");
		}
		else {
			testStepFailed("' "+SecretName+"' Secret is not present in Dashboard");
		}
		return status;
	}

	public boolean performbulkoperationforPreConditionErrorMsg(String SecretName, String BulkOperation, String foldername, boolean WithVstsUpdate,String ErrMsg) {

		boolean status = true;
		clickOn(OR.btn_home_icon);
		switchTofolders(foldername);

		if (elementPresent("Secret in Dashboard#xpath=//td[text()='"+SecretName+"']")) {
			selectCheckBox("enable secret in dashboard#xpath=//td[text()='"+SecretName+"']/preceding-sibling::td/input");
			selectFromDropdown(OR.drpdown_Selectbulkoperation, BulkOperation);

			if (elementPresent("Bulk Operation: "+BulkOperation+" box#xpath=//span[text()='Bulk Operation: "+BulkOperation+"']")) {
				testStepPassed("'Bulk Operation: "+BulkOperation+"' page should be displayed");
			}
			else {
				testStepFailed("'Bulk Operation: "+BulkOperation+"' page should not be displayed");
			}

			clickOn("Ok button in Bulk Option#xpath=//div[@class='ui-dialog-buttonset']/button[text()='OK']");

			if (elementPresent("Bulk operation "+BulkOperation+" completed page#xpath=//span[text()='Bulk Operation: "+BulkOperation+"']")) {
				testStepPassed("Bulk operation "+BulkOperation+" completed page is displayed");
			}
			else {
				testStepFailed("Bulk operation  completed page is not displayed");
			}

			if (isElementDisplayed("Error Message#xpath=//td[text()='"+SecretName+"']/following-sibling::td[text()='"+ErrMsg+"']")) {
				status = true;
				if(WithVstsUpdate)
					vstsTestStepPassed(BulkOperation +" is successfully", false);
			}
			else {
				status = false;
				if(WithVstsUpdate)
					vstsTestStepFailed(BulkOperation+"is not Successfully", true);
			}

			waitTime(4);
			clickOn("close button #xpath=//div[@class='ui-dialog-buttonset']/button[text()='Close']");
		}
		else {
			testStepFailed("' "+SecretName+"' Secret is not present in Dashboard");
		}
		return status;
	}
	
//	public void PerformBulkOperation(String SecretName, String BulkOperation, String BulkOperationErrorMsg, 
//			String BulkErrorMessageXpath, String foldername, boolean inherit,  String vstsUpdateforOkPagetitle, String vstsUpdateforComplatepagetitle) {
//		try {
//			clickOn(OR.btn_home_icon);
//			waitTime(2);
//			switchTofolders(foldername);
//
//			if (PerformSecretChecked(SecretName)) {
//				vstsTestStepPassed("All secret are checked", true);
//			}
//			else {
//				vstsTestStepFailed("Some secrets sre not checked", true);
//			}
//
//
//			selectFromDropdown(OR.drpdown_Selectbulkoperation, BulkOperation);
//			if (vstsUpdateforOkPagetitle.equalsIgnoreCase("Yes")) {
//				if (elementPresent("Bulk Operation: "+BulkOperation+" box#xpath=//span[text()='Bulk Operation: "+BulkOperation+"']")) {
//					testStepPassed("'Bulk Operation: "+BulkOperation+"' page should be displayed");
//					vstsTestStepPassed("'Bulk Operation: "+BulkOperation+"' page should be displayed", false);
//				}
//				else {
//					testStepFailed("'Bulk Operation: "+BulkOperation+"' page should not be displayed");
//					vstsTestStepFailed("'Bulk Operation: "+BulkOperation+"' page should not be displayed", true);
//				}
//			}
//
//			if(ValidateBulkOperationOkPage(BulkOperation, inherit)) {
//				vstsTestStepPassed("Bulk Operation Message and OK,Cancel is Present", false);
//			}
//			else {
//				vstsTestStepFailed("Bulk Operation Message and OK,Cancel is not Present", true);
//			}
//
//			if (inherit) {
//				selectCheckBox(OR.chk_Inherit_Secret_Policy);
//				waitTime(3);
//				if (isElementDisplayed(OR.drd_Secret_Policy)) {
//					testStepFailed("Secret Policy Field Is Present After Enabling a Inherit Secret Policy");
//					vstsTestStepFailed("Secret Policy Field Is Not Present After Enabling a Inherit Secret Policy", true);
//				}
//				else {
//					testStepPassed("Secret Policy Field Is Not Present After Enabling a Inherit Secret Policy");
//					vstsTestStepPassed("Secret Policy Field Is Not Present After Enabling a Inherit Secret Policy", true);
//				}
//			}
//			clickOn("Ok button in Bulk Option#xpath=//div[@class='ui-dialog-buttonset']/button[text()='OK']");
//
//
//			if (vstsUpdateforComplatepagetitle.equalsIgnoreCase("Yes")) {
//				if (elementPresent("Bulk operation " + BulkOperation
//						+ " completed page#xpath=//span[text()='Bulk Operation: " + BulkOperation + "']")) {
//					testStepPassed("Bulk operation " + BulkOperation + " completed page is displayed");
//					vstsTestStepPassed("Bulk operation " + BulkOperation + " completed page is displayed", false);
//				} else {
//					testStepFailed("Bulk operation  completed page is not displayed");
//					vstsTestStepFailed("Bulk operation  completed page is not displayed", true);
//				} 
//			}
//
//			waitTime(4);
//			if (ValidateBulkOperationComplatePage(SecretName, BulkOperation, BulkErrorMessageXpath,
//					BulkOperationErrorMsg)) {
//				vstsTestStepPassed("Complete,Error message and Close Button is present", false);
//
//			} else {
//				vstsTestStepFailed("Complete message or Error message or Close Button is not present", true);
//			} 
//
//
//			clickOn("close button #xpath=//div[@class='ui-dialog-buttonset']/button[text()='Close']");
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	public void PerformBulkOperationPreRequisteForMultiple(String SecretName,String SecretName1,String BulkOperation,String foldername,String ErrMsg,String ErrMsg1, boolean vsts)
	{
		if(performbulkoperationforPreConditionErrorMsg(SecretName, BulkOperation, foldername, false, ErrMsg)
				&&(performbulkoperationforPreConditionErrorMsg(SecretName1, BulkOperation, foldername, false, ErrMsg1)))
		{
			testStepPassed("Prerequiste completed");
			if(vsts==true)
			vstsTestStepPassed("Prerequiste completed", false);
		}
		else
		{
			testStepFailed("Unable to complete prerequiste");
			if(vsts==false)
			vstsTestStepFailed("Unable to complete prerequiste", true);
		}
	}

	public boolean validateSecretispresent(String SecretName, String foldername, boolean WithvstsUpdate) {

		boolean Status = false;
		clickOn(OR.btn_home_icon);
		switchTofolders(foldername);
		
		if (elementPresent("Secret in Dashboard Page#xpath=//td[text()='"+SecretName+"']")) {
			testStepPassed("Secret is present in Dashboard page");
			Status = true;
			if (WithvstsUpdate)
				vstsTestStepPassed("Secret is present in Dashboard page", false);
		}
		else {
			testStepFailed("Secret is not present in Dashboard page");
			Status = false;
			if (WithvstsUpdate)
				vstsTestStepFailed("Secret is not present in Dashboard page", true);
		}
		return Status;
	}

	public void ValidateSecretIsPresentforMultiple(String SecretName,  String SecretName1, String folderName)
	{

		if(validateSecretispresent(SecretName,folderName, false)==true && validateSecretispresent(SecretName1,folderName, false)==true)
		{
			testStepPassed("Validated secrets");
			vstsTestStepPassed("Validated secrets", false);
		}
		else
		{
			testStepFailed("Unable to validate secrets");
			vstsTestStepFailed("Unable to validate secrets", true);
		}
	}	
}
