package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.FindsByLinkText;
import org.openqa.selenium.support.FindBy;

import basics.AbstractPageObject;

public class SuppliersPage extends AbstractPageObject{
	
	//@FindBy(className="section-title")
	private WebElement info;
	
	public SuppliersPage(WebDriver driver) {
		super(driver);
	}
	
	public String getSectionTitle(){
//		System.out.println("info.getTagName() : " + info.getTagName());
//		System.out.println("info.getText() : " + info.getText());
//		System.out.println("info.toString() : " + info.toString());
		System.out.println("in secion title suppliers");
		return "AAAA";//info.toString(); //driver.findElement(FindsByLinkText,"");
	}

}
