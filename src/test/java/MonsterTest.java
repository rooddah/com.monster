import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MonsterTest extends BaseTest {
    private HomePage homePage;
    private AccountPage accountPage;
    private DashboardPage dashboard;
    private JobsPage jobsPage;
    private final String link = "Philips Jobs";
    private JobsResultsPanel jobsResultsPanel;
    private SavedJobs savedJobs;
    private final String savedJobsStr = "Saved Jobs";

    @BeforeMethod
    public void setup() {
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        homePage = new HomePage(driver);
        accountPage = new AccountPage(driver);
        dashboard = new DashboardPage(driver);
    }

    @Test
    public void test() throws Exception {
        homePage.clickCreateAccount();
        wait.until(ExpectedConditions.visibilityOf(accountPage.getEmailInput()));
        Assert.assertTrue(driver.getTitle().contains("Create an account"));
        accountPage.createAccount(email, password);
        wait.until(ExpectedConditions.visibilityOf(dashboard.viewAllEventsLink()));
        Assert.assertTrue(driver.getTitle().contains("Dashboard"), "Actual page title is: " + driver.getTitle() + " while it should be 'Dashboard'");
        dashboard.clickOnLink(link);
        jobsResultsPanel = new JobsResultsPanel(driver);
        jobsPage = new JobsPage(driver);
        int size = jobsPage.results().getNumOfJobs();
        String jobOne = jobsResultsPanel.cardTitleByIndex(1);
        String jobTwo = jobsResultsPanel.cardTitleByIndex(size-2);
        jobsPage.saveJobByIndex(1);
        jobsPage.saveJobByIndex(size-2);
        List<String> savedJobList = Arrays.asList(jobOne, jobTwo);
        jobsPage.selectJobOption(BasePage.Dropdowns.MY_JOB_SEARCH, savedJobsStr);
        wait.until(ExpectedConditions.visibilityOf(jobsPage.alertSaved()));
        Assert.assertTrue(driver.getTitle().contains(savedJobsStr));
        savedJobs = new SavedJobs(driver);
        List<String> actualSavedList = savedJobs.getListOfPositions();
        Assert.assertTrue(savedJobList.size() == actualSavedList.size() &&
                savedJobList.containsAll(actualSavedList) && actualSavedList.containsAll(savedJobList));
    }
}

