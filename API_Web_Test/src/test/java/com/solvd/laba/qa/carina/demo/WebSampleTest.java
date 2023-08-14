package com.solvd.laba.qa.carina.demo;

import static org.testng.AssertJUnit.assertEquals;

import com.solvd.laba.qa.carina.demo.gui.components.MerchItem;
import com.solvd.laba.qa.carina.demo.gui.enums.Category;
import com.solvd.laba.qa.carina.demo.gui.pages.andriod.FullCartPage;
import com.solvd.laba.qa.carina.demo.gui.pages.common.CartPageBase;
import com.solvd.laba.qa.carina.demo.gui.pages.common.CategoryBasePage;
import com.solvd.laba.qa.carina.demo.gui.pages.common.FullCartPageBase;
import com.solvd.laba.qa.carina.demo.gui.pages.common.ModelInfoPageBase;
import com.solvd.laba.qa.carina.demo.gui.pages.common.FAQPageBase;
import com.solvd.laba.qa.carina.demo.gui.pages.common.HomePageBase;
import com.solvd.laba.qa.carina.demo.gui.pages.common.MerchProductPageBase;

import com.solvd.laba.qa.carina.demo.gui.pages.common.WishlistProductPageBase;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
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

        String model = "Bobobo-bo Bo-bobo - Bobobo-bo Bo-bobo Nendoroid";


        ModelInfoPageBase productInfoPage = categoryBasePage.selectModel(model);

        SoftAssert softAssert = new SoftAssert();
        String price = "$45.99";
        softAssert.assertEquals(productInfoPage.readProductName(),"","Invalid product info!");
        softAssert.assertEquals(productInfoPage.readProductPrice(),price,"Invalid price info!");
        softAssert.assertAll();

    }


    //opens the home page goes to new products adds newest item to wishlist and checks if the item is in the wishlist page.
    @Test
    @MethodOwner(owner = "cezeokeke")
    @TestPriority(Priority.P2)
    @TestLabel(name = "feature", value = { "web", "regression" })
    public void testWishlist(){
        HomePageBase crunchyHomePageBase = initPage(getDriver(), HomePageBase.class);
        crunchyHomePageBase.open();
        MerchProductPageBase mpb = crunchyHomePageBase.navNewItemSelect();
        WishlistProductPageBase wpb = mpb.wishlistProduct();
        wpb.open();
        SoftAssert softAssert = new SoftAssert();
        String product = "Bocchi the Rock! - Hitori-chan Palm Size G.E.M. Series Figure (Melty Princess Ver.)";
        softAssert.assertEquals(wpb.readWishlistName(), product, "Invalid name info!");
        softAssert.assertAll();


    }

    @Test
    @MethodOwner(owner = "cezeokeke")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = { "web", "regression" })
    public void testCart(){
        HomePageBase crunchyHomePageBase = initPage(getDriver(), HomePageBase.class);
        crunchyHomePageBase.open();

        CategoryBasePage categoryBasePage = crunchyHomePageBase.selectCategory(Category.NEW_NENDOROIDS);


        String model = "Bobobo-bo Bo-bobo - Bobobo-bo Bo-bobo Nendoroid";
        ModelInfoPageBase productInfoPage = categoryBasePage.selectModel(model);

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
    @TestPriority(Priority.P4)
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
    @TestPriority(Priority.P5)
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
//        for(MerchItem merchItem : mI){
////            System.out.println(merchItem.readProductTitle());
//            softAssert.assertTrue(StringUtils.containsIgnoreCase(merchItem.readProductTitle(), searchAnimeMerch),
//                "Invalid search results for " + merchItem.readProductTitle());
//        }
        softAssert.assertAll();


    }



}
