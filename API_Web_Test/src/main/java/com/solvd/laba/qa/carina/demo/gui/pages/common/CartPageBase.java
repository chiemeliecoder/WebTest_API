package com.solvd.laba.qa.carina.demo.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CartPageBase extends AbstractPage {

  public CartPageBase(WebDriver driver) {

    super(driver);
    setPageURL("/products/bobobo-bo-bo-bobo-bobobo-bo-bo-bobo-nendoroid-4580590175891.html");
  }


}
