package com.solvd.laba.qa.carina.demo.gui.components;

import com.solvd.laba.qa.carina.demo.gui.pages.common.ModelInfoPageBase;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ChainItem extends AbstractUIObject implements ICustomTypePageFactory {

//  @FindBy(xpath = "//div[@id='product-search-results']//a")
  // //div[@class='flex-grow-1 product-items-container']//div[@class='product']
  //  //div[@class='product-tile js-product-tile']
  ////div[@class='flex-grow-1 product-items-container']//div[@data-pid='4983164177299']

  //to get a specific  model so this class just produces one item you just need to change the pid number and you can check any category
  @FindBy(xpath = "//div[@class='flex-grow-1 product-items-container']//div[@data-pid='4580590175891']")
  private ExtendedWebElement chainLink;

  @FindBy(xpath = "//div[@class='flex-grow-1 product-items-container']//div[@data-pid='4580590175891']//a[@class = 'link']")
  private ExtendedWebElement chainLabel;

  public ChainItem(WebDriver driver,
      SearchContext searchContext) {
    super(driver, searchContext);
  }

  public String readModel() {
    return chainLabel.getText();
  }

  public ModelInfoPageBase openModelPage() {
    chainLink.click();
    return initPage(driver, ModelInfoPageBase.class);
  }
}
