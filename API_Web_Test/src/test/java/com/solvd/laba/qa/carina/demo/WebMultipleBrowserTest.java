package com.solvd.laba.qa.carina.demo;

import com.solvd.laba.qa.carina.demo.gui.pages.common.WalmartHomePageBase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.webdriver.core.capability.impl.desktop.ChromeCapabilities;
import com.zebrunner.carina.webdriver.core.capability.impl.desktop.FirefoxCapabilities;

/**
 * This sample shows how initialize multiple drivers and run the tests on different browsers.
 *
 * @author qpsdemo
 */
public class WebMultipleBrowserTest implements IAbstractTest {
    private static final String CHROME_DRIVER_NAME = "chrome";
    private static final String FIREFOX_DRIVER_NAME = "firefox";



    @Test
    @MethodOwner(owner = "cezeokeke")
    public void multipleBrowserWalmartTest() {
        WalmartHomePageBase chromeHomePage = initPage(getDriver(CHROME_DRIVER_NAME,
            new ChromeCapabilities().getCapability("Chrome Test")), WalmartHomePageBase.class);

        chromeHomePage.open();
        Assert.assertTrue(chromeHomePage.isPageOpened(), "Chrome home page is not opened!");

        WalmartHomePageBase firefoxHomePage = initPage(getDriver(FIREFOX_DRIVER_NAME,
            new FirefoxCapabilities().getCapability("Firefox Test")), WalmartHomePageBase.class);

        firefoxHomePage.open();
        Assert.assertTrue(firefoxHomePage.isPageOpened(), "Firefox home page is not opened!");


    }
}
