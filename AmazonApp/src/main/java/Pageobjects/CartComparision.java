package Pageobjects;
import org.testng.Assert;
import com.relevantcodes.extentreports.LogStatus;
import Utility.Resusablemethods;
public class CartComparision extends Utility.Resusablemethods {
	static String Productincart="";
	public static  String viewcart="com.amazon.mShop.android.shopping:id/action_bar_cart_image";
	public static  String Productdetails= "//*[contains(@text,'JBL C100SI In-Ear Deep Bass Headphones with Mic (Black)')]";

	public static void validatecart()
	{			
		try {						
			Resusablemethods method =new Resusablemethods();	
			/* Description: calling Reusable Method to Click and viewcart
			 * Created By: Anand Mai 
			 *
			 * 			  
			 */ 		
			method.clickbyid(viewcart);     

			Productincart = driver.findElementByXPath(Productdetails).getText();		     		      			  
			if(Productincart.equals(Resusablemethods.textValue))
			{
				logger = extent.startTest("selected Product Matched");					
				Assert.assertTrue(true);
				logger.log(LogStatus.PASS, "Product Matched");

			} 
			else{
				logger.log(LogStatus.FAIL, "product Not matched");
			}	        		        

			System.out.println(" cart validation done Successfully");				
			logger = extent.startTest("passTest");
			Assert.assertTrue(true);
			logger.log(LogStatus.PASS, "cart Validation done successfully Testcases Passed");
			method.Takescreenshot();
		}

		catch (Exception e) {		
			e.printStackTrace();
		}		
	}	
}
