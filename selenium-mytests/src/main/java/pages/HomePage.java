package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basics.AbstractPageObject;

public class HomePage extends AbstractPageObject {
	private Actions actions;

	@FindBy(id = "form-head-search-q")
	private WebElement findQuery;
	
	@FindBy(className = "header-search-form-button")
	private List<WebElement> searchButton;
	
	@FindBy(className = "shopping-cart--icon")
	private List<WebElement> bascetIcon;

	@FindBy(partialLinkText = "O nas, kontakt")
	private WebElement about;

	@FindBy(partialLinkText = "Katalog producentów")
	private List<WebElement> prod;

	@FindBy(className = "dotted-link")
	private List<WebElement> linkAbout;

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver.get("http://www.ceneo.pl/");
		this.actions = new Actions(driver);
	}

	public HomePage setSearchQuery(String query) {
		this.findQuery.sendKeys(query);
		return this;
	}
	
	public MainResultPage clinkSearchButton() {
		for (WebElement search : searchButton) {
			if(search.getAttribute("type").equals("submit")){	
				actions.click(search).perform();	
			}			
		}
		return PageFactory.initElements(driver, MainResultPage.class);
	}
	
	public InfoPage clinkAboutButton() {
		// System.out.println("e.getTagName() : " + about.getTagName());
		// System.out.println("e.getText() : " + about.getText());
		// System.out.println("e.toString() : " + about.toString());
		// System.out.println("e.toString() : " + about.getAttribute("href"));
		// driver.findElement(By.partialLinkText("O nas, kontakt")).click();
		// actions.click(about).perform();
		
		driver.get(about.getAttribute("href"));
		return PageFactory.initElements(driver, InfoPage.class);
	}

	public SuppliersPage clickGetSuppliersPage() {
		for (WebElement e : prod) {

			if (e.getText().contains("Katalog producentów")) {
				System.out.println("Producenci text");
				 //actions.click(e).perform();
			}

			for (WebElement f : linkAbout) {
				if (f.getText().contains("Katalog producentów")) {
					System.out.println("Producenci class");
					//actions.click(f).perform();
				}
			}
		}
		return PageFactory.initElements(driver, SuppliersPage.class);
	}
	
	public BasketPage clickGetBascetPage() {
		for (WebElement g : bascetIcon) {
			if (g.getText().contains("Koszyk")) {
				actions.click(g).perform();
				actions.click( driver.findElement(By.name("/checkout"))).perform();
				//???
			}
		}
		return PageFactory.initElements(driver, BasketPage.class);
	}

}
