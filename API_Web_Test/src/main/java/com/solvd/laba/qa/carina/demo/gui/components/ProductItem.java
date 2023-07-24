package com.solvd.laba.qa.carina.demo.gui.components;

import com.solvd.laba.qa.carina.demo.gui.pages.common.ProductPageBase;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductItem extends AbstractUIObject implements ICustomTypePageFactory {

  @FindBy(xpath = "//a[@link-identifier='product_picture_1185889021']/img")
  private ExtendedWebElement productPicture;

  @FindBy(xpath = "//span[@link-identifier='product_label_1185889021']")
  private ExtendedWebElement productLabel;

  @FindBy(xpath = "//span[@link-identifier='product_price_1185889021']")
  private ExtendedWebElement productPrice;


  protected ProductItem(WebDriver driver,
      SearchContext searchContext) {
    super(driver, searchContext);
  }

  public String readProductLabel(){
    return productLabel.getText();
  }

  public String readProductPrice(){
    return productPrice.getText();
  }

  public ProductPageBase openProductPage(){
    productPicture.click();
    return initPage(driver, ProductPageBase.class);
  }
}
