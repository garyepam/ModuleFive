package myPackage;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.epam.tat.module4.Calculator;

@Test(groups="ModuelFive")
public class NewTest {
	
//	StringBuffer verificationErrors = new StringBuffer();
 
	@Test(dataProvider = "dpDiv")  
  public void division(int a, int b, int res) {

	  long resultInteger;
	  
	  Calculator cal = new Calculator();
	  
	  resultInteger =  cal.div(a, b);
	  
	  Assert.assertEquals(resultInteger, res);
	  
  }
	@Test(dataProvider = "dpMul")  
	  public void mul(long a, long b, long res) {

		  long resultInteger;
		  
		  Calculator cal = new Calculator();
		  
		  resultInteger =  cal.mult(a, b);
		  
		  Assert.assertEquals(resultInteger, res);
		  
	  }
	
	
	@Test(dataProvider = "dpSub")  
	  public void sub(long a, long b, long res) {

		  long resultInteger;
		  
		  Calculator cal = new Calculator();
		  
		  resultInteger =  cal.sub(a, b);
		  
		  Assert.assertEquals(resultInteger, res);
		  
	  }
	
	@Test(dataProvider = "dpSum")  
	  public void sum(long a, long b, long res) {

		  long resultInteger;
		  
		  Calculator cal = new Calculator();
		  
		  resultInteger =  cal.sum(a, b);
		  
		  Assert.assertEquals(resultInteger, res, "Invalid argument is ");
		  
	  }
//	@Test(dataProvider = "dpPow")
	
	@Test
	@Parameters({"paraPowA","paraPowB","paraPowR"})
	  public void pow(double a, double b, double res) {

		  double resultInteger;
		  
		  Calculator cal = new Calculator();
		  
		  resultInteger =  cal.pow(a, b);
		  
		  Assert.assertEquals(resultInteger, res);
		  
	  }
	
	@Parameters(value="paraSin")
	  public void sin(double a, double res) {

		  double resultInteger;
		  
		  Calculator cal = new Calculator();
		  
		  resultInteger =  cal.sin(a);
		  
		  Assert.assertEquals(resultInteger, res);
		  
	  }
 
  
  @BeforeMethod
  public void beforeMethod() {
	  
	WebDriver driver ;
		
	StringBuffer verificationErrors = new StringBuffer();
  }

  @AfterMethod
  public void afterMethod() {
	  /*String verificationErrorString = verificationErrors.toString();
	  if(!"".equalsIgnoreCase(verificationErrorString)){
		  System.out.println(verificationErrorString);
	  }*/
	  
	  System.out.println("All methods executed.");
  }


  @DataProvider
  public Object[][] dpDiv() {
    return new Object[][] {
      new Object[] { 100, 5, 29},
      new Object[] { 224, 7, 32 },
    };
  }
  
  @DataProvider
  public Object[][] dpSum() {
    return new Object[][] {
      new Object[] { 1000, 7000, 8001 },
      new Object[] { 1022, 71, 1099 },
    };
  }
  
  @DataProvider
  public Object[][] dpSub() {
    return new Object[][] {
      new Object[] { 2240, 7, 2232 },
      new Object[] { 9898, 7, 9893 },
    };
  }
  
  @DataProvider
  public Object[][] dpMul() {
    return new Object[][] {
      new Object[] { 224, 7000, 1568000 },
      new Object[] { 1111, 17, 18887},
    };
  }  
    
    
}
