package at.nacs.wondernumber2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WonderNumberTest {
  private WonderNumber wonderNumber = new WonderNumber();

  @Test
  void find() {
    int actual = wonderNumber.find();
    assertEquals(actual, 142857);
  }
}