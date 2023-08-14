package com.solvd.laba.qa.carina.demo.gui.pages.andriod;

import com.solvd.laba.qa.carina.demo.gui.pages.common.CartPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import org.openqa.selenium.WebDriver;


@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = CartPageBase.class)
public class CartPage extends CartPageBase {

  public CartPage(WebDriver driver) {
    super(driver);
  }
}
