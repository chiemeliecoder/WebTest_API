package com.solvd.laba.qa.carina.demo.gui.pages.andriod;

import com.solvd.laba.qa.carina.demo.gui.components.ChainItem;
import com.solvd.laba.qa.carina.demo.gui.components.ProductItem;
import com.solvd.laba.qa.carina.demo.gui.pages.common.CategoryBasePage;
import com.solvd.laba.qa.carina.demo.gui.pages.common.ModelInfoPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CategoryBasePage.class)
public class CategoryPage extends CategoryBasePage {

  @FindBy(xpath = "//div[@class='flex-grow-1 product-items-container']//div[@class='product']")
  public List<ChainItem> categoryProducts;

  @FindBy(xpath = ".//h1[@class = 'product-name']")
  public List<ProductItem> oneProductItem;

  @FindBy(xpath = ".//div[@class='product']")
  public List<ProductItem> productItems;


  public CategoryPage(WebDriver driver) {
    super(driver);
  }

  @Override
  public ModelInfoPageBase selectModel(String modelName){
        ChainItem model = categoryProducts.stream()
        .filter(m -> m.readModel().equalsIgnoreCase(modelName))
        .findFirst()
        .orElseThrow(() -> new RuntimeException("Unable to find product model: " + modelName));
        return model.openModelPage();

  }

  @Override
  public ModelInfoPageBase selectRandomModel(String modelName) {
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
