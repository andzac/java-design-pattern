package it.andzac.dp4j.model.impl;

import it.andzac.dp4j.model.interfaces.Tyre;

public class FourSeasonTyre implements Tyre {
  private static final int PRESSURE_NORMAL = 230;
  private int pressure;
  private String identificationLabel;
  private boolean isInPressure = false;

  public FourSeasonTyre(String identificationLabel, int pressure) {
    this.pressure = pressure;
    setLabel(identificationLabel);

    if ((pressure > (PRESSURE_NORMAL / 2)) && this.pressure <= PRESSURE_NORMAL) {
      isInPressure = true;
    }
  }

  public int getPressure() {
    return pressure;
  }

  public void setLabel(String identificationLabel) {
    this.identificationLabel = identificationLabel;
  }

  public boolean inPressure() {
    return isInPressure;
  }
}
