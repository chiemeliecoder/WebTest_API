package com.solvd.laba.qa.carina.demo.gui.pages.andriod;


import com.solvd.laba.qa.carina.demo.gui.pages.common.CartPageBase;
import com.solvd.laba.qa.carina.demo.gui.pages.common.FullCartPageBase;
import com.solvd.laba.qa.carina.demo.gui.pages.common.ModelInfoPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = ModelInfoPageBase.class)
public class ModelInfoPage extends ModelInfoPageBase {

  @FindBy(css = ".product-name-block h1")
  private ExtendedWebElement productInfoLabel;

  @FindBy(css = ".sales span")
  private ExtendedWebElement salesInfoLabel;

  @FindBy(xpath = "//div[@class = 'pdp-checkout-button d-flex']//button")
  private ExtendedWebElement addToCart;

  @FindBy(xpath = "//div[@class = 'minicart-header-block']//button")
  private ExtendedWebElement closePopUpCart;

  @FindBy(xpath = "//div[@class = 'mb-3 view-cart']//a")
  private ExtendedWebElement openUpCart;

  @FindBy(xpath = "//div[@class = 'minicart-icon']/a")
  private ExtendedWebElement shoppingCart;

  public ModelInfoPage(WebDriver driver) {
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

  @Override
  public CartPageBase addedToCartItems(){
    addToCart.click();
    closePopUpCart.click();
    return new CartPage(driver);
  }

  @Override
  public String getMinicartQuantity() {
    return null;
  }

  @Override
  public CartPageBase shopCartIconClicked(){
    shoppingCart.click();
    return new CartPage(driver);
  }

  @Override
  //fix: change them all to base page
  public FullCartPageBase viewItemInCart(){
    openUpCart.click();
    return new FullCartPage(driver);
  }

}
