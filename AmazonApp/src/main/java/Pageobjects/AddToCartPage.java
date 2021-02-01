package Pageobjects;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import Utility.Resusablemethods;

	public class AddToCartPage extends Utility.Resusablemethods {
		
		public static String selectproduct = "//*[@resource-id='com.amazon.mShop.android.shopping:id/iss_search_dropdown_item_text']";	
		public static  String selectpro="//*[@resource-id='com.amazon.mShop.android.shopping:id/rs_results_image']";	
		public static  String add_cart="//*[@resource-id='a-autoid-2']//*[@class='android.widget.Button']";
		public static  String viewcart="com.amazon.mShop.android.shopping:id/action_bar_cart_image";
		public static  String productdetails= "//*[contains(@text,'JBL C100SI In-Ear Deep Bass Headphones with Mic (Black)')]";
		  /*
		 * Description: Method to Ad Product to cart
		 * Created By: AnandMai
		 * 
		 */
		public static void addtocart()
		{	
			
				
	
				Resusablemethods.clickbyxpath(selectproduct);
			
	
				Resusablemethods.clickbyxpath(selectpro);
				
				
				Resusablemethods.getProductDetails(productdetails);
				
				
				Resusablemethods.swipeFullFromTopToBottom();
				
				Resusablemethods.clickbyxpath(add_cart);
				
				 System.out.println("Product Added to cart Successfully");				
			 		logger = extent.startTest("passTest");
			 	    Assert.assertTrue(true);
			 	    logger.log(LogStatus.PASS, "Add to Cart Testcases Passed");
			 	   Resusablemethods.Takescreenshot();						
			}		
			
		    
	}
	
	
