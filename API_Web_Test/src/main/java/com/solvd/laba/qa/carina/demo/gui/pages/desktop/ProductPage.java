package com.solvd.laba.qa.carina.demo.gui.pages.desktop;

import com.solvd.laba.qa.carina.demo.gui.pages.common.ProductPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = ProductPageBase.class)
public class ProductPage extends ProductPageBase {

  @FindBy(xpath = ".//div[@class = 'product-name-block']/h1")
  private ExtendedWebElement nameInfoLabel;


  @FindBy(xpath = ".//span[@class = 'value']")
  private ExtendedWebElement priceInfoLabel;

  public ProductPage(WebDriver driver) {
    super(driver);
  }


  @Override
  public String getProductName(){
    //assertElementPresent(nameInfoLabel);
    return nameInfoLabel.getText();
  }

  @Override
  public String getProductPrice(){
    //assertElementPresent(priceInfoLabel);
    return priceInfoLabel.getText();
  }
}
