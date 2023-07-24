package com.solvd.laba.qa.carina.demo.gui.pages.common;

import com.solvd.laba.qa.carina.demo.gui.components.CityItem;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import java.util.List;
import org.openqa.selenium.WebDriver;

public abstract class StatePageBase extends AbstractPage {

  public StatePageBase(WebDriver driver) {
    super(driver);
  }
  public abstract CityPageBase selectCity(String cityName);

  public abstract List<CityItem> getCity();
}
