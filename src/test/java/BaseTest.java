import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.util.Random;

public class BaseTest {
    static WebDriver driver;
    static WebDriverWait wait;
    protected static String DEFAULT_CHROME_DRIVER_PATH = "src/main/resources/chromedriver.exe";
    String URL = "https://www.monsterworksdemo.com/home/";
    Random rand = new Random();
    int randomStr =  rand.nextInt(900) + 100;
    String email = "johny.bravo"+randomStr+"@jobseeker.com";
    String password = "Monster@123";

    @BeforeClass
    public static void setUp() {
        if (System.getProperty("webdriver.chrome.driver") == null) {
            System.setProperty("webdriver.chrome.driver", DEFAULT_CHROME_DRIVER_PATH);
        }
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
