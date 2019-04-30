package wondernumber1.controller;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SameDigitsControllerTest {
  private SameDigitsController controller = new SameDigitsController();

  @ParameterizedTest
  @CsvSource({
      "12, 21, true",
      "1928, 2891, true",
      "80436,64083, true",
      "1234, 5123, false",
      "1029,1829, false"})
  void testCheck(int number1, int number2, boolean expected) {

    assertEquals(controller.check(number1, number2), expected);
  }

  @ParameterizedTest
  @CsvSource({
      "1928, 1289",
      "80436,03468"})
  void sortDigitsOf(int number, String expected) {

    assertEquals(controller.sortDigitsOf(number), expected);
  }
}