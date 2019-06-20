package allUtility;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.URL;
import java.util.*;

public class GeneralUtility extends GlobalObjects{

    public void simpleThreadWait(long milliSec){
        try{Thread.sleep(milliSec);}catch(Exception w){}
    }

    public WebDriver initChromeBrowser(boolean bLoadImages){
        String strOSType             = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
        String strRemoteWebDriverUrl = System.getProperty("remotewebdriverurl");

        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        if(!bLoadImages) {
            prefs.put("profile.managed_default_content_settings.images", 2);
        }
        ChromeOptions objChromeOptions = new ChromeOptions();
        objChromeOptions.setExperimentalOption("prefs", prefs);
        objChromeOptions.addArguments("--incognito");
        objChromeOptions.addArguments("--disable-popup-blocking");
        objChromeOptions.addArguments("--no-sandbox");
        objChromeOptions.addArguments("--disable-dev-shm-usage");
        if(strOSType.contains("nux")){objChromeOptions.setBinary(path_chromelinux);}
        if(strOSType.contains("mac")){objChromeOptions.setBinary(path_chromemac);}
        DesiredCapabilities chromeCapabilities = DesiredCapabilities.chrome();
        chromeCapabilities.setCapability(ChromeOptions.CAPABILITY, objChromeOptions);

        if(strOSType.contains("win")){path_chromedriver = path_chromedriver + ".exe";}
        if(strOSType.contains("nux")){new File(path_chromedriver).setExecutable(true);}
        if(strOSType.contains("mac")){new File(path_chromedriver).setExecutable(true);}
        System.setProperty("webdriver.chrome.driver",path_chromedriver);

        WebDriver driverLocal = null;
        if(null==strRemoteWebDriverUrl){
            driverLocal= new ChromeDriver(chromeCapabilities);
        }else{
            try{
                driverLocal=new RemoteWebDriver(new URL(strRemoteWebDriverUrl), chromeCapabilities);}
            catch(Exception e){}
        }

        driverLocal.manage().window().setPosition(new Point(2,2));
        driverLocal.manage().window().setSize(new Dimension(1500,840));
        driverLocal.manage().deleteAllCookies();
        return driverLocal;
    }

    public WebDriver initFireFoxBrowser(boolean bLoadImages){
        String strRemoteWebDriverUrl = System.getProperty("remotewebdriverurl");

//        Map<String, Object> prefs = new HashMap<String, Object>();
//        prefs.put("profile.default_content_setting_values.notifications", 2);
        if(!bLoadImages) {
//            prefs.put("profile.managed_default_content_settings.images", 2);
        }

        String strOSType = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
        if(strOSType.contains("win")){ path_gecodriver = path_gecodriver + ".exe";}
        if(strOSType.contains("nux")){ /* do nothing */}
        if(strOSType.contains("mac")){ /* do nothing */}

        System.setProperty("webdriver.gecko.driver",path_gecodriver);
        DesiredCapabilities firefoxCapabilities = DesiredCapabilities.firefox();

        WebDriver driverLocal = null;
        if(null==strRemoteWebDriverUrl){
            driverLocal= new FirefoxDriver(firefoxCapabilities);
        }else{
            try{
                driverLocal=new RemoteWebDriver(new URL(strRemoteWebDriverUrl), firefoxCapabilities);}
            catch(Exception e){}
        }

        driverLocal.manage().window().setPosition(new Point(50,50));
        driverLocal.manage().window().setSize(new Dimension(1500,840));
        driverLocal.manage().deleteAllCookies();
        return driverLocal;
    }


}
