package module6_2.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		
		WebElement link = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[class^='_fce_h']")));
//		.linkText("New")));
//		.elementToBeClickable(By.linkText("New")));
//		.visibilityOfElementLocated(By.linkText("New")));

		Actions builder = new Actions(driver);
		
		builder.doubleClick(link).build().perform();

		//Find and input to To field
		WebElement ToField = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div._fp_A>form>input")));

//		driver.findElement(By.cssSelector("div._fp_A>form>input"));

		ToField.click();

		ToField.sendKeys("gary_zhao@epam.com");

		//Find and input to Subject field
		WebElement subjectField = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[class^='_mcp_C1']")));

//		driver.findElement(By.cssSelector("input[class^='_mcp_C1']"));

		subjectField.click();

		subjectField.sendKeys("Homework Module 6 -2 from Gary Zhao");

		//Find and input Body 
		WebElement bodyField = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[class^='allowTextSelection']:first-child")));

//		driver.findElement(By.cssSelector("div[class^='allowTextSelection']:first-child"));

//		bodyField.clear();

		bodyField.sendKeys("Hi This is my homework for Module6-2, though it is ugly.:)");

		//Save email to Draft
		/*
		 * FAILED, since outlook.live.com prohibit automatically created email be saved as draft.
		WebElement draftIcon = driver.findElement(By.cssSelector("div._fce_e>button"));

		draftIcon.click();

		driver.findElement(By.cssSelector("div[id^='_ariaId_7']>div>div>div>div>div>button")).click();
*/

		//Send email out
		driver.findElement(By.cssSelector("div._fce_e>button")).click();

		
		
//		build.doubleClick(newEmailLinkIcon).build().perform();
	    /*
		Boolean flag = inputFolder.isDisplayed();
		
		if(flag){
			System.out.println("Input folder had been found.");
		}
		
		newEmailIcon.click();
		
		toInputFiled.sendKeys(TO);
		
		subjectInputField.sendKeys(SUBJECT);
		
		bodyInputField.sendKeys(BODY);
		
		sendEmailOutButton.click();
		*/
	}
	
	public void close(){
		System.out.println("Email had been sent out and browser will be closed.");
		driver.close();
	}
}
