package com.solvd.laba.qa.carina.demo.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class StoreDirectoryPageBase extends AbstractPage {


  public StoreDirectoryPageBase(WebDriver driver) { super(driver); }

  public abstract StatePageBase selectState(String stateName);
}
