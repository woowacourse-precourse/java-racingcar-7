package racingcar.common.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.common.parser.InputParser;
import racingcar.common.validator.InputValidator;

public class Input {

  private final Output output = new Output();

  public List<String> getCarNames() {
    output.printMessage("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    String input = Console.readLine().trim();

    List<String> carNames = InputParser.parseCarNames(input);
    InputValidator.validateCarNames(carNames);

    return carNames;
  }

  public int getAttempts() {
    output.printMessage("시도할 횟수는 몇 회인가요?");
    String input = Console.readLine().trim();

    int attempts = InputParser.parseNumber(input);
    InputValidator.validateAttempts(attempts);

    return attempts;
  }
}
