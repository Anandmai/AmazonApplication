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
	public static String signin ="com.amazon.mShop.android.shopping:id/skip_sign_in_button";
	public static	String Search_button="com.amazon.mShop.android.shopping:id/rs_search_src_text";

	@BeforeTest	
	public void beforetest()  {
		try {
			System.out.println("Starting Appium-launching the Application");	
			Resusablemethods cap =new Resusablemethods();
			/* Description: calling Reusable Method to read porperties
			 * Created By: Anand Mai 			 			  
			 */ 
			cap.readproperties();

			/* Description: calling Reusable Method to start Extent Reports
			 * Created By: Anand Mai 			 			  
			 */ 
			cap.startextentreports();		
			/* Description: calling Reusable Method to Start Appium and give capabilities
			 * Created By: Anand Mai 			 			  
			 */ 
			cap.capabilities();
		}
		catch(Exception e)
		{
			Assert.assertTrue(false);
			logger.log(LogStatus.FAIL, "Not clicked");				
		}
	}

	@Test
	public void searchanyproduct()
	{																	
		try {

			/* Description:calling Reusable Method for Login
			 * Created By: Anand Mai 
			 * Attribute: report- Class object of Reporting to generate extent report
			 * 			  
			 */ 
			LoginPage.ApplicationLogin();

			System.out.println("Login completed Successfully");		
			logger = extent.startTest("passTest");
			Assert.assertTrue(true); 
			logger.log(LogStatus.PASS, "Login Testcases Passed");
			/* Description: callingReusable Method to Search Any Product
			 * Created By: Anand Mai 
			 * Attribute: report- Class object of Reporting to generate extent report
			 * 			  
			 */ 
			SearchProductPage.searchanyproduct();

			System.out.println("Product Search completed Successfully");		
			logger = extent.startTest("passTest");
			Assert.assertTrue(true); 
			logger.log(LogStatus.PASS, "Product Search completed Successfully");
			/* Description:calling Reusable Method for Add product to Cart
			 * Created By: Anand Mai 
			 * Attribute: report- Class object of Reporting to generate extent report
			 * 			  
			 */ 

			AddToCartPage.addtocart();

			System.out.println("Add To cart completed Successfully");		
			logger = extent.startTest("passTest");
			Assert.assertTrue(true); 
			logger.log(LogStatus.PASS, "Add To cart completed Successfully");
			/* Description: calling Reusable Method to validate the Cart
			 * Created By: Anand Mai 
			 * Attribute: report- Class object of Reporting to generate extent report
			 * 			  
			 */ 

			CartComparision.validatecart();
			System.out.println("CartComparisionSuccessfully");		
			logger = extent.startTest("passTest");
			Assert.assertTrue(true); 
			logger.log(LogStatus.PASS, "Productscomparision completed Successfully");
		}

		catch (Exception e) {			
			e.printStackTrace();
		}

	}
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

