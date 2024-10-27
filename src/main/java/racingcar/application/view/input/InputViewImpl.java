package racingcar.application.view.input;

import camp.nextstep.edu.missionutils.Console;
import static racingcar.application.view.validation.InputValidation.*;

public class InputViewImpl implements InputView {

  @Override
  public String readInputCarNames() {

    String inputCarNames = Console.readLine();
    validateInputCarNames(inputCarNames);

    return inputCarNames;
  }

  @Override
  public int readInputAttemptCount() {
    return 0;
  }
}
