package racingcar.domain.car;

import racingcar.error.ErrorMessages;
import racingcar.domain.Constants;

public record CarName(String value) {

  public CarName {
    validateName(value);
  }

  private void validateName(String name) {
    if (name == null || name.isEmpty()) {
      throw new IllegalArgumentException(ErrorMessages.CAR_NAME_EMPTY.getMessage());
    }
    if (name.length() > Constants.MAX_CAR_NAME_LENGTH) {
      throw new IllegalArgumentException(ErrorMessages.CAR_NAME_TOO_LONG.getMessage());
    }
  }
}
