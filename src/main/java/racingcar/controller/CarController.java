package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.CarRacingProgress;
import racingcar.model.Cars;
import racingcar.model.Winner;
import racingcar.strategy.RandomMoveStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

/**
 * 전체적인 진행을 맡는 클래스
 * View와 메시지를 주고 받는다.
 */
public class CarController {

    private final InputView inputView;

    private final OutputView outputView;

    public CarController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        String carNames = inputView.getCarNames();
        int chanceToMove = inputView.getChanceToMove();
        Cars cars = Cars.getOfNamesAndStrategy(carNames, new RandomMoveStrategy());
        raceCarsAndTimes(cars, chanceToMove);
        Winner winner = Winner.getFromCars(cars);
        outputView.printRaceResult(winner);
    }

    private void raceCarsAndTimes(Cars cars, int chanceToMove) {
        outputView.printStartRace();
        for (int i = 0; i < chanceToMove; i++) {
            for (Car car : cars) {
                car.moveOrNot();
                CarRacingProgress progress = new CarRacingProgress(car);
                outputView.printProgress(progress);
            }
            outputView.printLineBreaking();
        }
    }
}
