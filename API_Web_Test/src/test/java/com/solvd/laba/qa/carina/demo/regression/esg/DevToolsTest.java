package com.solvd.laba.qa.carina.demo.regression.esg;

import com.github.kklisura.cdt.services.ChromeDevToolsService;
import com.solvd.laba.qa.carina.demo.gui.pages.common.WalmartHomePageBase;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.webdriver.DriverHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class DevToolsTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test
    public void devToolsTest() {
        WalmartHomePageBase walmartHomePage = initPage(getDriver(), WalmartHomePageBase.class);
        walmartHomePage.open();
        Assert.assertTrue(walmartHomePage.isPageOpened(), "Home page is not opened");
        DriverHelper driverHelper = new DriverHelper(getDriver());

        LOGGER.info("Trying to get Chrome DevTools...");
        ChromeDevToolsService chromeDevToolsService = driverHelper.getChromeDevTools();
        LOGGER.info("Got Chrome DevTools. Trying to get browser js version...");
        String jsVersion = chromeDevToolsService.getBrowser()
                .getVersion()
                .getJsVersion();
        LOGGER.info("Got browser js version: {}", jsVersion);
        chromeDevToolsService.close();
        chromeDevToolsService.waitUntilClosed();
    }

}