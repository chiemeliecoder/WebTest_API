package com.solvd.laba.qa.carina.demo;

import static org.testng.AssertJUnit.assertEquals;

import com.solvd.laba.qa.carina.demo.gui.components.MerchItem;
import com.solvd.laba.qa.carina.demo.gui.pages.common.CartPageBase;
import com.solvd.laba.qa.carina.demo.gui.pages.common.CategoryBasePage;
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

        String category = "NEW NENDOROIDS";
        CategoryBasePage categoryBasePage = crunchyHomePageBase.selectCategory(category);

        String model = "Banana Fish - Ash Lynx (Re-run) Nendoroid";
        ModelInfoPageBase productInfoPage = categoryBasePage.selectModel(model);

        SoftAssert softAssert = new SoftAssert();
        String price = "$38.99";
        softAssert.assertEquals(productInfoPage.readProductName(),"","Invalid product info!");
        softAssert.assertEquals(productInfoPage.readProductPrice(),price,"Invalid price info!");
        softAssert.assertAll();

    }

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
        String product = "Final Fantasy XVI - Cidolfus Telamon Bring Arts Action Figure";
        softAssert.assertEquals(wpb.readWishlistName(), product, "Invalid name info!");
        softAssert.assertAll();


    }

    @Test
    @MethodOwner(owner = "cezeokeke")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = { "web", "regression" })
    public void testCart() throws InterruptedException {
        HomePageBase crunchyHomePageBase = initPage(getDriver(), HomePageBase.class);
        crunchyHomePageBase.open();

        String category = "NEW NENDOROIDS";
        CategoryBasePage categoryBasePage = crunchyHomePageBase.selectCategory(category);

        String model = "Banana Fish - Ash Lynx (Re-run) Nendoroid";
        ModelInfoPageBase productInfoPage = categoryBasePage.selectModel(model);

        CartPageBase cPB = productInfoPage.addedToCartItems();

        productInfoPage.shopCart();

        productInfoPage.cartFull();

    }



    @Test
    @MethodOwner(owner = "cezeokeke")
    @TestPriority(Priority.P4)
    @TestLabel(name = "feature", value = { "web", "regression" })
    public void testFAQFooter() throws InterruptedException {
        HomePageBase crunchyHomePageBase = initPage(getDriver(), HomePageBase.class);
        crunchyHomePageBase.open();

        //test wont pass current thread is not owner
        FAQPageBase f = initPage(getDriver(), FAQPageBase.class);
        f.open();
        //test wont pass current thread is not owner
//        FAQPage faq = crunchyHomePageBase.getFooterWalmartMenu().openFAQPage();
//        Assert.assertTrue(faq.isPageOpened(10));
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
        for(MerchItem merchItem : mI){
            System.out.println(merchItem.readProductTitle());
            softAssert.assertTrue(StringUtils.containsIgnoreCase(merchItem.readProductTitle(), searchAnimeMerch),
                "Invalid search results for " + merchItem.readProductTitle());
        }
        softAssert.assertAll();


    }



}
