package com.solvd.laba.qa.carina.demo.gui.pages.desktop;

import com.solvd.laba.qa.carina.demo.gui.pages.common.ProductPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = ProductPageBase.class)
public class ProductPage extends ProductPageBase {

  @FindBy(css = ".help-camera strong")
  private ExtendedWebElement nameInfoLabel;


  @FindBy(css = ".help-camera strong")
  private ExtendedWebElement priceInfoLabel;

  public ProductPage(WebDriver driver) {
    super(driver);
  }

  public String readName(){
    assertElementPresent(nameInfoLabel);
    return nameInfoLabel.getText();
  }

  public String readPrice(){
    assertElementPresent(priceInfoLabel);
    return priceInfoLabel.getText();
  }
}
