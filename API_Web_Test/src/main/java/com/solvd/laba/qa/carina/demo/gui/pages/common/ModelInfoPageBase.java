package com.solvd.laba.qa.carina.demo.gui.pages.common;

import com.solvd.laba.qa.carina.demo.gui.pages.desktop.CartPage;
import com.solvd.laba.qa.carina.demo.gui.pages.desktop.FullCartPage;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ModelInfoPageBase extends AbstractPage {

  public ModelInfoPageBase(WebDriver driver) {
    super(driver);
  }

  public abstract String readProductName();

  public abstract String readProductPrice();

  public abstract CartPageBase addedToCartItems();

  public abstract String getMinicartQuantity();

  public abstract CartPageBase shopCartIconClicked();

  public abstract FullCartPageBase viewItemInCart();


}
