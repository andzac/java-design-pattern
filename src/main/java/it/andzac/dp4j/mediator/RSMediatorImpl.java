package it.andzac.dp4j.mediator;

import it.andzac.dp4j.bridge.CentralLocking;
import it.andzac.dp4j.model.impl.ConcreteTelemetry;
import it.andzac.dp4j.model.impl.FourSeasonTyre;
import it.andzac.dp4j.model.impl.GasolineEngine;
import java.util.List;

public class RSMediatorImpl implements RSMediator {
  private final GasolineEngine gasolineEngine;
  private final List<FourSeasonTyre> tyreSet;
  private final ConcreteTelemetry concreteTelemetry;
  private final CentralLocking centralLockSystem;
  private boolean isActivated = false;

  public RSMediatorImpl(
      GasolineEngine engine,
      List<FourSeasonTyre> tyreSet,
      ConcreteTelemetry concreteTelemetry,
      CentralLocking centralLockSystem) {
    this.gasolineEngine = engine;
    this.tyreSet = tyreSet;
    this.concreteTelemetry = concreteTelemetry;
    this.centralLockSystem = centralLockSystem;
  }

  public void engineInitialization() {
    this.concreteTelemetry.register("engine defined and ready");
  }

  public void tiresPressureInitialization() {
    for (FourSeasonTyre tyre : this.tyreSet) {
      this.concreteTelemetry.register(
          String.valueOf(tyre.getPressure()) + " in pressure:" + String.valueOf(tyre.inPressure()));
    }
  }

  public void lockSystemInitialization() {
    this.concreteTelemetry.register(this.centralLockSystem.productName());
  }

  public void telemetryInitialization() {
    this.concreteTelemetry.init();
  }

  public void startRS() {
    this.isActivated = true;
    this.concreteTelemetry.register("RS Activated");
  }

  public void stopRS() {
    this.isActivated = false;
    this.concreteTelemetry.register("RS Stopped");
  }
}
