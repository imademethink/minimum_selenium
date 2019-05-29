package stepDefinitions;

import allUtility.GeneralUtility;
import allUtility.GlobalObjects;
import cucumber.api.java.en.Given;


public class Steps extends GlobalObjects {

    @Given("^General check simple chrome launch and quit case 1$")
    public void general_check_simple_chrome_launch_and_quit_case_1()  {
        System.out.println("\n\n\nDebug::  Launching Chrome\n\n\n");
        generalUtility    = new GeneralUtility();
        realDriver = generalUtility.initChromeBrowser(true);
        realDriver.get("https://www.toolsqa.com/automation-practice-form/");
        generalUtility.simpleThreadWait(12000);

        System.out.println("\n\n\nDebug::  Quit Chrome\n\n\n");
        realDriver.quit();
    }

    @Given("^General check simple chrome launch and quit case 2$")
    public void general_check_simple_chrome_launch_and_quit_case_2()  {
        System.out.println("\n\n\nDebug::  Launching Chrome\n\n\n");
        generalUtility    = new GeneralUtility();
        realDriver = generalUtility.initChromeBrowser(true);
        realDriver.get("https://www.toolsqa.com/automation-practice-form/");
        generalUtility.simpleThreadWait(12000);

        System.out.println("\n\n\nDebug::  Quit Chrome\n\n\n");
        realDriver.quit();
    }

    @Given("^General check simple firefox launch and quit$")
    public void general_check_simple_firefox_launch_and_quit()  {
        System.out.println("\n\n\nDebug::  Launching Firefox\n\n\n");
        generalUtility    = new GeneralUtility();
        realDriver = generalUtility.initFireFoxBrowser(true);
        realDriver.get("https://github.com");
        generalUtility.simpleThreadWait(12000);

        System.out.println("\n\n\nDebug::  Quit Firefox\n\n\n");
        realDriver.quit();
    }

    @Given("^General do nothing$")
    public void general_do_nothing()  {
        System.out.println("\n\n\nDebug::  General do nothing\n\n\n");
    }




}
