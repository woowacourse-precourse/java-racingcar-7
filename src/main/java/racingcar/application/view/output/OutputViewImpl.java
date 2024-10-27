package racingcar.application.view.output;

public class OutputViewImpl implements OutputView {

  private static final String CAR_NAME_INPUT_PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
  private static final String ATTEMPT_COUNT_INPUT_PROMPT = "시도할 횟수는 몇 회인가요?";

  @Override
  public void printCarNamesInputPrompt() {
    System.out.println(CAR_NAME_INPUT_PROMPT);
  }

  @Override
  public void printAttemptCountInputPrompt() {
    System.out.println(ATTEMPT_COUNT_INPUT_PROMPT);
  }
}
