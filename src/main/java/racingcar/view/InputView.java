package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constants.ErrorMessage;

public class InputView {
  public static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
  public static final String ATTEMPTS_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?";

  private String readLine() {
    String input = Console.readLine();
    if (input == null) {
      throw new IllegalArgumentException(ErrorMessage.NULL);
    }
    return input.trim();
  }

  public String askForCarName() {
    System.out.println(CAR_NAME_INPUT_MESSAGE);
    return readLine();
  }

  public String askForAttempts() {
    System.out.println(ATTEMPTS_INPUT_MESSAGE);
    return readLine();
  }
}
