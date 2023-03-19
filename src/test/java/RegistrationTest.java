

import com.github.javafaker.Faker;
import jdk.jfr.Description;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.LoginPage;
import pages.MainPage;
import pages.RegistrationPage;

import java.time.Duration;
import static org.junit.Assert.assertEquals;

public class RegistrationTest {
    ChromeOptions options = new ChromeOptions().addArguments("--remote-allow-origins=*");
    WebDriver driver = new ChromeDriver(options);
    MainPage mainPage = new MainPage(driver);
    RegistrationPage registrationPage = new RegistrationPage(driver);
    LoginPage loginPage = new LoginPage(driver);
    Faker faker = new Faker();
    private final String email = faker.internet().emailAddress();
    private final String validPassword = faker.internet().password(6,10);
    private final String invalidPassword = faker.random().toString().substring(0,5);
    private final String userName = faker.name().firstName();


    @Before
    public void setUp() {
        driver.get(mainPage.getUrl());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        mainPage.clickPersonalAccount();
        loginPage.clickButtonFromStartRegistration();

    }
    @Test
    @Description("Проверка успешной регистрации")
    public void successfullRegistration() {
        registrationPage.registrationInputFieldsAndClickButton(userName, email, validPassword);
        assertEquals("Регистрация не выполнена","Войти",loginPage.buttonEnterText());
    }
    @Test
    @Description("Проверка регистрации с невалидным паролем")
    public void registrationWithInvalidPassword() throws Exception {
        try {
            registrationPage.registrationInputFieldsAndClickButton(userName, email, invalidPassword);
            assertEquals("Регистрация не выполнена","Войти",loginPage.buttonEnterText());
        }
        catch (Exception exception) {
        }
        assertEquals("Регистрация выполнена","Некорректный пароль",loginPage.textUncorrectPassword());

    }
    @After
    public void quitDriver() {
        driver.quit();
    }
}