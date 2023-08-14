package com.solvd.laba.qa.carina.demo.gui.pages.andriod;

import com.solvd.laba.qa.carina.demo.gui.pages.common.WishlistProductPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = WishlistProductPageBase.class)
public class WishlistProductPage extends WishlistProductPageBase {

  @FindBy(css = " .line-item-header a")
  private ExtendedWebElement wishlistItemLabel;

  public WishlistProductPage(WebDriver driver) {
    super(driver);
    setPageURL("/wishlist");
  }

  @Override
  public String readWishlistName() {
    assertElementPresent(wishlistItemLabel);
    return wishlistItemLabel.getText();
  }
}
