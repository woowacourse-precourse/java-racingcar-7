package racingcar.view.input.dto;

import racingcar.common.exception.dto.ExceptionEnum;
import racingcar.view.input.exception.InputException;


/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 25.
 */
public record RacingRequest(
    String carNames,
    int roundCount
) {

  private static int validateRoundCount(String roundCount) {
    if (roundCount == null || roundCount.trim().isEmpty()){
      throw new InputException(ExceptionEnum.INVALID_ROUND_COUNT);
    }
    if (roundCount.contains(".")){
      throw new InputException(ExceptionEnum.ROUND_COUNT_DECIMAL_NUMBER_NOT_AVAILABLE);
    }
    try {
      int value = Integer.parseInt(roundCount);
      if (value <= 0){
        throw new InputException(ExceptionEnum.ROUND_COUNT_NEGATIVE_NUMBER_NOT_AVAILABLE);
      }
      return value;
    } catch (NumberFormatException e){
      throw new InputException(ExceptionEnum.ROUND_COUNT_OUT_OF_INTEGER_RANGE);
    }
  }

  private static void validateCarNames(String carNames) {
    if (carNames == null || carNames.trim().isEmpty()){
      throw new InputException(ExceptionEnum.INVALID_CARNAME);
    }
  }

  public static RacingRequest from(String carNames, String roundCount) {
    validateCarNames(carNames);
    int roundCountNumber = validateRoundCount(roundCount);
    return new RacingRequest(carNames, roundCountNumber);
  }
}
