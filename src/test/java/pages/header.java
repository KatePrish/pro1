package pages;

import com.sun.org.apache.xml.internal.security.Init;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import stepDefinition.InitialSteps;

import java.util.List;

public class header extends InitialSteps{

    public header(WebDriver driver) {
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    @FindBy(how= How.XPATH, using="//img[@class='logo']")
    public WebElement logo;

    public void checkLogo(String title) {
        if(logo.getAttribute("title").equals(title)){
            logo.isDisplayed();
        }
    }

    @FindBy(how= How.XPATH, using="//span[@class='ng-binding']")
    public WebElement nameOrg;

    public void checkNameOrg(String name) {
        if(nameOrg.getText().equals(name)){
            nameOrg.isDisplayed();
        }
    }

    @FindBy(how=How.XPATH, using = "//li[@class='dropdown']//a[@class='dropdown-toggle']")
    public List<WebElement> navigationItems;

    public void navigationItemsPush(String name){
        for(WebElement item : navigationItems){
            isElementPresent(item, 30);
        }
        for(WebElement item : navigationItems){
            if(item.getText().equals(name)){
                item.click();
            }
        }
    }

    @FindBy(how=How.XPATH, using = "//li/a[contains(@sua-access, '.list')]")
    public List<WebElement> itemsDropDownList;

    public void itemsDropDownListPush(String name){
        for (WebElement item : itemsDropDownList){
            if(item.getText().equals(name)){
                item.click();
            }
        }
    }
}

