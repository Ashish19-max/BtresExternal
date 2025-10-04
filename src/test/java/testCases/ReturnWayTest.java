package testCases;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

import base.TestBase;
import pages.BookingPage;
import pages.LoginPage;
import pages.SearchPage;

public class ReturnWayTest extends TestBase {
    
    @Test
    public void returnWayFlightBookingTest() throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        SearchPage searchPage = new SearchPage(driver);
        BookingPage bookingPage = new BookingPage(driver);
        
        // Login
        loginPage.loginToApplication();
        
        // Search return flight
        searchPage.scrollDown();
        searchPage.selectTripType("return");
        searchPage.enterSourceFromConfig();
        searchPage.enterDestinationFromConfig();
        searchPage.selectDepartDateFromConfig();
        searchPage.selectReturnDateFromConfig();
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
        
     // Extract RETURN flight details
        searchPage.extractAndPrintReturnFlightDetails();
        
        
     // === ADD FLIGHT DETAILS EXTRACTION HERE ===
        // Airline name
//        String airline = driver.findElement(By.xpath("//div[@class='airline-logo text-center airlogobt']//span[@class='graylight']")).getText();
//
//        // Departure details
//        String departureAirport = driver.findElement(By.xpath("(//div[@class='airline-logo text-center']//div[@class='flight-info_airport'])[1]")).getText().trim();
//        String departureTimeAndDate = driver.findElement(By.xpath("//div[@class='flight-info-travel']//div[@class='departure-time-dep']")).getText().trim();
//
//        // Arrival details
//        String arrivalAirport = driver.findElement(By.xpath("//div[@class='departing']//div[@class='flight-info_airport']")).getText().trim();
//        String arrivalTimeAndDate = driver.findElement(By.xpath("//div[@class='flight-info-travel']//div[@class='departure-time-ariv']")).getText().trim();
//
//        // Fare
//        String fare = driver.findElement(By.xpath("//div[@class='bookflight text-center']//h2")).getText().trim();
//
//        // Print results
//        System.out.println("Airline: " + airline);
//        System.out.println("Departure: " + departureAirport + " | " + departureTimeAndDate);
//        System.out.println("Arrival: " + arrivalAirport + " | " + arrivalTimeAndDate);
//        System.out.println("Fare: " + fare);
//
//        Thread.sleep(2000);
//        // === END OF FLIGHT DETAILS EXTRACTION ===
        // Book flight
        bookingPage.clickBookButton();
        bookingPage.fillPassengerDetails("Mr", "Shyam", "Kumar", "19/09/1996");
        
        bookingPage.enterPostcodeFromConfig();
        bookingPage.enterContactDetailsFromConfig();
        bookingPage.acceptTerms();
//        bookingPage.clickConfirm();
        bookingPage.captureBookingDetails();
        
        
        //bookingPage.clickProceedButton();
        // Add assertions or validations as needed
         Reporter.log("Booking process completed successfully.");
    }
}