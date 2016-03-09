package ldrygala.petclinic.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ldrygala.petclinic.AbstractPageObject;

public class FindOwnersPage extends AbstractPageObject {
	@FindBy(linkText="Add Owner")
	private WebElement addOwner;
	
	public FindOwnersPage(WebDriver driver) {
		super(driver);
	}
	
	public NewOwnerPage clickAddOwner() {
		addOwner.click();
		return PageFactory.initElements(driver, NewOwnerPage.class);
	}
	
}
