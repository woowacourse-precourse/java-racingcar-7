package racingcar.view;

import racingcar.model.Cars;
import racingcar.model.RacingGame;

public class OutputView {
    public void printDarDistance(RacingGame racingGame) {
        racingGame.startGame();
    }

    public void printWinner(Cars cars) {
        System.out.println("최종 우승자 : " + cars.getWinner());
    }
}
