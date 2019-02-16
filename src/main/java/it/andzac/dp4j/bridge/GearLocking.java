package it.andzac.dp4j.bridge;

public class GearLocking implements Locksystem {
  private final String productName;

  public GearLocking(String productName) {
    this.productName = productName;
  }

  public String productName() {
    return productName;
  }

  public void initSystem() {
    System.out.println("Init for the system Gear Locking...");
  }
}
