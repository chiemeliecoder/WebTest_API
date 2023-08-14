package com.solvd.laba.qa.carina.demo;

import com.solvd.laba.qa.carina.demo.gui.components.MerchItem;
import com.solvd.laba.qa.carina.demo.gui.pages.common.HomePageBase;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import java.util.List;
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

  }

}
