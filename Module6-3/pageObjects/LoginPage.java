package module6_2.pageObjects;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LoginPage {
		
	static String USERNAME = "gary_epam@hotmail.com";
	
	static String PASSWORD = "GARYepam2016";
	
	static DesiredCapabilities capability = DesiredCapabilities.firefox();
	
	public static WebDriver driver;
//			new FirefoxDriver();
	
//	WebDriverWait wait = new WebDriverWait(driver,30);	
	private String url = "https://mail.msn.com";
	
	@FindBy(id = "i0116")
	private WebElement userName;
	
	@FindBy(id = "i0118")
	private WebElement password;
	
	@FindBy(id = "idSIButton9")
	private WebElement loginButton;
	
	//Create constructor to LoginPage class and initialize page Object
	@Test
	public LoginPage() {
		
		DesiredCapabilities capability = DesiredCapabilities.firefox();
		
//		driver = new FirefoxDriver();
		capability.setBrowserName("firefox");
	
		capability.setPlatform(Platform.WINDOWS);
		
		try{
			
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capability);
		
		} catch(MalformedURLException e){
			
			e.printStackTrace();
		}
		
		
		PageFactory.initElements(driver, this);
		
	}
	
	//Navigate to the page which will be tested
	public void load(){
		
		this.driver.manage().window().maximize();
		
		this.driver.get(url);
	}
	
	
	//Login hotmail with user and password
	public void login(){
		
		userName.sendKeys(USERNAME);
		
		password.sendKeys(PASSWORD);
		
		//Use JavaScript to get current domain
	JavascriptExecutor js = (JavascriptExecutor) driver;
		
	String docuTitle = (String)js.executeScript("return document.domain");
		
	System.out.println("Document title is: " +docuTitle);
		
		//Hightlight login button with red and border
		js.executeScript("arguments[0].setAttribute('style',arguments[1]);", loginButton,"color:red;font-size:25px; border:5px solid green");
		
		loginButton.click();
				
	}
	
	private boolean Boolean(Object alert) {
		// TODO Auto-generated method stub
		return false;
	}

	//Close driver	
	public void close(){
			
		this.driver.close();
	}
}
