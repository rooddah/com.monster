import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SavedJob {
    private String title;

    public SavedJob(WebElement elem) {
        WebElement titleEl = elem.findElement(By.cssSelector("h2.list-item-heading.h3.ng-scope"));
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
