package racingcar.validator;

import racingcar.constants.ErrorMessage;

public class InitialInputValidator {
  private void validateNotEmpty(String input) {
    if (input == null || input.isEmpty()) {
      throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT);
    }
  }
  private void validateNoSpaces(String carNameInput) {
    if (carNameInput.contains(" ")) {
      throw new IllegalArgumentException(ErrorMessage.CONTAINS_SPACE);
    }
  }
  private void validateDelimiter(String carNameInput) {
    if (!carNameInput.matches("[a-zA-Z,]+")) {
      throw new IllegalArgumentException(ErrorMessage.INVALID_DELIMITER);
    }
  }
  private void validateNotOnlyCommas(String carNameInput) {
    if (carNameInput.matches("^,+$")) {
      throw new IllegalArgumentException(ErrorMessage.ONLY_COMMAS);
    }
  }
  public void validateCarNameInput(String carNameInput) {
    validateNotEmpty(carNameInput);
    validateNoSpaces(carNameInput);
    validateDelimiter(carNameInput);
    validateNotOnlyCommas(carNameInput);
  }
  public void validateAttemptsInput(String attemptsInput) {
    validateNotEmpty(attemptsInput);
  }
}
