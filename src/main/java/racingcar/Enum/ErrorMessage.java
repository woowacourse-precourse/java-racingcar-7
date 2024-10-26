package racingcar.Enum;

public enum ErrorMessage implements SystemMessage {
  INVALID_CAR_NAME("유효하지 않은 자동차 이름이 포함되어 있습니다."),
  INVALID_CAR_NUMBER("경기에 최소 2대 자동차가 참여할 수 있습니다."),
  INVALID_TURN_NUMBER("자연수가 아닌 숫자입니다.");

  private final String message;

  ErrorMessage(String message) {
    this.message = message;
  }

  @Override
  public String getMessage() {
    return "[ERROR] " + message;
  }
}
