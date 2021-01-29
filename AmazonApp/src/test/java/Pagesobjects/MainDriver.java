package Pagesobjects;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import Utility.Resusablemethods;
import io.appium.java_client.android.AndroidDriver;


public class MainDriver {	
	public static AndroidDriver driver;
	public static ExtentReports extent;
	public static ExtentTest logger;
	public static Properties properties;
	//private final String andriodproperties= System.getProperty("user.dir")+("\\src\\Utility\\Android.property") ;  
	private final String constantproperties= System.getProperty("user.dir")+("\\src\\test\\java\\Utility\\constants.Property") ; 
	
	public MainDriver(){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(constantproperties));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();		
			throw new RuntimeException("Configuration.properties not found at " + constantproperties);
		}
		}			
  @BeforeSuite
  public static void beforeSuite() throws Exception {	  
	 
		 Resusablemethods cap =new Resusablemethods();
		
		 cap.startextentreports();
		 
		 cap.capabilities();
  
}
	 @AfterSuite
	 public void endReport()
	 {
		 System.out.println("successfully closed");
	    }
   }

