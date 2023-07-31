package com.solvd.laba.qa.carina.demo.gui.pages.common;

import com.solvd.laba.qa.carina.demo.gui.components.ChainItem;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import java.util.List;
import org.openqa.selenium.WebDriver;

public abstract class ChainsawManBasePage extends AbstractPage {

  public ChainsawManBasePage(WebDriver driver) {
    super(driver);
  }

  public abstract ChainsawManModelInfoPageBase selectModel(String modelName);

  public abstract List<ChainItem> getChainsawManProducts();
}
