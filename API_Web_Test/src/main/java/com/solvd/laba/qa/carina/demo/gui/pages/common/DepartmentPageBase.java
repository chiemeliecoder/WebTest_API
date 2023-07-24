package com.solvd.laba.qa.carina.demo.gui.pages.common;

import com.solvd.laba.qa.carina.demo.gui.components.GenreItem;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import java.util.List;
import org.openqa.selenium.WebDriver;

public abstract class DepartmentPageBase extends AbstractPage {

  public DepartmentPageBase(WebDriver driver) {
    super(driver);
  }

  public abstract GenrePageBase selectGenre(String genreName);

  public abstract List<GenreItem> getGenres();
}
