package it.andzac.dp4j.bridge;

public class CentralLocking implements Locksystem {
  private final String productName;

  public CentralLocking(String productName) {
    this.productName = productName;
  }

  public String productName() {
    return productName;
  }

  public void initSystem() {
    System.out.println("Init for the system Central Locking...");
  }
}
