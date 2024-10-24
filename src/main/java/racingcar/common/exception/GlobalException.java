package racingcar.common.exception;

import racingcar.common.exception.dto.ExceptionEnum;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 23.
 */
public class GlobalException extends IllegalArgumentException {

  public GlobalException (ExceptionEnum exceptionEnum)  {
    this(exceptionEnum, "런타임 메시지가 없습니다.");
  }

  public GlobalException (ExceptionEnum exceptionEnum, String runtimeMessage) {
    super(exceptionEnum.getMessage() + " : " + runtimeMessage);
  }
}
