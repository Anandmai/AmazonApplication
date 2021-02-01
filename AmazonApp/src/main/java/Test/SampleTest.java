package Test;	
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import Pageobjects.AddToCartPage;
import Pageobjects.CartComparision;
import Pageobjects.LoginPage;
import Pageobjects.SearchProductPage;
import Utility.Resusablemethods;
import io.appium.java_client.android.AndroidDriver;
import Utility.ExcelReadData;

public class SampleTest extends Utility.Resusablemethods {	
	//Element declaration
	public static String signin ="com.amazon.mShop.android.shopping:id/skip_sign_in_button";
	public static	String Search_button="com.amazon.mShop.android.shopping:id/rs_search_src_text";

	/*
	 * Description: Constructor for initializing the class variables and the parent class
	 * Created By: Anand Mai
	 */
	@BeforeTest	
	public void beforetest()  {
		
			System.out.println("Starting Appium-launching the Application");				
			Resusablemethods.readproperties();		
			Resusablemethods.startextentreports();		
			Resusablemethods.capabilities();
		}
		
	/*
	 * Description: Test method for executing the Amazon App
	 * Created By: Anand Mai
	 */
	@Test
	public void Loginandsearchanyproduct()
	{																	
				
			LoginPage.ApplicationLogin();
			
			SearchProductPage.searchanyproduct();

			AddToCartPage.addtocart();

			CartComparision.validatecart();
			
		
		}

	/*
	 * Description: After Method to tear down the driver and check execution status
	 * Created By: Anand Mai
	 * Attribute: result - Class object of ITestResult to fetch the overall execution status
	 */
	@AfterMethod
	public void getResult(ITestResult result){
		if(result.getStatus() == ITestResult.FAILURE){
			logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
			logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
		}else if(result.getStatus() == ITestResult.SKIP){
			logger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());	 
		}		
		extent.flush();
		
	}

}

