package scenarios;

import java.io.IOException;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import objectRepository.OR;
import pages.AdminPage;
import pages.BasicPage;
import pages.ConfigurationPage;
import pages.DashboardPage;
import pages.FoldersPage;
import pages.GettingStartedPage;
import pages.HelpPage;
import pages.LoginPage;
import pages.ProfilePage;
import pages.UsersPage;

public class DashboardScenarios extends ApplicationKeywords{
	BaseClass obj;
	LoginPage loginpage  ;
	DashboardPage dashboardpage ;
	HelpPage helppage ;
	ProfilePage profilepage;
	AdminPage adminpage;
	UsersPage userspage;
	ConfigurationPage configurationpage;
	FoldersPage folderspage;
	BasicPage basicpage;
	GettingStartedPage gettingstartedpage;
	private Boolean status = false;

	public DashboardScenarios(BaseClass obj) {
		// TODO Auto-generated constructor stub
		super(obj);
		this.obj=obj;
	}
	public DashboardScenarios() {

		// TODO Auto-generated constructor stub
	}
	
	
	public void verifyColumnselectionInSecretGrid() {
		try{
			
			loginpage  = new LoginPage(obj);
			dashboardpage = new DashboardPage(obj);
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(retrieve("User Name"), retrieve("Password"), "Yes");
			dashboardpage.AddVerifyColumnInSecretGrid(retrieve("Column Selection Item"), retrieve("Advance Labels"));
			loginpage.Logout();
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if (loginpage.testFailure || dashboardpage.testFailure) {
				 status = true;
			}
			this.testFailure = status;
		}
	}
	
	
	public void deleteSecretWidgeInDashboard() {
        try{
			
        	String SecretUrl = retrieve("Secret server URL");
        	String Username = retrieve("User Name");
        	String Password = retrieve("Password");
        	String ContentItem = retrieve("Content Item");
        	String Expectedmessage =  retrieve("Expected Alert Message");
        	
			loginpage  = new LoginPage(obj);
			dashboardpage = new DashboardPage(obj);
			
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(Username, Password, "No");
			dashboardpage.checkSecretWidgetIspresent(ContentItem);
			loginpage.Logout();
			
			loginpage.LaunchUrl(SecretUrl, "No");
			loginpage.Login(Username, Password, "Yes");
			dashboardpage.verifySecretWidgetDelete(ContentItem, Expectedmessage);
			loginpage.Logout();
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if (loginpage.testFailure || dashboardpage.testFailure) {
				 status = true;
			}
			this.testFailure = status;
		}
	}
	
	public void addNewTabByDraggingFolder() {
		try{
			
			loginpage  = new LoginPage(obj);
			dashboardpage = new DashboardPage(obj);
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(retrieve("User Name"), retrieve("Password"), "Yes");
			dashboardpage.addNewTabInDashboard(retrieve("NewTab Name"));
			loginpage.Logout();
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if (loginpage.testFailure || dashboardpage.testFailure) {
				 status = true;
			}
			this.testFailure = status;
		}
	}
	
	public void VerifyCurrentSessionPage() {
		try{
			
			loginpage  = new LoginPage(obj);
			profilepage = new ProfilePage(obj);
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(retrieve("User Name"), retrieve("Password"), "Yes");
			profilepage.verifyCurrentSessionpage();
			loginpage.Logout();
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if (loginpage.testFailure || profilepage.testFailure) {
				 status = true;
			}
			this.testFailure = status;
		}
	}	
	
	public void DeleteInBulkOperation() {
		try{
			
			loginpage  = new LoginPage(obj);
			dashboardpage = new DashboardPage(obj);
			
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(retrieve("User Name"), retrieve("Password"), "No");
			CreateBankAccountSecretTemplate(retrieve("Secret Template Type"), retrieve("Secret Name"), retrieve("Account Number"), retrieve("Routing Number"), retrieve("Bank Name"), 
					retrieve("First Address"), retrieve("Second Address"), retrieve("Third Address"), retrieve("Contact Person"), retrieve("Contact Phone"), 
					retrieve("Notes"), retrieve("Folder Path"), retrieve("Folder Name"));
			dashboardpage.validateSecretispresent(retrieve("Secret Name"), retrieve("Folder Name"), true);
			loginpage.Logout();
			
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(retrieve("User Name"), retrieve("Password"), "Yes");
			dashboardpage.deleteSecretusingBulkOperation(retrieve("Secret Name"), retrieve("Folder Name"));
			loginpage.Logout();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if (loginpage.testFailure || dashboardpage.testFailure) {
				 status = true;
			}
			this.testFailure = status;
		}
	}
	
	public void DisableCommentInBulkOperation() {
        try{
			
			loginpage  = new LoginPage(obj);
			dashboardpage = new DashboardPage(obj);
			
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(retrieve("User Name"), retrieve("Password"), "Yes");
			CreateBankAccountSecretTemplate(retrieve("Secret Template Type"), retrieve("Secret Name"), retrieve("Account Number"), retrieve("Routing Number"), retrieve("Bank Name"), 
					retrieve("First Address"), retrieve("Second Address"), retrieve("Third Address"), retrieve("Contact Person"), retrieve("Contact Phone"), 
					retrieve("Notes"), retrieve("Folder Path"), retrieve("Folder Name"));
			//dashboardpage.validateSecretispresent(retrieve("Secret Name"));
			//loginpage.Logout();
			
			//dashboardpage.EnableDisableCommentViewInBulkWithErrorMessage( retrieve("Secret Name"), retrieve("Bulk Operation"), retrieve("Bulk Operation ErrorMessage"), retrieve("Folder Name"));
			//loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
		//	loginpage.Login(retrieve("User Name"), retrieve("Password"), "Yes");
			dashboardpage.CheckBulkOpertionWithErrorMsg(retrieve("Secret Name"), retrieve("Bulk Operation"), retrieve("Bulk Operation ErrorMessage"), retrieve("Folder Name"));
			deleteSecretfromdashboard(retrieve("Secret Name"));
			loginpage.Logout();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if (loginpage.testFailure || dashboardpage.testFailure) {
				 status = true;
			}
			this.testFailure = status;
		}
	}
	
	public void EnableCommentInBulkOperation() {
        try{
			
			loginpage  = new LoginPage(obj);
			dashboardpage = new DashboardPage(obj);
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(retrieve("User Name"), retrieve("Password"), "No");
			CreateBankAccountSecretTemplate(retrieve("Secret Template Type"), retrieve("Secret Name"), retrieve("Account Number"), retrieve("Routing Number"), retrieve("Bank Name"), 
					retrieve("First Address"), retrieve("Second Address"), retrieve("Third Address"), retrieve("Contact Person"), retrieve("Contact Phone"), 
					retrieve("Notes"), retrieve("Folder Path"), retrieve("Folder Name"));
			
		    dashboardpage.performbulkoperationforPreCondition(retrieve("Secret Name"), retrieve("Bulk Operation"), retrieve("Folder Name"), true);	
			
			loginpage.Logout();
			
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(retrieve("User Name"), retrieve("Password"), "yes");
			dashboardpage.ValidateEnableCommendonviewWithError(retrieve("Secret Name"), retrieve("Bulk Operation"), retrieve("Bulk Operation ErrorMessage"), retrieve("Folder Name"));
			deleteSecretfromdashboard(retrieve("Secret Name"));
			loginpage.Logout();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if (loginpage.testFailure || dashboardpage.testFailure) {
				 status = true;
			}
			this.testFailure = status;
		}
	}
	
	
	public void ValidateErrorMessageAssignSecretPolicy() {
        try{
			
			loginpage  = new LoginPage(obj);
			dashboardpage = new DashboardPage(obj);
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(retrieve("User Name"), retrieve("Password"), "Yes");
			
			dashboardpage.ValidateErrorMsgAssignSecretPolicy(retrieve("Error Message"));
			loginpage.Logout();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if (loginpage.testFailure || dashboardpage.testFailure) {
				 status = true;
			}
			this.testFailure = status;
		}
	}
	
	public void ValidateInheritSecretPolicyInAssignSecretPolicy() {
        try{
			
			loginpage  = new LoginPage(obj);
			dashboardpage = new DashboardPage(obj);
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(retrieve("User Name"), retrieve("Password"), "Yes");
			CreateBankAccountSecretTemplate(retrieve("Secret Template Type"), retrieve("Secret Name"), retrieve("Account Number"), retrieve("Routing Number"), retrieve("Bank Name"), 
					retrieve("First Address"), retrieve("Second Address"), retrieve("Third Address"), retrieve("Contact Person"), retrieve("Contact Phone"), 
					retrieve("Notes"), retrieve("Folder Path"), retrieve("Folder Name"));
//			CreateBankAccountSecretTemplate(retrieve("Secret Template Type"), retrieve("Second Secret Name"), retrieve("Account Number"), retrieve("Routing Number"), retrieve("Bank Name"), 
//					retrieve("First Address"), retrieve("Second Address"), retrieve("Third Address"), retrieve("Contact Person"), retrieve("Contact Phone"), 
//					retrieve("Notes"), retrieve("Folder Path"), retrieve("Folder Name"));
			
			
			dashboardpage.AssignSecretPolicyInBulkOperation( retrieve("Secret Name"), retrieve("Bulk Operation"), retrieve("Folder Name"));
			loginpage.Logout();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if (loginpage.testFailure || dashboardpage.testFailure) {
				 status = true;
			}
			this.testFailure = status;
		}
	}
	
	public void DisableCheckoutInBulkOperation() {
        try{
			
			loginpage  = new LoginPage(obj);
			dashboardpage = new DashboardPage(obj);
			
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(retrieve("User Name"), retrieve("Password"), "No");
			CreateBankAccountSecretTemplate(retrieve("Secret Template Type"), retrieve("Secret Name"), retrieve("Account Number"), retrieve("Routing Number"), retrieve("Bank Name"), 
					retrieve("First Address"), retrieve("Second Address"), retrieve("Third Address"), retrieve("Contact Person"), retrieve("Contact Phone"), 
					retrieve("Notes"), retrieve("Folder Path"), retrieve("Folder Name"));
			dashboardpage.performbulkoperationforPreCondition(retrieve("Secret Name"), retrieve("Prereq Bulk Operation"), retrieve("Folder Name"), true);
			loginpage.Logout();
			
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(retrieve("User Name"), retrieve("Password"), "yes");
			dashboardpage.VerifyDisableCheckout( retrieve("Secret Name"), retrieve("Bulk Operation"), retrieve("Bulk Operation ErrorMessage"), 
					retrieve("Prereq Bulk Operation"), retrieve("Folder Name"));
			loginpage.Logout();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if (loginpage.testFailure || dashboardpage.testFailure) {
				 status = true;
			}
			this.testFailure = status;
		}
	}
	
	public void EnableCheckoutInBulkOperation() {
        try{
			
			loginpage  = new LoginPage(obj);
			dashboardpage = new DashboardPage(obj);
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(retrieve("User Name"), retrieve("Password"), "No");
			CreateBankAccountSecretTemplate(retrieve("Secret Template Type"), retrieve("First Secret Name"), retrieve("Account Number"), retrieve("Routing Number"), retrieve("Bank Name"), 
					retrieve("First Address"), retrieve("Second Address"), retrieve("Third Address"), retrieve("Contact Person"), retrieve("Contact Phone"), 
					retrieve("Notes"), retrieve("Folder Path"), retrieve("Folder Name"));
			CreateBankAccountSecretTemplate(retrieve("Secret Template Type"), retrieve("Second Secret Name"), retrieve("Account Number"), retrieve("Routing Number"), retrieve("Bank Name"), 
					retrieve("First Address"), retrieve("Second Address"), retrieve("Third Address"), retrieve("Contact Person"), retrieve("Contact Phone"), 
					retrieve("Notes"), retrieve("Folder Path"), retrieve("Folder Name"));
			loginpage.Logout();
			
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(retrieve("User Name"), retrieve("Password"), "Yes");
			dashboardpage.verifyEnableCheckoutInBulkOperation( retrieve("First Secret Name"), retrieve("Second Secret Name"), 
					retrieve("Bulk Operation"), retrieve("Bulk Operation ErrorMessage"), retrieve("Folder Name"));
			loginpage.Logout();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if (loginpage.testFailure || dashboardpage.testFailure) {
				 status = true;
			}
			this.testFailure = status;
		}
	}
	
	public void EnableAutochangeInBulkOperation() {
        try{
			
			loginpage  = new LoginPage(obj);
			dashboardpage = new DashboardPage(obj);
			adminpage = new AdminPage(obj);
			
			String RemortPasswodChangeParams = retrieve("Remort Password Change Params");
        	String RemortPasswordChangeParamsStatus = retrieve("Remort Password Change Params Status");
        	
			loginpage.LaunchUrl(retrieve("Secret server URL"),"No");
			loginpage.Login(retrieve("User Name"), retrieve("Password"),"NO");
			adminpage.ValidateRemotePasswordParamwithVsts(RemortPasswodChangeParams, RemortPasswordChangeParamsStatus);
			CreateCiscoAcountSecretTemplate(retrieve("Secret Template Type"), retrieve("Secret Name"), retrieve("Host"), retrieve("Cisco UserName"), retrieve("Cisco Password"),  
					retrieve("Note"), retrieve("Folder Path"), retrieve("Folder Name"), retrieve("Inherit Secret Policy"), retrieve("Secret Policy"), retrieve("AutoChange"));
		    loginpage.Logout();
			
		    loginpage.LaunchUrl(retrieve("Secret server URL"),"No");
			loginpage.Login(retrieve("User Name"), retrieve("Password"),"yes");
			dashboardpage.verifyEnableDisableAutochangeInBulkOperation( retrieve("Secret Name"), retrieve("Bulk Operation"), 
					retrieve("Bulk Operation ErrorMessage"), retrieve("Remote Password Change AutoChange"), retrieve("Folder Name"));
			deleteSecretfromdashboard(retrieve("Secret Name"));
			loginpage.Logout();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if (loginpage.testFailure || dashboardpage.testFailure || adminpage.testFailure) {
				 status = true;
			}
			this.testFailure = status;
		}
	}
	
    public void DisableAutochangeInBulkOperation() {
        try{
			
			loginpage  = new LoginPage(obj);
			dashboardpage = new DashboardPage(obj);
			adminpage = new AdminPage(obj);
			
			String RemortPasswodChangeParams = retrieve("Remort Password Change Params");
        	String RemortPasswordChangeParamsStatus = retrieve("Remort Password Change Params Status");
			
			
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(retrieve("User Name"), retrieve("Password"), "No");
			
			boolean RemortPasswordstatus = EnableDisableRemotePasswordChangingParameters(RemortPasswodChangeParams, RemortPasswordChangeParamsStatus);
			CreateCiscoAcountSecretTemplate(retrieve("Secret Template Type"), retrieve("Secret Name"), retrieve("Host"), retrieve("Cisco UserName"), retrieve("Cisco Password"),  
					retrieve("Note"), retrieve("Folder Path"), retrieve("Folder Name"), retrieve("Inherit Secret Policy"), retrieve("Secret Policy"), retrieve("AutoChange"));
		    dashboardpage.validatePrereDisableAutoChange(retrieve("Secret Name"), retrieve("PreReq Bulk Operation"), RemortPasswordstatus, retrieve("Folder Name"));
		    loginpage.Logout();
			
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(retrieve("User Name"), retrieve("Password"), "Yes");
			dashboardpage.verifyEnableDisableAutochangeInBulkOperation( retrieve("Secret Name"), retrieve("Bulk Operation"), retrieve("Bulk Operation ErrorMessage"), retrieve("Remote Password Change AutoChange"), retrieve("Folder Name"));
			deleteSecretfromdashboard(retrieve("Secret Name"));
			loginpage.Logout();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if (loginpage.testFailure || dashboardpage.testFailure || adminpage.testFailure) {
				 status = true;
			}
			this.testFailure = status;
		}
    }
    
