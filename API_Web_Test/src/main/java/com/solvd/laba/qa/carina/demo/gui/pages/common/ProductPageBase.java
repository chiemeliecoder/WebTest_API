package com.solvd.laba.qa.carina.demo.gui.pages.common;

import com.solvd.laba.qa.carina.demo.gui.components.ProductItem;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import java.util.List;
import org.openqa.selenium.WebDriver;

public abstract class ProductPageBase extends AbstractPage {

  public ProductPageBase(WebDriver driver) {
    super(driver);
  }

  public abstract String getProductName();

  public abstract String getProductPrice();



}
