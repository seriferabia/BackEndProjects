package at.nacs.wondernumber1.controller;

import java.util.List;

public class MultipliedNumberVerifier {
  private List<Integer> multipliers = Multipliers.asList();
  private SameDigitsController controller = new SameDigitsController();

  public boolean verify(int number) {
    return multipliers.stream()
                      .map(multiplier -> multiplier * number)
                      .allMatch(multipliedNumber -> controller.check(multipliedNumber, number));
  }
}
