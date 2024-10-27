package racingcar.utilities;

import racingcar.enums.ErrorMessage;

public class NumberParser {
  public static int parseToInt(String value) {
    try {
      return Integer.parseInt(value);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException(ErrorMessage.INVALID_TURN_NUMBER.getMessage());
    }
  }
}
