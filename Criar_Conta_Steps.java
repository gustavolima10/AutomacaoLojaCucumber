package Steps;

import Runners.Runners;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.Random;
import java.util.Scanner;

public class Criar_Conta_Steps {

    @FindBy(xpath = "//a[@class='login']")
    protected WebElement login;

    @FindBy(xpath = "//form[@id='create-account_form']//span[1]")
    protected WebElement createAcount;

    @FindBy (xpath = "//input[@id='email_create']")
    protected WebElement campoEmail;

    @FindBy (xpath = "//h1[@class='page-heading']")
    protected WebElement nomeCreateAcount;

    @FindBy (xpath = "//h3[contains(text(),'Your personal information')]")
    protected WebElement nomeYourPersonal;

    @FindBy (xpath = "//input[@id='id_gender1']")
    protected WebElement btnMr;

    @FindBy (xpath = "//input[@id='id_gender2']")
    protected WebElement btnMrs;

    @FindBy (xpath = "//input[@id='customer_firstname']")
    protected WebElement first_name1;

    @FindBy (xpath = "//input[@id='customer_lastname']")
    protected WebElement last_name1;

    @FindBy (xpath = "//input[@id='email']")
    protected WebElement email22;

    @FindBy (xpath = "//input[@id='passwd']")
    protected WebElement password1;

    @FindBy (xpath = "//select[@id='days']")
    protected WebElement dayData;

    @FindBy (xpath = "//select[@id='months']")
    protected WebElement mesData;

    @FindBy (xpath = "//select[@id='years']")
    protected WebElement anoData;

    @FindBy (xpath = "//input[@id='newsletter']")
    protected WebElement btnNewlestter;

    @FindBy (xpath = "//input[@id='optin']")
    protected WebElement btnSpecialOffers;

    @FindBy (xpath = "//input[@id='firstname']")
    protected WebElement first_name02;

    @FindBy (xpath = "//input[@id='lastname']")
    protected WebElement last_name02;

    @FindBy (xpath = "//input[@id='address1']")
    protected WebElement adress1;

    @FindBy (xpath = "//input[@id='address2']")
    protected WebElement adress02;

    @FindBy (xpath = "//input[@id='city']")
    protected WebElement city1;

    @FindBy (xpath = "//select[@id='id_state']")
    protected WebElement btnState;

    @FindBy (xpath = "//input[@id='postcode']")
    protected WebElement zip_code1;

    @FindBy (xpath = "//select[@id='id_country']")
    protected WebElement btnCountry;

    @FindBy (xpath = "//textarea[@id='other']")
    protected WebElement additional_info1;

    @FindBy (xpath = "//input[@id='phone']")
    protected WebElement home_phone1;

    @FindBy (xpath = "//input[@id='phone_mobile']")
    protected WebElement mobile_phone1;

    @FindBy (xpath = "//input[@id='alias']")
    protected WebElement assign_adress1;

    @FindBy (xpath = "//span[contains(text(),'Register')]")
    protected WebElement btnRegister;

    @FindBy (xpath = "//p[@class='info-account']")
    protected WebElement msgSuesso;

    @FindBy (xpath = "//span[contains(text(),'Order history and details')]")
    protected WebElement btnOrderHistory;

    @FindBy (xpath = "//span[contains(text(),'My credit slips')]")
    protected WebElement btnMyCreditsSlips;

    @FindBy (xpath = "//span[contains(text(),'My addresses')]")
    protected WebElement btnMyAddress;

    @FindBy (xpath = "//span[contains(text(),'My personal information')]")
    protected WebElement btnMyPersonalInf;

    @FindBy (xpath = "//span[contains(text(),'My wishlists')]")
    protected WebElement btnMyWishlists;

    @FindBy (xpath = "//span[@class='address_name']")
    protected WebElement firstLastName;

    @FindBy (xpath = "//div[@class='columns-container']//li[5]")
    protected WebElement adressNew2;

    Random random = new Random();
    int numerosAleat = random.nextInt(1000);

    static WebDriver driver;
    String novoFirst;
    String novoAdress;

    @Given("^que acesso a aplicação$")
    public void que_acesso_a_aplicação() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver,  this);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[contains(text(),'0123-456-789')]")));
    }

    @When("^que acesso sign$")
    public void que_acesso_sign() {
        login.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        createAcount.click();

    }

    @When("informo email para cadastro")
    public void informoEmailParaCadastro() {
        campoEmail.sendKeys("Teste"+numerosAleat+"@teste.com");
        createAcount.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement until = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='page-heading']")));
        try {
            Thread.sleep(3000);
        }
        catch (InterruptedException ie){
        }

    }

    @When("informo os dados para cadastro {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
    public void informo_os_dados_para_cadastro(String first_name, String last_name, String password, String adress, String adress2, String city, String zip_code, String additional_info, String home_phone, String mobile_phone, String assign_adress) {
        btnMr.click();
        first_name1.sendKeys(first_name);
        novoFirst = first_name;
        last_name1.sendKeys(last_name);
        password1.sendKeys(password);
        new Select(dayData).selectByValue("10");
        new Select(mesData).selectByValue("5");
        new Select(anoData).selectByValue("1985");
        btnNewlestter.click();
        btnSpecialOffers.click();
        adress1.sendKeys(adress);
        adress02.sendKeys(adress2);
        city1.sendKeys(city);
        new Select(btnState).selectByVisibleText("Colorado");
        zip_code1.sendKeys(zip_code);
        new Select(btnCountry).selectByVisibleText("United States");
        additional_info1.sendKeys(additional_info);
        home_phone1.sendKeys(home_phone);
        mobile_phone1.sendKeys(mobile_phone);
        assign_adress1.clear();
        assign_adress1.sendKeys(assign_adress);
        novoAdress = assign_adress;
        btnRegister.click();
    }

    @Then("realizo cadastro com sucesso")
    public void realizo_cadastro_com_sucesso() {
        Assert.assertEquals("Welcome to your account. Here you can manage all of your personal information and orders.", msgSuesso.getText());
    }

    @Then("valido os dados cadastrados")
    public void validoOsDadosCadastrados() {
        try{
            Thread.sleep(3000);
        }
        catch (InterruptedException ie){
        }
        btnMyAddress.click();
        Assert.assertEquals(firstLastName.getText(), novoFirst );

    }

    @AfterClass

    public void quit(){
        driver.close();
        driver.quit();
    }

    public WebElement getLogin() {
        return login;
    }

    public void setLogin(WebElement login) {
        this.login = login;
    }
}