package racingcar.domain.game;

import racingcar.domain.Constants;
import racingcar.error.ErrorMessages;

public class Count {

  private int value;

  public Count(String input) {
    this.value = parseAndValidate(input);
  }

  private int parseAndValidate(String input) {
    int parsedValue = convertToInt(input);
    validateValue(parsedValue);
    return parsedValue;
  }

  private int convertToInt(String input) {
    try {
      return Integer.parseInt(input.trim());
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException(ErrorMessages.GAME_COUNT_FORMAT_ERROR.getMessage());
    }
  }

  private void validateValue(int value) {
    if (value < Constants.MIN_GAME_COUNT) {
      throw new IllegalArgumentException(ErrorMessages.GAME_COUNT_INVALID.getMessage());
    }
  }

  public void decrement() {
    value--;
  }

  public boolean canPlay() {
    return value > Constants.CAN_NOT_PLAY_COUNT;
  }
}
