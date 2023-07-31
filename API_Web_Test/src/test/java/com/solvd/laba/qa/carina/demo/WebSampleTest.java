package com.solvd.laba.qa.carina.demo;

import static org.testng.AssertJUnit.assertEquals;

import com.solvd.laba.qa.carina.demo.gui.components.GenreItem;
import com.solvd.laba.qa.carina.demo.gui.components.MerchItem;
import com.solvd.laba.qa.carina.demo.gui.pages.common.AllDepartmentsPageBase;
import com.solvd.laba.qa.carina.demo.gui.pages.common.CartPageBase;
import com.solvd.laba.qa.carina.demo.gui.pages.common.ChainsawManBasePage;
import com.solvd.laba.qa.carina.demo.gui.pages.common.ChainsawManModelInfoPageBase;
import com.solvd.laba.qa.carina.demo.gui.pages.common.DepartmentPageBase;
import com.solvd.laba.qa.carina.demo.gui.pages.common.FAQPageBase;
import com.solvd.laba.qa.carina.demo.gui.pages.common.GenrePageBase;
import com.solvd.laba.qa.carina.demo.gui.pages.common.HomePageBase;
import com.solvd.laba.qa.carina.demo.gui.pages.common.MerchProductPageBase;
import com.solvd.laba.qa.carina.demo.gui.pages.common.ProductPageBase;
import com.solvd.laba.qa.carina.demo.gui.pages.common.StoreDirectoryPageBase;

import com.solvd.laba.qa.carina.demo.gui.pages.common.WishlistProductPageBase;
import com.solvd.laba.qa.carina.demo.gui.pages.desktop.FAQPage;
import com.solvd.laba.qa.carina.demo.gui.pages.desktop.HomePage;
import com.solvd.laba.qa.carina.demo.gui.pages.desktop.MerchProductPage;
import com.solvd.laba.qa.carina.demo.gui.pages.desktop.ProductPage;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import java.net.PortUnreachableException;
import java.time.Duration;
import java.util.List;

import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
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
        //Assert.assertTrue(crunchyHomePageBase.isPageOpened(), "Crunchyroll Store page is not opened");

        ChainsawManBasePage chainsawMan = crunchyHomePageBase.selectChainsaw("CHAINSAW MAN MERCH");

        ChainsawManModelInfoPageBase productInfoPage = chainsawMan.selectModel("Chainsaw Man - Power Otaku Lamp");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(productInfoPage.readProductName(),"","Invalid product info!");
        softAssert.assertEquals(productInfoPage.readProductPrice(),"$34.95","Invalid price info!");
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
        softAssert.assertEquals(wpb.readWishlistName(), "Final Fantasy XVI - Cidolfus Telamon Bring Arts Action Figure", "Invalid name info!");
        softAssert.assertAll();


    }

    @Test
    @MethodOwner(owner = "cezeokeke")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = { "web", "regression" })
    public void testCart() throws InterruptedException {
        HomePageBase crunchyHomePageBase = initPage(getDriver(), HomePageBase.class);
        crunchyHomePageBase.open();

        ChainsawManBasePage chainsawMan = crunchyHomePageBase.selectChainsaw("CHAINSAW MAN MERCH");

        ChainsawManModelInfoPageBase productInfoPage = chainsawMan.selectModel("Chainsaw Man - Power Otaku Lamp");

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
