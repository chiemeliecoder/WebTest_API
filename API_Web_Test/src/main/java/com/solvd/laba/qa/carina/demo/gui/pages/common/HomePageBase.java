package com.solvd.laba.qa.carina.demo.gui.pages.common;

import com.solvd.laba.qa.carina.demo.gui.components.MerchItem;
import com.solvd.laba.qa.carina.demo.gui.components.footer.FooterWalmartMenuBase;
import com.solvd.laba.qa.carina.demo.gui.enums.Category;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import java.util.List;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class HomePageBase extends AbstractPage {

  ////button[text()='Agree and proceed']
  @FindBy(xpath = "//button[@id='_evidon-accept-button']")
  private ExtendedWebElement acceptCookies;

  ////h1[contains(text(), 'Welcome to Walmart')]
  @FindBy(xpath = "//h1[contains(text(), 'Crunchyroll homepage')]")
  private ExtendedWebElement uiLoadedMarker;

  public HomePageBase(WebDriver driver) {
    super(driver);
    setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    setUiLoadedMarker(uiLoadedMarker);
  }

  @Override
  public boolean isPageOpened() {
    return isPageOpened(EXPLICIT_TIMEOUT);
  }

  @Override
  public boolean isPageOpened(long timeout) {
    // Validate the presence of the uiLoadedMarker
    try {
      return uiLoadedMarker.isElementPresent(timeout);
    } catch (NoSuchElementException | TimeoutException e) {
      return false;
    }
  }


  public abstract FooterWalmartMenuBase getFooterWalmartMenu();

  public abstract AllDepartmentsPageBase openAllDepartments();

  public abstract StoreDirectoryPageBase openStoreDirectory();

  public abstract CategoryBasePage selectCategory(Category name);

  public abstract List<MerchItem> searchMerch(String searchInput);

  public abstract MerchProductPageBase navNewItemSelect();


  @Override
  public void open() {
    super.open();
    acceptCookies.clickIfPresent(10);
  }
}
