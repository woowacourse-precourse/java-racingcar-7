package racingcar.view.enums;

public enum Constants {
  START_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
  GET_TRIAL_MESSAGE("시도할 횟수는 몇 회인가요?"),
  ENTER_MESSAGE("\n"),
  INTERMEDIATE_RESULT_MESSAGE("%s : "),
  FINAL_RESULT_MESSAGE("최종 우승자 : ");

  private final String message;

  Constants(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
