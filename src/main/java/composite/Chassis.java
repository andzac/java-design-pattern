package composite;

import java.util.List;

public abstract class Chassis {
  public abstract String getName();

  public void addChassisLayer(Chassis chassis) {
    throw new UnsupportedOperationException("Current operation not supported");
  }

  public void removeChassisLayer(Chassis chassis) {
    throw new UnsupportedOperationException("Current operation not supported");
  }

  public List<Chassis> getChassisLayers() {
    throw new UnsupportedOperationException("Current operation not supported");
  }

  public abstract String checkChassis();
}
