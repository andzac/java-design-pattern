package it.andzac.dp4j;

import it.andzac.dp4j.bridge.CentralLocking;
import it.andzac.dp4j.composite.ChassisParentElement;
import it.andzac.dp4j.facade.ChassisFacade;
import it.andzac.dp4j.facade.EngineFacade;
import it.andzac.dp4j.mediator.RSMediator;
import it.andzac.dp4j.mediator.RSMediatorImpl;
import it.andzac.dp4j.model.impl.ConcreteRemoteControl;
import it.andzac.dp4j.model.impl.ConcreteTelemetry;
import it.andzac.dp4j.model.impl.FourSeasonTyre;
import it.andzac.dp4j.model.impl.GasolineEngine;
import java.util.ArrayList;
import java.util.List;

public class App {
  public static void main(String[] args) {
    int temp = 15;
    List<FourSeasonTyre> tyreSet;

    /** switch of locking system at runtime */
    CentralLocking locksystem = new CentralLocking("CLS for Auto");
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

    System.out.println("###### START MEDIATOR DESIGN PATTERN APPLICATION ######");
    ConcreteRemoteControl remoteControl = new ConcreteRemoteControl();
    ConcreteTelemetry telemetrySystem = new ConcreteTelemetry();

    FourSeasonTyre frontLeft = new FourSeasonTyre("FL", 230);
    FourSeasonTyre frontRight = new FourSeasonTyre("FR", 230);
    FourSeasonTyre rearLeft = new FourSeasonTyre("RF", 230);
    FourSeasonTyre rearRight = new FourSeasonTyre("RR", 230);
    tyreSet = new ArrayList<FourSeasonTyre>();
    tyreSet.add(frontLeft);
    tyreSet.add(frontRight);
    tyreSet.add(rearLeft);
    tyreSet.add(rearRight);

    RSMediator mediator = new RSMediatorImpl(gasolineEngine, tyreSet, telemetrySystem, locksystem);
    remoteControl.setMediator(mediator);
    remoteControl.activateRS();
    remoteControl.stopRS();
  }
}
