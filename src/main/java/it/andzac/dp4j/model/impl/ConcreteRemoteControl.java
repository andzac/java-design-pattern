package it.andzac.dp4j.model.impl;

import it.andzac.dp4j.mediator.RSMediator;
import it.andzac.dp4j.mediator.RSMediatorImpl;
import it.andzac.dp4j.model.interfaces.RemoteControl;

public class ConcreteRemoteControl implements RemoteControl {
  private RSMediatorImpl mediator;

  public void setMediator(RSMediator mediator) {
    this.mediator = (RSMediatorImpl) mediator;
  }

  public void activateRS() {
    mediator.telemetryInitialization();
    mediator.engineInitialization();
    mediator.lockSystemInitialization();
    mediator.tiresPressureInitialization();
    mediator.startRS();
  }

  public void stopRS() {
    mediator.stopRS();
  }
}
