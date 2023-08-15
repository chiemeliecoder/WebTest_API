package com.solvd.laba.qa.carina.demo.gui.pages.common;

import com.solvd.laba.qa.carina.demo.gui.components.MerchItem;
import com.solvd.laba.qa.carina.demo.gui.components.NewItem;
import com.solvd.laba.qa.carina.demo.gui.components.ProductItem;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import java.util.List;
import org.openqa.selenium.WebDriver;

public abstract class MerchProductPageBase extends AbstractPage {

  public MerchProductPageBase(WebDriver driver) {
    super(driver);
  }

  public abstract List<NewItem> getMerch();

  public abstract WishlistProductPageBase wishlistProduct();

  public abstract List<ProductItem> getProductList();
}
