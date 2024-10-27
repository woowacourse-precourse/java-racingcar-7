package racingcar.domain;

import racingcar.error.ErrorMessages;
import racingcar.util.Constants;

public class GameCount {

  private int count;

  public GameCount(String gameCountInput) {
    validateInput(gameCountInput);
    this.count = parseGameCount(gameCountInput);
  }

  private void validateInput(String input) {
    if (input == null || input.isEmpty()) {
      throw new IllegalArgumentException(ErrorMessages.INPUT_EMPTY.getMessage());
    }
  }

  private int parseGameCount(String input) {
    try {
      int gameCount = Integer.parseInt(input);
      if (gameCount < Constants.MIN_GAME_COUNT) {
        throw new IllegalArgumentException(ErrorMessages.GAME_COUNT_INVALID.getMessage());
      }
      return gameCount;
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException(ErrorMessages.GAME_COUNT_FORMAT_ERROR.getMessage());
    }
  }

  public void decrement() {
    this.count--;
  }

  public boolean canPlay() {
    return this.count > Constants.CAN_NOT_PLAY_COUNT;
  }
}
