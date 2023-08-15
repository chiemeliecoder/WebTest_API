package com.solvd.laba.qa.carina.demo;


import org.testng.annotations.DataProvider;

public class PageDataProvider {

  @DataProvider(name = "productTestData")
  public Object[][] getProductTestData() {
    return new Object[][] {
        {"Bobobo-bo Bo-bobo - Bobobo-bo Bo-bobo Nendoroid", "$45.99"},
        // Add more data as needed
    };
  }

}
