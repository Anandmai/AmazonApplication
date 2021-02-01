	package Utility;
	import java.util.Date;
	import java.util.Properties;
	import java.util.UUID;
	import java.util.concurrent.TimeUnit;
	import java.io.BufferedReader;
	import java.io.File;
	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.io.IOException;
	import java.lang.reflect.Method;
	import java.net.URL;
	import java.text.SimpleDateFormat;
	import java.util.concurrent.TimeUnit;	
	import io.appium.java_client.AppiumDriver;
	import io.appium.java_client.MobileElement;
	import io.appium.java_client.TouchAction;
	import io.appium.java_client.android.AndroidDriver;
	import io.appium.java_client.ios.IOSDriver;
	import io.appium.java_client.touch.offset.PointOption;	
	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.By;
	import org.openqa.selenium.Dimension;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.ScreenOrientation;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.interactions.touch.TouchActions;
	import org.openqa.selenium.io.FileHandler;
	import org.openqa.selenium.remote.DesiredCapabilities;
	import org.openqa.selenium.remote.RemoteWebDriver;
	import io.appium.java_client.android.AndroidDriver;	
	import org.testng.Assert;
	import org.testng.ITestResult;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;	
	import com.relevantcodes.extentreports.ExtentReports;
	import com.relevantcodes.extentreports.ExtentTest;
	import com.relevantcodes.extentreports.LogStatus;
	import io.appium.java_client.TouchAction;
	import io.appium.java_client.android.AndroidElement;
	import io.appium.java_client.MultiTouchAction;
	import io.appium.java_client.TouchAction;
	import io.appium.java_client.android.AndroidDriver;
	import io.appium.java_client.android.AndroidElement;
	import org.openqa.selenium.Dimension; 
	import java.time.Duration; 
	import static io.appium.java_client.touch.TapOptions.tapOptions;
	import static io.appium.java_client.touch.WaitOptions.waitOptions;
	import static io.appium.java_client.touch.offset.ElementOption.element;
	import static io.appium.java_client.touch.offset.PointOption.point;
	import static java.time.Duration.ofMillis;
	import static java.time.Duration.ofSeconds;
	public class Resusablemethods {
		public static ExtentReports extent;
		public static AndroidDriver driver;
		public static ExtentTest logger;
		public static String textValue = "";
		public static String Imagepath="";
		public static Properties properties;
		private final static String constantproperties= System.getProperty("user.dir")+("\\src\\main\\java\\Resources\\constants.Property") ; 	
		
		public static	String Search_button="com.amazon.mShop.android.shopping:id/rs_search_src_text";
		/* Description: Reusable Method to Click
		 * Created By: Anand Mai 
		 * Attribute: String object passed for id or xpath		  
		 * 			  Report:Logger extent report
		 */
		public static void click(String object){
	
			if(driver.findElement(By.xpath(properties.getProperty(object))).isDisplayed()) {
				logger = extent.startTest("Clicked on"+object);
				driver.findElement(By.xpath(properties.getProperty(object))).click();
				Imagepath =	Resusablemethods.screenshot(properties.getProperty("Screeshot_path"));
				logger.log(LogStatus.PASS,logger.addScreenCapture(Imagepath) );							
				Assert.assertTrue(true);
				extent.endTest(logger);
			} 
			else{
				logger.log(LogStatus.PASS,logger.addScreenCapture(Imagepath) );							
				Assert.assertTrue(false);
				logger.log(LogStatus.FAIL, "Not clicked");					
			}					 
		}
	
		/* Description: Reusable Method to get screenshot
		 * Created By: Anand Mai 
		 * Attribute:  String object passed for id or xpath		  
		 * 			  Report:Logger extent report
		 */
		public static String screenshot(String path_screenshot){
			try {
				File srcFile=driver.getScreenshotAs(OutputType.FILE);
				String filename=UUID.randomUUID().toString(); 
				File targetFile=new File(path_screenshot  + filename +".png");
				//File finalDestination = new File(filename);
				FileUtils.copyFile(srcFile,targetFile);
				String Imagepath = "./screenshots/" + targetFile.getName();
				return Imagepath;
				//return targetfile.getname;
			}
			catch (IOException e) {
				e.printStackTrace();
				return Imagepath;}
		}
	
		/* Description: Reusable function to get result
		 * Created By: Anand Mai 
		 * Attribute:  
		 * 			  Report:Logger extent report
		 */
		public void getResult(ITestResult result){
			if(result.getStatus() == ITestResult.FAILURE){
				logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
				logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
			}else if(result.getStatus() == ITestResult.SKIP){
				logger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
	
			}	
		}
		/* Description: Reusable Method to click byName
		 * Created By: Anand Mai 
		 * Attribute:  String object passed for id or xpath		  
		 * 			  Report:Logger extent report
		 */
		public static void clickbyname(String object){	
			if(driver.findElementByName(object).isDisplayed()){
				logger = extent.startTest("Clicked on"+object);
	
				driver.findElementByName(object).click();
				Assert.assertTrue(true);
				logger.log(LogStatus.PASS, "Clicked successfully");
				extent.endTest(logger);			 
			} 
			else{
				logger.log(LogStatus.FAIL, "Not clicked");			
			}
	
		}
	
		/* Description: Reusable Method to clickbyid
		 * Created By: Anand Mai 
		 * Attribute:  String object passed for id   
		 * 			  Report:Logger extent report
		 */
		public static void clickbyid(String object){		
			if(driver.findElementById(object).isDisplayed()){
				logger = extent.startTest("Clicked on"+object);		
				driver.findElementById(object).click();
				Assert.assertTrue(true);
				logger.log(LogStatus.PASS, "Clicked successfully");
				Imagepath =	Resusablemethods.screenshot(properties.getProperty("Screeshot_path"));
				logger.log(LogStatus.PASS,logger.addScreenCapture(Imagepath) );
				//logger.log(LogStatus.PASS,logger.addScreenCapture(Imagepath) );
				extent.endTest(logger);
			} 
			else{
				logger.log(LogStatus.FAIL, "Not clicked");
	
			}
		}
	
		/* Description: Reusable Method to sendkeysbyID
		 * Created By: Anand Mai 
		 * Attribute:  String object passed for id   
		 * 			  Report:Logger extent report
		 */
		public static  void sendkeysbyID(String object,String data){	
			if(driver.findElementById(object).isDisplayed()){
				logger = extent.startTest("Clicked on"+object);		
				driver.findElementById(object).sendKeys(data);
				Assert.assertTrue(true);
				logger.log(LogStatus.PASS, "Clicked successfully");
	
				Imagepath =	Resusablemethods.screenshot(properties.getProperty("Screeshot_path"));
				logger.log(LogStatus.PASS,logger.addScreenCapture(Imagepath) );
				extent.endTest(logger);
			} 
			else{
				logger.log(LogStatus.FAIL, "Not clicked");			
			}				
		}
	
		/* Description: Reusable Method to sendkeysbyID
		 * Created By: Anand Mai 
		 * Attribute:  String object passed for Xpath   
		 * 			  Report:Logger extent report
		 */
		public void sendkeysbyxpath(String object,String data){
	
			if(driver.findElementByXPath(object).isDisplayed()){
				logger = extent.startTest("Clicked on"+object);		
				driver.findElementByXPath(object).sendKeys(data);
				Assert.assertTrue(true);
				logger.log(LogStatus.PASS, "Clicked successfully");			
				Imagepath =	Resusablemethods.screenshot(properties.getProperty("Screeshot_path"));
				logger.log(LogStatus.PASS,logger.addScreenCapture(Imagepath) );
				extent.endTest(logger);
			} 
			else{
				logger.log(LogStatus.FAIL, "Not clicked");			
			}	
		}
	
		/* Description: Reusable Method to clickbyxpath
		 * Created By: Anand Mai 
		 * Attribute:  String object passed for Xpath   
		 * 			  Report:Logger extent report
		 */
		public static void clickbyxpath(String object){
			if(driver.findElementByXPath(object).isDisplayed()){
				logger = extent.startTest("Clicked on"+object);		
				driver.findElementByXPath(object).click();;
				Assert.assertTrue(true);
				logger.log(LogStatus.PASS, "Clicked successfully");
				Imagepath =	Resusablemethods.screenshot(properties.getProperty("Screeshot_path"));
				logger.log(LogStatus.PASS,logger.addScreenCapture(Imagepath) );
	
				extent.endTest(logger);
			} 
			else{
				logger.log(LogStatus.FAIL, "Not clicked");			
			}	
	
		}
		/* Description: Reusable Method to clickbyxpath
		 * Created By: Anand Mai 
		 * Attribute:  String object passed for Xpath   
		 * 			  Report:Logger extent report
		 */
		public static void sendkeysbyname(String object,String data){
			if(driver.findElementByName(object).isDisplayed()){
				logger = extent.startTest("Clicked on"+object);		
				driver.findElementByName(object).sendKeys(data);
				Assert.assertTrue(true);
				logger.log(LogStatus.PASS, "Clicked successfully");
				Imagepath =	Resusablemethods.screenshot(properties.getProperty("Screeshot_path"));
				logger.log(LogStatus.PASS,logger.addScreenCapture(Imagepath) );
	
				extent.endTest(logger);
			} 
			else{
				logger.log(LogStatus.FAIL, "Not clicked");	
				Imagepath =	Resusablemethods.screenshot(properties.getProperty("Screeshot_path"));
				logger.log(LogStatus.PASS,logger.addScreenCapture(Imagepath) );
			}
		}
		/* Description: Reusable Method to getproduct detils
		 * Created By: Anand Mai 
		 * Attribute:  String object passed for Xpath   
		 * 			  Report:Logger extent report
		 */
	
		public static String getProductDetails(String object) {
			//String provalue=properties.getProperty("")
	
			try {
				textValue = driver.findElementByXPath(object).getText();
				logger = extent.startTest("Get product Details");	
				if (textValue != null) {
	
					Assert.assertTrue(true);
					logger.log(LogStatus.PASS, "got product details");
					extent.endTest(logger);
				}
				return textValue;
			} catch (Exception e) {
				e.printStackTrace();
				Assert.assertTrue(false);
				logger.log(LogStatus.FAIL, "Not clicked");	
			}
			return textValue;
		}
	
		public static void enterproductname() {
			//String provalue=properties.getProperty("")
	
			try {
				String Productname1 = ExcelReadData.getMapData("Productname");	
				System.out.println("Value of the keyword (search) is- "+Productname1);	
				Resusablemethods.sendkeysbyID(Search_button, Productname1);	
			}

			 catch (Exception e) {
				e.printStackTrace();
				
			}
			
		}
	
		
		
		/* Description: Reusable Method to Press  at given co-ordinates
		 * Created By: Anand Mai 
		 * Attribute:  x,y,seconds-codinates on the screen and time in seconds   
		 * 			  Report:Logger extent report
		 */
		public void pressByCoordinates (int x, int y, long seconds) {
			try {
				new TouchAction(driver)
				.press(point(x,y))
				.waitAction(waitOptions(ofSeconds(seconds)))
				.release()
				.perform();
			}
			catch(Exception e){
				System.out.println("Object Tapped");
			}
		}
		/* Description: Reusable Method to swipe by giving percentages
		 * Created By: Anand Mai 
		 * Attribute: input startPercentage,endPercentage ,anchorPercentage
		 * 			  Report:Logger extent report
		 */
		public void verticalSwipeByPercentage (double startPercentage, double endPercentage, double anchorPercentage) {
			Dimension size = driver.manage().window().getSize();
			int anchor = (int) (size.height * anchorPercentage);
			int startPoint = (int) (size.width * startPercentage);
			int endPoint = (int) (size.width * endPercentage);
	
			new TouchAction(driver)
			.press(point(startPoint, anchor))
			.waitAction(waitOptions(ofMillis(1000)))
			.moveTo(point(endPoint, anchor))
			.release().perform();
		}
		
		/* Description: Reusable Method to swipe
		 * Created By: Anand Mai 
		 * Attribute:  startElement,endElement 
		 * 			  Report:Logger extent report
		 */
		public static void swipeFullFromTopToBottom() {

			try {
				Thread.sleep(2000);
				Dimension scrnSize = driver.manage().window().getSize();
				int startx = (int) (scrnSize.width / 2);
				int endy = (int) (scrnSize.height*0.9);
				int starty = (int) (scrnSize.height * 0.2);


				(new TouchAction(driver))
				.press(point(startx, starty))
				.moveTo(point(startx, starty))
				.release()
				.perform();

			} catch (InterruptedException e) {
				Assert.assertTrue(false,e.getMessage());
			}



		}
	
		/* Description: Reusable Method to Tap  at given co-ordinates
		 * Created By: Anand Mai 
		 * Attribute:  x,y on the screen and time in seconds   
		 * 			  Report:Logger extent report
		 */
	
		public static void tapusingcordinates(String object , String data ,String data1)
		{
			try{
				TouchAction Action=new TouchAction(driver);
				int coordinate1 = Integer.parseInt(data);
				int coordinate2 = Integer.parseInt(data1);
				Action.tap(PointOption.point(coordinate1, coordinate2));
				System.out.println("Object Tapped");			
			}
			catch(Exception e){
				System.out.println("Object Tapped");
			}
		}
	
		/* Description: Reusable Method to enter data using adb commands for android
		 * Created By: Anand Mai 
		 * Attribute:  testdata Input
		 * 			  
		 */
		public static void adbsendkeys(String data) 
		{
			try{
				Runtime.getRuntime().exec("adb shell input text"+data );
			}
			catch(Exception e){
	
				System.out.println("Unknown exception");
			}
		}
		/* Description: Reusable Method to rotate screen
		 * Created By: Anand Mai 
		 * Attribute:   Input portrait or Landscape view in data
		 * 			  
		 */
		public void rotate(ScreenOrientation data) {
			try{
				//give portrait or Landscape view in data
				driver.rotate(data);
				driver.getOrientation();
				System.out.println("device rotated");
			}catch(Exception e)
			{
				Assert.assertTrue(false);
				logger.log(LogStatus.FAIL, "Not clicked");				
			}
		}
		/* Description: Reusable Method for Wait
		 * Created By: Anand Mai 
		 * Attribute:   Input wait time
		 * 			  
		 */
	
		public static void Wait() {
			try {
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			}catch(Exception e)
			{
				Assert.assertTrue(false);
				logger.log(LogStatus.FAIL, "Not clicked");				
			}
		}
	
		/* Description: Reusable Method to add screenshot
		 * Created By: Anand Mai 
		 * Attribute:   Input Screenshotpath
		 * 			  
		 */
	
		public static void Takescreenshot() {
			try {
				Imagepath =	Resusablemethods.screenshot(properties.getProperty("Screeshot_path"));
				logger.log(LogStatus.PASS,logger.addScreenCapture(Imagepath) );
			}
			catch(Exception e)
			{
				Assert.assertTrue(false);
				logger.log(LogStatus.FAIL, "Not clicked");				
			}
		}
		/* Description: Reusable Method to Start extent reports
		 * Created By: Anand Mai 
		 *
		 * 			  
		 */
	
		public static void startextentreports() {
			extent = new ExtentReports (System.getProperty("user.dir") +"/test-output/testextentreports.html", true);	
			extent
			.addSystemInfo("Host Name", "Amazon App")
			.addSystemInfo("Environment", "System Integration Testing")
			.addSystemInfo("User Name", "AnandMai");
			extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
		}
	
		/* Description: Reusable Method to give capabilities 
		 * Created By: Anand Mai 
		 *
		 * 			  
		 */
	
		public static  void capabilities() {
			try
			{
	
				DesiredCapabilities capabilities = new DesiredCapabilities();
	
				capabilities.setCapability("deviceName",properties.getProperty("deviceName"));
				capabilities.setCapability("platformVersion",properties.getProperty("platformVersion") );
				capabilities.setCapability("platformName", properties.getProperty("platformName"));			
				capabilities.setCapability("appPackage", properties.getProperty("appPackagename"));
				capabilities.setCapability("appActivity",properties.getProperty("appActivityname"));
				driver = new AndroidDriver(new URL("http://localhost:4725/wd/hub"), capabilities);
				Thread.sleep(10000);
				driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
				logger = extent.startTest("App launched");			
				Assert.assertTrue(true);
				logger.log(LogStatus.PASS, "App launched successfully");
				Imagepath =	Resusablemethods.screenshot(properties.getProperty("Screeshot_path"));
				logger.log(LogStatus.PASS,logger.addScreenCapture(Imagepath) );
			}   	 	
			catch(Exception e)
			{
				Assert.assertTrue(false);
				logger.log(LogStatus.FAIL, "Not clicked");	
				e.printStackTrace();
				return;
	
			}
		}
	
		/* Description: Reusable Method to read porperties file
		 * Created By: Anand Mai 
		 * Attribute:   Input Path of the file
		 * 			  
		 */
	
		public static void readproperties() {
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
	}
	
	
	
