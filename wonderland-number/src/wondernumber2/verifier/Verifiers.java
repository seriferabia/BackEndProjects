package wondernumber2.verifier;

import java.util.List;

public class Verifiers {
  public static List<Verifier> asList() {
    return List.of(new DigitsNumberVerifier(), new MultipliedNumberVerifier());
  }
}
