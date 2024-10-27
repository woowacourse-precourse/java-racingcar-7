package racingcar.error;

public enum ErrorMessages {
  CAR_NAME_EMPTY("Error: 자동차 이름은 비어있을 수 없습니다."),
  CAR_NAME_TOO_LONG("Error: 자동차 이름은 5자 이하로 입력해야 합니다."),
  CAR_NAME_DUPLICATE("Error: 중복된 자동차 이름은 허용되지 않습니다."),
  INPUT_EMPTY("Error: 입력값은 비어있을 수 없습니다."),
  GAME_COUNT_INVALID("Error: 시도 횟수는 1 이상의 값이어야 합니다."),
  GAME_COUNT_FORMAT_ERROR("Error: 시도 횟수는 정수여야 합니다.");

  private final Message message;

  ErrorMessages(String message) {
    this.message = new Message(message);
  }

  public String getMessage() {
    return this.message.value();
  }
}
