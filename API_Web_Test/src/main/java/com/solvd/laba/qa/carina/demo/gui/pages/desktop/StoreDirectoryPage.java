package com.solvd.laba.qa.carina.demo.gui.pages.desktop;

import com.solvd.laba.qa.carina.demo.gui.pages.common.StatePageBase;
import com.solvd.laba.qa.carina.demo.gui.pages.common.StoreDirectoryPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = StoreDirectoryPageBase.class)
public class StoreDirectoryPage extends StoreDirectoryPageBase {




  @FindBy(xpath = "//h1[@tabindex=\"0\" and @class=\"f1\"]")
  private ExtendedWebElement storeDirPageTitle;

  public StoreDirectoryPage(WebDriver driver) {

    super(driver);
    setPageURL("/store-directory"); //the slash changes to a - is it okay it is like this?
  }


  public String getDirPageTitle(){
    return storeDirPageTitle.getText();
  }

  @Override
  public StatePageBase selectState(String stateName){

    stateName = stateName.toLowerCase();
    for(ExtendedWebElement state : findExtendedWebElements(By.xpath("//div[@class=\"w_KPWk w_GxNv\"]//a[@link-identifier]"))){
      if(state.getText().contains(stateName)){
        state.click();
        return initPage(driver, StatePageBase.class);
      }
    }
    throw new RuntimeException("Unable to open state page: " + stateName);
  }



}
