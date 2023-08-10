package com.solvd.laba.qa.carina.demo.gui.enums;

public enum Product {

  PRODUCT_1("Banana Fish - Ash Lynx (Re-run) Nendoroid","$38.99"),
  PRODUCT_2("The Legend of Zelda - Zelda Nendoroid (Breath of the Wild Ver.)","$44.99"),
  PRODUCT_3("My Teen Romantic Comedy SNAFU Climax - Yukino Yukinoshita Figure","$119.99");

  private final String name;
  private final String price;

  Product(String name, String price) {
    this.name = name;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public String getPrice() {
    return price;
  }
}
