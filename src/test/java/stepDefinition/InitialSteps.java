package stepDefinition;

import cucumber.api.java.ru.Дано;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.ListActiv;
import pages.LoginForm;
import pages.NewListActiv;
import pages.header;

public class InitialSteps extends HelpSteps {

    static WebDriver driver;
    public static LoginForm loginForm;
    public static header headerForm;
    public static ListActiv listActiv;
    public static NewListActiv newListActiv;

    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("-incognito");
            options.addArguments("start-maximized");
            options.addArguments("dom.webnotifications.enabled");

            //  DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            //   capabilities.setCapability(ChromeOptions.CAPABILITY, options);

            driver = new ChromeDriver(options);
            loginForm = new LoginForm(driver);
            headerForm = new header(driver);
            listActiv = new ListActiv(driver);
            newListActiv = new NewListActiv(driver);
        }
        return driver;
    }

    @Дано("^открыт браузер и осуществлен переход по ссылке$")
    public void openBrowser(){
        driver=getDriver();
        driver.get("http://172.26.25.86:8081/sua/login");
    }

    @Дано("^браузер закрыт$")
    public void closeBrowser() throws InterruptedException{
        driver.quit();
        driver=null;
    }

    @Дано("^открыта ЭФ \"([^\"]*)\"$")
    public void открыта_ЭФ(String arg1) throws InterruptedException {
        Thread.sleep(1500);
        isDisplayedElement(arg1);
    }
}
