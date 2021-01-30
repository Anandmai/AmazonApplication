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
	//import Utility.ExcelUtils;
import Utility.Resusablemethods;
import io.appium.java_client.android.AndroidDriver;
import Utility.ExcelReadData;
	   public class SearchProductPage extends Utility.Resusablemethods {
			
		   public static String signin ="com.amazon.mShop.android.shopping:id/skip_sign_in_button";
			public static	String Search_button="com.amazon.mShop.android.shopping:id/rs_search_src_text";
			public static void searchanyproduct()
			{																	
				try {
							
					String Productname1 = ExcelReadData.getMapData("Productname");	
					System.out.println("Value of the keyword (search) is- "+Productname1);	
					Resusablemethods method =new Resusablemethods();
					/* Description: calling Reusable Method to Click 
					 * Created By: Anand Mai 
					 *							  
					 */ 
					method.clickbyid(Search_button);
					
					method.wait();					
					/* Description: calling Reusable Method to Click and send input
					 * Created By: Anand Mai 
					 * Attribute: Input ProductName
					 * 			  
					 */ 
					method.sendkeysbyID(Search_button, Productname1);	
					//Thread.sleep(10000);
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
	   
	   
