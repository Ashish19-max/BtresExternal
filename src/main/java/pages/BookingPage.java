package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

import utility.ReadData;
import utility.TestUtil;

public class BookingPage {
    
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;
    
    
    
    @FindBy(xpath = "//button[contains(@class,'bkflghtnewadd') and contains(text(),'Book')]")
    private WebElement bookBtn;
    
    @FindBy(id = "UserInfos_0__Title")
    private WebElement titleDropdown;
    
    @FindBy(id = "UserInfos_0__FirstName")
    private WebElement firstNameTextbox;
    
    @FindBy(id = "UserInfos_0__LastName")
    private WebElement lastNameTextbox;
    
    @FindBy(id = "UserInfos_0__PaxDOB")
    private WebElement dobTextbox;
    
    @FindBy(id = "autocomp")
    private WebElement postcodeLookup;
    
    @FindBy(id = "AccountInfo_UserInfo_ContactNo")
    private WebElement mobileTextbox;
    
    @FindBy(id = "Email")
    private WebElement emailTextbox;
    
    @FindBy(xpath = "//span[@class='sp-check']")
    private WebElement termsCheckbox;
    
    @FindBy(id = "btnconfirm")
    private WebElement confirmBtn;
    
    @FindBy(id="btmPayments")  
    private WebElement proceedBtn;
    
    // Constructor that accepts WebDriver parameter
    public BookingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(20));
        js = (JavascriptExecutor) driver;
    }
    
    public void clickBookButton() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(bookBtn)).click();
        Thread.sleep(3000);
//        System.out.println("Booking Page Load Time: " + TestBase.getPageLoadTime(driver) + " ms");
        
    }
    
    public void fillPassengerDetails(String title, String firstName, String lastName, String dob) {
        Select titleSelect = new Select(titleDropdown);
        titleSelect.selectByVisibleText(title);
        
        firstNameTextbox.sendKeys(firstName);
        lastNameTextbox.sendKeys(lastName);
        dobTextbox.sendKeys(dob);
    }
 // ADD this new method for multiple passengers
    // === MULTIPLE PASSENGER METHODS ===
