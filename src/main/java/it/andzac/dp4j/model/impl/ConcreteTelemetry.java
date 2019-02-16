package it.andzac.dp4j.model.impl;

import it.andzac.dp4j.model.interfaces.Telemetry;

public class ConcreteTelemetry implements Telemetry {

  public void init() {
    System.out.println("### [ TELEMETRY INIT OK ] ###");
  }

  public void register(String value) {
    System.out.println("### [TELEMETRY INFO] ###: " + value);
  }
}
