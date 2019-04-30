package at.nacs.wondernumber1.controller;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MultipliedNumberVerifierTest {
  private MultipliedNumberVerifier verifier = new MultipliedNumberVerifier();

  @ParameterizedTest
  @CsvSource({
      "142857, true",
      "125874, false"
  })
  void verify(int number, boolean expected) {
    assertEquals(verifier.verify(number), expected);
  }
}