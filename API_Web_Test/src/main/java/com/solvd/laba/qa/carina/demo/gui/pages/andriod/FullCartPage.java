package com.solvd.laba.qa.carina.demo.gui.pages.andriod;

import com.solvd.laba.qa.carina.demo.gui.pages.common.FullCartPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = FullCartPageBase.class)
public class FullCartPage extends FullCartPageBase {

  public FullCartPage(WebDriver driver) {
    super(driver);
    openURL("/cart");
  }
}
