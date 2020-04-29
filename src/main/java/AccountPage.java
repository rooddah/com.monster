import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AccountPage {
    private WebDriver driver;
    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }
    private final By emailInput = By.id("c_elem_0");
    private final By passwordInput = By.xpath("//input[@aria-labelledby='label-elem_1'][1]");
    private final By passwordReInput = By.xpath("//input[@aria-labelledby='label-elem_2'][1]");
    private final By checkbox = By.xpath("//span[@class='checkbox-custom checkbox-toggle']");
    private final By createBtn2 = By.xpath("//button[normalize-space()='Create an account']");

    WebElement getBtnCreate() {
        return driver.findElement(createBtn2);
    }

    WebElement getEmailInput() {
        return driver.findElement(emailInput);
    }

    WebElement getPass1Input() {
        return driver.findElement(passwordInput);
    }
    WebElement getPass2Input() {
        return driver.findElement(passwordReInput);
    }
    WebElement getCheckbox() {
        return driver.findElement(checkbox);
    }
    Select dropdownJobCorpsCenter() {
        return new Select(driver.findElement(By.id("elem_3")));
    }

    public void selectDropdown() {
        dropdownJobCorpsCenter().selectByIndex(1);
    }

    public void checkCheckbox() {
        if (getCheckbox() != null) {
            getCheckbox().click();
        }
    }

    public void enterPass(String pass) {
        if (getPass1Input() != null && getPass2Input() != null) {
            getPass1Input().sendKeys(pass);
            getPass2Input().sendKeys(pass);
        }
    }

    public void enterEmail(String email) {
        if (getEmailInput() != null) {
            getEmailInput().sendKeys(email);
        }
    }

    public void fillNecessaryFields(String email, String pass) throws Exception {
        enterEmail(email);
        enterPass(pass);
        selectDropdown();
        checkCheckbox();
    }

    public void clickCreate() {
        getBtnCreate().click();
    }

    public void createAccount(String email, String pass) throws Exception {
        fillNecessaryFields(email, pass);
        clickCreate();
    }
}
