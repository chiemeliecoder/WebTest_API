package com.solvd.laba.qa.carina.demo.gui.components;

import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class MerchItem extends AbstractUIObject implements ICustomTypePageFactory {

  @FindBy(xpath = "//div[@class = 'pdp-link']/a")
  public ExtendedWebElement productNameLink;

  public MerchItem(WebDriver driver,
      SearchContext searchContext) {
    super(driver, searchContext);
  }

  public String readProductTitle() {
    return productNameLink.getText();
  }

  }
