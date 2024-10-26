package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

  private InputView() {
  }

  public static String getCarNames() {
    return Console.readLine();
  }

  public static String getTryCount() {
    return Console.readLine();
  }
}
