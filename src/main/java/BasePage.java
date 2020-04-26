import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasePage {
    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
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

    public void selectJobOption(Dropdowns drop, String option) {
        By dropdwn = null;
        if (drop == Dropdowns.MY_JOB_SEARCH) {
            dropdwn = By.linkText("My Job Search");
        } else if (drop == Dropdowns.MY_CAREER_TOOLS) {
            dropdwn = By.linkText("My Career Tools");
        }
        topPanel().findElement(dropdwn).click();
        List<WebElement> options = driver.findElements(By.xpath("//ul[@class='dropdown-menu']//li"));
        for (WebElement opt : options) {
            if (opt.getText().trim().equals(option)) {
                opt.click();
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
