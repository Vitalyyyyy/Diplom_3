import com.github.javafaker.Faker;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.LoginPage;
import pages.MainPage;

import java.time.Duration;

public class BaseTest {
    ChromeOptions options = new ChromeOptions().addArguments("--remote-allow-origins=*");
    private WebDriver driver = new ChromeDriver(options);
    private final String loginEmail = "Vitaly@mail.ru";
    private final String loginPassword = "1234567";
    Faker faker = new Faker();

    private final String email = faker.internet().emailAddress();
    private final String password = faker.internet().password(6, 10);
    private final String invalidPassword = faker.random().toString().substring(0, 5);
    private final String userName = faker.name().firstName();
    MainPage mainPage = new MainPage(driver);
    LoginPage loginPage = new LoginPage(driver);

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getInvalidPassword() {
        return invalidPassword;
    }

    public String getUserName() {
        return userName;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void openUrl() {
        driver.get(mainPage.getUrl());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    public void login() {
        loginPage.loginEnterFieldsAndClick(loginEmail, loginPassword);
    }

    public void clickPersonalAccount() {
        mainPage.clickPersonalAccount();
    }

    public void startRegistration() {
        loginPage.clickButtonFromStartRegistration();
    }
    public void clickEnterOnMainPage() {
        mainPage.clickEnterButton();
    }

    @After
    public void baseAfter() {
        driver.quit();
    }
}