    public void verifyHeartbeatOptioninBulk () {
        try{
			
			loginpage  = new LoginPage(obj);
			dashboardpage = new DashboardPage(obj);
			adminpage = new AdminPage(obj);
			
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(retrieve("User Name"), retrieve("Password"), "No");
			adminpage.ValidateRemotePasswordParamwithVsts(retrieve("Remort Password Change Params"), retrieve("Remort Password Change Params Status"));
			loginpage.Logout();
			
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(retrieve("User Name"), retrieve("Password"), "Yes");
		    dashboardpage.VerifyHeartbeatoptionPresent( );
			loginpage.Logout();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if (loginpage.testFailure || dashboardpage.testFailure || adminpage.testFailure) {
				 status = true;
			}
			this.testFailure = status;
		}
    }
    
    public void EnableHeartbeatOptioninBulk () {
        try{
			String Secrettemplate = retrieve("Secret Template Type");
			String SecretName = retrieve("Secret Name");
			String Host = retrieve("Host");
			String CiscoUserName = retrieve("Cisco UserName");
			String CiscoPassword = retrieve("Cisco Password");
			String Note = retrieve("Note");
			String FolderPath = retrieve("Folder Path");
			String FolderName = retrieve("Folder Name");
			String InhertPolicy =  retrieve("Inherit Secret Policy");
			String SecretPolicy = retrieve("Secret Policy");
        	String AutoChange = retrieve("AutoChange");
        	
        	String RemortPasswodChangeParams = retrieve("Remort Password Change Params");
        	String RemortPasswordChangeParamsStatus = retrieve("Remort Password Change Params Status");
        	String Prereq_BulkOperation = retrieve("PreReq Bulk Operation");
        	String BulkOperation = retrieve("Bulk Operation");
        	String BulkOperationErrorMsg= retrieve("Bulk Operation ErrorMessage");
        	
			loginpage  = new LoginPage(obj);
			dashboardpage = new DashboardPage(obj);
			adminpage = new AdminPage(obj);
			
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(retrieve("User Name"), retrieve("Password"),"No");
			 boolean RemotePasswordStatus = EnableDisableRemotePasswordChangingParameters(RemortPasswodChangeParams, RemortPasswordChangeParamsStatus);
			CreateCiscoAcountSecretTemplate(Secrettemplate, SecretName, Host, CiscoUserName, CiscoPassword,  
					Note, FolderPath, FolderName, InhertPolicy, SecretPolicy, AutoChange);
			dashboardpage.validatePrereDisableAutoChange(SecretName, Prereq_BulkOperation,RemotePasswordStatus, FolderName);
			loginpage.Logout();
			
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(retrieve("User Name"), retrieve("Password"),"Yes");
		    dashboardpage.verifyEnableDisableHearthbeat( SecretName, BulkOperation,  BulkOperationErrorMsg, FolderName);
		    deleteSecretfromdashboard(SecretName);
			loginpage.Logout();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if (loginpage.testFailure || dashboardpage.testFailure || adminpage.testFailure) {
				 status = true;
			}
			this.testFailure = status;
		}
    }
    
    public void DisableHeartbeatOptioninBulk () {
        try{
			String Secrettemplate = retrieve("Secret Template Type");
			String SecretName = retrieve("Secret Name");
			String Host = retrieve("Host");
			String CiscoUserName = retrieve("Cisco UserName");
			String CiscoPassword = retrieve("Cisco Password");
			String Note = retrieve("Note");
			String FolderPath = retrieve("Folder Path");
			String FolderName = retrieve("Folder Name");
			String InhertPolicy =  retrieve("Inherit Secret Policy");
			String SecretPolicy = retrieve("Secret Policy");
        	String AutoChange = retrieve("AutoChange");
        	
        	String RemortPasswodChangeParams = retrieve("Remort Password Change Params");
        	String RemortPasswordChangeParamsStatus = retrieve("Remort Password Change Params Status");
        	//String Prereq_BulkOperation = retrieve("PreReq Bulk Operation");
        	String BulkOperation = retrieve("Bulk Operation");
        	String BulkOperationErrorMsg= retrieve("Bulk Operation ErrorMessage");
        	String SecretetemplateParas = retrieve("Secret Template Params");
        	String EnableHeartbeatSecret= retrieve("Enable Heartbeat Secret Template Status");
        	
			loginpage  = new LoginPage(obj);
			dashboardpage = new DashboardPage(obj);
			adminpage = new AdminPage(obj);
			
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(retrieve("User Name"), retrieve("Password"), "No");
			EnableDisableRemotePasswordChangingParameters(RemortPasswodChangeParams, RemortPasswordChangeParamsStatus);
			adminpage.ValidateEnableDisableHBINSecretTemplate(Secrettemplate, SecretetemplateParas, EnableHeartbeatSecret);
			CreateCiscoAcountSecretTemplate(Secrettemplate, SecretName, Host, CiscoUserName, CiscoPassword,  
					Note, FolderPath, FolderName, InhertPolicy, SecretPolicy, AutoChange);
			
			loginpage.Logout();
			
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(retrieve("User Name"), retrieve("Password"), "Yes");
		    dashboardpage.verifyEnableDisableHearthbeat( SecretName, BulkOperation,  BulkOperationErrorMsg, FolderName);
		    deleteSecretfromdashboard(SecretName);
			loginpage.Logout();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if (loginpage.testFailure || dashboardpage.testFailure || adminpage.testFailure) {
				 status = true;
			}
			this.testFailure = status;
		}
    }
    
    public void RunHeartbeatOptioninBulk () {
        try{
			String Secrettemplate = retrieve("Secret Template Type");
			String SecretName = retrieve("Secret Name");
			String Server = retrieve("Server");
			String SqlUserName = retrieve("Sql UserName");
			String SqlPassword = retrieve("Sql Password");
			String Note = retrieve("Note");
			String FolderPath = retrieve("Folder Path");
			String FolderName = retrieve("Folder Name");
			String InhertPolicy =  retrieve("Inherit Secret Policy");
			String SecretPolicy = retrieve("Secret Policy");
        	String AutoChange = retrieve("AutoChange");
        	
        	String RemortPasswodChangeParams = retrieve("Remort Password Change Params");
        	String RemortPasswordChangeParamsStatus = retrieve("Remort Password Change Params Status");
        	//String Prereq_BulkOperation = retrieve("PreReq Bulk Operation");
        	String BulkOperation = retrieve("Bulk Operation");
        	String BulkOperationErrorMsg= retrieve("Bulk Operation ErrorMessage");
        	String SecretetemplateParas = retrieve("Secret Template Params");
        	String EnableHeartbeatSecret= retrieve("Enable Heartbeat Secret Template Status");
        	
			loginpage  = new LoginPage(obj);
			dashboardpage = new DashboardPage(obj);
			adminpage = new AdminPage(obj);
			
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(retrieve("User Name"), retrieve("Password"), "No");
			boolean RemortStatus = EnableDisableRemotePasswordChangingParameters(RemortPasswodChangeParams, RemortPasswordChangeParamsStatus);
			boolean HBSecretTempalteStatus = enableDiasableRemotePasswordandHBInSecretTemplates(Secrettemplate,SecretetemplateParas, EnableHeartbeatSecret);
			CreateSqlSecretTemplate(Secrettemplate, SecretName, Server, SqlUserName, SqlPassword,  
					Note, FolderPath, FolderName, InhertPolicy, SecretPolicy, AutoChange);
			dashboardpage.validatePrereDisableHeartbeat(SecretName, FolderName, RemortStatus, HBSecretTempalteStatus);
	
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(retrieve("User Name"), retrieve("Password"), "yes");
		    dashboardpage.RunHearthbeat( SecretName, BulkOperation, BulkOperationErrorMsg, FolderName);
		   
			loginpage.Logout();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if (loginpage.testFailure || dashboardpage.testFailure || adminpage.testFailure) {
				 status = true;
			}
			this.testFailure = status;
		}
    }
	
    public void  verifyErrorMessageEnableHeartbeatInBulkOperation() {
        try{
			String Secrettemplate = retrieve("Secret Template Type");
			String SecretName = retrieve("Secret Name");
			String Domain = retrieve("Domain");
			String DirectoryUserName = retrieve("Directory UserName");
			String DirectoryPassword = retrieve("Directory Password");
			String Note = retrieve("Note");
			String FolderPath = retrieve("Folder Path");
			String FolderName = retrieve("Folder Name");
			String InhertPolicy =  retrieve("Inherit Secret Policy");
			String SecretPolicy = retrieve("Secret Policy");
        	String AutoChange = retrieve("AutoChange");
        	
        	String RemortPasswodChangeParams = retrieve("Remort Password Change Params");
        	String RemortPasswordChangeParamsStatus = retrieve("Remort Password Change Params Status");
        	
        	String BulkOperation = retrieve("Bulk Operation");
        	String BulkOperationErrorMsg= retrieve("Bulk Operation ErrorMessage");
        	String SecretetemplateParas = retrieve("Secret Template Params");
        	String EnableHeartbeatSecret= retrieve("Enable Heartbeat Secret Template Status");
        	
			loginpage  = new LoginPage(obj);
			dashboardpage = new DashboardPage(obj);
			adminpage = new AdminPage(obj);
			
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(retrieve("User Name"), retrieve("Password"), "No");
			boolean RemortStatus = EnableDisableRemotePasswordChangingParameters(RemortPasswodChangeParams, RemortPasswordChangeParamsStatus);
			boolean HBSecretTempalteStatus = enableDiasableRemotePasswordandHBInSecretTemplates(Secrettemplate, SecretetemplateParas, EnableHeartbeatSecret);
			
			dashboardpage.validatePrereDisableHeartbeatandRemortstatus(RemortStatus, HBSecretTempalteStatus);
			
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(retrieve("User Name"), retrieve("Password"), "Yes");
		    dashboardpage.CheckBulkOpertionWithEnableHeartbeatErrorMsg( Secrettemplate, SecretName,  Domain, DirectoryUserName, DirectoryPassword, FolderName, FolderPath
		    		, BulkOperation, BulkOperationErrorMsg); 
		    
		    deleteSecretfromdashboard(SecretName);
		   
			loginpage.Logout();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if (loginpage.testFailure || dashboardpage.testFailure || adminpage.testFailure) {
				 status = true;
			}
			this.testFailure = status;
		}
    }
   
    
    public void  verifyHBInBulkOperationWhenDisableHBInSecretTemplate() {
        try{
			String Secrettemplate = retrieve("Secret Template Type");
			String FirstSecretName = retrieve("First Secret Name");
			String SecondSecretName = retrieve("Second Secret Name");
			String Domain = retrieve("Domain");
			String DirectoryUserName = retrieve("Directory UserName");
			String DirectoryPassword = retrieve("Directory Password");
			String Note = retrieve("Note");
			String FolderPath = retrieve("Folder Path");
			String FolderName = retrieve("Folder Name");
			String InhertPolicy =  retrieve("Inherit Secret Policy");
			String SecretPolicy = retrieve("Secret Policy");
        	String AutoChange = retrieve("AutoChange");
        	
        	String RemortPasswodChangeParams = retrieve("Remort Password Change Params");
        	String RemortPasswordChangeParamsStatus = retrieve("Remort Password Change Params Status");
        	//String Prereq_BulkOperation = retrieve("PreReq Bulk Operation");
        	String FirstBulkOpertaion = retrieve("First Bulk Operation");
        	String SecondBulkOperation = retrieve("Second Bulk Operation");
        	String FirstSecretServerErrorMsg = retrieve("First Secret Server ErrorMessage");
        	String SecondSecretServerErrorMsg = retrieve("Second Secret Server ErrorMessage"); 
        	String EnableHeartbeatSecretStatus = retrieve("Enable Heartbeat Secret Template Status");
        	
			loginpage  = new LoginPage(obj);
			dashboardpage = new DashboardPage(obj);
			adminpage = new AdminPage(obj);
			
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(retrieve("User Name"), retrieve("Password"), "Yes");
			
			EnableDisableRemotePasswordChangingParameters(RemortPasswodChangeParams, RemortPasswordChangeParamsStatus);
			
			enableDiasableRemotePasswordandHBInSecretTemplates(Secrettemplate, "Enable Heartbeat","Yes");
		
			CreateSqlSecretTemplate(Secrettemplate, FirstSecretName, Domain, DirectoryUserName, DirectoryPassword,  
					Note, FolderPath, FolderName, InhertPolicy, SecretPolicy, AutoChange);
			
			CreateSqlSecretTemplate(Secrettemplate, SecondSecretName, Domain, DirectoryUserName, DirectoryPassword,  
					Note, FolderPath, FolderName, InhertPolicy, SecretPolicy, AutoChange);
			
		    dashboardpage.verifyHBInBulkoperationWhenHBIsDisableInTemplate(Secrettemplate, FirstSecretName, SecondSecretName, FirstBulkOpertaion,
		    		SecondBulkOperation, EnableHeartbeatSecretStatus, FirstSecretServerErrorMsg, SecondSecretServerErrorMsg, FolderName);
		   
		    deleteSecretfromdashboard(FirstSecretName+"##"+SecondSecretName);
			loginpage.Logout();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if (loginpage.testFailure || dashboardpage.testFailure || adminpage.testFailure) {
				 status = true;
			}
			this.testFailure = status;
		}
    }
    
