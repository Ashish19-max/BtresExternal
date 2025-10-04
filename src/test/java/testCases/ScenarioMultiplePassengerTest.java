package testCases;

import org.testng.annotations.Test;

import base.TestBase;
import pages.BookingPage;
import pages.LoginPage;
import pages.SearchPage;

public class ScenarioMultiplePassengerTest extends TestBase {
	@Test
    public void adult4Child2Infant1FlightBookingTest() throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        SearchPage searchPage = new SearchPage(driver);
        BookingPage bookingPage = new BookingPage(driver);
        
        // Login
        loginPage.loginToApplication();
        
        // Search one-way flight
        searchPage.scrollDown();
        searchPage.selectTripType("return");
        searchPage.enterSourceFromConfig();
        Thread.sleep(4000);
        searchPage.enterDestinationFromConfig();
        Thread.sleep(4000);
        searchPage.selectDepartDateFromConfig();
        searchPage.selectReturnDateFromConfig();
        // Select passenger counts
        searchPage.selectPassengerCounts("2", "1", "2", "1");
        
        // Select travel class from config
        searchPage.selectTravelClass();
        
        searchPage.clickSearchFlight();
        Thread.sleep(5000);
        
        // Additional actions
        searchPage.simpleScroll();
        searchPage.selectSupplier();
        searchPage.countVisibleSearchResults();
        searchPage.testAllModals();
        searchPage.extractAndPrintOneWayFlightDetails();
        
        // Book flight
        bookingPage.clickBookButton();
        bookingPage.fillMultiplePassengerDetails("2", "1", "2", "1");
        bookingPage.enterPostcode("tw3 1ua");
        bookingPage.enterContactDetails("9545354708", "it.centre@brightsun.co.in");
//        bookingPage.acceptTerms();
        bookingPage.captureBookingDetails();
        
        System.out.println("Multiple passenger flight booking test completed successfully!");
    }
}
