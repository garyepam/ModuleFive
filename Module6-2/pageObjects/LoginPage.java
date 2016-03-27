package module6_2.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
		
	static String USERNAME = "gary_epam@hotmail.com";
	
	static String PASSWORD = "GARYepam2016";
	
	public static WebDriver driver = new FirefoxDriver();;
	
//	WebDriverWait wait = new WebDriverWait(driver,30);	
	private String url = "https://mail.msn.com";
	
	@FindBy(id = "i0116")
	private WebElement userName;
	
	@FindBy(id = "i0118")
	private WebElement password;
	
	@FindBy(id = "idSIButton9")
	private WebElement loginButton;
	
	//Create constructor to LoginPage class and initialize page Object
	public LoginPage(){
		
//		driver = new FirefoxDriver();
		
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
		
		loginButton.click();
				
	}
	
	//Close driver	
	public void close(){
	
		this.driver.close();
	}
}
