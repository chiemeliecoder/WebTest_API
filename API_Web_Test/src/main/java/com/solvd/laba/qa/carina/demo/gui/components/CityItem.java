package com.solvd.laba.qa.carina.demo.gui.components;

import com.solvd.laba.qa.carina.demo.gui.pages.common.CityPageBase;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CityItem extends AbstractUIObject implements ICustomTypePageFactory {

  @FindBy(xpath = "//a[@link-identifier='Anchorage']")
  private ExtendedWebElement cityLink;

  public CityItem(WebDriver driver, SearchContext searchContext) {
    super(driver, searchContext);
  }

  public String readCity(){
    return cityLink.getText();
  }

  public CityPageBase openCityPage(){
    cityLink.click();
    return initPage(driver, CityPageBase.class);
  }

}
