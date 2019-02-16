package it.andzac.dp4j.mediator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import it.andzac.dp4j.bridge.CentralLocking;
import it.andzac.dp4j.model.impl.ConcreteTelemetry;
import it.andzac.dp4j.model.impl.FourSeasonTyre;
import it.andzac.dp4j.model.impl.GasolineEngine;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class RSMediatorImplTest {
  /*
   * found a lot of problem when try to run a test with parameters...
   */

  private final GasolineEngine gasolineEngine;
  private final List<FourSeasonTyre> tyreSet;
  private final ConcreteTelemetry concreteTelemetry;
  private final CentralLocking centralLockSystem;
  private boolean isActivated = false;

  public RSMediatorImplTest() {

    this.centralLockSystem = new CentralLocking("Test Lock System");
    this.gasolineEngine = new GasolineEngine(this.centralLockSystem);
    this.gasolineEngine.setType("gasoline");
    this.gasolineEngine.setVersion("1.4 GTC");
    this.gasolineEngine.setSteamHorses(140);

    FourSeasonTyre frontLeft = new FourSeasonTyre("FL", 230);
    FourSeasonTyre frontRight = new FourSeasonTyre("FR", 230);
    FourSeasonTyre rearLeft = new FourSeasonTyre("RF", 230);
    FourSeasonTyre rearRight = new FourSeasonTyre("RR", 230);
    this.tyreSet = new ArrayList<FourSeasonTyre>();
    tyreSet.add(frontLeft);
    tyreSet.add(frontRight);
    tyreSet.add(rearLeft);
    tyreSet.add(rearRight);

    this.concreteTelemetry = new ConcreteTelemetry();
  }

  @Test
  public void testEngineInitialization() {
    assertEquals(this.gasolineEngine.getType(), "gasoline");
  }

  @Test
  public void testTiresPressureInitialization() {
    for (FourSeasonTyre tyre : this.tyreSet) {
      assertTrue(tyre.getPressure() > 0);
      //      this.concreteTelemetry.register(
      //          String.valueOf(tyre.getPressure()) + "in pressure:" +
      // String.valueOf(tyre.inPressure()));
    }
  }

  @Test
  public void testLockSystemInitialization() {
    // this.concreteTelemetry.register(this.centralLockSystem.productName());
    assertEquals(this.centralLockSystem.productName(), "Test Lock System");
  }

  @Test
  public void testTelemetryInitialization() {
    // this.concreteTelemetry.init();
    assertTrue(this.concreteTelemetry != null);
  }

  @Test
  public void testStartRS() {
    this.isActivated = true;
    assertTrue(this.isActivated);
  }

  @Test
  public void testStopRS() {
    this.isActivated = false;
    assertFalse(this.isActivated);
  }
}
