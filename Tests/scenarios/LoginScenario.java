package scenarios;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginScenario extends ApplicationKeywords{

	BaseClass obj;
	LoginPage loginpage;
	DashboardPage dashboardpage;
	private Boolean status = false;

	public LoginScenario(BaseClass obj) {
		// TODO Auto-generated constructor stub
		super(obj);
		this.obj=obj;
	}
	public LoginScenario() {

		// TODO Auto-generated constructor stub
	}
	
	public void scenario1(){
		try{
			loginpage = new LoginPage(obj);
			dashboardpage = new DashboardPage(obj);
			loginpage.LaunchUrl(retrieve("Secret server URL"), "Yes");
			loginpage.Login(retrieve("User Name"), retrieve("Password"), "No");

			loginpage.Logout();
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if (loginpage.testFailure) {
				 status = true;
			}
			this.testFailure = status;
		}
	}
	
	public void ValidateLoginPageFields() {
		try{
			loginpage = new LoginPage(obj);
			dashboardpage = new DashboardPage(obj);
			loginpage.LaunchUrl(retrieve("Secret server URL"), "Yes");
			loginpage.ValidateLoginPageElements();
			//loginpage.Login(retrieve("User Name"), retrieve("Password"));

			//loginpage.Logout();
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if (loginpage.testFailure) {
				 status = true;
			}
			this.testFailure = status;
		}
	}
	
	public void ValidateLoginPageFieldswithLogin() {
		try{
			loginpage = new LoginPage(obj);
			dashboardpage = new DashboardPage(obj);
			loginpage.LaunchUrl(retrieve("Secret server URL"), "Yes");
			loginpage.ValidateLoginPageElements();
			loginpage.ValidateLoginScenarios(retrieve("User Name"), retrieve("Password"), "");
			loginpage.Logout();
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if (loginpage.testFailure) {
				 status = true;
			}
			this.testFailure = status;
		}
	}
	
	public void InvaildLogincredentials() {
		try{
			loginpage = new LoginPage(obj);
			dashboardpage = new DashboardPage(obj);
			loginpage.LaunchUrl(retrieve("Secret server URL"), "Yes");
			loginpage.ValidateLoginPageElements();
			loginpage.ValidateLoginScenarios(retrieve("User Name"), retrieve("Password"), retrieve("Expected Message"));
			//loginpage.Login(retrieve("User Name"), retrieve("Password"));

			//loginpage.Logout();
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if (loginpage.testFailure) {
				 status = true;
			}
			this.testFailure = status;
		}
	}
	
	public void ValidatblankUserAndPassworkErrorMessage() {
		try{
			loginpage = new LoginPage(obj);
			loginpage.LaunchUrl(retrieve("Secret server URL"), "Yes");
			loginpage.ValidateLoginPageElements();
			loginpage.ValidateLoginScenarios("", "", retrieve("Expected Message"));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if (loginpage.testFailure) {
				 status = true;
			}
			this.testFailure = status;
		}
	}
	
	public void validateblankPasswordErrorMsg() {
		try{
			loginpage = new LoginPage(obj);
			dashboardpage = new DashboardPage(obj);
			loginpage.LaunchUrl(retrieve("Secret server URL"), "Yes");
			loginpage.ValidateLoginPageElements();
			loginpage.ValidateLoginScenarios(retrieve("User Name"),"", retrieve("Expected Message"));
			//loginpage.Login(retrieve("User Name"), retrieve("Password"));

			//loginpage.Logout();
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if (loginpage.testFailure) {
				 status = true;
			}
			this.testFailure = status;
		}
	}
	
	public void ValidatblankUserNameErrorMessage() {
		try{
			loginpage = new LoginPage(obj);
			dashboardpage = new DashboardPage(obj);
			loginpage.LaunchUrl(retrieve("Secret server URL"), "Yes");
			loginpage.ValidateLoginPageElements();
			loginpage.ValidateLoginScenarios("", retrieve("Password"),  retrieve("Expected Message"));
			//loginpage.Login(retrieve("User Name"), retrieve("Password"));

			//loginpage.Logout();
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if (loginpage.testFailure) {
				 status = true;
			}
			this.testFailure = status;
		}
	}
	
	public void ValidateThycoticpagedisplayed() {
		try{
			loginpage = new LoginPage(obj);
			dashboardpage = new DashboardPage(obj);
			loginpage.LaunchUrl(retrieve("Secret server URL"), "Yes");
			loginpage.ValidateLoginPageElements();
			loginpage.verifyThycoticpagedisplayedclickingcopyright();
			//loginpage.Login(retrieve("User Name"), retrieve("Password"));

			//loginpage.Logout();
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if (loginpage.testFailure) {
				 status = true;
			}
			this.testFailure = status;
		}
	}
	
	public void ValidateRefreshthepageafterclickinglogo() {
		try{
			loginpage = new LoginPage(obj);
			dashboardpage = new DashboardPage(obj);
			loginpage.LaunchUrl(retrieve("Secret server URL"), "Yes");
			loginpage.ValidateLoginPageElements();
			loginpage.VerifyRefreshthepage();
			//loginpage.Login(retrieve("User Name"), retrieve("Password"));

			//loginpage.Logout();
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if (loginpage.testFailure) {
				 status = true;
			}
			this.testFailure = status;
		}
	}
	
	public void ValidateThycoticpagedisplayedclickingThycotic() {
		try{
			loginpage = new LoginPage(obj);
			dashboardpage = new DashboardPage(obj);
			loginpage.LaunchUrl(retrieve("Secret server URL"), "Yes");
			loginpage.ValidateLoginPageElements();
			loginpage.verifyThycoticpagedisplayedclickingThycotic();
			//loginpage.Login(retrieve("User Name"), retrieve("Password"));

			//loginpage.Logout();
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if (loginpage.testFailure) {
				 status = true;
			}
			this.testFailure = status;
		}
	}
}
