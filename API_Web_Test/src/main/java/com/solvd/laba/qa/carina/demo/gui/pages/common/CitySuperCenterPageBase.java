package com.solvd.laba.qa.carina.demo.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CitySuperCenterPageBase extends AbstractPage {

  public CitySuperCenterPageBase(WebDriver driver) {
    super(driver);
  }

  public abstract String readAddress();

  public abstract String readOpenTime();
}
