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
  INVALID_WHITESPACE("입력에 공백은 허용되지 않습니다."),
  ROUND_COUNT_NEGATIVE_NUMBER_NOT_AVAILABLE("시도할 횟수는 음수일 수 없습니다."),
  ROUND_COUNT_DECIMAL_NUMBER_NOT_AVAILABLE("시도할 횟수는 소수일 수 없습니다."),
  ROUND_COUNT_OUT_OF_INTEGER_RANGE("시도할 횟수가 Integer의 범위를 벗어납니다"),

  //CarStrategy
  CAR_NAME_LONGGER_THAN_FIVE("자동차 이름은 5자 이하만 가능 합니다."),
  DUPLICATE_CAR_NAME("중복된 자동차 이름은 허용되지 않습니다."),

  INVALID_INPUT("유효하지 않은 입력 입니다.");



  private final String message;

  ExceptionEnum(String message) {
    this.message = message;
  }
  
  public String getMessage(){
    return this.message;
  }
}
