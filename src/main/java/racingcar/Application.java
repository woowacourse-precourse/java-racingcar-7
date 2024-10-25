package racingcar;

import racingcar.domain.Cars;
import racingcar.domain.Game;
import racingcar.domain.GameCount;
import racingcar.domain.RandomMoveCondition;
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
    GameCount count = new GameCount(gameCount);

    Game game = new Game(cars, new RandomMoveCondition());
    for (int i = 0; i < count.getCount(); i++) {
      game.playRound();
    }
  }
}
