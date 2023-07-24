package com.solvd.laba.qa.carina.demo.gui.pages.common;

import com.solvd.laba.qa.carina.demo.gui.components.GenreItem;
import com.solvd.laba.qa.carina.demo.gui.components.ProductItem;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import java.util.List;
import org.openqa.selenium.WebDriver;

public abstract class GenrePageBase extends AbstractPage {

  public GenrePageBase(WebDriver driver) {
    super(driver);
  }

  public abstract ProductPageBase selectProduct(String productName);

  public abstract List<ProductItem> getProducts();
}
