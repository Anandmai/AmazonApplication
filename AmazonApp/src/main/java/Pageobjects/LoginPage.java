package Pageobjects;
		
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
import Utility.Resusablemethods;
import io.appium.java_client.android.AndroidDriver;
import Utility.ExcelReadData;
	   public class LoginPage extends Utility.Resusablemethods {
		   
		   public static String signin ="com.amazon.mShop.android.shopping:id/skip_sign_in_button";
			
			public static void ApplicationLogin()
			{																	
				try {
							
					
					Resusablemethods method =new Resusablemethods();
					/* Description: calling Reusable Method to Click and Signin
					 * Created By: Anand Mai 
					 * Attribute: report- Class object of Reporting to generate extent report
					 * 			  
					 */ 

				     method.clickbyid(signin);
					Thread.sleep(10000);
				    // method.wait();	
				     
					System.out.println("Product Searched Successfully");		
					logger = extent.startTest("passTest");
				    Assert.assertTrue(true); 
				    logger.log(LogStatus.PASS, "Login Testcases Passed");
				    method.Takescreenshot();
				}
				
				catch (Exception e) {			
					e.printStackTrace();
				}
							
			    
		}
			
	   }
	   
	   
