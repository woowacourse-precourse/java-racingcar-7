package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

  public static String[] inputCarNames() {
    System.out.println(START_MESSAGE);
    String input =Console.readLine();;
    return input.split(",");
  }

  public static int inputTrialCount() {
    System.out.println(GET_TRIAL_MESSAGE);
    return Integer.parseInt(Console.readLine());
  }
}
