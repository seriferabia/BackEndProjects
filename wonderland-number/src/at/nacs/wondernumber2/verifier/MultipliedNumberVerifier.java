package wondernumber2.verifier;

import java.util.List;

public class MultipliedNumberVerifier implements Verifier {
  private List<Integer> multipliers = Multipliers.asList();
  private SameDigitsController controller = new SameDigitsController();

  public boolean verify(int number) {
    return multipliers.stream()
                      .map(multiplier -> multiplier * number)
                      .allMatch(multipliedNumber -> controller.check(multipliedNumber, number));
  }
}
