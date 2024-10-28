package racingcar.common.parser;

import java.util.Arrays;
import java.util.List;

public class InputParser {

  public static List<String> parseCarNames(String input) {
    return Arrays.stream(input.split(","))
        .map(String::trim)
        .toList();
  }

  public static int parseNumber(String input) {
    try {
      return Integer.parseInt(input);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("올바른 숫자를 입력해야 합니다.");
    }
  }
}