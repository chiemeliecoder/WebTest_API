package com.solvd.laba.qa.carina.demo.gui.pages.desktop;

import com.solvd.laba.qa.carina.demo.gui.components.footer.FooterWalmartMenu;
import com.solvd.laba.qa.carina.demo.gui.pages.common.HomePageBase;
import com.solvd.laba.qa.carina.demo.gui.pages.common.StoreDirectoryPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {



  @FindBy(xpath = "//ul[@data-testid=\"responsive-footer-list\"]")
  private FooterWalmartMenu footerWalmartMenu;

  public HomePage(WebDriver driver) {
    super(driver);
  }

  @Override
  public FooterWalmartMenu getFooterWalmartMenu(){
    return footerWalmartMenu;
  }

}
