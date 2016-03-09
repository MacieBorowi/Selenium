package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import basics.AbstractPageObject;

public class MainResultPage extends AbstractPageObject {

	@FindBy(className = "section-title--oneline")
	private List<WebElement> resultsBar;
	
	@FindBy(className = "not-found")
	private List<WebElement> noResult;

	public MainResultPage(WebDriver driver) {
		super(driver);
	}

	public String getSectionTitle(){
		String result = "";
		for (WebElement e : resultsBar) {
			if(e.getText().toUpperCase().startsWith("MAMY DLA CIEBIE")){
				result = e.getText();
			}
		}
		for (WebElement e : noResult) {
			//if(e.getText().toUpperCase().startsWith("MAMY DLA CIEBIE")){
				result = e.getText();
			//}
		}
		return result; 
	}

}
