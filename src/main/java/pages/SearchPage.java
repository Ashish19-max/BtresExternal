package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;
import utility.ReadData;

public class SearchPage {
    
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;
    
    @FindBy(xpath = "//label[@for='radioOW']")
    private WebElement oneWayRadio;
    
    @FindBy(xpath = "//label[@for='radioRT']")
    private WebElement returnWayRadio;
    
    @FindBy(id = "txtSource")
    private WebElement sourceTextbox;
    
    @FindBy(id = "txtDestination")
    private WebElement destinationTextbox;
    
    @FindBy(id = "drpDepartDate")
    private WebElement departDatePicker;
    
    @FindBy(id = "drpReturnDate")
    private WebElement returnDatePicker;
    
    
    
//    @FindBy(xpath = "//span[@class='sp-check']")
//    private WebElement aggregatorsCheckbox;
    
    
 // === NEW PASSENGER SELECTION LOCATORS ===
    @FindBy(xpath = "//div[@class='adulginde']//select[@id='Adult']")
    private WebElement adultDropdown;
    
    @FindBy(xpath = "//div[@class='adulginde']//select[@id='Youth']")
    private WebElement youthDropdown;
    
    @FindBy(xpath = "//div[@class='adulginde']//select[@id='Child']")
    private WebElement childDropdown;
    
    @FindBy(xpath = "//div[@class='adulginde']//select[@id='Infant']")
    private WebElement infantDropdown;
    
    @FindBy(xpath = "//div[@class='adulgindeair']//select[@id='AirSegments_0__Class']")
    private WebElement travelClassDropdown;
    
    
    
 
    
    
    
 // === NEW LOCATORS FOR MODALS ===
    @FindBy(xpath = "//button[contains(@id, 'FareRulesModal_')]")
    private WebElement fareRulesBtn;
    
    @FindBy(xpath = "//div[contains(@id, 'FareRulesModal_')]")
    private WebElement fareRulesModal;
    
    @FindBy(xpath = "//div[contains(@id, 'FareRulesModal_')]//button[@type='button']")
    private WebElement closeFareRulesBtn;
    
    @FindBy(xpath = "//button[contains(@href, '#FltDetails_')]")
    private WebElement flightDetailsBtn;
    
    @FindBy(xpath = "//div[contains(@id, 'FltDetails_')]")
    private WebElement flightDetailsModal;
    
    @FindBy(xpath = "//div[contains(@id, 'FltDetails_')]//button[@type='button']")
    private WebElement closeFlightDetailsBtn;
    
    

    
    // === COMMON FLIGHT DETAILS LOCATORS ===
    @FindBy(xpath = "(//div[@class='row mar-none'])[1]")
    private WebElement firstFlightResult;
    
    // Fare details
    @FindBy(xpath = "(//div[@class='row mar-none'])[1]//div[@class='bookflight text-center']//h2")
    private WebElement fareElement;
    
    @FindBy(xpath = "(//div[@class='row mar-none'])[1]//span[@class='mahroon']/strong[contains(text(), 'PTC Type:')]")
    private WebElement ptcTypeElement;
    
    @FindBy(xpath = "(//div[@class='row mar-none'])[1]//span[@class='mahroon' and contains(@style, 'color: Blue')]/strong")
    private WebElement fareTypeElement;
    
    // === OUTBOUND FLIGHT LOCATORS ===
    @FindBy(xpath = "(//div[@class='row mar-none'])[1]//div[@class='flight-up-down clearfix'][1]")
    private WebElement outboundSection;
    
    @FindBy(xpath = "(//div[@class='row mar-none'])[1]//div[@class='flight-up-down clearfix'][1]//div[@class='airline-logo text-center airlogobt']//span[@class='graylight']")
    private WebElement outboundAirline;
    
    @FindBy(xpath = "(//div[@class='row mar-none'])[1]//div[@class='flight-up-down clearfix'][1]//div[@class='airline-logo text-center']/div[@class='flight-info_airport']")
    private WebElement outboundDepartureAirport;
    
    @FindBy(xpath = "(//div[@class='row mar-none'])[1]//div[@class='flight-up-down clearfix'][1]//div[@class='airline-logo text-center']/span[@class='graylight']")
    private WebElement outboundDepartureCity;
    
    @FindBy(xpath = "(//div[@class='row mar-none'])[1]//div[@class='flight-up-down clearfix'][1]//div[@class='departure-time-dep']")
    private WebElement outboundDepartureTime;
    
    @FindBy(xpath = "(//div[@class='row mar-none'])[1]//div[@class='flight-up-down clearfix'][1]//div[@class='departing']/div[@class='flight-info_airport']")
    private WebElement outboundArrivalAirport;
    
