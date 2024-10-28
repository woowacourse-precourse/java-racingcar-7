package racingcar.view.input.exception;

import racingcar.common.exception.GlobalException;
import racingcar.common.exception.dto.ExceptionEnum;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 25.
 */
public class InputException extends GlobalException {

  public InputException(ExceptionEnum exceptionEnum) {
    super(exceptionEnum);
  }
}
