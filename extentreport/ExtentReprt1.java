package extentreport;

import org.testng.annotations.Test;

public class ExtentReprt1 {
	@Test(priority=1)
    void launchApp() {
    System.out.println("Launch the appication");
   	 
    }
	@Test(priority=2)
	void login() {
		System.out.println("login to the application");   
		
	}
	
	@Test(priority=3)
	void logout() {
		System.out.println("logout  to the application");
		
	}

	@Test(priority=4)
	void closeAPP() {
		System.out.println("close the application");
		
		
	}
}
