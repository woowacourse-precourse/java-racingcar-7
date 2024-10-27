package racingcar.application;

import racingcar.application.view.input.InputView;
import racingcar.application.view.input.InputViewImpl;
import racingcar.application.view.output.OutputView;
import racingcar.application.view.output.OutputViewImpl;

public class RacingCarApplication {

  public void run() {
    InputView inputView = new InputViewImpl();
    OutputView outputView = new OutputViewImpl();

    outputView.printCarNamesInputPrompt();
    inputView.readInputCarNames();
    outputView.printAttemptCountInputPrompt();
    inputView.readInputAttemptCount();
  }
}
