package racingcar;

import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

  public static void main(String[] args) {
    // TODO: 프로그램 구현
    OutputView.printCarNamePrompt();
    String input = InputView.getCarNames();

    Cars cars = new Cars(input);
    OutputView.printGameCountPrompt();
    String gameCount = InputView.getTryCount();

  }
}
