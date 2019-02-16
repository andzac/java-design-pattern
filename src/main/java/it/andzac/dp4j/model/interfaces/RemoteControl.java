package it.andzac.dp4j.model.interfaces;

import it.andzac.dp4j.mediator.RSMediator;

public interface RemoteControl {
  void setMediator(RSMediator mediator);

  void activateRS();

  void stopRS();
}
