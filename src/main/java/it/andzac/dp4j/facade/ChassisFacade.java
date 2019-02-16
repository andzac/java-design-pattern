package it.andzac.dp4j.facade;

import it.andzac.dp4j.composite.ChassisInnerElement;
import it.andzac.dp4j.composite.ChassisParentElement;

public class ChassisFacade {
  private final ChassisParentElement chassis;

  public ChassisFacade(ChassisParentElement chassis) {
    this.chassis = chassis;
  }

  public String checkChassis() {
    // populate sub components
    ChassisInnerElement inner1 = new ChassisInnerElement("Chassis inner 1");
    ChassisInnerElement inner2 = new ChassisInnerElement("Chassis inner 2");

    chassis.addChassisLayer(inner1);
    chassis.addChassisLayer(inner2);

    return chassis.checkChassis();
  }
}
