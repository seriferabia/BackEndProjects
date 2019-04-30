package at.nacs.wondernumber1.controller;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SameDigitsController {
  public boolean check(Integer multipliedNumber, Integer originalNumber) {
    return sortDigitsOf(originalNumber).equals(sortDigitsOf(multipliedNumber));
  }

  String sortDigitsOf(Integer number) {
    return Stream.of(number.toString().split(""))
                 .sorted()
                 .collect(Collectors.joining());
  }
}
