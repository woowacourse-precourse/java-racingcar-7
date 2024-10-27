package racingcar.validation;

import racingcar.enums.ErrorMessage;
import racingcar.utilities.NumberParser;

public class TurnCountValidator {
  public static int validateTurnCount(String turnCount) {
    int intTurnCount = NumberParser.parseToInt(turnCount);
    if (intTurnCount < 1) {
      throw new IllegalArgumentException(ErrorMessage.INVALID_INT_NUMBER.getMessage());
    }
    return intTurnCount;
  }
}
