package com.solvd.laba.qa.carina.demo.gui.pages.desktop;

import com.solvd.laba.qa.carina.demo.gui.components.ChainItem;
import com.solvd.laba.qa.carina.demo.gui.enums.Product;
import com.solvd.laba.qa.carina.demo.gui.pages.common.CategoryBasePage;
import com.solvd.laba.qa.carina.demo.gui.pages.common.ModelInfoPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = CategoryBasePage.class)
public class CategoryPage extends CategoryBasePage {

  @FindBy(xpath = "//div[contains(@class, 'pdp-link')]/a")
  public List<ChainItem> categoryProducts;


  public List<String> croducts;

  public CategoryPage(WebDriver driver) {
    super(driver);
  }

  public ModelInfoPageBase selectModel(Product modelName){
    for (ChainItem model : categoryProducts) {
      if (model.readModel().equalsIgnoreCase(modelName.getName())) {
        return model.openModelPage();
      }
    }
    throw new RuntimeException("Unable to open product model: " + modelName);

  }


  @Override
  public List<ChainItem> getChainsawManProducts() {
    return categoryProducts;
  }


}
