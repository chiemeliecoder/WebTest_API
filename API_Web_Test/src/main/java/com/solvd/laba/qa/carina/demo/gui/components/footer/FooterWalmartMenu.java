package com.solvd.laba.qa.carina.demo.gui.components.footer;

import com.solvd.laba.qa.carina.demo.gui.pages.common.FAQPageBase;
import com.solvd.laba.qa.carina.demo.gui.pages.desktop.AllDepartmentsPage;
import com.solvd.laba.qa.carina.demo.gui.pages.desktop.FAQPage;
import com.solvd.laba.qa.carina.demo.gui.pages.desktop.StoreDirectoryPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FooterWalmartMenu extends FooterWalmartMenuBase{

  @FindBy(linkText = "All Departments")
  private ExtendedWebElement allDepartmentsLink;

  @FindBy(linkText = "Store Directory")
  private ExtendedWebElement storeDirectoryLink;

  //a[@href = 'https://store.crunchyroll.com/help-center.html']
  @FindBy(linkText = "FAQ")
  private ExtendedWebElement fAQLink;

  public FooterWalmartMenu(WebDriver driver, SearchContext searchContext) {
    super(driver, searchContext);
  }

  public void scrollToElement(WebElement element) {
    ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
  }

  @Override
  public AllDepartmentsPage openAllDepartmentsPage(){
    allDepartmentsLink.scrollTo();
    allDepartmentsLink.hover();
    allDepartmentsLink.click();
    return new AllDepartmentsPage(driver);
  }

  @Override
  public StoreDirectoryPage openStoreDirectoryPage(){
    storeDirectoryLink.scrollTo();
    storeDirectoryLink.hover();
    storeDirectoryLink.click();

    return new StoreDirectoryPage(driver);

  }

  @Override
  public FAQPageBase openFAQPage() {
    scrollToElement(fAQLink.getElement());

    // Use explicit wait to wait for the element to be clickable
    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10)); // Wait up to 10 seconds
    wait.until(ExpectedConditions.elementToBeClickable(fAQLink.getElement()));
    JavascriptExecutor executor = (JavascriptExecutor) getDriver();
    executor.executeScript("arguments[0].click();", fAQLink.getElement());
//    fAQLink.click();
    return new FAQPage(getDriver());
  }
}
