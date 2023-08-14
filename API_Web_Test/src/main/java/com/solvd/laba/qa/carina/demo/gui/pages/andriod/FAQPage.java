package com.solvd.laba.qa.carina.demo.gui.pages.andriod;

import com.solvd.laba.qa.carina.demo.gui.pages.common.FAQPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = FAQPageBase.class)
public class FAQPage extends FAQPageBase{

  public FAQPage(WebDriver driver) {
    super(driver);
    setPageURL("/help-center.html");

  }
}
