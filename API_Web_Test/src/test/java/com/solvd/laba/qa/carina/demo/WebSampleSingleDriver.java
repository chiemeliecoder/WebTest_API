package com.solvd.laba.qa.carina.demo;

import com.solvd.laba.qa.carina.demo.gui.components.footer.FooterWalmartMenuBase;
import com.solvd.laba.qa.carina.demo.gui.pages.common.AllDepartmentsPageBase;
import com.solvd.laba.qa.carina.demo.gui.pages.common.HomePageBase;
import com.solvd.laba.qa.carina.demo.gui.pages.common.StoreDirectoryPageBase;


import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;

/**
 * This sample shows how create Web test with dependent methods which shares existing driver between methods.
 *
 * @author qpsdemo
 */
public class WebSampleSingleDriver implements IAbstractTest {


    private HomePageBase walmartHomePageBase;
    private AllDepartmentsPageBase allDepartmentsPage;
    private StoreDirectoryPageBase storeDirectoryPage;


    @BeforeSuite
    public void startWalmartDriver(){
        walmartHomePageBase = initPage(getDriver(), HomePageBase.class);
    }


    @Test()
    @MethodOwner(owner = "cezeokeke")
    public void testWalmartOpenPage(){
        walmartHomePageBase.open();
        Assert.assertTrue(walmartHomePageBase.isPageOpened(), "Walmart Home page is not opened");
    }

    @Test(dependsOnMethods="testWalmartOpenPage") //for dependent tests Carina keeps driver sessions by default
    @MethodOwner(owner = "cezeokeke")
    public void testOpenAllDepartment(){

        FooterWalmartMenuBase footerWalmartMenuBase = walmartHomePageBase.getFooterWalmartMenu();
        Assert.assertTrue(footerWalmartMenuBase.isUIObjectPresent(2), "Footer menu wasn't found!");
        allDepartmentsPage.isPageOpened();
    }

    @Test(dependsOnMethods="testWalmartOpenPage") //for dependent tests Carina keeps driver sessions by default
    @MethodOwner(owner = "cezeokeke")
    public void testOpenStoreDirectory(){
        FooterWalmartMenuBase footerWalmartMenuBase = walmartHomePageBase.getFooterWalmartMenu();
        Assert.assertTrue(footerWalmartMenuBase.isUIObjectPresent(2), "Footer menu wasn't found!");
        storeDirectoryPage.isPageOpened();
    }





}
