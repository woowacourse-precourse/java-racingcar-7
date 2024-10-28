package racingcar.common.validator;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class InputValidator {

  public static void validateCarNames(List<String> carNames) {
    if (carNames == null) {
      throw new IllegalArgumentException("자동차 이름은 빈 문자열이 올 수 없습니다.");
    }

    if (carNames.stream().anyMatch(String::isBlank)) {
      throw new IllegalArgumentException("자동차 이름에 빈 문자열이나 공백만 포함된 이름이 올 수 없습니다.");
    }

    validateUniqueNames(carNames);
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

  private static void validateUniqueNames(List<String> carNames) {
    Set<String> uniqueNames = carNames.stream().map(String::toLowerCase)
        .collect(Collectors.toSet());
    if (uniqueNames.size() < carNames.size()) {
      throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
    }
  }
}
