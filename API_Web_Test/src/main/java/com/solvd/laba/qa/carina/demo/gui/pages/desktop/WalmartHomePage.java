package com.solvd.laba.qa.carina.demo.gui.pages.desktop;

import com.solvd.laba.qa.carina.demo.gui.components.footer.FooterWalmartMenu;
import com.solvd.laba.qa.carina.demo.gui.pages.common.WalmartHomePageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class WalmartHomePage extends WalmartHomePageBase {



  @FindBy(className = "list ma0 mt3 ph3 pt1 ma0-hdkp ph4-hdkp pb4-hdkp pt3-hdkp flex-hdkp flex-wrap-hdkp justify-center-hdkp footer-list")
  private FooterWalmartMenu footerWalmartMenu;

  public WalmartHomePage(WebDriver driver) {
    super(driver);
  }

  @Override
  public FooterWalmartMenu getFooterWalmartMenu(){
    return footerWalmartMenu;
  }

}
