package wondernumber1.controller;

public class NumberOfDigitsIdentifier {
  private static final int NUMBER_OF_DIGITS = 6;

  public static int getPossibleMinWonderNumber() {
    return (int) Math.pow(10, NUMBER_OF_DIGITS - 1);
  }

  public static int getPossibleMaxWonderNumber() {
    int maxMultiplier = Multipliers.asList().stream()
                                   .max(Integer::compare)
                                   .orElseThrow();
    return (int) Math.pow(10, NUMBER_OF_DIGITS) / maxMultiplier;
  }
}
