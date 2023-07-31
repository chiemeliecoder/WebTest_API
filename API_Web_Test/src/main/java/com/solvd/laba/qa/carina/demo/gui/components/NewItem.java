package com.solvd.laba.qa.carina.demo.gui.components;

import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class NewItem extends AbstractUIObject implements ICustomTypePageFactory {

  @FindBy(xpath = "//div[@class = 'pdp-link']/a")
  private ExtendedWebElement newItemLink;

  public NewItem(WebDriver driver,
      SearchContext searchContext) {
    super(driver, searchContext);
  }

  public String readNewItemTitle(){
    return newItemLink.getText();
  }
}
