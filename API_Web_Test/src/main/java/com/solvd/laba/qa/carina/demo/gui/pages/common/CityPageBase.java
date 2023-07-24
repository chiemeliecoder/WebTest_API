package com.solvd.laba.qa.carina.demo.gui.pages.common;

import com.solvd.laba.qa.carina.demo.gui.components.CityItem;
import com.solvd.laba.qa.carina.demo.gui.components.SuperCenterItem;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import java.util.List;
import org.openqa.selenium.WebDriver;

public abstract class CityPageBase extends AbstractPage {

  public CityPageBase(WebDriver driver) {
    super(driver);
  }

  public abstract CitySuperCenterPageBase selectSuperCenter(String supercenterName);

  public abstract List<SuperCenterItem> getSuperCenter();
}
