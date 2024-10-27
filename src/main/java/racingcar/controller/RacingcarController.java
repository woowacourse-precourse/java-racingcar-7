package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingcarController {
    private List<Car> cars = new ArrayList<>();
    private static final int MOVE_THRESHOLD = 4;

    public void playGame() {
        String carNames = InputView.inputCarNames();
        cars = Car.createCarsFromNames(carNames);
        int attemptCount = InputView.inputAttemptCount();

        for (int i = 0; i < attemptCount; i++) {
            raceCars();
            OutputView.displayCurrentPositions(cars);
        }
        OutputView.announceWinners(cars);
    }

    private void raceCars() {
        for (Car car : cars) {
            if (shouldMoveForward()) {
                car.moveForward();
            }
        }
    }

    private boolean shouldMoveForward() {
        return Randoms.pickNumberInRange(0, 9) >= MOVE_THRESHOLD;
    }
}