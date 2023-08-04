package com.solvd.laba.qa.carina.demo.gui.pages.desktop;

import com.solvd.laba.qa.carina.demo.gui.components.ChainItem;
import com.solvd.laba.qa.carina.demo.gui.pages.common.CategoryBasePage;
import com.solvd.laba.qa.carina.demo.gui.pages.common.ModelInfoPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = CategoryBasePage.class)
public class CategoryPage extends CategoryBasePage {

  @FindBy(xpath = "//div[contains(@data-pid, '4580590175426')]")
  public List<ChainItem> chainsawManProducts;


  public CategoryPage(WebDriver driver) {
    super(driver);
  }

  public ModelInfoPageBase selectModel(String modelName){
    for (ChainItem model : chainsawManProducts) {
      if (model.readModel().equalsIgnoreCase(modelName)) {
        return model.openModelPage();
      }
    }
    throw new RuntimeException("Unable to open chainsawman model: " + modelName);

  }

  @Override
  public List<ChainItem> getChainsawManProducts() {
    return chainsawManProducts;
  }


}
