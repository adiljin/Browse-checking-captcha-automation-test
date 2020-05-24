import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class baseChrome {

    public static AndroidDriver<AndroidElement> Capabilities() throws MalformedURLException {
        //Appium Chrome Browser
        //For apk's needs
        //File f = new File("src");
        //File fs = new File(f, "ApiDemos-debug_latest.apk");

        DesiredCapabilities cap = new DesiredCapabilities();
        //For a real device
        //cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
        //For an emulator
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Demo");
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        cap.setCapability("chromedriverExecutable","/Users/'USERNAME'/node_modules/appium/node_modules/appium-chromedriver/chromedriver/mac/chromedriver");
        //cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
        AndroidDriver<AndroidElement> driver = new AndroidDriver(new URL("SERVER'S URL"), cap);

        return driver;

    }

}
