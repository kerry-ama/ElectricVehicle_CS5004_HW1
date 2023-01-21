import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;



/**
 * This class tests the Electric Vehicle class instances and methods.
 *
 */
public class testElectricVehicle {
  private ElectricVehicle Ford;
  private ElectricVehicle Tesla;
  private ElectricVehicle Mercedes;



  /**
   * Creates Electric Vehicle object instances.
   */
  @Before
  public void setUp() {
    Ford = new ElectricVehicle("MachE", 68,
            0.95, 2.0);
    Tesla = new ElectricVehicle("Tesla Model S", 200,
            2.0, 5.0);
    Mercedes = new ElectricVehicle("Mercedes EQS", 7.0,
            0.0, 0.0);

  }

  /**
   * The 'testEfficiency' method tests the 'getEfficiency' method
   * of the Electric Vehicle class.
   */
  @Test
  public void testEfficiency() {
    assertEquals(2.0, Ford.getEfficiency(), 0.001);
    assertEquals(4.5, Tesla.getEfficiency(), 0.001);
    assertEquals(0.5, Mercedes.getEfficiency(), 0.001);
  }

  /**
   * The 'testBatterySize' method tests the 'getBatterySize' method
   * of the Electric Vehicle class.
   */
  @Test
  public void testBatterySize() {
    assertEquals(68, Ford.getBatterySize(), 0.001);
    assertEquals(150.0, Tesla.getBatterySize(), 0.001);
    assertEquals(10.0, Mercedes.getBatterySize(), 0.001);
  }

  /**
   * The 'testStateOfCharge' method tests the 'getStateOfCharge' method
   * of the Electric Vehicle class.
   */
  @Test
  public void testStateOfCharge() {
    assertEquals(0.95, Ford.getStateOfCharge(), 0.001);
    assertEquals(1.0, Tesla.getStateOfCharge(), 0.001);
    assertEquals(0.15, Mercedes.getStateOfCharge(), 0.001);
  }

  /**
   * The 'testNameEV' method tests the 'getName' method of the
   * Electric Vehicle class.
   */
  @Test
  public void testNameEV() {
    assertEquals("MachE",Ford.getName());
    assertEquals("Tesla Model S", Tesla.getName());
    assertEquals("Mercedes EQS", Mercedes.getName());
  }

  /**
   * The 'testToString' method tests the 'toString' method
   * of the Electric Vehicle class.
   */
  @Test
  public void testToString() {
    assertEquals("MachE SOC: 95.0% Range (miles): 129.2", Ford.toString());
    assertEquals("Tesla Model S SOC: 100.0% Range (miles): 675.0", Tesla.toString());
    assertEquals("Mercedes EQS SOC: 15.0% Range (miles): 0.8", Mercedes.toString());
  }

  /**
   * The 'testRange' method tests the 'range' method of the Electric
   * Vehicle class.
   */
  @Test
  public void testRange() {
    assertEquals(129.2 ,Ford.range(), 0.001);
    assertEquals(675.0, Tesla.range(), 0.001);
    assertEquals(0.75, Mercedes.range(), 0.001);
  }

  /**
   * The 'testUpdateEfficiency' method tests the 'updateEfficiency' method of
   * the Electric Vehicle class. Current temps within all
   * possible ranges are tested.
   */
  @Test
  public void testUpdateEfficiency() {
    double currentTempF = 70.0;
    double currentTempT = 100.0;
    double currentTempM = 10.0;
    Ford.updateEfficiency(currentTempF);
    Tesla.updateEfficiency(currentTempT);
    Mercedes.updateEfficiency(currentTempM);
    assertEquals(2.0, Ford.getEfficiency(), 0.001);
    assertEquals(3.825, Tesla.getEfficiency(), 0.001);
    assertEquals(0.25, Mercedes.getEfficiency(), 0.001);
  }
}
