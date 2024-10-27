package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.enums.IOMessage;

public class InputView {
  public static String readCarsName() {
    System.out.println(IOMessage.INPUT_CARS_NAME.getMessage());
    String inputCarNames = Console.readLine();
    return inputCarNames;
  }

  public static String readTurnCount() {
    System.out.println(IOMessage.INPUT_TURN_COUNT.getMessage());
    String inputTurnCount = Console.readLine();
    return inputTurnCount;
  }
}
