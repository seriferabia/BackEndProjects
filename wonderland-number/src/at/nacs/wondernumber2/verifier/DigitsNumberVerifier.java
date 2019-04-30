package at.nacs.wondernumber2.verifier;

public class DigitsNumberVerifier implements Verifier {
  private final int NUMBER_OF_DIGITS = 6;

  public boolean verify(int number) {
    return (int) (Math.log10(number) + 1) == NUMBER_OF_DIGITS;
  }
}
