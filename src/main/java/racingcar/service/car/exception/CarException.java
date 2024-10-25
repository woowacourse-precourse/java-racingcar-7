package racingcar.service.car.exception;

import racingcar.common.exception.GlobalException;
import racingcar.common.exception.dto.ExceptionEnum;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 25.
 */
public class CarException extends GlobalException {

  public CarException(ExceptionEnum exceptionEnum) {
    super(exceptionEnum);
  }
}
