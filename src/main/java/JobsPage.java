import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class JobsPage extends BasePage {
    private final JobsResultsPanel jobsResultsPanel;

    private final Job job;

    WebElement alertSaved() {
        return driver.findElement(By.xpath("//div[@class='alert alert-info ng-binding']"));
    }

    WebElement savedMsg() {
        return driver.findElement(By.cssSelector("div.alerts-content"));
    }

    public JobsPage(WebDriver driver) {
        super(driver);
        this.jobsResultsPanel = new JobsResultsPanel(driver);
        this.job = new Job(driver);
    }

    public JobsResultsPanel results() {
        return jobsResultsPanel;
    }

    public Job job() {
        return job;
    }

    public void saveJobByIndex(int index) throws InterruptedException {
        WebElement job = jobsResultsPanel.getAllJobCardsElements().get(index);
        job.click();
        job().jobContactPanel().clickSave();
        Thread.sleep(2000);
        if (job().jobContactPanel().isSaved() != true) {
            System.out.println("Job has not been saved");
            wait.until(ExpectedConditions.invisibilityOf(savedMsg()));
        }
    }
}
