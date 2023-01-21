import java.text.DecimalFormat;

/**
 * This class represents an electric vehicle. The attributes of the class include
 * the Electric vehicle's name, battery size, state of charge, current efficiency,
 * and default efficiency.
 */

public class ElectricVehicle {
  private String name;
  private double batterySize;
  private double stateOfCharge;
  private double currentEfficiency;
  private double defaultEfficiency;

  /**
   * Construct an Electric Vehicle object that has the provided name battery size,
   * state of charge, and default efficiency.
   *
   * @param name              the name of the Electric Vehicle (may not null nor empty string)
   * @param batterySize       minimum battery size is 10 kilowatt-hours (kWh) and maximum 150 kWh
   * @param stateOfCharge     ranges from 0.15 to 1.0.
   * @param defaultEfficiency minimum default efficiency is 0.5, maximum default efficiency is 4.5
   */
  public ElectricVehicle(String name, double batterySize,
                         double stateOfCharge, double defaultEfficiency) {
    if (name == null || name == "") {
      name = "unknown EV";
    }
    this.name = name;

    if (batterySize < 10.0) {
      batterySize = 10.0;
    } else if (batterySize > 150.0) {
      batterySize = 150.0;
    }
    this.batterySize = batterySize;

    if (stateOfCharge < 0.15) {
      stateOfCharge = 0.15;
    } else if (stateOfCharge > 1.0) {
      stateOfCharge = 1.0;
    }
    this.stateOfCharge = stateOfCharge;

    if (defaultEfficiency < 0.5) {
      defaultEfficiency = 0.5;
    } else if (defaultEfficiency > 4.5) {
      defaultEfficiency = 4.5;
    }
    //this.defaultEfficiency is the attribute; right side = parameter/value
    this.defaultEfficiency = defaultEfficiency;
    this.currentEfficiency = this.defaultEfficiency;
  }

  /**
   * This getter method returns the current efficiency, NOT the default efficiency.
   * @return the efficiency of the electric vehicle (up to 16 decimal places)
   */
  public double getEfficiency() {
    return this.currentEfficiency;
  }

  /**
   * This getter method returns the battery size of the electric vehicle.
   * @return the battery size of the electric vehicle (up to 16 decimal places)
   */
  public double getBatterySize() {
    return this.batterySize;
  }

  /**
   * This getter method returns the state of charge of the electric vehicle.
   * @return the state of charge of the electric vehicle (up to 16 decimal places)
   */
  public double getStateOfCharge() {
    return this.stateOfCharge;
  }

  /**
   * This getter method returns the name of the electric vehicle.
   * @return the name of the electric vehicle
   */
  public String getName() {
    return this.name;
  }

  /**
   * This setter method sets the current state of charge of the electric vehicle.
   * @param stateOfCharge current state of charge of the electric vehicle.
   */
  public void setStateOfCharge(double stateOfCharge) {
    if (stateOfCharge < 0.15) {
      stateOfCharge = 0.15;
    } else if (stateOfCharge > 1.0) {
      stateOfCharge = 1.0;
    }
    this.stateOfCharge = stateOfCharge;
  }

  /**
   * This is a calculation method that calculates the range of the electric vehicle
   * by multiplying the current efficiency by the state of charge and battery size.
   * @return result of multiplying the current efficiency by the state of charge
   *         and battery size
   */
  public double range() {
    double result = this.currentEfficiency * this.stateOfCharge * this.batterySize;
    return result;
  }

  /**
   * This method takes a double representing the current temperature in Fahrenheit
   * and updates the Electric vehicle's current efficiency. If the current temperature
   * is greater than or equal to 65F and less than or equal to 77F, the current efficiency
   * equals the default efficiency. If current temp above 77F the current efficiency is
   * 85% the default efficiency. Lastly,current temp < 65.0F then the current efficiency
   * is reduced by 1% for every degree fahrenheit below 65 degrees, up to a maximum decrease of 50%.
   * @param currentTemp the temperature in degrees Fahrenheit
   */
  public void updateEfficiency(double currentTemp) {
    if ((65.0 <= currentTemp) && (currentTemp <= 77.0)) {
      //currentEfficiency is 100% defaultEfficiency
      this.currentEfficiency = this.defaultEfficiency;
    } else if (currentTemp > 77.0) {
      this.currentEfficiency = 0.85 * this.defaultEfficiency;
    } else if (currentTemp < 65.0) {
      double decreaseDegree = 65.0 - currentTemp;
      if (decreaseDegree > 50.0) {
        decreaseDegree = 50.0;
      }
      this.currentEfficiency = (1 - (decreaseDegree / 100)) * this.defaultEfficiency;
      //STUB: add toString method
    }
  }

  /**
   *  This method allows Electric Vehicle objects to be represented as a String,
   *  describing its name, state of charge (in percent, not decimal form) and range.
   * @return a string that displays the current state of charge and range in miles of
   *         the electric vehicle object.
   */
  public String toString() {
    DecimalFormat percentage = new DecimalFormat("00.0%");
    DecimalFormat miles = new DecimalFormat("0.0");
    return this.name + " " + "SOC: " + percentage.format(this.getStateOfCharge())
            + " " + "Range (miles): " + miles.format(this.range());

  }

}