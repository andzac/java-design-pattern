package it.andzac.dp4j.composite;

import java.util.ArrayList;
import java.util.List;

public class ChassisParentElement extends Chassis {
  private String idSeries;
  private String name;
  private List<Chassis> childrenLayers = new ArrayList<Chassis>();

  public ChassisParentElement(String name) {
    this.idSeries = "000-PCE";
    this.name = name;
  }

  @Override
  public String getName() {
    return this.name;
  }

  public String getIdSeries() {
    return idSeries;
  }

  @Override
  public void addChassisLayer(Chassis chassis) {
    this.childrenLayers.add(chassis);
  }

  @Override
  public void removeChassisLayer(Chassis chassis) {
    this.childrenLayers.remove(chassis);
  }

  @Override
  public List<Chassis> getChassisLayers() {
    return this.childrenLayers;
  }

  @Override
  public String checkChassis() {
    String res = "[" + getIdSeries() + "]" + " " + getName() + " have components..\n";
    for (Chassis c : childrenLayers) {
      res += " - " + c.checkChassis();
    }
    return res;
  }
}
