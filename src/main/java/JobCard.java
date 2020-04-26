import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JobCard {
    private WebDriver driver;
    private String title;

    public JobCard(WebDriver driver) {
        this.driver = driver;
}

    public JobCard(WebElement elem) {
        WebElement titleEl = elem.findElement(By.cssSelector("h2.title"));
        String aTitle = titleEl.getText();
        setTitle(aTitle);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
