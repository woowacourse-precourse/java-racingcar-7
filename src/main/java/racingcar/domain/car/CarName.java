package racingcar.domain.car;

import racingcar.error.ErrorMessages;
import racingcar.domain.Constants;

public record CarName(String value) {

  public CarName {
    validateNotNull(value);
    validateNotEmpty(value);
    validateMaxLength(value);
  }

  private void validateNotNull(String name) {
    if (name == null) {
      throw new IllegalArgumentException(ErrorMessages.CAR_NAMES_NULL.getMessage());
    }
  }

  private void validateNotEmpty(String name) {
    if (name.isEmpty()) {
      throw new IllegalArgumentException(ErrorMessages.CAR_NAME_EMPTY.getMessage());
    }
  }

  private void validateMaxLength(String name) {
    if (name.length() > Constants.MAX_CAR_NAME_LENGTH) {
      throw new IllegalArgumentException(ErrorMessages.CAR_NAME_TOO_LONG.getMessage());
    }
  }
}
