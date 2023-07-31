package com.solvd.laba.qa.carina.demo.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class WishlistProductPageBase extends AbstractPage {

  public WishlistProductPageBase(WebDriver driver) {
    super(driver);
  }

  public abstract String readWishlistName();
}