    public void DeleteCurrentSession() {
    	try{
			loginpage  = new LoginPage(obj);
			profilepage = new ProfilePage(obj);
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(retrieve("User Name"), retrieve("Password"), "Yes");
			profilepage.verifydeleteCurrentSession(retrieve("Session Page Fields"), retrieve("Session Page Buttons"), retrieve("IP Address"));
			//loginpage.Logout();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if (loginpage.testFailure || profilepage.testFailure) {
				 status = true;
			}
			this.testFailure = status;
		}
    }
    
    public void EnableCommentonViewInBulkWithEditPermission () {
    	try{	
			loginpage  = new LoginPage(obj);
			configurationpage = new ConfigurationPage(obj);
			userspage  = new UsersPage(obj);
			folderspage = new FoldersPage(obj);
			dashboardpage = new DashboardPage(obj);
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(retrieve("User Name"), retrieve("Password"), "No");
			
			boolean Default_Status = configurationpage.SetDefaultSecretPermissions(retrieve("Default Secret Permissions"));
			
     		userspage.createNewUsers(retrieve("New Users Name"), retrieve("User Display Name"), retrieve("Email Address"), retrieve("Users Password"), 
     				retrieve("Users Confirm Password"), retrieve("Two Factor"), retrieve("User Enable Field"), retrieve("Locked Out"));
	
     		
     		boolean Folder_Status = folderspage.createNewFolder(retrieve("Folder Name"), retrieve("Folder Icon"), retrieve("Secret Policy"), retrieve("Admin Permissions Name"), 
     				retrieve("Admin Folder Permissions type"), retrieve("Admin Secret Permissions "), retrieve("Admin Overview"), retrieve("Add Group/User"), 
     				retrieve("Users Permissions Name"), retrieve("Users Folder Permissions type"), retrieve("User Secret Permissions"), retrieve("User Overview"));
			
     		CreateBankAccountSecretTemplate(retrieve("Secret Template Type"), retrieve("Secret Name"), retrieve("Account Number"), retrieve("Routing Number"), retrieve("Bank Name"), 
					retrieve("First Address"), retrieve("Second Address"), retrieve("Third Address"), retrieve("Contact Person"), retrieve("Contact Phone"), 
					retrieve("Notes"), retrieve("Folder Path"), retrieve("Folder Name"));
     		
     		
     		dashboardpage.validateFolderDefaultSecretPreCondition(retrieve("Secret Name"), retrieve("Folder Name"), Default_Status, Folder_Status);
     		loginpage.Logout();
     		
     		loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(retrieve("User Name"), retrieve("Password"), "yes");
     		dashboardpage.CheckBulkOpertionWithfolderErrorMsg(retrieve("Secret Name"), retrieve("Bulk Operation"), retrieve("Bulk Operation ErrorMessage"), retrieve("Folder Name"));
			
     		folderspage.deleteFolder(retrieve("Folder Name"));
     		
     		deleteSecretfromdashboard(retrieve("Secret Name"));
     		
     		
     		loginpage.Logout();
     		
//     		loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
//			loginpage.Login(retrieve("New Users Name"), retrieve("Users Password"));
//            deleteSecretfromdashboard(retrieve("Secret Name"));
//            loginpage.Logout();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if (loginpage.testFailure || configurationpage.testFailure
					|| userspage.testFailure || folderspage.testFailure || dashboardpage.testFailure) {
				 status = true;
			}
			this.testFailure = status;
		}
    }
    
    public void AddShareOptionInBulkWithViewFolderPermission () {
    	try{	
			loginpage  = new LoginPage(obj);
			configurationpage = new ConfigurationPage(obj);
			userspage  = new UsersPage(obj);
			folderspage = new FoldersPage(obj);
			dashboardpage = new DashboardPage(obj);
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(retrieve("User Name"), retrieve("Password"), "No");
			
			boolean Default_Status = configurationpage.SetDefaultSecretPermissions(retrieve("Default Secret Permissions"));
			
     		userspage.createNewUsers(retrieve("New Users Name"), retrieve("User Display Name"), retrieve("Email Address"), retrieve("Users Password"), 
     				retrieve("Users Confirm Password"), retrieve("Two Factor"), retrieve("User Enable Field"), retrieve("Locked Out"));
	
     		
     		boolean Folder_Status = folderspage.createNewFolder(retrieve("Folder Name"), retrieve("Folder Icon"), retrieve("Secret Policy"), retrieve("Admin Permissions Name"), 
     				retrieve("Admin Folder Permissions type"), retrieve("Admin Secret Permissions "), retrieve("Admin Overview"), retrieve("Add Group/User"), 
     				retrieve("Users Permissions Name"), retrieve("Users Folder Permissions type"), retrieve("User Secret Permissions"), retrieve("User Overview"));
			
     		CreateBankAccountSecretTemplate(retrieve("Secret Template Type"), retrieve("Secret Name"), retrieve("Account Number"), retrieve("Routing Number"), retrieve("Bank Name"), 
					retrieve("First Address"), retrieve("Second Address"), retrieve("Third Address"), retrieve("Contact Person"), retrieve("Contact Phone"), 
					retrieve("Notes"), retrieve("Folder Path"), retrieve("Folder Name"));
     		dashboardpage.validateFolderDefaultSecretPreCondition(retrieve("Secret Name"), retrieve("Folder Name"), Default_Status, Folder_Status);
     		loginpage.Logout();
     		
     		loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(retrieve("User Name"), retrieve("Password"), "yes");
     		
     		
     		dashboardpage.performAddShareInBulkOperation( retrieve("Secret Name"), retrieve("Bulk Operation"), retrieve("Bulk Operation ErrorMessage"), retrieve("Share User/Group"), retrieve("Folder Name"));
			
     		folderspage.deleteFolder(retrieve("Folder Name"));
     		
     		loginpage.Logout();
     		
     		loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(retrieve("New Users Name"), retrieve("Users Password"), "No");
            deleteSecretfromNewuser (retrieve("Secret Name"), retrieve("Users Password"));
            loginpage.Logout();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if (loginpage.testFailure || configurationpage.testFailure
					|| userspage.testFailure || folderspage.testFailure || dashboardpage.testFailure) {
				 status = true;
			}
			this.testFailure = status;
		}
    }
    
    
    public void AddShareOptionInBulkWithListFolderPermission () {
    	try{	
			loginpage  = new LoginPage(obj);
			configurationpage = new ConfigurationPage(obj);
			userspage  = new UsersPage(obj);
			folderspage = new FoldersPage(obj);
			dashboardpage = new DashboardPage(obj);
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(retrieve("User Name"), retrieve("Password"), "No");
			
			boolean Default_Status = configurationpage.SetDefaultSecretPermissions(retrieve("Default Secret Permissions"));
			
     		userspage.createNewUsers(retrieve("New Users Name"), retrieve("User Display Name"), retrieve("Email Address"), retrieve("Users Password"), 
     				retrieve("Users Confirm Password"), retrieve("Two Factor"), retrieve("User Enable Field"), retrieve("Locked Out"));
	
     		
     		boolean Folder_Status = folderspage.createNewFolder(retrieve("Folder Name"), retrieve("Folder Icon"), retrieve("Secret Policy"), retrieve("Admin Permissions Name"), 
     				retrieve("Admin Folder Permissions type"), retrieve("Admin Secret Permissions "), retrieve("Admin Overview"), retrieve("Add Group/User"), 
     				retrieve("Users Permissions Name"), retrieve("Users Folder Permissions type"), retrieve("User Secret Permissions"), retrieve("User Overview"));
			
     		CreateWindowAccountSecretTemplateWithListPermision(retrieve("Secret Template Type"), retrieve("Secret Name"), retrieve("Machine"), retrieve("Windows UserName"), retrieve("Windows Password"),  
     				retrieve("Note"), retrieve("Folder Path"), retrieve("Folder Name"), retrieve("Inherit Secret Policy"), retrieve("Secret Policy"), retrieve("AutoChange"));
     		
     		dashboardpage.validateFolderDefaultSecretPreCondition(retrieve("Secret Name"), retrieve("Folder Name"), Default_Status, Folder_Status);
     		loginpage.Logout();
     		
     		loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(retrieve("User Name"), retrieve("Password"), "yes");
     		
     		
     		dashboardpage.performAddShareInBulkOperation( retrieve("Secret Name"), retrieve("Bulk Operation"), retrieve("Bulk Operation ErrorMessage"), retrieve("Share User/Group"), retrieve("Folder Name"));
			
     		folderspage.deleteFolder(retrieve("Folder Name"));
     		
     		loginpage.Logout();
     		
     		loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(retrieve("New Users Name"), retrieve("Users Password"), "No");
            deleteSecretfromNewuser (retrieve("Secret Name"), retrieve("Users Password"));
            loginpage.Logout();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if (loginpage.testFailure || configurationpage.testFailure
					|| userspage.testFailure || folderspage.testFailure || dashboardpage.testFailure) {
				 status = true;
			}
			this.testFailure = status;
		}
    }

    
    public void HideLauncherInBulkWithListFolderPermission () {
    	try{	
			loginpage  = new LoginPage(obj);
			configurationpage = new ConfigurationPage(obj);
			userspage  = new UsersPage(obj);
			folderspage = new FoldersPage(obj);
			dashboardpage = new DashboardPage(obj);
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(retrieve("User Name"), retrieve("Password"), "No");
			
			boolean Default_Status = configurationpage.SetDefaultSecretPermissions(retrieve("Default Secret Permissions"));
			
     		userspage.createNewUsers(retrieve("New Users Name"), retrieve("User Display Name"), retrieve("Email Address"), retrieve("Users Password"), 
     				retrieve("Users Confirm Password"), retrieve("Two Factor"), retrieve("User Enable Field"), retrieve("Locked Out"));
	
     		
     		boolean Folder_Status = folderspage.createNewFolder(retrieve("Folder Name"), retrieve("Folder Icon"), retrieve("Secret Policy"), retrieve("Admin Permissions Name"), 
     				retrieve("Admin Folder Permissions type"), retrieve("Admin Secret Permissions "), retrieve("Admin Overview"), retrieve("Add Group/User"), 
     				retrieve("Users Permissions Name"), retrieve("Users Folder Permissions type"), retrieve("User Secret Permissions"), retrieve("User Overview"));
			
     		CreateWindowAccountSecretTemplateWithListPermision(retrieve("Secret Template Type"), retrieve("Secret Name"), retrieve("Machine"), retrieve("Windows UserName"), retrieve("Windows Password"),  
     				retrieve("Note"), retrieve("Folder Path"), retrieve("Folder Name"), retrieve("Inherit Secret Policy"), retrieve("Secret Policy"), retrieve("AutoChange"));
     		dashboardpage.validateFolderDefaultSecretPreCondition(retrieve("Secret Name"), retrieve("Folder Name"), Default_Status, Folder_Status);
     		loginpage.Logout();
     		
     		loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(retrieve("User Name"), retrieve("Password"), "yes");
     		
     	
			dashboardpage.CheckBulkOpertionWithfolderErrorMsg(retrieve("Secret Name"), retrieve("Bulk Operation"), retrieve("Bulk Operation ErrorMessage"), retrieve("Folder Name"));
					
     		folderspage.deleteFolder(retrieve("Folder Name"));
     		
     		loginpage.Logout();
     		
     		loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(retrieve("New Users Name"), retrieve("Users Password"), "No");
            deleteSecretfromNewuser(retrieve("Secret Name"), retrieve("Users Password"));
            loginpage.Logout();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if (loginpage.testFailure || configurationpage.testFailure
					|| userspage.testFailure || folderspage.testFailure || dashboardpage.testFailure) {
				 status = true;
			}
			this.testFailure = status;
		}
    }
    
    public void EnableCommentonViewInBulkWithListPermission () {
    	try{	
			loginpage  = new LoginPage(obj);
			configurationpage = new ConfigurationPage(obj);
			userspage  = new UsersPage(obj);
			folderspage = new FoldersPage(obj);
			dashboardpage = new DashboardPage(obj);
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(retrieve("User Name"), retrieve("Password"), "No");
			
			boolean Default_Status = configurationpage.SetDefaultSecretPermissions(retrieve("Default Secret Permissions"));
			
     		userspage.createNewUsers(retrieve("New Users Name"), retrieve("User Display Name"), retrieve("Email Address"), retrieve("Users Password"), 
     				retrieve("Users Confirm Password"), retrieve("Two Factor"), retrieve("User Enable Field"), retrieve("Locked Out"));
	
     		
     		boolean Folder_Status = folderspage.createNewFolder(retrieve("Folder Name"), retrieve("Folder Icon"), retrieve("Secret Policy"), retrieve("Admin Permissions Name"), 
     				retrieve("Admin Folder Permissions type"), retrieve("Admin Secret Permissions "), retrieve("Admin Overview"), retrieve("Add Group/User"), 
     				retrieve("Users Permissions Name"), retrieve("Users Folder Permissions type"), retrieve("User Secret Permissions"), retrieve("User Overview"));
		
     		CreateBankAccountSecretTemplate(retrieve("Secret Template Type"), retrieve("Secret Name"), retrieve("Account Number"), retrieve("Routing Number"), retrieve("Bank Name"), 
					retrieve("First Address"), retrieve("Second Address"), retrieve("Third Address"), retrieve("Contact Person"), retrieve("Contact Phone"), 
					retrieve("Notes"), retrieve("Folder Path"), retrieve("Folder Name"));
		
     		dashboardpage.validateFolderDefaultSecretPreCondition(retrieve("Secret Name"), retrieve("Folder Name"), Default_Status, Folder_Status);
     		loginpage.Logout();
     		
     		
     		
     		loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(retrieve("User Name"), retrieve("Password"), "yes");
     		
			dashboardpage.CheckBulkOpertionWithfolderErrorMsg(retrieve("Secret Name"), retrieve("Bulk Operation"), retrieve("Bulk Operation ErrorMessage"), retrieve("Folder Name"));
					
			deleteSecretfromdashboard(retrieve("Secret Name"));
			
     		folderspage.deleteFolder(retrieve("Folder Name"));
     		
     		loginpage.Logout();
     	
     		
//     		loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
//			loginpage.Login(retrieve("New Users Name"), retrieve("Users Password"));
//            deleteSecretfromdashboard(retrieve("Secret Name"));
//            loginpage.Logout();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if (loginpage.testFailure || configurationpage.testFailure
					|| userspage.testFailure || folderspage.testFailure || dashboardpage.testFailure) {
				 status = true;
			}
			this.testFailure = status;
		}
    }
    
    public void AddShareBulkWithOnlyCreatorHasPermissions () {
    	try{	
			loginpage  = new LoginPage(obj);
			configurationpage = new ConfigurationPage(obj);
			userspage  = new UsersPage(obj);
			folderspage = new FoldersPage(obj);
			dashboardpage = new DashboardPage(obj);
			
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(retrieve("User Name"), retrieve("Password"), "No");
			
			boolean Default_Status = configurationpage.SetDefaultSecretPermissions(retrieve("Default Secret Permissions"));
			
     		userspage.createNewUsers(retrieve("New Users Name"), retrieve("User Display Name"), retrieve("Email Address"), retrieve("Users Password"), 
     				retrieve("Users Confirm Password"), retrieve("Two Factor"), retrieve("User Enable Field"), retrieve("Locked Out"));
	
     		
     		boolean Folder_Status = folderspage.createNewFolder(retrieve("Folder Name"), retrieve("Folder Icon"), retrieve("Secret Policy"), retrieve("Admin Permissions Name"), 
     				retrieve("Admin Folder Permissions type"), retrieve("Admin Secret Permissions "), retrieve("Admin Overview"), retrieve("Add Group/User"), 
     				retrieve("Users Permissions Name"), retrieve("Users Folder Permissions type"), retrieve("User Secret Permissions"), retrieve("User Overview"));
			
     		CreateBankAccountSecretTemplate(retrieve("Secret Template Type"), retrieve("Secret Name"), retrieve("Account Number"), retrieve("Routing Number"), retrieve("Bank Name"), 
					retrieve("First Address"), retrieve("Second Address"), retrieve("Third Address"), retrieve("Contact Person"), retrieve("Contact Phone"), 
					retrieve("Notes"), retrieve("Folder Path"), retrieve("Folder Name"));
     		dashboardpage.validateFolderDefaultSecretPreCondition(retrieve("Secret Name"), retrieve("Folder Name"), Default_Status, Folder_Status);
     		loginpage.Logout();
     		
     		loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(retrieve("User Name"), retrieve("Password"), "yes");
     		
     		
     		dashboardpage.performAddShareInBulkOperation( retrieve("Secret Name"), retrieve("Bulk Operation"), retrieve("Bulk Operation ErrorMessage"), retrieve("Share User/Group"), retrieve("Folder Name"));
			
     		folderspage.deleteFolder(retrieve("Folder Name"));
     		deleteSecretfromdashboard(retrieve("Secret Name"));
     		loginpage.Logout();
     		
//     		loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
//			loginpage.Login(retrieve("New Users Name"), retrieve("Users Password"));
//            deleteSecretfromdashboard(retrieve("Secret Name"));
//            loginpage.Logout();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if (loginpage.testFailure || configurationpage.testFailure
					|| userspage.testFailure || folderspage.testFailure || dashboardpage.testFailure) {
				 status = true;
			}
			this.testFailure = status;
		}
    }
    
    public void HeathBeatWithDifferentFolderPermission() {
    	try{	
    		
    		String SecretUrl = retrieve("Secret server URL");
    		String Username = retrieve("User Name");
    		String Password = retrieve("Password");
    		
    		String DefaultSecretPermission = retrieve("Default Secret Permissions");
    		
    		String CreateNewUserSname = retrieve("New Users Name");
    		String UsersDisplayName = retrieve("User Display Name");
    		String EmailAddress = retrieve("Email Address");
    		String UsersPassword = retrieve("Users Password");
    		String ConfirmPassword = retrieve("Users Confirm Password");
    		String TwoFactory= retrieve("Two Factor");
    		String EnableField = retrieve("User Enable Field");
    		String LockedOut = retrieve("Locked Out");
    		
            String FolderIcon = retrieve("Folder Icon");
            String FolderSecretPolicy = retrieve("Folder Secret Policy");
    		String AdminPermissionName = retrieve("Admin Permissions Name");
    		String AdminFolderPermissiontype = retrieve("Admin Folder Permissions type");
    		String AdminSecretPermission = retrieve("Admin Secret Permissions ") ;
    		String AdminOverview = retrieve("Admin Overview");
    		String AddGroupUser = retrieve("Add Group/User");
    		String UserPermissionName = retrieve("Users Permissions Name");
    		String UserFolderPermissionType = retrieve("Users Folder Permissions type");
    		String UserSecretPermission = retrieve("User Secret Permissions");
    		String UserOverview = retrieve("User Overview");
    		
    		
    		String Secrettemplate = retrieve("Secret Template Type");
			String SecretName = retrieve("Secret Name");
			String Domain = retrieve("Domain");
			String DirectoryUserName = retrieve("Directory UserName");
			String DirectoryPassword = retrieve("Directory Password");
			String Note = retrieve("Note");
			String FolderPath = retrieve("Folder Path");
			String FolderName = retrieve("Folder Name");
			String InhertPolicy =  retrieve("Inherit Secret Policy");
			String SecretPolicy = retrieve("Secret Policy");
        	String AutoChange = retrieve("AutoChange");
        	
        	String RemortPasswodChangeParams = retrieve("Remort Password Change Params");
        	String RemortPasswordChangeParamsStatus = retrieve("Remort Password Change Params Status");
        	
        	String BulkOperation = retrieve("Bulk Operation");
        	String BulkOperationErrorMsg= retrieve("Bulk Operation ErrorMessage");
        	String SecretetemplateParas = retrieve("Secret Template Params");
        	String EnableHeartbeatSecret= retrieve("Enable Heartbeat Secret Template Status");
        	   	
			loginpage  = new LoginPage(obj);
			configurationpage = new ConfigurationPage(obj);
			userspage  = new UsersPage(obj);
			folderspage = new FoldersPage(obj);
			dashboardpage = new DashboardPage(obj);
			
			loginpage.LaunchUrl(SecretUrl, "No");
			loginpage.Login(Username, Password, "NO");
			
			boolean Default_Status = configurationpage.SetDefaultSecretPermissions(DefaultSecretPermission);
			
     		userspage.createNewUsers(CreateNewUserSname, UsersDisplayName, EmailAddress, UsersPassword, 
     				ConfirmPassword, TwoFactory, EnableField, LockedOut);
	
     		
     		boolean Folder_Status = folderspage.createNewFolder(FolderName, FolderIcon, FolderSecretPolicy, AdminPermissionName, 
     				AdminFolderPermissiontype, AdminSecretPermission, AdminOverview, AddGroupUser, 
     				UserPermissionName, UserFolderPermissionType, UserSecretPermission, UserOverview);
			
     		EnableDisableRemotePasswordChangingParameters(RemortPasswodChangeParams, RemortPasswordChangeParamsStatus);
			enableDiasableRemotePasswordandHBInSecretTemplates(Secrettemplate,SecretetemplateParas, EnableHeartbeatSecret);
			
			CreateSqlSecretTemplate(Secrettemplate, SecretName, Domain, DirectoryUserName, DirectoryPassword,  
					Note, FolderPath, FolderName, InhertPolicy, SecretPolicy, AutoChange);
			
			dashboardpage.validateFolderDefaultSecretPreCondition(retrieve("Secret Name"), FolderName, Default_Status, Folder_Status);
     		loginpage.Logout();
			
     		loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(retrieve("User Name"), retrieve("Password"), "yes");
     		
			dashboardpage.CheckBulkOpertionWithfolderErrorMsg(SecretName, BulkOperation, BulkOperationErrorMsg, FolderName);
				
     		deleteSecretfromdashboard(retrieve("Secret Name"));
     		folderspage.deleteFolder(retrieve("Folder Name"));
     		
     		loginpage.Logout();
     		
     		/*loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(retrieve("New Users Name"), retrieve("Users Password"));
            deleteSecretfromdashboard(retrieve("Secret Name"));
            loginpage.Logout();*/
			
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if (loginpage.testFailure || configurationpage.testFailure
					|| userspage.testFailure || folderspage.testFailure || dashboardpage.testFailure) {
				 status = true;
			}
			this.testFailure = status;
		}
    }
    
