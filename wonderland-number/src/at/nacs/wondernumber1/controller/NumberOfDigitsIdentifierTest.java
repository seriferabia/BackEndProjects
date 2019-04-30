package at.nacs.wondernumber1.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberOfDigitsIdentifierTest {
  private final int MAX_MULTIPLIER = 6;

  @Test
  void testGetPossibleMinWonderNumber() {
    Integer possibleMinWonderNumber = NumberOfDigitsIdentifier.getPossibleMinWonderNumber();
    int actualLength = possibleMinWonderNumber.toString().length();
    assertEquals(actualLength, 6);
    assertEquals(possibleMinWonderNumber, 100000);
  }

  @Test
  void testGetPossibleMaxWonderNumber() {
    int possibleMaxWonderNumber = NumberOfDigitsIdentifier.getPossibleMaxWonderNumber();
    Integer possibleMaxMultipliedNumber = possibleMaxWonderNumber * MAX_MULTIPLIER;
    int lengthOfPossibleMaxMultipliedNumber = possibleMaxMultipliedNumber.toString().length();
    assertEquals(lengthOfPossibleMaxMultipliedNumber, 6);
  }
}