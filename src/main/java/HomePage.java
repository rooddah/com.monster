import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private final By createAccount = By.xpath("//span[contains(text(),'CREATE ACCOUNT')]");

    WebElement getCreateAccountBtn() {
        return driver.findElement(createAccount);
    }

    public void clickCreateAccount() {
        if (getCreateAccountBtn() != null) {
            getCreateAccountBtn().click();
        }
    }

}
