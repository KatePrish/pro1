package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import stepDefinition.InitialSteps;

import java.util.List;

public class LoginForm extends InitialSteps {


    public LoginForm(WebDriver driver) {
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    @FindBy(how = How.XPATH, using = "//input[@class='form-control']")
    public List<WebElement> loginForm;

    public void enterDataLoginForm(String fieldName, String value) {
        for (WebElement item : loginForm) {
            if (item.getAttribute("placeholder").equals(fieldName)) {
                item.clear();
                item.sendKeys(value);
            }
        }
    }

}
