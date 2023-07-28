package com.solvd.laba.qa.carina.demo.gui.pages.common;

import com.solvd.laba.qa.carina.demo.gui.components.footer.FooterWalmartMenuBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class HomePageBase extends AbstractPage {

  @FindBy(xpath = "//button[text()='Agree and proceed']")
  private ExtendedWebElement acceptCookies;

  public HomePageBase(WebDriver driver) {
    super(driver);
    setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
  }


  public abstract FooterWalmartMenuBase getFooterWalmartMenu();
}
