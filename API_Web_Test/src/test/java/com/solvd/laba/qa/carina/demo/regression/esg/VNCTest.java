package com.solvd.laba.qa.carina.demo.regression.esg;

import com.solvd.laba.qa.carina.demo.gui.pages.common.WalmartHomePageBase;
import com.zebrunner.carina.core.IAbstractTest;
import com.solvd.laba.qa.carina.demo.websocket.WebsocketClientEndpoint;
import com.zebrunner.carina.utils.R;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static com.solvd.laba.qa.carina.demo.websocket.EndpointUtils.getWebSocketUrl;
import static com.solvd.laba.qa.carina.demo.websocket.EndpointUtils.isMessagePresent;

public class VNCTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test
    public void vncTest() throws URISyntaxException {
        R.CONFIG.put("capabilities.zebrunner:enableVNC", "true", true);
        WalmartHomePageBase walmartHomePage = initPage(getDriver(), WalmartHomePageBase.class);
        walmartHomePage.open();
        Assert.assertTrue(walmartHomePage.isPageOpened(), "Home page is not opened");

        LOGGER.info("Trying to create connection with the VNC endpoint...");
        final WebsocketClientEndpoint clientEndPoint = new WebsocketClientEndpoint(new URI(getWebSocketUrl(getDriver(), "ws/vnc/")));
        List<Object> messages = new ArrayList<>();
        clientEndPoint.addMessageHandler(messages::add);

        FluentWait<WebDriver> wait = new FluentWait<>(getDriver())
                .pollingEvery(Duration.ofSeconds(1))
                .withTimeout(Duration.ofSeconds(20));

        Assert.assertTrue(isMessagePresent(wait, messages), "There are no messages from the VNC endpoint.");
        LOGGER.info("Created connection with the VNC endpoint.");
    }

}