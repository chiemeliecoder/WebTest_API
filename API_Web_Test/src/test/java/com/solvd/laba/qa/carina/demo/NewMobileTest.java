package com.solvd.laba.qa.carina.demo;

import static org.testng.AssertJUnit.assertEquals;

import com.solvd.laba.qa.carina.demo.gui.components.MerchItem;
import com.solvd.laba.qa.carina.demo.gui.components.ProductItem;
import com.solvd.laba.qa.carina.demo.gui.enums.Category;
import com.solvd.laba.qa.carina.demo.gui.pages.common.CategoryBasePage;
import com.solvd.laba.qa.carina.demo.gui.pages.common.HomePageBase;
import com.solvd.laba.qa.carina.demo.gui.pages.common.MerchProductPageBase;
import com.solvd.laba.qa.carina.demo.gui.pages.common.ProductPageBase;
import com.solvd.laba.qa.carina.demo.gui.pages.common.WishlistProductPageBase;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import java.util.List;
import java.util.Random;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


/**
 * This sample shows how create Mobile test.
 *
 * @author cezeokeke
 */

public class NewMobileTest implements IAbstractTest, IMobileUtils {

  @Test()
  @MethodOwner(owner = "cezeokeke")
  @TestLabel(name = "feature", value = {"mobile", "regression"})
  public void testMobileWebView() {
    HomePageBase homePageBase = initPage(getDriver(), HomePageBase.class);
    homePageBase.open();
    Assert.assertFalse(homePageBase.isPageOpened(), "Welcome page is opened");

    final String searchAnimeMerch = "Attack on Titan";
    List<MerchItem> mI = homePageBase.searchMerch(searchAnimeMerch);
    SoftAssert softAssert = new SoftAssert();
    mI.stream().forEach(c->{
      softAssert.assertTrue(StringUtils.containsIgnoreCase(c.readProductTitle(), searchAnimeMerch),
          "Invalid search results for " + c.readProductTitle());
    });
    softAssert.assertAll();
  }

  @Test()
  @MethodOwner(owner = "cezeokeke")
  @TestLabel(name = "feature", value = {"mobile", "acceptance"})
  public void testMobileUIElements() {
    HomePageBase crunchyHomePageBase = initPage(getDriver(), HomePageBase.class);
    crunchyHomePageBase.open();
    Assert.assertFalse(crunchyHomePageBase.isPageOpened(), "Crunchyroll Store page is opened");



    CategoryBasePage categoryBasePage = crunchyHomePageBase.selectCategory(Category.NEW_NENDOROIDS);



    List<ProductItem> listOfProducts = categoryBasePage.getProductList();
    int rand = new Random().nextInt(listOfProducts.size());
    String productLabel = listOfProducts.get(rand).getProductLabel();
    String productPrice = listOfProducts.get(rand).getProductPrice();

    listOfProducts.get(rand).openProductPage();

    ProductPageBase productPageBase = initPage(ProductPageBase.class);
    assertEquals("product name is wrong", productLabel,productLabel);
    assertEquals("price value is wrong",productPrice, productPageBase.getProductPrice());
    //please if you are using a different version of AssertJUnit your assertEquals parameter would be in the opposite direction
  }


  @Test()
  @MethodOwner(owner = "cezeokeke")
  @TestLabel(name = "feature", value = {"mobile", "acceptance"})
  public void testWishlist(){

    HomePageBase crunchyHomePageBase = initPage(getDriver(), HomePageBase.class);
    crunchyHomePageBase.open();
    MerchProductPageBase mpb = crunchyHomePageBase.navNewItemSelect();
//        WishlistProductPageBase wpb = mpb.wishlistProduct();
//        wpb.open();


    List<ProductItem> listOfProducts = mpb.getProductList();
    int rand = new Random().nextInt(listOfProducts.size());
    String productLabel = listOfProducts.get(rand).getProductLabel();



    WishlistProductPageBase wpb = listOfProducts.get(rand).wishlistProduct();




    wpb.open();
    WishlistProductPageBase wishlistProductPageBase = initPage(WishlistProductPageBase.class);
    SoftAssert softAssert = new SoftAssert();


    softAssert.assertEquals(wishlistProductPageBase.readWishlistName(), productLabel, "Invalid name info!");
    softAssert.assertAll();

  }

}
