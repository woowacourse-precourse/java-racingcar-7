package racingcar.common.validator;

import java.util.Arrays;

public class InputValidator {

  public static String[] validateAndParseCarNames(String input) {
    if (input == null || input.isEmpty()) {
      throw new IllegalArgumentException("자동차 이름은 빈 문자열이 올 수 없습니다.");
    }

    if (!input.contains(",")) {
      throw new IllegalArgumentException("자동차 이름은 쉼표(,)로만 구분해야 합니다.");
    }

    String[] carNames = input.split(",");
    Arrays.stream(carNames).forEach(InputValidator::validateCarName);
    return carNames;
  }

  private static void validateCarName(String name) {
    String trimmedName = name.trim(); // 공백 제거
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
