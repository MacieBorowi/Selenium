package ceneo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import basics.AbstractSelenium;
import pages.BasketPage;
import pages.HomePage;
import pages.InfoPage;
import pages.SuppliersPage;
import pages.MainResultPage;

public class CeneoHomePageTest extends AbstractSelenium {

	private HomePage newHomePage;

	@Override
	@Before
	public void setUp() {
		super.setUp();
		newHomePage = openCeneo();
	}

	@Test
	public void shouldCeneoTitle() {
		assertTrue(newHomePage.getPageTitle().startsWith("Ceneo "));
	}

	@Test
	public void shouldFindQuery() {
		// given
		String query = "Audiobook";
		newHomePage.setSearchQuery(query);
		MainResultPage resultPage = newHomePage.clinkSearchButton();
		// then
		assertTrue(resultPage.getSectionTitle().contains("MAMY DLA CIEBIE "));
		assertTrue(resultPage.getSectionTitle().charAt(16) > 0);
	}

	@Test
	public void shouldNotFoundQuery() {
		// given
		String query = "AbAbAbAbAbAbAb";
		newHomePage.setSearchQuery(query);
		MainResultPage resultPage = newHomePage.clinkSearchButton();
		// then
		assertTrue(resultPage.getSectionTitle().contains("Niestety nic nie znaleziono"));
	}
	
	@Test
	public void shouldGetBasket() {
		BasketPage basket = newHomePage.clickGetBascetPage();
		System.out.println(basket.getPageTitle() + " sssss");
		assertTrue(basket.getPageTitle().contains("Złóż zamówienie"));
	}


	@Test
	public void shouldGetInfoTab() {
		InfoPage infoPage = newHomePage.clinkAboutButton();
		System.out.println(infoPage.getPageTitle());
		assertTrue(infoPage.getPageTitle().contains("Kim jesteśmy"));
	}

	@Test
	public void shouldGetSuppliersTab() {
		SuppliersPage suppliersPage = newHomePage.clickGetSuppliersPage();
		 assertEquals("Strefy producentów",suppliersPage.getSectionTitle());
	}

}
