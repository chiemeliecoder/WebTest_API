package com.solvd.laba.qa.carina.demo.gui.pages.desktop;


import com.solvd.laba.qa.carina.demo.gui.pages.common.ChainsawManBasePage;
import com.solvd.laba.qa.carina.demo.gui.pages.common.ChainsawManModelInfoPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = ChainsawManModelInfoPageBase.class)
public class ChainsawManModelInfoPage extends ChainsawManModelInfoPageBase {

  @FindBy(css = ".product-name-block h1")
  private ExtendedWebElement productInfoLabel;

  @FindBy(css = ".sales span")
  private ExtendedWebElement salesInfoLabel;

  public ChainsawManModelInfoPage(WebDriver driver) {
    super(driver);
  }

  @Override
  public String readProductName() {
    assertElementPresent(productInfoLabel);
    return productInfoLabel.getText();
  }

  @Override
  public String readProductPrice() {
    assertElementPresent(salesInfoLabel);
    return salesInfoLabel.getText();
  }
}
