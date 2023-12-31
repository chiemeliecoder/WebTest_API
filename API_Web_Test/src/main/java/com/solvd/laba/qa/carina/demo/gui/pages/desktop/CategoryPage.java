package com.solvd.laba.qa.carina.demo.gui.pages.desktop;

import com.solvd.laba.qa.carina.demo.gui.components.ChainItem;
import com.solvd.laba.qa.carina.demo.gui.components.ProductItem;
import com.solvd.laba.qa.carina.demo.gui.pages.common.CategoryBasePage;
import com.solvd.laba.qa.carina.demo.gui.pages.common.ModelInfoPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = CategoryBasePage.class)
public class CategoryPage extends CategoryBasePage {

  ////div[contains(@class, 'pdp-link')]/a
  ////div[contains(@class, 'image-container')]//a
  ////div[contains(@class, 'product-tile js-product-tile')]//a
  ////div[@data-position = '1']
  @FindBy(xpath = "//div[@class='flex-grow-1 product-items-container']//div[@class='product']")
  public List<ChainItem> categoryProducts;

  @FindBy(xpath = ".//div[@class='product']")
  public List<ProductItem> productItems;

  @FindBy(xpath = ".//h1[@class = 'product-name']")
  public List<ProductItem> oneProductItem;



  public CategoryPage(WebDriver driver) {
    super(driver);
  }

  public ModelInfoPageBase selectModel(String modelName){


//    ChainItem model = categoryProducts.stream()
//        .filter(m -> m.readModel().equalsIgnoreCase(modelName))
//        .findFirst()
////        .orElseThrow(() -> new RuntimeException("Unable to find product model: " + modelName));
//
//    return model.openModelPage();
    for (ChainItem model : categoryProducts) {
      //System.out.println(model.readModel());
      if (model.readModel().equalsIgnoreCase(modelName)) {
        return model.openModelPage();
      }
    }
    throw new RuntimeException("Unable to open product model: " + modelName);

  }

  public ModelInfoPageBase selectRandomModel(String modelName){

    for (ProductItem model : oneProductItem) {
      System.out.println(model.readModel());
      if (model.readModel().equalsIgnoreCase(modelName)) {
        return initPage(driver, ModelInfoPageBase.class);
      }
    }
    throw new RuntimeException("Unable to open product model: " + modelName);

  }


  @Override
  public List<ChainItem> getChainsawManProducts() {

    return categoryProducts;
  }

  @Override
  public List<ProductItem> getProductList() {
    return productItems;
  }


}