//    public void fillMultiplePassengerDetails() throws InterruptedException {
//        // Adult 1 (Index 0)
//        fillPassengerDetails(0, "Mr", "Shyam", "Kumar", "19/09/1996");
//
//        // Adult 2 (Index 1) 
//        fillPassengerDetails(1, "Mrs", "Priya", "Sharma", "15/05/1995");
//
//        // Adult 3 (Index 2)
//        fillPassengerDetails(2, "Mr", "Rahul", "Verma", "10/08/1996");
//
//        // Adult 4 (Index 3)
//        fillPassengerDetails(3, "Ms", "Anjali", "Singh", "22/03/1998");
//        
//        // Youth
//        fillPassengerDetails(4, "Mr", "Satyam", "Singh", "22/03/2010");
//        
//        // Child 1 (Index 4)
//        fillPassengerDetails(5, "Mr", "Rohan", "Sharma", "22/03/2015");
//
//        // Child 2 (Index 5)
//        fillPassengerDetails(6, "Ms", "Priya", "Gupta", "22/03/2015");
//        
//        // Infant 1 (Index 6)
//        fillPassengerDetails(7, "Mstr", "Aarav", "Gupta", "05/12/2024");
//    }
    public void fillMultiplePassengerDetails(String adults, String youth, String children, String infant) throws InterruptedException {
        int adultCount = Integer.parseInt(adults);
        int youthCount = Integer.parseInt(youth);
        int childCount = Integer.parseInt(children);
        int infantCount = Integer.parseInt(infant);
        
        int currentIndex = 0;
        
        // Fill Adult passengers
        for (int i = 0; i < adultCount; i++) {
            String[] names = {"John", "Jane", "Robert", "Maria", "David", "Sarah", "Michael", "Emma"};
            String[] lastNames = {"Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller", "Davis"};
            
            fillPassengerDetails(currentIndex, 
                               i % 2 == 0 ? "Mr" : "Mrs",
                               names[i % names.length],
                               lastNames[i % lastNames.length],
                               getValidAdultDOB());
            currentIndex++;
        }
        
        // Fill Youth passengers
        for (int i = 0; i < youthCount; i++) {
            String[] youthNames = {"Alex", "Sophia", "Ryan", "Olivia", "Daniel", "Ava"};
            String[] youthLastNames = {"Taylor", "Anderson", "Thomas", "Jackson", "White", "Harris"};
            
            fillPassengerDetails(currentIndex,
                             //  "Mr",
                               i % 2 == 0 ? "Mr" : "Ms",
                               youthNames[i % youthNames.length],
                               youthLastNames[i % youthLastNames.length],
                               getValidYouthDOB());
            currentIndex++;
        }
        
        // Fill Child passengers
        for (int i = 0; i < childCount; i++) {
            String[] childNames = {"Leo", "Mia", "Noah", "Zoe", "James", "Lily"};
            String[] childLastNames = {"Clark", "Lewis", "Walker", "Hall", "Young", "King"};
            
            fillPassengerDetails(currentIndex,
                               i % 2 == 0 ? "Mstr" : "Miss",
                               childNames[i % childNames.length],
                               childLastNames[i % childLastNames.length],
                               getValidChildDOB());
            currentIndex++;
        }
        
        // Fill Infant passengers
        for (int i = 0; i < infantCount; i++) {
            String[] infantNames = {"Ethan", "Isla", "Liam", "Ruby", "Oliver", "Chloe"};
            String[] infantLastNames = {"Scott", "Green", "Adams", "Nelson", "Baker", "Carter"};
            
            fillPassengerDetails(currentIndex,
                               //"Mstr",
            		            i % 2 == 0 ? "Mstr" : "Miss",
                               infantNames[i % infantNames.length],
                               infantLastNames[i % infantLastNames.length],
                               getValidInfantDOB());
            currentIndex++;
        }
    }

    // Helper methods for DOB generation - FIXED SYNTAX
   // FIXED: Valid date generation methods
    private String getValidAdultDOB() {
        // Adults: 18-65 years old (1999-1958)
        int year = 1958 + (int)(Math.random() * 41); // 1958-1999
        int month = 1 + (int)(Math.random() * 12);
        int day = getValidDayForMonth(month, year);
        return String.format("%02d/%02d/%d", day, month, year);
    }

    private String getValidYouthDOB() {
        // Youth: 12-15 years old (2010-2013)
        int year = 2010 + (int)(Math.random() * 4); // 2010-2013
        int month = 1 + (int)(Math.random() * 12);
        int day = getValidDayForMonth(month, year);
        return String.format("%02d/%02d/%d", day, month, year);
    }



    private String getValidChildDOB() {
        // Children: 2-11 years old (2014-2023)
        int year = 2014 + (int)(Math.random() * 10); // 2014-2023
        int month = 1 + (int)(Math.random() * 12);
        int day = getValidDayForMonth(month, year);
        return String.format("%02d/%02d/%d", day, month, year);
    }
    private String getValidInfantDOB() {
        // Infant: <2 years old (2023-2025)
        int year = 2023 + (int)(Math.random() * 3); // 2023-2025
        int month = 1 + (int)(Math.random() * 12);
        int day = getValidDayForMonth(month, year);
        return String.format("%02d/%02d/%d", day, month, year);
    }

    
 // NEW: Helper method to get valid days for each month
    private int getValidDayForMonth(int month, int year) {
        switch (month) {
            case 2: // February
                // Check for leap year
                boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
                return 1 + (int)(Math.random() * (isLeapYear ? 29 : 28));
            case 4: case 6: case 9: case 11: // April, June, September, November
                return 1 + (int)(Math.random() * 30);
            default: // All other months
                return 1 + (int)(Math.random() * 31);
        }
    }
    
 // === HELPER METHOD FOR MULTIPLE PASSENGERS ===
    public void fillPassengerDetails(int passengerIndex, String title, String firstName, String lastName, String dob) throws InterruptedException {
        js.executeScript("arguments[0].scrollIntoView(true);", 
            driver.findElement(By.xpath("//input[@id='UserInfos_" + passengerIndex + "__FirstName']")));
        
        // Title
        WebElement titleElement = driver.findElement(By.xpath("//select[@id='UserInfos_" + passengerIndex + "__Title']"));
        Select dropdown = new Select(titleElement);
        dropdown.selectByVisibleText(title);
        
        // First Name
        WebElement firstNameElement = driver.findElement(By.xpath("//input[@id='UserInfos_" + passengerIndex + "__FirstName']"));
        firstNameElement.clear();
        firstNameElement.sendKeys(firstName);
        
        // Last Name
        WebElement lastNameElement = driver.findElement(By.xpath("//input[@id='UserInfos_" + passengerIndex + "__LastName']"));
        lastNameElement.clear();
        lastNameElement.sendKeys(lastName);
        
        // Date of Birth
        WebElement dobElement = driver.findElement(By.xpath("//input[@id='UserInfos_" + passengerIndex + "__PaxDOB']"));
        dobElement.clear();
        dobElement.sendKeys(dob);
        
        Thread.sleep(500);
    }
    public void enterPostcode(String postcode) throws InterruptedException {
        js.executeScript("window.scrollBy(0, 800)");
        postcodeLookup.sendKeys(postcode);
        Thread.sleep(4000);
    }
    // ✅ NEW METHOD: Get postcode from config and call existing method
    public void enterPostcodeFromConfig() throws Exception {
        String postcode = ReadData.readPropertyFile("postcode");
        enterPostcode(postcode); // Call your existing method
        System.out.println("Entered postcode from config: " + postcode);
    }

    public void enterContactDetails(String mobile, String email) {
        js.executeScript("window.scrollBy(0, 1000)");
        
        mobileTextbox.clear();
        mobileTextbox.sendKeys(mobile);
        
        emailTextbox.clear();
        emailTextbox.sendKeys(email);
    }
 // ✅ ENTER CONTACT DETAILS FROM CONFIG
    public void enterContactDetailsFromConfig() throws Exception {
        String mobile = ReadData.readPropertyFile("mobile");
        String email = ReadData.readPropertyFile("email");
        enterContactDetails(mobile, email);
        System.out.println("Entered contact details from config - Mobile: " + mobile + ", Email: " + email);
    }
    
    public void acceptTerms() {
        js.executeScript("window.scrollBy(0, 1200)");
        termsCheckbox.click();
    }
    
    public void clickConfirm() throws InterruptedException {
        confirmBtn.click();
        Thread.sleep(5000);
    }
    
    public void clickProceedButton() {
        proceedBtn.click();
    }
    
    
    
    
    public String getBookingReference() {
//   WebElement bookingRefElement = driver.findElement(By.xpath("//span[contains(@class,'booking-reference')]"));//For option booking use this xpath
    	WebElement bookingRefElement = driver.findElement(By.xpath("//div[@id='CardDetailsDivdisplay']//span[contains(@class,'booking-reference')]"));//For card booking ref fetch
    	String fullText = bookingRefElement.getText();
        return fullText.replace("Booking Reference:", "").trim();
    }
    
    public void captureBookingDetails() throws InterruptedException, IOException {
        String bookingRef = getBookingReference();
        System.out.println("Booking Reference: " + bookingRef);
        
        TestUtil.copyToClipboard(bookingRef);
        System.out.println("Booking reference copied to clipboard!");
        
        TestUtil.takeScreenshot(driver, "booking_confirmation");
    }
    
    
    
}