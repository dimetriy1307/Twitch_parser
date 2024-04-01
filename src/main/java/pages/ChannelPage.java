package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChannelPage extends BasePage{
    public ChannelPage(WebDriver driver) {
        super(driver);
    }
    private static final String TWITCH_MESSAGE = "Привіт, бачу, що у тебе не так багато глядачів, якщо вирішиш купити глядачів та розвивати стрім, то у нас найдешевший сервіс на ринку (тест від 6грн) https://twitch-viewers.minisite.ai/ Гарного тобі стріму!❤️";
    private static final String TWITCH_CHAT_WINDOW="//textarea[@autocomplete='twitch-chat']";
    private static final String SEND_MESSAGE_BUTTON="//div[text()='Chat']";
    private static final String VERIFIED_ACCOUNT_MESSAGE="//p[text()='Verified Accounts Only Chat']";
    private static final String EMOTE_CHAT_ONLY="//p[text()='Emote Only Chat']";
    private static final String FOLLOW_BUTTON="//button[@aria-label='Follow']";
    private static final String FOLLOWERS_ONLY_CHAT="//p[text()='Followers-Only Chat']";
    private static final String OFFLINE_TAG="//p[text()='Offline']";
    public void sendMessageToChat(){
        driver.findElement(By.xpath(TWITCH_CHAT_WINDOW)).sendKeys(TWITCH_MESSAGE);
    }
    public void clickSendMessageButton(){
        driver.findElement(By.xpath(SEND_MESSAGE_BUTTON)).click();
    }
    public void clickFollowButton(){
        driver.findElement(By.xpath(FOLLOW_BUTTON)).click();
    }
    public void verifyIfStreamIsOn(){
       if(driver.findElement(By.xpath(OFFLINE_TAG)).isDisplayed()){
           driver.close();
       }
    }
    public void followMessageIsShown(){
        if(driver.findElement(By.xpath(FOLLOWERS_ONLY_CHAT)).isDisplayed()){
         clickFollowButton();
        }
    }
    public void emoteChatOnlyMessageIsShown(){
        if(driver.findElement(By.xpath(EMOTE_CHAT_ONLY)).isDisplayed()){
            driver.close();
        }
    }
    public void verifiedAccountMessageIsShown(){
        if(driver.findElement(By.xpath(VERIFIED_ACCOUNT_MESSAGE)).isDisplayed()){
            driver.close();
        }
    }
}