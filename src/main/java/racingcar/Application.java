package racingcar;

import racingcar.domain.stadium.Stadium;
import racingcar.view.InputView;


public class Application {
  public static void main(String[] args) {
    Stadium stadium = new Stadium();

    String[] names = InputView.inputCarName();
   int numAttempt = InputView.inputNumAttempt();

    stadium.addCars(names);
    stadium.startGame(numAttempt);

  }

}
