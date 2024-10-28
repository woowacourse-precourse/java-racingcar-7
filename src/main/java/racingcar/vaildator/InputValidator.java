package racingcar.vaildator;

public class InputValidator {
  static public void validateInputCarName(final String inputCarName) {
    checkNull(inputCarName);
    checkEmpty(inputCarName);
    checkBlank(inputCarName);
    checkCarNamesContent(inputCarName);
  }

  static public void validateInputNumAttempt(String inputNumAttempt) {
    checkNull(inputNumAttempt);
    checkEmpty(inputNumAttempt);
    checkBlank(inputNumAttempt);
    checkNumeric(inputNumAttempt);
  }

  static private void checkNull(final String inputCarNames) {
    if (inputCarNames == null) {
      throw new IllegalArgumentException("null은 인식 할 수 없습니다");
    }
  }

  static private void checkEmpty(final String inputCarNames) {
    if (inputCarNames.isEmpty()) {
      throw new IllegalArgumentException("빈 문자열입니다. ");
    }
  }

  static private void checkBlank(final String inputCarNames) {
    if (inputCarNames.isBlank()) {
      throw new IllegalArgumentException("공백은 입력 할 수 없습니다.\n" + inputCarNames);
    }
  }

  static void checkNumeric(final String input) {
    String regex = "^[0-9]+$";

    if (!input.matches(regex)) {
      throw new IllegalArgumentException("문자열은 0~9 숫자로만 이루어져야 합니다: " + input);
    }
  }

  static private void checkCarNamesContent(final String inputCarNames) {
    String regex = "^[a-zA-Z,]+$";

    if (!inputCarNames.matches(regex)) {
      throw new IllegalArgumentException("자동차 이름은 영어 알파벳과 쉼표(,)로만 이루어져야 합니다.\n" + inputCarNames);
    }
  }
}
