package racingcar.domain;

import racingcar.error.ErrorMessages;

public class GameCount {

  private static final int MIN_COUNT = 1;
  private int count;

  public GameCount(String input) {
    this.count = validateAndParse(input);
  }

  private int validateAndParse(String input) {
    if (input == null) {
      throw new IllegalArgumentException(ErrorMessages.INPUT_NULL);
    }
    if (input.trim().isEmpty()) {
      throw new IllegalArgumentException(ErrorMessages.GAME_COUNT_EMPTY);
    }

    try {
      int parsedValue = Integer.parseInt(input);
      if (parsedValue < MIN_COUNT) {
        throw new IllegalArgumentException(ErrorMessages.GAME_COUNT_INVALID);
      }
      return parsedValue;
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException(ErrorMessages.GAME_COUNT_FORMAT_ERROR);
    }
  }

  public boolean canPlay() {
    return count > 0;
  }

  public void decrement() {
    count--;
  }
}
