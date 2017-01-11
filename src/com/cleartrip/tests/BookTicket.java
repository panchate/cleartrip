package com.cleartrip.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.cleartrip.pages.FlightListPage;
import com.cleartrip.pages.GuestDetailsPage;
import com.cleartrip.pages.HomePage;
import com.cleartrip.pages.ItineraryPage;
import com.cleartrip.pages.LoginPage;
import com.cleartrip.utils.PageObjectFactory;


public class BookTicket extends TestBase {
	HomePage homePage;
	FlightListPage flightListPage;
	ItineraryPage itineraryPage;
	LoginPage loginPage;
	GuestDetailsPage guestDetailsPage;

	@Test
	public void bookTicketScenario(){
		try{
			
			//home page
			homePage = PageObjectFactory.initializePage(driver, HomePage.class);
			Assert.assertEquals(homePage.isPageReady(driver), true);
			Assert.assertEquals(homePage.getSearchFrom().equals("Search flights"), true);
			homePage.selectTripType("roundtrip");
			homePage.selectFrom("Bangalore", driver);
			homePage.selectTo("Ahmedabad", driver);
			homePage.selectDepartDate("12", "August", "2017", driver);		
			Thread.sleep(2000);
			homePage.selectReturnDate("13", "August", "2017", driver);
			homePage.selectAdults("1");
			homePage.search();
			
			//select flight				
			flightListPage = PageObjectFactory.initializePage(driver, FlightListPage.class);
			Assert.assertEquals(flightListPage.isPageLoaded(driver), true);
			Thread.sleep(10000);			
			flightListPage.selectPriceNBook(driver);
			
			//Itinerary
			itineraryPage = PageObjectFactory.initializePage(driver, ItineraryPage.class);
			Assert.assertEquals(itineraryPage.isPageLoaded(driver), true);			
			itineraryPage.continueBooking();
			
			//login page
			loginPage = PageObjectFactory.initializePage(driver, LoginPage.class);
			Assert.assertEquals(loginPage.isPageLoaded(driver), true);			
			loginPage.setLoginDetails("xyz@abc.com");
			
			//Guest Details
			guestDetailsPage = PageObjectFactory.initializePage(driver, GuestDetailsPage.class);
			Assert.assertEquals(guestDetailsPage.isPageReady(driver), true);			
			guestDetailsPage.setTravellerDetails("Mr", "Tejas", "Panchal", "9999999999");
			
		}catch(Exception e){
			e.printStackTrace();
			Assert.assertTrue(false, e.getMessage());
		}
	}
}
