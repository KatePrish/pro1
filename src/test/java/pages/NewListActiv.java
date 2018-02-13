package pages;

import cucumber.api.DataTable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import stepDefinition.HelpSteps;

import java.util.List;
import java.util.stream.Collectors;

public class NewListActiv extends HelpSteps {

    public NewListActiv(WebDriver driver) {
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    @FindBy(how = How.XPATH, using = "//label[@class='control-label'][count(*)=1]")
    public List<WebElement> listDropDownNewActiv;

    public void listDropDownNewActiv(String name) {
        for (WebElement item : listDropDownNewActiv) {
            if (item.getText().equals(name)) {
                item.isDisplayed();
            }
        }
    }
/*
    @FindBy(how=How.XPATH, using = "//*[contains(@class, 'form-control ng-pristine ng-untouched')][@name='orgName']|//*[@class='form-control ng-pristine ng-untouched ng-invalid ng-invalid-required'][@name='assetFunctionalType']")
    public WebElement listDisabled;

    public void ListDisabledCheck()
*/

    @FindBy(how = How.XPATH, using = "//option[@label=\"Денежные средства\"]")
    public WebElement itemsDropDownList;

    public void itemsDropDownNewListPush(String name) throws InterruptedException {
        itemsDropDownList.click();
    }

    @FindAll({@FindBy(how=How.XPATH, using = "//a[contains(@data-toggle, 'tab')]")})
    public List<WebElement> navigationNewActive;

    public List<String> navigationNewActiveToList(){
     //   for()
        return navigationNewActive.stream().limit(13)
                .map(WebElement::getText).collect(Collectors.toList());
    }

    /*public void checkNavigationNewActive(List<String> element, DataTable table){

    }
*/
}
