package racingcar.common.validator;

import java.util.Arrays;
import java.util.List;

public class InputValidator {

  public static List<String> validateAndParseCarNames(String input) {
    if (input == null || input.isEmpty()) {
      throw new IllegalArgumentException("자동차 이름은 빈 문자열이 올 수 없습니다.");
    }

    return Arrays.stream(input.split(","))
        .map(String::trim)
        .map(name -> {
          validateCarName(name);
          return name;
        })
        .toList();
  }

  private static void validateCarName(String name) {
    String trimmedName = name.trim();
    if (trimmedName.length() > 5) {
      throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하여야 합니다.");
    }
  }

  public static void validateAttempts(int attempts) {
    if (attempts <= 0) {
      throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
    }
  }

  public static int parseAndValidateNumber(String input) {
    try {
      return Integer.parseInt(input);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("올바른 숫자를 입력해야 합니다.");
    }
  }
}
