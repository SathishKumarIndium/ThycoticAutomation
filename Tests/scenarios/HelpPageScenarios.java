package scenarios;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import pages.DashboardPage;
import pages.HelpPage;
import pages.LoginPage;

public class HelpPageScenarios extends ApplicationKeywords {

	BaseClass obj;
	LoginPage loginpage  ;
	DashboardPage dashboardpage ;
	HelpPage helppage ;
	private Boolean status = false;
	public HelpPageScenarios(BaseClass obj) {
		// TODO Auto-generated constructor stub
		super(obj);
		this.obj=obj;
	}
	public HelpPageScenarios() {

		// TODO Auto-generated constructor stub
	}
	
	public void Verifyhelppagelayout() {
		try{
			loginpage  = new LoginPage(obj);
			helppage = new HelpPage(obj);
			loginpage.LaunchUrl(retrieve("Secret server URL"), "No");
			loginpage.Login(retrieve("User Name"), retrieve("Password"), "Yes");
			
			String helpfields = retrieve("Help Labels");
			helppage.HelpPageFieldsValidation(helpfields);
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
