package it.andzac.dp4j;

import it.andzac.dp4j.bridge.CentralLocking;
import it.andzac.dp4j.bridge.Locksystem;
import it.andzac.dp4j.composite.ChassisParentElement;
import it.andzac.dp4j.facade.ChassisFacade;
import it.andzac.dp4j.facade.EngineFacade;
import it.andzac.dp4j.model.GasolineEngine;

public class App {
  public static void main(String[] args) {
    int temp = 15;

    /** switch of locking system at runtime */
    Locksystem locksystem = new CentralLocking("CLS for Auto");
    // Locksystem locksystem2 = new GearLocking("GLS for AUto");

    GasolineEngine gasolineEngine = new GasolineEngine(locksystem);
    gasolineEngine.setType("gasoline");
    gasolineEngine.setVersion("1.4 GTC");
    gasolineEngine.setSteamHorses(140);

    System.out.println("###### FACADE DESIGN PATTERN APPLICATION ######");
    EngineFacade engineFacade = new EngineFacade(gasolineEngine);
    engineFacade.startEngine(temp);
    engineFacade.stopEngine();
    System.out.println("###### END FACADE DESIGN PATTERN APPLICATION ######");

    System.out.println("###### START COMPOSITE DESIGN PATTERN APPLICATION ######");
    ChassisParentElement chassisParentElement = new ChassisParentElement("Chassis Parent 1");
    ChassisFacade chassisFacade = new ChassisFacade(chassisParentElement);
    System.out.println(chassisFacade.checkChassis());
    System.out.println("###### END COMPOSITE DESIGN PATTERN APPLICATION ######");

    System.out.println("###### START BRIDGE DESIGN PATTERN APPLICATION ######");
    gasolineEngine.setAssociation();
    System.out.println("###### END BRIDGE DESIGN PATTERN APPLICATION ######");
  }
}
