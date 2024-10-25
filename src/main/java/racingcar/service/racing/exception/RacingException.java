package racingcar.service.racing.exception;

import racingcar.common.exception.GlobalException;
import racingcar.common.exception.dto.ExceptionEnum;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 26.
 */
public class RacingException extends GlobalException {

  public RacingException(ExceptionEnum exceptionEnum) {
    super(exceptionEnum);
  }

  public RacingException(ExceptionEnum exceptionEnum, String runtimeMessage){
    super(exceptionEnum, runtimeMessage);
  }
}
