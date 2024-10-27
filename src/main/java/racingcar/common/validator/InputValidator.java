package racingcar.common.validator;

public class InputValidator {

  public static void validateCarNames(String[] names) {
    if (names.length == 0) {
      throw new IllegalArgumentException("자동차 이름은 비어 있을 수 없습니다.");
    }

    for (String name : names) {
      if (name.length() > 5) {
        throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
      }
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
