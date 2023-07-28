package com.solvd.laba.qa.carina.demo;

import static org.testng.AssertJUnit.assertEquals;

import com.solvd.laba.qa.carina.demo.gui.components.GenreItem;
import com.solvd.laba.qa.carina.demo.gui.pages.common.AllDepartmentsPageBase;
import com.solvd.laba.qa.carina.demo.gui.pages.common.DepartmentPageBase;
import com.solvd.laba.qa.carina.demo.gui.pages.common.HomePageBase;
import com.solvd.laba.qa.carina.demo.gui.pages.common.StoreDirectoryPageBase;

import com.solvd.laba.qa.carina.demo.gui.pages.desktop.HomePage;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import java.time.Duration;
import java.util.List;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
    public void testSeleniumFirst() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        String title = driver.getTitle();
        assertEquals("Web form", title);

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        WebElement textBox = driver.findElement(By.name("my-text"));
        WebElement submitButton = driver.findElement(By.cssSelector("button"));

        textBox.sendKeys("Selenium");
        submitButton.click();

        WebElement message = driver.findElement(By.id("message"));
        String value = message.getText();
        assertEquals("Received!", value);

        driver.quit();
    }

    @Test
    @MethodOwner(owner = "cezeokeke")
    @TestLabel(name = "feature", value = { "web", "regression" })
    public void testWalmartHomePage() {
        HomePage walmartHomePageBase = new HomePage(getDriver());
        walmartHomePageBase.open();
        Assert.assertTrue(walmartHomePageBase.isPageOpened(), "Walmart Home page is not opened");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertAll();


    }



    @Test
    @MethodOwner(owner = "cezeokeke")
    public void testAllDepartments(){
        HomePageBase walmartHomePageBase = initPage(getDriver(), HomePageBase.class);
        walmartHomePageBase.open();
        Assert.assertTrue(walmartHomePageBase.isPageOpened(), "Walmart Home page is not opened");

        AllDepartmentsPageBase allDepartmentsPage = walmartHomePageBase.getFooterWalmartMenu().openAllDepartmentsPage();
        Assert.assertTrue(allDepartmentsPage.isPageOpened(), "All Department page is not opened");

    }

    @Test
    @MethodOwner(owner = "cezeokeke")
    public void testStoreDirectory(){
        HomePageBase walmartHomePageBase = initPage(getDriver(), HomePageBase.class);
        walmartHomePageBase.open();
        Assert.assertTrue(walmartHomePageBase.isPageOpened(), "Walmart Home page is not opened");

        StoreDirectoryPageBase storeDirectoryPage = walmartHomePageBase.getFooterWalmartMenu().openStoreDirectoryPage();
        Assert.assertTrue(storeDirectoryPage.isPageOpened(), "Store Directory is not opened");
    }



    @Test
    @MethodOwner(owner = "cezeokeke")
    public void testDepartment(){
        HomePageBase walmartHomePageBase = initPage(getDriver(), HomePageBase.class);
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
