package racingcar.enums;

public enum IOMessage implements SystemMessage {
  INPUT_CARS_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
  INPUT_TURN_COUNT("시도할 횟수는 몇 회인가요?"),
  PRINT_GAME_RESULT("실행 결과"),
  PRINT_GAME_WINNER("최종 우승자 : ");

  private final String message;

  IOMessage(String message) {
    this.message = message;
  }

  @Override
  public String getMessage() {
    return message;
  }
}
