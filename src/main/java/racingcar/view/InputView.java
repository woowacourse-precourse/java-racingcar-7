package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import racingcar.view.enums.Constants;

public class InputView {

  public static String[] inputCarNames() {
    System.out.println(Constants.START_MESSAGE.getMessage());
    String input = Console.readLine();
    return Arrays.stream(input.split(","))
        .map(String::trim) // 이름 사이 공백 제거
        .toArray(String[]::new);
  }

  public static int inputTrialCount() {
    System.out.println(Constants.GET_TRIAL_MESSAGE.getMessage());
    return Integer.parseInt(Console.readLine());
  }
}
