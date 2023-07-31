package com.solvd.laba.qa.carina.demo.gui.components;

import com.solvd.laba.qa.carina.demo.gui.pages.common.GenrePageBase;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class GenreItem extends AbstractUIObject implements ICustomTypePageFactory {


  @FindBy(xpath = "//a[@link-identifier='efb68adb-9b32-406d-abdb-012b2d513892']/img")
  private ExtendedWebElement genrePicture;

  @FindBy(xpath = "//a[@link-identifier='efb68adb-9b32-406d-abdb-012b2d513892']/div/span")
  private ExtendedWebElement genreLink;

  public GenreItem(WebDriver driver,
      SearchContext searchContext) {
    super(driver, searchContext);
  }

  public String readGenre(){
    return genreLink.getText();
  }


  public GenrePageBase openGenrePage(){
    genreLink.click();
    return initPage(driver,GenrePageBase.class);
  }
}
