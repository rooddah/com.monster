import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SavedJobs {
    public WebDriver driver;

    public SavedJobs(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getListOfSavedJobs() {
        List<WebElement> jobRows;
        jobRows = driver.findElements(By.xpath("//div[starts-with(@class, 'list-item display-table-row ng-scope')]"));
        return jobRows;
    }

    public List<SavedJob> getAllJobRows() {
        List<SavedJob> jobRows = new ArrayList<>();
        List<WebElement> jobs = getListOfSavedJobs();
        for (WebElement job : jobs){
            jobRows.add(new SavedJob(job));
        }
        return jobRows;
    }

    public List<String> getListOfPositions() {
        List<String> positions = new ArrayList<>();
        for (int i = 0; i < getAllJobRows().size() ; i++) {
            String position = getAllJobRows().get(i).getTitle();
            positions.add(position);
        }
        return positions;
    }
}
