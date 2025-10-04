package base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ReadData;

public class TestBase {
    
    public static WebDriver driver;
    
    // Page load time measurement method
//    public static long getPageLoadTime(WebDriver driver) {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        
//        try {
//            Long navigationStart = (Long) js.executeScript("return window.performance.timing.navigationStart;");
//            Long loadEventEnd = (Long) js.executeScript("return window.performance.timing.loadEventEnd;");
//            
//            if (navigationStart != null && loadEventEnd != null) {
//                return loadEventEnd - navigationStart; // in ms
//            }
//        } catch (Exception e) {
//            System.out.println("Could not measure page load time: " + e.getMessage());
//        }
//        return -1; // Return -1 if measurement fails
//    }
    
    @BeforeMethod
    public void initialization() throws IOException, InterruptedException {
        String browser = ReadData.readPropertyFile("browser");
        
        if(browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else if(browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get(ReadData.readPropertyFile("url"));
        // Homepage load time
//        System.out.println("Homepage Load Time: " + getPageLoadTime(driver) + " ms");
    }
    
    @AfterMethod
    public void tearDown() {
        if(driver != null) {
            driver.quit();
        }
    }
    
    // Getter method for driver (optional but good practice)
    public static WebDriver getDriver() {
        return driver;
    }
}