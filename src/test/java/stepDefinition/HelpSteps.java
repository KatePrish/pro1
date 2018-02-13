package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class HelpSteps {

    WebDriver driver=InitialSteps.getDriver();

    public void isDisplayedElement(String str){
        WebElement el = driver.findElement(By.xpath("//*[text()='"+str+"']"));
        (new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOf(el));
        isElementPresent(el, 30);
        //element.isDisplayed();
        assertTrue(el.getText().equalsIgnoreCase(str));
    }

    public boolean isElementPresent(WebElement elementName, int timeout)  {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            Thread.sleep(1000);
            wait.until(ExpectedConditions.visibilityOf(elementName));
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public void enterData(String id, String placeholder, String data){
        WebElement element = driver.findElement(By.xpath("//input[@id='"+id+"'][@placeholder='"+placeholder+"']"));
        element.clear();
        element.sendKeys(data);
    }

    public void pushButton(String name){
        WebElement element = driver.findElement(By.xpath("//button[text()='"+name+"']"));
        isElementPresent(element, 30);
        element.click();
    }

}
