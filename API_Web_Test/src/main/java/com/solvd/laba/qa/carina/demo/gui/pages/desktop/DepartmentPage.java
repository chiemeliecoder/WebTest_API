package com.solvd.laba.qa.carina.demo.gui.pages.desktop;

import com.solvd.laba.qa.carina.demo.gui.components.GenreItem;
import com.solvd.laba.qa.carina.demo.gui.pages.common.DepartmentPageBase;
import com.solvd.laba.qa.carina.demo.gui.pages.common.GenrePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = DepartmentPageBase.class)
public class DepartmentPage extends DepartmentPageBase {

  @FindBy(xpath = "//div[@id='Hubspokes4orNxMGrid']/div/a")
  private List<GenreItem> genres;

  public DepartmentPage(WebDriver driver) {
    super(driver);
  }

  @Override
  public GenrePageBase selectGenre(String genreName){

    for(GenreItem genre : genres){
      if(genre.readGenre().equalsIgnoreCase(genreName)){
        return genre.openGenrePage() ;
      }
    }
    throw new RuntimeException("Unable to open genre: " + genreName);
  }

  @Override
  public List<GenreItem> getGenres(){
    return genres;
  }

}
