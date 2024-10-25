package racingcar;

import racingcar.view.InputView;
import racingcar.view.OutPutView;

public class Application {

  public static void main(String[] args) {
    // TODO: 프로그램 구현
    OutPutView.printCarNamePrompt();
    String input = InputView.getCarNames();

  }
}
