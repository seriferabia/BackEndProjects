package at.nacs.wondernumber1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WonderNumberTest {
  private WonderNumber wonderNumber = new WonderNumber();

  @Test
  void testFind() {
    int actual = wonderNumber.find();
    assertEquals(actual,142857);
  }
}