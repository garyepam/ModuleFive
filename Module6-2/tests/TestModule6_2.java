package module6_2.tests;

import module6_2.pageObjects.HomePage;
import module6_2.pageObjects.LoginPage;

public class TestModule6_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Initialize broswser and log on page");
		LoginPage loginPage = new LoginPage();
		
		//Navigate to hotmail web page
		loginPage.load();
		
		//Login with user name and password
		loginPage.login();
		
		HomePage homePage = new HomePage(LoginPage.driver);
		
		try {
			
			Thread.sleep(29000);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//compose email receipt, subject and a short text as body then sent out
		homePage.emailEdit();
		
		System.out.println("Email sent out successfull!");
		
		homePage.close();
	}

}
