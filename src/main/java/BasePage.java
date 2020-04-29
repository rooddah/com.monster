import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 3);
    }

    public WebElement getLink(String link) {
        return driver.findElement(By.linkText(link));
    }

    public void clickOnLink(String link) {
        getLink(link).click();
    }

    public WebElement topPanel(){
        return driver.findElement(By.xpath("//div[@class='navbar-collapse mobile-navbar']"));
    }

    public void selectJobOption(Dropdowns drop, String option) throws InterruptedException {
        Actions actions = new Actions(driver);
        By dropdwn = null;
        if (drop == Dropdowns.MY_JOB_SEARCH) {
            dropdwn = By.linkText("My Job Search");
        } else if (drop == Dropdowns.MY_CAREER_TOOLS) {
            dropdwn = By.linkText("My Career Tools");
        }
        actions.moveToElement(topPanel().findElement(dropdwn)).perform();
        Thread.sleep(1000);
        List<WebElement> options = driver.findElements(By.xpath("//ul[@class='dropdown-menu']//li"));
        for (WebElement opt : options) {
            if (opt.getText().trim().equals(option)) {
                actions.moveToElement(opt).click().perform();
                return;
            }
        }
        throw new NoSuchElementException("Can't find '" + option + "' in dropdown");
    }

    public enum Dropdowns {
        MY_JOB_SEARCH,
        MY_CAREER_TOOLS,
        RESOURCES;
    }

}
