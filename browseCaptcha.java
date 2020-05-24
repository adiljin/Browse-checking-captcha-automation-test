import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.*;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class browseCaptcha extends baseChrome{

    public static void main(String[] args) throws MalformedURLException {
        AndroidDriver<AndroidElement> driver = Capabilities();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //Getting a captcha
        driver.get("https://patrickhlauke.github.io/recaptcha/");
        //Switching to the frame
        switchToFrame(driver);

    }

    public static void switchToFrame(WebDriver driver){
        // Looking for "iframe" in the html, and getting it's size
        int frameCount = driver.findElements(By.tagName("iframe")).size();
        // For loop in order to go through the size
        for(int i =0;i<frameCount; i++){
            driver.switchTo().frame(i);
            // Finding all elements related to captcha
            int count = driver.findElements(By.xpath("//*[@id=\"recaptcha-anchor\"]/div[1]")).size();
            if(count>0){
                // In case it's found the right element, checking the captcha
                driver.findElement(By.xpath("//*[@id=\"recaptcha-anchor\"]/div[1]")).click();
                // Break the loop
                break;
            }else{
                // Printing process of work into the console
                System.out.println("Continue looping");
            }
        }
    }
}
