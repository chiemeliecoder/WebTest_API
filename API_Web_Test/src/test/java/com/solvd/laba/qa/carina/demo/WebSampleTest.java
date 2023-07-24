package com.solvd.laba.qa.carina.demo;

import com.solvd.laba.qa.carina.demo.gui.components.GenreItem;
import com.solvd.laba.qa.carina.demo.gui.pages.common.AllDepartmentsPageBase;
import com.solvd.laba.qa.carina.demo.gui.pages.common.DepartmentPageBase;
import com.solvd.laba.qa.carina.demo.gui.pages.common.StoreDirectoryPageBase;
import com.solvd.laba.qa.carina.demo.gui.pages.common.WalmartHomePageBase;
import java.util.List;

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
    public void testWalmartHomePage() {
        WalmartHomePageBase walmartHomePageBase = initPage(getDriver(), WalmartHomePageBase.class);
        walmartHomePageBase.open();
        Assert.assertTrue(walmartHomePageBase.isPageOpened(), "Walmart Home page is not opened");
    }



    @Test
    @MethodOwner(owner = "cezeokeke")
    public void testAllDepartments(){
        WalmartHomePageBase walmartHomePageBase = initPage(getDriver(), WalmartHomePageBase.class);
        walmartHomePageBase.open();
        Assert.assertTrue(walmartHomePageBase.isPageOpened(), "Walmart Home page is not opened");

        AllDepartmentsPageBase allDepartmentsPage = walmartHomePageBase.getFooterWalmartMenu().openAllDepartmentsPage();
        Assert.assertTrue(allDepartmentsPage.isPageOpened(), "All Department page is not opened");

    }

    @Test
    @MethodOwner(owner = "cezeokeke")
    public void testStoreDirectory(){
        WalmartHomePageBase walmartHomePageBase = initPage(getDriver(), WalmartHomePageBase.class);
        walmartHomePageBase.open();
        Assert.assertTrue(walmartHomePageBase.isPageOpened(), "Walmart Home page is not opened");

        StoreDirectoryPageBase storeDirectoryPage = walmartHomePageBase.getFooterWalmartMenu().openStoreDirectoryPage();
        Assert.assertTrue(storeDirectoryPage.isPageOpened(), "Store Directory is not opened");
    }



    @Test
    @MethodOwner(owner = "cezeokeke")
    public void testDepartment(){
        WalmartHomePageBase walmartHomePageBase = initPage(getDriver(), WalmartHomePageBase.class);
        walmartHomePageBase.open();
        Assert.assertTrue(walmartHomePageBase.isPageOpened(), "Walmart Home page is not opened");

        AllDepartmentsPageBase allDepartmentsPage = walmartHomePageBase.getFooterWalmartMenu().openAllDepartmentsPage();
        Assert.assertTrue(allDepartmentsPage.isPageOpened(), "All Department page is not opened");

        final String departmentName = "Books";
        DepartmentPageBase departmentPage = allDepartmentsPage.selectDepartment(departmentName);
        List<GenreItem> genres = departmentPage.getGenres();
        SoftAssert softAssert = new SoftAssert();
        for(GenreItem genreItem : genres){
            softAssert.assertFalse(genreItem.readGenre().contains(departmentName),
                "Genre" + genreItem.readGenre() + "should not include department" + departmentName + "in name");
        }
        softAssert.assertAll();
    }

}
