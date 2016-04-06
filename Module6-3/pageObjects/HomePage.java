package module6_2.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

public class HomePage {
	
	WebDriver driver;
	
	WebDriverWait wait = new WebDriverWait(LoginPage.driver,30);
	
	Actions build = new Actions(LoginPage.driver);
	
	static String TO = "gary_zhao@epam.com";
	
	static String SUBJECT = "Homework for moduel 6 - 2 of Gary Zhao";
			
	static String BODY = "Hi, Alex  This is my homework of module 6 - 2. Thanks ";
	
	@FindBy(id="_ariaId_30.folder")
	private WebElement inputFolder;
	
	@FindBy(css = "button[class^='_fce_h']") 
	private WebElement newEmailGenerator;
	
	@FindBy(using="button[class^='_fce_h']")
	private WebElement newEmailIcon;

	@FindBy(css = "div._fp_A>form>input")
	private WebElement toInputFiled;
	
	@FindBy(css = "input[class^='_mcp_C1'")
	private WebElement subjectInputField;
	

	@FindBy(css = "div[class^='allowTextSelection']:first-child'")
	private WebElement bodyInputField;
	
	@FindBy(css = "div._fce_e>button")
	private WebElement sendEmailOutButton;

	//Initialized the elements on the email content page
	public HomePage(WebDriver driver){
		
		this.driver = LoginPage.driver;
		
		PageFactory.initElements(driver, this);
	}
	
	public void emailEdit(){
		
		//Initialized new email
		WebElement link = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[class^='_fce_h']")));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].setAttribute('style',arguments[1]);", link,"color:yellow;font-size:20px; border:3px solid green");
		
		Actions builder = new Actions(driver);
		
		builder.doubleClick(link).build().perform();

		//Find and input to To field
		WebElement ToField = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div._fp_A>form>input")));

		ToField.click();

		ToField.sendKeys("gary_zhao@epam.com");

		//Find and input to Subject field
		WebElement subjectField = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[class^='_mcp_C1']")));

		subjectField.click();

		subjectField.sendKeys("Homework Module 6 - 3 from Gary Zhao");

		WebElement bodyField = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[class^='allowTextSelection']:first-child")));

		bodyField.sendKeys("Hi This is my homework for Module6-3. With Javascript, Actions class and Selenium-Grid. :)");

		driver.findElement(By.cssSelector("div._fce_e>button")).click();
	
	}
	
	public void close(){
		
		System.out.println("Email had been sent out and browser will be closed.");
		
		driver.close();
	}
}
