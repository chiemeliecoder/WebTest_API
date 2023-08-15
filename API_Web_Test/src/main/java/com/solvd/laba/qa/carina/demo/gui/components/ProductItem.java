package com.solvd.laba.qa.carina.demo.gui.components;

import com.solvd.laba.qa.carina.demo.gui.pages.common.ModelInfoPageBase;
import com.solvd.laba.qa.carina.demo.gui.pages.common.ProductPageBase;
import com.solvd.laba.qa.carina.demo.gui.pages.common.WishlistProductPageBase;
import com.solvd.laba.qa.carina.demo.gui.pages.desktop.WishlistProductPage;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import java.time.Duration;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductItem extends AbstractUIObject implements ICustomTypePageFactory {

  @FindBy(xpath = ".//img")
  private ExtendedWebElement productPicture;

  @FindBy(xpath = ".//div[@class='pdp-link']/a")
  private ExtendedWebElement productLabel;

  @FindBy(xpath = ".//div[@class='price']")
  private ExtendedWebElement productPrice;

  @FindBy(xpath = ".//div[contains(@data-pid, '')]//a[@class ='wishlistTile wishlist-icon-block']")
  private ExtendedWebElement itemsAreNew;

  @FindBy(xpath = "//div[@class = 'product-name-block']/h1")
  private ExtendedWebElement chainLabel;

  public ProductItem(WebDriver driver) {
    super(driver);

  }

  public ProductItem(WebDriver driver,
      SearchContext searchContext) {
    super(driver, searchContext);
  }

  public String getProductLabel(){
    return productLabel.getText();
  }

  public String getProductPrice(){
    return productPrice.getText();
  }

  public ProductPageBase openProductPage(){
    try {
      productLabel.click();
    } catch (ElementClickInterceptedException e) {
      // Handle the exception here
      System.out.println("ElementClickInterceptedException occurred. Handling it...");

      // Then, click again
      productLabel.click();
    }
    //productLabel.click();
    return initPage(driver, ProductPageBase.class);
  }


  public WishlistProductPageBase wishlistProduct(){
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement itemsAreNewElement = itemsAreNew.getElement(); // Get the underlying WebElement

    // Scroll to the element to ensure it's within the viewport
    JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
    jsExecutor.executeScript("arguments[0].scrollIntoView(true);", itemsAreNewElement);


    wait.until(ExpectedConditions.elementToBeClickable(itemsAreNewElement));

    Actions actions = new Actions(driver);
    actions.moveToElement(itemsAreNewElement).perform();

    // Click the element
    itemsAreNewElement.click();


    return initPage(driver, WishlistProductPageBase.class);
  }

  public String readModel() {
    return chainLabel.getText();
  }

  public ModelInfoPageBase openModelPage() {
//    productLabel.click();
    try {
      productLabel.click();
    } catch (ElementClickInterceptedException e) {
      // Handle the exception here
      System.out.println("ElementClickInterceptedException occurred. Handling it...");

      // Then, click again
      productLabel.click();
    }
    return initPage(driver, ModelInfoPageBase.class);
  }
}
