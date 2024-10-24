package racingcar.view;

import static racingcar.view.Constants.ENTER_MESSAGE;
import static racingcar.view.Constants.FINAL_RESULT_MESSAGE;
import static racingcar.view.Constants.INTERMEDIATE_RESULT_MESSAGE;

import java.util.List;
import racingcar.model.Car;
import racingcar.view.Constants;

public class ResultView {

  public static void printRoundResult(List<Car> cars) {
    System.out.println(ENTER_MESSAGE);
    for (Car car : cars) {
      printCarResult(car);
    }
  }

  private static void printCarResult(Car car) {
    System.out.printf(INTERMEDIATE_RESULT_MESSAGE, car.getName());
    for (int i = 0; i < car.getPosition(); i++) {
      System.out.print("-");
    }
    System.out.println();
  }

  public static void printWinners(List<Car> winners) {
    if (winners.size() == 1) {
      System.out.println(FINAL_RESULT_MESSAGE + winners.get(0).getName());
    } else {
      String winnerNames = String.join(", ", winners.stream().map(Car::getName).toArray(String[]::new));
      System.out.println(FINAL_RESULT_MESSAGE + winnerNames);
    }
  }
}

