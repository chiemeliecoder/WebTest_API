package com.solvd.laba.qa.carina.demo.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class AllDepartmentsPageBase extends AbstractPage {

  public AllDepartmentsPageBase(WebDriver driver) {
    super(driver);
    setPageURL("/all-departments");
  }

  public abstract DepartmentPageBase selectDepartment(String departmentName);
}
