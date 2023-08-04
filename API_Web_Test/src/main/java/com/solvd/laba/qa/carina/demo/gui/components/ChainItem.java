package com.solvd.laba.qa.carina.demo.gui.components;

import com.solvd.laba.qa.carina.demo.gui.pages.common.ModelInfoPageBase;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ChainItem extends AbstractUIObject implements ICustomTypePageFactory {

  @FindBy(xpath = "//div[@id='product-search-results']//a")
  private ExtendedWebElement chainLink;

  @FindBy(xpath = ".//a[@class = 'link']")
  private ExtendedWebElement chainLabel;

  public ChainItem(WebDriver driver,
      SearchContext searchContext) {
    super(driver, searchContext);
  }

  public String readModel() {
    return chainLabel.getText();
  }

  public ModelInfoPageBase openModelPage() {
    chainLink.click();
    return initPage(driver, ModelInfoPageBase.class);
  }
}
