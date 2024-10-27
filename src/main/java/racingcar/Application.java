package racingcar;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.game.RacingGame;
import racingcar.exception.ExceptionHandler;
import racingcar.view.InputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            List<String> carList = InputView.inputCarList();
            Integer tryRounds = InputView.inputTryRounds();

            RacingGame racingGame = new RacingGame(carList, tryRounds);
            racingGame.run();
        } catch (IllegalArgumentException e) {
            ExceptionHandler.handleIllegalArgumentExeption(e);
        }

    }
}
