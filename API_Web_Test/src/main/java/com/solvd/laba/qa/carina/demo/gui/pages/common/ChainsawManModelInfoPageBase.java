package com.solvd.laba.qa.carina.demo.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ChainsawManModelInfoPageBase extends AbstractPage {

  public ChainsawManModelInfoPageBase(WebDriver driver) {
    super(driver);
  }

  public abstract String readProductName();

  public abstract String readProductPrice();


}
