package com.solvd.laba.qa.carina.demo.gui.enums;

public enum Category {
  NEW_NENDOROIDS("NEW NENDOROIDS"),
  WEEKLY_SPECIALS(" WEEKLY SPECIALS"),
  SPYXFAMILY_MERCH("SPYXFAMILY MERCH"),
  NON_SCALE_FIGURES("NON-SCALE FIGURES"),
  NEW_HOME_VIDEO("NEW HOME VIDEO"),
  VIDEO_GAME_MERCH("VIDEO GAME MERCH"),
  BEST_ANIME_GIRLS("BEST ANIME GIRLS"),
  NEW_PRE_ORDERS("NEW PRE-ORDERS");

  private final String name;

  Category(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
