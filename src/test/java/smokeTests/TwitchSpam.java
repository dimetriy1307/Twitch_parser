package smokeTests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Proxy;
import org.testng.annotations.Test;
import pages.BrowsePage;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import org.openqa.selenium.Proxy;
import java.util.Set;

public class TwitchSpam extends BaseTests {
    private static final String TWITCH_LINK = "https://www.twitch.tv/";

    @Test
    public void writeAMessageToChat() {
        getBrowsePage().clickLanguageButton();
        getBrowsePage().clickLanguageButtonUKR();
        getBrowsePage().clickBrowseHeadline();
        getBrowsePage().implicitWait(10);
        String link = "";
        link = getBrowsePage().getPreviewLink();
        link = TWITCH_LINK + link;
        getBrowsePage().implicitWait(10);
        String currentTab = getDriver().getWindowHandle();
        ((JavascriptExecutor) getDriver()).executeScript("window.open('" + link + "','_blank');");
        getBrowsePage().implicitWait(10);
        Set<String> tabs = getDriver().getWindowHandles();
        for (String tab : tabs) {
            if (!tab.equals(currentTab)) {
                getDriver().switchTo().window(tab);
                break;
            }
            getBrowsePage().implicitWait(10);
            getChannelPage().verifyIfStreamIsOn();
            getChannelPage().emoteChatOnlyMessageIsShown();
            getChannelPage().verifiedAccountMessageIsShown();
            getChannelPage().followMessageIsShown();
            getChannelPage().sendMessageToChat();
            getChannelPage().clickSendMessageButton();
        }
    }
}
