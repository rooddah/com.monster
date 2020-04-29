import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage extends BasePage {

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    WebElement viewAllEventsLink() {
        return driver.findElement(By.xpath("//a[contains(text(),'View all events')]"));
    }
}
