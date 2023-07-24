package com.solvd.laba.qa.carina.demo.gui.pages.desktop;

import com.solvd.laba.qa.carina.demo.gui.pages.common.CitySuperCenterPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CitySuperCenterPage extends CitySuperCenterPageBase {


  @FindBy(css = ".help-camera strong")
  private ExtendedWebElement addressInfoLabel;

  @FindBy(css = ".help-camera strong")
  private ExtendedWebElement openTimeInfoLabel;

  public CitySuperCenterPage(WebDriver driver) {
    super(driver);
  }

  public String readAddress(){
    assertElementPresent(addressInfoLabel);
    return addressInfoLabel.getText();
  }

  public String readOpenTime(){
    assertElementPresent(openTimeInfoLabel);
    return openTimeInfoLabel.getText();
  }
}
