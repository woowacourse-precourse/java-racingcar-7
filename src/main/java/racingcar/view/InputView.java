package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.Constants;

public class InputView {

  public String getCarNames() {
    System.out.println(Constants.CAR_NAME_PROMPT);
    return Console.readLine();
  }

  public String getGameCount() {
    System.out.println(Constants.GAME_COUNT_PROMPT);
    return Console.readLine();
  }
}
