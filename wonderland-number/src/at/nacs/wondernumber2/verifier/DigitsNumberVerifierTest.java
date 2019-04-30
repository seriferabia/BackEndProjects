package at.nacs.wondernumber2.verifier;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DigitsNumberVerifierTest {
  private DigitsNumberVerifier verifier = new DigitsNumberVerifier();

  @ParameterizedTest
  @CsvSource({
      "123,false",
      "123456,true",
      "1234567, false"})
  void testVerify(Integer number, Boolean expected) {
    assertEquals(verifier.verify(number), expected);
  }
}