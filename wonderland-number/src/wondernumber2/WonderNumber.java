package wondernumber2;

import wondernumber2.verifier.Verifier;
import wondernumber2.verifier.Verifiers;

import java.util.List;
import java.util.stream.Stream;

public class WonderNumber {
  private List<Verifier> verifiers = Verifiers.asList();

  public int find() {
    return Stream.iterate(1, n -> n + 1)
                 .filter(e -> isWonderNumber(e))
                 .findFirst().orElseThrow();
  }

  private boolean isWonderNumber(Integer number) {
    return verifiers.stream()
                    .allMatch(verifier -> verifier.verify(number));
  }
}
