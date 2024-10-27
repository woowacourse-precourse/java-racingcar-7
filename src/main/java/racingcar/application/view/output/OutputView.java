package racingcar.application.view.output;

import java.util.List;
import racingcar.application.model.Car;

public interface OutputView {

  void printCarNamesInputPrompt();

  void printAttemptCountInputPrompt();

  void printStartMessage();

  void printRaceState(List<Car> cars);

  void printEmptyLine();
}
