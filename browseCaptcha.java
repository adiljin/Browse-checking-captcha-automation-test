import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.*;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class browseCaptcha extends baseChrome{

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        AndroidDriver<AndroidElement> driver = Capabilities();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //Getting a captcha
        driver.get("https://www.google.com/recaptcha/api2/demo");

        //Switching to the frame
        int number = findFrame(driver, By.xpath("//*[@id=\"recaptcha-anchor\"]/div[1]"));
        driver.switchTo().frame(number);
        driver.findElementByXPath("//*[@id=\"recaptcha-anchor\"]/div[1]").click();
        driver.switchTo().defaultContent();

        Thread.sleep(2000);

        WebElement frame1 = driver.findElement(By.xpath(".//iframe[@title='recaptcha challenge']"));
        driver.switchTo().frame(frame1);
        driver.findElement(By.xpath(".//*[@id='recaptcha-verify-button']")).click();


//
//
//        int number2 = findFrame(driver, By.xpath("//*[@id=\"recaptcha-verify-button\"]"));
//        driver.switchTo().frame(number2);
//        driver.findElementByXPath("//*[@id=\"recaptcha-verify-button\"]").click();


    }

    public static int findFrame(WebDriver driver, By by){
        int i;
        // Looking for "iframe" in the html, and getting it's size
        int frameCount = driver.findElements(By.tagName("iframe")).size();
        // For loop in order to go through the size
        for(i = 0;i<frameCount; i++){
            driver.switchTo().frame(i);
            // Finding all elements related to captcha
            int count = driver.findElements(by).size();
            if(count>0){
                // In case it's found the right element, checking the captcha
                // Break the loop
                break;
            }else{
                // Printing process of work into the console
                System.out.println("Continue looping");
            }
        }
        driver.switchTo().defaultContent();
        return i;
    }
}
