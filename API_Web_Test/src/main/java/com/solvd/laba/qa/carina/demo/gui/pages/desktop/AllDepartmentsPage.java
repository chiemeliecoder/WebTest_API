package com.solvd.laba.qa.carina.demo.gui.pages.desktop;

import com.solvd.laba.qa.carina.demo.gui.pages.common.AllDepartmentsPageBase;
import com.solvd.laba.qa.carina.demo.gui.pages.common.DepartmentPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = AllDepartmentsPageBase.class)
public class AllDepartmentsPage extends AllDepartmentsPageBase {



  @FindBy(xpath = "//h1[@class='f2 mh4 mv4']")
  private ExtendedWebElement deptPageTitle;


  public AllDepartmentsPage(WebDriver driver) {

    super(driver);
    setPageURL("/all-departments");
  }

  public String getPageTitle() {
    return deptPageTitle.getText();
  }

  @Override
  public DepartmentPageBase selectDepartment(String departmentName){
    departmentName = departmentName.toLowerCase();
    for (ExtendedWebElement dept : findExtendedWebElements(By.xpath("//div[@class='flex flex-column']//a"))){
      if(dept.getText().contains(departmentName)){
        dept.click();
        return initPage(driver,DepartmentPageBase.class);
      }
    }
    throw new RuntimeException("Unable to open department page: " + departmentName);
  }

}
