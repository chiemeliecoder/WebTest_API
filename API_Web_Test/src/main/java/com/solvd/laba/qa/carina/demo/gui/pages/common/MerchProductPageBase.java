package com.solvd.laba.qa.carina.demo.gui.pages.common;

import com.solvd.laba.qa.carina.demo.gui.components.MerchItem;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import java.util.List;
import org.openqa.selenium.WebDriver;

public abstract class MerchProductPageBase extends AbstractPage {

  public MerchProductPageBase(WebDriver driver) {
    super(driver);
  }

  //public abstract List<MerchItem> searchMerch(String searchInput);
}
