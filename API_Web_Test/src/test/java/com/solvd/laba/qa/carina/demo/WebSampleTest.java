package com.solvd.laba.qa.carina.demo;

import static org.testng.AssertJUnit.assertEquals;

import com.solvd.laba.qa.carina.demo.gui.components.GenreItem;
import com.solvd.laba.qa.carina.demo.gui.components.MerchItem;
import com.solvd.laba.qa.carina.demo.gui.pages.common.AllDepartmentsPageBase;
import com.solvd.laba.qa.carina.demo.gui.pages.common.ChainsawManBasePage;
import com.solvd.laba.qa.carina.demo.gui.pages.common.ChainsawManModelInfoPageBase;
import com.solvd.laba.qa.carina.demo.gui.pages.common.DepartmentPageBase;
import com.solvd.laba.qa.carina.demo.gui.pages.common.GenrePageBase;
import com.solvd.laba.qa.carina.demo.gui.pages.common.HomePageBase;
import com.solvd.laba.qa.carina.demo.gui.pages.common.MerchProductPageBase;
import com.solvd.laba.qa.carina.demo.gui.pages.common.ProductPageBase;
import com.solvd.laba.qa.carina.demo.gui.pages.common.StoreDirectoryPageBase;

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



//    @Test
//    @MethodOwner(owner = "cezeokeke")
//    @TestPriority(Priority.P1)
//    @TestLabel(name = "feature", value = { "web", "regression" })
//    public void testWalmartHomePage() {
//      AllDepartmentsPageBase allDept = initPage(getDriver(), AllDepartmentsPageBase.class);
//      allDept.open();
//      Assert.assertTrue(allDept.isPageOpened(), "All Department page is not opened");
//      SoftAssert softAssert = new SoftAssert();
//      softAssert.assertAll();
//    }

    @Test
    @MethodOwner(owner = "cezeokeke")
    @TestPriority(Priority.P2)
    @TestLabel(name = "feature", value = { "web", "regression" })
    public void testGenrePage(){
        AllDepartmentsPageBase allDept = initPage(getDriver(), AllDepartmentsPageBase.class);
        allDept.open();
        Assert.assertTrue(allDept.isPageOpened(), "All Department page is not opened");
        DepartmentPageBase deptPage = allDept.selectDepartment("Books");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertAll();
    }


//    @Test
//    public void manuallySolveCaptchaWithDelayInSelenium() {
//        try {
//
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
//            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
//                By.xpath("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")));
//
//            wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("//div[@class='recaptcha-checkbox-border']"))).click();
//
//            System.out.println("Clicked the checkbox");
//
//            wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("//button[text()='sign up']"))).click();
//
//            System.out.println("Clicked the sign up button");
//
//        } catch (Exception e) {      //*[@id="px-captcha"]//iframe[8]
//
//        }//*[@id="px-captcha"]

    //<div class="tc"><p>Activate and hold the button to confirm that you're human. Thank You!</p><div id="px-captcha" class="flex justify-center" role="region" aria-label="Human challenge" style="display: block; min-width: 310px;"><iframe style="display: none; width: 100%; height: 100px; border: 0px; user-select: none;" token="9b97202c2a32c305698600423f084e2ad8c080b057cf2273a15d592d04aa77b8c466adc487442d7fa69faf28d63e84fca3beed8ff4359bc2dd79d3470392e0e3" title="Human verification challenge"></iframe></div><p><button class="w_hhLG w_DZvO w_0_LY" type="button">Try a different method</button></p></div>
