import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class JobsResultsPanel {
    private WebDriver driver;

    public JobsResultsPanel(WebDriver driver) {
        this.driver = driver;
    }

    public int getNumOfJobs() {
        return getAllJobCards().size();
    }

    By jobCard = By.xpath("//div[@id='SearchResults']//section[contains(@class, 'card-content')]");

    public WebElement getEmptyMessage() {
        return driver.findElement(By.xpath("//span[contains(text(),'we didn\''t find any jobs matching your criteria')]"));
    }

    public List<String> getJobsStr() {
        List<String> jobs = new ArrayList<String>();
        List<WebElement> cards =  getAllJobCardsElements();
        for (WebElement ele : cards) {
            String title = ele.findElement(By.cssSelector(".title")).getText();
            jobs.add(title);
        }
        return jobs;
    }

    public List<WebElement> getAllJobCardsElements() {
        List<WebElement> jobCards;
        jobCards =  driver.findElements(jobCard);
        return jobCards;
    }

    public List<JobCard> getAllJobCards() {
        List<JobCard> jobCardsk = new ArrayList<>();
        List<WebElement> jobs = getAllJobCardsElements();
        for (WebElement job : jobs){
            jobCardsk.add(new JobCard(job));
        }
        return jobCardsk;
    }

    public String cardTitleByIndex(int index) {
        String title = getAllJobCards().get(index).getTitle();
        return title;
    }

}
