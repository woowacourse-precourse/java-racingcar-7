package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.GameRule;
import racingcar.domain.RacingGame;
import racingcar.domain.RandomRule;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    public void run() {
        List<Car> carList = new ArrayList<>();
        List<String> winners = new ArrayList<>();
        GameRule gameRule = new RandomRule();

        List<String> carNames = InputView.getCarNames();
        int tryNum = InputView.getTryNum();

        for (String carName : carNames) {
            Car car = new Car(carName,0);
            carList.add(car);
        }
        Cars cars = new Cars(carList);
        RacingGame racingGame = new RacingGame(cars);

        OutputView.printExecutionResult();
        for (int i = 0; i < tryNum; i++) {
            racingGame.game(gameRule);
            OutputView.printMidResult(cars);
        }

        winners = cars.findWinner();
        OutputView.printResult(winners);
    }
}
