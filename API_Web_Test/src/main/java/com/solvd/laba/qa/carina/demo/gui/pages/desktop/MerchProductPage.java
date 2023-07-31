package com.solvd.laba.qa.carina.demo.gui.pages.desktop;

import com.solvd.laba.qa.carina.demo.gui.components.MerchItem;
import com.solvd.laba.qa.carina.demo.gui.pages.common.ChainsawManBasePage;
import com.solvd.laba.qa.carina.demo.gui.pages.common.MerchProductPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.Context;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = MerchProductPageBase.class)
public class MerchProductPage extends MerchProductPageBase {


  @FindBy(xpath = "//div[@class='site-search']")
  private ExtendedWebElement searchDiv;

  @Context(dependsOn = "searchDiv")
  @FindBy(xpath = ".//input[@type='text']")
  private ExtendedWebElement searchTextField;

  @Context(dependsOn = "searchDiv")
  @FindBy(xpath = ".//button[@type ='submit']")
  private ExtendedWebElement searchButton;

  @FindBy(xpath = "//div[@class = 'product']")
  private List<MerchItem> merch;

  public MerchProductPage(WebDriver driver) {
    super(driver);
  }

//  @Override
//  public List<MerchItem> searchMerch(String searchInput) {
//    searchTextField.type(searchInput);
//    searchButton.click();
//    return merch;
//  }
}
