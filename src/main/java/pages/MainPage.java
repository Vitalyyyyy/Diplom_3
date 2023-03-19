package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    // Кнопка "Личный кабинет"
    private final By personalAccount = By.xpath(".//p[text()='Личный Кабинет']");
    // Кнопка "Оформить заказ"
    private final By createOrder = By.xpath(".//button[text()='Оформить заказ']");
    // Кнопка Вход в форме регистрации
    private final By enterOnRegistrationForm = By.xpath(".//a[text()='Войти']");
    // Кнопка войти в аккаунт на главной странице
    private final By enterButton = By.xpath(".//button[text()='Войти в аккаунт']");
    // Надпись Соберите бургер на главной странице
    private final By chooseBurger = By.xpath(".//h1[text()='Соберите бургер']");
    // Кнопка Булки в конструкторе
    private final By breadButton = By.xpath(".//div/span[text()='Булки']");
    // Кнопка Соусы в конструкторе
    private final By sauceButton = By.xpath(".//div/span[text()='Соусы']");
    // Кнопка Начинки в конструкторе
    private final By filingsButton = By.xpath(".//div/span[text()='Начинки']");

    // Текст активной вкладки
    private static final By currentMenu = By.xpath("//div[contains(@class,'tab_tab__1SPyG tab_tab_type_current__2BEPc')]");

    // Получение текста секций с элементами
    private By textSectionBreads  = By.xpath("//h2[contains(text(),'Булки')]");
    private By textSectionSauces  = By.xpath("//h2[contains(text(),'Соусы')]");
    private By textSectionfillings  = By.xpath("//h2[contains(text(),'Начинки')]");

    private final WebDriver driver;
    private static final String url = "https://stellarburgers.nomoreparties.site/";



    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void clickPersonalAccount() {
        driver.findElement(personalAccount).click();
    }

    public void clickEnterOnRegistrationForm() {
        driver.findElement(enterOnRegistrationForm).click();
    }

    public void clickEnterButton() {
        driver.findElement(enterButton).click();
    }

    public String textOfChooseBurger() {
        return driver.findElement(chooseBurger).getText();
    }

    public String buttonCreateOrderText() {
        return driver.findElement(createOrder).getText();
    }

    public void clickBreadButton() {
        driver.findElement(breadButton).click();
    }

    public void clickSauceButton() {
        driver.findElement(sauceButton).click();
    }

    public void clickFilingsButton() {
        driver.findElement(filingsButton).click();
    }

    public String getCurrentMenu() {
        return driver.findElement(currentMenu).getText();
    }
    public String getTextSectionBreads() {
        return driver.findElement(textSectionBreads).getText();
    }
    public String getTextSectionSauces() {
        return driver.findElement(textSectionSauces).getText();
    }
    public String getTextSectionfillings() {
        return driver.findElement(textSectionfillings).getText();
    }


}
