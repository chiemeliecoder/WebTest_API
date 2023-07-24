package com.solvd.laba.qa.carina.demo.gui.components;

import com.solvd.laba.qa.carina.demo.gui.pages.common.CitySuperCenterPageBase;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SuperCenterItem extends AbstractUIObject implements ICustomTypePageFactory {

  @FindBy(xpath = "//a[@link-identifier='Supercenter']/text()")
  private ExtendedWebElement citySuperCenterLabel;

  public SuperCenterItem(WebDriver driver,
      SearchContext searchContext) {
    super(driver, searchContext);
  }

  public String readSuperCenterLabel(){
    return citySuperCenterLabel.getText();
  }

  public CitySuperCenterPageBase openCitySuperCenterPage(){
    citySuperCenterLabel.click();
    return initPage(driver, CitySuperCenterPageBase.class);
  }


}
