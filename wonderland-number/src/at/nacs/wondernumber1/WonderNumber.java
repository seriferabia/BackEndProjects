package at.nacs.wondernumber1;

import at.nacs.wondernumber1.controller.MultipliedNumberVerifier;
import at.nacs.wondernumber1.controller.NumberOfDigitsIdentifier;

import java.util.stream.IntStream;

public class WonderNumber {
  private int possibleMin = NumberOfDigitsIdentifier.getPossibleMinWonderNumber();
  private int possibleMax = NumberOfDigitsIdentifier.getPossibleMaxWonderNumber();
  private MultipliedNumberVerifier verifier = new MultipliedNumberVerifier();

  public int find() {
    return IntStream.rangeClosed(possibleMin, possibleMax)
                    .dropWhile(e -> !verifier.verify(e))
                    .findFirst().orElseThrow();
  }
}