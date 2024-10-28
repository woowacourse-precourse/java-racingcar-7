package racingcar.common.validator;

import java.util.List;

public class InputValidator {

  public static void validateCarNames(List<String> carNames) {
    if (carNames == null || carNames.stream().allMatch(String::isEmpty)) {
      throw new IllegalArgumentException("자동차 이름은 빈 문자열이 올 수 없습니다.");
    }

    carNames.forEach(InputValidator::validateCarName);
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
}
