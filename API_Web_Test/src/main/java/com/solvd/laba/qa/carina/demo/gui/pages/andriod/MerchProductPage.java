package com.solvd.laba.qa.carina.demo.gui.pages.andriod;

import com.solvd.laba.qa.carina.demo.gui.components.NewItem;
import com.solvd.laba.qa.carina.demo.gui.pages.common.MerchProductPageBase;
import com.solvd.laba.qa.carina.demo.gui.pages.common.WishlistProductPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = MerchProductPageBase.class)
public class MerchProductPage extends MerchProductPageBase {


  @FindBy(xpath = "//div[contains(@data-pid, '4988601371919')]")
  private List<NewItem> newItems;


  @FindBy(xpath = "//div[contains(@data-pid, '')]//a[@class ='wishlistTile wishlist-icon-block']")
  private ExtendedWebElement itemsAreNew;

  public MerchProductPage(WebDriver driver) {
    super(driver);
  }

  @Override
  public List<NewItem> getMerch() {
    return newItems;
  }

  @Override
  public WishlistProductPageBase wishlistProduct(){
    itemsAreNew.hover();
    itemsAreNew.click();
    return new WishlistProductPage(driver);
  }
}
