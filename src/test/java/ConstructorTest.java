import io.qameta.allure.junit4.DisplayName;

import org.junit.Before;
import org.junit.Test;
import pages.MainPage;

import static org.junit.Assert.assertEquals;

public class ConstructorTest extends BaseTest {
    MainPage mainPage = new MainPage(getDriver());

    @Before
    public void openPage() {
        openUrl();
    }

    @Test
    @DisplayName("Проверка перехода на вкладку Бургеры")
    public void clickOnBread() {
        mainPage.clickSauceButton();
        mainPage.clickBreadButton();
        assertEquals(mainPage.getTextSectionBreads(), mainPage.getCurrentMenu());
    }

    @Test
    @DisplayName("Проверка перехода на вкладку Соусы")
    public void clickOnSauce() {
        mainPage.clickSauceButton();
        assertEquals(mainPage.getTextSectionSauces(), mainPage.getCurrentMenu());
    }

    @Test
    @DisplayName("Проверка перехода на вкладку Начинки")
    public void clickOnFiling() {
        mainPage.clickFilingsButton();
        assertEquals(mainPage.getTextSectionfillings(), mainPage.getCurrentMenu());
    }

}