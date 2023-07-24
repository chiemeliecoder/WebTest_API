package com.solvd.laba.qa.carina.demo.gui.pages.desktop;

import com.solvd.laba.qa.carina.demo.gui.components.SuperCenterItem;
import com.solvd.laba.qa.carina.demo.gui.pages.common.CityPageBase;
import com.solvd.laba.qa.carina.demo.gui.pages.common.CitySuperCenterPageBase;
import java.util.List;
import org.openqa.selenium.WebDriver;

public class CityPage extends CityPageBase {

  public List<SuperCenterItem> superCities;

  public CityPage(WebDriver driver) {
    super(driver);
  }

  @Override
  public CitySuperCenterPageBase selectSuperCenter(String supercenterName){
    for(SuperCenterItem superCity : superCities){
      if(superCity.readSuperCenterLabel().equalsIgnoreCase(supercenterName)){
        return superCity.openCitySuperCenterPage();
      }
    }
    throw new RuntimeException("Unable to open supercenter: " + supercenterName);
  }

  @Override
  public List<SuperCenterItem> getSuperCenter(){
    return superCities;
  }
}
