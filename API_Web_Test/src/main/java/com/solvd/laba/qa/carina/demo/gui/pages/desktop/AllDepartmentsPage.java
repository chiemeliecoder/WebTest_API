package com.solvd.laba.qa.carina.demo.gui.pages.desktop;

import com.solvd.laba.qa.carina.demo.gui.pages.common.AllDepartmentsPageBase;
import com.solvd.laba.qa.carina.demo.gui.pages.common.DepartmentPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = AllDepartmentsPageBase.class)
public class AllDepartmentsPage extends AllDepartmentsPageBase {



  @FindBy(xpath = "//h2[@class='ma0']/a[@link-identifier='Books']")
  private ExtendedWebElement deptPageTitle;

  @FindBy(className = "flex-container")
  private ExtendedWebElement departmentMenu;

  public AllDepartmentsPage(WebDriver driver) {

    super(driver);
    //setUiLoadedMarker(departmentMenu);
    setUiLoadedMarker(deptPageTitle);
  }


  public String getPageTitle() {
    return deptPageTitle.getText();
  }

  // //h2[@class='ma0']/a[@link-identifier='Books']
  // //div[@class='flex flex-column']//a
  @Override
  public DepartmentPageBase selectDepartment(String departmentName){
    //departmentName = departmentName.equalsIgnoreCase("books");
    for (ExtendedWebElement dept : findExtendedWebElements(By.xpath("//h2[@class='ma0']/a[@link-identifier='Books']"))){
      if(dept.getText().contains(departmentName)){
        dept.click();
        return initPage(driver,DepartmentPageBase.class);
      }
    }
    throw new RuntimeException("Unable to open department page: " + departmentName);
  }

}
