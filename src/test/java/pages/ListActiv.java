package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import stepDefinition.HelpSteps;
import static org.junit.Assert.assertEquals;

public class ListActiv extends HelpSteps {

    public ListActiv(WebDriver driver) {
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    @FindBy(how= How.XPATH, using = "//form/ol//*")
    public WebElement titleListActiv;

    public void checkTitleListActive(String title){
        if(titleListActiv.getText().equals(title)){
            isElementPresent(titleListActiv, 50);
            assertEquals(titleListActiv.getText(), title);

        }

    }

}
