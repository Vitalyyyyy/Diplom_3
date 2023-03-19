import io.qameta.allure.junit4.DisplayName;

import org.junit.Before;
import org.junit.Test;
import pages.MainPage;
import pages.PasswordPage;
import pages.RegistrationPage;

import static org.junit.Assert.assertEquals;

public class LoginPageTest extends BaseTest {

    MainPage mainPage = new MainPage(getDriver());
    RegistrationPage registrationPage = new RegistrationPage(getDriver());
    PasswordPage recoveryPasswordPage = new PasswordPage(getDriver());

    @Before
    public void openPage() {
        openUrl();
    }

    @Test
    @DisplayName("Проверка возможности успешного входа через кнопку войти в аккаунт на главной странице")
    public void loginOnMainPage() {
        mainPage.clickEnterButton();
        login();
        assertEquals("Оформить заказ", mainPage.buttonCreateOrderText());
    }

    @Test
    @DisplayName("Проверка возможности успешного входа через кнопку Личный кабинет")
    public void loginOnClickPersonalAccount() {
        mainPage.clickPersonalAccount();
        login();
        assertEquals("Оформить заказ", mainPage.buttonCreateOrderText());
    }

    @Test
    @DisplayName("Проверка возможности успешного входа через кнопку войти в форме регистрации")
    public void loginOnRegistrationForm() {
        clickPersonalAccount();
        startRegistration();
        mainPage.clickEnterOnRegistrationForm();
        login();
        assertEquals("Оформить заказ", mainPage.buttonCreateOrderText());
    }

    @Test
    @DisplayName("Проверка возможности успешного входа через кнопку войти в форме восстановления пароля")
    public void loginOnRefreshPasswordForm() {
        clickPersonalAccount();
        registrationPage.clickRecoveryPassword();
        recoveryPasswordPage.clickEnterButton();
        login();
        assertEquals("Оформить заказ", mainPage.buttonCreateOrderText());
    }

}

