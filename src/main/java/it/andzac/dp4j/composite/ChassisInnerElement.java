package it.andzac.dp4j.composite;

public class ChassisInnerElement extends Chassis {
  private String idSeries;
  private String name;

  public ChassisInnerElement(String name) {
    this.idSeries = "000-ICE";
    this.name = name;
  }

  @Override
  public String getName() {
    return name;
  }

  public String getIdSeries() {
    return idSeries;
  }

  @Override
  public String checkChassis() {
    return getIdSeries() + " " + getName() + "\n";
  }
}
