package model;

public class Engine {
  private int fuelAmount = 100;
  private int ampereAmount = 80;
  private String version;
  private String steamHorses;
  private String type;
  private boolean isStarted = false;
  private boolean isReady = false;
  private boolean isError = false;
  private boolean checkTempOk = false;
  private boolean checkFuelOk = false;
  private boolean checkElettricityOk = false;
  private boolean checkCPUOk = false;
  private boolean checkGearInitOk = false;

  // components
  private CPU cpu;
  private Gear gear;

  public Engine() {
    cpu = new CPU();
    gear = new Gear();
  }

  public void boot() {
    isStarted = true;
    System.out.println("Boot started");
  }

  public void checkTemperature(int value) {
    if (value > 0 && value < 40) {
      System.out.println("Check temperature OK");
      checkTempOk = true;
    }
  }

  public void checkFuel() {
    if (fuelAmount > 0) {
      System.out.println("Check fuel OK");
      checkFuelOk = true;
    } else {
      System.out.println("Error - not enough fuel!!");
      isError = true;
    }
  }

  public void checkElettricity() {
    if (ampereAmount > 0) {
      System.out.println("Check elettricity OK");
      checkElettricityOk = true;
    } else {
      System.out.println("Error - no energy!!");
      isError = true;
    }
  }

  public void checkCPUOk() {
    if (cpu.isActive()) {
      System.out.println("Check CPU OK");
      checkCPUOk = true;
    }
  }

  public void checkGearOk() {
    if (gear.isActive()) {
      System.out.println("Check Gear OK");
      checkGearInitOk = true;
    }
  }

  public void shutdown() {
    System.out.println("The engine is stopped");
    isStarted = false;
    isReady = false;
    checkCPUOk = false;
    checkGearInitOk = false;
    checkElettricityOk = false;
    checkFuelOk = false;
    checkTempOk = false;
  }

  public void ready() {
    if (isStarted
        && checkCPUOk
        && checkGearInitOk
        && checkElettricityOk
        && checkFuelOk
        && checkTempOk) {
      System.out.println("Engine successfully started and ready");
      isReady = true;
    } else {
      isError = true;
      System.out.println("Engine error");
    }
  }

  // Engine components classes

  public class CPU {
    private static final boolean IS_ACTIVE = true;

    public boolean isActive() {
      return IS_ACTIVE;
    }
  }

  public class Gear {
    private static final boolean IS_ACTIVE = true;

    public boolean isActive() {
      return IS_ACTIVE;
    }
  }
}
