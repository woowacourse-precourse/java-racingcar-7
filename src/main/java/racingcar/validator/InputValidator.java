package racingcar.validator;

import racingcar.constants.ErrorMessage;

public class InputValidator {
  private void validateNotNull(String input) {
    if (input == null) {
      throw new IllegalArgumentException(ErrorMessage.NULL);
    }
  }
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
    validateNotNull(carNameInput);
    String trimmedCarNameInput = carNameInput.trim();
    validateNotEmpty(trimmedCarNameInput);
    validateNoSpaces(trimmedCarNameInput);
    validateDelimiter(trimmedCarNameInput);
    validateNotOnlyCommas(trimmedCarNameInput);
  }
  public void validateAttemptsInput(String attemptsInput) {
    validateNotNull(attemptsInput);
    String trimmedAttemptsInput = attemptsInput.trim();
    validateNotEmpty(trimmedAttemptsInput);
    validateNoSpaces(trimmedAttemptsInput);
  }
}