    @FindBy(xpath = "(//div[@class='row mar-none'])[1]//div[@class='flight-up-down clearfix'][1]//div[@class='departing']/span[@class='graylight']")
    private WebElement outboundArrivalCity;
    
    @FindBy(xpath = "(//div[@class='row mar-none'])[1]//div[@class='flight-up-down clearfix'][1]//div[@class='departure-time-ariv']")
    private WebElement outboundArrivalTime;
    
    @FindBy(xpath = "(//div[@class='row mar-none'])[1]//div[@class='flight-up-down clearfix'][1]//div[@class='aircrftfare']//small[@class='small-gray']")
    private WebElement outboundAircraft;
    
    @FindBy(xpath = "(//div[@class='row mar-none'])[1]//div[@class='flight-up-down clearfix'][1]//div[@class='classchoose']//small[@class='small-gray']")
    private WebElement outboundClass;
    
    @FindBy(xpath = "(//div[@class='row mar-none'])[1]//div[@class='flight-up-down clearfix'][1]//div[@class='baggachoose']//small[@class='small-gray']")
    private WebElement outboundBaggage;
    
    @FindBy(xpath = "(//div[@class='row mar-none'])[1]//div[@class='flight-up-down clearfix'][1]//div[@class='seatleft']//small[@class='small-gray']")
    private WebElement outboundSeats;
    
    @FindBy(xpath = "(//div[@class='row mar-none'])[1]//div[@class='flight-up-down clearfix'][1]//div[@class='milescls']//small[@class='small-gray']")
    private WebElement outboundMiles;
    
    // === INBOUND FLIGHT LOCATORS (Using more flexible XPaths) ===
    @FindBy(xpath = "(//div[@class='row mar-none'])[1]//div[contains(@class, 'flight-up-down')][2]")
    private WebElement inboundSection;
    
    @FindBy(xpath = "(//div[@class='row mar-none'])[1]//div[contains(@class, 'flight-up-down')][2]//div[contains(@class, 'airline-logo')]//span[@class='graylight']")
    private WebElement inboundAirline;
    
    @FindBy(xpath = "(//div[@class='row mar-none'])[1]//div[contains(@class, 'flight-up-down')][2]//div[contains(@class, 'airline-logo')]/div[@class='flight-info_airport']")
    private WebElement inboundDepartureAirport;
    
    @FindBy(xpath = "(//div[@class='row mar-none'])[1]//div[contains(@class, 'flight-up-down')][2]//div[contains(@class, 'airline-logo')]/span[@class='graylight']")
    private WebElement inboundDepartureCity;
    
    @FindBy(xpath = "(//div[@class='row mar-none'])[1]//div[contains(@class, 'flight-up-down')][2]//div[@class='departure-time-dep']")
    private WebElement inboundDepartureTime;
    
    @FindBy(xpath = "(//div[@class='row mar-none'])[1]//div[contains(@class, 'flight-up-down')][2]//div[@class='departing']/div[@class='flight-info_airport']")
    private WebElement inboundArrivalAirport;
    
    @FindBy(xpath = "(//div[@class='row mar-none'])[1]//div[contains(@class, 'flight-up-down')][2]//div[@class='departing']/span[@class='graylight']")
    private WebElement inboundArrivalCity;
    
    @FindBy(xpath = "(//div[@class='row mar-none'])[1]//div[contains(@class, 'flight-up-down')][2]//div[@class='departure-time-ariv']")
    private WebElement inboundArrivalTime;
    
    @FindBy(xpath = "(//div[@class='row mar-none'])[1]//div[contains(@class, 'flight-up-down')][2]//div[@class='aircrftfare']//small[@class='small-gray']")
    private WebElement inboundAircraft;
    
    @FindBy(xpath = "(//div[@class='row mar-none'])[1]//div[contains(@class, 'flight-up-down')][2]//div[@class='classchoose']//small[@class='small-gray']")
    private WebElement inboundClass;
    
    @FindBy(xpath = "(//div[@class='row mar-none'])[1]//div[contains(@class, 'flight-up-down')][2]//div[@class='baggachoose']//small[@class='small-gray']")
    private WebElement inboundBaggage;
    
    @FindBy(xpath = "(//div[@class='row mar-none'])[1]//div[contains(@class, 'flight-up-down')][2]//div[@class='seatleft']//small[@class='small-gray']")
    private WebElement inboundSeats;
    
    @FindBy(xpath = "(//div[@class='row mar-none'])[1]//div[contains(@class, 'flight-up-down')][2]//div[@class='milescls']//small[@class='small-gray']")
    private WebElement inboundMiles;
    
