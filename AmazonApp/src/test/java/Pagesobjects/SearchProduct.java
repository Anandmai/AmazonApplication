	package Pagesobjects;
	
	
	import org.testng.Assert;
	import org.testng.ITestResult;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;
	
	import com.relevantcodes.extentreports.LogStatus;
	
	//import Utility.ExcelUtils;
	import Utility.Resusablemethods;
	
	import Utility.ExcelReadData;
	public class SearchProduct extends MainDriver {
	public static String signin ="com.amazon.mShop.android.shopping:id/skip_sign_in_button";
	public static	String Search_button="com.amazon.mShop.android.shopping:id/rs_search_src_text";
	
		
		@BeforeTest	
		 public void beforetest() throws Exception {
				System.out.println("Search the Product");
		      }
			
			@Test
			public void searchanyproduct()
			{	
				
				try {
							
					String Productname1 = ExcelReadData.getMapData("Productname");	
					System.out.println("Value of the keyword (search) is- "+Productname1);
					
					Resusablemethods method =new Resusablemethods();
					//Click on Skip Signin 
				     method.clickbyid(signin);
					Thread.sleep(10000);
				    //Click on SerachButton
					method.clickbyid(Search_button);			
					method.wait();
				    //Click on SerachButton and Enter the Product
					method.sendkeysbyID(Search_button, Productname1);				
					System.out.println("Product Searched Successfully");		
					logger = extent.startTest("passTest");
				    Assert.assertTrue(true); 
				    logger.log(LogStatus.PASS, "Login Testcases Passed");
				    method.Takescreenshot();
				}
				
				catch (Exception e) {			
					e.printStackTrace();
				}
				
			    
				/* Description: Reusable function Add product to Cart
				 * Created By: Anand Mai 
				 * Attribute: report- Class object of Reporting to generate extent report
				 * 			  
				 */ 
				   AddtoCart.addtocart();
				   
					/* Description: Reusable function to validate the Cart
					 * Created By: Anand Mai 
					 * Attribute: report- Class object of Reporting to generate extent report
					 * 			  
					 */ 
			      CartPage.validatecart();
			    
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
			     //  driver.close();
					 //extent.endTest(logger);
					 }
				
		}
	
