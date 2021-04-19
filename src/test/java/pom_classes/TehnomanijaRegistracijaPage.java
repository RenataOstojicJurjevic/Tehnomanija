package pom_classes;

import org.apache.tools.ant.types.selectors.SelectSelector;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import sun.security.x509.OtherName;

import java.util.List;
import java.util.Random;

public class TehnomanijaRegistracijaPage extends TehnomanijaCommonPage {

    WebDriver driver;

    public TehnomanijaRegistracijaPage(WebDriver driver) {
    super(driver);
    this.driver = driver;
     PageFactory.initElements(driver,this);
    }


    private By title = By.id("title2");   //gospodin   //@FindBy (id = "title2")  WebElement title;
    @FindBy (xpath = "//input[@id='customer[first_name]']")
    WebElement firstName; //private By firstName = By.xpath("//input[@id='customer[first_name]']");
    @FindBy (xpath = "//input[@id='customer[last_name]']")
    WebElement lastName; //private By lastName = By.xpath("//input[@id='customer[last_name]']");
    @FindBy (xpath = "//input[@name='customer[email]']")
    WebElement email; //private By email = By.xpath("//input[@name='customer[email]']");
    @FindBy (xpath = "//input[@name='customer[confirm_email]']")
    WebElement confirmEmail; //private By confirmEmail = By.xpath("//input[@name='customer[confirm_email]']");
    @FindBy (xpath = "//input[@id='customer[password]']")
    WebElement password; //private By password = By.xpath("//input[@id='customer[password]']");
    @FindBy (xpath = "//input[@id='customer[confirm_password]']")
    WebElement confirmPassword; //private By confirmPassword = By.xpath("//input[@id='customer[confirm_password]']");
    @FindBy (xpath = "//input[@id='customer[mobile]']")
    WebElement mobilePhone; //private By mobilePhone = By.xpath("//input[@id='customer[mobile]']");
    @FindBy (xpath = "//input[@id='datepicker']")
    WebElement birthDate; //private By birthDate = By.xpath("//input[@id='datepicker']");


    private By street = By.cssSelector("[name='customer[street]']");
    private By streetList = By.xpath("//div[@id='search-autocomplete']");

    @FindBy (css = "[name='customer[street_number]']")
    WebElement streetNUmber; //private By streetNUmber = By.cssSelector("[name='customer[street_number]']");
    private By floor = By.cssSelector("[name='customer[floor]']");
    private By flat = By.cssSelector("[name='customer[flat]']");
    private By city = By.cssSelector("[name='customer[city]']");
    private By postCode = By.cssSelector("[name='customer[post_code]']");
    private By phone = By.cssSelector("[name='customer[phone]']");


    @FindBy (xpath = "//input[@id='accept_terms']")
    WebElement acceptTerms; // private By acceptTerms = By.xpath("//input[@id='accept_terms']"); //By.id("accept_terms");

    @FindBy (xpath = "//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")
    WebElement recaptcha; //private By recaptcha = By.xpath("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]"); //By.xpath("//span[@id='recaptcha-anchor']");

    private By pictures = By.id("#rc-imageselect");


    @FindBy (xpath = "//input[@name='Submit']")
    WebElement submit; //private By submit = By.xpath("//input[@name='Submit']");




    public void enterTitle() {
        //izbor  Gospođa, Gospodin
       driver.findElement(title).click();
       // clickElement(title);

    }

    public void enterFirstName() {
        String ime = randomName();
        typeText( firstName, ime);
        //driver.findElement(firstName).clear();
        //driver.findElement(firstName).sendKeys(ime);
    }


    public void enterLastName() {
        String prezime = randomSurname();
        typeText( lastName, prezime);
        //driver.findElement(lastName).clear();
        //driver.findElement(lastName).sendKeys(prezime);
    }




    public void enterRetypeEmail() {
        //Unos email-a
        String mail = randomEmail();
        typeText( email, mail);
        //Potvrda email-a
        typeText( confirmEmail, mail);

        // driver.findElement(email).clear();
        // driver.findElement(email).sendKeys(mail);
        // driver.findElement(confirmEmail).clear();
        // driver.findElement(confirmEmail).sendKeys(mail);
    }



    public void enterRetypePassword() {
        //Unos lozinke
        String lozinka = randomLozinka();
        typeText( password, lozinka);
        //Potvrda lozinke
        typeText( confirmPassword, lozinka);

        //driver.findElement(password).clear();
        //driver.findElement(password).sendKeys(lozinka);
        // driver.findElement(confirmPassword).clear();
        //driver.findElement(confirmPassword).sendKeys(lozinka);
    }



    public void enterPhoneNr() {
        String brojTel = randomPhoneNr();
        typeText( mobilePhone, brojTel);

        //driver.findElement(mobilePhone).clear();
       //driver.findElement(mobilePhone).sendKeys(brojTel);
    }




    public void enterBirthDate() {
        //unos datum rođenja. prvo klik da se pojavi kalendar
        //clickElement(birthDate);
        driver.findElement(By.xpath("//input[@id='datepicker']")).click();
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
    public void clickAcceptTerms() {
        clickElement(acceptTerms);
    }

    // new WebDriverWait(driver, 10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")));
    // new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.recaptcha-checkbox-checkmark"))).click();

    public void clickReCaptcha() {
        clickElement(recaptcha);
    }


    public void pickStreet(int indexToSelect) {
        driver.findElement(street).click();
        driver.findElement(street).clear();
        driver.findElement(street).sendKeys(Keys.ARROW_DOWN);

        List<WebElement> optionsToSelect = driver.findElements(By.xpath("//div[@id='mCSB_1']"));
        if(indexToSelect<optionsToSelect.size()) {
            optionsToSelect.get(indexToSelect).click();
        }
        else {
            int i = --indexToSelect;
            optionsToSelect.get(i).click();
        }
    }


    public void enterStreetNr( String streetNr){

        typeText( streetNUmber, streetNr);
       // driver.findElement(streetNUmber).click();
       // driver.findElement(streetNUmber).sendKeys(streetNr);


    }

    public void enterFloor( String floorNr){
        driver.findElement(floor).click();
        driver.findElement(floor).sendKeys(floorNr);
    }

    public void enterFlat( String flatNr){
        driver.findElement(flat).click();
        driver.findElement(flat).sendKeys(flatNr);
        driver.findElement(flat).sendKeys(Keys.TAB);
    }
    public void enterPhone(){
        driver.findElement(phone).click();
        driver.findElement(phone).sendKeys(randomPhoneNr());
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

        //Nakon pickStreet: Grad/Mesto  i Poštanski broj se popune automatski
        //pickStreet(1);

        enterStreetNr("5");
        enterFloor("4");
        enterFlat("3");
        enterPhone();

        //clickAcceptTerms();  //Slažem se sa Tehnomanija Politikom privatnosti ....
        clickReCaptcha();





    }


}
