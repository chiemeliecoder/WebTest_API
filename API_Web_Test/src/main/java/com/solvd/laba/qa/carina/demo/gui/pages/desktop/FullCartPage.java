package com.solvd.laba.qa.carina.demo.gui.pages.desktop;

import com.solvd.laba.qa.carina.demo.gui.pages.common.FullCartPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = FullCartPageBase.class)
public class FullCartPage extends FullCartPageBase {

  public FullCartPage(WebDriver driver) {
    super(driver);
    openURL("/cart");
  }
}
