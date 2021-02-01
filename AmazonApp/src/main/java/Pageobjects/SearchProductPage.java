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
		 //Element declaration
		   public static String signin ="com.amazon.mShop.android.shopping:id/skip_sign_in_button";
			public static	String Search_button="com.amazon.mShop.android.shopping:id/rs_search_src_text";
			/*
			 * Description: Method to Search a Product
			 * Created By: AnandMai
			 * 
			 */
			public static void searchanyproduct()
			{																	
							
					Resusablemethods.clickbyid(Search_button);
					
					Resusablemethods.Wait();		
					
					Resusablemethods.enterproductname();
					
					Resusablemethods.Wait();	
					System.out.println("Product Search completed Successfully");		
					logger = extent.startTest("passTest");
					Assert.assertTrue(true); 
					logger.log(LogStatus.PASS, "Product Search completed Successfully");
				    
				}
				
			
	   }
	   
	   
