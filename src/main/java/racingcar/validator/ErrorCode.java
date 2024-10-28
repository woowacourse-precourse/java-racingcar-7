package racingcar.validator;

public enum ErrorCode {

  CAR_NAME_TOO_LONG("자동차 이름은 5글자 이하여야 합니다."),
  CAR_NAME_CANNOT_BE_EMPTY("자동차 이름은 공백이 될 수 없습니다."),
  CAR_NAME_DUPLICATE("자동차 이름은 중복될 수 없습니다."),
  ;

  private final String message;

  ErrorCode(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
