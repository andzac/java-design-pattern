package it.andzac.dp4j.facade;

import model.Engine;

public class EngineFacade {
  private final Engine engine;

  public EngineFacade(Engine engine) {
    this.engine = engine;
  }

  public void startEngine(int tempVal) {
    engine.boot();
    engine.checkTemperature(tempVal);
    engine.checkElettricity();
    engine.checkFuel();
    engine.checkCPUOk();
    engine.checkGearOk();
    engine.ready();
  }

  public void stopEngine() {
    engine.shutdown();
  }
}
