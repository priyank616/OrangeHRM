package basePackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utility.TimeUtils;

public class BaseHRMClass {
	//browser info WebDriver=new ChromeDriver(); 
		//url info
		//username and password
	public static Properties prop=new Properties();
	public static WebDriver driver;
	
	//step1
	public BaseHRMClass () {
		try {
		FileInputStream file=new FileInputStream("C:\\Users\\kirta\\Desktop\\priyank QA\\HRmanagement\\src\\test\\java\\environmentvariables\\Config.properties" );
		prop.load(file);
		
	}
		catch (FileNotFoundException e) {
				e.printStackTrace();
}
		catch(IOException a) {
			a.printStackTrace();}
		}
		//step2
		
		public static void initiation() {
	//drivers path webdriver.chromewebdriver
	//maximize pageload,implicit,getting url
		//if browser=chrome webdriver.chrome.driver
			//elseif (browser=firefox){
			//webdriver.gecko.driver
			String browsername=prop.getProperty("browser");
	if(browsername.equals("chrome")) { 
		 System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		 
		 driver=new ChromeDriver ();}
		 else if (browsername.equals("Firefox")) {
			 System.setProperty("webdriver.gecko.driver","geckodriver.exe");
		 }
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(TimeUtils.timepage,TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));
	}
	
		public static void screenshots(String Filename) {
			
			File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
			FileUtils.copyFileToDirectory(file, new File("C:\\Users\\kirta\\Desktop\\priyank QA\\HRmanagement\\src\\test\\java\\screenshots\\Screenshots"+ Filename+".jpg"));
		}
			catch (IOException e) {
				e.printStackTrace();
			}
			}
	}

