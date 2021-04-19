package test;


import io.qameta.allure.Description;
import listeners.AllureTestNGListeners;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pom_classes.TehnomanijaHomePage;
import pom_classes.TehnomanijaRegistracijaPage;
import selenium_core.DriverManager;


import java.io.IOException;


@Listeners(AllureTestNGListeners.class)
public class TehnomanijaTests extends BaseTest{

    String URL = "https://www.tehnomanija.rs/";
    DriverManager driverManager;
    TehnomanijaRegistracijaPage tehnomanijaRegistracijaPage;
    TehnomanijaHomePage tehnomanijaHomePage;

    @BeforeMethod
    public void setup(){

        init(URL,30); //ovdje i browswer treba dodat
    }


    @Test(description="This is user registration test")
    @Description("Klik na PRIJAVA pa Registrujte se i popunjavanje polja za registraciju")
    public void registerToTehnomanija() throws IOException {
        tehnomanijaRegistracijaPage = new TehnomanijaRegistracijaPage(driver);
        tehnomanijaHomePage = new TehnomanijaHomePage(driver);

        tehnomanijaHomePage.checkTitle();
        tehnomanijaHomePage.checkPrijava();
        tehnomanijaHomePage.checkKorpa();
        tehnomanijaHomePage.clickCookies();
        tehnomanijaHomePage.checkSocialLinks();
        tehnomanijaHomePage.clickPrijava();
        tehnomanijaHomePage.clickRegistrujSe();
        tehnomanijaRegistracijaPage.checkRegistrationPage();
        tehnomanijaRegistracijaPage.checkSocialLinks();
        tehnomanijaRegistracijaPage.register();
        takeScreenshot("RegisterPage");

    /*
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("document.body.style.zoom = '0.5'");
        */
    }

    @AfterMethod
    public void tearDown(){
        //quitDriver();
    }
}