//    public void EnableBeatWithEditFolderPermission() {
//    	try{	
//    		
//    		String SecretUrl = retrieve("Secret server URL");
//    		String Username = retrieve("User Name");
//    		String Password = retrieve("Password");
//    		
//    		String DefaultSecretPermission = retrieve("Default Secret Permissions");
//    		
//    		String CreateNewUserSname = retrieve("New Users Name");
//    		String UsersDisplayName = retrieve("User Display Name");
//    		String EmailAddress = retrieve("Email Address");
//    		String UsersPassword = retrieve("Users Password");
//    		String ConfirmPassword = retrieve("Users Confirm Password");
//    		String TwoFactory= retrieve("Two Factor");
//    		String EnableField = retrieve("User Enable Field");
//    		String LockedOut = retrieve("Locked Out");
//    		
//            String FolderIcon = retrieve("Folder Icon");
//            String FolderSecretPolicy = retrieve("Folder Secret Policy");
//    		String AdminPermissionName = retrieve("Admin Permissions Name");
//    		String AdminFolderPermissiontype = retrieve("Admin Folder Permissions type");
//    		String AdminSecretPermission = retrieve("Admin Secret Permissions ") ;
//    		String AdminOverview = retrieve("Admin Overview");
//    		String AddGroupUser = retrieve("Add Group/User");
//    		String UserPermissionName = retrieve("Users Permissions Name");
//    		String UserFolderPermissionType = retrieve("Users Folder Permissions type");
//    		String UserSecretPermission = retrieve("User Secret Permissions");
//    		String UserOverview = retrieve("User Overview");
//    		
//    		
//    		String Secrettemplate = retrieve("Secret Template Type");
//			String SecretName = retrieve("Secret Name");
//			String Domain = retrieve("Domain");
//			String DirectoryUserName = retrieve("Directory UserName");
//			String DirectoryPassword = retrieve("Directory Password");
//			String Note = retrieve("Note");
//			String FolderPath = retrieve("Folder Path");
//			String FolderName = retrieve("Folder Name");
//			String InhertPolicy =  retrieve("Inherit Secret Policy");
//			String SecretPolicy = retrieve("Secret Policy");
//        	String AutoChange = retrieve("AutoChange");
//        	
//        	String RemortPasswodChangeParams = retrieve("Remort Password Change Params");
//        	String RemortPasswordChangeParamsStatus = retrieve("Remort Password Change Params Status");
//        	
//        	String BulkOperation = retrieve("Bulk Operation");
//        	String BulkOperationErrorMsg= retrieve("Bulk Operation ErrorMessage");
//        	String SecretetemplateParas = retrieve("Secret Template Params");
//        	String EnableHeartbeatSecret= retrieve("Enable Heartbeat Secret Template Status");
//        	   	
//			loginpage  = new LoginPage(obj);
//			configurationpage = new ConfigurationPage(obj);
//			userspage  = new UsersPage(obj);
//			folderspage = new FoldersPage(obj);
//			dashboardpage = new DashboardPage(obj);
//			loginpage.LaunchUrl(SecretUrl);
//			loginpage.Login(Username, Password);
//			
//			configurationpage.SetDefaultSecretPermissions(DefaultSecretPermission);
//			
//     		userspage.createNewUsers(CreateNewUserSname, UsersDisplayName, EmailAddress, UsersPassword, 
//     				ConfirmPassword, TwoFactory, EnableField, LockedOut);
//	
//     		
//     		folderspage.createNewFolder(FolderName, FolderIcon, FolderSecretPolicy, AdminPermissionName, 
//     				AdminFolderPermissiontype, AdminSecretPermission, AdminOverview, AddGroupUser, 
//     				UserPermissionName, UserFolderPermissionType, UserSecretPermission, UserOverview);
//			
//     		
//     		
//     		EnableDisableRemotePasswordChangingParameters(RemortPasswodChangeParams, RemortPasswordChangeParamsStatus);
//			enableDiasableRemotePasswordandHBInSecretTemplates(Secrettemplate,SecretetemplateParas, EnableHeartbeatSecret);
//			CreateSqlSecretTemplate(Secrettemplate, SecretName, Domain, DirectoryUserName, DirectoryPassword,  
//					Note, FolderPath, FolderName, InhertPolicy, SecretPolicy, AutoChange);
//			
//     		dashboardpage.CheckBulkOpertionWithErrorMsg(SecretName, BulkOperation, BulkOperationErrorMsg, FolderName);
//				
//     		deleteSecretfromdashboard(retrieve("Secret Name"));
//     		folderspage.deleteFolder(retrieve("Folder Name"));
//     		
//     		loginpage.Logout();
//     		
//     		/*loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
//			loginpage.Login(retrieve("New Users Name"), retrieve("Users Password"));
//            deleteSecretfromdashboard(retrieve("Secret Name"));
//            loginpage.Logout();*/
//			
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		finally{
//			if (loginpage.testFailure || configurationpage.testFailure
//					|| userspage.testFailure || folderspage.testFailure || dashboardpage.testFailure) {
//				 status = true;
//			}
//			this.testFailure = status;
//		}
//    }
    
    public void  VerifySecretSearchInBasicLink() {
        try{
        	String SecretServerURl = retrieve("Secret server URL");
        	String UserName = retrieve("User Name");
        	String Password = retrieve("Password");
        	
			String Secrettemplate = retrieve("Secret Template Type");
			String SecretName = retrieve("Secret Name");
			String Domain = retrieve("Domain");
			String DirectoryUserName = retrieve("Directory UserName");
			String DirectoryPassword = retrieve("Directory Password");
			String Note = retrieve("Note");
			String FolderPath = retrieve("Folder Path");
			String FolderName = retrieve("Folder Name");
			String InhertPolicy =  retrieve("Inherit Secret Policy");
			String SecretPolicy = retrieve("Secret Policy");
        	String AutoChange = retrieve("AutoChange");
        
        	
			loginpage  = new LoginPage(obj);
			dashboardpage = new DashboardPage(obj);
			adminpage = new AdminPage(obj);
			basicpage = new BasicPage(obj);
			
			loginpage.LaunchUrl(SecretServerURl, "No");
			loginpage.Login(UserName, Password, "Yes");
			
			CreateSqlSecretTemplate(Secrettemplate, SecretName, Domain, DirectoryUserName, DirectoryPassword,  
					Note, FolderPath, FolderName, InhertPolicy, SecretPolicy, AutoChange);

		    basicpage.checkBasicSearch(SecretName);
		    
		    deleteSecretfromdashboard(SecretName);
		   
			loginpage.Logout();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if (loginpage.testFailure || dashboardpage.testFailure || basicpage.testFailure) {
				 status = true;
			}
			this.testFailure = status;
		}
    }
    
    
    public void verifyCreateSecretInBasicPage () {
    	try{	
    		String SecretServerURl = retrieve("Secret server URL");
        	String UserName = retrieve("User Name");
        	String Password = retrieve("Password");
        	
			loginpage  = new LoginPage(obj);
			basicpage = new BasicPage(obj);
			
			loginpage.LaunchUrl(SecretServerURl, "No");
			loginpage.Login(UserName, Password,"yes");
		    
			basicpage.CheckCreateSecreteInBasicLink(retrieve("Secret Template Type"), retrieve("Secret Name"), retrieve("Account Number"), retrieve("Routing Number"), retrieve("Bank Name"), 
					retrieve("First Address"), retrieve("Second Address"), retrieve("Third Address"), retrieve("Contact Person"), retrieve("Contact Phone"), 
					retrieve("Notes"), retrieve("Folder Path"), retrieve("Folder Name"));
     		
     		loginpage.Logout();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if (loginpage.testFailure || basicpage.testFailure) {
				 status = true;
			}
			this.testFailure = status;
		}
    }
    
    
    //sathish
    
    public void dashboard_MyProfile()
	{
		try {
			loginpage = new LoginPage(obj);
			profilepage = new ProfilePage(obj);
			String MyProfile_labels = retrieve("My profile labels");

			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(retrieve("User name"), retrieve("Password"), "Yes");

			profilepage.profileValidationFields(MyProfile_labels);
			loginpage.Logout();
		}
		catch(Exception ex)
		{
			System.out.println("Exception in dashboard_MyProfile "+ex);
			ex.printStackTrace();
		}finally{
			if (loginpage.testFailure || profilepage.testFailure) {
				status = true;
			}
			this.testFailure = status;
		}
	}

	public void dashboard_DragAndDrop()
	{
		try {
			loginpage = new LoginPage(obj);
			dashboardpage = new DashboardPage(obj);
			String username = retrieve("User name");
			String password = retrieve("Password");
			String Content_items = retrieve("Dashboard labels");
			String url = retrieve("Secret server URL");

			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(username, password, "No");
			
			dashboardpage.dragNDropPrecondition();
			loginpage.Logout();
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(username, password, "Yes");
			
			DeleteContentInDashBoard();
			
			dashboardpage.performDashboardActions(Content_items);
			loginpage.Logout();
		}
		catch(Exception ex)
		{
			System.out.println("Exception in dashboard_DragAndDrop "+ex);
			ex.printStackTrace();
		}finally{
			if (loginpage.testFailure || dashboardpage.testFailure) {
				status = true;
			}
			this.testFailure = status;
		}

	}

	public void UpdatePassword() 
	{
		try {
			loginpage = new LoginPage(obj);
			profilepage = new ProfilePage(obj);
			String username = retrieve("User name");
			String password = retrieve("Password");
			String updated_pwd = retrieve("New Password");
			String url = retrieve("Secret server URL");
			String ChangePasswordElements = retrieve("Password page Elements");
			String current_pwd= password;
			String Buttons = retrieve("Buttons");
			
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(username, password, "Yes");
			profilepage.changePasswordwithVSTS(current_pwd, updated_pwd,ChangePasswordElements, Buttons);
			loginpage.Logout();
			clickHereToLoginLink();
			loginpage.Login(username, updated_pwd, "NO");
			profilepage.changePassword(updated_pwd, password,ChangePasswordElements, Buttons);
			loginpage.Logout();
		}catch(Exception ex)
		{
			System.out.println("Exception in UpdatePassword "+ex);
			ex.printStackTrace();
		}finally{
			if (loginpage.testFailure || profilepage.testFailure) {
				status = true;
			}
			this.testFailure = status;
		}
	}

	public void commentOnView()
	{
		try {
			loginpage = new LoginPage(obj);
			dashboardpage = new DashboardPage(obj);
			
			String username = retrieve("User name");
			String password = retrieve("Password");
			String url = retrieve("Secret server URL");
			String msg_validation = retrieve("Error Message");
			
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(username, password,"Yes");
			
			dashboardpage.commentOnView_Validation(msg_validation);
			loginpage.Logout();
			
			
		}catch(Exception ex)
		{
			System.out.println("Exception in commentOnView "+ex);
			ex.printStackTrace();
		}finally{
			if (loginpage.testFailure || dashboardpage.testFailure) {
				status = true;
			}
			this.testFailure = status;
		}
	}

	public void disable_CommentonView()
	{
		try {
			loginpage = new LoginPage(obj);
			dashboardpage = new DashboardPage(obj);

			String username = retrieve("User name");
			String password = retrieve("Password");
			String SecretItem = retrieve("Secret Template Type");
			String SecretName = retrieve("Secret Name");
			String AccountNumber = retrieve("Account Number");
			String RoutingNumber = retrieve("Routing Number");
			String BankName = retrieve("Bank Name");
			String AddressOne = retrieve("First Address");
			String SecondAddress = retrieve("Second Address");
			String thirdAddress = retrieve("Third Address");
			String ContactPerson = retrieve("Contact Person");
			String ContactPhone = retrieve("Contact Phone");
			String Notes = retrieve("Notes");
			String folderPath = retrieve("Folder Path");
			String folderName = retrieve("Folder Name");
			String url = retrieve("Secret server URL");
			String createSec_elements = retrieve("Secret Elements");
			
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(username, password, "No");
			
			CreateBankAccountSecretTemplate(SecretItem, SecretName, AccountNumber, RoutingNumber, BankName, AddressOne, SecondAddress, thirdAddress, ContactPerson, ContactPhone, Notes, folderPath, folderName);
			dashboardpage.performbulkoperationforPreCondition(SecretName, "Enable Comment on View", folderName, true);
			loginpage.Logout();
			
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(username, password, "Yes");
			
			dashboardpage.newSecret_Validation(SecretName, folderName, createSec_elements);
			
			
			deleteSecretfromdashboard(SecretName);
			loginpage.Logout();
		}catch(Exception ex)
		{
			//System.out.println("Exception in disableCommentonView "+ex);public static final String lbl_validationSummary = "To reteive validation summary#xpath=//div[@id='ValidationUpdatePanel']/div[@id='ValidationSummary']";
			ex.printStackTrace();
		}finally{
			if (loginpage.testFailure || dashboardpage.testFailure) {
				status = true;
			}
			this.testFailure = status;
		}
	}


	public void disable_CommentonViewWithMultipleSecrets()
	{
		try {
			loginpage = new LoginPage(obj);
			dashboardpage = new DashboardPage(obj);

			String username = retrieve("User name");
			String password = retrieve("Password");
			String SecretItem = retrieve("Secret Template Type");
			String SecretName = retrieve("Secret Name");
			String SecretName1 = retrieve("Secret Name 1");
			String AccountNumber = retrieve("Account Number");
			String RoutingNumber = retrieve("Routing Number");
			String BankName = retrieve("Bank Name");
			String AddressOne = retrieve("First Address");
			String SecondAddress = retrieve("Second Address");
			String thirdAddress = retrieve("Third Address");
			String ContactPerson = retrieve("Contact Person");
			String ContactPhone = retrieve("Contact Phone");
			String Notes = retrieve("Notes");
			String folderPath = retrieve("Folder Path");
			String folderName = retrieve("Folder Name");
			String BulkOperation = retrieve("Bulk Opertion");
			String ErrMsg= retrieve("Error Message");
			String ErrMsg1= retrieve("Error Message1");
			
			String url = retrieve("Secret server URL");
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(username, password, "No");

		
			CreateBankAccountSecretTemplate(SecretItem, SecretName, AccountNumber, RoutingNumber, BankName, AddressOne, SecondAddress, thirdAddress, ContactPerson, ContactPhone, Notes, folderPath, folderName);
			CreateBankAccountSecretTemplate(SecretItem, SecretName1, AccountNumber, RoutingNumber, BankName, AddressOne, SecondAddress, thirdAddress, ContactPerson, ContactPhone, Notes, folderPath, folderName);
			
			dashboardpage.PerformBulkOperationPreRequisteForMultiple(SecretName, SecretName1, BulkOperation, folderName, ErrMsg, ErrMsg1, false);
			loginpage.Logout();
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(username, password,"Yes");
			dashboardpage.CommentonView_Multiple_Secrets(SecretName, SecretName1, "Disable Comment on View");
			String SecretNames = retrieve("Secrets");
			deleteSecretfromdashboard(SecretNames);
			loginpage.Logout();

		}catch(Exception ex)
		{
			System.out.println("Exception in disable_CommentonViewWithMultipleSecrets "+ex);
			ex.printStackTrace();
		}finally{
			if (loginpage.testFailure || dashboardpage.testFailure) {
				status = true;
			}
			this.testFailure = status;
		}
	}

	public void single_EnableCheckOut()
	{
		try {
			
			loginpage = new LoginPage(obj);
			dashboardpage = new DashboardPage(obj);

			String username = retrieve("User name");
			String password = retrieve("Password");
			String SecretItem = retrieve("Secret Template Type");
			String SecretName = retrieve("Secret Name");
			String AccountNumber = retrieve("Account Number");
			String RoutingNumber = retrieve("Routing Number");
			String BankName = retrieve("Bank Name");
			String AddressOne = retrieve("First Address");
			String SecondAddress = retrieve("Second Address");
			String thirdAddress = retrieve("Third Address");
			String ContactPerson = retrieve("Contact Person");
			String ContactPhone = retrieve("Contact Phone");
			String Notes = retrieve("Notes");
			String folderPath = retrieve("Folder Path");
			String folderName = retrieve("Folder Name");
			String BulkOpertion = retrieve("Bulk Opertion");
			String url = retrieve("Secret server URL");
			
			
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");

			loginpage.Login(username, password,"Yes");

			CreateBankAccountSecretTemplate(SecretItem, SecretName, AccountNumber, RoutingNumber, BankName, AddressOne, SecondAddress, thirdAddress, ContactPerson, ContactPhone, Notes, folderPath, folderName);
			
			dashboardpage.single_Enable_Check_Out(SecretName,BulkOpertion, folderName);
			
			deleteSecretfromdashboard(SecretName);
			loginpage.Logout();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if (loginpage.testFailure || dashboardpage.testFailure) {
				status = true;
			}
			this.testFailure = status;
		}

	}

	public void EnableCheckOutWith_MultipleSecrets()
	{
		try {
			loginpage = new LoginPage(obj);
			dashboardpage = new DashboardPage(obj);

			String username = retrieve("User name");
			String password = retrieve("Password");
			String SecretItem = retrieve("Secret Template Type");
			String SecretName = retrieve("Secret Name");
			String SecretName1 = retrieve("Secret Name 1");
			String AccountNumber = retrieve("Account Number");
			String RoutingNumber = retrieve("Routing Number");
			String BankName = retrieve("Bank Name");
			String AddressOne = retrieve("First Address");
			String SecondAddress = retrieve("Second Address");
			String thirdAddress = retrieve("Third Address");
			String ContactPerson = retrieve("Contact Person");
			String ContactPhone = retrieve("Contact Phone");
			String Notes = retrieve("Notes");
			String folderPath = retrieve("Folder Path");
			String folderName = retrieve("Folder Name");
			String BulkOpertion = retrieve("Bulk Opertion");
			String url = retrieve("Secret server URL");
			
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(username, password,"Yes");

			CreateBankAccountSecretTemplate(SecretItem, SecretName, AccountNumber, RoutingNumber, BankName, AddressOne, SecondAddress, thirdAddress, ContactPerson, ContactPhone, Notes, folderPath, folderName);
			CreateBankAccountSecretTemplate(SecretItem, SecretName1, AccountNumber, RoutingNumber, BankName, AddressOne, SecondAddress, thirdAddress, ContactPerson, ContactPhone, Notes, folderPath, folderName);

			dashboardpage.performbulkoperationforPreCondition(SecretName, BulkOpertion, folderName, false);
			dashboardpage.performbulkoperationforPreCondition(SecretName1, BulkOpertion, folderName, false);
			dashboardpage.multiple_Enable_Check_Out(SecretName, SecretName1, BulkOpertion);
			String SecretNames = retrieve("Secrets");
			deleteSecretfromdashboard(SecretNames);

			loginpage.Logout();
		}catch(Exception ex)
		{
			System.out.println("Exception in EnableCheckOutWith_MultipleSecrets "+ex);
			ex.printStackTrace();
		}finally{
			if (loginpage.testFailure || dashboardpage.testFailure) {
				status = true;
			}
			this.testFailure = status;
		}
	}

	public void ValidatingWelcomeInContents()
	{
		try {

			loginpage = new LoginPage(obj);
			dashboardpage = new DashboardPage(obj);
			String username = retrieve("User name");
			String password = retrieve("Password");
			
			String alertMsg = retrieve("Alert Message");
			
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(username, password, "No");
			
			DeleteContentInDashBoard();
			dashboardpage.dragandDropwithVSTS(OR.drag_src_Welcome, OR.drop_Destination, "Welcome");
			loginpage.Logout();
			
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(username, password,"Yes");
			
			dashboardpage.Validate_Welcome_contentElement("Welcome", alertMsg);
			loginpage.Logout();

		}catch(Exception ex)
		{
			System.out.println("Exception in ValidatingWelcomeInContents "+ex);
			ex.printStackTrace();
		}finally{
			if (loginpage.testFailure || dashboardpage.testFailure) {
				status = true;
			}
			this.testFailure = status;
		}

	}

	public void HideLauncherPassword()
	{
		try {
			loginpage = new LoginPage(obj);
			dashboardpage = new DashboardPage(obj);
			String username = retrieve("User name");
			String password = retrieve("Password");
			String SecretItem = retrieve("Secret Template Type");
			String SecretName = retrieve("Secret Name");
			String Server = retrieve("Machine");
			String Notes = retrieve("Notes");
			String folderPath = retrieve("Folder Path");
			String folderName = retrieve("Folder Name");
			String Inherit_Secret_Policy = retrieve("Inherit Secret Policy");
			String Secret_Policy = retrieve("Secret Policy");
			String AutoChange = retrieve("AutoChange");
			String BulkOperation = retrieve("Bulk Operation");

			String url = retrieve("Secret server URL");
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(username, password, "No");
			CreateSqlSecretTemplate(SecretItem, SecretName, Server, username, password, Notes, folderPath, folderName, Inherit_Secret_Policy, Secret_Policy, AutoChange);
			dashboardpage.performbulkoperationforPreCondition(SecretName, BulkOperation, folderName, true);
			loginpage.Logout();
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(username, password,"Yes");
			
			dashboardpage.hide_Launcher_Password(SecretName, BulkOperation, folderName, false, "Yes", "Yes",SecretItem);
			clickOn(OR.btn_home_icon);
			deleteSecretfromdashboard(SecretName);
			loginpage.Logout();


		} catch (Exception ex) {
			System.out.println("Exception in HideLauncherPassword "+ex);
			ex.printStackTrace();
		}finally{
			if (loginpage.testFailure || dashboardpage.testFailure) {
				status = true;
			}
			this.testFailure = status;
		}
	}


	public void RemotePasswordStatusChange()
	{
		try
		{
			loginpage = new LoginPage(obj);
			dashboardpage = new DashboardPage(obj);
			adminpage = new AdminPage(obj);
			String username = retrieve("User name");
			String password = retrieve("Password");
			String RemotePasswordParams = retrieve("Remote Password Changing Configuration");
			String RemotePasswordParamsStatus = retrieve("Remote Password Changing Configuration status");
			String OperationName =retrieve("Operation Name");

			String url = retrieve("Secret server URL");
			
			
			
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(username, password, "No");
			
			adminpage.ValidateRemotePasswordParamwithVsts(RemotePasswordParams, RemotePasswordParamsStatus);
			loginpage.Logout();
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(username, password,"Yes");
			
			dashboardpage.RemotePasswordOption(RemotePasswordParams, RemotePasswordParamsStatus, OperationName);
			loginpage.Logout();
			
			
			
		}catch(Exception ex)
		{
			System.out.println("Exception in RemotePasswordStatusChange "+ex);
			ex.printStackTrace();
		}finally{
			if (loginpage.testFailure || dashboardpage.testFailure || adminpage.testFailure) {
				status = true;
			}
			this.testFailure = status;
		}
	}

	public void FavouriteSecrets()
	{
		try
		{
			loginpage = new LoginPage(obj);
			dashboardpage = new DashboardPage(obj);
			String username = retrieve("User name");
			String password = retrieve("Password");

			String SecretItem = retrieve("Secret Template Type");
			String SecretName = retrieve("Secret Name");
			String AccountNumber = retrieve("Account Number");
			String RoutingNumber = retrieve("Routing Number");
			String BankName = retrieve("Bank Name");
			String AddressOne = retrieve("First Address");
			String SecondAddress = retrieve("Second Address");
			String thirdAddress = retrieve("Third Address");
			String ContactPerson = retrieve("Contact Person");
			String ContactPhone = retrieve("Contact Phone");
			String Notes = retrieve("Notes");
			String folderPath = retrieve("Folder Path");
			String folderName = retrieve("Folder Name");

			String WidgetName = retrieve("Widget Name");
			String SecretDetails = retrieve("Secret Details");
			
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(username, password, "No");
			
			CreateBankAccountSecretTemplate(SecretItem, SecretName, AccountNumber, RoutingNumber, BankName, AddressOne, SecondAddress, thirdAddress, ContactPerson, ContactPhone, Notes, folderPath, folderName);

			dashboardpage.dragandDropwithVSTS(OR.drag_src_FavoriteSecrets, OR.drop_Destination, WidgetName);
		
			
			loginpage.Logout();
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(username, password,"Yes");
			
			dashboardpage.SetFavourite(SecretDetails, WidgetName, SecretName);
			deleteSecretfromdashboard(SecretName);
			loginpage.Logout();

		}catch(Exception ex)
		{
			System.out.println("Exception in FavouriteSecrets "+ex);
			ex.printStackTrace();

		}finally{
			if (loginpage.testFailure || dashboardpage.testFailure) {
				status = true;
			}
			this.testFailure = status;
		}
	}


	public void MultiplePinSecret()
	{
		try
		{
			loginpage = new LoginPage(obj);
			dashboardpage = new DashboardPage(obj);
			String username = retrieve("User name");
			String password = retrieve("Password");
			String PIN = retrieve("PIN");
			String Notes = retrieve("Notes");

			String SecretItem = retrieve("Secret Template Type");
			String SecretName = retrieve("Secret Name");
			String SecretName1 = retrieve("Secret Name 1");
			String folderPath = retrieve("Folder Path");
			String folderName = retrieve("Folder Name");

			String SecretNames = retrieve("Secret Names");


			String BulkOpertion = retrieve("Bulk Opertion");
			String Error_msg = retrieve("Error Message");

			String url = retrieve("Secret server URL");
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(username, password, "No");
			
			
			CreatePinSecretTemplate(SecretItem, SecretName, PIN, Notes, folderName, folderPath);
			CreatePinSecretTemplate(SecretItem, SecretName1, PIN, Notes, folderName, folderPath);
			
			dashboardpage.ValidateSecretIsPresentforMultiple(SecretName, SecretName1, folderName);
			loginpage.Logout();
			
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(username, password,"Yes");
			
			dashboardpage.Multiple_Pin_Secret(SecretName, SecretName1, BulkOpertion, Error_msg);
			deleteSecretfromdashboard(SecretNames);
			loginpage.Logout();
		}catch(Exception ex)
		{
			System.out.println("Exception in MultiplePinSecret "+ex);
			ex.printStackTrace();

		}finally{
			if (loginpage.testFailure || dashboardpage.testFailure) {
				status = true;
			}
			this.testFailure = status;
		}
	}

	public void EnableAutochangeRemotePassword()
	{
		try
		{
			loginpage = new LoginPage(obj);
			dashboardpage = new DashboardPage(obj);
			String username = retrieve("User name");
			String password = retrieve("Password");


			String SecretItem = retrieve("Secret Template Type");
			String SecretName = retrieve("Secret Name");
			String SecretName1 = retrieve("Secret Name 1");
			String folderPath = retrieve("Folder Path");
			String folderName = retrieve("Folder Name");
			String Notes = retrieve("Notes");
			String Inherit_Secret_Policy = retrieve("Inherit Secret Policy");
			String Domain = retrieve("Domain");
			String Secret_Policy = retrieve("Secret Policy");
			String AutoChange = retrieve("Auto Change");
			String SecretTemplateParas = retrieve("Secret Template Parameters");
			String SecretTemplateHeartbeatStatus= retrieve("Secret Template Remote Password Status");
			String BulkOperation = retrieve("Bulk Operation");
			String SecretNames = retrieve("Secrets");
			


			String url = retrieve("Secret server URL");
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(username, password, "No");

			CreateSqlSecretTemplate(SecretItem, SecretName, Domain, username, password, Notes, folderPath, folderName, Inherit_Secret_Policy, Secret_Policy, AutoChange);
			CreateSqlSecretTemplate(SecretItem, SecretName1, Domain, username, password, Notes, folderPath, folderName, Inherit_Secret_Policy, Secret_Policy, AutoChange);
			dashboardpage.ValidateSecretIsPresentforMultiple(SecretName, SecretName1, folderName);
			enableDiasableRemotePasswordandHBInSecretTemplates(SecretItem, SecretTemplateParas, "No");
			
			
			loginpage.Logout();
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(username, password,"Yes");

			dashboardpage.Enable_Autochange_RemotePassword(SecretItem, SecretTemplateParas, SecretTemplateHeartbeatStatus,SecretName,SecretName1,BulkOperation);
			deleteSecretfromdashboard(SecretNames);
			validateDashboard();
			loginpage.Logout();

		}catch(Exception ex)
		{
			System.out.println("Exception in EnableAutochangeRemotePassword "+ex);
			ex.printStackTrace();

		}finally{
			if (loginpage.testFailure || dashboardpage.testFailure) {
				status = true;
			}
			this.testFailure = status;
		}

	}
	public void RunHeartbeatwithHeartbeatDisabled()
	{
		try
		{
			loginpage = new LoginPage(obj);
			dashboardpage = new DashboardPage(obj);
			adminpage = new AdminPage(obj);
			
			String username = retrieve("User name");
			String password = retrieve("Password");


			String SecretItem = retrieve("Secret Template Type");
			String SecretName = retrieve("Secret Name");
			String SecretName1 = retrieve("Secret Name 1");
			String folderPath = retrieve("Folder Path");
			String folderName = retrieve("Folder Name");
			String Notes = retrieve("Notes");
			String Inherit_Secret_Policy = retrieve("Inherit Secret Policy");
			String Domain = retrieve("Domain");
			String Secret_Policy = retrieve("Secret Policy");
			String AutoChange = retrieve("Auto Change");
			String SecretTemplateParas = retrieve("Secret Template Parameters");
			String SecretTemplateHeartbeatStatus= retrieve("Heartbeat Status");
			String BulkOperation = retrieve("Bulk Operation");
			String SecretNames = retrieve("Secrets");

			String url = retrieve("Secret server URL");
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(username, password, "No");

			CreateSqlSecretTemplate(SecretItem, SecretName, Domain, username, password, Notes, folderPath, folderName, Inherit_Secret_Policy, Secret_Policy, AutoChange);
			CreateSqlSecretTemplate(SecretItem, SecretName1, Domain, username, password, Notes, folderPath, folderName, Inherit_Secret_Policy, Secret_Policy, AutoChange);
			adminpage.ValidateEnableDisableHBINSecretTemplate(SecretItem, SecretTemplateParas, SecretTemplateHeartbeatStatus);
			loginpage.Logout();
			
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(username, password,"Yes	");
			
			dashboardpage.RunHeartbeat_HeartbeatDisabled(SecretItem, SecretTemplateParas, SecretTemplateHeartbeatStatus,SecretName,SecretName1,BulkOperation);
			deleteSecretfromdashboard(SecretNames);
			validateDashboard();
			loginpage.Logout();

		}catch(Exception ex)
		{
			System.out.println("Exception in RunHeartbeatwithHeartbeatDisabled "+ex);
			ex.printStackTrace();

		}finally{
			if (loginpage.testFailure || dashboardpage.testFailure) {
				status = true;
			}
			this.testFailure = status;
		}
	}

	public void Disableheartbeat_HeartbeatDisabled()
	{
		try
		{
			loginpage = new LoginPage(obj);
			dashboardpage = new DashboardPage(obj);
			String username = retrieve("User name");
			String password = retrieve("Password");


			String SecretItem = retrieve("Secret Template Type");
			String SecretName = retrieve("Secret Name");
			String folderPath = retrieve("Folder Path");
			String folderName = retrieve("Folder Name");
			String Notes = retrieve("Notes");
			String Inherit_Secret_Policy = retrieve("Inherit Secret Policy");
			String Machine = retrieve("Machine");
			String Secret_Policy = retrieve("Secret Policy");
			String AutoChange = retrieve("Auto Change");
			String SecretTemplateParas = retrieve("Secret Template Parameters");
			String SecretTemplateHeartbeatStatus= retrieve("Heartbeat Status");
			String BulkOperation = retrieve("Bulk Operation");
			String SecondBulkOperation = retrieve("Second Bulk Operation");

			String FirstErrormessage = retrieve("First ErrorMessage");
			String SecondErrrorMessage = retrieve("Second ErrorMessage");
			

			String url = retrieve("Secret server URL");
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(username, password,"Yes");
				
			enableDiasableRemotePasswordandHBInSecretTemplates(SecretItem, SecretTemplateParas, SecretTemplateHeartbeatStatus);
			CreateSqlSecretTemplate(SecretItem, SecretName, Machine, username, password, Notes, folderPath, folderName, Inherit_Secret_Policy, Secret_Policy, AutoChange);

			dashboardpage.Disableheartbeat_HeartbeatDisabled(SecretName, BulkOperation, FirstErrormessage, folderName, false);
			dashboardpage.Disableheartbeat_HeartbeatDisabled(SecretName, SecondBulkOperation, SecondErrrorMessage, folderName, true);
			
			deleteSecretfromdashboard(SecretName);
			loginpage.Logout();

		}catch(Exception ex)
		{
			System.out.println("Exception in RunHeartbeatwithHeartbeatDisabled "+ex);
			ex.printStackTrace();

		}finally{
			if (loginpage.testFailure || dashboardpage.testFailure) {
				status = true;
			}
			this.testFailure = status;
		}

	}

	public void CurrentLoggedIn_Sessions()
	{
		try
		{
			loginpage = new LoginPage(obj);
			profilepage = new ProfilePage(obj);

			String username = retrieve("User name");
			String password = retrieve("Password");
			String SessionElements = retrieve("Session Elements");
			String SessionButtons = retrieve("Session Buttons");
			String Browser = retrieve("Browser");
			String IpAddr = retrieve("IpAddr");

			String url = retrieve("Secret server URL");
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(username, password,"Yes");

			profilepage.MyProfileSessionsValidation(SessionElements, SessionButtons, Browser, IpAddr);
			loginpage.Logout();

		}catch(Exception ex)
		{
			System.out.println("Exception in CurrentLoggedIn_Sessions "+ex);
			ex.printStackTrace();

		}finally{
			if (loginpage.testFailure || profilepage.testFailure) {
				status = true;
			}
			this.testFailure = status;
		}
	}


	public void unableToPerformBulkOperation()
	{
		try
		{
			loginpage = new LoginPage(obj);
			configurationpage = new ConfigurationPage(obj);
			userspage = new UsersPage(obj);
			folderspage = new FoldersPage(obj);
			dashboardpage = new DashboardPage(obj);

			String username = retrieve("User name");
			String password = retrieve("Password");


			String DefaultSecretPermissionParams = retrieve("Default Secret Permission Params");

			String Usersname = retrieve("Users Name");
			String DisplayName = retrieve("Display Name");
			String EmailAddress = retrieve("Email Address");
			String TwoFactory = retrieve("Two Factory");
			String EnabledUser = retrieve("Enabled User");
			String LockedOut = retrieve("Locked Out");

			String foldername = retrieve("Folder Name");
			String FolderIcon = retrieve("Folder Icon");
			String SecretPolicy = retrieve("Secret Policy");
			String AdminPermissionsName =retrieve("Admin Permissions Name");
			String FolderPermissionsValue = retrieve("Folder Permissions Value");
			String SecretPermissionsValue = retrieve("Secret Permissions Value");
			String Overridevalue = retrieve("Override value");
			String AddGroupUser=retrieve("Add Group User");
			String NewUsername=retrieve("New Username");
			String UserFolderPermissionstype=retrieve("User Folder Permissions type");
			String UserSecretPermissions=retrieve("User Secret Permissions");
			String UserOverview=retrieve("User Overview");

			String SecretItem = retrieve("Secret Template Type");
			String SecretName = retrieve("Secret Name");
			String folderPath = retrieve("Folder Path");
			String AccountNumber = retrieve("Account Number");
			String RoutingNumber = retrieve("Routing Number");
			String BankName = retrieve("Bank Name");
			String AddressOne = retrieve("First Address");
			String SecondAddress = retrieve("Second Address");
			String thirdAddress = retrieve("Third Address");
			String ContactPerson = retrieve("Contact Person");
			String ContactPhone = retrieve("Contact Phone");
			String Notes = retrieve("Notes");

			String BulkOpertion = retrieve("Bulk Opertion");
			
			String ErrorMessage = retrieve("Error message");

			String Url = retrieve("Secret server URL");

			String url = retrieve("Secret server URL");
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(username, password, "No");
			
			boolean Default_Status=configurationpage.SetDefaultSecretPermissions(DefaultSecretPermissionParams);
			
			userspage.createNewUsers(Usersname, DisplayName, EmailAddress, password, password, TwoFactory, EnabledUser, LockedOut);
			
			boolean Folder_Status=folderspage.createNewFolder(foldername, FolderIcon, SecretPolicy, AdminPermissionsName, FolderPermissionsValue, SecretPermissionsValue, Overridevalue, AddGroupUser, NewUsername, UserFolderPermissionstype, UserSecretPermissions, UserOverview);
			CreateBankAccountSecretTemplate(SecretItem, SecretName, AccountNumber, RoutingNumber, BankName, AddressOne, SecondAddress, thirdAddress, ContactPerson, ContactPhone, Notes, folderPath, foldername);
			loginpage.Logout();
			
			
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(username, password, "yes");
			dashboardpage.validateFolderDefaultSecretPreCondition(SecretName, foldername, Default_Status, Folder_Status);
			//dashboardpage.AddShareBulkOperation(SecretName, BulkOpertion, ErrorMessage,foldername);
			
			dashboardpage.CheckBulkOpertionWithfolderErrorMsg(SecretName, BulkOpertion, ErrorMessage,foldername);
			loginpage.Logout();
			loginpage.LaunchAllUrl(Url);
			loginpage.Login(Usersname, password, "No");
			deleteSecretfromNewuser(SecretName, password);
			
			//deleteSecretfromNewuser(SecretName, CurrentPassword);
			loginpage.Logout();

		}catch(Exception ex)
		{
			System.out.println("Exception in unableToPerformBulkOperation "+ex);
			ex.printStackTrace();

		}finally{
			if (loginpage.testFailure || configurationpage.testFailure || userspage.testFailure || folderspage.testFailure || dashboardpage.testFailure) {
				status = true;
			}
			this.testFailure = status;
		}
	}


	public void unableToPerformBulkOperationNewSecretscopypermissionsfromfolder()
	{
		try
		{
			loginpage = new LoginPage(obj);
			configurationpage = new ConfigurationPage(obj);
			userspage = new UsersPage(obj);
			folderspage = new FoldersPage(obj);
			dashboardpage = new DashboardPage(obj);

			String username = retrieve("User name");
			String password = retrieve("Password");


			String DefaultSecretPermissionParams = retrieve("Default Secret Permission Params");

			String Usersname = retrieve("Users Name");
			String DisplayName = retrieve("Display Name");
			String EmailAddress = retrieve("Email Address");
			String TwoFactory = retrieve("Two Factory");
			String EnabledUser = retrieve("Enabled User");
			String LockedOut = retrieve("Locked Out");

			String foldername = retrieve("Folder Name");
			String FolderIcon = retrieve("Folder Icon");
			String SecretPolicy = retrieve("Secret Policy");
			String AdminPermissionsName =retrieve("Admin Permissions Name");
			String FolderPermissionsValue = retrieve("Folder Permissions Value");
			String SecretPermissionsValue = retrieve("Secret Permissions Value");
			String Overridevalue = retrieve("Override value");
			String AddGroupUser=retrieve("Add Group User");
			String NewUsername=retrieve("New Username");
			String UserFolderPermissionstype=retrieve("User Folder Permissions type");
			String UserSecretPermissions=retrieve("User Secret Permissions");
			String UserOverview=retrieve("User Overview");

			String SecretItem = retrieve("Secret Template Type");
			String SecretName = retrieve("Secret Name");
			String folderPath = retrieve("Folder Path");
			String AccountNumber = retrieve("Account Number");
			String RoutingNumber = retrieve("Routing Number");
			String BankName = retrieve("Bank Name");
			String AddressOne = retrieve("First Address");
			String SecondAddress = retrieve("Second Address");
			String thirdAddress = retrieve("Third Address");
			String ContactPerson = retrieve("Contact Person");
			String ContactPhone = retrieve("Contact Phone");
			String Notes = retrieve("Notes");

			String BulkOpertion = retrieve("Bulk Opertion");
			
			String ErrorMessage = retrieve("Error message");

			String Url = retrieve("Secret server URL");

			String url = retrieve("Secret server URL");
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(username, password, "No");
			boolean Default_Status= configurationpage.SetDefaultSecretPermissions(DefaultSecretPermissionParams);
			userspage.createNewUsers(Usersname, DisplayName, EmailAddress, password, password, TwoFactory, EnabledUser, LockedOut);
			boolean Folder_Status=folderspage.createNewFolder(foldername, FolderIcon, SecretPolicy, AdminPermissionsName, FolderPermissionsValue, SecretPermissionsValue, Overridevalue, AddGroupUser, NewUsername, UserFolderPermissionstype, UserSecretPermissions, UserOverview);
			
		
			CreateBankAccountSecretTemplate(SecretItem, SecretName, AccountNumber, RoutingNumber, BankName, AddressOne, SecondAddress, thirdAddress, ContactPerson, ContactPhone, Notes, folderPath, foldername);
			dashboardpage.validateFolderDefaultSecretPreCondition(SecretName, foldername, Default_Status, Folder_Status);
			
			loginpage.Logout();
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(username, password, "Yes");
			//dashboardpage.PerformEnableCheckOutforNewSecretscopypermissionsfromfolder(SecretName, BulkOpertion,foldername);
			dashboardpage.CheckBulkOpertionWithfolderErrorMsg(SecretName, BulkOpertion, ErrorMessage,foldername);
			
			loginpage.Logout();
			loginpage.LaunchAllUrl(Url);
			loginpage.Login(Usersname, password, "No");
			deleteSecretfromNewuser(SecretName, password);
			loginpage.Logout();

		}catch(Exception ex)
		{
			System.out.println("Exception in unableToPerformBulkOperation "+ex);
			ex.printStackTrace();

		}finally{
			if (loginpage.testFailure || configurationpage.testFailure || userspage.testFailure || folderspage.testFailure || dashboardpage.testFailure) {
				status = true;
			}
			this.testFailure = status;
		}
	}


	public void ableToPerformCheckOutWithEditPermission()
	{
		try
		{
			loginpage = new LoginPage(obj);
			configurationpage = new ConfigurationPage(obj);
			userspage = new UsersPage(obj);
			folderspage = new FoldersPage(obj);
			dashboardpage = new DashboardPage(obj);

			String username = retrieve("User name");
			String password = retrieve("Password");


			String DefaultSecretPermissionParams = retrieve("Default Secret Permission Params");

			String Usersname = retrieve("Users Name");
			String DisplayName = retrieve("Display Name");
			String EmailAddress = retrieve("Email Address");
			String TwoFactory = retrieve("Two Factory");
			String EnabledUser = retrieve("Enabled User");
			String LockedOut = retrieve("Locked Out");

			String foldername = retrieve("Folder Name");
			String FolderIcon = retrieve("Folder Icon");
			String SecretPolicy = retrieve("Secret Policy");
			String AdminPermissionsName =retrieve("Admin Permissions Name");
			String FolderPermissionsValue = retrieve("Folder Permissions Value");
			String SecretPermissionsValue = retrieve("Secret Permissions Value");
			String Overridevalue = retrieve("Override value");
			String AddGroupUser=retrieve("Add Group User");
			String NewUsername=retrieve("New Username");
			String UserFolderPermissionstype=retrieve("User Folder Permissions type");
			String UserSecretPermissions=retrieve("User Secret Permissions");
			String UserOverview=retrieve("User Overview");

			String SecretItem = retrieve("Secret Template Type");
			String SecretName = retrieve("Secret Name");
			String folderPath = retrieve("Folder Path");
			String AccountNumber = retrieve("Account Number");
			String RoutingNumber = retrieve("Routing Number");
			String BankName = retrieve("Bank Name");
			String AddressOne = retrieve("First Address");
			String SecondAddress = retrieve("Second Address");
			String thirdAddress = retrieve("Third Address");
			String ContactPerson = retrieve("Contact Person");
			String ContactPhone = retrieve("Contact Phone");
			String Notes = retrieve("Notes");

			String BulkOpertion = retrieve("Bulk Opertion");

			String ErrorMessage = retrieve("Error message");
			
			//String Url = retrieve("Secret server URL");

			String url = retrieve("Secret server URL");
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(username, password, "No");
			boolean Default_Status=configurationpage.SetDefaultSecretPermissions(DefaultSecretPermissionParams);
			userspage.createNewUsers(Usersname, DisplayName, EmailAddress, password, password, TwoFactory, EnabledUser, LockedOut);
			boolean Folder_Status=folderspage.createNewFolder(foldername, FolderIcon, SecretPolicy, AdminPermissionsName, FolderPermissionsValue, SecretPermissionsValue, Overridevalue, AddGroupUser, NewUsername, UserFolderPermissionstype, UserSecretPermissions, UserOverview);
			CreateBankAccountSecretTemplate(SecretItem, SecretName, AccountNumber, RoutingNumber, BankName, AddressOne, SecondAddress, thirdAddress, ContactPerson, ContactPhone, Notes, folderPath, foldername);
			
			dashboardpage.validateFolderDefaultSecretPreCondition(SecretName, foldername, Default_Status, Folder_Status);
			
			loginpage.Logout();
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(username, password, "Yes");
			//dashboardpage.PerformEnableCheckOutforNewSecretswithEditPermisson(SecretName, BulkOpertion, foldername);
			dashboardpage.CheckBulkOpertionWithfolderErrorMsg(SecretName, BulkOpertion, ErrorMessage,foldername);
			
			deleteSecretfromNewuser(SecretName, password);
			loginpage.Logout();

		}catch(Exception ex)
		{
			System.out.println("Exception in unableToPerformBulkOperation "+ex);
			ex.printStackTrace();

		}finally{
			if (loginpage.testFailure || configurationpage.testFailure || userspage.testFailure || folderspage.testFailure || dashboardpage.testFailure) {
				status = true;
			}
			this.testFailure = status;
		}
	}


	public void EnableHeartbeatWithListPermission()
	{
		try
		{
			loginpage = new LoginPage(obj);
			configurationpage = new ConfigurationPage(obj);
			userspage = new UsersPage(obj);
			folderspage = new FoldersPage(obj);
			dashboardpage = new DashboardPage(obj);

			String username = retrieve("User name");
			String password = retrieve("Password");


			String DefaultSecretPermissionParams = retrieve("Default Secret Permission Params");

			String Usersname = retrieve("Users Name");
			String DisplayName = retrieve("Display Name");
			String EmailAddress = retrieve("Email Address");
			String TwoFactory = retrieve("Two Factory");
			String EnabledUser = retrieve("Enabled User");
			String LockedOut = retrieve("Locked Out");

			String foldername = retrieve("Folder Name");
			String FolderIcon = retrieve("Folder Icon");
			String SecretPolicy = retrieve("Secret Policy");
			String AdminPermissionsName =retrieve("Admin Permissions Name");
			String FolderPermissionsValue = retrieve("Folder Permissions Value");
			String SecretPermissionsValue = retrieve("Secret Permissions Value");
			String Overridevalue = retrieve("Override value");
			String AddGroupUser=retrieve("Add Group User");
			String NewUsername=retrieve("New Username");
			String UserFolderPermissionstype=retrieve("User Folder Permissions type");
			String UserSecretPermissions=retrieve("User Secret Permissions");
			String UserOverview=retrieve("User Overview");

			String SecretItem = retrieve("Secret Template Type");
			String SecretName = retrieve("Secret Name");
			String folderPath = retrieve("Folder Path");

			String Notes = retrieve("Notes");
			String Server = retrieve("Server");
			String Inherit_Secret_Policy = retrieve("Inherit Secret Policy");
			String Secret_Policy = retrieve("Secret Policy");
			String AutoChange = retrieve("AutoChange");

			String BulkOpertion = retrieve("Bulk Opertion");

			String Url = retrieve("Secret server URL");

			String ErrorMessage = retrieve("Error message");
			
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(username, password, "No");
			boolean Default_status=configurationpage.SetDefaultSecretPermissions(DefaultSecretPermissionParams);
			userspage.createNewUsers(Usersname, DisplayName, EmailAddress, password, password, TwoFactory, EnabledUser, LockedOut);
			boolean Folder_status=folderspage.createNewFolder(foldername, FolderIcon, SecretPolicy, AdminPermissionsName, FolderPermissionsValue, SecretPermissionsValue, Overridevalue, AddGroupUser, NewUsername, UserFolderPermissionstype, UserSecretPermissions, UserOverview);			
			
			CreateWindowAccountSecretTemplateWithListPermision(SecretItem, SecretName, Server, username, password, Notes, folderPath, foldername, Inherit_Secret_Policy, Secret_Policy, AutoChange);
		
			dashboardpage.validateFolderDefaultSecretPreCondition(SecretName, foldername, Default_status, Folder_status);
			loginpage.Logout();
			
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(username, password, "Yes");
			//dashboardpage.PerformHeartbeatwithListPermission(SecretName, BulkOpertion,foldername);
			dashboardpage.CheckBulkOpertionWithfolderErrorMsg(SecretName, BulkOpertion, ErrorMessage,foldername);
			loginpage.Logout();
			
			loginpage.LaunchAllUrl(Url);
			loginpage.Login(Usersname, password, "No");
			deleteSecretfromNewuser(SecretName, password);
			loginpage.Logout();

		}catch(Exception ex)
		{
			System.out.println("Exception in unableToPerformBulkOperation "+ex);
			ex.printStackTrace();

		}finally{
			if (loginpage.testFailure || configurationpage.testFailure || userspage.testFailure || folderspage.testFailure || dashboardpage.testFailure) {
				status = true;
			}
			this.testFailure = status;
		}
	}


	public void RunHeartbeat_ViewPermission()
	{
		try
		{
			loginpage = new LoginPage(obj);
			configurationpage = new ConfigurationPage(obj);
			userspage = new UsersPage(obj);
			folderspage = new FoldersPage(obj);
			dashboardpage = new DashboardPage(obj);

			String username = retrieve("User name");
			String password = retrieve("Password");


			String DefaultSecretPermissionParams = retrieve("Default Secret Permission Params");

			String Usersname = retrieve("Users Name");
			String DisplayName = retrieve("Display Name");
			String EmailAddress = retrieve("Email Address");
			String TwoFactory = retrieve("Two Factory");
			String EnabledUser = retrieve("Enabled User");
			String LockedOut = retrieve("Locked Out");

			String foldername = retrieve("Folder Name");
			String FolderIcon = retrieve("Folder Icon");
			String SecretPolicy = retrieve("Secret Policy");
			String AdminPermissionsName =retrieve("Admin Permissions Name");
			String FolderPermissionsValue = retrieve("Folder Permissions Value");
			String SecretPermissionsValue = retrieve("Secret Permissions Value");
			String Overridevalue = retrieve("Override value");
			String AddGroupUser=retrieve("Add Group User");
			String NewUsername=retrieve("New Username");
			String UserFolderPermissionstype=retrieve("User Folder Permissions type");
			String UserSecretPermissions=retrieve("User Secret Permissions");
			String UserOverview=retrieve("User Overview");

			String SecretItem = retrieve("Secret Template Type");
			String SecretName = retrieve("Secret Name");
			String folderPath = retrieve("Folder Path");
			String AccountNumber = retrieve("Account Number");
			String RoutingNumber = retrieve("Routing Number");
			String BankName = retrieve("Bank Name");
			String AddressOne = retrieve("First Address");
			String SecondAddress = retrieve("Second Address");
			String thirdAddress = retrieve("Third Address");
			String ContactPerson = retrieve("Contact Person");
			String ContactPhone = retrieve("Contact Phone");
			String Notes = retrieve("Notes");

			String BulkOpertion = retrieve("Bulk Opertion");

			String Url = retrieve("Secret server URL");
			
			String ErrorMessage = retrieve("Error message");
			
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(username, password, "No");
			boolean Default_status = configurationpage.SetDefaultSecretPermissions(DefaultSecretPermissionParams);
			userspage.createNewUsers(Usersname, DisplayName, EmailAddress, password, password, TwoFactory, EnabledUser, LockedOut);
			boolean Folder_status = folderspage.createNewFolder(foldername, FolderIcon, SecretPolicy, AdminPermissionsName, FolderPermissionsValue, SecretPermissionsValue, Overridevalue, AddGroupUser, NewUsername, UserFolderPermissionstype, UserSecretPermissions, UserOverview);
			CreateBankAccountSecretTemplate(SecretItem, SecretName, AccountNumber, RoutingNumber, BankName, AddressOne, SecondAddress, thirdAddress, ContactPerson, ContactPhone, Notes, folderPath, foldername);
			dashboardpage.validateFolderDefaultSecretPreCondition(SecretName, foldername, Default_status, Folder_status);
			loginpage.Logout();
			
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(username, password, "Yes");
			
			dashboardpage.CheckBulkOpertionWithfolderErrorMsg(SecretName, BulkOpertion, ErrorMessage,foldername);
			loginpage.Logout();
			
			
		//	dashboardpage.PerformRunHeartbeatWithViewPermission(SecretName, BulkOpertion, foldername);

			loginpage.LaunchAllUrl(Url);
			loginpage.Login(Usersname, password, "No");
			deleteSecretfromNewuser(SecretName, password);
			loginpage.Logout();

		}catch(Exception ex)
		{
			System.out.println("Exception in unableToPerformBulkOperation "+ex);
			ex.printStackTrace();

		}finally{
			if (loginpage.testFailure || configurationpage.testFailure || userspage.testFailure || folderspage.testFailure || dashboardpage.testFailure) {
				status = true;
			}
			this.testFailure = status;
		}
	}


	public void RunHeartbeatWithListPermission()
	{
		try
		{
			loginpage = new LoginPage(obj);
			configurationpage = new ConfigurationPage(obj);
			userspage = new UsersPage(obj);
			folderspage = new FoldersPage(obj);
			dashboardpage = new DashboardPage(obj);

			String username = retrieve("User name");
			String password = retrieve("Password");


			String DefaultSecretPermissionParams = retrieve("Default Secret Permission Params");

			String Usersname = retrieve("Users Name");
			String DisplayName = retrieve("Display Name");
			String EmailAddress = retrieve("Email Address");
			String TwoFactory = retrieve("Two Factory");
			String EnabledUser = retrieve("Enabled User");
			String LockedOut = retrieve("Locked Out");

			String foldername = retrieve("Folder Name");
			String FolderIcon = retrieve("Folder Icon");
			String SecretPolicy = retrieve("Secret Policy");
			String AdminPermissionsName =retrieve("Admin Permissions Name");
			String FolderPermissionsValue = retrieve("Folder Permissions Value");
			String SecretPermissionsValue = retrieve("Secret Permissions Value");
			String Overridevalue = retrieve("Override value");
			String AddGroupUser=retrieve("Add Group User");
			String NewUsername=retrieve("New Username");
			String UserFolderPermissionstype=retrieve("User Folder Permissions type");
			String UserSecretPermissions=retrieve("User Secret Permissions");
			String UserOverview=retrieve("User Overview");

			String SecretItem = retrieve("Secret Template Type");
			String SecretName = retrieve("Secret Name");
			String folderPath = retrieve("Folder Path");
			/*String AccountNumber = retrieve("Account Number");
			String RoutingNumber = retrieve("Routing Number");
			String BankName = retrieve("Bank Name");
			String AddressOne = retrieve("First Address");
			String SecondAddress = retrieve("Second Address");
			String thirdAddress = retrieve("Third Address");
			String ContactPerson = retrieve("Contact Person");
			String ContactPhone = retrieve("Contact Phone");*/
			String Notes = retrieve("Notes");
			String Server = retrieve("Server");
			String Inherit_Secret_Policy = retrieve("Inherit Secret Policy");
			String Secret_Policy = retrieve("Secret Policy");
			String AutoChange = retrieve("AutoChange");

			String BulkOpertion = retrieve("Bulk Opertion");

			String Url = retrieve("Secret server URL");

			String ErrorMessage = retrieve("Error message");
			
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(username, password, "No");
			boolean Default_status = configurationpage.SetDefaultSecretPermissions(DefaultSecretPermissionParams);
			userspage.createNewUsers(Usersname, DisplayName, EmailAddress, password, password, TwoFactory, EnabledUser, LockedOut);
			boolean Folder_status = folderspage.createNewFolder(foldername, FolderIcon, SecretPolicy, AdminPermissionsName, FolderPermissionsValue, SecretPermissionsValue, Overridevalue, AddGroupUser, NewUsername, UserFolderPermissionstype, UserSecretPermissions, UserOverview);
			//			CreateBankAccountSecretTemplate(SecretItem, SecretName, AccountNumber, RoutingNumber, BankName, AddressOne, SecondAddress, thirdAddress, ContactPerson, ContactPhone, Notes, folderPath, foldername);
			CreateWindowAccountSecretTemplateWithListPermision(SecretItem, SecretName, Server, username, password, Notes, folderPath, foldername, Inherit_Secret_Policy, Secret_Policy, AutoChange);
			
			dashboardpage.validateFolderDefaultSecretPreCondition(SecretName, foldername, Default_status, Folder_status);
			
			loginpage.Logout();
			
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(username, password, "Yes");
			
			dashboardpage.CheckBulkOpertionWithfolderErrorMsg(SecretName, BulkOpertion, ErrorMessage,foldername);
			
			//dashboardpage.PerformRunHeartbeatWithListPermission(SecretName, BulkOpertion,foldername);
			loginpage.Logout();
			loginpage.LaunchAllUrl(Url);
			loginpage.Login(Usersname, password, "No");
			deleteSecretfromNewuser(SecretName, password);
			loginpage.Logout();

		}catch(Exception ex)
		{
			System.out.println("Exception in unableToPerformBulkOperation "+ex);
			ex.printStackTrace();

		}finally{
			if (loginpage.testFailure || configurationpage.testFailure || userspage.testFailure || folderspage.testFailure || dashboardpage.testFailure) {
				status = true;
			}
			this.testFailure = status;
		}
	}

	public void EnableHeartbeatWithViewPermission()
	{
		try
		{
			loginpage = new LoginPage(obj);
			configurationpage = new ConfigurationPage(obj);
			userspage = new UsersPage(obj);
			folderspage = new FoldersPage(obj);
			dashboardpage = new DashboardPage(obj);

			String username = retrieve("User name");
			String password = retrieve("Password");


			String DefaultSecretPermissionParams = retrieve("Default Secret Permission Params");

			String Usersname = retrieve("Users Name");
			String DisplayName = retrieve("Display Name");
			String EmailAddress = retrieve("Email Address");
			String TwoFactory = retrieve("Two Factory");
			String EnabledUser = retrieve("Enabled User");
			String LockedOut = retrieve("Locked Out");

			String foldername = retrieve("Folder Name");
			String FolderIcon = retrieve("Folder Icon");
			String SecretPolicy = retrieve("Secret Policy");
			String AdminPermissionsName =retrieve("Admin Permissions Name");
			String FolderPermissionsValue = retrieve("Folder Permissions Value");
			String SecretPermissionsValue = retrieve("Secret Permissions Value");
			String Overridevalue = retrieve("Override value");
			String AddGroupUser=retrieve("Add Group User");
			String NewUsername=retrieve("New Username");
			String UserFolderPermissionstype=retrieve("User Folder Permissions type");
			String UserSecretPermissions=retrieve("User Secret Permissions");
			String UserOverview=retrieve("User Overview");

			String SecretItem = retrieve("Secret Template Type");
			String SecretName = retrieve("Secret Name");
			String folderPath = retrieve("Folder Path");
			/*String AccountNumber = retrieve("Account Number");
			String RoutingNumber = retrieve("Routing Number");
			String BankName = retrieve("Bank Name");
			String AddressOne = retrieve("First Address");
			String SecondAddress = retrieve("Second Address");
			String thirdAddress = retrieve("Third Address");
			String ContactPerson = retrieve("Contact Person");
			String ContactPhone = retrieve("Contact Phone");*/
			String Notes = retrieve("Notes");

			String BulkOpertion = retrieve("Bulk Opertion");

			String Url = retrieve("Secret server URL");

			String SecretTemplate = retrieve("Secret Template");
			String SecretTemplateStatus = retrieve("Secret Template Status");

			String Machine = retrieve("Server");
			String Inherit_Secret_Policy = retrieve("Inherit Secret Policy");
			String Secret_Policy = retrieve("Secret Policy");
			String AutoChange = retrieve("AutoChange");
			
			String ErrorMessage = retrieve("Error message");
			
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(username, password, "No");
			boolean Default_status = configurationpage.SetDefaultSecretPermissions(DefaultSecretPermissionParams);
			userspage.createNewUsers(Usersname, DisplayName, EmailAddress, password, password, TwoFactory, EnabledUser, LockedOut);
			boolean Folder_status = folderspage.createNewFolder(foldername, FolderIcon, SecretPolicy, AdminPermissionsName, FolderPermissionsValue, SecretPermissionsValue, Overridevalue, AddGroupUser, NewUsername, UserFolderPermissionstype, UserSecretPermissions, UserOverview);

			enableDiasableRemotePasswordandHBInSecretTemplates(SecretItem, SecretTemplate, SecretTemplateStatus);
			CreateSqlSecretTemplate(SecretItem, SecretName, Machine, username, password, Notes, folderPath, foldername, Inherit_Secret_Policy, Secret_Policy, AutoChange);
			
			dashboardpage.validateFolderDefaultSecretPreCondition(SecretName, foldername, Default_status, Folder_status);
			
			
			loginpage.Logout();
			
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(username, password, "Yes");
			
			dashboardpage.CheckBulkOpertionWithfolderErrorMsg(SecretName, BulkOpertion, ErrorMessage,foldername);
			
			//dashboardpage.PerformEnableHeartbeatWithViewPermission(SecretName, BulkOpertion,foldername);
			loginpage.Logout();
			loginpage.LaunchAllUrl(Url);
			loginpage.Login(Usersname, password, "No");
			deleteSecretfromNewuser(SecretName, password);
			loginpage.Logout();

		}catch(Exception ex)
		{
			System.out.println("Exception in unableToPerformBulkOperation "+ex);
			ex.printStackTrace();

		}finally{
			if (loginpage.testFailure || configurationpage.testFailure || userspage.testFailure || folderspage.testFailure || dashboardpage.testFailure) {
				status = true;
			}
			this.testFailure = status;
		}

	}

	public void DisableHeartbeatWithViewPermission()
	{
		try
		{
			loginpage = new LoginPage(obj);
			configurationpage = new ConfigurationPage(obj);
			userspage = new UsersPage(obj);
			folderspage = new FoldersPage(obj);
			dashboardpage = new DashboardPage(obj);

			String username = retrieve("User name");
			String password = retrieve("Password");


			String DefaultSecretPermissionParams = retrieve("Default Secret Permission Params");

			String Usersname = retrieve("Users Name");
			String DisplayName = retrieve("Display Name");
			String EmailAddress = retrieve("Email Address");
			String TwoFactory = retrieve("Two Factory");
			String EnabledUser = retrieve("Enabled User");
			String LockedOut = retrieve("Locked Out");

			String foldername = retrieve("Folder Name");
			String FolderIcon = retrieve("Folder Icon");
			String SecretPolicy = retrieve("Secret Policy");
			String AdminPermissionsName =retrieve("Admin Permissions Name");
			String FolderPermissionsValue = retrieve("Folder Permissions Value");
			String SecretPermissionsValue = retrieve("Secret Permissions Value");
			String Overridevalue = retrieve("Override value");
			String AddGroupUser=retrieve("Add Group User");
			String NewUsername=retrieve("New Username");
			String UserFolderPermissionstype=retrieve("User Folder Permissions type");
			String UserSecretPermissions=retrieve("User Secret Permissions");
			String UserOverview=retrieve("User Overview");

			String SecretItem = retrieve("Secret Template Type");
			String SecretName = retrieve("Secret Name");
			String folderPath = retrieve("Folder Path");
			/*String AccountNumber = retrieve("Account Number");
			String RoutingNumber = retrieve("Routing Number");
			String BankName = retrieve("Bank Name");
			String AddressOne = retrieve("First Address");
			String SecondAddress = retrieve("Second Address");
			String thirdAddress = retrieve("Third Address");
			String ContactPerson = retrieve("Contact Person");
			String ContactPhone = retrieve("Contact Phone");*/
			String Notes = retrieve("Notes");

			String BulkOpertion = retrieve("Bulk Opertion");

			//String Url = retrieve("Secret server URL");

			String SecretTemplate = retrieve("Secret Template");
			String SecretTemplateStatus = retrieve("Secret Template Status");

			String Machine = retrieve("Server");
			String Inherit_Secret_Policy = retrieve("Inherit Secret Policy");
			String Secret_Policy = retrieve("Secret Policy");
			String AutoChange = retrieve("AutoChange");

			String url = retrieve("Secret server URL");
			String ErrorMessage = retrieve("Error message");
			
			
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(username, password, "No");
			boolean Default_status = configurationpage.SetDefaultSecretPermissions(DefaultSecretPermissionParams);
			userspage.createNewUsers(Usersname, DisplayName, EmailAddress, password, password, TwoFactory, EnabledUser, LockedOut);
			boolean Folder_status = folderspage.createNewFolder(foldername, FolderIcon, SecretPolicy, AdminPermissionsName, FolderPermissionsValue, SecretPermissionsValue, Overridevalue, AddGroupUser, NewUsername, UserFolderPermissionstype, UserSecretPermissions, UserOverview);

			enableDiasableRemotePasswordandHBInSecretTemplates(SecretItem, SecretTemplate, SecretTemplateStatus);
			CreateSqlSecretTemplate(SecretItem, SecretName, Machine, username, password, Notes, folderPath, foldername, Inherit_Secret_Policy, Secret_Policy, AutoChange);
			
			dashboardpage.validateFolderDefaultSecretPreCondition(SecretName, foldername, Default_status, Folder_status);
			
			
			loginpage.Logout();
			
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(username, password, "Yes");
			
			dashboardpage.CheckBulkOpertionWithfolderErrorMsg(SecretName, BulkOpertion, ErrorMessage,foldername);
			
		//	dashboardpage.PerformDisableHeartbeatWithViewPermission(SecretName, BulkOpertion,foldername);
			
			
			/*loginpage.Logout();
			loginpage.LaunchAllUrl(Url);
			loginpage.Login(Usersname, password);*/
			deleteSecretfromdashboard(SecretName);
			loginpage.Logout();

		}catch(Exception ex)
		{
			System.out.println("Exception in DisableHeartbeatWithViewPermission "+ex);
			ex.printStackTrace();

		}finally{
			if (loginpage.testFailure || configurationpage.testFailure || userspage.testFailure || folderspage.testFailure || dashboardpage.testFailure) {
				status = true;
			}
			this.testFailure = status;
		}

	}

	public void RunHeartbeatWithListPermission_onlyCreatorhasPermissions()
	{
		try
		{
			loginpage = new LoginPage(obj);
			configurationpage = new ConfigurationPage(obj);
			userspage = new UsersPage(obj);
			folderspage = new FoldersPage(obj);
			dashboardpage = new DashboardPage(obj);

			String username = retrieve("User name");
			String password = retrieve("Password");


			String DefaultSecretPermissionParams = retrieve("Default Secret Permission Params");

			String Usersname = retrieve("Users Name");
			String DisplayName = retrieve("Display Name");
			String EmailAddress = retrieve("Email Address");
			String TwoFactory = retrieve("Two Factory");
			String EnabledUser = retrieve("Enabled User");
			String LockedOut = retrieve("Locked Out");

			String foldername = retrieve("Folder Name");
			String FolderIcon = retrieve("Folder Icon");
			String SecretPolicy = retrieve("Secret Policy");
			String AdminPermissionsName =retrieve("Admin Permissions Name");
			String FolderPermissionsValue = retrieve("Folder Permissions Value");
			String SecretPermissionsValue = retrieve("Secret Permissions Value");
			String Overridevalue = retrieve("Override value");
			String AddGroupUser=retrieve("Add Group User");
			String NewUsername=retrieve("New Username");
			String UserFolderPermissionstype=retrieve("User Folder Permissions type");
			String UserSecretPermissions=retrieve("User Secret Permissions");
			String UserOverview=retrieve("User Overview");

			String SecretItem = retrieve("Secret Template Type");
			String SecretName = retrieve("Secret Name");
			String folderPath = retrieve("Folder Path");
			String Notes = retrieve("Notes");
			String Server = retrieve("Server");
			String Inherit_Secret_Policy = retrieve("Inherit Secret Policy");
			String Secret_Policy = retrieve("Secret Policy");
			String AutoChange = retrieve("AutoChange");

			String BulkOpertion = retrieve("Bulk Opertion");

			String Url = retrieve("Secret server URL");
			String ErrorMessage = retrieve("Error message");
	
			
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(username, password, "No");
			boolean Default_status = configurationpage.SetDefaultSecretPermissions(DefaultSecretPermissionParams);
			userspage.createNewUsers(Usersname, DisplayName, EmailAddress, password, password, TwoFactory, EnabledUser, LockedOut);
			boolean Folder_status = folderspage.createNewFolder(foldername, FolderIcon, SecretPolicy, AdminPermissionsName, FolderPermissionsValue, SecretPermissionsValue, Overridevalue, AddGroupUser, NewUsername, UserFolderPermissionstype, UserSecretPermissions, UserOverview);
			CreateWindowAccountSecretTemplateWithListPermision(SecretItem, SecretName, Server, username, password, Notes, folderPath, foldername, Inherit_Secret_Policy, Secret_Policy, AutoChange);
			
			dashboardpage.validateFolderDefaultSecretPreCondition(SecretName, foldername, Default_status, Folder_status);
			loginpage.Logout();
			
			loginpage.LaunchAllUrl(Url);
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(username, password,"Yes");
			
			dashboardpage.CheckBulkOpertionWithfolderErrorMsg(SecretName, BulkOpertion, ErrorMessage,foldername);

			//dashboardpage.PerformRunHeartbeatWithViewPermission_onlyCreatorHasPermission(SecretName, BulkOpertion,foldername);
			
			
			deleteSecretfromdashboard(SecretName);
			loginpage.Logout();

		}catch(Exception ex)
		{
			System.out.println("Exception in RunHeartbeatWithListPermission_onlyCreatorhasPermissions "+ex);
			ex.printStackTrace();

		}finally{
			if (loginpage.testFailure || configurationpage.testFailure || userspage.testFailure || folderspage.testFailure || dashboardpage.testFailure) {
				status = true;
			}
			this.testFailure = status;
		}
	}

	public void BasicTabValidation()
	{
		try {
			loginpage = new LoginPage(obj);
			dashboardpage = new DashboardPage(obj);

			String username = retrieve("User name");
			String password = retrieve("Password");
			String SecretItem = retrieve("Secret Template Type");
			String SecretName = retrieve("Secret Name");
			String AccountNumber = retrieve("Account Number");
			String RoutingNumber = retrieve("Routing Number");
			String BankName = retrieve("Bank Name");
			String AddressOne = retrieve("First Address");
			String SecondAddress = retrieve("Second Address");
			String thirdAddress = retrieve("Third Address");
			String ContactPerson = retrieve("Contact Person");
			String ContactPhone = retrieve("Contact Phone");
			String Notes = retrieve("Notes");
			String folderPath = retrieve("Folder Path");
			String folderName = retrieve("Folder Name");

			String SecretElements = retrieve("Secret Elements");

			
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(username, password, "No");

			

			CreateBankAccountSecretTemplate(SecretItem, SecretName, AccountNumber, RoutingNumber, BankName, AddressOne, SecondAddress, thirdAddress, ContactPerson, ContactPhone, Notes, folderPath, folderName);
			dashboardpage.validateSecretispresent(SecretName, retrieve("Folder Name"), true);
			loginpage.Logout();
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(username, password,"Yes");
			
			dashboardpage.BasicTab(SecretElements, SecretName);
			deleteSecretfromdashboard(SecretName);
			loginpage.Logout();

		} catch(Exception ex)
		{
			System.out.println("Exception in unableToPerformBulkOperation "+ex);
			ex.printStackTrace();

		}finally{
			if (loginpage.testFailure ||dashboardpage.testFailure) {
				status = true;
			}
			this.testFailure = status;
		}
	}



	public void ValidatingGettingStarted()
	{
		try
		{

			loginpage = new LoginPage(obj);
			gettingstartedpage = new GettingStartedPage(obj);

			String username = retrieve("User name");
			String password = retrieve("Password");
			String Emailserver = retrieve("Email Server");
			String FromEmailAddress = retrieve("From Email Address");
			String AdvancedOptElements = retrieve("Advance(Optional) Elements");
			String UseCredentialsElements = retrieve("Use Credentials Elements");
			String UseCustomPortElements = retrieve("Use Custom Port Elements");
			String Ele = retrieve("Final Visible Elemements");

			String[] VisibleElemements = Ele.split("##");

			
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(username, password, "Yes");
			
			
			gettingstartedpage.GettingStartedValidation(Emailserver, FromEmailAddress, AdvancedOptElements, UseCredentialsElements, UseCustomPortElements, VisibleElemements);
			loginpage.Logout();

		}catch(Exception ex)
		{
			System.out.println("Exception in ValidatingGettingStarted "+ex);
			ex.printStackTrace();

		}finally{
			if (loginpage.testFailure ||gettingstartedpage.testFailure) {
				status = true;
			}
			this.testFailure = status;
		}
	}

	public void copyToClipBoard() throws IOException
	{
		try
		{
			loginpage = new LoginPage(obj);
			dashboardpage = new DashboardPage(obj);


			String username = retrieve("User name");
			String password = retrieve("Password");


			String SecretItem = retrieve("Secret Template Type");
			String SecretName = retrieve("Secret Name");
			String folderPath = retrieve("Folder Path");
			String foldername = retrieve("Folder Name");
			String Notes = retrieve("Notes");
			String Server = retrieve("Server");
			String Inherit_Secret_Policy = retrieve("Inherit Secret Policy");
			String Secret_Policy = retrieve("Secret Policy");
			String AutoChange = retrieve("AutoChange");
			String SecretData = retrieve("Secret Data");
			String path = retrieve("Path");

			String url = retrieve("Secret server URL");
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(username, password, "yes");
			validateDashboard();

			CreateSqlSecretTemplate(SecretItem, SecretName, Server, username, password, Notes, folderPath, foldername, Inherit_Secret_Policy, Secret_Policy, AutoChange);

			dashboardpage.copyTextTOClipBoard(SecretName, SecretData, path);
			loginpage.Logout();

		}catch(Exception ex)
		{
			System.out.println("Exception in copyToClipBoard "+ex);
			ex.printStackTrace();

		}finally{
			if (loginpage.testFailure ||dashboardpage.testFailure) {
				status = true;
			}
			this.testFailure = status;
		}
	}

    
    

}
