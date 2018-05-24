package scenarios;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.AdminPage;
import pages.BasicPage;
import pages.ConfigurationPage;
import pages.DashboardPage;
import pages.FoldersPage;
import pages.HelpPage;
import pages.LoginPage;
import pages.ProfilePage;
import pages.UsersPage;

public class LicenseScenarios extends ApplicationKeywords{
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
	private Boolean status = false;

	public LicenseScenarios(BaseClass obj) {
		// TODO Auto-generated constructor stub
		super(obj);
		this.obj=obj;
	}
	public LicenseScenarios() {

		// TODO Auto-generated constructor stub
	}
	
	 public void AddLicensesViaSecretServerSetup() {
		try{
			String LicensesName = retrieve("Licenses Name");
			String LicensesKeys = retrieve("Licenses Keys");
			loginpage  = new LoginPage(obj);
			helppage = new HelpPage(obj);
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(retrieve("User Name"), retrieve("Password"), "Yes");
			helppage.addingLicensesSecretServerSetup(LicensesName, LicensesKeys);
			helppage.verifyLicenesesinLicensesPage(LicensesKeys, true);
			helppage.deleteLicenses(retrieve("Licenses Keys"));
			loginpage.Logout();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if (loginpage.testFailure || helppage.testFailure) {
				 status = true;
			}
			this.testFailure = status;
		}
	}
    
    public void verifyRemoveLicensesViaSecretServerSetup() {
		try{
			
			String LicensesName = retrieve("Licenses Name");
			String LicensesKeys = retrieve("Licenses Keys");
			
			loginpage  = new LoginPage(obj);
			helppage = new HelpPage(obj);
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(retrieve("User Name"), retrieve("Password"), "No");
			helppage.validateLicensesispresentprecondition(LicensesName, LicensesKeys);
			loginpage.Logout();
			
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(retrieve("User Name"), retrieve("Password"), "yes");
			helppage.deleteLicensesSecretServerSetup(LicensesKeys);
			loginpage.Logout();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if (loginpage.testFailure || helppage.testFailure) {
				 status = true;
			}
			this.testFailure = status;
		}
	}
	
}
