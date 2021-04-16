package pom_classes;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

public class TehnomanijaRegistracijaPage extends TehnomanijaCommonPage {

    WebDriver driver;

    public TehnomanijaRegistracijaPage(WebDriver driver) {
    super(driver);
        this.driver = driver;
    }



    private By title = By.id("title2");   //label[text()='Gospođa']  //input[@id='title1']
    private By firstName = By.xpath("//input[@id='customer[first_name]']");
    private By lastName = By.xpath("//input[@id='customer[last_name]']");
    private By email = By.xpath("//input[@name='customer[email]']");
    private By confirmEmail = By.xpath("//input[@name='customer[confirm_email]']");
    private By password = By.xpath("//input[@id='customer[password]']");
    private By confirmPassword = By.xpath("//input[@id='customer[confirm_password]']");
    private By mobilePhone = By.xpath("//input[@id='customer[mobile]']");
    private By birthDate = By.xpath("//input[@id='datepicker']");


    private By street = By.cssSelector("[name='customer[street]']");
    private By streetNUmber = By.cssSelector("[name='customer[street_number]']");
    private By floor = By.cssSelector("[name='customer[floor]']");
    private By flat = By.cssSelector("[name='customer[flat]']");
    private By city = By.cssSelector("[name='customer[city]']");
    private By postCode = By.cssSelector("[name='customer[post_code]']");
    private By phone = By.cssSelector("[name='customer[phone]']");

    private By acceptTerms = By.xpath("//input[@id='accept_terms']"); //By.id("accept_terms");
    private By recaptcha = By.xpath("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]"); //By.xpath("//span[@id='recaptcha-anchor']");
    private By submit = By.xpath("//input[@name='Submit']");




    public void enterTitle() {

        driver.findElement(title).click();
        //clickAnyField(title);
    }

    public void clickAnyField(By element) {

        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(element)));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(element)));
        driver.findElement(element).click();
    }

    public void enterFirstName() {
        String ime = randomName();
        driver.findElement(firstName).clear();
        driver.findElement(firstName).sendKeys(ime);
    }

    public String randomName() {
        Random r = new Random();
        int x = r.nextInt(10000);
        return "test" + x;
    }


    public void enterLastName() {
        String prezime = randomSurname();
        driver.findElement(firstName).clear();
        driver.findElement(firstName).sendKeys(prezime);
    }

    public String randomSurname() {
        Random r = new Random();
        int x = r.nextInt(10000);
        return "test" + x;
    }


    public void enterRetypeEmail() {
        //Unos email-a
        String mail = randomEmail();
        driver.findElement(email).clear();
        driver.findElement(email).sendKeys(mail);

        //Potvrda email-a
        driver.findElement(confirmEmail).clear();
        driver.findElement(confirmEmail).sendKeys(mail);
    }

    public String randomEmail() {
        Random r = new Random();
        int x = r.nextInt(10000);
        return "testmail" + x + "@gmail.com";
    }

    public void enterRetypePassword() {
        //Unos lozinke
        String lozinka = randomLozinka();
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(lozinka);

        //Potvrda lozinke
        driver.findElement(confirmPassword).clear();
        driver.findElement(confirmPassword).sendKeys(lozinka);
    }


    public String randomLozinka() {
        Random r = new Random();
        int x = r.nextInt(10000);
        return "Passwo" + x + "!";
    }


    public void enterPhoneNr() {
        String brojTel = randomPhoneNr();
        driver.findElement(mobilePhone).clear();
        driver.findElement(mobilePhone).sendKeys(brojTel);
    }

    public String randomPhoneNr() {
        Random r = new Random();
        int x = r.nextInt(10000);
        return "01" + x;
    }


    public void enterBirthDate() {
        //unos datum rođenja
        //klik na polje da se pojavi kalendar
        clickAnyField(birthDate);  //driver.findElement(By.xpath("//input[@id='datepicker']")).click();
        driver.findElement(By.xpath("//a[@class='ui-state-default']")).click();
        driver.findElement(By.xpath("//a[@class='ui-state-default']")).sendKeys(Keys.TAB);
    }

    public void checkRegistrationPage() {
        //provjera jesmo li na stranici https://www.tehnomanija.rs/index.php?mod=customers&op=register

        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL, "https://www.tehnomanija.rs/index.php?mod=customers&op=register");

        //provjera naslova stranice
        Assert.assertEquals(driver.getTitle(), "Registracija korisnika | Tehnomanija");

    }


    public void clickReCaptcha() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")));
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.recaptcha-checkbox-checkmark"))).click();

    }

    public void pickStreet(int indexToSelect) {
        List<WebElement> optionsToSelect = driver.findElements(street);
        if(indexToSelect<optionsToSelect.size()) {
            optionsToSelect.get(indexToSelect).click();
        }
        else {
            int i = --indexToSelect;
            optionsToSelect.get(i).click();
        }
    }

    public void register( )
    {


        enterTitle();
        enterFirstName();
        enterLastName();
        enterRetypeEmail();
        enterRetypePassword();
        enterPhoneNr();
        enterBirthDate();
        pickStreet(10);
        
        /*
        driver.findElement(By.cssSelector("[name='customer[street]']")).click();
        driver.findElement(By.cssSelector("[name='customer[street]']")).sendKeys("Neka ulica");
*/
        //Broj
        driver.findElement(By.cssSelector("[name='customer[street_number]']")).click();
        driver.findElement(By.cssSelector("[name='customer[street_number]']")).sendKeys("5");

        //Sprat

        driver.findElement(By.cssSelector("[name='customer[floor]']")).click();
        driver.findElement(By.cssSelector("[name='customer[floor]']")).sendKeys("1");

        //Broj stana

        driver.findElement(By.cssSelector("[name='customer[flat]']")).click();
        driver.findElement(By.cssSelector("[name='customer[flat]']")).sendKeys("3");

        driver.findElement(By.cssSelector("[name='customer[flat]']")).sendKeys(Keys.TAB);

        //Grad/Mesto  popuni se kad izabereš ulicu

        /*
        WebElement grad = driver.findElement(By.cssSelector("[name='customer[city]']"));

        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOf(grad));
        wait.until(ExpectedConditions.elementToBeClickable(grad));
        grad.sendKeys("Beograd");

        driver.findElement(By.cssSelector("[name='customer[city]']")).click();
        driver.findElement(By.cssSelector("[name='customer[city]']")).sendKeys("Beograd");
*/

        //driver.findElement(By.cssSelector("[name='customer[city]']")).sendKeys(Keys.TAB);

        //Poštanski broj

        driver.findElement(By.cssSelector("[name='customer[post_code]']")).click();
        driver.findElement(By.cssSelector("[name='customer[post_code]']")).sendKeys("11050");

        //Telefon

       driver.findElement(By.cssSelector("[name='customer[phone]']")).click();
       driver.findElement(By.cssSelector("[name='customer[phone]']")).sendKeys(randomPhoneNr());


        clickAnyField(acceptTerms);
        clickReCaptcha();


    }


//ovo je bolji način !!!!!!!!!!!!
    public void clickElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void typeText(WebElement element, String text){
        element.clear();
        element.sendKeys(text);
        element.sendKeys(Keys.ENTER);
    }
}
