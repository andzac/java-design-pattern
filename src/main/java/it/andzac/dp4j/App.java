package it.andzac.dp4j;

import composite.ChassisParentElement;
import facade.ChassisFacade;
import model.Engine;

/** Hello world! */
public class App {
  public static void main(String[] args) {
    int temp = 15;
    Engine engine = new Engine();

    //    System.out.println("###### FACADE DESIGN PATTERN APPLICATION ######");
    //    EngineFacade engineFacade = new EngineFacade(engine);
    //    engineFacade.startEngine(temp);
    //    engineFacade.stopEngine();
    //    System.out.println("###### END FACADE DESIGN PATTERN APPLICATION ######");

    System.out.println("###### START COMPOSITE DESIGN PATTERN APPLICATION ######");
    ChassisParentElement chassisParentElement = new ChassisParentElement("Chassis Parent 1");
    ChassisFacade chassisFacade = new ChassisFacade(chassisParentElement);
    System.out.println(chassisFacade.checkChassis());
    System.out.println("###### END COMPOSITE DESIGN PATTERN APPLICATION ######");
  }
}
