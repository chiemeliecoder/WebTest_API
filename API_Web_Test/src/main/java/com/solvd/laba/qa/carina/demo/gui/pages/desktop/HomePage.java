package com.solvd.laba.qa.carina.demo.gui.pages.desktop;

import com.solvd.laba.qa.carina.demo.gui.components.MerchItem;
import com.solvd.laba.qa.carina.demo.gui.components.footer.FooterWalmartMenu;
import com.solvd.laba.qa.carina.demo.gui.pages.common.AllDepartmentsPageBase;
import com.solvd.laba.qa.carina.demo.gui.pages.common.ChainsawManBasePage;
import com.solvd.laba.qa.carina.demo.gui.pages.common.FAQPageBase;
import com.solvd.laba.qa.carina.demo.gui.pages.common.HomePageBase;
import com.solvd.laba.qa.carina.demo.gui.pages.common.MerchProductPageBase;
import com.solvd.laba.qa.carina.demo.gui.pages.common.StoreDirectoryPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.Context;
import java.lang.invoke.MethodHandles;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

  private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());



  @FindBy(id = "footercontent")
  private FooterWalmartMenu footerWalmartMenu;

  @FindBy(className = "experience-component experience-commerce_layouts-bannerCarousel")
  private ExtendedWebElement pageColumn;

  @FindBy(xpath = "//div[contains(@class, 'experience-component experience-commerce_assets-multiImagesContainer')]//a")
  private List<ExtendedWebElement> animeLinks;

  @FindBy(xpath = "//div[@class='site-search']")
  private ExtendedWebElement searchDiv;

  @Context(dependsOn = "searchDiv")
  @FindBy(xpath = ".//input[@type='text']")
  private ExtendedWebElement searchTextField;

  @Context(dependsOn = "searchDiv")
  @FindBy(xpath = ".//button[@type ='submit']")
  private ExtendedWebElement searchButton;

  @FindBy(xpath = "//div[@class = 'product']")
  private List<MerchItem> merch;

  @FindBy(xpath = "//nav[@role='navigation']//button")
  private ExtendedWebElement navigateDiv;


  @FindBy(xpath = "//div[@class = 'menu-group']//li[@class = 'nav-item dropdown']/a")
  private ExtendedWebElement newItems;



  @FindBy(xpath = "//div[@class = 'menu-group']//li[@class = 'dropdown-item dropdown']/a")
  private ExtendedWebElement shopAllNewItems;

  @FindBy(xpath = ".//a[@href = 'https://store.crunchyroll.com/help-center.html']")
  private ExtendedWebElement footerPicks;


  public HomePage(WebDriver driver) {
    super(driver);
    setUiLoadedMarker(pageColumn);
  }


  @Override
  public FooterWalmartMenu getFooterWalmartMenu(){
    return footerWalmartMenu;
  }

  @Override
  public AllDepartmentsPageBase openAllDepartments() {
    return getFooterWalmartMenu().openAllDepartmentsPage();
  }

  @Override
  public StoreDirectoryPageBase openStoreDirectory() {
    return getFooterWalmartMenu().openStoreDirectoryPage();
  }


@Override
 public ChainsawManBasePage selectChainsaw(String name){
   LOGGER.info("selecting '" + name + "' name...");
   for (ExtendedWebElement anime : animeLinks) {
     String currentAnime = anime.getText();
     LOGGER.info("currentBrand: " + currentAnime);
     if (name.equalsIgnoreCase(currentAnime)) {
       anime.click();
       return initPage(driver, ChainsawManBasePage.class);
     }
   }
   throw new RuntimeException("Unable to open anime name: " + name);
 }

  @Override
  public List<MerchItem> searchMerch(String searchInput) {
    searchTextField.type(searchInput);
    searchButton.click();
    return merch;
  }

  @Override
  public MerchProductPageBase navNewItemSelect(){
    newItems.hover();
    newItems.click();
    return new MerchProductPage(driver);
  }


}
