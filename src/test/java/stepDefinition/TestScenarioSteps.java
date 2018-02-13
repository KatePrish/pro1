package stepDefinition;

import cucumber.api.DataTable;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import cucumber.api.java.ru.То;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import junit.framework.Assert;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static stepDefinition.InitialSteps.*;

public class TestScenarioSteps extends HelpSteps {

    //11111
    @Когда("^пользователь вводит значение \"([^\"]*)\" в поле \"([^\"]*)\"$")
    public void пользователь_вводит_значение_в_поле(String data, String placeholder) {
        loginForm.enterDataLoginForm(placeholder, data);
    }

    @Когда("^пользователь нажимает кнопку \"([^\"]*)\"$")
    public void пользователь_нажимает_кнопку(String arg1) throws Throwable {
        pushButton(arg1);
    }

    @Когда("^пользователь выбирает финансовую организацию с названием \"([^\"]*)\"$")
    public void пользователь_выбирает_финансовую_организацию_с_названием(String arg1) throws InterruptedException {
        Thread.sleep(1000);
        WebElement element = driver.findElement(By.xpath("//td[@role='gridcell'][@title='"+arg1+"']"));
        element.click();
    }

    @Тогда("^открыта ЭФ с логотипом \"([^\"]*)\"$")
    public void открыта_ЭФ_с_логотипом(String arg1) throws Throwable {
        headerForm.checkLogo(arg1);
    }

    @Тогда("^открыта ЭФ с финансовой организацией \"([^\"]*)\"$")
    public void открыта_ЭФ_с_финансовой_организацией(String arg1) {
        headerForm.checkNameOrg(arg1);
    }

    @Тогда("^пользователь нажимает кнопку с выпадающим списком \"([^\"]*)\"$")
    public void пользователь_нажимает_кнопку_с_выпадающим_списком(String arg1)  {
        headerForm.navigationItemsPush(arg1);
    }

    @Тогда("^пользователь выбирает пункт \"([^\"]*)\"$")
    public void пользователь_выбирает_пункт(String arg1) throws InterruptedException {
        Thread.sleep(3000);
        headerForm.itemsDropDownListPush(arg1);
    }

    @То("^открыта ЭФ с названием \"([^\"]*)\"$")
    public void открыта_ЭФ_с_названием(String arg1) {
        listActiv.checkTitleListActive(arg1);
    }

    @То("^на странице присутствует выпадающий список \"([^\"]*)\"$")
    public void на_странице_присутствует_выпадающий_список(String arg1)  {
        newListActiv.listDropDownNewActiv(arg1);
    }
//можно сократить
    @То("^выпадающий список \"Наименование ФО\" недоступен для редактирования$")
    public void выпадающий_список_недоступен_для_редактирования() {
        WebElement element = driver.findElement(By.xpath("//*[@name='orgName']"));
        assertFalse(element.isEnabled());

    }
//можно сократить
    @То("^выпадающий список \"Тип актива функциональный\" доступен для редактирования$")
    public void выпадающий_список_доступен_для_редактирования() {
        WebElement element = driver.findElement(By.xpath("//*[@name='assetFunctionalType']"));
        assertTrue(element.isEnabled());
    }


    @То("^выпадающий список \"Наименование ФО\" заполнен наименованием текущей организации \"([^\"]*)\"$")
    public void выпадающий_список_заполнен_наименованием_текущей_организации(String arg1){
        WebElement element = driver.findElement(By.xpath("//*[@name='orgName']"));
        assertTrue(element.getAttribute("value").equalsIgnoreCase(arg1));
    }

    @Когда("^пользователь выбирает пункт выпадающего списка \"([^\"]*)\"$")
    public void пользователь_выбирает_пункт_выпадающего_списка(String arg1) throws InterruptedException {
        Thread.sleep(500);
        newListActiv.itemsDropDownNewListPush(arg1);
    }

    @Тогда("^на форме \"Карточка актива\" отображаются закладки$")
    public void на_форма_отображаются_закладки(DataTable table) throws Throwable {
        List<String> navigationItems = table.asList(String.class);
        assertEquals(navigationItems, newListActiv.navigationNewActiveToList());
    }
}
