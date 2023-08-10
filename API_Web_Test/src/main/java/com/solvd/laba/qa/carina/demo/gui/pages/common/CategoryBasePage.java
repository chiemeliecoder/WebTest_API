package com.solvd.laba.qa.carina.demo.gui.pages.common;

import com.solvd.laba.qa.carina.demo.gui.components.ChainItem;
import com.solvd.laba.qa.carina.demo.gui.enums.Product;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import java.util.List;
import org.openqa.selenium.WebDriver;

public abstract class CategoryBasePage extends AbstractPage {

  public CategoryBasePage(WebDriver driver) {
    super(driver);
  }

  public abstract ModelInfoPageBase selectModel(Product modelName);

  public abstract List<ChainItem> getChainsawManProducts();
}
