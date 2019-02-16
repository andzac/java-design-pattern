package it.andzac.dp4j.model;

import it.andzac.dp4j.bridge.Locksystem;

public class GasolineEngine extends Engine {

  private Locksystem locksystem;

  public GasolineEngine(Locksystem locksystem) {
    super(locksystem);
    this.locksystem = locksystem;
  }

  @Override
  public void setAssociation() {
    locksystem.initSystem();
    System.out.println(
        "Gasoline engine " + super.getVersion() + " with Locksystem " + locksystem.productName());
  }
}
