package smokeTests;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.*;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class BaseTests {

    private WebDriver driver;
    private static final String LOG_IN_BUTTON="//div[text()='Log In']";
    private static final String TWITCH_BROWSE_PAGE = "https://www.twitch.tv/directory/all?sort=VIEWER_COUNT_ASC";

    @BeforeTest
    public void profileSetup() {
        chromedriver().setup();
    }

    @BeforeMethod
    public void testsSetup() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(TWITCH_BROWSE_PAGE);
    }

//    @AfterMethod
//    public void tearDown() {
//        driver.close();
//    }

    public WebDriver getDriver() {
        return driver;
    }

    public BrowsePage getBrowsePage() {
        return new BrowsePage(getDriver());
    }

    public ChannelPage getChannelPage() {
        return new ChannelPage(getDriver());
    }
}