//<div class="w_WyaV"><button class="w_jaHf" type="button" aria-label="Close dialog"><svg fill="currentColor" height="1em" viewBox="0 0 16 16" width="1em" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" role="presentation" style="font-size: 1.5rem; vertical-align: -0.25em;"><path fill-rule="evenodd" d="M3.05 3.05a.5.5 0 0 1 .707 0L8 7.293l4.243-4.243a.5.5 0 0 1 .707.707L8.707 8l4.243 4.243a.5.5 0 0 1-.707.707L8 8.707 3.757 12.95a.5.5 0 0 1-.707-.707L7.293 8 3.05 3.757a.5.5 0 0 1 0-.707Z"></path></svg></button><h2 class="w_CWoT" id="ld_modalTitle_0">Robot or human?</h2></div>
//    }<div id="vgfqmpeCpqVhQMG" aria-label="Press &amp; Hold"><div id="yksdKwEfPpACUun" style="width: 0px;"></div><div id="FVdiFmFHNOGMjFz"><p id="lMsbBqmqsCzqwUE" class="QuxBepGxuwpitUx" style="animation: 146.613ms ease 0s 1 normal none running textColorIReverse;">Press &amp; Hold</p><span id="VfPwrgGEALRsUbP">Human Challenge requires verification. Please press and hold the button until verified</span></div><div class="fetching-volume"><span>•</span><span>•</span><span>•</span></div><div id="checkmark"></div><div id="ripple"></div></div>

    //        HomePageBase walmartHomePageBase = initPage(getDriver(), HomePageBase.class);
//        walmartHomePageBase.open();
//        Assert.assertTrue(walmartHomePageBase.isPageOpened(), "Walmart Home page is not opened");
    //AllDepartmentsPageBase allDepartmentsPage = walmartHomePageBase.getFooterWalmartMenu().openAllDepartmentsPage();



    @Test
    @MethodOwner(owner = "cezeokeke")
    @TestPriority(Priority.P3)
    @TestLabel(name = "feature", value = { "web", "regression" })
    public void testAllDepartments(){
        AllDepartmentsPageBase allDept = initPage(getDriver(), AllDepartmentsPageBase.class);
        allDept.open();
        Assert.assertTrue(allDept.isPageOpened(), "All Department page is not opened");
        DepartmentPageBase deptPage = allDept.selectDepartment("Books");
        GenrePageBase genrePage = deptPage.selectGenre("Coloring & activity");
        ProductPageBase productPageBase = genrePage.selectProduct("Art of Coloring: Art of Coloring: Disney Tim Burton's the Nightmare Before Christmas (Paperback)");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(productPageBase.readName(),"Art of Coloring: Art of Coloring: Disney Tim Burton's the Nightmare Before Christmas (Paperback)", "Invalid name info!");
        softAssert.assertEquals(productPageBase.readPrice(),"Now $12.99","Invalid price info!");
        softAssert.assertAll();

    }

    @Test
    @MethodOwner(owner = "cezeokeke")
    @TestPriority(Priority.P4)
    @TestLabel(name = "feature", value = { "web", "regression" })
    public void testStoreDirectory(){
        StoreDirectoryPageBase storeDirectoryPage = initPage(getDriver(), StoreDirectoryPageBase.class);
        storeDirectoryPage.open();
        Assert.assertTrue(storeDirectoryPage.isPageOpened(), "Store Directory is not opened");
    }


//    @Test
//    @MethodOwner(owner = "cezeokeke")
//    @TestPriority(Priority.P5)
//    @TestLabel(name = "feature", value = { "web", "regression" })
//    public void testDepartment(){
//        AllDepartmentsPageBase allDepartmentsPage = initPage(getDriver(), AllDepartmentsPageBase.class);
//        allDepartmentsPage.open();
//        Assert.assertTrue(allDepartmentsPage.isPageOpened(), "All Department page is not opened");
//
//        final String departmentName = "Books";
//        DepartmentPageBase departmentPage = allDepartmentsPage.selectDepartment(departmentName);
//        List<GenreItem> genres = departmentPage.getGenres();
//        SoftAssert softAssert = new SoftAssert();
//        for(GenreItem genreItem : genres){
//            softAssert.assertFalse(genreItem.readGenre().contains(departmentName),
//                "Genre" + genreItem.readGenre() + "should not include department" + departmentName + "in name");
//        }
//        softAssert.assertAll();
//    }


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
