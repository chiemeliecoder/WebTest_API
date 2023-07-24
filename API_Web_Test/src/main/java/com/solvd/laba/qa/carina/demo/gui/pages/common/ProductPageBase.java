package com.solvd.laba.qa.carina.demo.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ProductPageBase extends AbstractPage {

  public ProductPageBase(WebDriver driver) {
    super(driver);
  }

  public abstract String readName();

  public abstract String readPrice();


}
