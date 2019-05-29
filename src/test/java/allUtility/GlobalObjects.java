package allUtility;

import org.openqa.selenium.WebDriver;

public class GlobalObjects {
    public WebDriver realDriver                = null;
    public GeneralUtility generalUtility       = null;

    public String path_chromedriver = "browserDriver//chromedriver_automation";
    public String path_gecodriver   = "browserDriver//geckodriver_automation";

    public final String path_chromelinux  = "/opt/google/chrome/chrome";
    public final String path_chromewindows= "";
    public final String path_chromemac    = "";

    public final String path_firefoxlinux = "";
    public final String path_firefoxwindows= "";
    public final String path_firefoxmac   = "";

}
