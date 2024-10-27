package racingcar.common.io;

import camp.nextstep.edu.missionutils.Console;
import racingcar.common.validator.InputValidator;

public class Input {

  Output output = new Output();

  public String[] getCarNames() {
    output.printMessage("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    String input = Console.readLine().trim();
    InputValidator.validateAndParseCarNames(input);

    return InputValidator.validateAndParseCarNames(input);
  }

  public int getAttempts() {
    output.printMessage("시도할 횟수는 몇 회인가요?");
    String input = Console.readLine().trim();

    int attempts = InputValidator.parseAndValidateNumber(input);
    InputValidator.validateAttempts(attempts);

    return attempts;
  }
}
