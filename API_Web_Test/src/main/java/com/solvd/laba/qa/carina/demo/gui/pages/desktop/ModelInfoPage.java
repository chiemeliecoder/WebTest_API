package com.solvd.laba.qa.carina.demo.gui.pages.desktop;


import com.solvd.laba.qa.carina.demo.gui.pages.common.CartPageBase;
import com.solvd.laba.qa.carina.demo.gui.pages.common.FullCartPageBase;
import com.solvd.laba.qa.carina.demo.gui.pages.common.ModelInfoPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = ModelInfoPageBase.class)
public class ModelInfoPage extends ModelInfoPageBase {

  //css = ".product-name-block h1"
  //xpath = "//div[@class = 'product-name-block']//h1[@class = 'product-name']"
  @FindBy(xpath = "//div[@class = 'product-name-block']//h1[@class = 'product-name']")
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

  ////div[@class ='minicart-icon']//span[@class = 'minicart-quantity ml-1']
  private By minicartQuantityLocator = By.xpath("//div[@class='minicart-icon']//span[@class='minicart-quantity ml-1']");

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

  public String getMinicartQuantity() {
    WebElement minicartQuantityElement = getDriver().findElement(minicartQuantityLocator);
    return minicartQuantityElement.getText();
  }

  @Override
  public CartPageBase shopCartIconClicked(){
    shoppingCart.click();
    return new CartPage(driver);
  }

  @Override
  public FullCartPageBase viewItemInCart(){
    openUpCart.click();
    return new FullCartPage(driver);
  }



}
