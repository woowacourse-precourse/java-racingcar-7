package racingcar.application.view.output;

import java.util.List;
import racingcar.application.model.Car;

public class OutputViewImpl implements OutputView {

  private static final String CAR_NAME_INPUT_PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
  private static final String ATTEMPT_COUNT_INPUT_PROMPT = "시도할 횟수는 몇 회인가요?";
  private static final String RACE_RESULT_MESSAGE = "실행 결과";
  private static final String FINAL_WINNER_MESSAGE = "최종 우승자";

  @Override
  public void printCarNamesInputPrompt() {
    System.out.println(CAR_NAME_INPUT_PROMPT);
  }

  @Override
  public void printAttemptCountInputPrompt() {
    System.out.println(ATTEMPT_COUNT_INPUT_PROMPT);
  }

  @Override
  public void printStartMessage() {
    System.out.println(RACE_RESULT_MESSAGE);
  }

  @Override
  public void printRaceState(List<Car> cars) {

    for (Car car : cars) {
      System.out.print(car.getName() + " : ");
      System.out.println("-".repeat(car.getForward()));
    }
    System.out.println();
  }

  @Override
  public void printEmptyLine() {
    System.out.println();
  }
}
