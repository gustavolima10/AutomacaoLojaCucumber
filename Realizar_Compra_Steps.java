package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Realizar_Compra_Steps {

    @FindBy(xpath = "//a[@class='login']")
    protected WebElement login;

    @FindBy(xpath = "//input[@id='email']")
    protected WebElement cpInserirEmail;

    @FindBy(xpath = "//input[@id='passwd']")
    protected WebElement cpInserirSenha;

    @FindBy(xpath = "//p[@class='submit']//span[1]")
    protected WebElement btnSignIn;

    @FindBy(xpath = "//a[@class='sf-with-ul'][contains(text(),'Women')]")
    protected WebElement btnWomen;

    @FindBy(xpath = "//div[@class='block_content']//ul[@class='tree dynamized']//a[contains(text(),'Tops')]")
    protected WebElement btnTops;

    @FindBy(xpath = "//body[@id='category']/div[@id='page']/div[@class='columns-container']/div[@id='columns']/div[@class='row']/div[@id='left_column']/div[@id='categories_block_left']/div[@class='block_content']/ul[@class='tree dynamized']/li[@class='last']/a[1]")
    protected WebElement btnDresses;

    @FindBy(xpath = "//div[@id='subcategories']//li[2]//div[1]//a[1]//img[1]")
    protected WebElement btnSubCatDresses;

    @FindBy(xpath = "//li[@class='ajax_block_product col-xs-12 col-sm-6 col-md-4 first-in-line first-item-of-tablet-line first-item-of-mobile-line']//img[@class='replace-2x img-responsive']")
    protected WebElement imgDresses1;

    @FindBy(xpath = "//a[@class='btn btn-default button-plus product_quantity_up']")
    protected WebElement btnMais;

    @FindBy(xpath = "//select[@id='group_1']")
    protected WebElement selectSize;

    @FindBy(xpath = "//span[contains(text(),'Add to cart')]")
    protected WebElement btnAddCart;

    @FindBy(xpath = "//span[@class='continue btn btn-default button exclusive-medium']//span[1]")
    protected WebElement btnContinueShopping;

    @FindBy(xpath = "//span[contains(text(),'Proceed to checkout')]")
    protected WebElement btnProccedCheck;

    @FindBy(xpath = "//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]")
    protected WebElement btnProccedCheck2;

    @FindBy(xpath = "//textarea[@name='message']")
    protected WebElement cpInserirMsg;

    @FindBy(xpath = "//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]")
    protected WebElement btnProccedCheck3;

    @FindBy(xpath = "//input[@id='cgv']")
    protected WebElement cbxIAgree;

    @FindBy(xpath = "//p[@class='fancybox-error']")
    protected WebElement msgErrorIAgree;

    @FindBy(xpath = "//a[@class='fancybox-item fancybox-close']")
    protected WebElement msgCloseErrorIAgree;

    @FindBy(xpath = "//a[@class='bankwire']")
    protected WebElement btnPayMyBank;

    @FindBy(xpath = "//a[@class='cheque']")
    protected WebElement btnPayCjeck;

    @FindBy(xpath = "//span[contains(text(),'I confirm my order')]")
    protected WebElement btnIConfirm;

    @FindBy(xpath = "//strong[contains(text(),'Pradeep Macharla')]")
    protected WebElement msgConfirmBank;


    static WebDriver driver;

    @Given("acesso o site")
    public void acessoOSite() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver,  this);
        login.click();
        try{
            Thread.sleep(3000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        cpInserirEmail.sendKeys("teste333@teste.com");
        cpInserirSenha.sendKeys("123456");
        btnSignIn.click();
    }

    @When("seleciono um produto")
    public void selecionoUmProduto() {
        btnWomen.click();
        btnSubCatDresses.click();
        imgDresses1.click();
        try{
            Thread.sleep(3000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebDriverWait wait = new WebDriverWait(driver, 2);
        WebElement until = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#quantity_wanted_p > a.btn.btn-default.button-plus.product_quantity_up > span")));
        btnMais.click();
        new Select(selectSize).selectByValue("2");
        btnAddCart.click();


    }

    @When("realizo o checkout")
    public void realizoOCheckout() {
        btnProccedCheck.click();
        btnProccedCheck2.click();
        cpInserirMsg.sendKeys("Novo Produto");
        btnProccedCheck3.click();
        Assert.assertEquals("You must agree to the terms of service before continuing.", msgErrorIAgree.getText());
        msgCloseErrorIAgree.click();
        cbxIAgree.click();
        btnProccedCheck3.click();

    }
    @Then("finalizo a compra")
    public void finalizoACompra() {
        btnPayMyBank.click();
        btnIConfirm.click();
    }
    @Then("valido minhas compras")
    public void validoMinhasCompras() {
        Assert.assertEquals("Pradeep Macharla", msgConfirmBank.getText());

    }
}