    @FindBy(xpath = "//button[@id='btnRTOW']")
    private WebElement searchFlightBtn;
    
    @FindBy(xpath = "//label[@for='suppGDS_0']//span[@class='checkbox-text' and normalize-space()='Galileo']")
    private WebElement supplier;
    
//    @FindBy(xpath = "//label[@for='suppGDS_0']//span[@class='checkbox-text' and normalize-space()='Sabre GDS']")
//    private WebElement supplier;
    
    // Constructor that accepts WebDriver parameter
    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(20));
        js = (JavascriptExecutor) driver;
    }
    
    public void scrollDown() {
        js.executeScript("window.scrollBy(0, 500)");
    }
    
    public void selectTripType(String tripType) {
        if(tripType.equalsIgnoreCase("oneway")) {
            oneWayRadio.click();
        } else {
            returnWayRadio.click();
        }
    }
    
    public void enterSource(String source) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(sourceTextbox)).click();
        sourceTextbox.sendKeys(source);
        Thread.sleep(2000);
        sourceTextbox.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
    }
    
    public void enterDestination(String destination) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(destinationTextbox)).click();
        destinationTextbox.sendKeys(destination);
        Thread.sleep(2000);
        destinationTextbox.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
    }
    
    // ✅ NEW OVERLOADED METHODS FOR CONFIG
    public void enterSourceFromConfig() throws Exception {
        String source = ReadData.readPropertyFile("source");
        enterSource(source); // Call the existing method
        System.out.println("Entered source from config: " + source);
    }
    
    public void enterDestinationFromConfig() throws Exception {
        String destination = ReadData.readPropertyFile("destination");
        enterDestination(destination); // Call the existing method
        System.out.println("Entered destination from config: " + destination);
    }
    
    public void selectDate(String dateField, String day, String month, String year) throws InterruptedException {
        WebElement datePicker = dateField.equalsIgnoreCase("depart") ? departDatePicker : returnDatePicker;
        datePicker.click();
        
        while(true) {
            String calendarMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
            String calendarYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
            
            if(calendarMonth.equalsIgnoreCase(month) && calendarYear.equals(year)) {
                List<WebElement> daysList = driver.findElements(By.xpath("//table/tbody/tr/td/a"));
                
                for(WebElement dayElement : daysList) {
                    if(dayElement.getText().equals(day)) {
                        dayElement.click();
                        break;
                    }
                }
                break;
            } else {
                driver.findElement(By.xpath("//a[@title='Next']")).click();
            }
        }
        Thread.sleep(1000);
    }
    // ✅ NEW OVERLOADED METHOD FOR DEPART DATE FROM CONFIG
    public void selectDepartDateFromConfig() throws Exception {
        String day = ReadData.readPropertyFile("departDay");
        String month = ReadData.readPropertyFile("departMonth");
        String year = ReadData.readPropertyFile("departYear");
        selectDate("depart", day, month, year);
        System.out.println("Selected depart date from config: " + day + " " + month + " " + year);
    }
    
    // ✅ NEW OVERLOADED METHOD FOR RETURN DATE FROM CONFIG
    public void selectReturnDateFromConfig() throws Exception {
        String day = ReadData.readPropertyFile("returnDay");
        String month = ReadData.readPropertyFile("returnMonth");
        String year = ReadData.readPropertyFile("returnYear");
        selectDate("return", day, month, year);
        System.out.println("Selected return date from config: " + day + " " + month + " " + year);
    }
//    public void selectAggregators() {
//        aggregatorsCheckbox.click();
//    }
    
    // === NEW PASSENGER METHODS ===
