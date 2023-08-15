package com.solvd.laba.qa.carina.demo;

import static org.testng.AssertJUnit.assertEquals;

import com.solvd.laba.qa.carina.demo.gui.components.MerchItem;
import com.solvd.laba.qa.carina.demo.gui.components.ProductItem;
import com.solvd.laba.qa.carina.demo.gui.enums.Category;
import com.solvd.laba.qa.carina.demo.gui.pages.andriod.FullCartPage;
import com.solvd.laba.qa.carina.demo.gui.pages.common.CartPageBase;
import com.solvd.laba.qa.carina.demo.gui.pages.common.CategoryBasePage;
import com.solvd.laba.qa.carina.demo.gui.pages.common.FullCartPageBase;
import com.solvd.laba.qa.carina.demo.gui.pages.common.ModelInfoPageBase;
import com.solvd.laba.qa.carina.demo.gui.pages.common.FAQPageBase;
import com.solvd.laba.qa.carina.demo.gui.pages.common.HomePageBase;
import com.solvd.laba.qa.carina.demo.gui.pages.common.MerchProductPageBase;

import com.solvd.laba.qa.carina.demo.gui.pages.common.ProductPageBase;
import com.solvd.laba.qa.carina.demo.gui.pages.common.WishlistProductPageBase;
import com.solvd.laba.qa.carina.demo.gui.pages.desktop.ProductPage;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import java.time.Duration;
import java.util.List;

import java.util.Random;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;

/**
 * This sample shows how create Web test.
 *
 * @author cezeokeke
 */
public class WebSampleTest implements IAbstractTest {

    @Test
    @MethodOwner(owner = "cezeokeke")
    @TestPriority(Priority.P1)
    @TestLabel(name = "feature", value = { "web", "regression" })
    public void testCrunchyrollPage(){
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


    @Test(dataProvider = "productTestData", dataProviderClass = PageDataProvider.class)
    @MethodOwner(owner = "cezeokeke")
    @TestPriority(Priority.P2)
    @TestLabel(name = "feature", value = { "web", "regression" })
    public void testCrunchyrollPage2(String expectedModel, String expectedPrice){
        HomePageBase crunchyHomePageBase = initPage(getDriver(), HomePageBase.class);
        crunchyHomePageBase.open();
        Assert.assertFalse(crunchyHomePageBase.isPageOpened(), "Crunchyroll Store page is opened");



        CategoryBasePage categoryBasePage = crunchyHomePageBase.selectCategory(Category.NEW_NENDOROIDS);


        ModelInfoPageBase productInfoPage = categoryBasePage.selectModel(expectedModel);

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(productInfoPage.readProductName(),"","Invalid product info!");
        softAssert.assertEquals(productInfoPage.readProductPrice(),expectedPrice,"Invalid price info!");
        softAssert.assertAll();

    }


    //opens the home page goes to new products adds newest item to wishlist and checks if the item is in the wishlist page.
    @Test
    @MethodOwner(owner = "cezeokeke")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = { "web", "regression" })
    public void testWishlist(){


        // Set the browser window size
        getDriver().manage().window().maximize();


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

        //wpb.open();


    }

    @Test(dataProvider = "productTestData", dataProviderClass = PageDataProvider.class)
    @MethodOwner(owner = "cezeokeke")
    @TestPriority(Priority.P4)
    @TestLabel(name = "feature", value = { "web", "regression" })
    public void testCart(String expectedModel, String expectedPrice){
        HomePageBase crunchyHomePageBase = initPage(getDriver(), HomePageBase.class);
        crunchyHomePageBase.open();

        CategoryBasePage categoryBasePage = crunchyHomePageBase.selectCategory(Category.NEW_NENDOROIDS);





        //String model = "Bobobo-bo Bo-bobo - Bobobo-bo Bo-bobo Nendoroid";
        ModelInfoPageBase productInfoPage = categoryBasePage.selectModel(expectedModel);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(productInfoPage.readProductPrice(),expectedPrice,"Invalid price info!");
        softAssert.assertAll();
        System.out.println(productInfoPage.readProductName());

        // Get the initial cart quantity
        String initialCartQuantity = productInfoPage.getMinicartQuantity();

        productInfoPage.addedToCartItems();

        // Assert that the cart quantity has increased by 1 after adding the item
        String updatedCartQuantity = productInfoPage.getMinicartQuantity();


        int initialQuantity = Integer.parseInt(initialCartQuantity);
        int updatedQuantity = Integer.parseInt(updatedCartQuantity);
        Assert.assertEquals(updatedQuantity, initialQuantity + 1, "Cart quantity should have increased by 1.");

        CartPageBase cartPage = productInfoPage.shopCartIconClicked();
        Assert.assertTrue(cartPage.isPageOpened(), "A minimized Cart page is not open");

        FullCartPageBase fullCartPage = productInfoPage.viewItemInCart();
        Assert.assertTrue(fullCartPage.isPageOpened(),"A maximized Cart page is not open");



    }



    @Test
    @MethodOwner(owner = "cezeokeke")
    @TestPriority(Priority.P5)
    @TestLabel(name = "feature", value = { "web", "regression" })
    public void testFAQFooter(){
        HomePageBase crunchyHomePageBase = initPage(getDriver(), HomePageBase.class);
        crunchyHomePageBase.open();

        FAQPageBase faq = crunchyHomePageBase.getFooterWalmartMenu().openFAQPage();

        Assert.assertFalse(faq.isPageOpened(10));
    }






    //This is the last test as it needs to load all products on the page.
    @Test
    @MethodOwner(owner = "cezeokeke")
    @TestPriority(Priority.P6)
    @TestLabel(name = "feature", value = { "web", "regression" })
    public void testAOT(){
        HomePageBase crunchyHomePageBase = initPage(getDriver(), HomePageBase.class);
        crunchyHomePageBase.open();

        final String searchAnimeMerch = "Attack on Titan";
        List<MerchItem> mI = crunchyHomePageBase.searchMerch(searchAnimeMerch);
        SoftAssert softAssert = new SoftAssert();
        mI.stream().forEach(c->{
            softAssert.assertTrue(StringUtils.containsIgnoreCase(c.readProductTitle(), searchAnimeMerch),
            "Invalid search results for " + c.readProductTitle());
        });
        softAssert.assertAll();


    }



}
