package com.solvd.laba.qa.carina.demo.gui.pages.desktop;

import com.solvd.laba.qa.carina.demo.gui.pages.common.FAQPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = FAQPageBase.class)
    public class FAQPage extends FAQPageBase{

  public FAQPage(WebDriver driver) {
    super(driver);
    setPageURL("/help-center.html");

  }
}
