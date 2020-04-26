import org.openqa.selenium.WebDriver;

public class Job {
    private WebDriver driver;
    private JobContactPanel jobPanel;

    public Job(WebDriver driver) {
        this.driver = driver;
        this.jobPanel = new JobContactPanel(driver);
    }

    public JobContactPanel jobContactPanel(){
        return jobPanel;
    }

}
