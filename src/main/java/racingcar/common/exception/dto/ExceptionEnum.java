package racingcar.common.exception.dto;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 23.
 */
public enum ExceptionEnum {
  RUTIME_ERROR("런타임 오류가 발생 했습니다."),

  //InputView
  INVALID_CARNAME("자동차 이름은 null이거나 빈 문자열일 수 없습니다."),
  INVALID_ROUND_COUNT("시도할 횟수는 null이거나 빈 문자열일 수 없습니다."),
  ROUND_COUNT_NEGATIVE_NUMBER_NOT_AVAILABLE("시도할 횟수는 음수일 수 없습니다."),
  ROUND_COUNT_DECIMAL_NUMBER_NOT_AVAILABLE("시도할 횟수는 소수일 수 없습니다."),

  INVALID_INPUT("유효하지 않은 입력 입니다.");

  private final String message;

  ExceptionEnum(String message) {
    this.message = message;
  }
  
  public String getMessage(){
    return this.message;
  }
}
