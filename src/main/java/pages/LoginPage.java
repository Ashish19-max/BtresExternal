package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;
import utility.ReadData;

public class LoginPage {
    
    WebDriver driver;
    WebDriverWait wait;
    
    @FindBy(xpath = "//span[@class='link-text'][1]") 
    private WebElement b2bUK;
    
    @FindBy(xpath = "//input[@id='UserId']") 
    private WebElement userIdTextbox;
    
    @FindBy(xpath = "//input[@id='Password']") 
    private WebElement passwordTextbox;
    
    @FindBy(xpath = "//input[@id='txtloggedUsername']") 
    private WebElement nameTextbox;
    
    @FindBy(xpath = "//button[normalize-space()='Login']") 
    private WebElement loginBtn1;
    
    @FindBy(xpath = "//input[@id='Otp']") 
    private WebElement otpTextbox;
    
    @FindBy(xpath = "//button[normalize-space()='Login']") 
    private WebElement loginBtn2;
    
    // Constructor that accepts WebDriver parameter
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(20));
    }
    
    public void loginToApplication() throws InterruptedException, IOException {
        wait.until(ExpectedConditions.elementToBeClickable(b2bUK)).click();
        
        // Country selection load time
//        System.out.println("Country selection Page Load Time: " + TestBase.getPageLoadTime(driver) + " ms");
        
        wait.until(ExpectedConditions.visibilityOf(userIdTextbox))
            .sendKeys(ReadData.readPropertyFile("username"));
        
        wait.until(ExpectedConditions.visibilityOf(passwordTextbox))
            .sendKeys(ReadData.readPropertyFile("password"));
        
        wait.until(ExpectedConditions.visibilityOf(nameTextbox))
            .sendKeys(ReadData.readPropertyFile("name"));
        
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn1)).click();
        Thread.sleep(2000);
        
        wait.until(ExpectedConditions.visibilityOf(otpTextbox))
            .sendKeys(ReadData.readPropertyFile("otp"));
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn2)).click();
        Thread.sleep(2000);
        
//        System.out.println("Login Load Time: " + TestBase.getPageLoadTime(driver) + " ms");
    }
}