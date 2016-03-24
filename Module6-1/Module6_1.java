package module6_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Module6_1 {
		 	
	WebDriver driver = new FirefoxDriver();
	  
	 
  @Test
  public void sendEmailFunctionVerification() {
	 
	  	//Input user name
	  	WebDriverWait wait = new WebDriverWait(driver,30);
		
		WebElement userName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("i0116")));
		
		userName.sendKeys("gary_epam@hotmail.com");
	  
		//Input password
		WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("i0118")));
		
		password.sendKeys("GARYepam2016");  
	  
		//Click submit to log on 
		driver.findElement(By.id("idSIButton9")).click();
		
		//Waiting for log on complete then click the create new mail button
		WebElement link = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[class^='_fce_h']")));
//				.linkText("New")));
//				.elementToBeClickable(By.linkText("New")));
// 				.visibilityOfElementLocated(By.linkText("New")));
		Actions builder = new Actions(driver);
		builder.doubleClick(link).build().perform();
//		link.click();
		
		//Find and input to To field
		WebElement ToField = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div._fp_A>form>input")));
//				driver.findElement(By.cssSelector("div._fp_A>form>input"));
		
		ToField.click();
		
		ToField.sendKeys("olesksii_kaminskyi@epam.com");
		
		//Find and input to Subject field
		
		WebElement subjectField = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[class^='_mcp_C1']")));
//				driver.findElement(By.cssSelector("input[class^='_mcp_C1']"));
		
		subjectField.click();
		
		subjectField.sendKeys("Homework Module 6 -1 from Gary Zhao");
		
		//Find and input Body 
		
		WebElement bodyField = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[class^='allowTextSelection']:first-child")));
//				driver.findElement(By.cssSelector("div[class^='allowTextSelection']:first-child"));
		
//		bodyField.clear();
		
		bodyField.sendKeys("Hi Alex This is my homework for Module6-1, though it is urgle.:)");
		
		
		//Save email to Draft
		/*
		 * FAILED, since outlook.live.com prohibit automatically created email be saved as draft.
		WebElement draftIcon = driver.findElement(By.cssSelector("div._fce_e>button"));
		
		draftIcon.click();
		
		driver.findElement(By.cssSelector("div[id^='_ariaId_7']>div>div>div>div>div>button")).click();
		*/
		
		//Send email out
		driver.findElement(By.cssSelector("div._fce_e>button")).click();
		
  }
  
  @BeforeMethod
  public void beforeMethod() {
	 
	
	  driver.manage().window().maximize();
	  
	  driver.get("https://mail.msn.com");
  }

  @AfterMethod
  public void afterMethod() {
	  
	  System.out.println("Testing complete!");
//	  driver.close();
  }

  @BeforeClass
  public void beforeClass() {
	  
	  System.out.println("TA homework module 6 - 1.");
	 
	   }

  @AfterClass
  public void afterClass() {
  }

}
