import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.util.Random;

public class BaseTest {
    static WebDriver driver;
    String URL = "https://www.monsterworksdemo.com/home/";
    Random rand = new Random();
    int randomStr =  rand.nextInt(900) + 100;
    String email = "johny.bravo"+randomStr+"@jobseeker.com";
    String password = "Monster@123";

    @BeforeClass
    public static void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
