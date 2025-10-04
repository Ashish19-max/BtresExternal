package testCases;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

import base.TestBase;
import pages.BookingPage;
import pages.LoginPage;
import pages.SearchPage;

public class OneWayTest extends TestBase {
    
    @Test
    public void oneWayFlightBookingTest() throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        SearchPage searchPage = new SearchPage(driver);
        BookingPage bookingPage = new BookingPage(driver);
        
        // Login
        loginPage.loginToApplication();
        
        // Search one-way flight
        searchPage.scrollDown();
        searchPage.selectTripType("oneway");
        searchPage.enterSourceFromConfig();
        searchPage.enterDestinationFromConfig();
        searchPage.selectDepartDateFromConfig();
        
        searchPage.selectTravelClass();
//        searchPage.selectAggregators();
        searchPage.clickSearchFlight();
        Thread.sleep(5000);
     // Use the new method that includes load time measurement
//        searchPage.searchFlightsAndMeasureLoadTime();
        
     // === SIMPLE SCROLLING ===
        searchPage.simpleScroll();
        
        //=====SelectSupplier====
        searchPage.selectSupplier();
        
        
        //=====Count Result========
        searchPage.countVisibleSearchResults();
        
        // === CALL MODAL TEST METHODS FROM SEARCHPAGE ===
        searchPage.testAllModals();
        // === END MODAL TESTING ===
        

        
        // Extract ONE-WAY flight details
        searchPage.extractAndPrintOneWayFlightDetails();
        
        // Book flight
        bookingPage.clickBookButton();
        bookingPage.fillPassengerDetails("Mr", "Ashish", "Kumar", "19/09/1989");
//        bookingPage.enterPostcode("tw3 1ua");
        bookingPage.enterPostcodeFromConfig();
        bookingPage.enterContactDetailsFromConfig();
        bookingPage.acceptTerms();
//        bookingPage.clickConfirm();
        bookingPage.captureBookingDetails();
        System.out.println("One-way flight booking test completed successfully!");
        
//        bookingPage.clickProceedButton();
     // Add assertions or validations as needed
        Reporter.log("Booking process completed successfully.");
    }
}