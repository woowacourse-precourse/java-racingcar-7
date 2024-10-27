package racingcar.view;


import camp.nextstep.edu.missionutils.Console;

public class InputView {

  public String getCarNames() {
    System.out.println(GameMessages.CAR_NAME_PROMPT);
    return Console.readLine();
  }

  public String getGameCount() {
    System.out.println(GameMessages.GAME_COUNT_PROMPT);
    return Console.readLine();
  }
}
