package com.solvd.laba.qa.carina.demo.gui.pages.desktop;

import com.solvd.laba.qa.carina.demo.gui.components.ProductItem;
import com.solvd.laba.qa.carina.demo.gui.pages.common.GenrePageBase;
import com.solvd.laba.qa.carina.demo.gui.pages.common.ProductPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = GenrePageBase.class)
public class GenrePage extends GenrePageBase {


  @FindBy(xpath = "//div[contains(@class, 'flex-wrap')]/div[contains(@class, 'w-25')]/div[contains(@class, 'relative')]/a")
  private List<ProductItem> products;

  public GenrePage(WebDriver driver) {
    super(driver);
  }

  @Override
  public ProductPageBase selectProduct(String productName){
    for(ProductItem product : products){
      if(product.getProductLabel().equalsIgnoreCase(productName)){
        return product.openProductPage();
      }
    }
    throw new RuntimeException("Unable to open product: " + productName);
  }

  @Override
  public List<ProductItem> getProducts(){
    return products;
  }
}
