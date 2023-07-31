package com.solvd.laba.qa.carina.demo.gui.pages.desktop;

import com.solvd.laba.qa.carina.demo.gui.components.ChainItem;
import com.solvd.laba.qa.carina.demo.gui.pages.common.ChainsawManBasePage;
import com.solvd.laba.qa.carina.demo.gui.pages.common.ChainsawManModelInfoPageBase;
import com.solvd.laba.qa.carina.demo.gui.pages.common.HomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = ChainsawManBasePage.class)
public class ChainsawManPage extends ChainsawManBasePage {

  @FindBy(xpath = "//div[contains(@data-pid, '810093653393')]")
  public List<ChainItem> chainsawManProducts;


  public ChainsawManPage(WebDriver driver) {
    super(driver);
  }

  public ChainsawManModelInfoPageBase selectModel(String modelName){
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
