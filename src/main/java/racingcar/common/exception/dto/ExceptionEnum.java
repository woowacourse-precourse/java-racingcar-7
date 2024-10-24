package racingcar.common.exception.dto;

import java.util.function.Function;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 23.
 */
public enum ExceptionEnum {
  RUTIME_ERROR("런타임 오류가 발생 했습니다.");

  private final String message;

  ExceptionEnum(String message) {
    this.message = message;
  }
  
  public String getMessage(){
    return this.message;
  }
}
