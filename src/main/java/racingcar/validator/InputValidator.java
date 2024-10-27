package racingcar.validator;

import racingcar.constants.ErrorMessage;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {
  private void validateNotEmpty(String input) {
    if (input.isEmpty()) {
      throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT);
    }
  }
  private void validateNoSpaces(String carNameInput) {
    if (carNameInput.contains(" ")) {
      throw new IllegalArgumentException(ErrorMessage.CONTAINS_SPACE);
    }
  }
  private void validateDelimiter(String carNameInput) {
    if (!carNameInput.matches("[a-zA-Z0-9,]+")) {
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
    validateNoSpaces(attemptsInput);
  }
  public void validateEachCarName(String[] carNames) {
    Set<String> uniqueNames = new HashSet<>();

    for (String name : carNames) {
      if (name.isEmpty()) {
        throw new IllegalArgumentException(ErrorMessage.EMPTY_CAR_NAME);
      }
      if (name.contains(" ")) {
        throw new IllegalArgumentException(ErrorMessage.SPACE_CAR_NAME);
      }
      if (name.length() > 5) {
        throw new IllegalArgumentException(ErrorMessage.LONG_CAR_NAME);
      }
      if (!uniqueNames.add(name)) {
        throw new IllegalArgumentException(ErrorMessage.DUPLICATE_CAR_NAME);
      }
    }
  }
  private void validatePositiveNumber(String attemptsInput) {
    if (!attemptsInput.matches("([1-9]\\d*|\\+\\d+)")) {
      throw new IllegalArgumentException(ErrorMessage.POSITIVE_NUMBER);
    }
  }
  public void validateAttemptCount(String attemptsInput) {
    validatePositiveNumber(attemptsInput);
  }
}
