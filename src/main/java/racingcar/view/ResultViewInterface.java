package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public interface ResultViewInterface {

  void printRoundResult(List<Car> cars);

  void printWinners(List<Car> winners);
}
