import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JobContactPanel {
    private WebDriver driver;

    public JobContactPanel(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement getJobCaption() {
        return driver.findElement(By.xpath("//header[@class='card-content job-caption']"));
    }

    private final By contactUsBtn = By.xpath("//button[@class='mux-btn btn-secondary btn-apply btn-block']");
    private final By save = By.cssSelector("#SaveButton");
    private final By email = By.cssSelector("#SaveJob");
    private final By saved = By.xpath("//span[@class='label'][contains(text(),'Saved')]");

    WebElement getContactUs() {
        return getJobCaption().findElement(contactUsBtn);
    }

    WebElement getSave() {
        return getJobCaption().findElement(save);
    }

    WebElement getEmail() {
        return getJobCaption().findElement(email);
    }

    WebElement saved() {
        return getJobCaption().findElement(saved);
    }

    public void clickSave() {
        if (getSave()!=null){
            getSave().click();
        }
    }

    public boolean isSaved() {
        if (saved().isDisplayed()) {
            return true;
        }
        return false;
    }


}
