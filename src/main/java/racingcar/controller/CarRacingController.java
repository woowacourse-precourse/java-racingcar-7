package racingcar.controller;

import racingcar.model.*;
import racingcar.strategy.RandomMoveStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

/**
 * 전체적인 진행을 맡는 클래스
 * View와 메시지를 주고 받는다.
 */
public class CarRacingController {

    private final InputView inputView;

    private final OutputView outputView;

    public CarRacingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        CarNames carNames = CarNames.getAfterValidateForm(inputView.getCarNames());
        RacingChance racingChance =
                RacingChance.getAfterValidateForm(inputView.getChanceToMove());
        Cars cars = Cars.getOfNamesAndStrategy(carNames, new RandomMoveStrategy());
        raceOfCarsAndChance(cars, racingChance);
        Winner winner = Winner.getFromCars(cars);
        outputView.printRaceResult(winner);
    }

    private void raceOfCarsAndChance(Cars cars, RacingChance chanceToRace) {
        outputView.printStartRace();
        for (int i = 0; i < chanceToRace.get(); i++) {
            for (Car car : cars) {
                car.moveOrNot();
                CarRacingProgress progress = new CarRacingProgress(car);
                outputView.printProgress(progress);
            }
            outputView.printLineBreaking();
        }
    }
}
