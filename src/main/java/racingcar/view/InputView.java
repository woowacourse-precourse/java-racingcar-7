package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.view.enums.Constants;

public class InputView {

  public static String[] inputCarNames() {
    System.out.println(Constants.START_MESSAGE.getMessage());
    String input =Console.readLine();
    return input.split(",");
  }

  public static int inputTrialCount() {
    System.out.println(Constants.GET_TRIAL_MESSAGE.getMessage());
    return Integer.parseInt(Console.readLine());
  }
}
