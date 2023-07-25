package com.solvd.laba.qa.carina.demo;

import com.solvd.laba.qa.carina.demo.gui.pages.common.WalmartHomePageBase;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PageOpeningStrategySampleTest implements IAbstractTest {

  @Test
  @MethodOwner(owner = "cezeokeke")
  public void testByElementOpeningStrategy(){
    WalmartHomePageBase walmartHomePage = initPage(getDriver(), WalmartHomePageBase.class);
    walmartHomePage.open();
    walmartHomePage.setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);


    SoftAssert softAssert = new SoftAssert();
    softAssert.assertTrue(walmartHomePage.isPageOpened(), "Walmart Home page is not opened");
    softAssert.assertAll();
  }



  @Test
  @MethodOwner(owner = "cezeokeke")
  public void testByURLOpeningStrategy(){

    WalmartHomePageBase walmartHomePage = initPage(getDriver(), WalmartHomePageBase.class);
    walmartHomePage.open();
    walmartHomePage.setPageOpeningStrategy(PageOpeningStrategy.BY_URL);


    SoftAssert softAssert = new SoftAssert();
    softAssert.assertTrue(walmartHomePage.isPageOpened(), "Walmart Home page is not opened");
    softAssert.assertAll();
  }


  @Test
  @MethodOwner(owner = "cezeokeke")
  public void testByUrlAndElementOpeningStrategy() {
    WalmartHomePageBase walmartHomePage = initPage(getDriver(), WalmartHomePageBase.class);
    walmartHomePage.open();
    walmartHomePage.setPageOpeningStrategy(PageOpeningStrategy.BY_URL_AND_ELEMENT);


    SoftAssert softAssert = new SoftAssert();
    softAssert.assertTrue(walmartHomePage.isPageOpened(), "Walmart Home page is not opened");
    softAssert.assertAll();
  }

}
