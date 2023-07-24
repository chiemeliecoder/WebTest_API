package com.solvd.laba.qa.carina.demo.gui.pages.desktop;

import com.solvd.laba.qa.carina.demo.gui.components.CityItem;
import com.solvd.laba.qa.carina.demo.gui.pages.common.CityPageBase;
import com.solvd.laba.qa.carina.demo.gui.pages.common.StatePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = StatePageBase.class)
public class StatePage extends StatePageBase {

  @FindBy(xpath = "//div[@class='w_KPWk w_GxNv']/div[@class='w_aoqv w_wRee w_EP2w w_AV1I']/div[@class='mt3 dark-gray f6']/a")
  private List<CityItem> cities;

  public StatePage(WebDriver driver) {
    super(driver);
  }


  @Override
  public CityPageBase selectCity(String cityName){
    for(CityItem city : cities){
      if(city.readCity().equalsIgnoreCase(cityName)){
        return city.openCityPage();
      }
    }
    throw new RuntimeException("Unable to open city: " + cityName);
  }

  @Override
  public List<CityItem> getCity(){
    return cities;
  }
}