//    public void selectPassengerCounts(String adults,String youth, String children, String infant) throws InterruptedException {
//        Select selectAdult = new Select(adultDropdown);
//        selectAdult.selectByValue(adults);
//        
//        Select selectYouth = new Select(youthDropdown);
//        selectYouth.selectByValue(youth);
//        
//        
//        Select selectChild = new Select(childDropdown);
//        selectChild.selectByValue(children);
//        
//        Select selectInfant = new Select(infantDropdown);
//        selectInfant.selectByValue(infant);
//        
//        Thread.sleep(1000);
//    }
    
    public void selectPassengerCounts(String adults, String youth, String children, String infant) throws InterruptedException {
        // Select Adults
        if (adults != null && !adults.isEmpty()) {
            Select selectAdult = new Select(adultDropdown);
            selectAdult.selectByValue(adults);
            System.out.println("Selected " + adults + " adult(s)");
        }
        
        // Select Youth - FIXED: Use numeric values
     // Select Youth
        if (youth != null && !youth.isEmpty()) {
            Select selectYouth = new Select(youthDropdown);
            if (youth.equals("0")) {
                selectYouth.selectByVisibleText("Youth");
            } else {
                selectYouth.selectByValue(youth);
            }
            System.out.println("Selected " + youth + " youth passenger(s)");
        }
        
        
        // Select Children
        if (children != null && !children.isEmpty()) {
            Select selectChild = new Select(childDropdown);
            if (children.equals("0")) {
                selectChild.selectByVisibleText("Children");
            } else {
                selectChild.selectByValue(children);
            }
            System.out.println("Selected " + children + " child(ren)");
        }
        
     // Select Infant
        if (infant != null && !infant.isEmpty()) {
            Select selectInfant = new Select(infantDropdown);
            if (infant.equals("0")) {
                selectInfant.selectByVisibleText("Infant");
            } else {
                selectInfant.selectByValue(infant);
            }
            System.out.println("Selected " + infant + " infant(s)");
        }
        
        Thread.sleep(1000);
    }
    
    public void selectTravelClass() throws Exception {
        String travelClass = ReadData.readPropertyFile("travelClass");
        Select selectClass = new Select(travelClassDropdown);
        
        System.out.println("Selecting travel class: " + travelClass);
        
        switch(travelClass.toLowerCase()) {
            case "economy":
                selectClass.selectByIndex(0);
                break;
            case "premium economy":
            case "premiumeconomy":
                selectClass.selectByIndex(1);
                break;
            case "business":
                selectClass.selectByIndex(2);
                break;
            case "first":
                selectClass.selectByIndex(3);
                break;
            case "non":
            case "no preference":
                selectClass.selectByValue("Non");
                System.out.println("Selected: No Preference");
                break;
            default:
                System.out.println("Unknown travel class: " + travelClass + ". Defaulting to Economy.");
                selectClass.selectByIndex(0);
        }
        Thread.sleep(1000);
    }
    
    
    public void clickSearchFlight() {
        searchFlightBtn.click();
    }
    
 // Modified method to include search results load time
 //   public void searchFlightsAndMeasureLoadTime() throws InterruptedException {
 //       searchFlightBtn.click();
        
        // Wait for results to load and measure time
