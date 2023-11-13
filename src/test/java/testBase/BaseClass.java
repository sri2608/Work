package testBase;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;

//import java.util.ResourceBundle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass  {
	
	public static WebDriver driver;
	public Logger logger;
	//public ResourceBundle rr; It is for config.properties file where common data can be kept
	  
	@BeforeClass
	@Parameters("browser") 
	public void setup(String br){
		
		//rr=ResourceBundle.getBundle("config");
        logger = LogManager.getLogger(this.getClass());  //logging
		
		//ChromeOptions options=new ChromeOptions(); 
		//options.setExperimentalOption("excludeSwitches",new String[] {"enable-automation"});
		
		if(br.equals("chrome"))
		{
		driver=new ChromeDriver();
		}
		else if(br.equals("edge"))
		{
		driver = new EdgeDriver();
		}
		else
		{
		driver = new FirefoxDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//driver.get(rr.getString("appURL"));
		driver.get("https://www.saucedemo.com/");
		//driver.get("https://demo.opencart.com/index.php");
		
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown() {
		try {
            if (driver != null) {
                driver.quit();
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception as needed (log, report, etc.)
        }
	}
	
	
	public String captureScreen(String tname) throws IOException {
	String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());		
	TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
	File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
	String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

	try {
	FileUtils.copyFile(source, new File(destination));
	logger.info("Screenshot captured: " + destination);
	} catch (Exception e) {
	e.getMessage();
	}
	return destination;
	}
}
