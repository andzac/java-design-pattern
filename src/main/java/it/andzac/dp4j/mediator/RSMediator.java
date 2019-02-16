package it.andzac.dp4j.mediator;

public interface RSMediator {

  public void engineInitialization();

  public void tiresPressureInitialization();

  public void lockSystemInitialization();

  public void telemetryInitialization();

  public void startRS();

  public void stopRS();
}