//        Thread.sleep(5000);
//        System.out.println("Search Results Page Load Time: " + TestBase.getPageLoadTime(driver) + " ms");
//    }
    
    
    public void selectSupplier()
    {
    	System.out.println("Supplier: " + supplier.getText().trim());
    	supplier.click();
    }
    
 // === VERY SIMPLE SCROLLING ===
    public void simpleScroll() throws InterruptedException {
        //System.out.println("Simple scrolling...");
        
        // Scroll to bottom
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(2000);
        
        // Scroll to top
        js.executeScript("window.scrollTo(0, 0)");
        Thread.sleep(2000);
    }

 // // === METHOD TO COUNT VISIBLE SEARCH RESULTS ON CURRENT PAGE (SIMPLE) ===
    public int countVisibleSearchResults() {
        try {
            List<WebElement> flightResults = driver.findElements(By.xpath("//div[@class='row mar-none']"));
            int visibleCount = 0;
            
            for (WebElement result : flightResults) {
                if (result.isDisplayed()) {
                    visibleCount++;
                }
            }
            
            // Simple highlighted output
            System.out.println("==========================================");
            System.out.println("\u001B[31m" + "VISIBLE RESULTS ON CURRENT PAGE: " + visibleCount+ "\u001B[0m");
            System.out.println("==========================================");
            
            return visibleCount;
        } catch (Exception e) {
            System.out.println("*** Error: " + e.getMessage() + " ***");
            return 0;
        }
    
    }
    
 // === NEW METHODS FOR MODAL TESTING ===
    
    public boolean testFareRulesModal() throws InterruptedException {
      //  fareRulesBtn.click();
        
    	// Wait for button to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(fareRulesBtn)).click();
        
        // Wait for modal to appear
        wait.until(ExpectedConditions.visibilityOf(fareRulesModal));
        boolean isVisible = fareRulesModal.isDisplayed();
        System.out.println("Fare Rules modal visible: " + isVisible);
        
        //closeFareRulesBtn.click();
        // Close modal
        wait.until(ExpectedConditions.elementToBeClickable(closeFareRulesBtn)).click();
        wait.until(ExpectedConditions.invisibilityOf(fareRulesModal));
        System.out.println("Fare Rules modal closed successfully");
        Thread.sleep(1000);
        
        return isVisible;
    }
    
    public boolean testFlightDetailsModal() throws InterruptedException {
       // flightDetailsBtn.click();
        
        // Wait for button to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(flightDetailsBtn)).click();
        
        // Wait for modal to appear
        wait.until(ExpectedConditions.visibilityOf(flightDetailsModal));
        boolean isVisible = flightDetailsModal.isDisplayed();
        System.out.println("Flight Details modal visible: " + isVisible);
        
       // closeFlightDetailsBtn.click();
        // Close modal
        wait.until(ExpectedConditions.elementToBeClickable(closeFlightDetailsBtn)).click();
        wait.until(ExpectedConditions.invisibilityOf(flightDetailsModal));
        System.out.println("Flight Details modal closed successfully");
        Thread.sleep(1000);
        
        return isVisible;
    }
    
    public void testAllModals() throws InterruptedException {
        System.out.println("=== TESTING FLIGHT MODALS ===");
        testFareRulesModal();
        testFlightDetailsModal();
    }
    
    


    
    
    // === NEW METHOD: EXTRACT ONE-WAY FLIGHT DETAILS ===
    public void extractAndPrintOneWayFlightDetails() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(firstFlightResult));
        
        System.out.println("=== ONE-WAY FLIGHT DETAILS ===");
        
        // OUTBOUND FLIGHT DETAILS
        System.out.println("--- Outbound Flight ---");
        printOutboundFlightDetails();
        
        // FARE DETAILS
        printFareDetails();
        
        System.out.println("=====================");
        Thread.sleep(2000);
    }
    
    // === NEW METHOD: EXTRACT RETURN FLIGHT DETAILS ===
    public void extractAndPrintReturnFlightDetails() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(firstFlightResult));
        
        System.out.println("=== RETURN FLIGHT DETAILS ===");
        
        // OUTBOUND FLIGHT DETAILS
        System.out.println("--- Outbound Flight ---");
        printOutboundFlightDetails();
        
        // INBOUND FLIGHT DETAILS
        System.out.println("--- Inbound Flight ---");
        printInboundFlightDetails();
        
        // FARE DETAILS
        printFareDetails();
        
        System.out.println("=====================");
        Thread.sleep(2000);
    }
    
    // === HELPER METHOD: PRINT OUTBOUND FLIGHT DETAILS ===
    private void printOutboundFlightDetails() {
        System.out.println("Airline: " + outboundAirline.getText().trim());
        System.out.println("Departure: " + outboundDepartureAirport.getText().trim() + " | " + outboundDepartureCity.getText().trim());
        System.out.println("Departure Time: " + outboundDepartureTime.getText().trim());
        System.out.println("Arrival: " + outboundArrivalAirport.getText().trim() + " | " + outboundArrivalCity.getText().trim());
        System.out.println("Arrival Time: " + outboundArrivalTime.getText().trim());
        System.out.println("Aircraft: " + outboundAircraft.getText().trim());
        System.out.println("Class: " + outboundClass.getText().trim());
        System.out.println("Baggage: " + outboundBaggage.getText().trim());
        System.out.println("Seats Left: " + outboundSeats.getText().trim());
        System.out.println("Miles: " + outboundMiles.getText().trim());
    }
    
    // === HELPER METHOD: PRINT INBOUND FLIGHT DETAILS ===
    private void printInboundFlightDetails() {
        System.out.println("Airline: " + inboundAirline.getText().trim());
        System.out.println("Departure: " + inboundDepartureAirport.getText().trim() + " | " + inboundDepartureCity.getText().trim());
        System.out.println("Departure Time: " + inboundDepartureTime.getText().trim());
        System.out.println("Arrival: " + inboundArrivalAirport.getText().trim() + " | " + inboundArrivalCity.getText().trim());
        System.out.println("Arrival Time: | " + inboundArrivalTime.getText().trim());
        System.out.println("Aircraft: " + inboundAircraft.getText().trim());
        System.out.println("Class: " + inboundClass.getText().trim());
        System.out.println("Baggage: " + inboundBaggage.getText().trim());
        System.out.println("Seats Left: " + inboundSeats.getText().trim());
        System.out.println("Miles: " + inboundMiles.getText().trim());
    }
    
    // === HELPER METHOD: PRINT FARE DETAILS ===
    private void printFareDetails() {
        System.out.println("--- Fare Details ---");
        System.out.println("Total Fare: " + fareElement.getText().trim());
//        System.out.println("PTC Type: " + ptcTypeElement.getText().replace("PTC Type: ", "").trim());
//        System.out.println("Fare Type: " + fareTypeElement.getText().trim());
    }
    

    
 
}
    

