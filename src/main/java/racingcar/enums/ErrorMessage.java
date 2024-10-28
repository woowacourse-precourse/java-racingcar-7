package racingcar.enums;

public enum ErrorMessage implements SystemMessage {
  INVALID_DUPLICATE_CAR_NAME("중복된 자동차 이름 있습니다."),
  INVALID_CAR_NAME_EMPTY("비어있는 자동차 이름이 존재합니다."),
  INVALID_CAR_NAME_LENGTH("자동차 이름은 5자 이하만 가능합니다."),
  INVALID_CAR_NAME_NUMERIC_ONLY("자동차 이름이 숫자로만 구성될 수 없습니다."),
  INVALID_CAR_NAME_INCLUDE_SPECIAL_CHAR("자동차 이름에 특수문자가 포함될 수 없습니다."),
  INVALID_CAR_NUMBER("경기에 최소 2대 자동차가 참여할 수 있습니다."),
  INVALID_TURN_NUMBER("자연수가 아닌 숫자입니다."),
  INVALID_INT_NUMBER("숫자가 아닌 것이 입력 되었습니다.");

  private final String ERROR_LOG_LEVEL = "[ERROR] ";
  private final String message;

  ErrorMessage(String message) {
    this.message = message;
  }

  @Override
  public String getMessage() {
    return ERROR_LOG_LEVEL + message;
  }
}
